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
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.atm.day.AtmDayRouteDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayRoute;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayTabEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDayRouteService;
import cn.com.atnc.ioms.mng.duty.atm.day.AtmDaySonService;
import cn.com.atnc.ioms.model.duty.atm.AtmDayQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * ATM日检路由器Service实现类
 * 
 * @author 王凌斌
 * @2017年2月9日 下午2:02:56
 */
@Transactional
@Service("atmDayRouteService")
public class AtmDayRouteServiceImpl extends BaseService implements
		AtmDayRouteService {

	@Autowired
	private AtmDayRouteDao atmDayRouteDao;
	@Autowired
	private AtmDaySonService atmDaySonService;

	@Override
	public Pagination queryPageByModel(AtmDayQueryModel queryModel) {
		// 获取分页数据
		Pagination pagn = atmDayRouteDao.queryPageByModel(queryModel);
		// 获取数据集合
		@SuppressWarnings("unchecked")
		List<ATMDayRoute> atmDayRoutes = (List<ATMDayRoute>) pagn.getResult();
		// 将子类数据赋值到父类中
		if (!CollectionUtils.isEmpty(atmDayRoutes)) {
			for (ATMDayRoute atmDayRoute : atmDayRoutes) {
				// 根据父类ID查找符合条件的子类集合（按照序号升序排列）
				List<ATMDaySon> atmDaySons = atmDaySonService
						.findByRouteOrderBySerial(atmDayRoute);
				atmDayRoute.setAtmDaySons(atmDaySons);
			}
		}
		return pagn;
	}

	@Override
	public void save(User user, AtmDayQueryModel pageModel) {
		List<String> telnets = pageModel.getTelnet();
		for (int i = 0; i < telnets.size(); i++) {
			// 创建业务路由器实体
			ATMDayRoute atmDayRoute = new ATMDayRoute();
			// -------保存北京网控中心的数据---------//
			// 远程访问
			atmDayRoute.setTelnet(StatusResultEnum.valueOf(pageModel
					.getTelnet().get(i)));
			// cpu利用率
			atmDayRoute.setCpu(pageModel.getCpu().get(i));
			// 备注
			atmDayRoute.setRemark(pageModel.getWkzxbz().get(i));
			// 区域
			atmDayRoute.setArea(AtmDayTabEnum.values()[i]);
			// 添加人
			atmDayRoute.setCreater(user);
			// 添加时间
			atmDayRoute.setRecordTime(DateUtilTools.getNowDateTime());
			// 日检时间
			atmDayRoute.setRecordDate(DateUtilTools.getNowDateStr());
			atmDayRouteDao.save(atmDayRoute);
			// 业务路由器子类
			atmDaySonService.save(atmDayRoute, pageModel, i);
		}
	}

	@Override
	public ATMDayRoute findById(String id) {
		return atmDayRouteDao.findById(id);
	}

	@Override
	public void delete(ATMDayRoute atmDayRoute) {
		// 删除实体
		atmDayRouteDao.delete(atmDayRoute);
		// 级联删除
		List<ATMDaySon> atmDaySons = atmDaySonService
				.findByRouteOrderBySerial(atmDayRoute);
		atmDaySonService.deleteAll(atmDaySons);
	}

	@Override
	public ATMDayRoute update(User user, ATMDayRoute atmDayRoute,
			AtmDayQueryModel pageModel) {
		// -------更新北京网控中心的数据---------//
		// 远程访问
		atmDayRoute.setTelnet(StatusResultEnum.valueOf(pageModel
				.getTelnet().get(0)));
		// cpu利用率
		atmDayRoute.setCpu(pageModel.getCpu().get(0));
		System.err.println(pageModel.getCpu().get(0));
		// 备注
		atmDayRoute.setRemark(pageModel.getWkzxbz().get(0));
		// 修改人
		atmDayRoute.setUpdater(user);
		// 修改时间
		atmDayRoute.setUpdateTime(DateUtilTools.getNowDateTime());
		atmDayRouteDao.update(atmDayRoute);
		// 业务路由器子类
		atmDaySonService.update(atmDayRoute, pageModel);
		return atmDayRoute;
	}

	@Override
	public ATMDayRoute audit(User user, ATMDayRoute atmDayRoute,
			AtmDayQueryModel pageModel) {
		// 审核备注
		atmDayRoute.setAuditRemark(pageModel.getAuditRemark());
		// 修改人
		atmDayRoute.setAuditer(user);
		// 修改时间
		atmDayRoute.setAuditTime(DateUtilTools.getNowDateTime());
		atmDayRouteDao.update(atmDayRoute);
		return atmDayRoute;
	}

}
