/**
 * @Title:AtmdayCheckServiceImpl.java
 * @author shijiyong
 * @data 2016年9月26日上午10:55:44
 * @version v1.0
 */
package cn.com.atnc.ioms.mng.duty.atm.day.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.atm.day.AtmDaySonDao;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayRoute;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;
import cn.com.atnc.ioms.enums.duty.atm.CityEnum;
import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDaySonService;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModel;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModelMgx;

/**
 * ATM日检子类Service实现类
 * 
 * @author 王凌斌
 * @2017年2月9日 下午3:10:19
 */
@Transactional
@Service("AtmDaySonService")
public class AtmDaySonServiceImpl extends BaseService implements
        AtmDaySonService {
    @Autowired
    private AtmDaySonDao atmDaySonDao;
    @Override
    public void save(ATMDayRoute atmDayRoute, AtmDayQueryModel pageModel, int i) {
        // 记录序号
        int index = 1;
        // 成都
        saveRecord(atmDayRoute, CityEnum.CHENGDU,
                HaveNoEnum.valueOf(pageModel.getChengdu().get(i)),
                new ATMDaySon(), index++);
        // 广州
        saveRecord(atmDayRoute, CityEnum.GUANGZHOU,
                HaveNoEnum.valueOf(pageModel.getGuangzhou().get(i)),
                new ATMDaySon(), index++);
        // 首都机场
        saveRecord(atmDayRoute, CityEnum.SHOUDU,
                HaveNoEnum.valueOf(pageModel.getShoudu().get(i)),
                new ATMDaySon(), index++);
        // 上海
        saveRecord(atmDayRoute, CityEnum.SHANGHAI,
                HaveNoEnum.valueOf(pageModel.getShanghai().get(i)),
                new ATMDaySon(), index++);
        // 沈阳
        saveRecord(atmDayRoute, CityEnum.SHENYANG,
                HaveNoEnum.valueOf(pageModel.getShenyang().get(i)),
                new ATMDaySon(), index++);
        // 西安
        saveRecord(atmDayRoute, CityEnum.XIAN,
                HaveNoEnum.valueOf(pageModel.getXian().get(i)),
                new ATMDaySon(), index++);
        // 乌鲁木齐
        saveRecord(atmDayRoute, CityEnum.WULUMUQI,
                HaveNoEnum.valueOf(pageModel.getWulumuqi().get(i)),
                new ATMDaySon(), index++);
        // 三亚
        saveRecord(atmDayRoute, CityEnum.SANYA,
                HaveNoEnum.valueOf(pageModel.getSanya().get(i)),
                new ATMDaySon(), index);
    }

    @Override
    public void save(ATMDayMgx atmDayMgx, AtmDayQueryModelMgx pageModelMgx, int i) {
        // 记录序号
        int index = 1;
        // 西安
        saveConRecord(atmDayMgx, CityEnum.XIAN,
                StatusResultEnum.valueOf(pageModelMgx.getXian().get(i)),
                new ATMDaySon(), index++);
        // 广州
        saveConRecord(atmDayMgx, CityEnum.GUANGZHOU,
                StatusResultEnum.valueOf(pageModelMgx.getGuangzhou().get(i)),
                new ATMDaySon(), index++);
        // 成都
        saveConRecord(atmDayMgx, CityEnum.CHENGDU,
                StatusResultEnum.valueOf(pageModelMgx.getChengdu().get(i)),
                new ATMDaySon(), index++);
        // 上海
        saveConRecord(atmDayMgx, CityEnum.SHANGHAI,
                StatusResultEnum.valueOf(pageModelMgx.getShanghai().get(i)),
                new ATMDaySon(), index++);
        // 沈阳
        saveConRecord(atmDayMgx, CityEnum.SHENYANG,
                StatusResultEnum.valueOf(pageModelMgx.getShenyang().get(i)),
                new ATMDaySon(), index++);
        // 乌鲁木齐
        saveConRecord(atmDayMgx, CityEnum.WULUMUQI,
                StatusResultEnum.valueOf(pageModelMgx.getWulumuqi().get(i)),
                new ATMDaySon(), index++);
    }

    /**
     * 保存记录
     * 
     * @author 王凌斌
     * @2017年2月9日 下午3:50:11
     * @param atmDayRoute
     * @param pageModel
     * @param atmDaySon
     * @param index
     *            void
     */
    private void saveRecord(ATMDayRoute atmDayRoute, CityEnum city,
            HaveNoEnum result, ATMDaySon atmDaySon, int index) {
        atmDaySon.setSerial(index);
        atmDaySon.setName(city);
        atmDaySon.setResult(result);
        atmDaySon.setRoute(atmDayRoute);
        atmDaySonDao.save(atmDaySon);
    }

    private void saveConRecord(ATMDayMgx atmDayMgx, CityEnum city,
            StatusResultEnum result, ATMDaySon atmDaySon, int index) {
        atmDaySon.setSerial(index);
        atmDaySon.setName(city);
        atmDaySon.setConResult(result);
        atmDaySon.setMgx(atmDayMgx);
        atmDaySonDao.save(atmDaySon);
    }

    @Override
    public List<ATMDaySon> findByRouteOrderBySerial(ATMDayRoute atmDayRoute) {
        return atmDaySonDao.findByRouteOrderBySerial(atmDayRoute);
    }

    @Override
    public List<ATMDaySon> findByRouteOrderBySerial(ATMDayMgx atmDayMgx) {
        return atmDaySonDao.findByRouteOrderBySerial(atmDayMgx);
    }

    @Override
    public void deleteAll(List<ATMDaySon> atmDaySons) {
        atmDaySonDao.deleteList(atmDaySons);
    }

    @Override
    public void update(ATMDayRoute atmDayRoute, AtmDayQueryModel pageModel) {
        // 根据父类ID获取子类集合
        List<ATMDaySon> atmDaySons = this.findByRouteOrderBySerial(atmDayRoute);
        // 循环遍历，修改数据
        // 记录序号
        int index = 0;
        // 成都
        atmDaySons.get(index++).setResult(
                HaveNoEnum.valueOf(pageModel.getChengdu().get(0)));
        // 广州
        atmDaySons.get(index++).setResult(
                HaveNoEnum.valueOf(pageModel.getGuangzhou().get(0)));
        // 首都机场
        atmDaySons.get(index++).setResult(
                HaveNoEnum.valueOf(pageModel.getShoudu().get(0)));
        // 上海
        atmDaySons.get(index++).setResult(
                HaveNoEnum.valueOf(pageModel.getShanghai().get(0)));
        // 沈阳
        atmDaySons.get(index++).setResult(
                HaveNoEnum.valueOf(pageModel.getShenyang().get(0)));
        // 西安
        atmDaySons.get(index++).setResult(
                HaveNoEnum.valueOf(pageModel.getXian().get(0)));
        // 乌鲁木齐
        atmDaySons.get(index++).setResult(
                HaveNoEnum.valueOf(pageModel.getWulumuqi().get(0)));
        // 三亚
        atmDaySons.get(index++).setResult(
                HaveNoEnum.valueOf(pageModel.getSanya().get(0)));
        // 更新
        for (ATMDaySon atmDaySon : atmDaySons) {
            atmDaySonDao.update(atmDaySon);
        }
    }

    @Override
    public void update(ATMDayMgx atmDayMgx, AtmDayQueryModelMgx pageModelMgx) {
        // 根据父类ID获取子类集合
        List<ATMDaySon> atmDaySons = this.findByRouteOrderBySerial(atmDayMgx);
        // 循环遍历，修改数据
        // 记录序号
        int index = 0;
        // 西安
        atmDaySons.get(index++).setConResult(
                StatusResultEnum.valueOf(pageModelMgx.getXian().get(0)));
        // 广州
        atmDaySons.get(index++).setConResult(
                StatusResultEnum.valueOf(pageModelMgx.getGuangzhou().get(0)));
        // 成都
        atmDaySons.get(index++).setConResult(
                StatusResultEnum.valueOf(pageModelMgx.getChengdu().get(0)));
        // 上海
        atmDaySons.get(index++).setConResult(
                StatusResultEnum.valueOf(pageModelMgx.getShanghai().get(0)));
        // 沈阳
        atmDaySons.get(index++).setConResult(
                StatusResultEnum.valueOf(pageModelMgx.getShenyang().get(0)));
       // 乌鲁木齐
        atmDaySons.get(index++).setConResult(
                StatusResultEnum.valueOf(pageModelMgx.getWulumuqi().get(0)));
       // 更新
        for (ATMDaySon atmDaySon : atmDaySons) {
            atmDaySonDao.update(atmDaySon);
        }
    }
}
