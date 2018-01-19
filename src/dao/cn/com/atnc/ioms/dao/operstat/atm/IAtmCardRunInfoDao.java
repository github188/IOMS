package cn.com.atnc.ioms.dao.operstat.atm;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.CardRunInfo;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardRunInfoModel;

/**
 * @author Chenwei
 * @date 2014-8-26 上午11:35:04
 * @version 1.0
 */

public abstract interface IAtmCardRunInfoDao extends IBaseDao<CardRunInfo> {

	Pagination queryPage(AtmCardRunInfoModel qm);

	public List<CardRunInfo> queryList(AtmCardRunInfoModel queryModel);

}
