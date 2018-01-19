package cn.com.atnc.ioms.mng.clientnotice;

import cn.com.atnc.common.service.ServiceException;



/**
 * @author:lizhisheng
 * @date:2014-4-22 上午9:15:40
 * @version:1.0
 */
public abstract interface ISendMessageService
{
	/**
	* 发送指定内容到指定手机号
	 * user  用户
	 * msg  信息
	 * @throws ServiceException 
	 */
	public int send(String str, String phoneNo);
}
