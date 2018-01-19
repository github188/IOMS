/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:02:18
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.maintain.equipmobile;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;

/**
 * 设备绑定数据库 接口
 *
 * @author 段衍林
 * @2016年11月22日 上午9:41:49
 */

public interface IKuMobileDao extends IBaseDao<KuMobile> {

	/**
	 * 列表查询
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午9:47:27
	 * @param queryModel
	 * @return List<KuMobile>
	 */
	public List<KuMobile> queryList(KuMobileQueryModel queryModel);
}
