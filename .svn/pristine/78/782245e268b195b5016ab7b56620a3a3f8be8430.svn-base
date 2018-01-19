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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.mng.maintain.pollinginfo.KuCarrierFreqManager;
import cn.com.atnc.ioms.model.maintain.pollinginfo.PollingInfoQueryModel;
import cn.com.atnc.ioms.dao.maintain.pollinginfo.IKuCarrierFreqDao;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuCarrierFreq;

 /**
 * 此处添加类KuCarrierFreqManagerImpl的描述信息
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午3:03:24
 * @since 1.0.0
 */
@Service("kuCarrierFreqManager")
public class KuCarrierFreqManagerImpl extends AbstractService implements
        KuCarrierFreqManager {
	
	@Autowired
    private IKuCarrierFreqDao kuCarrierFreqDao;

	@Override
	public Pagination queryPage(PollingInfoQueryModel queryModel) {
		return kuCarrierFreqDao.queryPage(queryModel);
	}
	
	@Override
	public Pagination queryViewPage(PollingInfoQueryModel queryModel) {
		return kuCarrierFreqDao.queryViewPage(queryModel);
	}
	
	@Override
	public List<KuCarrierFreq> findAll() {
		return kuCarrierFreqDao.findAll();
	}

	@Override
	public void update(KuCarrierFreq kuCarrierFreq) throws ServiceException {
		kuCarrierFreqDao.update(kuCarrierFreq);
	}

	@Override
	public List<Long> queryEquip() throws ServiceException {
		return kuCarrierFreqDao.queryEquip();
	}

	@Override
	public List<KuCarrierFreq> getKCFList(List<KuCarrierFreq> kcfli) {
		List<KuCarrierFreq> kcfli2 = new ArrayList<>();
		if(kcfli.size()>0){
			kcfli2.add(kcfli.get(0));
			for(int i=0;i<kcfli.size();i++){
				KuCarrierFreq kuCarrierFreq = new KuCarrierFreq();
				kuCarrierFreq = kcfli.get(i);
				for(int j= kcfli2.size()-1;j>=0;j--){
					int num = 0;
					if(kcfli2.get(j).getEquipId().getId().equals(kuCarrierFreq.getEquipId().getId()) == false){
						num++;
					}
					if(num==kcfli2.size()){
						kcfli2.add(kuCarrierFreq);
					}
				}
			}
		}
		return kcfli2;
	}

}
