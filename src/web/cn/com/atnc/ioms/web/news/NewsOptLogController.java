package cn.com.atnc.ioms.web.news;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.news.NewsColumnsEnum;
import cn.com.atnc.ioms.enums.news.NewsLogSearchEnum;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
import cn.com.atnc.ioms.enums.news.NewsStatusSearchEnum;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.news.INewsOptLogMngService;
import cn.com.atnc.ioms.model.news.NewsOptLogQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller("newsOptLogController")
@RequestMapping("/news/log/")
public class NewsOptLogController extends MyBaseController {
    @Autowired
    private INewsOptLogMngService newsOptLogMngService;
    @Autowired
    private IUserManager userManager;
    /**
     * 方法说明：通知公告日志管理
     * 
     * @author WhiteYj
     * @date：2014-5-7 1609
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/manage.do", method = RequestMethod.GET)
    public String manage(@ModelAttribute("queryModel") NewsOptLogQueryModel queryModel, Model model, HttpServletRequest request) {
        model.addAttribute("newsColumnsEnum", NewsColumnsEnum.values());
        model.addAttribute("newsStatusEnum", NewsLogSearchEnum.values());
        super.pageInfo(model, request);
        return "news/log/manage";
    }
    
    /**
     * 
     * 方法说明：获取通知公告数据记录
     * 
     * @author WhiteYj
     * @date：2014-5-7 1711
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/manage.do", method = RequestMethod.POST)
    public String manageData(HttpSession session, @ModelAttribute("queryModel") NewsOptLogQueryModel queryModel, Model model, HttpServletRequest request) throws IOException {
        User user = userManager.findById(getCurrentUser(request).getId());
        String currentUserId = user.getId();
        logger.debug("newsUserId:" + currentUserId);
        model.addAttribute("pagn", this.newsOptLogMngService.queryPage(queryModel));
        logger.debug("newsUserRole:" + user.getRoleNames());
        return "news/log/queryResult";
    }
    

    /**
     * 方法说明：已审批通告记录引导
     * 
     * @author WhiteYj
     * @date：2014-5-7 1609
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "already/manage.do", method = RequestMethod.GET)
    public String already(@ModelAttribute("queryModel") NewsOptLogQueryModel queryModel, Model model, HttpServletRequest request) {
        model.addAttribute("newsStatusEnum", NewsStatusSearchEnum.values());
        super.pageInfo(model, request);
        return "news/already/manage";
    }
    /**
     * 
     * 方法说明：获取通知公告已审批通告记录
     * 
     * @author WhiteYj
     * @date：2014-5-7 1711
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "already/manage.do", method = RequestMethod.POST)
    public String alreadyData(HttpSession session, @ModelAttribute("queryModel") NewsOptLogQueryModel queryModel, Model model, HttpServletRequest request) throws IOException {
        User user = userManager.findById(getCurrentUser(request).getId());
        String currentUserId = user.getId();
        
        // 根据ID查询已审批的记录
        NewsStatusEnum str[] = {NewsStatusEnum.DRAFT,NewsStatusEnum.DELETED,NewsStatusEnum.FIRSTDISSENT,NewsStatusEnum.SECONDDISSENT};
        queryModel.setOptUserEq(user.getLoginName());
        queryModel.setInStatusEq(str);
        
        logger.debug("userId:" + currentUserId);
        model.addAttribute("pagn", this.newsOptLogMngService.queryPage(queryModel));
        logger.debug("userRole:" + user.getRoleNames());
        return "news/already/queryResult";
    }
}
