/**
 * @ProjectName PCSP
 * @FileName JasperReportService.java
 * @PackageName:cn.com.atnc.pcsp.mng.reports
 * @author WangLingbin
 * @date 2015年5月28日下午2:57:13
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.reports;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.ioms.entity.reports.AutoTelegraphEntity;
import cn.com.atnc.ioms.entity.reports.DataComNetworkEntity;
import cn.com.atnc.ioms.entity.reports.FormalCircuitBaseInfoEntity;
import cn.com.atnc.ioms.entity.reports.KuMaintenceEntity;
import cn.com.atnc.ioms.entity.reports.TeleGraphBaseInfoEntity;


/**
 * 报表中心
 * 
 * @author WangLingbin
 * @date 2015年5月28日 下午2:57:13
 * @since 1.0.0
 */
@SuppressWarnings("rawtypes")
public interface JasperReportService {

	/**
	 * 报表预览
	 * @author WangLingBin
	 * @param request 				Http请求
	 * @param datasource			主报表数据源
	 * @param subreportDatasource	子报表数据源
	 * @param imageName				图像名称
	 * @param reportName			报表名称
	 * @return map
	 * @author WangLingbin
	 * @date  2015年5月28日下午3:00:06
	 * @since 1.0.0
	 */
	
	Map<String, Object> preView(HttpServletRequest request, List datasource,
			List subreportDatasource, String imageName, String reportName);

	/**
	 * 根据导出类型和报表名称：导出报表
	 * @author WangLingBin
	 * @param type			导出类型，如pdf,xls,doc等
	 * @param reportName	报表名称：如officeStationery
	 * @param request		请求
	 * @param response 		响应
	 * @author WangLingbin
	 * @date  2015年5月28日下午3:28:33
	 * @since 1.0.0
	 */
	void export(@RequestParam(value = "type", required = false) String type,
			String reportName, HttpServletRequest request,
			HttpServletResponse response);
	
	/**
	 * 报表预览方法重载（不包含图像）
	 * @author WangLingBin
	 * @param request 				Http请求
	 * @param datasource			主报表数据源
	 * @param subreportDatasource	子报表数据源
	 * @param reportName			报表名称
	 * @return map
	 * @author WangLingbin
	 * @date  2015年5月28日下午3:29:22
	 * @since 1.0.0
	 */
	Map<String,Object> preView(HttpServletRequest request,List datasource,List subreportDatasource,String reportName);
	
	/**
	 * 报表预览方法重载（不包含子报表）
	 * @author WangLingBin
	 * @param request 				Http请求
	 * @param datasource			主报表数据源
	 * @param imageName				图像名称
	 * @param reportName			报表名称
	 * @return map
	 * @author WangLingbin
	 * @date  2015年5月28日下午3:30:17
	 * @since 1.0.0
	 */
	Map<String,Object> preView(HttpServletRequest request,List datasource,String imageName,String reportName);
	
	/**
	 * 报表预览方法重载（不包含子报表和图像）
	 * @author WangLingBin
	 * @param request 				Http请求
	 * @param datasource			主报表数据源
	 * @param reportName			报表名称
	 * @return map
	 * @author WangLingbin
	 * @date  2015年5月28日下午3:30:23
	 * @since 1.0.0
	 */
	Map<String,Object> preView(HttpServletRequest request,List datasource,String reportName);
	
	/**
	 * 获取报表apply的数据源
	 * @param id		数据库中TeleGraph的主键ID
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月2日下午1:11:51
	 * @since 1.0.0
	 */
	List<TeleGraphBaseInfoEntity> getApplyDatasource(String id);
	
	/**
	 * 获取报表config的数据源
	 * @param id		数据库中TeleGraph的主键ID
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月2日下午1:11:51
	 * @since 1.0.0
	 */
	List<TeleGraphBaseInfoEntity> getConfigDatasource(String id);
	
	/**
	 * 获取报表ATM的数据源
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月18日上午9:21:51
	 * @since 1.0.0
	 */
	List<FormalCircuitBaseInfoEntity> getATMDatasource(String id);
	
	/**
	 * 获取报表TES的数据源
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月18日上午9:21:51
	 * @since 1.0.0
	 */
	List<FormalCircuitBaseInfoEntity> getTESDatasource(String id);
	/**
	 * 获取报表PES的数据源
	 * @author 段衍林
	 * @2017年1月9日 上午11:21:25
	 * @param id
	 * @return
	 * List<FormalCircuitBaseInfoEntity>
	 */
	List<FormalCircuitBaseInfoEntity> getPESDatasource(String id);
	
	/**
	 * 获取报表KU的数据源
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年6月18日上午9:21:51
	 * @since 1.0.0
	 */
	List<FormalCircuitBaseInfoEntity> getKUDatasource(String id);

	/**
	 * 此处添加getKUConfigDatasource方法的描述信息
	 *
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年7月7日下午2:00:30
	 * @since 1.0.0
	 */
	List<FormalCircuitBaseInfoEntity> getKUConfigDatasource(String id);

	/**
	 * 获取转报电路数据源
	 *
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年10月23日下午4:05:36
	 * @since 1.0.0
	 */
	List<TeleGraphBaseInfoEntity> getCircuitsDatasource(String id);

	/**
	 * 数据通信网配置报表
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日上午9:57:12
	 * @since 1.0.0
	 */
	List<DataComNetworkEntity> getDataComNetworkConfigsource(String id);

	/**
	 * 数据通信网申请报表
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日上午9:57:32
	 * @since 1.0.0
	 */
	List<DataComNetworkEntity> getDataComNetworkDatasource(String id);

	/**
	 * 此处添加getTransferNetDatasource方法的描述信息
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月27日下午2:11:07
	 * @since 1.0.0
	 */
	List<AutoTelegraphEntity> getTransferNetDatasource(String id);
	/**
	 * 获取ATM配置表数据源
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月9日下午3:15:10
	 * @since 1.0.0
	 */
	List<FormalCircuitBaseInfoEntity> getATMConfigDatasource(String id);

	/**
	 * 获取TES配置表数据源
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年11月10日上午9:08:03
	 * @since 1.0.0
	 */
	List<FormalCircuitBaseInfoEntity> getTESConfigDatasource(String id);
	
	/**
	 * 获取PES配置表数据源
	 * @author 段衍林
	 * @2017年1月9日 上午11:26:03
	 * @param id
	 * @return
	 * List<FormalCircuitBaseInfoEntity>
	 */
	List<FormalCircuitBaseInfoEntity> getPESConfigDatasource(String id);
	
	
	/**
	 * 获取KU维保月度报表数据
	 * @author 王凌斌 
	 * @2017年1月22日 下午1:01:31
	 * @param id
	 * @return
	 * List<KuMaintenceEntity>
	 */
	List<KuMaintenceEntity> getKuMeintenceDatasource(String id);
}
