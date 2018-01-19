package cn.com.atnc.ioms.web.duty.atm;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayMgxTabEnum;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayTypeEnum;
import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDayMgxService;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDaySonService;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModelMgx;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 
 * @author 王志鹏
 * @time:2017年2月21日 上午10:08:33
 */
@Controller
@RequestMapping("/duty/atmday/mgx/")
public class MgxController extends MyBaseController {

    @Autowired
    private AtmDayMgxService atmDayMgxService;
    @Autowired
    private AtmDaySonService atmDaySonService;

    /**
     * 加载数据
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午10:12:13
     * @param queryModelMgx
     * @param atmType
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "manage.do", method = RequestMethod.GET)
    public String manage(
            @ModelAttribute("queryModel") AtmDayQueryModelMgx queryModelMgx,
            @RequestParam("atmType") AtmDayTypeEnum atmType,
            HttpServletRequest request, Model model) {
        model.addAttribute("atmType", atmType);
        super.pageInfo(model, request);
        return "duty/atmday/mgx/manage";
    }

    /**
     * 加载数据
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午10:22:22
     * @param queryModelMgx
     * @param tabType
     * @param request
     * @param model
     * @return
     */

    @RequestMapping(value = "manage.do", method = RequestMethod.POST)
    public String manageList(
            @ModelAttribute("queryModel") AtmDayQueryModelMgx queryModelMgx,
            @RequestParam("tabType") AtmDayMgxTabEnum tabType,
            HttpServletRequest request, Model model) {
        // 获取当前登陆用户
        User currentUser = (User) request.getSession().getAttribute(
                SessionNames.LOGIN_USER);
        model.addAttribute("currentUser", currentUser);
        // 默认访问通信基地8850
        if (ObjectUtils.equals(tabType, null)) {
            tabType = AtmDayMgxTabEnum.TXJD_8850;
        }
        // 得到TAB页类型
        model.addAttribute("tabType", tabType);
        queryModelMgx.setTabType(tabType);
        switch (tabType) {
        case TXJD_8850:
            model.addAttribute("pagn",
                    atmDayMgxService.queryPageByModel(queryModelMgx));
            return "duty/atmday/mgx/txjd8850/queryResult";
        case TXJD_8830:
            model.addAttribute("pagn",
                    atmDayMgxService.queryPageByModel(queryModelMgx));
            return "duty/atmday/mgx/txjd8830/queryResult";
        case SLH_8850:
            model.addAttribute("pagn",
                    atmDayMgxService.queryPageByModel(queryModelMgx));
            return "duty/atmday/mgx/slh8850/queryResult";
        case SLH_8830:
            model.addAttribute("pagn",
                    atmDayMgxService.queryPageByModel(queryModelMgx));
            return "duty/atmday/mgx/slh8830/queryResult";
        case MHJ_8850:
            model.addAttribute("pagn",
                    atmDayMgxService.queryPageByModel(queryModelMgx));
            return "duty/atmday/mgx/mhj8850/queryResult";
        case KGJ_8850:
            model.addAttribute("pagn",
                    atmDayMgxService.queryPageByModel(queryModelMgx));
            return "duty/atmday/mgx/kgj8850/queryResult";
        case CFZX_8830:
            model.addAttribute("pagn",
                    atmDayMgxService.queryPageByModel(queryModelMgx));
            return "duty/atmday/mgx/cfzx8830/queryResult";
        default:
            return "duty/atmday/mgx/txjd8850/queryResult";
        }     
    }

    /**
     * 添加页面跳转
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午10:27:58
     * @param pageModelMgx
     * @param model
     * @return
     */
    @RequestMapping(value = "add.do", method = RequestMethod.GET)
    public String addJump(
            @ModelAttribute("pageModel") AtmDayQueryModelMgx pageModelMgx,
            Model model) {
        // 状态结果枚举类
        List<StatusResultEnum> statusResults = Arrays.asList(StatusResultEnum
                .values());
        model.addAttribute("statusResults", statusResults);
        // 有无枚举类
        List<HaveNoEnum> haveNoStatus = Arrays.asList(HaveNoEnum.values());
        model.addAttribute("haveNoStatus", haveNoStatus);
        return "duty/atmday/mgx/add";
    }

