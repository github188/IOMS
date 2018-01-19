package cn.com.atnc.ioms.dao.basedata.atm.service;

/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:02:18
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */


import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.atm.service.AtmService;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;
import cn.com.atnc.ioms.model.operstat.atm.NetworkStatQueryModel;

/**
 * 
 * @author:xiongzhikang
 * @date:2014-4-22 上午10:05:09
 * @version:1.0
 */

public interface IAtmServiceDao extends IBaseDao<AtmService> {

	public Pagination queryPage(AtmServiceQueryModel queryModel);

	public Long querySize(AtmServiceQueryModel model);
	
	//public List<AtmServiceRunInfo> find(AtmServiceQueryModel queryModel);

	public List<AtmService> queryList(AtmServiceQueryModel queryModel);
	
	public Long queryDeleteNodeSize(AtmServiceQueryModel queryModel);
	
	public Pagination queryServiceDetailPageByModel(AtmServiceQueryModel queryModel);
}
