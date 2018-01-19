package cn.com.atnc.ioms.dao.basedata.tes.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTeleDao;
import cn.com.atnc.ioms.entity.basedata.tes.TesTele;
import cn.com.atnc.ioms.model.basedata.tes.TesTeleQueryModel;


@Repository("tesTeleDao")
public class TesTeleDaoImpl extends MyBaseDao<TesTele> implements ITesTeleDao {

	@Override
	public Pagination queryPage(TesTeleQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TesTele where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();	

		if (StringUtils.hasText(queryModel.getTesNodeCode())) {
			hql.append(" and tesNode.tesNodeCode  =:tesNodeCode");
			params.put("tesNodeCode", queryModel.getTesNodeCode());
		}
		if (StringUtils.hasText(queryModel.getTesNodeCodeLike())) {
			hql.append(" and tesNode.tesNodeCode  like:tesNodeCodeLike");
			params.put("tesNodeCodeLike","%"+queryModel.getTesNodeCodeLike().toUpperCase()+"%");
		}
		/*if (StringUtils.hasText(queryModel.getTesNodeId())) {
			hql.append(" and tesNode.tesNodeId  =:tesNodeId");
			params.put("tesNodeId", queryModel.getTesNodeId());
		}*/
	/*	if (StringUtils.hasText(queryModel.getTesNodeCodeLike())) {
			hql.append(" and tesNode.tesNodeCode  like:tesNodeCode");
			params.put("tesNodeCode", "%"+queryModel.getTesNodeCodeLike()+"%");
		}*/
					
		
		if (StringUtils.hasText(queryModel.getPhoneNum())) {
			hql.append(" and   phoneNum=:phoneNum");
			params.put("phoneNum", queryModel.getPhoneNum());
		}
		if (StringUtils.hasText(queryModel.getPhoneNumLike())) {
			hql.append(" and   phoneNum like:phoneNum");
			params.put("phoneNum","%"+ queryModel.getPhoneNumLike()+"%");
		}		
		if (StringUtils.hasText(queryModel.getCu())) {
			hql.append(" and   cu=:cu");
			params.put("cu", queryModel.getCu());
		}	
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by tesNode.equip.satellite.siteName,tesNode.tesNodeCode,cu asc");
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public Long querySize(TesTeleQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TesTele where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (StringUtils.hasText(queryModel.getTesNodeCode())) {
			hql.append(" and tesNode.tesNodeCode  =:tesNodeCode");
			params.put("tesNodeCode", queryModel.getTesNodeCode());
		}
		if (StringUtils.hasText(queryModel.getTesNodeCodeLike())) {
			hql.append(" and tesNode.tesNodeCode  like:tesNodeCodeLike");
			params.put("tesNodeCodeLike","%"+queryModel.getTesNodeCodeLike().toUpperCase()+"%");
		}
		/*if (StringUtils.hasText(queryModel.getTesNodeId())) {
			hql.append(" and tesNode.tesNodeId  =:tesNodeId");
			params.put("tesNodeId", queryModel.getTesNodeId());
		}*/
	/*	if (StringUtils.hasText(queryModel.getTesNodeCodeLike())) {
			hql.append(" and tesNode.tesNodeCode  like:tesNodeId");
			params.put("tesNodeId", "%"+queryModel.getTesNodeCodeLike()+"%");
		}*/
					
		
		if (StringUtils.hasText(queryModel.getPhoneNum())) {
			hql.append(" and   phoneNum=:phoneNum");
			params.put("phoneNum", queryModel.getPhoneNum());
		}
		if (StringUtils.hasText(queryModel.getPhoneNumLike())) {
			hql.append(" and   phoneNum like:phoneNum");
			params.put("phoneNum","%"+ queryModel.getPhoneNumLike()+"%");
		}		
		if (StringUtils.hasText(queryModel.getCu())) {
			hql.append(" and   cu=:cu");
			params.put("cu", queryModel.getCu());
		}	
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
				
		hql.append(" order by phoneNum asc");	
		return super.querySize(hql.toString(), params);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeDao#queryList(cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TesTele> queryList(TesTeleQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from TesTele where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		

		if (StringUtils.hasText(queryModel.getTesNodeCode())) {
			hql.append(" and tesNode.tesNodeCode  =:tesNodeCode");
			params.put("tesNodeCode", queryModel.getTesNodeCode());
		}
		if (StringUtils.hasText(queryModel.getTesNodeIdLike())) {
			hql.append(" and tesNode.id  =:tid");
			params.put("tid", queryModel.getTesNodeIdLike());
		}
		if (StringUtils.hasText(queryModel.getTesNodeCodeLike())) {
			hql.append(" and tesNode.tesNodeCode  like:tesNodeCodeLike");
			params.put("tesNodeCodeLike","%"+queryModel.getTesNodeCodeLike().toUpperCase()+"%");
		}
		
					
		
		if (StringUtils.hasText(queryModel.getPhoneNum())) {
			hql.append(" and   phoneNum=:phoneNum");
			params.put("phoneNum", queryModel.getPhoneNum());
		}
		if (StringUtils.hasText(queryModel.getPhoneNumLike())) {
			hql.append(" and   phoneNum like:phoneNum");
			params.put("phoneNum","%"+ queryModel.getPhoneNumLike()+"%");
		}		
		if (StringUtils.hasText(queryModel.getCu())) {
			hql.append(" and   cu=:cu");
			params.put("cu", queryModel.getCu());
		}	
		if (StringUtils.hasText(queryModel.getExcludeId())) {
			hql.append(" and id <>:id");
			params.put("id", queryModel.getExcludeId());
		}
		hql.append(" order by phoneNum asc");	
		return (List<TesTele>) super.queryList(hql.toString(), params);
	}
	
}
