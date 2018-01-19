package cn.com.atnc.ioms.mng.basedata.satellite.antenna;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.dao.basedata.antenna.IAntennaDao;
import cn.com.atnc.ioms.dao.basedata.equip.IEquipDao;
import cn.com.atnc.ioms.dao.basedata.satellite.ISatelliteSiteDao;
import cn.com.atnc.ioms.dao.clientmng.IClientDao;
import cn.com.atnc.ioms.entity.basedata.antenna.Antenna;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;

@Service("AntennaManager")
public class AntennaManagerImpl implements IAntennaManager {

	@Autowired
	private IAntennaDao antennaDao;
	@Autowired
	private IEquipDao equipDao;
	@Autowired
	private ISatelliteSiteDao siteDao;

	@Autowired
	private IClientDao clientDao;

	@Override
	public Antenna findById(String id) {
		// TODO Auto-generated method stub
		Antenna antenna = antennaDao.findById(id);
		if (antenna.getSite() == null) {
			return antenna;
		}
		if (antenna.getClient() == null) {
			return antenna;
		}
		// antenna.setSiteCode(antenna.getSite().getSiteCode());
		antenna.setSiteId(antenna.getSite().getId());
		antenna.setClientId(antenna.getClient().getId());
		return antenna;
	}

	@Override
	public Pagination queryPage(AntennaQueryModel model) {
		// TODO Auto-generated method stub
		return antennaDao.queryPage(model);
	}

	@Override
	public Long querySize(AntennaQueryModel model) {
		// TODO Auto-generated method stub
		return antennaDao.querySize(model);
	}

	@Override
	@Transactional(rollbackFor = { IOException.class, ServiceException.class })
	public Workbook exportExcel(File template, AntennaQueryModel queryModel)
			throws IOException, InvalidFormatException {
		// TODO Auto-generated method stub
		List<Antenna> os = antennaDao.queryList(queryModel);
		/*
		 * if (CollectionUtils.isEmpty(os)) { return null; }
		 */
		Workbook wb = null;
		Sheet sheet = null;
		// 判断模板是否存在
		if (template == null) {
			// 不存在，则自己到处抬头行
			wb = new HSSFWorkbook();
			sheet = wb.createSheet("天线统计表");// 注意获取sheet的方式不一样
			Row titleRow = sheet.createRow(0);
			titleRow.createCell(0).setCellValue("序号");
			titleRow.createCell(1).setCellValue("站点名称");
			titleRow.createCell(2).setCellValue("站点代码");
			titleRow.createCell(3).setCellValue("所属区域");
			// titleRow.createCell(4).setCellValue("天线代码");
			titleRow.createCell(4).setCellValue("天线尺寸");
			titleRow.createCell(5).setCellValue("站点纬度");
			titleRow.createCell(6).setCellValue("站点经度");

			titleRow.createCell(7).setCellValue("方位角(度)");
			titleRow.createCell(8).setCellValue("俯仰角（度）");
			titleRow.createCell(9).setCellValue("备件情况");
			titleRow.createCell(10).setCellValue("天线情况");
			titleRow.createCell(11).setCellValue("海拔");
			titleRow.createCell(12).setCellValue("备注");

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

			int j = 0;
			row.createCell(j++).setCellValue(i + 1);

			row.createCell(j++).setCellValue(
					os.get(i).getSite() == null ? "" : (os.get(i).getSite()
							.getSiteName() == null ? "" : os.get(i).getSite()
							.getSiteName().toString()));
			row.createCell(j++).setCellValue(
					os.get(i).getSite() == null ? "" : (os.get(i).getSite()
							.getSiteCode() == null ? "" : os.get(i).getSite()
							.getSiteCode().toString()));

			row.createCell(j++).setCellValue(
					os.get(i).getSite() == null ? "" : (os.get(i).getSite()
							.getBureau() == null ? "" : os.get(i).getSite()
							.getBureau().toString()));

			/*
			 * row.createCell(j++).setCellValue( os.get(i).getAntennaCode() ==
			 * null ? "" : os.get(i) .getAntennaCode());
			 */

			row.createCell(j++).setCellValue(
					os.get(i).getAntennaSize() == null ? "" : os.get(i)
							.getAntennaSize().toString());

			row.createCell(j++).setCellValue(os.get(i).getLatitude());
			row.createCell(j++).setCellValue(os.get(i).getLongitude());
			row.createCell(j++).setCellValue(
					os.get(i).getPositionAngle() == null ? "" : os.get(i)
							.getPositionAngle().toString());
			row.createCell(j++).setCellValue(
					os.get(i).getPitchingAngle() == null ? "" : os.get(i)
							.getPitchingAngle().toString());

			row.createCell(j++).setCellValue(
					os.get(i).getSpare() == null ? "" : os.get(i).getSpare());
			row.createCell(j++).setCellValue(
					os.get(i).getAntennaDesc() == null ? "" : os.get(i)
							.getAntennaDesc());
			row.createCell(j++).setCellValue(
					os.get(i).getElevation() == null ? "" : os.get(i)
							.getElevation());
			row.createCell(j++).setCellValue(
					os.get(i).getInfo() == null ? "" : os.get(i).getInfo());

		}
		return wb;
	}

	@Override
	@Transactional
	public Antenna update(Antenna antenna) throws ServiceException {
		Antenna antennaInDb=antennaDao.findById(antenna.getId());
		antennaInDb.setInfo(antenna.getInfo());
		antennaInDb.setOptUser(antenna.getOptUser());
		antennaInDb.setOptTime(Calendar.getInstance());
		antennaDao.saveOrUpdate(antennaInDb);
		return antennaInDb;
	}
}
