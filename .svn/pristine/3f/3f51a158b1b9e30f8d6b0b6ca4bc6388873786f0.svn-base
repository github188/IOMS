package cn.com.atnc.ioms.mng.duty.environment;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.BatteryMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.UpsContentCheck;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.acc.AccAddForm;
import cn.com.atnc.ioms.model.duty.environment.dg.DgAddForm;
import cn.com.atnc.ioms.model.duty.environment.psot.PsOtAddForm;
import cn.com.atnc.ioms.model.duty.environment.ups.UpsMonthAddForm;

/**
 * Ups巡检service
 * @author renyujuan
 * @date 2016年7月11日 下午2:00:29
 */

public interface EnvironmentEquipCheckService {
	/**
	 * 通过查询条件model查询记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:02:34
	 * @param queryModel
	 * @return
	 */
	Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel);
	
	/**
	 * 获取所有的记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:04:10
	 * @return
	 */
	List<EnvironmentEquipCheck> getAll();
	
	/**
	 * 保存ups巡检记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:05:15
	 * @param upsCheck
	 * @return
	 */
	void save(UpsMonthAddForm form, List<Integer> number,List<String> termialV,
			List<String> interR, List<String> remarks);
	
	/**
	 * 更新ups巡检记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:06:10
	 * @param upsCheck
	 * @return
	 */
	EnvironmentEquipCheck update(EnvironmentEquipCheck upsCheck,UpsMonthAddForm form, List<String> termialV,
			List<String> interR, List<String> remarks);
	
	/**
	 * 删除记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:07:03
	 * @param upsCheck
	 */
	void delete(EnvironmentEquipCheck upsCheck);
	
	/**
	 * 根据主键id查询记录
	 * @author renyujuan
	 * @date 2016年7月11日下午2:07:47
	 * @param id
	 * @return
	 */
	EnvironmentEquipCheck findById(String id);

	
	/**
	 * 根据属性集合，将其封装成实体对象
	 * @author renyujuan
	 * @date 2016年7月20日上午9:53:53
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @return
	 */
	List<BatteryMeasure> dealbatMea(List<Integer> number, List<String> termialV, List<String> interR,
			List<String> remarks);

	
	/**
	 * 根据查询model，查询相应的巡检内容
	 * @author renyujuan
	 * @date 2016年7月20日上午9:54:52
	 * @param queryModel
	 * @return
	 */
	List<UpsContentCheck> upsContentCheckList(EnvironmentCheckQueryModel queryModel);
	
	/**
	 * ups季检年检保存记录
	 * @author renyujuan
	 * @date 2016年8月3日上午11:14:57
	 * @param form
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @param dsTime
	 * @param batTotalV
	 * @param dsCurrent
	 * @param singleMaxV
	 * @param singleMinV
	 * @param remark
	 */
	void saveQuarter(UpsMonthAddForm form, List<Integer> number, List<String> termialV,
			List<String> interR, List<String> remarks,
			List<String> dsTime, List<String> batTotalV, List<String> dsCurrent,
			List<String> singleMaxV, List<String> singleMinV, List<String> remark);
	
	/**
	 * ups季检年检更新记录
	 * @author renyujuan
	 * @date 2016年8月3日上午11:15:20
	 * @param upsCheck
	 * @param form
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @param dsTime
	 * @param batTotalV
	 * @param dsCurrent
	 * @param singleMaxV
	 * @param singleMinV
	 * @param remark
	 * @return
	 */
	EnvironmentEquipCheck updateQuarter(EnvironmentEquipCheck upsCheck,UpsMonthAddForm form, List<String> termialV,
			List<String> interR, List<String> remarks,
			List<String> dsTime, List<String> batTotalV, List<String> dsCurrent,
			List<String> singleMaxV, List<String> singleMinV, List<String> remark);
	
	/**
	 * 添加柴油发电机记录
	 * @author renyujuan
	 * @date 2016年8月9日上午11:33:05
	 * @param form
	 */
	void saveDgCheck(DgAddForm form);
	
	/**
	 * 更新柴油发电机记录
	 * @author renyujuan
	 * @time:2016年8月12日 上午9:29:28
	 * @param dgCheck
	 * @param form
	 * @return
	 */
	EnvironmentEquipCheck updateDgCheck(EnvironmentEquipCheck dgCheck, DgAddForm form);
	
	/**
	 * 保存空调设备巡检记录
	 * @author renyujuan
	 * @time:2016年8月12日 上午9:30:39
	 * @param form
	 */
	void saveAccCheck(AccAddForm form);
	
	/**
	 * 更新空调设备巡检记录
	 * @author renyujuan
	 * @time:2016年8月12日 上午9:31:57
	 * @param accCheck
	 * @param form
	 * @return
	 */
	EnvironmentEquipCheck updateAccCheck(EnvironmentEquipCheck accCheck, AccAddForm form);
	
	/**
	 * 保存传输设备与通讯线路巡检记录
	 * @author renyujuan
	 * @time:2016年8月17日 下午1:36:11
	 * @param form
	 */
	void savePsOtCheck(PsOtAddForm form);
	
	/**
	 * 更新传输设备与通讯线路巡检记录
	 * @author renyujuan
	 * @time:2016年8月17日 下午1:35:17
	 * @param psOtCheck
	 * @param form
	 * @return
	 */
	EnvironmentEquipCheck updatePsOtCheck(
            EnvironmentEquipCheck psOtCheck, PsOtAddForm form);
	
	
	
	
	
	
	
	
	
	
	
	
}
