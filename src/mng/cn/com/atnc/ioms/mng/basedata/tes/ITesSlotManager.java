/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:46:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.basedata.tes;

import java.util.List;
import java.util.Vector;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.model.FileUploadModel;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.model.basedata.tes.TesSlotQueryModel;



public interface ITesSlotManager {

	public TesSlot add(TesSlot node) throws ServiceException;

	public TesSlot update(TesSlot node) throws ServiceException;


	public TesSlot findById(String id);
	public String delete(String id) throws ServiceException;
	public String deleteByTesNode(TesNode tesnode) throws ServiceException;
	
	public Pagination queryPage(TesSlotQueryModel model);
	
	
	public List<TesSlot> queryList(TesSlotQueryModel model);
	
	public List<TesSlot> queryListByTesNode(TesNode tesnode);
	
	

	public Long querySize(TesSlotQueryModel model);


	public Vector<Vector<String>> doExcelImport(
			FileUploadModel fileModel, User user) throws ServiceException;
	
	public List<TesSlot> queryListByParam(TesSlotQueryModel queryModel);
	
	

}
