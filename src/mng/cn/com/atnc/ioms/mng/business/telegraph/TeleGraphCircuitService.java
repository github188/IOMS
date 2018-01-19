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
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphCircuit;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;

/**
 * 民航转报网转报电路申请Service接口
 * 
 * @author WangLingbin
 * @date 2015年10月19日 上午8:47:41
 * @since 1.0.0
 */
public interface TeleGraphCircuitService {

	/**
	 * 通过查询条件model查询申请记录
	 * 
	 * @author WangLingbin
	 * @date 2015年10月19日下午4:01:49
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(TeleGraphQueryModel queryModel);

	/**
	 * 查找所有
	 * 
	 * @author WangLingbin
	 * @date 2015年10月19日下午3:22:05
	 * @since 1.0.0
	 */
	List<TeleGraphCircuit> getAll();

	/**
	 * 保存申请记录
	 * 
	 * @param teleGraphCircuit
	 * @author WangLingbin
	 * @date 2015年10月19日上午8:49:03
	 * @since 1.0.0
	 */
	void save(TeleGraphCircuit teleGraphCircuit);

	/**
	 * 根据主键ID获取申请对象
	 * 
	 * @param id
	 *            主键ID
	 * @return
	 * @author WangLingbin
	 * @date 2015年10月19日上午8:49:25
	 * @since 1.0.0
	 */
	TeleGraphCircuit getTeleGraphCircuitById(String id);

	/**
	 * 更新信息
	 * 
	 * @param teleGraphCircuit
	 * @author WangLingbin
	 * @date 2015年10月19日上午8:49:40
	 * @since 1.0.0
	 */
	void update(TeleGraphCircuit teleGraphCircuit);

	/**
	 * 删除信息
	 * 
	 * @param teleGraphCircuit
	 * @author WangLingbin
	 * @date 2015年10月19日上午8:49:51
	 * @since 1.0.0
	 */
	void delete(TeleGraphCircuit teleGraphCircuit);

	/**
	 * 根据父类TeleGraph的id查找TeleGraphApply集合
	 * 
	 * @param id
	 *            父类TeleGraph的id
	 * @return
	 * @author WangLingbin
	 * @date 2015年10月19日上午8:50:02
	 * @since 1.0.0
	 */
	List<TeleGraphCircuit> getCircuitsByParentId(String id);

	/**
	 * 处理审批
	 * 
	 * @author WangLingbin
	 * @date 2015年10月20日下午2:27:12
	 * @since 1.0.0
	 */
	TeleGraph dealForm(HttpServletRequest request,TeleGraphQueryModel queryModel, User user);

	/**
	 * 获取报表填充参数
	 * 
	 * @author WangLingbin
	 * @date 2015年11月10日下午4:44:23
	 * @since 1.0.0
	 */
	Map<String, Object> getReportParams(HttpServletRequest request, String id,
			String reportName);

	/**
	 * 
	 * 获取需要发送短信的数据
	 *
	 * @return
	 * @author WangPeng
	 * @date 2015年11月26日下午6:07:51
	 * @since 1.0.0
	 */
	public List<TeleGraphCircuit> getListSendMessage();
}
