package cn.com.atnc.ioms.web.duty.environment.psot;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.atnc.common.model.ResultModel;
import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.ContentCheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.environment.psot.CheckStatus;
import cn.com.atnc.ioms.enums.duty.environment.psot.DcPowerName;
import cn.com.atnc.ioms.enums.duty.environment.psot.DdnName;
import cn.com.atnc.ioms.enums.duty.environment.psot.NccName;
import cn.com.atnc.ioms.enums.duty.environment.psot.OticalName;
import cn.com.atnc.ioms.enums.duty.environment.psot.PdsName;
import cn.com.atnc.ioms.enums.duty.environment.psot.TxjdOticalName;
import cn.com.atnc.ioms.enums.duty.environment.psot.ZjOticalName;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.psot.PsOtAddForm;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 光端机设备巡检controller
 * @author renyujuan
 * @time:2016年8月17日 下午1:44:46
 */
@Controller
@RequestMapping("/duty/psotduty/otical/")
public class OticalController extends MyBaseController {

    @Autowired
    private EnvironmentEquipCheckService envirEquipCheckService;
    
    /**
     * 添加记录跳转
     * @author renyujuan
     * @time:2016年8月18日 上午9:27:37
     * @param psOtAddForm
     * @param checkType
     * @param model
     * @return
     */
    @RequestMapping(value="add.do", method=RequestMethod.GET)
    public String addJump(@ModelAttribute("pageModel") PsOtAddForm psOtAddForm,
            @RequestParam("checkType") CheckCatagory checkType,
            Model model) {
        //检查结果枚举类
        List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
        model.addAttribute("checkresult",checkResult);
        /*设备类型枚举类*/
        List<EquipType> equipType=Arrays.asList(EquipType.values());
        model.addAttribute("equipType", equipType);
        //检查状态枚举类
        List<CheckStatus> checkStatus=Arrays.asList(CheckStatus.values());
        model.addAttribute("checkStatus", checkStatus);
        List<ContentCheckResult> contentCheckResult=Arrays.asList(ContentCheckResult.values());
        model.addAttribute("contentCheckResult", contentCheckResult);
        //设备名称枚举类
        List<OticalName> oticalName=Arrays.asList(OticalName.values());
        model.addAttribute("oticalName", oticalName);
        model.addAttribute("checkType", checkType);
        return "/duty/psotduty/otical/add";
        
    }
    
    @SuppressWarnings("deprecation")
    @RequestMapping(value="add.do" , method=RequestMethod.POST)
    public String add(@ModelAttribute("pageModel") PsOtAddForm psOtAddForm,
            @RequestParam("checkType") CheckCatagory checkType,
            @RequestParam("equipType") EquipType equipType,
            HttpServletRequest request, Model model) throws IOException {
        try {
            /*设置当前用户为操作人*/
            User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
            psOtAddForm.setOperator(user);
            /*设置当前系统时间为巡检时间*/
            psOtAddForm.setCheckTime(new Date().toLocaleString());
            psOtAddForm.setCheckDate(psOtAddForm.getCheckTime());
            /*设置设备类型和检查类型*/
            psOtAddForm.setCheckType(checkType);
            psOtAddForm.setEquipType(equipType);
            /*将记录保存至数据库*/
            envirEquipCheckService.savePsOtCheck(psOtAddForm);
            model.addAttribute("currentUser", user);
            model.addAttribute("returnStr", new ResultModel(true, "添加传输设备与通讯线路巡检记录成功", psOtAddForm).toJson());
        } catch (Exception e) {
            logger.error("添加记录失败!", e);
            model.addAttribute("returnStr", new ResultModel(false, "添加传输设备与通讯线路巡检记录成功",
                    psOtAddForm).toJson());
            return "returnnote";
        }
        return "returnnote";
    }
    
    /**
     * 详情查看
     * @author renyujuan
     * @time:2016年8月18日 下午12:26:54
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="view.do", method=RequestMethod.GET)
    public String view(@RequestParam("id") String id,
            HttpServletRequest request, Model model) {
        EnvironmentEquipCheck psOtCheck = envirEquipCheckService.findById(id);
        model.addAttribute("psOtCheck", psOtCheck);
        /*model.addAttribute("view", true);*/
        return "/duty/psotduty/otical/view";
    }
    
    /**
     * 更新记录跳转
     * @author renyujuan
     * @time:2016年8月18日 下午12:29:45
     * @param psOtAddForm
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="update.do" , method=RequestMethod.GET)
    public String updateJump(@ModelAttribute("pageModel") PsOtAddForm psOtAddForm,
            @RequestParam(value="id", required= true) String id,
            HttpServletRequest request, Model model){
        /*检查结果枚举类*/
        List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
        model.addAttribute("checkresult",checkResult);
        //检查状态枚举类
        List<CheckStatus> checkStatus=Arrays.asList(CheckStatus.values());
        model.addAttribute("checkStatus", checkStatus);
        List<ContentCheckResult> contentCheckResult=Arrays.asList(ContentCheckResult.values());
        model.addAttribute("contentCheckResult", contentCheckResult);
        EnvironmentEquipCheck psOtCheck = envirEquipCheckService.findById(id);
        model.addAttribute("psOtCheck", psOtCheck);
        return "duty/psotduty/otical/update";
                
    }
    
    /**
     * 更新记录
     * @author renyujuan
     * @time:2016年8月18日 下午12:31:20
     * @param psOtAddForm
     * @param id
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value="update.do", method=RequestMethod.POST)
    public String update(@ModelAttribute("pageModel") PsOtAddForm psOtAddForm,
            @RequestParam("id") String id,
            HttpServletRequest request, Model model) throws IOException{
        try {
            /*根据id查找相应的柴油发电机巡检记录*/
            EnvironmentEquipCheck psOtCheck = envirEquipCheckService.findById(id);
            //System.err.println(psOtCheck.toString());
            envirEquipCheckService.updatePsOtCheck(psOtCheck, psOtAddForm);
            model.addAttribute("returnStr",
                    new ResultModel(true, "更新记录成功", psOtAddForm).toJson());
        } catch (Exception e) {
            logger.error("更新记录失败!", e);
            model.addAttribute("returnStr",
                    new ResultModel(true, "更新记录失败", psOtAddForm).toJson());
            return "returnnote";
        }
        return "returnnote";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
