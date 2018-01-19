package cn.com.atnc.ioms.mng.basedata.satellite.odu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.basedata.odu.IOduDao;
import cn.com.atnc.ioms.entity.basedata.odu.Odu;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

@Service("OduManager")
public class OduManagerImpl extends AbstractService implements IOduManager {

	@Autowired
	private IOduDao OduDao;

	@Override
	public Odu findById(String id) {
		return OduDao.findById(id);
	}

	@Override
	public Pagination queryPage(OduQueryModel model) {
		// TODO Auto-generated method stub
		return OduDao.queryPage(model);
	}

	@Override
	public Long querySize(OduQueryModel model) {
		// TODO Auto-generated method stub
		return OduDao.querySize(model);
	}

	@Override
	@Transactional(rollbackFor = { IOException.class, ServiceException.class })
	public Workbook exportExcel(File template, OduQueryModel queryModel)
			throws IOException, InvalidFormatException {
		List<Odu> os = OduDao.queryList(queryModel);

		/*
		 * if (CollectionUtils.isEmpty(os)) { return null; }
		 */
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己到处抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("ODU统计表");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			titleRow.createCell(0).setCellValue("序号");
			titleRow.createCell(1).setCellValue("站点名称");
			titleRow.createCell(2).setCellValue("站点代码");
			titleRow.createCell(3).setCellValue("所属区域");
			titleRow.createCell(4).setCellValue("ODU类型");
			titleRow.createCell(5).setCellValue("ODU功率");
			titleRow.createCell(6).setCellValue("中频发射固定/可调衰减值");
			titleRow.createCell(7).setCellValue("中频接收固定/可调衰减值");
			titleRow.createCell(8).setCellValue("发射增益/衰减");
			titleRow.createCell(9).setCellValue("接收增益/衰减");
			titleRow.createCell(10).setCellValue("备注");
		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(os)) {
				sheet = wb.getSheetAt(0);
			}
		}
		if (CollectionUtils.isEmpty(os)) {
			return wb;
		}

		for (int i = 0; i < os.size(); i++) {
			Row row = sheet.createRow(i + 1);
			// 给这一行的第一列赋值
			int j = 0;
			row.createCell(j++).setCellValue(i + 1);
			// 站名

			row.createCell(j++).setCellValue(
					os.get(i).getSite() == null ? "" : os.get(i).getSite()
							.getSiteName());
			row.createCell(j++).setCellValue(
					os.get(i).getSite() == null ? "" : os.get(i).getSite()
							.getSiteCode());

			row.createCell(j++).setCellValue(
					os.get(i).getSite() == null ? "" : os.get(i).getSite()
							.getBureau().toString());

			/*
			 * row.createCell(j++).setCellValue( os.get(i).getAntenna() == null
			 * ? "" : (os.get(i) .getAntenna().getAntennaCode()== null ? "" : os
			 * .get(i).getAntenna().getAntennaCode()));
			 */

			/*
			 * row.createCell(j++).setCellValue( os.get(i).getOduName() == null
			 * ? "":os.get(i).getOduName().toString());
			 */
			row.createCell(j++).setCellValue(
					os.get(i).getOduType() == null ? "" : os.get(i)
							.getOduType().toString());

			row.createCell(j++).setCellValue(
					os.get(i).getOduPower() == null ? "" : os.get(i)
							.getOduPower().toString());

			row.createCell(j++).setCellValue(
					os.get(i).getLanchMidFreq() == null ? "" : os.get(i)
							.getLanchMidFreq().toString());

			row.createCell(j++).setCellValue(
					os.get(i).getReceiveMidMinus() == null ? "" : os.get(i)
							.getReceiveMidMinus().toString());

			row.createCell(j++).setCellValue(
					os.get(i).getLanchPlusMinus() == null ? "" : os.get(i)
							.getLanchPlusMinus().toString());

			row.createCell(j++).setCellValue(
					os.get(i).getReceivePlusMinus() == null ? "" : os.get(i)
							.getReceivePlusMinus().toString());

			row.createCell(j++).setCellValue(
					os.get(i).getInfo() == null ? "" : os.get(i).getInfo());
		}
		return wb;
	}

}
