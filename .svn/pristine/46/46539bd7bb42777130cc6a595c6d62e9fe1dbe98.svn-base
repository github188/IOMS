/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:46:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

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
import cn.com.atnc.ioms.entity.basedata.tes.TesService;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;


public interface ITesServiceManager {
	public List<TesService> queryList(TesServiceQueryModel qm);

	public TesService add(TesService service) throws ServiceException;

	
	public TesService update(TesService service) throws ServiceException;

    public TesService updateRemark(TesService service) throws ServiceException ;
	
	public TesService findById(String id);


	public String delete(String id) throws ServiceException;

	public Pagination queryPage(TesServiceQueryModel model);

    public Pagination queryPage(TesStatQueryModel model);

	public Long querySize(TesServiceQueryModel model);


	public Vector<Vector<String>> doExcelImport(
			FileUploadModel fileUploadModel, User user) throws ServiceException;


	public Workbook exportExcel(File template,TesServiceQueryModel queryModel) throws IOException,
			InvalidFormatException;
}
