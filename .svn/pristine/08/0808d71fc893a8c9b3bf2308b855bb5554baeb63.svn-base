/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:04:49
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.maintain.equipmobile.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.equipmobile.IKuMobileDao;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;

/**
 * 设备绑定数据库 接口实现类
 *
 * @author 段衍林
 * @2016年11月22日 上午9:47:01
 */
@Repository("kuMobileDao")
public class KuMobileDaoImpl extends MyBaseDao<KuMobile> implements
		IKuMobileDao {

	/**
	 * 列表查询
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午9:47:18
	 * @param queryModel
	 * @return List<KuNode>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<KuMobile> queryList(KuMobileQueryModel queryModel) {

		StringBuilder hql = new StringBuilder("from KuMobile where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		// 设备查询
		if (StringUtils.isNotEmpty(queryModel.getEquipId())) {
			// 设备id查询
			hql.append(" and equip.id=:equipId");
			params.put("equipId", queryModel.getEquipId());
		}
		// 发送短信标记
		if (!ObjectUtils.equals(queryModel.getFlag(), null)) {
			hql.append(" and sendmsgFlag=:flag");
			params.put("flag", queryModel.getFlag());
		}
		hql.append(" order by id ");
		// 列表查询
		return (List<KuMobile>) super.queryList(hql.toString(), params);
	}
}
