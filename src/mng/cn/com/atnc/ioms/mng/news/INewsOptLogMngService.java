package cn.com.atnc.ioms.mng.news;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.news.NewsOptlog;
import cn.com.atnc.ioms.model.news.NewsOptLogQueryModel;
import cn.com.atnc.ioms.model.news.NewsQueryModel;

public interface INewsOptLogMngService {
    /**
     * 方法说明:新增操作日志
     * 
     * @author WhiteYj
     * @date 2014-05-08 1740
     * @param newsOptlog
     * @throws ServiceException
     */
    public void add(NewsOptlog newsOptlog) throws ServiceException;

    /**
     * 方法说明:查询日志记录最后一个时间点的记录
     * 
     * @author WhiteYj
     * @date 2014-05-09 1343
     * @param id
     * @return
     */
    public NewsOptlog findLastTimeById(String id);
    
    /**
     * 方法说明:查询ID条件下日志记录下的信息
     * @author WhiteYj
     * @date 2014-05-09 1410
     * @param id
     * @return
     */
    public List<NewsOptlog> findListById(String id);


    /**
     * 方法说明:查询日志记录并分页\
     * @author WhiteYj
     * @date 2014-05-12 1500
     * @param qm
     * @return
     */
    public Pagination queryPage(NewsOptLogQueryModel qm);
    public Pagination queryPage(NewsQueryModel qm);
}
