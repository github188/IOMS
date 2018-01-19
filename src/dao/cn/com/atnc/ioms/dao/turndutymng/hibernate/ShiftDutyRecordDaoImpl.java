package cn.com.atnc.ioms.dao.turndutymng.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.turndutymng.IShiftDutyRecordDao;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.model.turndutymng.ShiftDutyQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;

@Repository("IShiftDutyRecordDao")
public class ShiftDutyRecordDaoImpl extends MyBaseDao<ShiftDutyRecord> implements IShiftDutyRecordDao{
	SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat eqDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public Pagination queryPage(TurnDutyQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from ShiftDutyRecord where  1=1");
		List<Object> queryParams = new ArrayList<Object>();
		
		if(queryModel.getDutyPlace()!=null){
			hql.append(" and dutyPlaces = ?");
			queryParams.add(queryModel.getDutyPlace());
		}
		if(queryModel.getDutyRole()!=null){
			hql.append(" and dutyRoles = ?");
			queryParams.add(queryModel.getDutyRole());
		}
		if(!StringUtils.isEmpty(queryModel.getCreater())){
			hql.append(" and creater.name like ? escape '/' ");
			queryParams.add( "%" + queryModel.getCreater() + "%" );
		}
		if(!StringUtils.isEmpty(queryModel.getRemark())){
			hql.append(" and remark like ? escape '/' ");
			queryParams.add( "%" + queryModel.getRemark() + "%" );
		}
		if(!StringUtils.isEmpty(queryModel.getStartOptTime())){
			
			hql.append(" and creatime >= ?");
		    try {
		    	queryParams.add(startDate.parse(queryModel.getStartOptTime()+" 00:00:00"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
		}
		if(!StringUtils.isEmpty(queryModel.getEndOptTime())){
		
			hql.append(" and creatime <= ?");
		    try {
		    	queryParams.add(endDate.parse(queryModel.getEndOptTime()+" 23:59:59"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" and spare1='0' order by creatime desc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	
	public Pagination queryRecyclePage(TurnDutyQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from ShiftDutyRecord where  1=1");
		List<Object> queryParams = new ArrayList<Object>();
		
		if(queryModel.getDutyPlace()!=null){
			hql.append(" and dutyPlaces = ?");
			queryParams.add(queryModel.getDutyPlace());
		}
		if(queryModel.getDutyRole()!=null){
			hql.append(" and dutyRoles = ?");
			queryParams.add(queryModel.getDutyRole());
		}
		if(!StringUtils.isEmpty(queryModel.getCreater())){
			hql.append(" and creater.name like ? escape '/' ");
			queryParams.add( "%" + queryModel.getCreater() + "%" );
		}
		if(!StringUtils.isEmpty(queryModel.getRemark())){
			hql.append(" and remark like ? escape '/' ");
			queryParams.add( "%" + queryModel.getRemark() + "%" );
		}
		if(!StringUtils.isEmpty(queryModel.getStartOptTime())){
			
			hql.append(" and creatime >= ?");
		    try {
		    	queryParams.add(startDate.parse(queryModel.getStartOptTime()+" 00:00:00"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
		}
		if(!StringUtils.isEmpty(queryModel.getEndOptTime())){
		
			hql.append(" and creatime <= ?");
		    try {
		    	queryParams.add(endDate.parse(queryModel.getEndOptTime()+" 23:59:59"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" and spare1='1' order by creatime desc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}
	public List<ShiftDutyRecord> getRecordList(ShiftDutyQueryModel queryModel) {
	
		StringBuilder hql = new StringBuilder();
		hql.append(" from ShiftDutyRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
	    if(queryModel.getSignRecord()!=null) {
	    	hql.append(" and signRecord.dutyPlace =:signplace");
	    	params.put("signplace",queryModel.getSignRecord().getDutyPlace());
	    }
	    //查询日期
	    if(queryModel.getSignTime()!=null) {
	    	hql.append(" and creatime >=:starttime");
	    	params.put("starttime",queryModel.getSignTime());
	    }
	    //查询日期
	    if(queryModel.getLeaveTime()!=null) {
	    	hql.append(" and creatime <=:endtime");
	    	params.put("endtime",queryModel.getLeaveTime());
	    }
	    hql.append(" and signRecord.dutyStatus !='LEAVE' ");
		hql.append(" and spare1='0' order by creatime desc");
		return (List<ShiftDutyRecord>) super.queryList(hql.toString(),params);
	}
	public List<ShiftDutyRecord> getRecordBySignId(ShiftDutyQueryModel queryModel) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from ShiftDutyRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
	    if(queryModel.getSignRecord()!=null)
	    {
	    	hql.append(" and signRecord.id =:signid");
	    	params.put("signid",queryModel.getSignRecord().getId());
	    }
		hql.append(" and spare1='0' order by creatime desc");
		return (List<ShiftDutyRecord>) super.queryList(hql.toString(),params);
	}
	
	public List<ShiftDutyRecord> getRecordListBySign(ShiftDutyQueryModel queryModel) {
		
		StringBuilder hql = new StringBuilder();
		hql.append(" from ShiftDutyRecord where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
	    if(queryModel.getDutyPlaces()!=null) {
	    	hql.append(" and signRecord.dutyPlace =:signplace");
	    	params.put("signplace",queryModel.getDutyPlaces());
	    }
	    //查询日期
	    if(queryModel.getSignTime()!=null) {
	    	hql.append(" and creatime >=:starttime");
	    	params.put("starttime",queryModel.getSignTime());
	    }
	    //查询日期
	    if(queryModel.getLeaveTime()!=null) {
	    	hql.append(" and creatime <=:endtime");
	    	params.put("endtime",queryModel.getLeaveTime());
	    }
	    
		hql.append(" and spare1='0' order by creatime desc");
		return (List<ShiftDutyRecord>) super.queryList(hql.toString(),params);
	}

}
