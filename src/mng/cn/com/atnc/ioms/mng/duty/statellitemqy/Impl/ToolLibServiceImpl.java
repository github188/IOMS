package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
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
import cn.com.atnc.ioms.dao.duty.satellitemqy.ToolLibDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.satellite.ToolLib;
import cn.com.atnc.ioms.mng.duty.statellitemqy.ToolLibService;
import cn.com.atnc.ioms.model.duty.satellitetool.SatelliteToolModel;
import cn.com.atnc.ioms.model.duty.satellitetool.SatelliteToolQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("ToolLibService")
public class ToolLibServiceImpl implements ToolLibService {

	@Autowired
	private ToolLibDao toolLibDao;
	@Autowired
	private IUserDao userDao;

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月29日 上午11:15:52
	 * @param queryModel
	 * @return Pagination
	 */
	public Pagination queryPageByModel(SatelliteToolQueryModel queryModel) {
		// 分页查询
		Pagination pagn = toolLibDao.queryPageByModel(queryModel);
		// 返回分页数据
		return pagn;
	}

	@SuppressWarnings("unchecked")
	public ToolLib findByIdPagn(String id) {
		// 赋值
		SatelliteToolQueryModel queryModel = new SatelliteToolQueryModel();
		queryModel.setId(id);
		// 分页查询
		Pagination pagn = this.queryPageByModel(queryModel);
		// 取列表
		List<ToolLib> toolLibs = (List<ToolLib>) pagn.getResult();
		// 非空验证
		if (CollectionUtils.isNotEmpty(toolLibs)) {
			return toolLibs.get(0);
		} else {
			return null;
		}
	}

	/**
	 * 冒泡查询
	 */
	@SuppressWarnings("unchecked")
	public int getAjaxLoad(SatelliteToolQueryModel queryModel) {
		// 分页查询
		Pagination pagn = toolLibDao.queryPageByModel(queryModel);
		// 获取全部列表
		List<ToolLib> toolLibs = (List<ToolLib>) pagn.getResult();
		// 返回列表size
		return CollectionUtils.isNotEmpty(toolLibs) ? toolLibs.size() : 0;
	}

	/**
	 * 保存或更新
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public ToolLib saveOrUpdate(SatelliteToolModel tool)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		ToolLib toolLib = toolLibDao.findById(tool.getId());
		if (!ObjectUtils.equals(toolLib, null)) {
			// 记录时间
			tool.setCheckTime(toolLib.getCheckTime());
			// 记录人
			tool.setOperator(toolLib.getOperator());
		} else {
			toolLib = new ToolLib();
			// 记录时间
			tool.setCheckTime(DateUtilTools.getNowDateTime());
		}
		// 赋值
		PropertyUtils.copyProperties(toolLib, tool);
		// 非空验证
		if (StringUtils.isNotEmpty(tool.getStoreTimeWeb())) {
			// storeTime入库时间格式转换
			Date storeTime = DateUtilTools.parseDate(tool.getStoreTimeWeb(),
					DateUtilTools.PATTERN_DATE_3);
			// 赋值
			toolLib.setStoreTime(storeTime);
		}
		// 非空验证
		if (StringUtils.isNotEmpty(tool.getLendTimeWeb())) {
			// lendTime借出时间格式转换
			Date lendTime = DateUtilTools.parseDate(tool.getLendTimeWeb(),
					DateUtilTools.PATTERN_DATE_3);
			// 赋值
			toolLib.setLendTime(lendTime);
		}
		// 非空验证
		if (StringUtils.isNotEmpty(tool.getBackTimeWeb())) {
			// backTime归还时间格式转换
			Date backTime = DateUtilTools.parseDate(tool.getBackTimeWeb(),
					DateUtilTools.PATTERN_DATE_3);
			// 赋值
			toolLib.setBackTime(backTime);
		}
		// 添加创建时间
		toolLib.setUpdateTime(DateUtilTools.getNowDateTime());

		// 页面回显用
		User keeper = userDao.findById(tool.getKeeper().getId());
		toolLib.setKeeper(keeper);
		// 页面回显用
		User borrower = userDao.findById(tool.getBorrower().getId());
		toolLib.setBorrower(borrower);
		// 数据库保存
		toolLibDao.saveOrUpdate(toolLib);
		return toolLib;
	}

	@Override
	public ToolLib findById(String id) {
		// 根据id查询
		return toolLibDao.findById(id);
	}

	/**
	 * 删除
	 */
	public void delete(SatelliteToolModel tool) {
		// 非空验证
		if (StringUtils.isNotEmpty(tool.getId())) {
			// 取实体
			ToolLib toolLib = toolLibDao.findById(tool.getId());
			// 删除实体
			toolLibDao.delete(toolLib);
		}
	}

}