    /**
     * 添加保存页面
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午10:30:13
     * @param pageModelMgx
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    public String add(
            @ModelAttribute("pageModel") AtmDayQueryModelMgx pageModelMgx,
            HttpServletRequest request, Model model) throws IOException {
        try {
            // 设置当前用户为操作人
            User user = (User) request.getSession().getAttribute(
                    SessionNames.LOGIN_USER);
            model.addAttribute("currentUser", user);
            atmDayMgxService.save(user, pageModelMgx);
            model.addAttribute("returnStr", new ResultModel(true,
                    "添加ATM设备巡检记录成功", null).toJson());
        } catch (Exception e) {

            System.err.println("add.do-post:" + e);
            logger.error("添加记录失败!", e);
            model.addAttribute("returnStr", new ResultModel(false,
                    "添加ATM设备巡检记录成功", null).toJson());
            return "returnnote";
        }
        return "returnnote";
    }

    /**
     * 更新跳转
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午10:41:44
     * @param pageModelMgx
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "update.do", method = RequestMethod.GET)
    public String updateJump(
            @ModelAttribute("pageModel") AtmDayQueryModelMgx pageModelMgx,
            @ModelAttribute("queryModel") AtmDayQueryModelMgx queryModelMgx,
            @RequestParam(value = "id") String id, Model model,
            @RequestParam("tabType") AtmDayMgxTabEnum tabType,
            HttpServletRequest tabRequest, Model tabModel) {
        // 状态结果枚举类
        List<StatusResultEnum> statusResults = Arrays.asList(StatusResultEnum
                .values());
        model.addAttribute("statusResults", statusResults);
        // 有无枚举类
        List<HaveNoEnum> haveNoStatus = Arrays.asList(HaveNoEnum.values());
        model.addAttribute("haveNoStatus", haveNoStatus);
        // 根据主键ID查找实体
        ATMDayMgx atmDayMgx = atmDayMgxService.findById(id);
        // 根据父类查找子类集合
        List<ATMDaySon> atmDaySons = atmDaySonService
                .findByRouteOrderBySerial(atmDayMgx);
        atmDayMgx.setAtmDaySons(atmDaySons);
        model.addAttribute("atmDayMgx", atmDayMgx);
        // 修改操作
        model.addAttribute("view", "0");
       // 得到TAB页类型
        model.addAttribute("tabType", tabType);
        queryModelMgx.setTabType(tabType);
        switch (tabType) {
        case TXJD_8850:
            return "duty/atmday/mgx/update";
        case TXJD_8830:
            return "duty/atmday/mgx/txjd8830/update";
        case SLH_8850:
            return "duty/atmday/mgx/slh8850/update";
        case SLH_8830:
            return "duty/atmday/mgx/slh8830/update";
        case MHJ_8850:
            return "duty/atmday/mgx/mhj8850/update";
        case KGJ_8850:
            return "duty/atmday/mgx/kgj8850/update";
        case CFZX_8830:
            return "/duty/atmday/mgx/cfzx8830/update";
        default:
            return "/duty/atmday/mgx/update";
        }    
    }

    /**
     * 更新
     * 
     * @author wangzhipeng
     * @time:2017年2月28日 下午2:15:49
     * @param pageModel1
     * @param id
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    public String update(
            @ModelAttribute("pageModel") AtmDayQueryModelMgx pageModelMgx, 
            @RequestParam("id") String id, HttpServletRequest request,
            Model model ) throws IOException {
           // 根据主键ID查找实体
        ATMDayMgx atmDayMgx = atmDayMgxService.findById(id);
        try {
            // 设置当前用户为操作人
            User user = (User) request.getSession().getAttribute(
                    SessionNames.LOGIN_USER);
            atmDayMgx = atmDayMgxService.update(user, atmDayMgx,
                    pageModelMgx);
            model.addAttribute("returnStr", new ResultModel(true, "更新记录成功",
                    atmDayMgx).toJson());
        } catch (Exception e) {
            logger.error("更新记录失败!", e);
            model.addAttribute("returnStr", new ResultModel(true, "更新记录失败",
                    atmDayMgx).toJson());
            return "returnnote";
        }
        return "returnnote";
    }
    
    /**
     * 审核页面跳转
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午10:53:02
     * @param pageModel1
     * @param id
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "audit.do", method = RequestMethod.GET)
    public String auditJump(
            @ModelAttribute("pageModel") AtmDayQueryModelMgx pageModelMgx,
            @ModelAttribute("queryModel") AtmDayQueryModelMgx queryModelMgx,
            @RequestParam(value = "id") String id, Model model,
            HttpServletRequest request,
            @RequestParam("tabType") AtmDayMgxTabEnum tabType,
            HttpServletRequest tabRequest, Model tabModel) {
        // 设置当前用户为操作人
        User user = (User) request.getSession().getAttribute(
                SessionNames.LOGIN_USER);
        model.addAttribute("currentUser", user);
        // 根据主键ID查找实体
        ATMDayMgx atmDayMgx = atmDayMgxService.findById(id);
        // 根据父类查找子类集合
        List<ATMDaySon> atmDaySons = atmDaySonService
                .findByRouteOrderBySerial(atmDayMgx);
        atmDayMgx.setAtmDaySons(atmDaySons);
        model.addAttribute("atmDayMgx", atmDayMgx);
        // 审核操作
        model.addAttribute("audit", "1");
        // 得到TAB页类型
        model.addAttribute("tabType", tabType);
        queryModelMgx.setTabType(tabType);
        switch (tabType) {
        case TXJD_8850:
            return "duty/atmday/mgx/audit";
        case TXJD_8830:
            return "duty/atmday/mgx/txjd8830/audit";
        case SLH_8850:
            return "duty/atmday/mgx/slh8850/audit";
        case SLH_8830:
            return "duty/atmday/mgx/slh8830/audit";
        case MHJ_8850:
            return "duty/atmday/mgx/mhj8850/audit";
        case KGJ_8850:
            return "duty/atmday/mgx/kgj8850/audit";
        case CFZX_8830:
            return "/duty/atmday/mgx/cfzx8830/audit";
        default:
            return "/duty/atmday/mgx/audit";
        }
    }

    /**
     * 审核
     * 
     * @author wangzhipeng
     * @time:2017年2月21日 上午10:54:40
     * @param pageModel1
     * @param id
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "audit.do", method = RequestMethod.POST)
    public String audit(
            @ModelAttribute("pageModel") AtmDayQueryModelMgx pageModelMgx,
            @RequestParam("id") String id, HttpServletRequest request,
            Model model) throws IOException {
        // 根据主键ID查找实体
        ATMDayMgx atmDayMgx = atmDayMgxService.findById(id);
        try {
            // 设置当前用户为操作人
            User user = (User) request.getSession().getAttribute(
                    SessionNames.LOGIN_USER);
            atmDayMgx = atmDayMgxService.audit(user, atmDayMgx,
                    pageModelMgx);
            model.addAttribute("returnStr", new ResultModel(true, "审核记录成功",
                    atmDayMgx).toJson());
        } catch (Exception e) {
            logger.error("审核记录失败!", e);
            model.addAttribute("returnStr", new ResultModel(true, "审核记录失败",
                    atmDayMgx).toJson());
            return "returnnote";
        }
        return "returnnote";
    } 

   /**
    * 查看信息
    * 
    * @author renyujuan
    * @time:2017年3月1日 下午4:07:28
    * @param queryModel1
    * @param id
    * @param model
    * @param tabType
    * @param tabRequest
    * @param tabModel
    * @return
    */
    @RequestMapping(value = "txjd8850/view.do", method = RequestMethod.GET)
    public String view(
            @ModelAttribute("queryModel") AtmDayQueryModelMgx queryModelMgx,
            @RequestParam("id") String id, Model model,
            @RequestParam("tabType") AtmDayMgxTabEnum tabType,
            HttpServletRequest tabRequest, Model tabModel) {
        // 根据主键ID查找实体
        ATMDayMgx atmDayMgx = atmDayMgxService.findById(id);
        model.addAttribute("atmDayMgx", atmDayMgx);
        // 根据父类查找子类集合
        List<ATMDaySon> atmDaySons = atmDaySonService
                .findByRouteOrderBySerial(atmDayMgx);
        atmDayMgx.setAtmDaySons(atmDaySons);
        model.addAttribute("atmDayMgx", atmDayMgx);
        // 查看操作
        model.addAttribute("view", "1");
        // 得到TAB页类型
        tabModel.addAttribute("tabType", tabType);
        queryModelMgx.setTabType(tabType);
        switch (tabType) {
        case TXJD_8850:
            return "duty/atmday/mgx/txjd8850/view";
        case TXJD_8830:
            return "duty/atmday/mgx/txjd8830/view";
        case SLH_8850:
            return "duty/atmday/mgx/slh8850/view";
        case SLH_8830:
            return "duty/atmday/mgx/slh8830/view";
        case MHJ_8850:
            return "duty/atmday/mgx/mhj8850/view";
        case KGJ_8850:
            return "duty/atmday/mgx/kgj8850/view";
        case CFZX_8830:
            return "/duty/atmday/mgx/cfzx8830/view";
        default:
            return "/duty/atmday/mgx/txjd8850/view";
        }  
    }
    
