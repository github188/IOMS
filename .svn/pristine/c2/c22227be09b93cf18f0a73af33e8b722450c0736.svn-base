package cn.com.atnc.ioms.dao.clientnotice;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.clientnotice.SendLog;
import cn.com.atnc.ioms.enums.clientnotice.NoticeState;
import cn.com.atnc.ioms.model.clientnotice.ClientNoticeQueryModel;

/**
 * @author:lizhisheng
 * @date:2014-4-22 上午9:19:41
 * @version:1.0
 */
public interface IClientNoticeDao extends IBaseDao<SendLog> {
	/**
	 * 查询
	 * 
	 * @author lizhisheng ClientNoticeQueryModel
	 * */
	public Pagination queryPage(ClientNoticeQueryModel queryModel);

	/**
	 * 根据发送状态查找对应的记录
	 * 
	 * @author:lizhisheng
	 */
	public List<SendLog> findByNoticeState(NoticeState noticeState);

	public List<SendLog> findByExcludeNoticeState(NoticeState noticeState);

	public List<SendLog> queryList(ClientNoticeQueryModel queryModel);
}
