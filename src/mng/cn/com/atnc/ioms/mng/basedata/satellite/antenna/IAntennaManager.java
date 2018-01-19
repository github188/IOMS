package cn.com.atnc.ioms.mng.basedata.satellite.antenna;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.basedata.antenna.Antenna;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;

/**
 * @author 何月娇
 *
 */
public interface IAntennaManager {
	public Antenna findById(String id);
	public Pagination queryPage(AntennaQueryModel model);	
	public Long querySize(AntennaQueryModel model);		
	public Workbook exportExcel(File template, AntennaQueryModel queryModel)  throws IOException, InvalidFormatException;
	public Antenna update(Antenna antenna) throws ServiceException;
}
