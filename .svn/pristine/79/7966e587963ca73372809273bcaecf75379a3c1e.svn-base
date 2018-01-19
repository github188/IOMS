package cn.com.atnc.ioms.mng.duty.atm.day.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.atm.day.AtmDayMgxDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayMgxTabEnum;
import cn.com.atnc.ioms.enums.duty.atm.CityEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDayMgxService;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDaySonService;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModelMgx;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("atmDayMgxService")
public class AtmDayMgxServiceImpl extends BaseService implements
        AtmDayMgxService {

    @Autowired
    private AtmDayMgxDao atmDayMgxDao;
    @Autowired
    private AtmDaySonService atmDaySonService;

    @Override
    public Pagination queryPageByModel(AtmDayQueryModelMgx queryModelMgx) {
        // 获取分页数据
        Pagination pagn = atmDayMgxDao.queryPageByModel(queryModelMgx);
        // 获取数据集合
        @SuppressWarnings("unchecked")
        List<ATMDayMgx> atmDayMgxs = (List<ATMDayMgx>) pagn.getResult();
        // 将子类数据赋值到父类中
        if (!CollectionUtils.isEmpty(atmDayMgxs)) {
            for (ATMDayMgx atmDayMgx : atmDayMgxs) {
                // 根据父类ID查找符合条件的子类集合（按照序号升序排列）
                List<ATMDaySon> atmDaySons = atmDaySonService
                        .findByRouteOrderBySerial(atmDayMgx);
                if(!CollectionUtils.isEmpty(atmDaySons)) {
                    atmDayMgx.setAtmDaySons(atmDaySons);
                }
            }
        }
        
        return pagn;
    }

    @Override
    public void save(User user, AtmDayQueryModelMgx pageModelMgx) {
        @SuppressWarnings("unused")
        List<String> env_fans = pageModelMgx.getEnv_fan();
        List<AtmDayMgxTabEnum> mgxTabs = new ArrayList<AtmDayMgxTabEnum>(
                Arrays.asList(AtmDayMgxTabEnum.values()));
        //风扇、电源、温度初始序号
        int i = 0;
        //十里河8850初始序号
        int slh8850Index = 0;
        //通信基地8830初始序号
        int txjd8830Index = 0;
        //民航局8850初始序号
        int mhjIndex = 0;
        //首都机场初始序号
        int capitalIndex = 0;
        //通信基地8850初始序号
        int txjd8850Index = 0;
        //中继连通性初始序号
        int zjIndex = 0;
        //网控中心8830初始序号
        int wkzx8830Index = 0;
        //网控中心8850初始序号
        int wkzx8850Index = 0;
        // 创建ATM交换机实体
        for (AtmDayMgxTabEnum mgxTab : mgxTabs) {
            // 创建ATM交换机实体
            ATMDayMgx atmDayMgx = new ATMDayMgx();
            // -------保存通信基地 8850的数据---------//
            // 设备运行环境_风扇
            atmDayMgx.setEnv_fan(StatusResultEnum.valueOf(pageModelMgx
                    .getEnv_fan().get(i)));
            // 设备运行环境_电源
            atmDayMgx.setEnv_power(StatusResultEnum.valueOf(pageModelMgx
                    .getEnv_power().get(i)));
            // 设备运行环境_温度
            atmDayMgx.setEnv_temperatuer(StatusResultEnum.valueOf(pageModelMgx
                    .getEnv_temperatuer().get(i)));
            switch (mgxTab) {
            case TXJD_8850:
                // 十里河8850连通性
                atmDayMgx.setSlh8850_con(StatusResultEnum.valueOf(pageModelMgx
                        .getSlh8850_con().get(slh8850Index++)));
                // 与通信基地8830节点的连通性
                atmDayMgx.setTxjd8830_con(StatusResultEnum.valueOf(pageModelMgx
                        .getTxjd8830_con().get(txjd8830Index++)));
                // 民航局空管局连通性
                atmDayMgx.setMhj_con(StatusResultEnum.valueOf(pageModelMgx
                        .getMhj_con().get(mhjIndex++)));
                // 首都机场连通性
                atmDayMgx.setCapital_con(StatusResultEnum.valueOf(pageModelMgx
                        .getCapital_con().get(capitalIndex++)));
                // ATM交换机子类
                atmDaySonService.save(atmDayMgx, pageModelMgx, i);
                // 备注
                atmDayMgx.setRemark(CollectionUtils.isEmpty(pageModelMgx
                        .getTxjdbz()) ? "" : pageModelMgx.getTxjdbz().get(0));
                break;
            case TXJD_8830:
                // 与通信基地8850节点的连通性
                atmDayMgx.setTxjd8850_con(StatusResultEnum.valueOf(pageModelMgx
                        .getTxjd8850_con().get(txjd8850Index++)));
                // 中继连通状态
                atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                        .getZj_con().get(zjIndex++)));
             // 备注
                atmDayMgx.setRemark(CollectionUtils.isEmpty(pageModelMgx.getTxjdsbz())?"": pageModelMgx.getTxjdsbz().get(0));
                break;
            case SLH_8850:
                // 与网控中心8830节点的连通性
                atmDayMgx.setWkzx8830_con(StatusResultEnum.valueOf(pageModelMgx
                        .getWkzx8830_con().get(wkzx8830Index++)));
                // 与通信基地8850节点的连通性
                atmDayMgx.setTxjd8850_con(StatusResultEnum.valueOf(pageModelMgx
                        .getTxjd8850_con().get(txjd8850Index++)));
                // 与民航局空管局的连通性
                atmDayMgx.setMhj_con(StatusResultEnum.valueOf(pageModelMgx
                        .getMhj_con().get(mhjIndex++)));
                // 与首都机场的连通性
                atmDayMgx.setCapital_con(StatusResultEnum.valueOf(pageModelMgx
                        .getCapital_con().get(capitalIndex++)));
               // 备注
                atmDayMgx.setRemark(CollectionUtils.isEmpty(pageModelMgx.getTxjdsbz())?"":pageModelMgx.getSlhbz().get(0));
                break;
            case SLH_8830:
                // 与网控中心8850节点的连通性
                atmDayMgx.setWkzx8850_con(StatusResultEnum.valueOf(pageModelMgx
                        .getWkzx8850_con().get(wkzx8850Index++)));
                // 中继连通状态
                atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                        .getZj_con().get(zjIndex++)));
             // 备注
                atmDayMgx.setRemark(CollectionUtils.isEmpty(pageModelMgx.getTxjdsbz())?"":pageModelMgx.getSlhsbz().get(0));
                break;
            case MHJ_8850:
                // 十里河8850连通性
                atmDayMgx.setSlh8850_con(StatusResultEnum.valueOf(pageModelMgx
                        .getSlh8850_con().get(slh8850Index++)));
                // 与民航局空管局的连通性
                atmDayMgx.setMhj_con(StatusResultEnum.valueOf(pageModelMgx
                        .getMhj_con().get(mhjIndex++)));
                // 中继连通状态
                atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                        .getZj_con().get(zjIndex++)));
             // 备注
                atmDayMgx.setRemark(CollectionUtils.isEmpty(pageModelMgx.getTxjdsbz())?"":pageModelMgx.getMhjbz().get(0));
                break;
            case KGJ_8850:
                // 十里河8850连通性
                atmDayMgx.setSlh8850_con(StatusResultEnum.valueOf(pageModelMgx
                        .getSlh8850_con().get(slh8850Index++)));
                // 与民航局空管局的连通性
                 atmDayMgx.setMhj_con(StatusResultEnum.valueOf(pageModelMgx
                .getMhj_con().get(mhjIndex++)));
                // 中继连通状态
                atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                        .getZj_con().get(zjIndex++)));
             // 备注
                atmDayMgx.setRemark(CollectionUtils.isEmpty(pageModelMgx.getTxjdsbz())?"":pageModelMgx.getKgjbz().get(0));
                break;
            case CFZX_8830:
                // 十里河8850连通性
                atmDayMgx.setSlh8850_con(StatusResultEnum.valueOf(pageModelMgx
                        .getSlh8850_con().get(slh8850Index++)));
                // 中继连通状态
                atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                        .getZj_con().get(zjIndex++)));
             // 备注
                atmDayMgx.setRemark(CollectionUtils.isEmpty(pageModelMgx.getTxjdsbz())?"":pageModelMgx.getCfzxbz().get(0));
                break;
            default:
                break;
            }
            // 区域
            atmDayMgx.setArea(AtmDayMgxTabEnum.values()[i]);
            // 添加人
            atmDayMgx.setCreater(user);
            // 添加时间
            atmDayMgx.setRecordTime(DateUtilTools.getNowDateTime());
            // 日检时间
            atmDayMgx.setRecordDate(DateUtilTools.getNowDateStr());
            atmDayMgxDao.save(atmDayMgx);
            i++;
        }
    }

    @Override
    public ATMDayMgx findById(String id) {
        return atmDayMgxDao.findById(id);
    }

    @Override
    public void delete(ATMDayMgx atmDayMgx) {
        // 删除实体
        atmDayMgxDao.delete(atmDayMgx);
        // 级联删除
        List<ATMDaySon> atmDaySons = atmDaySonService
                .findByRouteOrderBySerial(atmDayMgx);
        atmDaySonService.deleteAll(atmDaySons);
    }

    @Override
    public ATMDayMgx update(User user, ATMDayMgx atmDayMgx,
            AtmDayQueryModelMgx pageModelMgx) {
        AtmDayMgxTabEnum atmDayMgxTabEnum=pageModelMgx.getTabType();
        // 设备运行环境_风扇
        atmDayMgx.setEnv_fan(StatusResultEnum.valueOf(pageModelMgx
                .getEnv_fan().get(0)));
        // 设备运行环境_电源
        atmDayMgx.setEnv_power(StatusResultEnum.valueOf(pageModelMgx
                .getEnv_power().get(0)));
        // 设备运行环境_温度
        atmDayMgx.setEnv_temperatuer(StatusResultEnum.valueOf(pageModelMgx
                .getEnv_temperatuer().get(0)));
        switch(atmDayMgxTabEnum) {
        case TXJD_8850:
         // 十里河8850连通性
            atmDayMgx.setSlh8850_con(StatusResultEnum.valueOf(pageModelMgx
                    .getSlh8850_con().get(0)));
            // 与通信基地8830节点的连通性
            atmDayMgx.setTxjd8830_con(StatusResultEnum.valueOf(pageModelMgx
                    .getTxjd8830_con().get(0)));
            // 民航局空管局连通性
            atmDayMgx.setMhj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getMhj_con().get(0)));
            // 首都机场连通性
            atmDayMgx.setCapital_con(StatusResultEnum.valueOf(pageModelMgx
                    .getCapital_con().get(0)));   
            // 备注
            atmDayMgx.setRemark(pageModelMgx.getTxjdbz().get(0));
            atmDayMgxDao.update(atmDayMgx);
           // ATM日检交换机子类
            atmDaySonService.update(atmDayMgx, pageModelMgx);
           
            break;
        case TXJD_8830:
            // 通信基地8850连通性
            atmDayMgx.setTxjd8850_con(StatusResultEnum.valueOf(pageModelMgx
                    .getTxjd8850_con().get(0)));
            // 中继连通状态
            atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getZj_con().get(0)));
            // 备注
            atmDayMgx.setRemark(pageModelMgx.getTxjdsbz().get(0));
            break;
        case SLH_8850:
            // 网控中心8830连通性
            atmDayMgx.setWkzx8830_con(StatusResultEnum.valueOf(pageModelMgx
                    .getWkzx8830_con().get(0)));
            // 通信基地8850连通性
            atmDayMgx.setTxjd8850_con(StatusResultEnum.valueOf(pageModelMgx
                    .getTxjd8850_con().get(0)));
            // 民航局空管局连通性
            atmDayMgx.setMhj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getMhj_con().get(0)));
            // 首都机场连通性
            atmDayMgx.setCapital_con(StatusResultEnum.valueOf(pageModelMgx
                    .getCapital_con().get(0)));
            // 备注
            atmDayMgx.setRemark(pageModelMgx.getSlhbz().get(0));
            break;
        case SLH_8830:
           // 与网控中心8850节点的连通性
            atmDayMgx.setWkzx8850_con(StatusResultEnum.valueOf(pageModelMgx
                    .getWkzx8850_con().get(0)));
            // 中继连通状态
            atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getZj_con().get(0)));
            // 备注
            atmDayMgx.setRemark(pageModelMgx.getSlhsbz().get(0));
            break;
        case MHJ_8850:
            // 十里河8850连通性
            atmDayMgx.setSlh8850_con(StatusResultEnum.valueOf(pageModelMgx
                    .getSlh8850_con().get(0)));
            // 民航局空管局连通性
            atmDayMgx.setMhj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getMhj_con().get(0)));
            // 中继连通状态
            atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getZj_con().get(0)));
            // 备注
            atmDayMgx.setRemark(pageModelMgx.getMhjbz().get(0));
            break;
        case KGJ_8850:
         // 十里河8850连通性
            atmDayMgx.setSlh8850_con(StatusResultEnum.valueOf(pageModelMgx
                    .getSlh8850_con().get(0)));
            // 民航局空管局连通性
            atmDayMgx.setMhj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getMhj_con().get(0)));
            // 中继连通状态
            atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getZj_con().get(0)));
            // 备注
            atmDayMgx.setRemark(pageModelMgx.getKgjbz().get(0));
            break;
        case CFZX_8830:
            // 十里河8850连通性
            atmDayMgx.setSlh8850_con(StatusResultEnum.valueOf(pageModelMgx
                    .getSlh8850_con().get(0)));
            // 中继连通状态
            atmDayMgx.setZj_con(StatusResultEnum.valueOf(pageModelMgx
                    .getZj_con().get(0)));
            // 备注
            atmDayMgx.setRemark(pageModelMgx.getCfzxbz().get(0));
            break;
        default:
            break;  
        }
        // 修改人
        atmDayMgx.setUpdater(user);
        // 修改时间
        atmDayMgx.setUpdateTime(DateUtilTools.getNowDateTime());
        atmDayMgxDao.update(atmDayMgx);
        return atmDayMgx;
    }

    @Override
    public ATMDayMgx audit(User user, ATMDayMgx atmDayMgx,
            AtmDayQueryModelMgx pageModelMgx) {
        // 审核备注
        atmDayMgx.setAuditRemark(pageModelMgx.getAuditRemark());
        // 修改人
        atmDayMgx.setAuditer(user);
        // 修改时间
        atmDayMgx.setAuditTime(DateUtilTools.getNowDateTime());
        atmDayMgxDao.update(atmDayMgx);
        return atmDayMgx;
    }
}
