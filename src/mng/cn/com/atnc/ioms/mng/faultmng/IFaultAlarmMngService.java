package cn.com.atnc.ioms.mng.faultmng;

import java.util.Date;
import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.faultmng.FaultAlarm;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.faultmng.FaultAlarmQueryModel;

/**
 * 事件单与告警绑定管理service接口
 *
 * @author 段衍林
 * @2017年1月19日 下午1:31:10
 */
public interface IFaultAlarmMngService {

	/**
	 * 需添加事件单的告警分页查询
	 * 
	 * @author 段衍林
	 * @2017年1月19日 下午3:11:58
	 * @param queryModel
	 *            查询model
	 * @return Pagination 分页
	 */
	public Pagination queryPage(FaultAlarmQueryModel queryModel);

	/**
	 * 根据id查询告警信息
	 * 
	 * @author 段衍林
	 * @2017年1月19日 下午3:39:35
	 * @param id
	 *            告警信息id
	 * @return FaultAlarm 告警信息实体
	 */
	public FaultAlarm findById(String id);

	/**
	 * 更新信息
	 * 
	 * @author 段衍林
	 * @2017年1月19日 下午3:40:05
	 * @param faultAlarm
	 *            保存实体 void
	 */
	public void update(FaultAlarm faultAlarm);

	/**
	 * 根据事件单id查询告警信息
	 * 
	 * @author 段衍林
	 * @2017年1月19日 下午3:39:35
	 * @param faultId
	 *            事件单id
	 * @return FaultAlarm 告警绑定事件单信息实体
	 */
	public FaultAlarm findByFaultId(String faultId);

	/**
	 * 根据维保设备和日期查找告警信息
	 * 
	 * @author 王凌斌
	 * @2017年1月24日 上午9:19:20
	 * @param maintainEquip
	 * @param currentDate
	 * @return List<FaultAlarm>
	 */
	public List<FaultAlarm> findByEquipAndDate(MaintainEquip maintainEquip,
			Date currentDate);
	
	public List<FaultAlarm> findByEquipAndDate(List<MaintainEquip> maintainEquip,
			Date currentDate);

	/**
	 * 阈值告警 查询list-呼叫中心显示
	 * 
	 * @author 韩天驭
	 * @2017年2月3日 上午10:30:11
	 * @param queryModel
	 * @return List<FaultAlarm>
	 */
	public List<FaultAlarm> findByStatus(FaultAlarmQueryModel queryModel);
}