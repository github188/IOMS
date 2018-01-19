package cn.com.atnc.ioms.mng.clientnotice;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.model.clientnotice.ClientNoticeQueryModel;

/**
 * @author:lizhisheng
 * @date:2014-4-23 下午5:01:58
 * @version:1.0
 */
public interface IClientNoticeManager {

	/**
	 * 多条件查询
	 * 
	 * @author:lizhisheng
	 * @date:2014-4-21
	 * @param qm
	 * @return Pagination
	 */
	public Pagination queryPage(ClientNoticeQueryModel queryModel);

	/**
	 * 
	 * @author:lizhisheng
	 * @Date:2014-4-23 下午5:02:19 发送邮件或者短信接口
	 * @param user
	 * @param msg
	 * @return boolean
	 */
	public void sendMessage(final BaseUserInfo client, final String msg);
}
