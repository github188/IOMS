/**
 * @ProjectName IOMS
 * @FileName IKuCarrierFreqParser.java
 * @PackageName:cn.com.atnc.ioms.mng.dataprocess
 * @author KuYonggang
 * @date 2015年4月1日下午1:04:43
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.dataprocess;

import cn.com.atnc.common.service.ServiceException;

/**
 * 信息json解析器
 *
 * @author KuYonggang
 * @date 2015年4月1日 下午1:04:43
 * @since 1.0.0
 */
public interface IDataParser {

	/**
	 * 解析入库链路告警信息
	 *
	 * @param jsonStr json字符串
	 * @param fileName 文件名
	 * @throws ServiceException 
	 * @author KuYonggang
	 * @date  2015年3月23日下午4:28:59
	 * @since 1.0.0
	 */
	public void parseLinkedWarn(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 解析入库状态告警信息
	 *
	 * @param jsonStr json字符串
	 * @param fileName 文件名
	 * @throws ServiceException 
	 * @author KuYonggang
	 * @date  2015年3月23日下午4:29:02
	 * @since 1.0.0
	 */
	public void parseStatusWarn(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 解析Ku节点参数信息json字符串
	 *
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException 
	 * @author KuYonggang
	 * @date  2015年4月1日下午2:35:55
	 * @since 1.0.0
	 */
	public void parseKuNodeParameter(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 解析Ku载波频率信息json字符串
	 *
	 * @param jsonStr 
	 * @param fileName
	 * @throws ServiceException 
	 * @author KuYonggang
	 * @date  2015年4月1日下午1:06:07
	 * @since 1.0.0
	 */
	public void parseKuCarrierFreq(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 解析Ku节点信息json字符串
	 *
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException 
	 * @author KuYonggang
	 * @date  2015年4月1日下午2:24:06
	 * @since 1.0.0
	 */
	public void parseKuNodeInfo(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 解析ODU轮询数据json字符串
	 *
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException 
	 * @author KuYonggang
	 * @date  2015年4月1日下午2:27:46
	 * @since 1.0.0
	 */
	public void parseOduPolling(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 解析wafr8端口统计数据json字符串
	 *
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException 
	 * @author KuYonggang
	 * @date  2015年4月1日下午2:28:30
	 * @since 1.0.0
	 */
	public void parseWafr08Port0Stat(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 解析FTPLINK心跳文件json字符串
	 *
	 * @param infoStr
	 * @param fileName 
	 * @author ku
	 * @date  2015年6月17日下午5:14:22
	 * @since 1.0.0
	 */
	public void parseFtpLink(String infoStr, String fileName) throws ServiceException;
}
