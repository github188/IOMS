package cn.com.atnc.ioms.dao.business.approveinfo.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.approveinfo.IApproveInfoDao;
import cn.com.atnc.ioms.entity.business.approveinfo.ApproveInfo;


/**
 * 公共审批信息DAO接口实现
 *
 * @author ku
 * @date 2015年5月15日 下午4:35:00
 * @since 1.0.0
 */
@Repository
public class ApproveInfoDaoImpl extends MyBaseDao<ApproveInfo> implements IApproveInfoDao {

	@Override
	public List<ApproveInfo> getApproveInfoByBaseInfoId(String id) {
		@SuppressWarnings("unchecked")
		List<ApproveInfo> approveInfos = (List<ApproveInfo>) queryList(
				"from ApproveInfo where applyBaseInfo.id = ? order by approveTime asc", id);
		return approveInfos;
	}

	@Override
	public List<ApproveInfo> getApproveInfoByUser(String id, String userId) {
		@SuppressWarnings("unchecked")
		List<ApproveInfo> approveInfos = (List<ApproveInfo>) queryList(
				"from ApproveInfo where applyBaseInfo.id = ? and user.id = ? order by approveTime desc", new String[]{id,userId});
		return approveInfos;
	}

	@Override
	public int getReturnedApplyNumber(String id) {
		String hql = "from ApproveInfo where applyBaseInfo.id = ? and reportAddress is not null";
		long count = querySize(hql, new String[]{id});
		return Integer.valueOf(count+"");
	}

}
