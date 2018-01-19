package cn.com.atnc.ioms.mng.news.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.news.INewsDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.news.News;
import cn.com.atnc.ioms.entity.news.NewsOptlog;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
import cn.com.atnc.ioms.mng.news.INewsMngService;
import cn.com.atnc.ioms.mng.news.INewsOptLogMngService;
import cn.com.atnc.ioms.mng.news.INewsWorkflowService;
import cn.com.atnc.ioms.model.news.NewsQueryModel;

/**
 * 
 * 类说明：通知公告实现
 * 
 * @author: WhiteYj
 * @time: 2014-5-7 1546
 * @version:1.0
 */
@Service("newsMngService")
public class NewsMngServiceImpl extends AbstractService implements INewsMngService{
    @Autowired
    private INewsDao newsDao;
    @Autowired
    private INewsOptLogMngService newsOptLogMngService;
    @Autowired
    private INewsWorkflowService workflowService;
    
    @Override
    public Pagination queryPage(NewsQueryModel qm) {
        return newsDao.queryPage(qm);
    }

    @Override
    public Pagination queryFlowPage(NewsQueryModel qm) {
        return newsDao.queryFlowPage(qm);
    }
    @Override
    @Transactional
    public News add(News node) throws ServiceException {
        newsDao.save(node);
        return node;
    }

    @Override
    @Transactional
    public News update(News node) throws ServiceException {
        newsDao.saveOrUpdate(node);
        return node;
    }

    @Override
    public News findById(String id){
        return  newsDao.findById(id);
    }

    @Override
    public void delStatusNewsByID(String id) {
        News news = newsDao.findById(id);
        news.setStatus(NewsStatusEnum.CDELETED);// 已删除
        newsDao.saveOrUpdate(news);
    }

    @Override
    public void removeStatusNewsByID(String id) {
        News news = newsDao.findById(id);
        news.setStatus(NewsStatusEnum.DELETED);// 已删除
        newsDao.saveOrUpdate(news);
    }
    
    @Override
    public Integer getApproveNum(String userId){
        return newsDao.getFlowNum(userId,new NewsStatusEnum[]{
                NewsStatusEnum.SUBMITTED,
                NewsStatusEnum.MODIFIED,
                NewsStatusEnum.FIRSTPASSED,
                NewsStatusEnum.SECONDPASSED,
                NewsStatusEnum.FIRSTDISSENT,
                NewsStatusEnum.SECONDDISSENT
        });
    }

    public Integer getFlowNum(String userId,NewsStatusEnum[] status){
        return newsDao.getFlowNum(userId,status);
    }
    
    @Override
    public String approve(String id, String remark, String processInstanceId, boolean pass, User user) throws Exception {
        try {
         Map<String, Object> taskVariables = new HashMap<String, Object>();
            News news = findById(id);
            NewsOptlog newsOptlog = new NewsOptlog();
            Task task1 = workflowService.getTaskByProcessInstaceId(news.getProcessInstanceId());
            String approveManageName = "";
            switch (news.getStatus()) {
            case MODIFIED://修改提交
            case SUBMITTED:// 网控部门经理审批
                taskVariables.put("deptManagePass", pass);
                newsOptlog.setInNewsStatusEnum(NewsStatusEnum.SUBMITTED);// 已提交
                if (pass) {// 审批通过
                    news.setStatus(NewsStatusEnum.FIRSTPASSED);// 部门经理通过
                    newsOptlog.setNewsStatusEnum(NewsStatusEnum.FIRSTPASSED);// 部门经理通过
                    newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.FIRSTPASSED);// 部门经理通过
                } else {
                    news.setStatus(NewsStatusEnum.FIRSTDISSENT);// 部门经理驳回
                    newsOptlog.setNewsStatusEnum(NewsStatusEnum.FIRSTDISSENT);//部门经理驳回
                    newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.FIRSTDISSENT);// 部门经理驳回
                }
                approveManageName="部门经理";
                break;
            case FIRSTPASSED:// 事业部领导审批
                taskVariables.put("syDeptManagePass", pass);
                newsOptlog.setInNewsStatusEnum(NewsStatusEnum.FIRSTPASSED);// 部门经理通过
                if (pass) {// 审批通过
                    news.setStatus(NewsStatusEnum.SECONDPASSED);// 事业部领导通过
                    newsOptlog.setNewsStatusEnum(NewsStatusEnum.SECONDPASSED);// 事业部领导通过
                    newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.SECONDPASSED);// 事业部领导通过
                } else {
                    news.setStatus(NewsStatusEnum.SECONDDISSENT);// 事业部领导驳回
                    newsOptlog.setNewsStatusEnum(NewsStatusEnum.SECONDDISSENT);// 事业部领导驳回
                    newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.SECONDDISSENT);// 事业部领导驳回
                }
                approveManageName="事业部领导";
                break;
            }
            workflowService.complete(task1.getId(), taskVariables);
            // 获取当前任务
            Task task = workflowService.getTaskByProcessInstaceId(news.getProcessInstanceId());
            //当前任务名
            news.setCurrentTaskName(task.getName());
            //当前审批人
            news.setCurrentAuditer(user.getLoginName());
            //累加审批人列表
            news.setAuditerList(news.getAuditerList()+"|" +user.getLoginName()+ "|");
            // 更改最新处理时间
            news.setPublishTime(new Date());
            update(news);
            //保存日志
            newsOptlog.setNews(news);
            newsOptlog.setOptUser(user);
            newsOptlog.setOptTime(new Date());
            String str = remark.length()>0?remark:"";
            newsOptlog.setInfo(str);
            try {
                newsOptLogMngService.add(newsOptlog);
                return "标题:"+news.getTitle()+",创建人:"+news.getCreateUser().getName()+",审批人:"+user.getName()+",角色:"+approveManageName+",结果:"+(pass?"通过":"不通过");
            } catch (ServiceException e) {
                e.printStackTrace();
                throw new Exception("审批失败");
            }
        } catch (ActivitiException e) {
            if (e.getMessage().indexOf("no processes deployed with key") != -1) {
                logger.warn("没有部署流程!", e);
            } else {
                logger.error("启动请假流程失败：", e);
            }
            throw new Exception("审批失败");
        } catch (Exception e) {
            logger.error("启动请假流程失败：", e);
            throw new Exception("审批失败");
        }
    }
    
}