    /**
     * 刪除
     * 
     * @author wangzhipeng
     * @time:2017年3月1日 下午3:19:13
     * @param queryModel1
     * @param id
     * @param request
     * @param model
     * @param tabType
     * @param tabRequest
     * @param tabModel
     * @return
     */
    @RequestMapping(value = "delete.do", method = RequestMethod.POST)
    public String delete(
            @ModelAttribute("queryModel") AtmDayQueryModelMgx queryModelMgx,
            @RequestParam(value = "id", required = true) String id,
            HttpServletRequest request, Model model,
            @RequestParam("tabType") AtmDayMgxTabEnum tabType,
            HttpServletRequest tabRequest, Model tabModel) {
        // 根据主键ID查找实体
        ATMDayMgx atmDayMgx = atmDayMgxService.findById(id);
        // 级联删除
        atmDayMgxService.delete(atmDayMgx);
        addSuccess(model, "删除记录成功");
        // 记录日志
        super.addLog(request, "删除记录成功");
        // 得到TAB页类型
        tabModel.addAttribute("tabType", tabType);
        queryModelMgx.setTabType(tabType);
        switch (tabType) {
        case TXJD_8850:
            return "duty/atmday/mgx/txjd8850/result";
        case TXJD_8830:
            return "duty/atmday/mgx/txjd8830/result";
        case SLH_8850:
            return "duty/atmday/mgx/slh8850/result";
        case SLH_8830:
            return "duty/atmday/mgx/slh8830/result";
        case MHJ_8850:
            return "duty/atmday/mgx/mhj8850/result";
        case KGJ_8850:
            return "duty/atmday/mgx/kgj8850/result";
        case CFZX_8830:
            return "/duty/atmday/mgx/cfzx8830/result";
        default:
            return "duty/atmday/mgx/txjd8850/result";
        }
    }
}