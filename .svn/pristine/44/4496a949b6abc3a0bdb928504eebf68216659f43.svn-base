package cn.com.atnc.ioms.dao.business.serial;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.serial.ApplySerial;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;

/**
 * 申请信息序号DAO
 * @author WangLingbin
 * @date 2015年10月27日 上午11:00:57
 * @since 1.0.0
 */
public interface IApplySerialDao extends IBaseDao<ApplySerial> {
	/**
	 * 根据名字，类型和日期查找实体
	 * @author WangLingbin
	 * @date  2015年10月27日上午11:10:59
	 * @since 1.0.0
	 */
	ApplySerial findByMulti(SerialNameEnum name, SerialTypeEnum type, Integer year);
}
