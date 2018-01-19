package cn.com.atnc.ioms.mng.business.formalcircuit;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuit;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;


 /**
 * 正式电路申请表基础信息Service接口
 *
 * @author Wang zhicheng
 * @date 2015年5月18日 上午8:52:08
 * @since 1.0.0
 */
public interface IFormalCircuitManager {

	/**
	 * 查询
	 *
	 * @param queryModel
	 * @return 
	 * @date  2015年5月19日下午3:55:30
	 * @since 1.0.0
	*/
	public Pagination queryPage(FormalCircuitQueryModel queryModel);

	/**
	 * 查找实体返回List
	 *
	 * @param queryModel
	 * @return 
	 * @date  2015年5月19日下午3:55:43
	 * @since 1.0.0
	*/
	public List<FormalCircuit> queryList(FormalCircuitQueryModel queryModel);

	/**
	 * 保存申请记录
	 *
	 * @param teleGraph 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:43:24
	 * @since 1.0.0
	 */
	void save(FormalCircuit formalCircuit);

	/**
	 * 更新申请信息
	 * @param teleGraph 
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:43:44
	 * @since 1.0.0
	 */
	void update(FormalCircuit formalCircuit);
	/**
	 * 通过ID查询实体
	 *
	 * @param id
	 * @return 
	 * @date  2015年5月22日下午2:19:57
	 * @since 1.0.0
	*/
	public FormalCircuit findById(String id);

	/**
	 * 通过FormalCircuit的ID得到弹出框实体Model
	 *
	 * @param id
	 * @return 
	 * @date  2015年5月22日下午2:20:14
	 * @since 1.0.0
	*/
	public FormalCircuitQueryModel getCheckModel(String id);

	/**
	 * 审核，评价方法
	 * @param id
	 * @param queryModel
	 * @param user
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月15日上午11:26:49
	 * @since 1.0.0
	 */
	public FormalCircuit doCheck(HttpServletRequest request, String id, FormalCircuitQueryModel queryModel, User user);

	/**
	 * 修改操作方法体
	 *
	 * @param queryModel
	 * @return 
	 * @date  2015年5月22日下午2:21:32
	 * @since 1.0.0
	*/
	public FormalCircuitQueryModel setModel(FormalCircuitQueryModel queryModel);


	/**
	 * 得到查询实体，用于页面查看
	 *
	 * @param applyBaseInfo
	 * @return 
	 * @date  2015年5月29日上午11:22:54
	 * @since 1.0.0
	*/
	public FormalCircuitQueryModel getViewModel(ApplyBaseInfo applyBaseInfo);

	/**
	 * 通过ApplyBaseInfo查询实体
	 *
	 * @param id
	 * @return 
	 * @date  2015年7月15日下午2:26:32
	 * @since 1.0.0
	*/
	public FormalCircuit findByApplyBaseInfo(String id);

	/**
	 * 获取报表填充参数
	 * @author WangLingbin
	 * @date  2015年11月10日下午5:14:19
	 * @since 1.0.0
	 */
	public Map<String, Object> getReportParams(HttpServletRequest request,String id, String reportName);

	/**
	 * 获取需要发送短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午2:08:40
	 * @since 1.0.0
	 */
	public List<FormalCircuit> getListSendMessage();
}
