/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-16 下午6:53:35
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.dataprocess;

import java.util.Date;

import cn.com.atnc.common.service.ServiceException;

/**
 * 卫星解析具体操作 接口
 *
 * @author 段衍林
 * @2016年11月29日 下午2:39:24
 */
public interface ISatelliteCheckParser {

	/**
	 * 通信基地-TES-TES OCC
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午3:59:29
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException
	 *             void
	 */
	public void parseTesOcc(String jsonStr, String fileName, Date checkTime)
			throws ServiceException;
	/**
	 * 通信基地-TES-TES ODU
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午3:59:29
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException
	 *             void
	 */
	public void parseTxjdOdu(String jsonStr, String fileName, Date checkTime)
			throws ServiceException;

	/**
	 * 通信基地-KU卫星
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午3:59:29
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException
	 *             void
	 */
	public void parseKuData(String jsonStr, String fileName, Date checkTime,
			String equipName) throws ServiceException;

	/**
	 * 通信基地-KU卫星--温度，参数，状态
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午3:59:29
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException
	 *             void
	 */
	public void parseKuEfdataRju(String jsonStr, String fileName, Date checkTime)
			throws ServiceException;

	/**
	 * 东四--ODU
	 * 
	 * @author 段衍林
	 * @2016年11月29日 下午3:59:29
	 * @param jsonStr
	 * @param fileName
	 * @throws ServiceException
	 *             void
	 */
	public void parseDsOdu(String jsonStr, String fileName, Date checkTime)
			throws ServiceException;
}
