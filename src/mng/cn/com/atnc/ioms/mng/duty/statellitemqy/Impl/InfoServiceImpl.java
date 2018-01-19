package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.acl.IUserDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.InfoDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.Info;
import cn.com.atnc.ioms.mng.duty.statellitemqy.InfoService;
import cn.com.atnc.ioms.model.duty.satelliteinfo.SatelliteInfoModel;
import cn.com.atnc.ioms.model.duty.satelliteinfo.SatelliteInfoQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("InfoService")
public class InfoServiceImpl implements InfoService {

	@Autowired
	private InfoDao infoDao;
	@Autowired
	private IUserDao userDao;

	/**
	 * 东四-PES-TES民航局ODU状态 卫星日检自检分页查询 实现类
	 */
	public Pagination queryPageByModel(SatelliteInfoQueryModel queryModel) {
		// 分页查询
		Pagination pagn = infoDao.queryPageByModel(queryModel);
		// 返回分页数据
		return pagn;
	}

	@SuppressWarnings("unchecked")
	public Info findByIdPagn(String id) {
		// 赋值
		SatelliteInfoQueryModel queryModel = new SatelliteInfoQueryModel();
		queryModel.setId(id);
		// 分页查询
		Pagination pagn = this.queryPageByModel(queryModel);
		// 取列表
		List<Info> infos = (List<Info>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(infos)) {
			return infos.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 冒泡查询
	 */
	@SuppressWarnings("unchecked")
	public int getAjaxLoad(SatelliteInfoQueryModel queryModel) {
		// 分页查询
		Pagination pagn = infoDao.queryPageByModel(queryModel);
		// 获取全部列表
		List<Info> infos = (List<Info>) pagn.getResult();
		// 返回列表size
		return CollectionUtils.isNotEmpty(infos) ? infos.size() : 0;
	}

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public Info saveOrUpdate(SatelliteInfoModel satelliteInfoModel)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		Info info = infoDao.findById(satelliteInfoModel.getId());
		if (!ObjectUtils.equals(info, null)) {
			// 记录时间
			satelliteInfoModel.setCheckTime(info.getCheckTime());
			// 记录人
			satelliteInfoModel.setOperator(info.getOperator());
		} else {
			info = new Info();
			// 记录时间
			satelliteInfoModel.setCheckTime(DateUtilTools.getNowDateTime());
		}
		// 赋值
		PropertyUtils.copyProperties(info, satelliteInfoModel);
		// 赋值测试时间
		if (StringUtils.isNotEmpty(satelliteInfoModel.getTestTimeWeb())) {
			info.setTestTime(DateUtilTools.parseDate(
					satelliteInfoModel.getTestTimeWeb(),
					DateUtilTools.PATTERN_DATE_3));
		}
		// 添加创建时间
		info.setUpdateTime(DateUtilTools.getNowDateTime());
		// 数据库保存
		infoDao.saveOrUpdate(info);
		User user = userDao.findById(satelliteInfoModel.getTester().getId());
		info.setTester(user);
		return info;
	}

	@Override
	public Info findById(String id) {
		// 根据id查询
		return infoDao.findById(id);
	}

	/**
	 * 删除
	 */
	public void delete(SatelliteInfoModel satelliteInfoModel) {
		// 非空验证
		if (StringUtils.isNotEmpty(satelliteInfoModel.getId())) {
			// 取实体
			Info info = infoDao.findById(satelliteInfoModel.getId());
			// 删除实体
			infoDao.delete(info);
		}
	}

	/**
	 * 删除
	 */
	@SuppressWarnings("unchecked")
	public Boolean checkSn(SatelliteInfoQueryModel queryModel) {
		// 标记
		Boolean flag = true;
		// id
		String id = queryModel.getId();
		// 查询
		SatelliteInfoQueryModel qm = new SatelliteInfoQueryModel();
		qm.setSn(queryModel.getSn());
		// 列表查询
		List<Info> infos = (List<Info>) this.queryPageByModel(qm).getResult();

		if (CollectionUtils.isNotEmpty(infos)) {
			// 只有一条数据且与源数据id相同
			if (infos.size() == 1
					&& StringUtils.equalsIgnoreCase(id, infos.get(0).getId())) {
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
}
