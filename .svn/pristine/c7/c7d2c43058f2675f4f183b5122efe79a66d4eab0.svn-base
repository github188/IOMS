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
 * 直流电源设备巡检controller
 * @author renyujuan
 * @time:2016年8月17日 下午1:44:46
 */
@Controller
@RequestMapping("/duty/psotduty/dcp/")
public class DcpController extends MyBaseController {

    @Autowired
    private EnvironmentEquipCheckService envirEquipCheckService;
    @Autowired
    private EnvironmentEquipCheckDao envirEquipCheckDao;
    
    /**
     * 页面初始化
     * @author renyujuan
     * @time:2016年8月17日 下午1:49:11
     * @param queryModel
     * @param checkType
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="manage.do", method=RequestMethod.GET)
    public String manage(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
            @RequestParam("checkType") CheckCatagory checkType,
            HttpServletRequest request, Model model){
        List<DcPowerName> dcpName = Arrays.asList(DcPowerName.values());
        model.addAttribute("dcpName", dcpName);
        List<EquipType> equipType=Arrays.asList(EquipType.values());
        model.addAttribute("equipType", equipType);
        model.addAttribute("checkType", checkType);
        /*System.err.println(checkType.toString());*/
        super.pageInfo(model, request);
        return "duty/psotduty/dcp/manage";
    }
    
    
    /**
     * 加载数据
     * @author renyujuan
     * @time:2016年8月17日 下午1:58:51
     * @param queryModel
     * @param checkType
     * @param equipType
     * @param optType
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="manage.do" , method=RequestMethod.POST)
    public String manageList(
            @ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel,
            @RequestParam("checkType") CheckCatagory checkType,
            @RequestParam("equipType") EquipType equipType,
            @RequestParam("optType") String optType,
            HttpServletRequest request, Model model) {
        //记录填写人
        User currentUser = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
        queryModel.setEquipType(equipType);
        queryModel.setCheckType(checkType);
        /*System.err.println(checkType);*/
        model.addAttribute("optType",optType);
        model.addAttribute("checkType", checkType);
        model.addAttribute("currentUser", currentUser);
        /*System.err.println(optType);*/
        switch(optType == null ? "" : optType){
        case "dcpCheck":
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel) );
            return "/duty/psotduty/dcp/queryResult";
        case "oticalCheck":
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
            return "/duty/psotduty/otical/queryResult";
        case "zjOticalCheck":
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
            return "/duty/psotduty/zjotical/queryResult";
        case "txjdOticalCheck":
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
            return "/duty/psotduty/txjdotical/queryResult";
        case "ddnCheck":
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
            return "/duty/psotduty/ddn/queryResult";
        case "nccCheck":
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
            return "/duty/psotduty/ncc/queryResult";
        case "slhPdsCheck":
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
            return "/duty/psotduty/slhpds/queryResult";
        case "txjdPdsCheck":
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel));
            return "/duty/psotduty/txjdpds/queryResult";
        default:
            model.addAttribute("pagn", envirEquipCheckService.queryPageByModel(queryModel) );
            return "/duty/psotduty/dcp/queryResult";
        }
    }
    
    
    /**
     * 加载设备名称
     * @author renyujuan
     * @time:2016年8月17日 下午2:00:16
     * @param queryModel
     * @param optType
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "ajaxEquip.dox", method = RequestMethod.GET)
    public String ajaxEquip(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel, 
            @RequestParam("optType") String optType,
            HttpServletRequest request, Model model) throws IOException {
        switch(optType == null ? "" : optType) {
        case "dcpCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(DcPowerName.values()));
            break;
        case "oticalCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(OticalName.values()));
            break;
        case "zjOticalCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(ZjOticalName.values()));
            break;
        case "txjdOticalCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(TxjdOticalName.values()));
            break;
        case "ddnCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(DdnName.values()));
            break;
        case "nccCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(NccName.values()));
            break;
        case "slhPdsCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(PdsName.values()));
            break;
        case "txjdPdsCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(PdsName.values()));
            break;
        default:
            model.addAttribute("returnStr", JacksonTools.toJsonStr(DcPowerName.values()));
            break;
        }
        return "returnnote";
    } 
    
    /**
     * 冒泡显示记录条数
     * @author renyujuan
     * @time:2016年8月17日 下午2:00:41
     * @param queryModel
     * @param optType
     * @param checkType
     * @param equipType
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value="ajaxLoad.dox", method=RequestMethod.GET)
    public String ajaxLoad(@ModelAttribute("queryModel") EnvironmentCheckQueryModel queryModel, 
            @RequestParam("optType") String optType,
            @RequestParam("checkType") CheckCatagory checkType,
            @RequestParam("equipType") EquipType equipType,
            HttpServletRequest request, Model model) throws IOException{
        //设置设备类别和巡检类型
        queryModel.setCheckType(checkType);
        queryModel.setEquipType(equipType);
        switch(optType == null ? "" : optType){
        case "dcpCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        case "oticalCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        case "zjOticalCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        case "txjdOticalCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        case "ddnCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        case "nccCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        case "slhPdsCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        case "txjdPdsCheck":
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        default:
            model.addAttribute("returnStr", JacksonTools.toJsonStr(envirEquipCheckDao.queryPageByModel(queryModel)));
            break;
        }
        return "returnnote";
    }
    
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
        List<DcPowerName> dcpName=Arrays.asList(DcPowerName.values());
        model.addAttribute("dcpName", dcpName);
        model.addAttribute("checkType", checkType);
        return "/duty/psotduty/dcp/add";
        
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
        return "/duty/psotduty/dcp/view";
    }
    
    /**
     * 删除记录
     * @author renyujuan
     * @time:2016年8月18日 下午12:27:17
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="delete.do", method=RequestMethod.POST)
    public String delete(@RequestParam(value="id" , required = true) String id,
            HttpServletRequest request, Model model){
        try {
            EnvironmentEquipCheck psOtCheck=envirEquipCheckService.findById(id);
            envirEquipCheckService.delete(psOtCheck);
            addSuccess(model, "删除记录成功");
            super.addLog(request, "删除记录成功");
        } catch (Exception e) {
            addError(model, "删除记录失败：" + e.getMessage());
        }
        return "duty/psotduty/dcp/result";
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
        return "duty/psotduty/dcp/update";
                
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
