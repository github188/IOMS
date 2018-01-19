package cn.com.atnc.ioms.web.operstat.tes;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.tes.TesService;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerStat;
import cn.com.atnc.ioms.mng.acl.IRoleResourceManager;
import cn.com.atnc.ioms.mng.acl.IUserManager;
import cn.com.atnc.ioms.mng.basedata.tes.ITesNodeManager;
import cn.com.atnc.ioms.mng.basedata.tes.ITesServiceManager;
import cn.com.atnc.ioms.mng.basedata.tes.ITesSlotManager;
import cn.com.atnc.ioms.mng.operstat.tes.ITesStatService;
import cn.com.atnc.ioms.model.basedata.tes.TesNodeQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesSlotQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesTxPowerQueryModel;
import cn.com.atnc.ioms.web.MyBaseController;

@Controller("tesStatController")
@RequestMapping("/operstat/tes/")
public class TesStatController extends MyBaseController {
    @Autowired
    private ITesStatService tesStatService;
    @Autowired
    private IUserManager userManager;
    @Autowired
    private IRoleResourceManager roleResourceManager;
    @Autowired    
    private ITesNodeManager tesNodeManager;
    @Autowired    
    private ITesSlotManager tesSlotManager;
    @Autowired
    private ITesServiceManager tesServiceManager;
    
    private String tesServiceQueryModelName = "tesServiceQueryModel";
    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH : mm");
    private SimpleDateFormat datess = new SimpleDateFormat("yyyy-MM-dd");
    
    
    public Object getMinKey(Map<Integer,String> map){
        if(map==null) return null;
        Set<Integer> set = map.keySet();
        Object[] obj = set.toArray();
        Arrays.sort(obj);
        return obj[0];
    }
    
