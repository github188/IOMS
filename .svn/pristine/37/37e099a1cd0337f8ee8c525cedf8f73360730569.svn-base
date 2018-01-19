/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:50:11
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.maintain.equipmobile.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.maintain.equipmobile.IKuMobileDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.maintain.equipmobile.KuMobile;
import cn.com.atnc.ioms.enums.clientnotice.NoticeFlag;
import cn.com.atnc.ioms.mng.maintain.equipmobile.IKuMobileManager;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileModel;
import cn.com.atnc.ioms.model.maintain.equipmobile.KuMobileQueryModel;

/**
 * 设备绑定发短信手机号 服务层接口实现类
 *
 * @author 段衍林
 * @2016年11月22日 上午10:00:45
 */
@Service("KuMobileManager")
public class KuMobileManagerImpl extends AbstractService implements
		IKuMobileManager {

	@Autowired
	private IKuMobileDao kuMobileDao;
	@Autowired
	private IEquipDao equipDao;

	/**
	 * 设备手机号绑定
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午9:57:28
	 * @param model
	 * @throws ServiceException
	 *             void
	 */
	public void save(KuMobileModel model) {
		// 封装查询条件
		KuMobileQueryModel queryModel = new KuMobileQueryModel();
		// 设置查询equipid
		queryModel.setEquipId(model.getEquipId());
		// 列表查询
		List<KuMobile> kuMobiles = this.queryList(queryModel);
		// 先清空数据，后保存
		if (CollectionUtils.isNotEmpty(kuMobiles)) {
			kuMobileDao.deleteList(kuMobiles);
		}
		// 设备id
		String equipId = model.getEquipId();
		// 非空验证
		if (StringUtils.isEmpty(equipId)) {
			return;
		}
		Equip equip = equipDao.findById(equipId);
		// 源数据
		String info = model.getInfos();
		if (StringUtils.isNotEmpty(info)) {
			// 分解数据组
			String[] userMobiles = info.split(";");
			for (String str : userMobiles) {
				// 解析每组数据
				String[] userMobile = str.split(",");
				// 数组验证
				if (userMobile.length != 3) {
					continue;
				}
				// 用户名
				String name = userMobile[0];
				// 绑定手机号
				String mobile = userMobile[1];
				// 是否发送短信
				NoticeFlag flag = NoticeFlag.valueOf(userMobile[2]);
				// 声明实体
				KuMobile kuMobile = new KuMobile();
				// 赋值
				kuMobile.setEquip(equip);
				kuMobile.setName(name);
				kuMobile.setMobile(mobile);
				kuMobile.setSendmsgFlag(flag);
				kuMobileDao.save(kuMobile);
			}
		}
	}

	/**
	 * 更新设备手机号绑定
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午9:57:59
	 * @param model
	 * @throws ServiceException
	 *             void
	 */
	public void update(KuMobileModel model) {
		// 封装查询条件
		KuMobileQueryModel queryModel = new KuMobileQueryModel();
		// 设置查询equipid
		queryModel.setEquipId(model.getEquipId());
		// 列表查询
		List<KuMobile> kuMobiles = this.queryList(queryModel);
		// 先清空数据，后保存
		if (CollectionUtils.isNotEmpty(kuMobiles)) {
			kuMobileDao.deleteList(kuMobiles);
		}
		// 重新保存
		this.save(model);
	}

	/**
	 * 设备绑定手机号列表查询
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午9:59:08
	 * @param model
	 * @return List<KuMobile>
	 */
	public List<KuMobile> queryList(KuMobileQueryModel queryModel) {
		return kuMobileDao.queryList(queryModel);
	}
}
