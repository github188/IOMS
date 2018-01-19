package cn.com.atnc.ioms.dao.business.evaluate.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.evaluate.IApplyEvaluateDao;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.evaluate.ApplyEvaluate;

 /**
 * 用户评价Dao接口实现类
 *
 * @author Wang zhicheng
 * @date 2015年5月22日 上午9:46:57
 * @since 1.0.0
 */
@Repository
public class ApplyEvaluateDaoImpl extends MyBaseDao<ApplyEvaluate> implements
              IApplyEvaluateDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ApplyEvaluate> queryList(ApplyBaseInfo applyBaseInfo) {
		StringBuffer hql = new StringBuffer(" from ApplyEvaluate where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if (!StringUtils.isEmpty(applyBaseInfo.getId())) {
			hql.append(" and applyBaseInfo.id = ?");
			params.add(applyBaseInfo.getId());
		}
		return (List<ApplyEvaluate>) super.queryList(hql.toString(),
				params.toArray());
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.dao.business.evaluate.IApplyEvaluateDao#physicalDelByApplyBaseInfoId(java.lang.String)
	 */
	@Override
	public void physicalDelByApplyBaseInfoId(String id) {
		this.executeHql("delete from ApplyEvaluate where applyBaseInfo.id = ?", id);
	}

}
