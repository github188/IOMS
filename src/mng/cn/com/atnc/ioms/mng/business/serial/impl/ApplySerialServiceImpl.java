package cn.com.atnc.ioms.mng.business.serial.impl;

import java.util.Calendar;

import net.sf.jasperreports.engine.util.ObjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.serial.IApplySerialDao;
import cn.com.atnc.ioms.entity.business.serial.ApplySerial;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;
import cn.com.atnc.ioms.mng.business.serial.IApplySerialService;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 申请信息序号Service实现类
 * @author WangLingbin
 * @date 2015年10月27日 上午11:06:43
 * @since 1.0.0
 */
@Service
public class ApplySerialServiceImpl extends BaseService implements
		IApplySerialService {

	@Autowired
	private IApplySerialDao applySerialDao;
	
	@Override
	public void save(ApplySerial applySerial) {
		applySerialDao.save(applySerial);
	}

	@Override
	public void update(ApplySerial applySerial) {
		applySerialDao.update(applySerial);
	}

	@Override
	public void delete(ApplySerial applySerial) {
		applySerialDao.delete(applySerial);
	}

	@Override
	public ApplySerial findByMulti(SerialNameEnum name, SerialTypeEnum type,
			Integer year) {
		return applySerialDao.findByMulti(name, type, year);
	}

	@Override
	public String createSerialNumber(SerialNameEnum name, SerialTypeEnum type) {
		StringBuilder sb = new StringBuilder();
		//获取时间
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String date = DateUtilTools.format(DateUtilTools.getNowDate(), DateUtilTools.PATTERN_DATE_1);
		ApplySerial applySerial = this.findByMulti(name, type, year);
		//如果为空，则向applySerial中插入一条新数据,并返回数据
		Integer max = 1;
		if(ObjectUtils.equals(applySerial, null)) {
			applySerial = new ApplySerial(name, type, max, year);
			this.save(applySerial);
		} else {
			max = applySerial.getMax();
			max += 1;
			applySerial.setMax(max);
			this.update(applySerial);
		}
		//不为空，max数值加1后返回
		sb.append(date + "_").append(applySerial.getName().name())
				.append("(" + applySerial.getType().name() + ")_")
				.append(max);
		return sb.toString();
	}

}
