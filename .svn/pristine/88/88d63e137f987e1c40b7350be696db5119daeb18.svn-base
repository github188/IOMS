/**
 * @ProjectName IOMS
 * @FileName LinkAlarmManagerImpl.java
 * @PackageName:cn.com.atnc.ioms.mng.basedata.alarm
 * @author KuYonggang
 * @date 2015年3月27日下午5:17:45
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.maintain.pollinginfo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuNodeInfoDao;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeInfo;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.KuNodeInfoManager;

/**
 * 节点信息业务实现类
 * 
 * @author 王凌斌
 * @2017年1月22日 下午1:10:18
 */
@Service("KuNodeInfoManager")
public class KuNodeInfoManagerImpl extends AbstractService implements
		KuNodeInfoManager {

	@Autowired
	private IKuNodeInfoDao kuNodeInfoDao;

	@Override
	public List<KuNodeInfo> findByMaintainEquip(
			List<MaintainEquip> maintainEquips) {
		List<KuNodeInfo> kuNodeInfos = kuNodeInfoDao
				.findByMaintainEquip(maintainEquips);
		if (!CollectionUtils.isEmpty(kuNodeInfos)) {
			if (kuNodeInfos.size() == 1) {
				return kuNodeInfos;
			} else {
				List<KuNodeInfo> results = new ArrayList<KuNodeInfo>();
				// 记录相同信息的最后一个的位置
				int index = 0;
				for (int i = 0; i < kuNodeInfos.size(); i++) {
					// 判断如果index==i的话，则跳过，继续比较下一个
					if (index > i && i != 0) {
						continue;
					}
					// 比较最后一个和前一个是否相同，如果相同则跳过，不同则添加到recordTimes中
					if (i == kuNodeInfos.size() - 1) {
						if (StringUtils.equalsIgnoreCase(kuNodeInfos.get(i - 1)
								.getEquipId().getId(), kuNodeInfos.get(i)
								.getEquipId().getId())) {
							break;
						} else {
							results.add(kuNodeInfos.get(i));
						}
					}
					KuNodeInfo info1 = kuNodeInfos.get(i);
					// 设备ID
					String euipId1 = info1.getEquipId().getId();
					for (int j = i + 1; j < kuNodeInfos.size(); j++) {
						KuNodeInfo info2 = kuNodeInfos.get(j);
						// 设备ID
						String euipId2 = info2.getEquipId().getId();
						// 如果相同，则继续比较下一个
						if (StringUtils.equalsIgnoreCase(euipId1, euipId2)) {
							if (j == kuNodeInfos.size() - 1) {
								index = j;
							}
							continue;
						}
						// 如果不同，则记录角标位置
						index = j;
						break;
					}
					results.add(kuNodeInfos.get(i));
				}
				return results;
			}
		}
		return kuNodeInfos;
	}

	@Override
	public List<KuNodeInfo> findByMaintainEquip(MaintainEquip maintainEquip,
			Date date) {
		return kuNodeInfoDao.findByMaintainEquip(maintainEquip, date);
	}

}
