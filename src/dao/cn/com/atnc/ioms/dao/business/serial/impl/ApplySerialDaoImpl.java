/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName ApplyBaseInfoDaoImpl.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.baseinfo.impl
 * @author ku
 * @date 2015年5月14日下午5:32:50
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.business.serial.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.serial.IApplySerialDao;
import cn.com.atnc.ioms.entity.business.serial.ApplySerial;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;


/**
 * 申请信息序号DAO实现类
 * @author WangLingbin
 * @date 2015年10月27日 上午11:02:45
 * @since 1.0.0
 */
@Repository
public class ApplySerialDaoImpl extends MyBaseDao<ApplySerial> implements
		IApplySerialDao {

	@Override
	public ApplySerial findByMulti(SerialNameEnum name, SerialTypeEnum type,
			Integer year) {
		StringBuilder hql = new StringBuilder(" from ApplySerial where 1=1 ");
		List<Object> params = new ArrayList<Object>();
		if(!ObjectUtils.equals(name, null)) {
			hql.append("and name = ?");
			params.add(name);
		}
		if(!ObjectUtils.equals(type, null)) {
			hql.append("and type = ?");
			params.add(type);
		}
		if(!ObjectUtils.equals(year, null)) {
			hql.append("and year = ?");
			params.add(year);
		}
		@SuppressWarnings("unchecked")
		List<ApplySerial> applySerials = 
				(List<ApplySerial>) super.queryList(hql.toString(), params.toArray());
		if(CollectionUtils.isEmpty(applySerials)) {
			return null;
		} else {
			return applySerials.get(0);
		}
	}

}
