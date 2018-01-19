package cn.com.atnc.ioms.mng.operstat.atm;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.operstat.atm.CardRunInfo;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardRunInfoModel;

/**
 * 数据管理-ATM板卡管理Service接口 
 * 
 * @author Chenwei
 * @date 2014-8-26 上午10:39:47
 * @version 1.0
 */

public interface IAtmCardRunInfoService {

	public CardRunInfo findById(String id);

	public Pagination queryPage(AtmCardRunInfoModel model);

	public List<CardRunInfo> queryList(AtmCardRunInfoModel model);
	
	public List<CardRunInfo> atmCardList(AtmCardRunInfoModel model);

	public Long querySize(AtmCardRunInfoModel model)
			throws UnsupportedEncodingException;

	public Workbook exportExcel(AtmCardRunInfoModel queryModel, File template)
			throws IOException, InvalidFormatException;

}
