
package cn.com.atnc.ioms.dao.basedata.tes.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesSlotDao;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.model.basedata.tes.TesSlotQueryModel;


@Repository("tesSlotDao")
public class TesSlotDaoImpl extends MyBaseDao<TesSlot> implements ITesSlotDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@Override
	public Pagination queryPage(TesSlotQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TesSlot where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();	
		

		if (StringUtils.hasText(queryModel.getTesNodeId())) {
			hql.append(" and tesNode.tesNodeId  =:tesNodeId");
			params.put("tesNodeId", queryModel.getTesNodeId());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by cast(cu as integer) asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(TesSlotQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TesSlot where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		if (StringUtils.hasText(queryModel.getTesNodeId())) {
			hql.append(" and tesNode.tesNodeId  =:tesNodeId");
			params.put("tesNodeId", queryModel.getTesNodeId());
		}
		return super.querySize(hql.toString(), params);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryList(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TesSlot> queryList(TesSlotQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from TesSlot where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		

		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}		
					
		if (StringUtils.hasText(queryModel.getTesNodeId())) {
			hql.append(" and tesNode.id  =:tesNodeId");
			params.put("tesNodeId",  queryModel.getTesNodeId());
		}		
		

        if (StringUtils.hasText(queryModel.getTesNodeCodeEq())) {
            hql.append(" and tesNode.tesNodeCode  =:tesNodeCode");
            params.put("tesNodeCode",  queryModel.getTesNodeCodeEq());
        }       
        
		/*if (StringTools.hasText(queryModel.getEquipId())) {
			hql.append(" and equip.id =:equipId");
			params.put("equipId", queryModel.getEquipId());
		}
		*/

        if(StringUtils.hasText(queryModel.getCuLike())){
            hql.append(" and cu like:culike");
            params.put("culike", queryModel.getCuLike()+"%");
        }
		if (StringUtils.hasText(queryModel.getCu())) {
			hql.append(" and cu  =:cu");
			params.put("cu",  queryModel.getCu());
		}	
		//hql.append(" order by cast(cu as integer) asc");	
		hql.append(" order by cast(cu as integer) asc");
		
		return (List<TesSlot>) super.queryList(hql.toString(), params);
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<TesSlot> queryListByTesNode(TesNode tesNode) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from TesSlot where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(tesNode.getId())) {
			hql.append(" and tesNode.id  =:tesNodeId");
			//hql.append(" and tesNodeId =:tesNodeId");
			params.put("tesNodeId",  tesNode.getId());
		}	
		//hql.append(" order by cast(cu as integer) asc");
		hql.append(" order by cast(cu as integer) asc");
		return (List<TesSlot>) super.queryList(hql.toString(), params);
	}

    @Override
	public TesSlot findByTesSlot(String code,String cu){
	    Session session = this.getSession();
	    try{
	        Query query = session.createQuery("from TesSlot where tesNode.tesNodeCode=? and cu=?");
	        query.setParameter(0,code);
	        query.setParameter(1, cu);
	        return (TesSlot) query.uniqueResult();
	    }catch (Exception e) {
	        e.printStackTrace();
        }finally{
            session.close();
        }
	    return null;
	}
}
