package cn.com.atnc.ioms.mng.basedata.tes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.FileUploadModel;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.tes.TesTele;
import cn.com.atnc.ioms.model.basedata.tes.TesTeleQueryModel;

public interface ITesTeleManager {	
	public TesTele add(TesTele node) throws ServiceException;
	public TesTele update(TesTele node) throws ServiceException;
	public TesTele findById(String id);
	public String delete(String id) throws ServiceException;
	public Pagination queryPage(TesTeleQueryModel model);

	public List<TesTele> queryList(TesTeleQueryModel model);
	public Long querySize(TesTeleQueryModel model);
	
	public Workbook exportExcel(File template,TesTeleQueryModel queryModel) throws IOException,
	InvalidFormatException;
	
	public Vector<Vector<String>> doExcelImport(
			FileUploadModel fileModel, User user) throws ServiceException;
}