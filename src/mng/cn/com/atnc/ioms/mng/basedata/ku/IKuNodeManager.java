/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-24 上午10:46:39
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.basedata.ku;

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
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.model.basedata.ku.KuNodeQueryModel;

/**
 * 数据管理--Ku节点管理
 * 
 * @author:HuangYijie
 * @date:2014-3-24 上午10:46:39
 * @version:1.0
 */

public interface IKuNodeManager {
	/**
	 * 添加一个ku节点
	 * 
	 * @author:HuangYijie
	 * @param KuNode
	 * @return
	 */
	public KuNode add(KuNode node) throws ServiceException;

	/**
	 * 更新ku节点信息
	 * 
	 * @author:HuangYijie
	 * @param KuNode
	 */
	public KuNode update(KuNode node) throws ServiceException;

	/**
	 * 根据id查找对应的记录
	 * 
	 * @author:HuangYijie
	 * @param id
	 * @return
	 */
	public KuNode findById(String id);

	/**
	 * 删除ku节点信息
	 * 
	 * @author:HuangYijie
	 * @param roleId
	 * @throws ManagerException
	 */
	public String delete(String id) throws ServiceException;

	/**
	 * 分页查询
	 * 
	 * @author:HuangYijie
	 * 
	 * @param model
	 * @return Pagination
	 */
	public Pagination queryPage(KuNodeQueryModel model);
	
	
	public List<KuNode> queryList(KuNodeQueryModel model);

	/**
	 * 查询符合条件的记录数
	 * 
	 * @author:HuangYijie
	 * @Date:2014-3-28 下午2:35:24
	 * 
	 * @param model
	 * @return Long
	 */
	public Long querySize(KuNodeQueryModel model);

	/**
	 * 导入Excel文件
	 * 
	 * @author:HuangYijie
	 * @Date:2014-3-28 下午2:35:34
	 * 
	 * @param fileUploadModel
	 * @param user
	 * @return
	 * @throws ServiceException
	 *             Vector<Vector<String>>
	 */
	public Vector<Vector<String>> doExcelImport(
			FileUploadModel fileUploadModel, User user) throws ServiceException;

	/**
	 * 导出excel文件
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-1 下午2:21:12
	 * 
	 * @param template
	 * @return
	 * @throws IOException
	 * @throws InvalidFormatException
	 *             Workbook
	 */
	public Workbook exportExcel(File template,KuNodeQueryModel queryModel) throws IOException,
			InvalidFormatException;
}
