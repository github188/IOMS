package cn.com.atnc.ioms.mng.basedata.atm.service;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.basedata.atm.service.AtmService;
import cn.com.atnc.ioms.entity.operstat.atm.AtmServiceRunInfo;
import cn.com.atnc.ioms.model.basedata.atm.service.AtmServiceQueryModel;


public interface IAtmServiceManager {
	
public AtmService findById(String id);

//public List<AtmServiceRunInfo> find(AtmServiceQueryModel model);

public AtmService updateService(AtmService service);

public Pagination queryPage(AtmServiceQueryModel model);

public Long querySize(AtmServiceQueryModel model);

public Workbook exportExcel(AtmServiceQueryModel queryModel, File template) throws IOException,
			InvalidFormatException,ServiceException;
	
public List<AtmService> queryList(AtmServiceQueryModel model);

}
