package cn.com.atnc.ioms.dao.systemmng.deptinfomng;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.systemmng.deptinfomng.DeptInfomationMng;
import cn.com.atnc.ioms.model.acl.UserQueryModel;
import cn.com.atnc.ioms.model.systemmng.deptinfomng.DeptInfoQueryModel;

public interface IDeptInfoMngDao extends IBaseDao<DeptInfomationMng>{
    /**
     * 
     * @Author:hantianyu 
     * @Title:queryPage
     * @Description:查询分页
     * @Param:@param queryModel
     * @Param:@return
     * @Return:Pagination
     * @Creatime:2016年6月17日 下午3:17:40
     */
	public Pagination queryPage(DeptInfoQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getDeptByType
	 * @Description:根据部门类型获取list
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<DeptInfomationMng>
	 * @Creatime:2016年6月17日 下午3:33:19
	 */
	public List<DeptInfomationMng> getDeptByType(DeptInfoQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getDeptByParentInfo
	 * @Description:获取父类
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<DeptInfomationMng>
	 * @Creatime:2016年6月22日 下午5:10:40
	 */
	public List<DeptInfomationMng> getDeptByParentInfo(DeptInfoQueryModel queryModel);
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getUserListByDept
	 * @Description:根据部门获取用户列表
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<User>
	 * @Creatime:2016年6月28日 上午10:49:14
	 */
	public List<User> getUserListByDept(UserQueryModel queryModel);
}
