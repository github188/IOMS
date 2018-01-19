package cn.com.atnc.ioms.mng.basedata.satellite.attenuator;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.attenuator.Attenuator;
import cn.com.atnc.ioms.model.basedata.satellite.AttenuatorQueryModel;

public interface IAttenuatorManager {
	public Attenuator findById(String id);
	public Pagination queryPage(AttenuatorQueryModel model);	
	public Long querySize(AttenuatorQueryModel model);		
	public Workbook exportExcel(File template) throws IOException, 	InvalidFormatException;
	public Workbook exportExcel(File template, AttenuatorQueryModel queryModel) 			throws IOException, InvalidFormatException;
}
