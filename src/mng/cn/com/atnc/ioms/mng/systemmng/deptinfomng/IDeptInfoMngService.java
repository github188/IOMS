package cn.com.atnc.ioms.mng.systemmng.deptinfomng;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.systemmng.deptinfomng.DeptInfoQueryModel;


public interface IDeptInfoMngService {
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:queryPage
	 * @Description:TODO
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年6月17日 下午4:11:40
	 */
	public Pagination queryPage(DeptInfoQueryModel queryModel);
	
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:save
	 * @Description:添加
	 * @Param:@param deptInfomationMng
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年6月17日 下午4:12:11
	 */
	public String save(DeptInfomationMng deptInfomationMng);
	
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getDeptByType
	 * @Description:根据类别获取部门信息
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<DeptInfomationMng>
	 * @Creatime:2016年6月17日 下午4:19:37
	 */
	public List<DeptInfomationMng> getDeptByType(DeptInfoQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getDeptByParentInfo
	 * @Description:TODO
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<DeptInfomationMng>
	 * @Creatime:2016年6月22日 下午5:13:46
	 */
	public List<DeptInfomationMng> getDeptByParentInfo(DeptInfoQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getUserListByDept
	 * @Description:根据部门信息获取用户列表
	 * @Param:@param user
	 * @Param:@return
	 * @Return:List<User>
	 * @Creatime:2016年6月28日 上午10:52:53
	 */
	public List<User> getUserListByDept(User user);
}
