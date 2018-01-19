package cn.com.atnc.ioms.mng.operstat.atm.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.operstat.atm.IAtmCardRunInfoDao;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.operstat.atm.CardRunInfo;
import cn.com.atnc.ioms.mng.operstat.atm.IAtmCardRunInfoService;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmCardRunInfoModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

/**
 * ATM板卡管理Service接口实现 数据管理--ATM板卡管理 板卡运行信息
 * 
 * @author Chenwei
 * @date 2014-8-26 上午10:41:16
 * @version 1.0
 */
@Service
public class AtmCardRunInfoServiceImpl extends AbstractService implements
		IAtmCardRunInfoService {

	@Autowired
	private IAtmCardRunInfoDao atmCardRunInfoDao;

	@Override
	public CardRunInfo findById(String id) {
		// TODO Auto-generated method stub
		CardRunInfo cardRunInfo = atmCardRunInfoDao.findById(id);
		return cardRunInfo;
	}

	@Override
	public Pagination queryPage(AtmCardRunInfoModel model) {
		// TODO Auto-generated method stub
		return atmCardRunInfoDao.queryPage(model);
	}

	@Override
	public List<CardRunInfo> queryList(AtmCardRunInfoModel model) {
		// TODO Auto-generated method stub
		return atmCardRunInfoDao.queryList(model);
	}

	@Override
	public Long querySize(AtmCardRunInfoModel model)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Workbook exportExcel(AtmCardRunInfoModel queryModel, File template)
			throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		List<CardRunInfo> cardRunInfo = atmCardRunInfoDao.queryList(queryModel);
		if (CollectionUtils.isEmpty(cardRunInfo)) {
			return null;
		}
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己制作抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("ATM板卡运行统计表");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			int columnNo = 0;
			titleRow.createCell(columnNo++).setCellValue("区域");
			titleRow.createCell(columnNo++).setCellValue("节点代码");
			titleRow.createCell(columnNo++).setCellValue("slot");
			titleRow.createCell(columnNo++).setCellValue("F/B CardState");
			titleRow.createCell(columnNo++).setCellValue("AlarmStatus");
			titleRow.createCell(columnNo++).setCellValue("FrontType");
			titleRow.createCell(columnNo++).setCellValue("FrontSerial");
			titleRow.createCell(columnNo++).setCellValue("BackUpperType");
			titleRow.createCell(columnNo++).setCellValue("BackUpperSerial");
			titleRow.createCell(columnNo++).setCellValue("BackLowerType");
			titleRow.createCell(columnNo++).setCellValue("BackLowerSerial");
			titleRow.createCell(columnNo++).setCellValue("BackType");
			titleRow.createCell(columnNo++).setCellValue("BackSerial");
			titleRow.createCell(columnNo++).setCellValue("运行时间");
		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(cardRunInfo)) {
				sheet = wb.getSheetAt(0);
			}
		}
		if (CollectionUtils.isEmpty(cardRunInfo)) {
			return wb;
		}
		// 将atmNode的信息导出
		for (int i = 0; i < cardRunInfo.size(); i++) {
			Row row = sheet.createRow(i + 1);
			// 给这一行的第一列赋值
			// 区域
			if (cardRunInfo.get(i).getCard() != null) {
				if (cardRunInfo.get(i).getCard().getNode() != null) {
					row.createCell(0)
							.setCellValue(
									cardRunInfo.get(i).getCard().getNode()
											.getBureau() == null ? ""
											: cardRunInfo.get(i).getCard()
													.getNode().getBureau()
													.getValue());
					row.createCell(1).setCellValue(
							cardRunInfo.get(i).getCard().getNode()
									.getAtmNodeCode() == null ? ""
									: cardRunInfo.get(i).getCard().getNode()
											.getAtmNodeCode());
				}
			}
			row.createCell(2).setCellValue(
					cardRunInfo.get(i).getCardSlot() == null ? "" : cardRunInfo
							.get(i).getCardSlot());
			row.createCell(3).setCellValue(
					cardRunInfo.get(i).getCardFbState() == null ? ""
							: cardRunInfo.get(i).getCardFbState());
			row.createCell(4).setCellValue(
					cardRunInfo.get(i).getCardAlarmStatus() == null ? ""
							: cardRunInfo.get(i).getCardAlarmStatus());
			if (cardRunInfo.get(i).getCard() != null) {
				row.createCell(5)
						.setCellValue(
								cardRunInfo.get(i).getCard().getCardFrontType() == null ? ""
										: cardRunInfo.get(i).getCard()
												.getCardFrontType());
				row.createCell(6)
						.setCellValue(
								cardRunInfo.get(i).getCard()
										.getCardFrontSerial() == null ? ""
										: cardRunInfo.get(i).getCard()
												.getCardFrontSerial());
				row.createCell(7)
						.setCellValue(
								cardRunInfo.get(i).getCard()
										.getCardBackUpperType() == null ? ""
										: cardRunInfo.get(i).getCard()
												.getCardBackUpperType());
				row.createCell(8)
						.setCellValue(
								cardRunInfo.get(i).getCard()
										.getCardBackUpperSerial() == null ? ""
										: cardRunInfo.get(i).getCard()
												.getCardBackUpperSerial());
				row.createCell(9)
						.setCellValue(
								cardRunInfo.get(i).getCard()
										.getCardBackLowerType() == null ? ""
										: cardRunInfo.get(i).getCard()
												.getCardBackLowerType());
				row.createCell(10)
						.setCellValue(
								cardRunInfo.get(i).getCard()
										.getCardBackLowerSerial() == null ? ""
										: cardRunInfo.get(i).getCard()
												.getCardBackLowerSerial());
				row.createCell(11)
						.setCellValue(
								cardRunInfo.get(i).getCard().getCardBackType() == null ? ""
										: cardRunInfo.get(i).getCard()
												.getCardBackType());
				row.createCell(12)
						.setCellValue(
								cardRunInfo.get(i).getCard()
										.getCardBackSerial() == null ? ""
										: cardRunInfo.get(i).getCard()
												.getCardBackSerial());
			}
			row.createCell(13).setCellValue(
					cardRunInfo.get(i).getCardRunTime() == null ? ""
							: cardRunInfo.get(i).getCardRunTime().toString());
		}
		return wb;
	}
	@Override
	public List<CardRunInfo> atmCardList(AtmCardRunInfoModel qm) {
		StringBuilder hql = new StringBuilder(" from CardRunInfo where 1=1");
		List<Object> params = new ArrayList<Object>();
		if (null != qm.getBureau()) {
			hql.append(" and bureau = ?");
			params.add(qm.getBureau());
			System.out.println(qm.getBureau());
		}else{
			System.out.println(qm.getBureau());
		}
		
		return (List<CardRunInfo>) atmCardRunInfoDao.queryList(qm);

	}
}
