package cn.com.atnc.ioms.mng.basedata.atm.node;

/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:46:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */



import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Vector;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.FileUploadModel;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;

/**
 * 数据管理--Atm节点管理
 * 
 * @author:xiongzhikang
 * @date:2014-4-11 上午10:46:39
 * @version:1.0
 */

public interface IAtmNodeManager {
	
	public AtmNode add(AtmNode node) throws ServiceException;

	
	public AtmNode update(AtmNode node) throws ServiceException;

	
	public AtmNode findById(String id);

	
	public String delete(String id) throws ServiceException;


	public Pagination queryPage(AtmNodeQueryModel model);
	
	
	public List<AtmNode> queryList(AtmNodeQueryModel model);

	
	public Long querySize(AtmNodeQueryModel model) throws UnsupportedEncodingException;

	
	public Vector<Vector<String>> doExcelImport(
			FileUploadModel fileUploadModel, User user) throws ServiceException;

	
	public Workbook exportExcel(AtmNodeQueryModel queryModel, File template) throws IOException,
			InvalidFormatException;
}
