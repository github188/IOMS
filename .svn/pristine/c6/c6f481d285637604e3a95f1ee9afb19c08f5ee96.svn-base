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
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;



public interface ITesNodeManager {
	
	public TesNode add(TesNode node) throws ServiceException;

	public TesNode update(TesNode node) throws ServiceException;

	
	public TesNode findById(String id);

	
	public String delete(String id) throws ServiceException;

	
	public Pagination queryPage(TesNodeQueryModel model);
	
	
	public List<TesNode> queryList(TesNodeQueryModel model);

	
	public Long querySize(TesNodeQueryModel model);

	
	public Vector<Vector<String>> doExcelImport(
			FileUploadModel fileUploadModel, User user) throws ServiceException;

	
	public Workbook exportExcel(File template,TesNodeQueryModel queryModel) throws IOException,
			InvalidFormatException;
	
	
	public List<TesNode> queryListByParam(TesNodeQueryModel queryModel);
}
