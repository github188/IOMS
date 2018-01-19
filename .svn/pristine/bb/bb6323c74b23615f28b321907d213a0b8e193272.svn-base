package cn.com.atnc.ioms.mng.basedata.atm.service;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.basedata.atm.service.IAtmServiceDao;
import cn.com.atnc.ioms.entity.basedata.atm.service.AtmService;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;
import cn.com.atnc.ioms.util.ExcelPoiTools;


@Service("AtmServiceManager")
public class AtmServiceManagerImpl extends AbstractService implements
		IAtmServiceManager { 
	@Autowired
	private IAtmServiceDao atmServiceDao;	
	@Override
	public AtmService findById(String id) {
		// TODO Auto-generated method stub
		AtmService service = atmServiceDao.findById(id);
		return service;
	}
	/*@Override
	public List<AtmServiceRunInfo> find(AtmServiceQueryModel model){
		
		return atmServiceDao.find(model);
	}*/
	 public AtmService updateService(AtmService service){
	        this.atmServiceDao.update(service);
	        return service;
	    }
	
	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager#queryPage(cn.com.atnc.ioms.model.basedata.ku.KuServiceQueryModel)
	 */
	@Override
	public Pagination queryPage(AtmServiceQueryModel model) {
		// TODO Auto-generated method stub
		return atmServiceDao.queryPage(model);
	}

	public Long querySize(AtmServiceQueryModel model) {
		return atmServiceDao.querySize(model);
	}
	
	
	//@Override
	//@Transactional(rollbackFor = { IOException.class, ServiceException.class })
	public Workbook exportExcel(AtmServiceQueryModel queryModel, File template) throws IOException,
			InvalidFormatException,ServiceException {
		// 初始化要导出的记录				
		List<AtmService> exportList = atmServiceDao.queryList
				(queryModel == null ? new AtmServiceQueryModel()
				: queryModel);	
		Workbook wb = null;
		Sheet sheet = null;
		if (CollectionUtils.isEmpty(exportList)) {
			return null;
		}
	
		// 判断模板是否存在
		if (template == null) {
			throw new ServiceException("ATMSERVICE模板文件不存在！");
			
		} else {
			// 存在，则直接获取模板中的抬头样式
			wb = ExcelPoiTools.create(new FileInputStream(template));
			if (!CollectionUtils.isEmpty(exportList)) {
				sheet = wb.getSheetAt(0);
			}
			
		}
		if (CollectionUtils.isEmpty(exportList)) {			
			return wb;
		}
		// 将atmService的信息导出
		for (int i = 0; i < exportList.size(); i++) {
			Row row = sheet.createRow(i + 2);
			// 给这一行的第一列赋值
			// 区域
			int columnNo = 0;
			row.createCell(columnNo++).setCellValue(
					i+1);
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getServiceName());			
			if (exportList.get(i).getAtmType() != null) {
				row.createCell(columnNo++).setCellValue(
						exportList.get(i).getAtmType().getServiceType());
			}else{
				row.createCell(columnNo++).setCellValue("");
			}
			
			row.createCell(columnNo++)
					.setCellValue(exportList.get(i).getLocalNodeNameCn());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getLocalPort());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getLocalPortCir());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getLocalPortClockType());//.getLocalPortClockType().getValue());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getLocalPortDLCIVPIVCI());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getLocalConnEquip());
			
			
			row.createCell(columnNo++)
					.setCellValue(exportList.get(i).getRemoteNodeNameCn());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getRemotePort());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getRemotePortCir());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getRemotePortClockType());//.getRemotePortClockType().getValue());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getRemotePortDLCIVPIVCI());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getRemoteConnEquip());
			
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getServiceCir());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getServiceClass());
			if (exportList.get(i).getServiceChangeType() != null) {
				row.createCell(columnNo++).setCellValue(
						exportList.get(i).getServiceChangeType().getValue());
			}else{
				row.createCell(columnNo++).setCellValue("");
			}
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getServiceStandbyInfo());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getServiceMsInfo());
			row.createCell(columnNo++).setCellValue(
					exportList.get(i).getServiceRemark());
			
		}
		return wb;
	}


	@Override
	public List<AtmService> queryList(AtmServiceQueryModel model) {
		// TODO Auto-generated method stub
		return atmServiceDao.queryList(model);
	}
	/*private List<AtmService> initExportList(AtmServiceQueryModel queryModel)
			throws ServiceException {
		// 构造要导出的记录，如果没有选中就导出所有。
		List<AtmService> exportList = atmServiceDao.queryList(queryModel);
		//查询列表为空
		if (ObjectUtils.isEmpty(exportList)) {
			//exportList = articleDao.listArticle();
			return null;
		} else {
			
			if (ObjectUtils.isEmpty(explist)) {
				throw new ServiceException("请选择要导出的记录");
			}
			for (String applyInfo : explist) {
				AtmService atmService = atmServiceDao.findById(applyInfo);
				if (atmService == null) {
					throw new ServiceException("数据库中无相关新闻纪录，id为"
							+ applyInfo);
				}
				exportList.add(atmService);
			}
		}
		if (CollectionUtils.isEmpty(exportList)) {
			throw new ServiceException("请选择要导出的记录");
		}
		return exportList;
	}*/
	
}
