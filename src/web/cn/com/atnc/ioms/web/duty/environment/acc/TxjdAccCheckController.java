package cn.com.atnc.ioms.web.duty.environment.acc;

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
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.environment.acc.SlhImosen;
import cn.com.atnc.ioms.enums.duty.environment.acc.TxjdAcc;
import cn.com.atnc.ioms.enums.duty.environment.ups.KuUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.SlhUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.TxjdUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.ZjUpsName;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.acc.AccAddForm;
import cn.com.atnc.ioms.model.duty.environment.dg.DgAddForm;
import cn.com.atnc.ioms.web.MyBaseController;

/**
 * 空调设备通信基地巡检controller
 * @author renyujuan
 * @time:2016年8月16日 上午8:46:13
 */
@Controller
@RequestMapping("/duty/accduty/txjd/")
public class TxjdAccCheckController extends MyBaseController {

    @Autowired
    private EnvironmentEquipCheckService envirEquipCheckService;
    
    /**
     * 添加记录跳转
     * @author renyujuan
     * @time:2016年8月12日 下午4:08:43
     * @param accAddForm
     * @param checkType
     * @param model
     * @return
     */
    @RequestMapping(value="add.do", method=RequestMethod.GET)
    public String addJump(@ModelAttribute("pageModel") AccAddForm accAddForm,
            @RequestParam("checkType") CheckCatagory checkType,
            Model model
            ) {
        //检查结果枚举类
        List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
        model.addAttribute("checkresult",checkResult);
        /*设备类型枚举类*/
        List<EquipType> equipType=Arrays.asList(EquipType.values());
        model.addAttribute("equipType", equipType);
        //设备名称枚举类
        List<TxjdAcc> txjdAcc = Arrays.asList(TxjdAcc.values());
        model.addAttribute("txjdAcc", txjdAcc);
        model.addAttribute("checkType", checkType);
        return "/duty/accduty/txjd/add";
    }
    
    /**
     * 添加空调设备巡检记录
     * @author renyujuan
     * @time:2016年8月15日 上午11:10:49
     * @param accAddForm
     * @param equipType
     * @param checkType
     * @param request
     * @param model
     * @return
     * @throws IOException 
     */
    @SuppressWarnings("deprecation")
    @RequestMapping(value="add.do", method=RequestMethod.POST)
    public String add(@ModelAttribute("pageModel") AccAddForm accAddForm,
            @RequestParam("equipType") EquipType equipType,
            @RequestParam("checkType") CheckCatagory checkType,
            HttpServletRequest request, Model model) throws IOException {
        try {
            /*设置当前用户为操作人*/
            User user = (User) request.getSession().getAttribute(SessionNames.LOGIN_USER);
            accAddForm.setOperator(user);
            /*设置当前系统时间为巡检时间*/
            accAddForm.setCheckTime(new Date().toLocaleString());
            accAddForm.setCheckDate(accAddForm.getCheckTime());
            /*设置设备类型和检查类型*/
            accAddForm.setCheckType(checkType);
            accAddForm.setEquipType(equipType);
            /*将记录保存至数据库*/
            envirEquipCheckService.saveAccCheck(accAddForm);
            model.addAttribute("currentUser", user);
            model.addAttribute("returnStr", new ResultModel(true, "添加空调设备巡检记录成功", accAddForm).toJson());
        } catch (Exception e) {
            logger.error("添加记录失败!", e);
            model.addAttribute("returnStr", new ResultModel(false, "添加空调设备巡检记录成功",
                    accAddForm).toJson());
            return "returnnote";
        }
        return "returnnote";
    }
    
    /**
     * 查看记录详情
     * @author renyujuan
     * @time:2016年8月15日 下午2:28:10
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="view.do", method=RequestMethod.GET)
    public String view(@RequestParam("id") String id,
            HttpServletRequest request, Model model) {
        EnvironmentEquipCheck accCheck = envirEquipCheckService.findById(id);
        model.addAttribute("accCheck", accCheck);
        /*model.addAttribute("view", true);*/
        return "/duty/accduty/txjd/view";
    }
    
    /**
     * 删除记录
     * @author renyujuan
     * @time:2016年8月15日 下午2:29:09
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="delete.do", method=RequestMethod.POST)
    public String delete(@RequestParam(value="id" , required = true) String id,
            HttpServletRequest request, Model model){
        try {
            EnvironmentEquipCheck accCheck=envirEquipCheckService.findById(id);
            envirEquipCheckService.delete(accCheck);
            addSuccess(model, "删除记录成功");
            super.addLog(request, "删除记录成功");
        } catch (Exception e) {
            addError(model, "删除记录失败：" + e.getMessage());
        }
        return "duty/accduty/txjd/result";
    }
    
    /**
     * 跟新记录跳转
     * @author renyujuan
     * @time:2016年8月15日 下午2:59:33
     * @param accAddForm
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value="update.do" , method=RequestMethod.GET)
    public String updateJump(@ModelAttribute("pageModel") AccAddForm accAddForm,
            @RequestParam(value="id", required= true) String id,
            HttpServletRequest request, Model model){
        /*检查结果枚举类*/
        List<CheckResult> checkResult=Arrays.asList(CheckResult.values());
        model.addAttribute("checkresult",checkResult);
        EnvironmentEquipCheck accCheck = envirEquipCheckService.findById(id);
        model.addAttribute("accCheck", accCheck);
        return "duty/accduty/txjd/update";
                
    }
    
    /**
     * 更新记录
     * @author renyujuan
     * @time:2016年8月15日 下午3:00:03
     * @param dgAddForm
     * @param id
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value="update.do", method=RequestMethod.POST)
    public String update(@ModelAttribute("pageModel") AccAddForm accAddForm,
            @RequestParam("id") String id,
            HttpServletRequest request, Model model) throws IOException{
        try {
            /*根据id查找相应的柴油发电机巡检记录*/
            EnvironmentEquipCheck accCheck = envirEquipCheckService.findById(id);
            envirEquipCheckService.updateAccCheck(accCheck, accAddForm);
            model.addAttribute("returnStr",
                    new ResultModel(true, "更新记录成功", accAddForm).toJson());
        } catch (Exception e) {
            logger.error("添加记录失败!", e);
            model.addAttribute("returnStr",
                    new ResultModel(true, "更新记录失败", accAddForm).toJson());
            return "returnnote";
        }
        return "returnnote";
    }
}
    
    
      
