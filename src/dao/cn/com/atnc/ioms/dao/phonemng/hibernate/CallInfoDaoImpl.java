package cn.com.atnc.ioms.dao.phonemng.hibernate;

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
import cn.com.atnc.ioms.dao.phonemng.ICallInfoDao;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;
import cn.com.atnc.ioms.model.phonemng.CountCallModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;

@Repository("ICallInfoDao")
public class CallInfoDaoImpl extends MyBaseDao<CallInformation> implements
		ICallInfoDao {
	SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Pagination queryPage(CallInformationQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation where  1=1");
		List<Object> queryParams = new ArrayList<Object>();

		if (queryModel.getCallType() != null) {
			// 通话类型
			if (queryModel.getCallType().name().equals("TRANSFER")) {
				hql.append(" and ( callType = 'TRANSFER' or callType='DIALTRANSFER' ) ");
			} else {
				hql.append(" and callType = ?");
				queryParams.add(queryModel.getCallType());
			}
			if (queryModel.getCallType().name().equals("NORMAL")) {
				// 外呼来电不显示排队放弃的 只显示 接听和未接听的
				hql.append(" and (callState = 'DEALING' or callState = 'NOTDEAL') ");
			}

		}
		if (queryModel.getCallState() != null) {
			// callState
			hql.append(" and callState = ?");
			queryParams.add(queryModel.getCallState());
		}
		if (!StringUtils.isEmpty(queryModel.getUserName())) {
			// 值班工程师
			hql.append(" and userName like ?");
			queryParams.add("%" + queryModel.getUserName() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCallonNumber())) {
			// 主叫号码查询
			hql.append(" and callonNumber like ? ");
			queryParams.add("%" + queryModel.getCallonNumber() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCalledNumber())) {
			// 被叫号码查询
			hql.append(" and calledNumber like ? ");
			queryParams.add("%" + queryModel.getCalledNumber() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCallonCity())) {
			// 主叫号码所在城市
			hql.append(" and callonCity like ? ");
			queryParams.add("%" + queryModel.getCallonCity() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getRingingTime())) {
			// 响铃时间段 开始时间 ringingTime做为开始时间
			hql.append(" and pickupTime >= ?");
			try {
				queryParams.add(startDate.parse(queryModel.getRingingTime()
						+ " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (!StringUtils.isEmpty(queryModel.getPickupTime())) {
			// 响铃时间段 结束时间 pickupTime 做为结束时间
			hql.append(" and pickupTime <= ?");
			try {
				queryParams.add(endDate.parse(queryModel.getPickupTime()
						+ " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (!StringUtils.isEmpty(queryModel.getSpare2())) {
			// 其他 排队放弃的内容
			hql.append(" and (callState != 'DEALING' and callState != 'NOTDEAL') ");
		}
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" and isDel !='DEL' and callState!='NOTDEAL' order by pickupTime desc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	public Pagination queryPageMissedCall(CallInformationQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation where  1=1");
		List<Object> queryParams = new ArrayList<Object>();

		if (queryModel.getCallState() != null) {
			// 通话状态
			hql.append(" and callState = ?");
			queryParams.add(queryModel.getCallState());
		}

		if (queryModel.getIsDel() != null) {
			// 是否删除该记录
			hql.append(" and isDel = ?");
			queryParams.add(queryModel.getIsDel());
		}
		if (queryModel.getCallType() != null) {
			// 通话类型
			if (queryModel.getCallType().name().equals("TRANSFER")) {
				hql.append(" and ( callType = 'TRANSFER' or callType='DIALTRANSFER' ) ");
			} else {
				hql.append(" and callType = ?");
				queryParams.add(queryModel.getCallType());
			}
		}

		if (!StringUtils.isEmpty(queryModel.getUserName())) {
			// 值班工程师
			hql.append(" and userName like ?");
			queryParams.add("%" + queryModel.getUserName() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCallonNumber())) {
			// 主叫号码查询
			hql.append(" and callonNumber like ? ");
			queryParams.add("%" + queryModel.getCallonNumber() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCalledNumber())) {
			// 被叫号码查询
			hql.append(" and calledNumber like ? ");
			queryParams.add("%" + queryModel.getCalledNumber() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCallonCity())) {
			// 主叫号码所在城市
			hql.append(" and callonCity like ? ");
			queryParams.add("%" + queryModel.getCallonCity() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getRingingTime())) {
			// 响铃时间段 开始时间 ringingTime做为开始时间
			hql.append(" and ringingTime >= ?");
			try {
				queryParams.add(startDate.parse(queryModel.getRingingTime()
						+ " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (!StringUtils.isEmpty(queryModel.getPickupTime())) {
			// 响铃时间段 结束时间 pickupTime 做为结束时间
			hql.append(" and ringingTime <= ?");
			try {
				queryParams.add(endDate.parse(queryModel.getPickupTime()
						+ " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by pickupTime desc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	public List<CallInformation> getCallInfoListByCallSheetId(
			CallInformationQueryModel qm) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (qm.getCallSheetId() != null) {
			hql.append("and callSheetId=:callSheetId");
			params.put("callSheetId", qm.getCallSheetId());
		}

		return (List<CallInformation>) super.queryList(hql.toString(), params);
	}

	public List<CallInformation> getMissedCallListByUser(
			CallInformationQueryModel qm) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation where 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(qm.getUserName())) {
			hql.append("and userName=:userName");
			params.put("userName", qm.getUserName());
		}
		hql.append(" and isDel !='DEL' and callState='NOTDEAL' order by ringingTime desc");
		return (List<CallInformation>) super.queryList(hql.toString(), params);
	}

	public List<String> getNameList(CallInformationQueryModel qm) {

		StringBuilder hql = new StringBuilder();
		hql.append("select distinct a.userName from CallInformation a where  1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (!StringUtils.isEmpty(qm.getRingingTime())) {
			// 响铃时间段 开始时间 ringingTime做为开始时间
			hql.append(" and a.callendTime >=:starttime");
			try {
				params.put("starttime",
						startDate.parse(qm.getRingingTime() + " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (!StringUtils.isEmpty(qm.getPickupTime())) {
			// 响铃时间段 结束时间 pickupTime 做为结束时间
			hql.append(" and a.callendTime <=:endtime");
			try {
				params.put("endtime",
						endDate.parse(qm.getPickupTime() + " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		hql.append(" and a.isDel !='DEL' ");
		return (List<String>) super.queryList(hql.toString(), params);
	}

	public List<CallInformation> getCountByName(CallInformationQueryModel qm) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation  where  1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (qm.getCallType() != null) {
			hql.append(" and callType =:callType");
			params.put("callType", qm.getCallType());
		}
		if (qm.getCallState() != null) {
			hql.append(" and callState =:callState");
			params.put("callState", qm.getCallState());
		}

		if (!StringUtils.isEmpty(qm.getUserName())) {
			hql.append(" and userName=:userName");
			params.put("userName", qm.getUserName());
		}
		if (!StringUtils.isEmpty(qm.getRingingTime())) {
			// 响铃时间段 开始时间 ringingTime做为开始时间
			hql.append(" and callendTime >=:starttime");
			try {
				params.put("starttime",
						startDate.parse(qm.getRingingTime() + " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (!StringUtils.isEmpty(qm.getPickupTime())) {
			// 响铃时间段 结束时间 pickupTime 做为结束时间
			hql.append(" and callendTime <=:endtime");
			try {
				params.put("endtime",
						endDate.parse(qm.getPickupTime() + " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		hql.append(" and isDel !='DEL' ");
		return (List<CallInformation>) super.queryList(hql.toString(), params);
	}

	public List<CallInformation> getCountPieByName(CallInformationQueryModel qm) {

		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation  where  1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (qm.getCallType() != null) {
			hql.append(" and callType =:callType");
			params.put("callType", qm.getCallType());
		}
		if (qm.getCallState() != null) {
			hql.append(" and callState =:callState");
			params.put("callState", qm.getCallState());
		}

		if (!StringUtils.isEmpty(qm.getUserName())) {
			hql.append(" and userName=:userName");
			params.put("userName", qm.getUserName());
		}
		if (!StringUtils.isEmpty(qm.getCallendTime())) {
			// 响铃时间段 开始时间 ringingTime做为开始时间
			hql.append(" and callendTime >=:starttime");
			try {
				params.put("starttime",
						startDate.parse(qm.getCallendTime() + " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			hql.append(" and callendTime <=:endtime");
			try {
				params.put("endtime",
						endDate.parse(qm.getCallendTime() + " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		hql.append(" and isDel !='DEL' ");
		return (List<CallInformation>) super.queryList(hql.toString(), params);
	}

	public List<Double> getCountLineByName(CallInformationQueryModel qm,
			String type) {
		StringBuilder hql = new StringBuilder();
		hql.append("select sum(a.callDuration) from CallInformation a  where  1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (type.equals("2")) {
			// 线图
			if (!StringUtils.isEmpty(qm.getRingingTime())) {
				// 响铃时间段 开始时间 ringingTime做为开始时间
				hql.append(" and a.callendTime >=:starttime");
				try {
					params.put("starttime",
							startDate.parse(qm.getRingingTime() + " 00:00:00"));
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
			if (!StringUtils.isEmpty(qm.getPickupTime())) {
				// 响铃时间段 结束时间 pickupTime 做为结束时间
				hql.append(" and a.callendTime <=:endtime");
				try {
					params.put("endtime",
							endDate.parse(qm.getPickupTime() + " 23:59:59"));
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}

		} else {
			// 个人统计
			if (qm.getCallType() != null) {
				hql.append(" and a.callType =:callType");
				params.put("callType", qm.getCallType());
			}
			if (qm.getCallState() != null) {
				hql.append(" and a.callState =:callState");
				params.put("callState", qm.getCallState());
			}
			if (!StringUtils.isEmpty(qm.getCallendTime())) {
				// 响铃时间段 开始时间 ringingTime做为开始时间
				hql.append(" and a.callendTime >=:starttime");
				try {
					params.put("starttime",
							startDate.parse(qm.getCallendTime() + " 00:00:00"));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				hql.append(" and a.callendTime <=:endtime");
				try {
					params.put("endtime",
							endDate.parse(qm.getCallendTime() + " 23:59:59"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		if (!StringUtils.isEmpty(qm.getUserName())) {
			hql.append(" and a.userName=:userName");
			params.put("userName", qm.getUserName());
		}

		hql.append(" and a.isDel !='DEL' ");
		return (List<Double>) super.queryList(hql.toString(), params);
	}

	@SuppressWarnings("unchecked")
	public List<CallInformation> getFileByDate(CallInformationQueryModel qm) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation  where  1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (qm.getCallendTime() != null) {
			// 响铃时间段 开始时间 ringingTime做为开始时间
			hql.append(" and callendTime >=:starttime");
			try {
				params.put("starttime",
						startDate.parse(qm.getCallendTime() + " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (qm.getCallendTime() != null) {
			// 响铃时间段 结束时间 pickupTime 做为结束时间
			hql.append(" and callendTime <=:endtime");
			try {
				params.put("endtime",
						endDate.parse(qm.getCallendTime() + " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		hql.append(" and isDel !='DEL' order by callendTime desc");
		return (List<CallInformation>) super.queryList(hql.toString(), params);
	}

	public Pagination queryPageExport(CallInformationQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation where  1=1");
		List<Object> queryParams = new ArrayList<Object>();

		if (queryModel.getCallType() != null) {
			// callType
			hql.append(" and callType = ?");
			queryParams.add(queryModel.getCallType());
		}
		if (queryModel.getCallState() != null) {
			// callState
			hql.append(" and callState = ?");
			queryParams.add(queryModel.getCallState());
		}
		if (queryModel.getIsDel() != null) {
			// isDel
			hql.append(" and isDel = ?");
			queryParams.add(queryModel.getIsDel());
		}
		if (!StringUtils.isEmpty(queryModel.getUserName())) {
			// 值班工程师
			hql.append(" and userName like ?");
			queryParams.add("%" + queryModel.getUserName() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCallonNumber())) {
			// 主叫号码查询
			hql.append(" and callonNumber like ? ");
			queryParams.add("%" + queryModel.getCallonNumber() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCalledNumber())) {
			// 被叫号码查询
			hql.append(" and calledNumber like ? ");
			queryParams.add("%" + queryModel.getCalledNumber() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCallonCity())) {
			// 主叫号码所在城市
			hql.append(" and callonCity like ? ");
			queryParams.add("%" + queryModel.getCallonCity() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getRingingTime())) {
			// 响铃时间段 开始时间 ringingTime做为开始时间
			hql.append(" and pickupTime >= ?");
			try {
				queryParams.add(startDate.parse(queryModel.getRingingTime()
						+ " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (!StringUtils.isEmpty(queryModel.getPickupTime())) {
			// 响铃时间段 结束时间 pickupTime 做为结束时间
			hql.append(" and pickupTime <= ?");
			try {
				queryParams.add(endDate.parse(queryModel.getPickupTime()
						+ " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}

		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by pickupTime desc");
		return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	public List<CallInformation> listExport(CallInformationQueryModel queryModel) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation where  1=1");
		Map<String, Object> params = new HashMap<String, Object>();

		if (queryModel.getCallType() != null) {
			// callType
			hql.append(" and callType =: type");
			params.put("type", queryModel.getCallType());
		}
		if (queryModel.getCallState() != null) {
			// callState
			hql.append(" and callState =:state");
			params.put("state", queryModel.getCallState());
		}
		if (queryModel.getIsDel() != null) {
			// isDel
			hql.append(" and isDel =:isdel");
			params.put("isdel", queryModel.getIsDel());
		}
		if (!StringUtils.isEmpty(queryModel.getUserName())) {
			// 值班工程师
			hql.append(" and userName like :user");
			params.put("user", "%" + queryModel.getUserName() + "%");
		}
		if (!StringUtils.isEmpty(queryModel.getCallonNumber())) {
			// 主叫号码查询
			hql.append(" and callonNumber like :callonnum ");
			params.put("callonnum", "%" + queryModel.getCallonNumber() + "%");
		}
		/*
		 * if(!StringUtils.isEmpty(queryModel.getCalledNumber())){ //被叫号码查询
		 * hql.append(" and calledNumber like ? ");
		 * queryParams.add("%"+queryModel.getCalledNumber()+"%"); }
		 * if(!StringUtils.isEmpty(queryModel.getCallonCity())){ //主叫号码所在城市
		 * hql.append(" and callonCity like ? ");
		 * queryParams.add("%"+queryModel.getCallonCity()+"%"); }
		 * if(!StringUtils.isEmpty(queryModel.getRingingTime())){ //响铃时间段 开始时间
		 * ringingTime做为开始时间 hql.append(" and pickupTime >= ?"); try {
		 * queryParams
		 * .add(startDate.parse(queryModel.getRingingTime()+" 00:00:00")); }
		 * catch (ParseException e) { e.printStackTrace(); }
		 * 
		 * } if(!StringUtils.isEmpty(queryModel.getPickupTime())){ //响铃时间段 结束时间
		 * pickupTime 做为结束时间 hql.append(" and pickupTime <= ?"); try {
		 * queryParams
		 * .add(endDate.parse(queryModel.getPickupTime()+" 23:59:59")); } catch
		 * (ParseException e) { e.printStackTrace(); }
		 * 
		 * }
		 */
		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by pickupTime desc");
		return (List<CallInformation>) super.queryList(hql.toString(), params);
	}

	/**
	 * 查询未经过备份的录音文件
	 */
	public List<CallInformation> backupCallInfo(
			CallInformationQueryModel queryModel) {
		StringBuilder hql = new StringBuilder();
		hql.append(" from CallInformation where  recordFileName is not null and spare2 is null ");
		Map<String, Object> params = new HashMap<String, Object>();

		String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
		hql.append(" order by pickupTime desc");
		return (List<CallInformation>) super.queryList(hql.toString(), params);
	}

	
    /**
     * 统计查询
     * @author 韩天驭
     * @2017年1月9日 下午2:28:09
     * @param qm
     * @return 
     * Map<Integer,List<String>>
     */
	public Map<String, List<String>> CountTimes(CallInformationQueryModel qm) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
		//////////
		
		StringBuilder hql = new StringBuilder();
		hql.append(" select a.userName from CallInformation a where 1=1 ");
		
		hql=this.setHql(qm, hql, params);
		hql.append(" and a.isDel !='DEL' and a.userName is not null  group by a.userName,a.atncType order by a.userName asc");
		List<String> listName = (List<String>) super.queryList(hql.toString(),
				params);
		resultMap.put("工程师姓名", listName);
		////////////////////
		//
		StringBuilder hqlSum = new StringBuilder();
		hqlSum.append(" select cast(sum(a.callDuration) as string) from CallInformation a where 1=1 ");
		hqlSum=this.setHql(qm, hqlSum, params);
		hqlSum.append(" and a.isDel !='DEL'  and a.userName is not null group by a.userName,a.atncType order by a.userName asc ");
		List<String> listSum = (List<String>) super.queryList(
				hqlSum.toString(), params);
		resultMap.put("通话时长(秒)", listSum);
		
		StringBuilder hqlSumM = new StringBuilder();
		hqlSumM.append(" select cast(trunc(sum(a.callDuration)/60,3) as string) from CallInformation a where 1=1 ");
		hqlSumM=this.setHql(qm, hqlSumM, params);
		hqlSumM.append(" and a.isDel !='DEL'  and a.userName is not null group by a.userName,a.atncType order by a.userName asc ");
		List<String> listSumM = (List<String>) super.queryList(
				hqlSumM.toString(), params);
		resultMap.put("通话时长(分钟)", listSumM);
		//
        //////////
		StringBuilder hqltype = new StringBuilder();
		hqltype.append(" select a.atncType from CallInformation a where 1=1 ");
		hqltype=this.setHql(qm, hqltype, params);
		hqltype.append(" and a.isDel !='DEL' and a.userName is not null group by a.userName,a.atncType order by a.userName asc ");
		List<String> listType = (List<String>) super.queryList(
				hqltype.toString(), params);
		resultMap.put("电话类别", listType);
		//
		
		return resultMap;
	}

	public StringBuilder setHql(CallInformationQueryModel qm, StringBuilder hql,
			Map<String, Object> params) {
		// 根据电话类别
		if (qm.getAtncType() != null) {
			hql.append(" and a.atncType=:atncType ");
			params.put("atncType", qm.getAtncType());
		}
		// 工程师
		if (!StringUtils.isEmpty(qm.getUserName())) {
			hql.append(" and a.userName=:userName ");
			params.put("userName", qm.getUserName());
		}

		if (!StringUtils.isEmpty(qm.getRingingTime())) {
			// 响铃时间段 开始时间 ringingTime做为开始时间
			hql.append(" and a.callendTime >=:starttime ");
			try {
				params.put("starttime",
						startDate.parse(qm.getRingingTime() + " 00:00:00"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		if (!StringUtils.isEmpty(qm.getPickupTime())) {
			// 响铃时间段 结束时间 pickupTime 做为结束时间
			hql.append(" and a.callendTime <=:endtime ");
			try {
				params.put("endtime",
						endDate.parse(qm.getPickupTime() + " 23:59:59"));
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
		
		return hql;
	}

}
