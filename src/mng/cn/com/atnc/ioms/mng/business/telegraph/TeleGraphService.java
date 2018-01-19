/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName IKuSatelliteService.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite
 * @author ku
 * @date 2015年5月13日下午4:03:05
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.telegraph;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraph;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;

/**
 * 转报地址Service接口
 *
 * @author WangLingbin
 * @date 2015年6月18日 上午10:41:09
 * @since 1.0.0
 */
public interface TeleGraphService {

	/**
	 * 通过查询条件model查询申请记录
	 *
	 * @param queryModel
	 * @author WangLingbin
	 * @date 2015年6月18日上午10:41:22
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TeleGraphQueryModel queryModel);

	/**
	 * 保存申请记录
	 *
	 * @param teleGraph
	 * @author WangLingbin
	 * @date 2015年5月21日上午9:43:24
	 * @since 1.0.0
	 */
	void save(TeleGraph teleGraph);

	/**
	 * 根据主键ID获取申请对象
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 * @author WangLingbin
	 * @date 2015年5月21日上午9:43:32
	 * @since 1.0.0
	 */
	TeleGraph getTeleGraphById(String id);

	/**
	 * 更新申请信息
	 * 
	 * @param teleGraph
	 * @author WangLingbin
	 * @date 2015年5月21日上午9:43:44
	 * @since 1.0.0
	 */
	void update(TeleGraph teleGraph);

	/**
	 * 删除申请信息
	 * 
	 * @param teleGraph
	 * @author WangLingbin
	 * @date 2015年5月21日上午9:43:54
	 * @since 1.0.0
	 */
	void delete(TeleGraph teleGraph);

	/**
	 * 客服领导审批处理
	 * 
	 * @author WangLingbin
	 * @date 2015年5月28日下午4:10:19
	 * @since 1.0.0
	 */
	TeleGraph dealForm(HttpServletRequest request, TeleGraphQueryModel model,
			User user, List<String> originalAddrs);

	/**
	 * 根据基础信息查找
	 * 
	 * @param id
	 *            申请信息父类ID
	 * @return
	 * @author WangLingbin
	 * @date 2015年5月30日下午3:42:46
	 * @since 1.0.0
	 */
	TeleGraph getTeleGraphByBaseInfo(String id);

	/**
	 * 获取报表参数
	 * 
	 * @author WangLingbin
	 * @date 2015年11月10日下午3:54:57
	 * @since 1.0.0
	 */
	Map<String, Object> getReportParams(HttpServletRequest request, String id,
			String reportName);

	/**
	 * 获取需要发送短信的数据（转报电路）
	 *
	 * @return
	 * @author Wang Zhicheng
	 * @param type
	 * @date 2015年11月16日下午2:59:43
	 * @since 1.0.0
	 */
	List<TeleGraph> getListSendMessage();

	/**
	 * 获取需要发送给工程师短信的数据
	 *
	 * @return
	 * @author Wang Zhicheng
	 * @date 2015年11月16日下午3:19:54
	 * @since 1.0.0
	 */
	List<TeleGraph> getListSendMessageEng();

	/**
	 * 
	 * 所有提交至网控的转报地址消息均发送至客服专员处
	 *
	 * @return
	 * @author WangPeng
	 * @date 2015年11月26日下午5:53:35
	 * @since 1.0.0
	 */
	List<TeleGraph> getListSendMessageFirstCommit();
}
