/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-16 下午6:53:35
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.dataprocess;

import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;

/**
 * @author:HuangYijie
 * @date:2014-4-16 下午6:53:35
 * @version:1.0
 */

public interface ISatelliteDataParser {
	/**
	 * 处理Ku状态采集数据入库
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-17 上午9:07:55
	 * 
	 * @param jsonStr
	 * @throws ServiceException
	 *             void
	 */
	public void parseKuStatus(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 处理KuMaplist数据入库
	 * 根据收发两端的节点号+槽位号+端口号唯一确定一条记录，有则更新start/cxr/fec，没有则入库一条新纪录并标识
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-17 上午9:08:11
	 * 
	 * @param jsonStr
	 * @throws ServiceException
	 *             void
	 */
	public void parseKuMaplist(String jsonStr,String fileName) throws ServiceException;

	/**
	 * 处理TES发送功率，所有频点的值。
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-17 上午9:09:27
	 * 
	 * @param jsonStr
	 * @throws ServiceException
	 *             void
	 */
	public void parseTesTxPower(String jsonStr,String fileName) throws ServiceException;
}
