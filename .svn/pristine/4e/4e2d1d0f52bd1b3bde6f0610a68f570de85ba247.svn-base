package cn.com.atnc.ioms.dao.faultmng;

import java.util.Date;
import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;

/**
 * 事件单与告警绑定管理Dao接口
 *
 * @author 段衍林
 * @2017年1月19日 下午1:29:12
 */
public interface IFaultAlarmDao extends IBaseDao<FaultAlarm> {
	/**
	 * 分页查询数据库实现类
	 * 
	 * @author 段衍林
	 * @2017年1月19日 下午3:13:07
	 * @param queryModel
	 *            查询model
	 * @return Pagination 分页
	 */
	public Pagination queryPage(FaultAlarmQueryModel queryModel);

	/**
	 * 列表查询
	 * 
	 * @author 段衍林
	 * @2017年2月3日 下午1:15:24
	 * @param queryModel
	 *            查询model
	 * @return List<FaultAlarm> 查询列表
	 */
	public List<FaultAlarm> queryList(FaultAlarmQueryModel queryModel);

	/**
	 * 根据维保设备和日期查找告警信息
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 上午9:20:38
	 * @param maintainEquip
	 * @param currentDate
	 * @return List<FaultAlarm>
	 */
	public List<FaultAlarm> findByEquipAndDate(MaintainEquip maintainEquip,
			Date currentDate);
	
	public List<FaultAlarm> findByEquipAndDate(List<MaintainEquip> maintainEquip,
			Date currentDate);

	/**
	 * 阈值告警 查询list
	 * 
	 * @author 韩天驭
	 * @2017年2月3日 上午10:28:05
	 * @param queryModel
	 * @return List<FaultAlarm>
	 */
	public List<FaultAlarm> findByStatus(FaultAlarmQueryModel queryModel);
}