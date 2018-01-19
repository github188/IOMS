package cn.com.atnc.ioms.mng.basedata.satellite.odu;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.odu.Odu;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;

public interface IOduManager {
	public Odu findById(String id);
	public Pagination queryPage(OduQueryModel model);	
	public Long querySize(OduQueryModel model);		
	public Workbook exportExcel(File template, OduQueryModel queryModel) throws IOException, 	InvalidFormatException;
	//public Workbook exportExcel(File template, AttenuatorQueryModel queryModel) 			throws IOException, InvalidFormatException;
}
