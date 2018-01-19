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
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IOduPollingDao;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.OduPolling;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.OduPollingInfoManager;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;

 /**
 * 此处添加类KuCarrierFreqManagerImpl的描述信息
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午3:03:24
 * @since 1.0.0
 */
@Service("oduPollingInfoManager")
public class OduPollingInfoManagerImpl extends AbstractService implements
        OduPollingInfoManager {
	
	@Autowired
    private IOduPollingDao oduPollingDao;

	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		return oduPollingDao.queryPage(queryModel);
	}

	@Override
	public OduPolling findById(String id) {
		return oduPollingDao.findById(id);
	}

	@Override
	public List<OduPolling> findByMaintainEquip(List<MaintainEquip> modems) {
		List<OduPolling> oduPollings = oduPollingDao.findByMaintainEquip(modems);
		if(!CollectionUtils.isEmpty(oduPollings)) {
			if (oduPollings.size() == 1) {
				return oduPollings;
			} else {
				List<OduPolling> results = new ArrayList<OduPolling>();
				// 记录相同信息的最后一个的位置
				int index = 0;
				for (int i = 0; i < oduPollings.size(); i++) {
					// 判断如果index==i的话，则跳过，继续比较下一个
					if (index > i && i != 0) {
						continue;
					}
					// 比较最后一个和前一个是否相同，如果相同则跳过，不同则添加到recordTimes中
					if (i == oduPollings.size() - 1) {
						if (StringUtils
								.equalsIgnoreCase(oduPollings.get(i - 1)
										.getEquipId().getId(), oduPollings
										.get(i).getEquipId().getId())) {
							break;
						} else {
							results.add(oduPollings.get(i));
						}
					}
					OduPolling info1 = oduPollings.get(i);
					// 设备ID
					String euipId1 = info1.getEquipId().getId();
					for (int j = i + 1; j < oduPollings.size(); j++) {
						OduPolling info2 = oduPollings.get(j);
						// 设备ID
						String euipId2 = info2.getEquipId().getId();
						// 如果相同，则继续比较下一个
						if (StringUtils.equalsIgnoreCase(euipId1, euipId2)) {
							if (j == oduPollings.size() - 1) {
								index = j;
							}
							continue;
						}
						// 如果不同，则记录角标位置
						index = j;
						break;
					}
					results.add(oduPollings.get(i));
				}
				return results;
			}
		}
		return oduPollings;
	}

}
