package cn.com.atnc.ioms.dao.news;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.news.News;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
import cn.com.atnc.ioms.model.news.NewsQueryModel;

public interface INewsDao extends IBaseDao<News> {
    
    /**
     * 功能说明:分页查询数据
     * @author WhiteYj
     * @return
     */
    public Pagination queryPage(NewsQueryModel newsQueryModel);
    
    /**
     * 功能说明：Sql分页查询
     * @param qm
     * @return
     */
    public Pagination queryFlowPage(NewsQueryModel qm);
    
    
    /**
     * 查询流程数量
     * @param sql
     * @param countsql
     * @param params
     * @return
     */
    public int getFlowNum(String userId,NewsStatusEnum[] newsStatus);
    
}