    /**
     * 引导显示tes异常点数和正常点数
     * 
     * @author WhiteYj
     * @date：2014-5-26 0950
     * @param queryModel
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "stat/manage.do", method = RequestMethod.GET)
    public String manage(@ModelAttribute("queryModel") TesStatQueryModel queryModel, Model model, HttpServletRequest request) {
        User user = userManager.findById(getCurrentUser(request).getId());
        List<Resource> res= roleResourceManager.listResourceByRoles(user.getRoles());
        Map<Integer,String> map = new HashMap<>();
        for(Resource te:res){
            if(te.getId().equals("tesstat")){
                map.put(1, "STAT");
            }
        }
        model.addAttribute("optType",map.get(getMinKey(map)));
        super.pageInfo(model, request);
        return "operstat/tes/stat/manage";
    }
    /**
     * 引导显示tespower页
     * @param queryModel
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "stat/find.do", method = RequestMethod.GET)
    public String findTxPower(@RequestParam("id") String id,@ModelAttribute("queryModel") TesTxPowerQueryModel queryModel,Model model, HttpServletRequest request) {
        model.addAttribute("pageModel", tesStatService.findById(id));
        super.pageInfo(model, request);
        return "operstat/tes/stat/find";
    }

    /**
     * 引导显示tespower页
     * @param queryModel
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "node/find.dox", method = RequestMethod.GET)
    public String findTesLog(@RequestParam("tesnode") String tesnode,
                            @RequestParam("tescu") String tescu,
                            @ModelAttribute("queryModel") TesTxPowerQueryModel queryModel,
                            Model model, HttpServletRequest request) {
        model.addAttribute("tesnode",tesnode);
        model.addAttribute("tescu",tescu);
        super.pageInfo(model, request);
        return "operstat/tes/node/find";
    }

    /**
     * 查询节点日志页
     * @param tesnode
     * @param tescu
     * @param queryModel
     * @param session
     * @param model
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "node/find.dox", method = RequestMethod.POST)
    public String managelog(
            @RequestParam("tesnode") String tesnode,
            @RequestParam("tescu") String tescu,
            @ModelAttribute("queryModel") TesStatQueryModel queryModel,
            HttpSession session, Model model, HttpServletRequest request) throws IOException {
        queryModel.setTesnode(tesnode);
        queryModel.setCu(tescu);
        model.addAttribute("pagn", this.tesStatService.queryLogPage(queryModel));
        model.addAttribute("optType","LOG");
        return "operstat/tes/log/queryResult";
            
    }
    /**
     * 
     * 方法说明：获取节点信息
     * 
     * @author WhiteYj
     * @date：2014-5-28 1511
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "power/manage.dox", method = RequestMethod.POST)
    public String manageData(@RequestParam("statid") String statid,
            @ModelAttribute("queryModel") TesTxPowerQueryModel queryModel,
            @RequestParam("optType")String optType,
            HttpSession session, Model model, HttpServletRequest request) throws IOException {
        User user = userManager.findById(getCurrentUser(request).getId());
        TesTxPowerStat stat = tesStatService.findById(statid);
        queryModel.setStat(stat);
        String currentUserId = user.getId();
        switch (optType==null?"":optType) {
        case "POWER":
            logger.debug("newsUserId:" + currentUserId);
            model.addAttribute("pagn", this.tesStatService.queryTxPowerPage(queryModel));
            logger.debug("newsUserRole:" + user.getRoleNames());
            return "operstat/tes/power/queryResult";
        case "NODE":
            logger.debug("newsUserId:" + currentUserId);
            model.addAttribute("pagn", this.tesStatService.querySQLPage(queryModel));
            logger.debug("newsUserRole:" + user.getRoleNames());
            return "operstat/tes/node/queryResult";
        default:
            model.addAttribute("pagn", this.tesStatService.queryTxPowerPage(queryModel));
            return "operstat/tes/power/queryResult";
        }
            
    }
    
    /**
     * 
     * 方法说明：根据OPTTYPE传值不同显示不同内容数据记录
     * 
     * @author WhiteYj
     * @date：2014-5-26 0950
     * @param session
     * @param request
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "tab/manage.do", method = RequestMethod.POST)
    public String tabData(HttpSession session, 
            @ModelAttribute("queryModel") TesStatQueryModel queryModel, 
            @RequestParam("optType")String optType,
            Model model, HttpServletRequest request) throws IOException {
        User user = userManager.findById(getCurrentUser(request).getId());
        String userId = user.getId();
        logger.debug("newsUserId:" + userId);
        logger.debug("newsUserRole:" + user.getRoleNames());
        
        List<TesTxPowerStat> list = null;
        String datetime ="";
        String overvalue ="";
        String normal ="";
        int overvaluesum = 0;
        int normalsum=0;
        int i=0;
        switch (optType==null?"":optType) {
        case "STAT":
            if(StringUtils.isEmpty(queryModel.getStartStatTime()) && StringUtils.isEmpty(queryModel.getEndStatTime())){
                String tdate = datess.format(new Date());
                String[] edate = tdate.split("-");
                int dd = Integer.parseInt(edate[1])-1;
                if(dd==0) edate[1]="12";
                if(dd>=10) edate[1]=""+dd;else edate[1]="0"+dd;
                queryModel.setStartStatTime(edate[0]+"-"+edate[1]+"-"+edate[2]);
                queryModel.setEndStatTime(tdate);
            }
            model.addAttribute("pagn", this.tesStatService.queryPage(queryModel));
            model.addAttribute("optType","STAT");
            list = this.tesStatService.findlist(queryModel);
            for(int j=list.size()-1;j>=0;j--){
                TesTxPowerStat stat = list.get(j);
                datetime+="'"+date.format(stat.getStatDate().getTime())+"'";
                overvalue+=stat.getOver();
                normal+=stat.getNormal();
                if(i<list.size()){
                    datetime+=",";
                    overvalue+=",";
                    normal+=",";
                }
                overvaluesum+=stat.getOver();
                normalsum+=stat.getNormal();
                i++;
            }
            model.addAttribute("datetime",datetime);
            model.addAttribute("overvalue",overvalue);
            model.addAttribute("normal",normal);
            model.addAttribute("overvaluesum",overvaluesum);
            model.addAttribute("normalsum",normalsum);
            return "operstat/tes/stat/queryResult";
        case "NODE":
            model.addAttribute("pagn", this.tesServiceManager.queryPage(queryModel));
            session.setAttribute(tesServiceQueryModelName, queryModel);
            model.addAttribute("optType","NODE");
            return "operstat/tes/service/queryResult";
        case "LOG":
            model.addAttribute("pagn", this.tesStatService.queryLogPage(queryModel));
            model.addAttribute("optType","LOG");
            return "operstat/tes/log/queryResult";
        default:
            List<Resource> res= roleResourceManager.listResourceByRoles(user.getRoles());
            Map<Integer,String> map = new HashMap<>();
            for(Resource te:res){
                if(te.getId().equals("tesstat")){
                    map.put(1, "tesstat");
                }else if(te.getId().equals("tesnode")){
                    map.put(2, "tesnode");
                }
            }
            if(getMinKey(map)!=null){
                String resname = map.get(getMinKey(map));
                if(resname.equals("tesstat")){
                    if(StringUtils.isEmpty(queryModel.getStartStatTime()) && StringUtils.isEmpty(queryModel.getEndStatTime())){
                        String tdate = datess.format(new Date());
                        String[] edate = tdate.split("-");
                        int dd = Integer.parseInt(edate[1])-1;
                        if(dd==0) edate[1]="12";
                        if(dd>=10) edate[1]=""+dd;else edate[1]="0"+dd;
                        queryModel.setStartStatTime(edate[0]+"-"+edate[1]+"-"+edate[2]);
                        queryModel.setEndStatTime(tdate);
                    }
                    model.addAttribute("pagn", this.tesStatService.queryPage(queryModel));
                    model.addAttribute("optType","STAT");
                    list = this.tesStatService.findlist(queryModel);
                    for(int j=list.size()-1;j>=0;j--){
                        TesTxPowerStat stat = list.get(j);
                        datetime+="'"+date.format(stat.getStatDate().getTime())+"'";
                        overvalue+=stat.getOver();
                        normal+=stat.getNormal();
                        if(i<list.size()){
                            datetime+=",";
                            overvalue+=",";
                            normal+=",";
                        }
                        overvaluesum+=stat.getOver();
                        normalsum+=stat.getNormal();
                        i++;
                    }
                    model.addAttribute("datetime",datetime);
                    model.addAttribute("overvalue",overvalue);
                    model.addAttribute("normal",normal);
                    model.addAttribute("overvaluesum",overvaluesum);
                    model.addAttribute("normalsum",normalsum);
                    return "operstat/tes/stat/queryResult";
                }else if(resname.equals("tesnode")){
                    model.addAttribute("pagn", this.tesServiceManager.queryPage(queryModel));
                    session.setAttribute(tesServiceQueryModelName, queryModel);
                    model.addAttribute("optType","NODE");
                    return "operstat/tes/service/queryResult";
                }else if(resname.equals("teslog")){
                    model.addAttribute("pagn", this.tesStatService.queryLogPage(queryModel));
                    model.addAttribute("optType","LOG");
                    return "operstat/tes/log/queryResult";
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
    /**
     * 设备节点下拉列表获取
     * @param code
     * @param model
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "equipcode.dox", method = RequestMethod.GET)
    public String equipCode(@RequestParam("code") String code,Model model, HttpServletRequest request)
            throws IOException {
        TesNodeQueryModel qm = new TesNodeQueryModel();
        qm.setTesNodeCodeLike(code);
        try {
            model.addAttribute("returnStr",JacksonTools.toJsonStr(tesNodeManager.queryList(qm)));
        } catch (IOException e) {
            model.addAttribute("returnStr", "[]");
        }
        return "returnnote";

    }
    /**
     * 站点下拉列表获取
     * @param code
     * @param tesnodecode
     * @param model
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "nodecucode.dox", method = RequestMethod.GET)
    public String nodecuCode(@RequestParam("code") String code,@RequestParam("tesnodecode") String tesnodecode,Model model, HttpServletRequest request)
            throws IOException {
        TesSlotQueryModel qm = new TesSlotQueryModel();
        qm.setCuLike(code);
        qm.setTesNodeCodeEq(tesnodecode);
        try {
            model.addAttribute("returnStr",JacksonTools.toJsonStr(tesSlotManager.queryList(qm)));
        } catch (IOException e) {
            model.addAttribute("returnStr", "[]");
            e.printStackTrace();
        }
        return "returnnote";

    }

    /**
     * 报警站点下拉列表
     * @param model
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "teswarninglist.dox", method = RequestMethod.GET)
    public String tesSlotWarningList(Model model, HttpServletRequest request) throws IOException{
        model.addAttribute("returnStr",JacksonTools.toJsonStr(tesStatService.tesSlotWarningList()));
        return "returnnote";
    }

    /**
     * 异常节点修改界面
     * @param id
     * @param equip
     * @param nodecu
     * @param session
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    public String update(@RequestParam("id") String id,
            @RequestParam("equip") String equip,
            @RequestParam("nodecu") String nodecu,
            HttpSession session, HttpServletRequest request, Model model) {
        User user = userManager.findById(getCurrentUser(request).getId());
        try {
            String reStr = tesStatService.save(equip,nodecu,id,user);
            super.addLog(request, "TES异常节点配置(" +reStr+ ")成功");
            model.addAttribute("returnStr", "{success:true,msg:'修改成功'}");
        } catch (Exception e) {
            model.addAttribute("returnStr", "{success:false,msg:'修改数据失败,原因:"+e.getMessage()+"'}");
        }
        return "returnnote";
    }

    /*@RequestMapping(value = "remove.do", method = RequestMethod.POST)
    public String remove(@RequestParam("id") String id,
            HttpSession session, HttpServletRequest request, Model model) {
        tesStatService.removeStatusById(id);
        addSuccess(model, "删除成功");
        return "operstat/tes/stat/result";
    }*/
    
    /**
     * 修改电路配置备注引导页
     * @param id
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "service/mod.do", method = RequestMethod.GET)
    public String setupModForm(@RequestParam("id") String id,
            HttpServletRequest request, Model model) {
        model.addAttribute("pageModel", tesServiceManager.findById(id));        
        return "operstat/tes/service/mod";
    }

    /**
     * 修改电路配置备注处理
     * @param service
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "service/mod.do", method = RequestMethod.POST)
    public String porcessModForm(@ModelAttribute("pageModel") TesService service,
            HttpServletRequest request, Model model) {
        try {
            service.setOptUser((User) WebUtils.getSessionAttribute(request, SessionNames.LOGIN_USER));
            TesService temp = tesServiceManager.updateRemark(service);
            addSuccess(model, "修改TES电路备注(" + temp.getCircuitName() + ")成功");
            super.addLog(request, "修改TES电路备注(" + temp.getCircuitName() + ")成功");
            model.addAttribute("vo", temp);
        } catch (Exception e) {
            addError(model, "修改TES电路备注失败:" + e.getMessage());
        }
        return "operstat/tes/service/result";
    }
}
