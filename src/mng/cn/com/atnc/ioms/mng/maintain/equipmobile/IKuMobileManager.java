/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:46:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.maintain.equipmobile;

import java.util.List;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileModel;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;

/**
 * 设备绑定发短信手机号 
 * 服务层接口
 *
 * @author 段衍林
 * @2016年11月22日 上午9:51:56
 */
public interface IKuMobileManager {

	/**
	 * 设备手机号绑定
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午9:57:28
	 * @param model
	 * @throws ServiceException
	 *             void
	 */
	public void save(KuMobileModel model) throws ServiceException;

	/**
	 * 更新设备手机号绑定
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午9:57:59
	 * @param model
	 * @throws ServiceException
	 *             void
	 */
	public void update(KuMobileModel model) throws ServiceException;

	/**
	 * 设备绑定手机号列表查询
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午9:59:08
	 * @param model
	 * @return List<KuMobile>
	 */
	public List<KuMobile> queryList(KuMobileQueryModel model);
}
