package cn.com.atnc.ioms.mng.news;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.news.News;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
import cn.com.atnc.ioms.model.news.NewsQueryModel;

public interface INewsMngService {
    /**
     * 
     * 方法说明：查询分页对象
     * @author WhiteYj
     * @date 2014-5-7 1540
     * @param qm
     * @return Pagination
     * 
     */
    public Pagination queryPage(NewsQueryModel qm);

    public Pagination queryFlowPage(NewsQueryModel qm);
    
    /**
     * 方法说明: 草稿保存
     * @author WhiteYj
     * @date 2014-5-8 1418
     * @param node
     * @return
     */
    public News add(News node) throws ServiceException;   

    /**
     * 方法说明: 公告信息查询
     * @author WhiteYj
     * @date 2014-5-9 1130
     * @param id
     * @return
     */
    public News findById(String id);
    
    /**
     * 方法说明: 公告信息修改
     * @author WhiteYj
     * @date 2014-5-9 1130
     * @param node
     * @return
     * @throws ServiceException
     */
    public News update(News node) throws ServiceException;
    
    /**
     * 方法说明:公告信息删除时做出状态性修改DELETE
     * @author WhiteYj
     * @data 2014-5-9 12:20
     * @param id
     */
    public void delStatusNewsByID(String id);

    public void removeStatusNewsByID(String id);
    /**
     * 方法说明：待批数量
     * @param userId
     * @return
     */
    public Integer getApproveNum(String userId);
    

    /**
     * 方法说明：某状态待批数量
     * @param userId
     * @param status
     * @return
     */
    public Integer getFlowNum(String userId,NewsStatusEnum[] status);
    /**
     * 审批
     * @param id
     * @param remark
     * @param processInstanceId
     * @param pass
     * @param user
     * @return
     */
    public String approve(String id ,String remark,String processInstanceId,boolean pass,User user) throws Exception ;
    
    
}
