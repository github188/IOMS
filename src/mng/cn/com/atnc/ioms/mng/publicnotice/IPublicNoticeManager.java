package cn.com.atnc.ioms.mng.publicnotice;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.publicnotice.PnNotice;
import cn.com.atnc.ioms.model.publicnotice.PublicNoticeQueryModel;

/**
 * @author:lizhisheng
 * @date:2014-4-25 下午3:31:43
 * @version:1.0
 */
public interface IPublicNoticeManager {
	public String delete(String id) throws ServiceException;
	public PnNotice add(PnNotice node) throws ServiceException;
	public PnNotice findById(String id);
	public PnNotice update(PnNotice node) throws ServiceException;
	public Pagination queryPage(PublicNoticeQueryModel queryModel);
	public List<PnNotice> queryList(PublicNoticeQueryModel queryModel);
	/**
	 * 
	 * 方法说明：根据ID撤销
	 * 
	 * @param id
	 * 
	 */
	public void canclePnnoticeByID(String id);
}
