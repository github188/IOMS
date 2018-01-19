package cn.com.atnc.ioms.web.news;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.news.News;
import cn.com.atnc.ioms.entity.news.NewsOptlog;
import cn.com.atnc.ioms.enums.news.NewsColumnsEnum;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
import cn.com.atnc.ioms.enums.news.NewsStatusSearchEnum;
import cn.com.atnc.ioms.mng.acl.IRoleResourceManager;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.news.INewsMngService;
import cn.com.atnc.ioms.mng.news.INewsOptLogMngService;
import cn.com.atnc.ioms.mng.news.INewsWorkflowService;
import cn.com.atnc.ioms.model.news.NewsQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * 功能说明：通知公告控制器
 * 
 * @author: WhiteYj
 * @time: 2014-5-7 1603
 * @version:1.0
 */
@Controller("newsController")
@RequestMapping("/news/")
public class NewsController extends MyBaseController{
    @Autowired
    private INewsMngService newsMngService;
    @Autowired
    private IUserManager userManager;
    @Autowired
    private INewsWorkflowService workflowService;
    @Autowired
    private INewsOptLogMngService newsOptLogMngService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private IRoleResourceManager roleResourceManager;
    
    /**
     * 方法说明：通知公告栏目引导,包括(通知发起,待批通知,待发布通知,通知撤销)
     * 
     * @author WhiteYj
     * @date：2014-5-7 1609
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "tab/manage.do", method = RequestMethod.GET)
    public String tabmanage(@ModelAttribute("queryModel") NewsQueryModel queryModel, Model model, HttpServletRequest request) {
        User user = userManager.findById(getCurrentUser(request).getId());
        List<Resource> res= roleResourceManager.listResourceByRoles(user.getRoles());
        Map<Integer,String> map = new HashMap<>();
        for(Resource te:res){
            if(te.getId().equals("newssponsor")){
                map.put(1, "SPONSOR");
            }else if(te.getId().equals("newsapprove")){
                map.put(2, "APPROVE");
            }else if(te.getId().equals("newspublish")){
                map.put(3, "PUBLISH");
            }else if(te.getId().equals("newsmanage")){
                map.put(4, "MANAGE");
            }
        }
        model.addAttribute("optType",map.get(getMinKey(map)));
        super.pageInfo(model, request);
        return "news/tab/manage";
    }

    /**
     * 
     * 方法说明：获取通知公告tab数据记录
     * 
     * @author WhiteYj
     * @date：2014-5-7 1711
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "tab/manage.do", method = RequestMethod.POST)
    public String tabData(HttpSession session, 
            @ModelAttribute("queryModel") NewsQueryModel queryModel, 
            @RequestParam("optType")String optType,
            Model model, HttpServletRequest request) throws IOException {
        User user = userManager.findById(getCurrentUser(request).getId());
        String userId = user.getId();
        logger.debug("newsUserId:" + userId);
        logger.debug("newsUserRole:" + user.getRoleNames());
        
        model.addAttribute("newsColumnEnum", NewsColumnsEnum.values());
        model.addAttribute("newsStatusSearchEnum", NewsStatusSearchEnum.values());
        switch (optType==null?"":optType) {
        case "SPONSOR":// 通知发起
            queryModel.setUser(user);
            queryModel.setInStatusEq(new NewsStatusEnum[]{
                    NewsStatusEnum.DRAFT,
                    NewsStatusEnum.FIRSTDISSENT,
                    NewsStatusEnum.SECONDDISSENT
            });
            model.addAttribute("pagn", this.newsMngService.queryPage(queryModel));
            return "news/sponsor/queryResult";
        case "APPROVE":// 待批通知
            queryModel.setUser(user);
            queryModel.setInStatusEq(new NewsStatusEnum[]{
                    NewsStatusEnum.SUBMITTED,
                    NewsStatusEnum.MODIFIED,
                    NewsStatusEnum.FIRSTPASSED
            });
            model.addAttribute("pagn", this.newsMngService.queryFlowPage(queryModel));
            model.addAttribute("optType","APPROVE");
            return "news/approve/queryResult";
        case "PUBLISH":// 待发布信息
            queryModel.setUser(user);
            queryModel.setStatusEq(NewsStatusEnum.SECONDPASSED);
            model.addAttribute("pagn", this.newsMngService.queryFlowPage(queryModel));
            model.addAttribute("optType","PUBLISH");
            return "news/approve/queryResult";
        case "MANAGE":// 待撤销管理
            queryModel.setNotInStatusEq(new NewsStatusEnum[]{
                    NewsStatusEnum.CDELETED,//草稿删除不显示
                    NewsStatusEnum.DRAFT,
                    NewsStatusEnum.PUBLISHED
            });
            model.addAttribute("pagn", this.newsMngService.queryPage(queryModel));
            return "news/queryResult";
        default:
            List<Resource> res= roleResourceManager.listResourceByRoles(user.getRoles());
            Map<Integer,String> map = new HashMap<>();
            for(Resource te:res){
                if(te.getId().equals("newssponsor")){
                    map.put(1, "newssponsor");
                }else if(te.getId().equals("newsapprove")){
                    map.put(2, "newsapprove");
                }else if(te.getId().equals("newspublish")){
                    map.put(3, "newspublish");
                }else if(te.getId().equals("newsmanage")){
                    map.put(4, "newsmanage");
                }
            }
            if(getMinKey(map)!=null){
                String resname = map.get(getMinKey(map));
                if(resname.equals("newssponsor")){
                    queryModel.setUser(user);
                    queryModel.setInStatusEq(new NewsStatusEnum[]{
                            NewsStatusEnum.DRAFT,
                            NewsStatusEnum.FIRSTDISSENT,
                            NewsStatusEnum.SECONDDISSENT
                    });
                    model.addAttribute("optType","SPONSOR");
                    model.addAttribute("pagn", this.newsMngService.queryPage(queryModel));
                    return "news/sponsor/queryResult";
                }else if(resname.equals("newsapprove")){
                    queryModel.setUser(user);
                    queryModel.setInStatusEq(new NewsStatusEnum[]{
                            NewsStatusEnum.SUBMITTED,
                            NewsStatusEnum.MODIFIED,
                            NewsStatusEnum.FIRSTPASSED
                    });
                    model.addAttribute("pagn", this.newsMngService.queryFlowPage(queryModel));
                    model.addAttribute("optType","APPROVE");
                    return "news/approve/queryResult";
                }else if(resname.equals("newspublish")){
                    queryModel.setUser(user);
                    queryModel.setStatusEq(NewsStatusEnum.SECONDPASSED);
                    model.addAttribute("pagn", this.newsMngService.queryFlowPage(queryModel));
                    model.addAttribute("optType","PUBLISH");
                    return "news/approve/queryResult";
                }else if(resname.equals("newsmanage")){
                    queryModel.setNotInStatusEq(new NewsStatusEnum[]{
                            NewsStatusEnum.CDELETED,//草稿删除不显示
                            NewsStatusEnum.DRAFT,
                            NewsStatusEnum.PUBLISHED
                    });
                    model.addAttribute("pagn", this.newsMngService.queryPage(queryModel));
                    return "news/queryResult";
                }else{
                    model.addAttribute("returnStr", "没有操作权限！");
                    return "returnnote";
                }
            }else{
                model.addAttribute("returnStr", "没有操作权限！");
                return "returnnote";
            }
        }
    }
    public Object getMinKey(Map<Integer,String> map){
        if(map==null) return null;
        Set<Integer> set = map.keySet();
        Object[] obj = set.toArray();
        Arrays.sort(obj);
        return obj[0];
    }
    /**
     * 方法说明：通知公告记录页面引导
     * 
     * @author WhiteYj
     * @date：2014-5-7 1609
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "browse/manage.do", method = RequestMethod.GET)
    public String browse(@ModelAttribute("queryModel") NewsQueryModel queryModel, Model model, HttpServletRequest request) {
        model.addAttribute("newsColumnEnum", NewsColumnsEnum.values());
        model.addAttribute("newsStatusEnum", NewsStatusSearchEnum.values());
        super.pageInfo(model, request);
        return "news/browse/manage";
    }
    /**
     * 
     * 方法说明：获取通知公告页面数据记录
     * 
     * @author WhiteYj
     * @date：2014-5-7 1711
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "browse/manage.do", method = RequestMethod.POST)
    public String browseData(HttpSession session, @ModelAttribute("queryModel") NewsQueryModel queryModel, Model model, HttpServletRequest request) throws IOException {
        User user = userManager.findById(getCurrentUser(request).getId());
        String currentUserId = user.getId();
        logger.debug("newsUserId:" + currentUserId);
        queryModel.setNotInStatusEq(new NewsStatusEnum[]{NewsStatusEnum.DRAFT,NewsStatusEnum.CDELETED});
        model.addAttribute("pagn", this.newsMngService.queryPage(queryModel));
        logger.debug("newsUserRole:" + user.getRoleNames());
        return "news/browse/queryResult";
    }
    
    /**
     * 方法说明:页面引导新增
     * @author WhiteYj
     * @time 2014-05-08 0930
     * @param node
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.GET)
    public String addUrl(@ModelAttribute("pageModel") News node, Model model, HttpServletRequest request) {
        User user = userManager.findById(getCurrentUser(request).getId());
        model.addAttribute("createUser", user.getLoginName());
        model.addAttribute("createName", user.getName());
        model.addAttribute("newsColumnEnum", NewsColumnsEnum.values());
        model.addAttribute("loginUser", WebUtils.getSessionAttribute(request, SessionNames.LOGIN_USER));
        return "news/sponsor/add";
    }

    /**
     * 方法说明:草稿保存
     * @author WhiteYj
     * @time 2014-05-08 0930
     * @param news
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/none.do")
    public String nodeSave(@ModelAttribute("pageModel")News news, HttpServletRequest request, Model model) {
        try {
            news.setCreateTime(new Date());
            news.setPublishTime(new Date());
            User user = getCurrentUser(request);
            news.setCreateUser(user);
            news.setStatus(NewsStatusEnum.DRAFT);
            model.addAttribute("vo", newsMngService.add(news));
            // 根据2014年6月19日指示不对提交以前的做日志记录
           /* NewsOptlog newsOptlog = new NewsOptlog();
            newsOptlog.setNews(news);
            newsOptlog.setNewsStatusEnum(NewsStatusEnum.DRAFT);
            newsOptlog.setInNewsStatusEnum(NewsStatusEnum.DRAFT);
            newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.DRAFT);
            newsOptlog.setInfo("添加通知公告草稿(标题:"+news.getTitle()+")");
            newsOptlog.setOptUser(user);
            newsOptlog.setOptTime(new Date());
            newsOptLogMngService.add(newsOptlog);*/
            
