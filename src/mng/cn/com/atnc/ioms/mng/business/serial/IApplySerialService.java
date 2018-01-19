package cn.com.atnc.ioms.mng.business.serial;

import cn.com.atnc.ioms.entity.business.serial.ApplySerial;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;


/**
 * 申请信息序号Service
 * @author WangLingbin
 * @date 2015年10月27日 上午11:04:16
 * @since 1.0.0
 */
public interface IApplySerialService {

	/**
	 * 保存实体
	 * @author WangLingbin
	 * @date  2015年10月27日上午11:04:41
	 * @since 1.0.0
	 */
	void save(ApplySerial applySerial);

	/**
	 * 更新实体
	 * @author WangLingbin
	 * @date  2015年10月27日上午11:04:57
	 * @since 1.0.0
	 */
	void update(ApplySerial applySerial);

	/**
	 * 删除实体
	 * @author WangLingbin
	 * @date  2015年10月27日上午11:05:13
	 * @since 1.0.0
	 */
	void delete(ApplySerial applySerial);

	/**
	 * 根据名字，类型和日期查找实体
	 * @author WangLingbin
	 * @date  2015年10月27日上午11:10:59
	 * @since 1.0.0
	 */
	ApplySerial findByMulti(SerialNameEnum name, SerialTypeEnum type, Integer year);
	
	/**
	 * 产生序号
	 * @author WangLingbin
	 * @date  2015年10月27日上午11:25:59
	 * @since 1.0.0
	 */
	String createSerialNumber(SerialNameEnum name, SerialTypeEnum type);
}
