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
 * 通信基地楼内综合布线设备巡检controller
 * @author renyujuan
 * @time:2016年8月17日 下午1:44:46
 */
@Controller
@RequestMapping("/duty/psotduty/txjdpds/")
public class TxjdPdsController extends MyBaseController {

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
        //设备名称枚举类
        List<PdsName> pdsName=Arrays.asList(PdsName.values());
        model.addAttribute("pdsName", pdsName);
        model.addAttribute("checkType", checkType);
        return "/duty/psotduty/txjdpds/add";
        
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