            addSuccess(model, "草稿保存成功:" + news.getTitle());
            super.addLog(request, "添加通知公告草稿(标题:"+news.getTitle()+")");
            
            
            
        } catch (ServiceException e) {
            addError(model, "草稿保存失败:" + e.getMessage());
        }
        return "news/sponsor/result";
    }
    
    /**
     * 方法说明:草稿修改或驳回修改采用草稿暂存并记录日志
     * @author WhiteYj
     * @time 2014-05-08 0930
     * @param news
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/noneModify.do")
    public String nodeModify(
            @RequestParam("id") String id,
            @ModelAttribute("pageModel")News news, 
            HttpServletRequest request, Model model) {
        try {
            //User user = getCurrentUser(request);
            
            News node = newsMngService.findById(id);
            node.setPublishTime(new Date());
            String oldtitle = node.getTitle();
            node.setTitle(news.getTitle());
            node.setColumns(news.getColumns());
            node.setContent(news.getContent());
            // 2014年6月19日 不需要提供提交后的日志
            // 必须原来状态是暂存才能存暂存状态。暂存不需要保存日志
            /*if(node.getStatus()==NewsStatusEnum.DRAFT){
                node.setStatus(NewsStatusEnum.DRAFT);
            }*//*else if(node.getStatus()==NewsStatusEnum.FIRSTDISSENT || node.getStatus()==NewsStatusEnum.SECONDDISSENT){// 该条信息为部门经理驳回或事业部领导驳回
                // 获得最后一条日志读取最后的到达状态
                NewsOptlog newsOptLogLast = newsOptLogMngService.findLastTimeById(id);
                NewsOptlog newsOptlog = new NewsOptlog();
                newsOptlog.setNews(news);
                newsOptlog.setNewsStatusEnum(NewsStatusEnum.MODIFI);
                // 将历史结束状态赋值给开始状态
                if(newsOptLogLast.getOutNewsStatusEnum()==NewsStatusEnum.MODIFIED){
                    newsOptlog.setInNewsStatusEnum(newsOptLogLast.getInNewsStatusEnum());
                }else{
                    newsOptlog.setInNewsStatusEnum(newsOptLogLast.getOutNewsStatusEnum());
                }
                newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.MODIFIED);
                newsOptlog.setInfo("修改通知公告草稿(标题:"+oldtitle+"->"+news.getTitle()+")");
                newsOptlog.setOptUser(user);
                newsOptlog.setOptTime(new Date());
                newsOptLogMngService.add(newsOptlog);
            }*/
            if(node.getStatus()==NewsStatusEnum.DRAFT || node.getStatus()==NewsStatusEnum.FIRSTDISSENT || node.getStatus()==NewsStatusEnum.SECONDDISSENT){
                model.addAttribute("vo", newsMngService.update(node));
                addSuccess(model, "草稿修改成功:" + node.getTitle());
                super.addLog(request, "修改通知公告草稿标题:"+news.getTitle());
            }else{
                throw new ServiceException("本条通知公告修改操作执行错误!");
            }
        } catch (ServiceException e) {
            addError(model, "草稿修改失败:" + e.getMessage());
        }
        return "news/sponsor/result";
    }
    /**
     * 方法说明:启动流程并添加通知公告信息
     * @author WhiteYj
     * @date 2014-05-08 1809
     * @param news
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/add.do", method = RequestMethod.POST)
    public String processAddNews(@ModelAttribute("pageModel") News news, HttpServletRequest request, Model model) {
        try {
            User user = getCurrentUser(request);
            news.setCreateUser(user);
            // 工作流参数
            Map<String, Object> variables = new HashMap<String, Object>();
            
            news.setCreateTime(new Date());
            news.setPublishTime(new Date());
            news.setStatus(NewsStatusEnum.SUBMITTED);// 单据状态为已提交
            String content = news.getContent();
            workflowService.startWorkflow(news, variables);
            // 保存日志
            NewsOptlog newsOptlog = new NewsOptlog();
            newsOptlog.setNews(news);
            newsOptlog.setOptUser(user);
            newsOptlog.setOptTime(new Date());
            newsOptlog.setNewsStatusEnum(NewsStatusEnum.SUBMITTED);// 已提交
//            newsOptlog.setInNewsStatusEnum(NewsStatusEnum.SUBMIT);// 提交通知公告
            newsOptlog.setInNewsStatusEnum(null);// 开始没有状态IOMS_OM_F6_01_05 
            newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.SUBMITTED);//已提交
            try {
                newsOptLogMngService.add(newsOptlog);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            model.addAttribute("vo", news);
            super.addLog(request, "添加通知公告并启动审批流程(标题:"+news.getTitle()+")");
        } catch (ActivitiException e) {
            if (e.getMessage().indexOf("no processes deployed with key") != -1) {
                logger.warn("没有部署流程!", e);
                try {
                    model.addAttribute("returnStr", new ResultModel(false, "没有部署流程!", news).toJson());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return "news/sponsor/result";
            } else {
                logger.error("启动流程失败!", e);
                try {
                    model.addAttribute("returnStr", new ResultModel(false, "启动流程失败!", news).toJson());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                return "news/sponsor/result";
            }
        }
        try {
            model.addAttribute("returnStr", new ResultModel(true, "", news).toJson());
            addSuccess(model, "提交成功");
        } catch (IOException e) {
            addError(model, "提交失败");
            e.printStackTrace();
        }
        return "news/sponsor/result";
    }
    
    /**
     * 方法说明:修改页面引导
     * @author WhiteYj
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "modify.do", method = RequestMethod.GET)
    public String setupModForm(@RequestParam("id") String id,HttpServletRequest request, Model model) {
        model.addAttribute("newsColumnEnum", NewsColumnsEnum.values());
        News news = newsMngService.findById(id);
        String content = news.getContent();
        news.setContent(content.replace("\"","\\\""));
//        System.out.println(news.getContent());
        model.addAttribute("pageModel",news);
        return "news/sponsor/modify";
    }
    
    /**
     * 方法说明:从草稿修改或驳回修改后进入工作流流程
     * @author WhiteYj
     * @param pass
     * @param id
     * @param node
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "modify.do", method = RequestMethod.POST)
    public String processModifyNews(
            @RequestParam("id") String id,
            @ModelAttribute("pageModel") News node,
            HttpServletRequest request, Model model) {
        try {
            Map<String, Object> taskVariables = new HashMap<String, Object>();
            User user = getCurrentUser(request);
            
            News news = newsMngService.findById(id);
            news.setCreateTime(new Date());
            news.setPublishTime(new Date());
            news.setCreateUser(user);
            news.setTitle(node.getTitle());
            news.setColumns(node.getColumns());
            news.setContent(node.getContent());
            
            NewsOptlog newsOptlog = new NewsOptlog();
            
            boolean isZancun = false;
            // 草稿到提交至网控经理审批
            if(news.getStatus() == NewsStatusEnum.DRAFT){
                newsOptlog.setInNewsStatusEnum(NewsStatusEnum.DRAFT);// 草稿提交至部门经理,日志开始状态为草稿

                newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.SUBMITTED);
                newsOptlog.setNewsStatusEnum(NewsStatusEnum.SUBMITTED);
                // 如果是暂存到提交
                news.setStatus(NewsStatusEnum.SUBMITTED);// 已提交
                workflowService.startWorkflow(news, null);// 启动流程
                isZancun = true;
            }
            // 从驳回修改到提交审批
            else if (news.getStatus() == NewsStatusEnum.FIRSTDISSENT || news.getStatus() == NewsStatusEnum.SECONDDISSENT) {
                // 找到最后一条日志记录
                taskVariables.put("modifyPass", true);// 从修改重新提交传参
                Task task = workflowService.getTaskByProcessInstaceId(news.getProcessInstanceId());
                
                news.setCurrentTaskName(task.getName());
                news.setCurrentAuditer(user.getLoginName());
                news.setAuditerList(news.getAuditerList()+"|"+user.getLoginName()+ "|");
                
                workflowService.complete(task.getId(), taskVariables);
                
                newsOptlog.setInNewsStatusEnum(news.getStatus());// 部门经理驳回 或 事业部领导驳回
                newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.MODIFIED);// 修改提交
                newsOptlog.setNewsStatusEnum(NewsStatusEnum.MODIFIED);// 已提交"打回的信息都会被重新审批"

                // 更新状态保存
                news.setStatus(NewsStatusEnum.MODIFIED);// 已提交
            }else{
                throw new Exception("status参数异常");
            }

            // 保存日志
            newsOptlog.setNews(news);
            newsOptlog.setOptUser(user);
            newsOptlog.setOptTime(new Date());
            try {
                newsMngService.update(news); //更新news信息
                newsOptLogMngService.add(newsOptlog);// 增加日志
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            if(isZancun){
                super.addLog(request, "草稿提交至审批流程(标题:"+news.getTitle()+")");
            }else{
                super.addLog(request, "纠正问题重新审批(标题:"+news.getTitle()+")");
            }
            super.addSuccess(model, "修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            addError(model, "修改通知公告失败:" + e.getMessage());
        }
        return "news/sponsor/result";
    }
    /**
     * 方法说明:流程挂起,假象删除
     * @author WhiteYj
     * @date 2014-05-09 1350
     * @param id
     * @param session
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/delete.do", method = RequestMethod.POST)
    public String processDeleteNews(@RequestParam("id") String id, HttpSession session, HttpServletRequest request, Model model) {
        // 公告信息做出状态性修改
        newsMngService.removeStatusNewsByID(id); // 删除状态
        News news = newsMngService.findById(id);
        User user = getCurrentUser(request);
        // 如果流程Id不为空则挂起
        if(news.getProcessInstanceId()!=null){
            // 如果做出删除可能会有一定风险,暂时使用挂起用来替代删除操作
            runtimeService.suspendProcessInstanceById(news.getProcessInstanceId());
        }
        NewsOptlog newsOptlog = new NewsOptlog();
        newsOptlog.setNews(news);
        newsOptlog.setNewsStatusEnum(NewsStatusEnum.DELETED);// 已删除
        if(newsOptLogMngService.findLastTimeById(id)!=null){
            newsOptlog.setInNewsStatusEnum(newsOptLogMngService.findLastTimeById(id).getNewsStatusEnum());
        }
        newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.DELETED);// 完成状态已删除
        newsOptlog.setOptUser(user);
        newsOptlog.setOptTime(new Date());

        try {
            newsOptLogMngService.add(newsOptlog);
            model.addAttribute("vo", news);
            addSuccess(model, "删除成功");
            super.addLog(request, "通知公告删除成功(标题:"+news.getTitle()+",创建人:"+news.getCreateUser().getName()+")");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "news/result";
    }
    /**
     * 草稿删除操作
     * @param id
     * @param session
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/remove.do", method = RequestMethod.POST)
    public String removeNews(@RequestParam("id") String id, HttpSession session, HttpServletRequest request, Model model) {
        // 公告信息做出状态性修改
        newsMngService.delStatusNewsByID(id); // 删除状态
        News news = newsMngService.findById(id);
        User user = getCurrentUser(request);
        NewsOptlog newsOptlog = new NewsOptlog();
        newsOptlog.setNews(news);
        newsOptlog.setNewsStatusEnum(NewsStatusEnum.CDELETED); // 删除
        newsOptlog.setInNewsStatusEnum(NewsStatusEnum.DRAFT);// 草稿
        newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.CDELETED);// 已删除
        newsOptlog.setOptUser(user);
        newsOptlog.setOptTime(new Date());
        try {
            newsOptLogMngService.add(newsOptlog);
            addSuccess(model, "删除成功");
            super.addLog(request, "删除通知公告草稿成功(标题:"+news.getTitle()+",创建人:"+news.getCreateUser().getName()+")");
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return "news/result";
    }
    
    /**
     * 
     * 方法说明:通知公告历史记录查询
     * @author WhiteYj
     * @date 2014-05-9 1420
     * @param id
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "log.dox")
    public String log(@RequestParam("id") String id, HttpSession session, HttpServletRequest request, Model model) throws IOException {
        model.addAttribute("newsOptlogs", newsOptLogMngService.findListById(id));
        model.addAttribute("news", newsMngService.findById(id));
        return "news/log/optlog";
    }
    
    /**
     * 
     * 方法说明:流程图发布转换
     * @author WhiteYj
     * @date 2014-05-12 0920
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/graphimage.dox", method = RequestMethod.GET)
    public String approveManage(@RequestParam("id") String id,HttpServletRequest request, Model model) {
        model.addAttribute("newsId", id);
        return "news/graphimage";
    }
    /**
     * 
     * 方法说明:流程图发布转换
     * @author WhiteYj
     * @date 2014-05-12 0920
     * @param id
     * @param session
     * @param request
     * @param response
     * @param model
     * @throws IOException
     */
    @RequestMapping(value = "/graph.dox")
    public void graph(@RequestParam("id") String id, HttpSession session, HttpServletRequest request,HttpServletResponse response, Model model) throws IOException {
        News news = newsMngService.findById(id);
        if(news.getStatus()==NewsStatusEnum.DELETED || // 删除
                news.getStatus()==NewsStatusEnum.DRAFT ||// 草稿
                news.getStatus()==NewsStatusEnum.PUBLISHED){// 已发布
            return;
        }
        if(news.getProcessInstanceId()==null){
            return;
        }
        InputStream is = null;
        try {
            is = this.graph(news.getProcessInstanceId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("image/png");
        OutputStream stream = response.getOutputStream();
        int bit;
        while((bit=is.read())!=-1){
         stream.write(bit);   
        }
        is.close();
        stream.flush();
        stream.close();
    }
    
    /**
     * 
     * 方法说明:通知公告审批引导页
     * @author WhiteYj
     * @date 2014-05-9 1710
     * @param id
     * @param processInstanceId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/approve/approve.do", method = RequestMethod.GET)
    public String newsApprove(@RequestParam("id") String id, @RequestParam("processInstanceId") String processInstanceId, Model model, HttpServletRequest request) {
        model.addAttribute("newsId", id);
        model.addAttribute("processInstanceId", processInstanceId);
        model.addAttribute("newsColumnEnum", NewsColumnsEnum.values());
        model.addAttribute("pageModel", newsMngService.findById(id));
        return "news/approve/approve";

    }
    /**
     * 
     * 方法说明:通知公告审批
     * @author WhiteYj
     * @date 2014-05-9 1710
     * @param pass
     * @param remark
     * @param id
     * @param processInstanceId
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/approve/approve.do", method = RequestMethod.POST)
    public String newsApproveForm(@RequestParam("pass") boolean pass,
            @RequestParam("remark") String remark,
            @RequestParam("id") String id,
            @RequestParam("processInstanceId") String processInstanceId,
            HttpServletRequest request, Model model) throws IOException {
        User user = getCurrentUser(request);
        try{
            String result = newsMngService.approve(id, remark, processInstanceId, pass, user);
            addSuccess(model, "通知公告审批"+(pass?"通过":"不通过"));
            super.addLog(request, "审批通知公告("+result+")");
        }catch (Exception e) {
            addSuccess(model, e.getMessage());
        }
        return "news/result";
    }
    
    /**
     * 方法说明:通知公告发布引导页
     * @author WhiteYj
     * @date 2014-05-12 1020
     * @param id
     * @param processInstanceId
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/publish.do", method = RequestMethod.GET)
    public String newsPublish(@RequestParam("id") String id, @RequestParam("processInstanceId") String processInstanceId, Model model, HttpServletRequest request) {
        model.addAttribute("newsId", id);
        model.addAttribute("processInstanceId", processInstanceId);
        model.addAttribute("newsColumnEnum", NewsColumnsEnum.values());
        model.addAttribute("pageModel", newsMngService.findById(id));
        return "news/approve/publish";
    }
    
    /**
     * 方法说明:通知公告发布
     * @author WhiteYj
     * @date 2014-05-12 1400
     * @param pass
     * @param remark
     * @param id
     * @param processInstanceId
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/publish.do", method = RequestMethod.POST)
    public String newsPublishForm(@RequestParam("pass") boolean pass,
            @RequestParam("remark") String remark,
            @RequestParam("id") String id,
            @RequestParam("processInstanceId") String processInstanceId,
            HttpServletRequest request, Model model) throws IOException {
        try {
            Map<String, Object> taskVariables = new HashMap<String, Object>();
            News news = newsMngService.findById(id);
            User user = getCurrentUser(request);
            NewsOptlog newsOptlog = new NewsOptlog();
            Task task1 = workflowService.getTaskByProcessInstaceId(news.getProcessInstanceId());
                    
            if(news.getStatus()==NewsStatusEnum.SECONDPASSED){// 事业部领导通过后可进行发布步骤
                taskVariables.put("isPublish", pass);
                newsOptlog.setInNewsStatusEnum(NewsStatusEnum.SECONDPASSED);// 事业部领导通过
                if (pass) {
                    news.setStatus(NewsStatusEnum.PUBLISHED);// 已经发布
                    newsOptlog.setNewsStatusEnum(NewsStatusEnum.PUBLISHED); //已发布
                    newsOptlog.setOutNewsStatusEnum(NewsStatusEnum.PUBLISHED);// 信息已经发布
                    //TODO 处理发布内容
                }else{
                    //TODO 发布取消
                }
            }else{
                throw new Exception("status参数错误");
            }
            workflowService.complete(task1.getId(), taskVariables);
            news.setPublishTime(new Date());
            newsMngService.update(news);
            //保存日志
            newsOptlog.setNews(news);
            newsOptlog.setOptUser(user);
            newsOptlog.setOptTime(new Date());
            String str = remark.length()>0?remark:"";
            newsOptlog.setInfo(str);
            try {
                newsOptLogMngService.add(newsOptlog);
                addSuccess(model, "发布完成");
                super.addLog(request, "发布通知公告成功(标题:"+news.getTitle()+",创建人:"+news.getCreateUser().getName()+",发布人:"+user.getName()+")");
            } catch (ServiceException e) {
                addError(model, "审批失败");
                e.printStackTrace();
            }
        } catch (ActivitiException e) {
            addError(model, "审批失败");
            if (e.getMessage().indexOf("no processes deployed with key") != -1) {
                logger.warn("没有部署流程!", e);
            } else {
                logger.error("启动请假流程失败：", e);
            }
        } catch (Exception e) {
            addError(model, "审批失败");
            logger.error("启动请假流程失败：", e);
        }
        return "news/result";
    }
    
    /**
     * 方法说明:查看页面引导
     * @author WhiteYj
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "find.do", method = RequestMethod.GET)
    public String findForm(@RequestParam("id") String id,HttpServletRequest request, Model model) {
        model.addAttribute("pageModel", newsMngService.findById(id));
        model.addAttribute("newsOptlogs", newsOptLogMngService.findListById(id));
        return "news/find";
    }
    
    /**
     * 方法说明:查看页面引导
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "browsefind.do", method = RequestMethod.GET)
    public String findBrowseForm(@RequestParam("id") String id,HttpServletRequest request, Model model) {
        model.addAttribute("pageModel", newsMngService.findById(id));
        model.addAttribute("newsOptlogs", newsOptLogMngService.findListById(id));
        return "news/find";
    }
    /**
     * 方法说明:加载待处理条数
     * @author：WhiteYj
     * @param：
     * @return：String
     */
    @RequestMapping(value = "ajaxLoad.dox",method = RequestMethod.GET)
    public String ajaxLoad(@ModelAttribute("queryModel") NewsQueryModel queryModel,
            @RequestParam("type")String type,HttpServletRequest request, Model model) throws IOException {
        User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
        String userId = user.getId();
        switch (type==null?"":type) {
        case "SPONSOR":// 待处理任务
            queryModel.setUser(user);
            queryModel.setInStatusEq(new NewsStatusEnum[]{
                    NewsStatusEnum.DRAFT,// 草稿
                    NewsStatusEnum.FIRSTDISSENT,
                    NewsStatusEnum.SECONDDISSENT});
            Long num = this.newsMngService.queryPage(queryModel).getTotalCount();
            model.addAttribute("returnStr","{\"result\":[],\"totalCount\":"+num+"}");
            return "returnnote";
        case "APPROVE":// 待批通知
            model.addAttribute("returnStr", 
                    "{\"result\":[],\"totalCount\":"+
                            newsMngService.getFlowNum(
                                    userId, 
                                    new NewsStatusEnum[]{
                                            NewsStatusEnum.SUBMITTED,
                                            NewsStatusEnum.MODIFIED,
                                            NewsStatusEnum.FIRSTPASSED
                            })+
                    "}");
            return "returnnote";
            
        case "PUBLISH":
            model.addAttribute("returnStr", 
                    "{\"result\":[],\"totalCount\":"+
                            newsMngService.getFlowNum(
                                    userId, 
                                    new NewsStatusEnum[]{NewsStatusEnum.SECONDPASSED
                            })+
                    "}");
            return "returnnote";
        default:
            return "returnnote";
        }
    }
    
    /**
     * 前台代办任务数量显示
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "approveNum.dox",method = RequestMethod.GET)
    public String approveNum(HttpServletRequest request, Model model) throws IOException {
        User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
        String userId = user.getId();
        List<News> listt = workflowService.findTodoTasks(userId);
        int i =0;
        for(News temp:listt){
            if(temp.getStatus()==NewsStatusEnum.SUBMITTED //部门经理审批
                || temp.getStatus()==NewsStatusEnum.MODIFIED
                || temp.getStatus()==NewsStatusEnum.FIRSTPASSED // 事业部领导审批
                || temp.getStatus()==NewsStatusEnum.SECONDPASSED// 待发布信息
                || temp.getStatus()==NewsStatusEnum.FIRSTDISSENT// 部门经理驳回
                || temp.getStatus()==NewsStatusEnum.SECONDDISSENT ){// 事业部驳回
                i++;
            }
        }
        model.addAttribute("returnStr", 
                "{\"totalCount\":"+i+"}");
        return "returnnote";
    }
}
