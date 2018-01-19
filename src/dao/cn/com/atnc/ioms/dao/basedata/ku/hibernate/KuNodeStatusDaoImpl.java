/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:46:54
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.ku.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusDao;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;
import cn.com.atnc.ioms.model.operstat.ku.KuBureauStatModel;
import cn.com.atnc.ioms.model.operstat.ku.KuBureauStatQueryModel;
import cn.com.atnc.ioms.model.operstat.ku.KuStatusQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:46:54
 * @version:1.0
 */
@Repository("KuNodeStatusDao")
public class KuNodeStatusDaoImpl extends MyBaseDao<KuNodeStatus> implements
		IKuNodeStatusDao {

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusDao#getLastestList()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<KuNodeStatus> getLastestList() {
		// TODO Auto-generated method stub
		String hql = "from KuNodeStatus "
				+ "where kuNodeStatusStat.id in "
				+ "(select id from KuNodeStatusStat"
				+ " where statDate in (select max(statDate) from KuNodeStatusStat))";
		return (List<KuNodeStatus>) super.queryList(hql);
	}
	
	@SuppressWarnings("unchecked")
	public List<KuNodeStatus> findByKuNodeId(KuStatusQueryModel qm) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder hql = new StringBuilder("from KuNodeStatus where 1=1");
		hql.append("and kuNode.id = :id");
		params.put("id", qm.getKuNodeId());
		return (List<KuNodeStatus>) super.queryList(hql.toString(), params);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @throws ServiceException
	 * 
	 * @see cn.com.atnc.pcsp.dao.basedata.ku.IKuNodeStatusDao#pageQuery(cn.com.atnc.pcsp.model.operstat.ku.KuStatusQueryModel)
	 */
	@Override
	public Pagination queryPage(KuStatusQueryModel qm) throws ServiceException {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder("from KuNodeStatus where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (StringTools.hasText(qm.getKuNodeStatusStatId())) {
			hql.append(" and kuNodeStatusStat.id = ?");
			params.add(qm.getKuNodeStatusStatId());
		}

		if (StringTools.hasText(qm.getKuNodeNoLike())) {
			hql.append(" and kuNodeNo like ?");
			try {
				params.add(Integer.parseInt(qm.getKuNodeNoLike()));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new ServiceException("节点号请输入整数" + e.getMessage());
			}
		}

		if (StringTools.hasText(qm.getClientId())) {
			hql.append(" and kuNode.equip.id in (select equip.id from ClientEquip where client.id=?)");
			params.add(qm.getClientId());
		}
		if (StringTools.hasText(qm.getBureauQM())) {
			hql.append(" and kuNode.equip.bureau like ?)");
			params.add(qm.getBureauQM());
		}
		if (StringTools.hasText(qm.getSiteNameQM())) {
			hql.append(" and kuNode.equip.satellite.siteName like ?)");
			params.add(qm.getSiteNameQM());
		}
		if (StringTools.hasText(qm.getKuStatusStandardQM())) {
			hql.append(" and status = ?");
			params.add(qm.getKuStatusStandardQM());
		}

		if (StringTools.hasText(qm.getKuEbNoTopQM())) {
			hql.append(" and ebno <= ?");
			try {
				params.add(new BigDecimal(qm.getKuEbNoTopQM()));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new ServiceException("Eb/No请输入浮点数" + e.getMessage());
			}
		}
		if (StringTools.hasText(qm.getKuEbNoLowQM())) {
			hql.append(" and ebno >= ?");
			try {
				params.add(new BigDecimal(qm.getKuEbNoLowQM()));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new ServiceException("Eb/No请输入浮点数" + e.getMessage());
			}
		}

		if (StringTools.hasText(qm.getKuRxLevelLowQM())) {
			hql.append(" and rxLevel >= ?");
			try {
				params.add(new BigDecimal(qm.getKuRxLevelLowQM()));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new ServiceException("RxLevel请输入浮点数" + e.getMessage());
			}
		}

		if (StringTools.hasText(qm.getKuRxLevelTopQM())) {
			hql.append(" and rxLevel <= ?");
			try {
				params.add(new BigDecimal(qm.getKuRxLevelTopQM()));
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new ServiceException("RxLevel请输入浮点数" + e.getMessage());
			}
		}
		String countHql = COUNT_ID + hql.toString();
		hql.append(" order by kuNodeNo asc");
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				qm.getPageNo(), qm.getPageSize());

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.dao.basedata.ku.IKuNodeStatusDao#getLatestStat()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<KuBureauStatModel> getLatestStat(KuBureauStatQueryModel qm) {
		// TODO Auto-generated method stub
		StringBuilder hql = new StringBuilder(
				"select new cn.com.atnc.ioms.model.operstat.ku.KuBureauStatModel(equip.bureau,count(*)) "
						+ "from KuNodeStatus status,KuNode node,Equip equip "
						+ "where  status.kuNode.id=node.id and node.equip.id=equip.id ");
		List<Object> params = new ArrayList<Object>();
		if (StringTools.hasText(qm.getKuStatusStatId())) {
			hql.append(" and status.kuNodeStatusStat.id=?");
			params.add(qm.getKuStatusStatId());
		}
		if (qm.getKuEbNoTopLimit() != null) {
			hql.append(" and status.ebno > ?");
			params.add(new BigDecimal(qm.getKuEbNoTopLimit()));
		}
		if (StringTools.hasText(qm.getKuNetworkStatusStandard())) {
			hql.append(" and status.status != ?");
			params.add(qm.getKuNetworkStatusStandard().toUpperCase());
		}
		if (qm.getKuRxLevelLowerLimit() != null
				&& qm.getKuRxLevelTopLimit() != null) {
			hql.append(" and (status.rxLevel < ? or status.rxLevel > ?)");
			params.add(new BigDecimal(qm.getKuRxLevelLowerLimit()));
			params.add(new BigDecimal(qm.getKuRxLevelTopLimit()));
		} else {
			if (qm.getKuRxLevelLowerLimit() != null) {
				hql.append(" and status.rxLevel < ?");
				params.add(new BigDecimal(qm.getKuRxLevelLowerLimit()));
			}
			if (qm.getKuRxLevelTopLimit() != null) {
				hql.append(" and status.rxLevel > ?");
				params.add(new BigDecimal(qm.getKuRxLevelTopLimit()));
			}
		}
		hql.append(" group by equip.bureau");
		return (List<KuBureauStatModel>) super.queryList(hql.toString(),
				params.toArray());
	}
}
