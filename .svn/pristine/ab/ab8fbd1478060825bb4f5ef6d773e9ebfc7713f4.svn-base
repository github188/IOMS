/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:32:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.tempcircuit.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.tempcircuit.ITempCircuitDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuit;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitExpireType;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitStatus;
import cn.com.atnc.ioms.enums.tempcircuit.CircuitType;
import cn.com.atnc.ioms.model.tempcircuit.TempCircuitQueryModel;

/**
 * 
 * 类说明：临时电路DAO实现
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午7:03:07
 * @version:1.0
 */
@Repository("tempCircuitDao")
public class TempCircuitDaoImpl extends MyBaseDao<TempCircuit> implements
		ITempCircuitDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TempCircuit> getTempCircuitByApplyUserID(String id) {
		// TODO Auto-generated method stub
		return (List<TempCircuit>) this.queryList(
				"from TempCircuit where applyUser.id = ?", id);
	}

	@SuppressWarnings("static-access")
	@Override
	public Pagination queryPage(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer(" from TempCircuit where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(qm.getEquipID())) {
			hql.append(" and (aEquip.id = ? or zEquip.id = ?)");
			params.add(qm.getEquipID());
			params.add(qm.getEquipID());
		}
		if (!StringUtils.isEmpty(qm.getApplyUserID())) {
			hql.append(" and applyUserId = ?");
			params.add(qm.getApplyUserID());
		}
		if (!StringUtils.isEmpty(qm.getaEquipID())) {
			hql.append(" and aEquip.id = ?");
			params.add(qm.getaEquipID());
		}
		if (!StringUtils.isEmpty(qm.getzEquipID())) {
			hql.append(" and zEquip.id = ?");
			params.add(qm.getzEquipID());
		}
		if (null != qm.getCircuitType()) {
			hql.append(" and circuitType = ?");
			params.add(qm.getCircuitType());
		}
		if (!StringUtils.isEmpty(qm.getApplyCompany())) {
			hql.append(" and applyCompany like ?");
			params.add("%" + qm.getApplyCompany() + "%");
		}
		if (!StringUtils.isEmpty(qm.getApplyUserLoginName())) {
			hql.append("and applyUserName like ?");
			params.add("%" + qm.getApplyUserLoginName() + "%");
		}
		if (!StringUtils.isEmpty(qm.getLinkMan())) {
			hql.append(" and linkMan like ?");
			params.add("%" + qm.getLinkMan() + "%");
		}
		if (null != qm.getCircuitStatus()) {
			hql.append(" and circuitStatus = ?");
			params.add(qm.getCircuitStatus());
		}
		if (null != qm.getCircuitOptType()) {
			hql.append(" and circuitOptType = ?");
			params.add(qm.getCircuitOptType());
		}
		if (!StringUtils.isEmpty(qm.getAuditor())) {
			hql.append(" and auditerList like ?");
			params.add("%|" + qm.getAuditor() + "|%");
		}
		if (null != qm.getCircuitCancelType()) {
			hql.append(" and circuitCancelType = ?");
			params.add(qm.getCircuitCancelType());
		}
		if (null != qm.getCircuitExpireType()) {
			hql.append(" and circuitExpireType = ?");
			params.add(qm.getCircuitExpireType());
		}
		if (null != qm.getCircuitExpireTypeNotExist()) {
			hql.append(" and circuitExpireType != ?");
			params.add(qm.getCircuitExpireTypeNotExist());
		}
		if (!StringUtils.isEmpty(qm.getEngineerName())) {
			hql.append(" and engineerName = ?");
			params.add(qm.getEngineerName());
		}
		if (!StringUtils.isEmpty(qm.getNumber())) {
			hql.append(" and number like ?");
			params.add("%" + qm.getNumber() + "%");
		}
		if (!StringUtils.isEmpty(qm.getAckDelete())) {
			hql.append("and ackDelete = ?");
			if (StringUtils.equals(qm.getAckDelete(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getAckDelete(), "false")) {
				params.add(false);
			}
		}
		if (!StringUtils.isEmpty(qm.getApplyDelay())) {
			hql.append("and applyDelay = ?");
			if (StringUtils.equals(qm.getApplyDelay(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getApplyDelay(), "false")) {
				params.add(false);
			}
		}

		String column = StringUtils.isEmpty(qm.getColumn()) ? "updateTime" : qm
				.getColumn();
		String sort = StringUtils.isEmpty(qm.getSort()) ? "DESC" : qm.getSort();
		String countHql = super.COUNT_ID + hql.toString();

		return super.queryGridPage(hql.toString(), countHql, params.toArray(),
				qm.getPageNo(), qm.getPageSize(), sort, column);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TempCircuit> queryList(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer(" from TempCircuit where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(qm.getApplyUserID())) {
			hql.append(" and applyUserId = ?");
			params.add(qm.getApplyUserID());
		}
		if (!StringUtils.isEmpty(qm.getaEquipID())) {
			hql.append(" and aEquip.id = ?");
			params.add(qm.getaEquipID());
		}
		if (!StringUtils.isEmpty(qm.getzEquipID())) {
			hql.append(" and zEquip.id = ?");
			params.add(qm.getzEquipID());
		}
		if (!StringUtils.isEmpty(qm.getTaskName())) {
			hql.append(" and currentTaskName = ?");
			params.add(qm.getTaskName());
		}
		if (qm.getSend() != null) {
			hql.append(" and send = ?");
			params.add(qm.getSend());
		}
		if (null != qm.getCircuitType()) {
			hql.append(" and circuitType = ?");
			params.add(qm.getCircuitType());
		}
		if (!StringUtils.isEmpty(qm.getApplyCompany())) {
			hql.append(" and applyCompany like ?");
			params.add("%" + qm.getApplyCompany() + "%");
		}
		if (!StringUtils.isEmpty(qm.getApplyUserLoginName())) {
			hql.append("and applyUserName like ?");
			params.add("%" + qm.getApplyUserLoginName() + "%");
		}
		if (!StringUtils.isEmpty(qm.getLinkMan())) {
			hql.append(" and linkMan like ?");
			params.add("%" + qm.getLinkMan() + "%");
		}
		if (null != qm.getCircuitStatus()) {
			hql.append(" and circuitStatus = ?");
			params.add(qm.getCircuitStatus());
		}
		if (null != qm.getCircuitOptType()) {
			hql.append(" and circuitOptType = ?");
			params.add(qm.getCircuitOptType());
		}
		if (!StringUtils.isEmpty(qm.getAuditor())) {
			hql.append(" and auditerList like ?");
			params.add("%|" + qm.getAuditor() + "|%");
		}
		if (null != qm.getCircuitCancelType()) {
			hql.append(" and circuitCancelType = ?");
			params.add(qm.getCircuitCancelType());
		}
		if (null != qm.getCircuitExpireType()) {
			hql.append(" and circuitExpireType = ?");
			params.add(qm.getCircuitExpireType());
		}
		if (null != qm.getCircuitExpireTypeNotExist()) {
			hql.append(" and circuitExpireType != ?");
			params.add(qm.getCircuitExpireTypeNotExist());
		}
		if (!StringUtils.isEmpty(qm.getEngineerName())) {
			hql.append(" and engineerName = ?");
			params.add(qm.getEngineerName());
		}
		if (!StringUtils.isEmpty(qm.getNumber())) {
			hql.append(" and number like ?");
			params.add("%" + qm.getNumber() + "%");
		}
		if (!StringUtils.isEmpty(qm.getAckDelete())) {
			hql.append("and ackDelete = ?");
			if (StringUtils.equals(qm.getAckDelete(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getAckDelete(), "false")) {
				params.add(false);
			}
		}
		if (!StringUtils.isEmpty(qm.getApplyDelay())) {
			hql.append("and applyDelay = ?");
			if (StringUtils.equals(qm.getApplyDelay(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getApplyDelay(), "false")) {
				params.add(false);
			}
		}
		return (List<TempCircuit>) super.queryList(hql.toString(),
				params.toArray());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TempCircuit> getAllValidTempCircuit() {
		// TODO Auto-generated method stub
		return (List<TempCircuit>) this
				.queryList(
						"from TempCircuit where circuitExpireType != ? and circuitStatus = ?",
						new Object[] { CircuitExpireType.EXPIRE,
								CircuitStatus.DONE });
	}

	@SuppressWarnings("static-access")
	@Override
	public Pagination queryPageAudit(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer(" from TempCircuit where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(qm.getEquipID())) {
			hql.append(" and (aEquip.id = ? or zEquip.id = ?)");
			params.add(qm.getEquipID());
			params.add(qm.getEquipID());
		}
		if (!StringUtils.isEmpty(qm.getaEquipID())) {
			hql.append(" and aEquip.id = ?");
			params.add(qm.getaEquipID());
		}
		if (!StringUtils.isEmpty(qm.getzEquipID())) {
			hql.append(" and zEquip.id = ?");
			params.add(qm.getzEquipID());
		}
		if (null != qm.getCircuitType()) {
			hql.append(" and circuitType = ?");
			params.add(qm.getCircuitType());
		}
		if (!StringUtils.isEmpty(qm.getApplyCompany())) {
			hql.append(" and applyCompany like ?");
			params.add("%" + qm.getApplyCompany() + "%");
		}
		if (!StringUtils.isEmpty(qm.getApplyUserLoginName())) {
			hql.append("and applyUserName like ?");
			params.add("%" + qm.getApplyUserLoginName() + "%");
		}
		if (!StringUtils.isEmpty(qm.getLinkMan())) {
			hql.append(" and linkMan like ?");
			params.add("%" + qm.getLinkMan() + "%");
		}
		if (null != qm.getCircuitOptType()) {
			hql.append(" and circuitOptType = ?");
			params.add(qm.getCircuitOptType());
		}
		if (!StringUtils.isEmpty(qm.getAuditor())) {
			hql.append(" and auditerList like ?");
			params.add("%|" + qm.getAuditor() + "|%");
		}
		if (null != qm.getCircuitCancelType()) {
			hql.append(" and circuitCancelType = ?");
			params.add(qm.getCircuitCancelType());
		}
		if (null != qm.getCircuitExpireType()) {
			hql.append(" and circuitExpireType = ?");
			params.add(qm.getCircuitExpireType());
		}
		if (null != qm.getCircuitExpireTypeNotExist()) {
			hql.append(" and circuitExpireType != ?");
			params.add(qm.getCircuitExpireTypeNotExist());
		}
		if (!StringUtils.isEmpty(qm.getEngineerName())) {
			hql.append(" and engineerName like ?");
			params.add("%" + qm.getEngineerName() + "%");
		}
		if (!StringUtils.isEmpty(qm.getNumber())) {
			hql.append(" and number like ?");
			params.add("%" + qm.getNumber() + "%");
		}
		if (!StringUtils.isEmpty(qm.getAckDelete())) {
			hql.append("and ackDelete = ?");
			if (StringUtils.equals(qm.getAckDelete(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getAckDelete(), "false")) {
				params.add(false);
			}
		}
		if (!StringUtils.isEmpty(qm.getApplyDelay())) {
			hql.append("and applyDelay = ?");
			if (StringUtils.equals(qm.getApplyDelay(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getApplyDelay(), "false")) {
				params.add(false);
			}
		}
		hql.append(" and circuitStatus not in (?,?,?) ");
		params.add(CircuitStatus.DELETED);
		params.add(CircuitStatus.ACKDELETED);
		params.add(CircuitStatus.DONE);

		String column = StringUtils.isEmpty(qm.getColumn()) ? "updateTime" : qm
				.getColumn();
		String sort = StringUtils.isEmpty(qm.getSort()) ? "DESC" : qm.getSort();
		String countHql = super.COUNT_ID + hql.toString();

		return super.queryGridPage(hql.toString(), countHql, params.toArray(),
				qm.getPageNo(), qm.getPageSize(), sort, column);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TempCircuit findTempCircuitByRecordTime(CircuitType circuitType) {
		// TODO Auto-generated method stub
		List<TempCircuit> list = (List<TempCircuit>) this
				.queryList(
						"from TempCircuit where circuitType = ? order by recordTime desc",
						circuitType);
		return list.size() > 0 ? list.get(0) : null;
	}

	@SuppressWarnings("static-access")
	@Override
	public Pagination queryPageExpire(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer(" from TempCircuit where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(qm.getEquipID())) {
			hql.append(" and (aEquip.id = ? or zEquip.id = ?)");
			params.add(qm.getEquipID());
			params.add(qm.getEquipID());
		}
		if (!StringUtils.isEmpty(qm.getaEquipID())) {
			hql.append(" and aEquip.id = ?");
			params.add(qm.getaEquipID());
		}
		if (!StringUtils.isEmpty(qm.getzEquipID())) {
			hql.append(" and zEquip.id = ?");
			params.add(qm.getzEquipID());
		}
		if (null != qm.getCircuitType()) {
			hql.append(" and circuitType = ?");
			params.add(qm.getCircuitType());
		}
		if (!StringUtils.isEmpty(qm.getApplyCompany())) {
			hql.append(" and applyCompany like ?");
			params.add("%" + qm.getApplyCompany() + "%");
		}
		if (!StringUtils.isEmpty(qm.getApplyUserLoginName())) {
			hql.append("and applyUserName like ?");
			params.add("%" + qm.getApplyUserLoginName() + "%");
		}
		if (!StringUtils.isEmpty(qm.getLinkMan())) {
			hql.append(" and linkMan like ?");
			params.add("%" + qm.getLinkMan() + "%");
		}
		if (null != qm.getCircuitOptType()) {
			hql.append(" and circuitOptType = ?");
			params.add(qm.getCircuitOptType());
		}
		if (!StringUtils.isEmpty(qm.getAuditor())) {
			hql.append(" and auditerList like ?");
			params.add("%|" + qm.getAuditor() + "|%");
		}
		if (null != qm.getCircuitCancelType()) {
			hql.append(" and circuitCancelType = ?");
			params.add(qm.getCircuitCancelType());
		}

		if (!StringUtils.isEmpty(qm.getEngineerName())) {
			hql.append(" and engineerName like ?");
			params.add("%" + qm.getEngineerName() + "%");
		}
		if (!StringUtils.isEmpty(qm.getNumber())) {
			hql.append(" and number like ?");
			params.add("%" + qm.getNumber() + "%");
		}
		if (!StringUtils.isEmpty(qm.getAckDelete())) {
			hql.append("and ackDelete = ?");
			if (StringUtils.equals(qm.getAckDelete(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getAckDelete(), "false")) {
				params.add(false);
			}
		}
		if (!StringUtils.isEmpty(qm.getApplyDelay())) {
			hql.append("and applyDelay = ?");
			if (StringUtils.equals(qm.getApplyDelay(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getApplyDelay(), "false")) {
				params.add(false);
			}
		}
		hql.append(" and circuitExpireType = ?");
		params.add(CircuitExpireType.EXPIRE);

		hql.append(" and circuitStatus not in (?,?) ");
		params.add(CircuitStatus.ACKDELETED);
		params.add(CircuitStatus.FORCEDELETED);

		String column = StringUtils.isEmpty(qm.getColumn()) ? "updateTime" : qm
				.getColumn();
		String sort = StringUtils.isEmpty(qm.getSort()) ? "DESC" : qm.getSort();
		String countHql = super.COUNT_ID + hql.toString();

		return super.queryGridPage(hql.toString(), countHql, params.toArray(),
				qm.getPageNo(), qm.getPageSize(), sort, column);
	}

	@SuppressWarnings("static-access")
	@Override
	public Pagination queryPageOver(TempCircuitQueryModel qm) {
		// TODO Auto-generated method stub
		StringBuffer hql = new StringBuffer(" from TempCircuit where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(qm.getEquipID())) {
			hql.append(" and (aEquip.id = ? or zEquip.id = ?)");
			params.add(qm.getEquipID());
			params.add(qm.getEquipID());
		}
		if (!StringUtils.isEmpty(qm.getaEquipID())) {
			hql.append(" and aEquip.id = ?");
			params.add(qm.getaEquipID());
		}
		if (!StringUtils.isEmpty(qm.getzEquipID())) {
			hql.append(" and zEquip.id = ?");
			params.add(qm.getzEquipID());
		}
		if (null != qm.getCircuitType()) {
			hql.append(" and circuitType = ?");
			params.add(qm.getCircuitType());
		}
		if (!StringUtils.isEmpty(qm.getApplyCompany())) {
			hql.append(" and applyCompany like ?");
			params.add("%" + qm.getApplyCompany() + "%");
		}
		if (!StringUtils.isEmpty(qm.getApplyUserLoginName())) {
			hql.append("and applyUserName like ?");
			params.add("%" + qm.getApplyUserLoginName() + "%");
		}
		if (!StringUtils.isEmpty(qm.getLinkMan())) {
			hql.append(" and linkMan like ?");
			params.add("%" + qm.getLinkMan() + "%");
		}
		if (null != qm.getCircuitOptType()) {
			hql.append(" and circuitOptType = ?");
			params.add(qm.getCircuitOptType());
		}
		if (!StringUtils.isEmpty(qm.getAuditor())) {
			hql.append(" and auditerList like ?");
			params.add("%|" + qm.getAuditor() + "|%");
		}
		if (null != qm.getCircuitCancelType()) {
			hql.append(" and circuitCancelType = ?");
			params.add(qm.getCircuitCancelType());
		}
		if (null != qm.getCircuitExpireType()) {
			hql.append(" and circuitExpireType = ?");
			params.add(qm.getCircuitExpireType());
		}
		if (null != qm.getCircuitExpireTypeNotExist()) {
			hql.append(" and circuitExpireType != ?");
			params.add(qm.getCircuitExpireTypeNotExist());
		}
		if (!StringUtils.isEmpty(qm.getEngineerName())) {
			hql.append(" and engineerName like ?");
			params.add("%" + qm.getEngineerName() + "%");
		}
		if (!StringUtils.isEmpty(qm.getNumber())) {
			hql.append(" and number like ?");
			params.add("%" + qm.getNumber() + "%");
		}
		if (!StringUtils.isEmpty(qm.getAckDelete())) {
			hql.append("and ackDelete = ?");
			if (StringUtils.equals(qm.getAckDelete(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getAckDelete(), "false")) {
				params.add(false);
			}
		}
		if (!StringUtils.isEmpty(qm.getApplyDelay())) {
			hql.append("and applyDelay = ?");
			if (StringUtils.equals(qm.getApplyDelay(), "true")) {
				params.add(true);
			}
			if (StringUtils.equals(qm.getApplyDelay(), "false")) {
				params.add(false);
			}
		}

		hql.append(" and circuitStatus in (?,?) ");
		params.add(CircuitStatus.ACKDELETED);
		params.add(CircuitStatus.FORCEDELETED);

		String column = StringUtils.isEmpty(qm.getColumn()) ? "updateTime" : qm
				.getColumn();
		String sort = StringUtils.isEmpty(qm.getSort()) ? "DESC" : qm.getSort();
		String countHql = super.COUNT_ID + hql.toString();

		return super.queryGridPage(hql.toString(), countHql, params.toArray(),
				qm.getPageNo(), qm.getPageSize(), sort, column);
	}
}
