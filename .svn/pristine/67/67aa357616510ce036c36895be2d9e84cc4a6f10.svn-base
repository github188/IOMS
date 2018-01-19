package cn.com.atnc.ioms.dao.news;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.news.NewsOptlog;
import cn.com.atnc.ioms.model.news.NewsOptLogQueryModel;
import cn.com.atnc.ioms.model.news.NewsQueryModel;
/**
 * 类说明:通知公告操作日志接口
 * @author WhiteYj
 * @date 2014-05-08 1720
 */
public interface INewsOptlogDao extends IBaseDao<NewsOptlog> {

    /**
     * 方法说明:查询通知公告最后的时间记录
     * @author WhiteYj
     * @data 2014-05-09 13:00
     * @param id
     * @return
     */
    public NewsOptlog findLastTimeById(String id);
    
    /**
     * 方法说明:按照Id查询通知公告操作日志
     * @author WhiteYj
     * @date 2014-5-9 1400
     * @param id
     * @return
     */
    public List<NewsOptlog> findListById(String id);
    

    /**
     * 方法说明:分页参数查询操作日志
     * @author WhiteYj
     * @date 2014-5-12 1510
     * @param qm
     * @return
     */
    public Pagination queryPage(NewsOptLogQueryModel qm);
    public Pagination queryPage(NewsQueryModel qm);
}
