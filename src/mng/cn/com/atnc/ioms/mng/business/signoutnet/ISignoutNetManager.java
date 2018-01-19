package cn.com.atnc.ioms.mng.business.signoutnet;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.signoutnet.SignoutNet;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.model.business.signoutnet.SignoutNetQueryModel;
import cn.com.atnc.ioms.model.business.signoutnet.SignoutNetReortModel;

/**
 * 通信网退网申请
 *
 * @author 段衍林
 * @2017年1月10日 上午11:21:20
 */
public interface ISignoutNetManager {

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2017年1月10日 下午2:09:08
	 * @param queryModel
	 *            查询条件
	 * @return MyPagination 分页
	 */
	public Pagination queryPage(SignoutNetQueryModel queryModel);

	/**
	 * 保存退网基础信息
	 * 
	 * @author 段衍林
	 * @2017年1月11日 下午1:01:53
	 * @param signOutNet
	 *            实体
	 * @param client
	 *            操作人 void
	 */
	void saveDeal(SignoutNet signOutNet, Client client);

	/**
	 * 修改退网基础信息
	 * 
	 * @author 段衍林
	 * @2017年1月11日 下午1:01:53
	 * @param signOutNet
	 *            实体
	 * @param client
	 *            操作人 void
	 */
	void modDeal(SignoutNet signOutNet, Client client);

	/**
	 * 保存申请记录
	 * 
	 * @author 段衍林
	 * @2017年1月11日 下午1:58:58
	 * @param signOutNet
	 *            实体 void
	 */
	void save(SignoutNet signOutNet);

	/**
	 * 更新申请信息
	 * 
	 * @author 段衍林
	 * @2017年1月11日 下午1:59:18
	 * @param signOutNet
	 *            实体 void
	 */
	void update(SignoutNet signOutNet);

	/**
	 * 通过ID查询实体
	 * 
	 * @author 段衍林
	 * @2017年1月11日 下午1:59:30
	 * @param id
	 *            实体id
	 * @return SignOutNet 返回值实体
	 */
	SignoutNet findById(String id);

	/**
	 * 获取报表数据源
	 * 
	 * @author 段衍林
	 * @2017年1月12日 上午11:10:14
	 * @param id
	 *            退网id
	 * @return List<SignoutNetReortModel> 报表数据列表
	 */
	List<SignoutNetReortModel> getReportDateSource(String id);

	/**
	 * 通过基础申请信息ID获取退网申请实体
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午12:58:12
	 * @param id
	 *            实体id
	 * @return SignOutNet 返回实体
	 */
	SignoutNet findByApplyBaseInfoId(String id);

	/**
	 * 处理表单保存操作
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午3:17:10
	 * @param queryModel
	 *            查询model
	 * @param user
	 *            操作人
	 * @return SignOutNet 返回值
	 */
	SignoutNet dealForm(SignoutNetQueryModel queryModel, User user);

	/**
	 * 获取报表填充参数
	 * 
	 * @author 段衍林
	 * @2017年1月13日 下午3:30:48
	 * @param request
	 *            请求
	 * @param id
	 *            id
	 * @param reportName
	 *            报表名称
	 * @return Map<String,Object> 返回键值对
	 */
	Map<String, Object> getReportParams(HttpServletRequest request, String id,
			String reportName);
}
