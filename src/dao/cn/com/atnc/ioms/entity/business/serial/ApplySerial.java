/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName ApplyBaseInfo.java
 * @PackageName:cn.com.atnc.pcsp.entity.business
 * @author ku
 * @date 2015年5月13日下午2:12:40
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.business.serial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.business.serial.SerialNameEnum;
import cn.com.atnc.ioms.enums.business.serial.SerialTypeEnum;


/**
 * 申请信息序号实体
 * @author WangLingbin
 * @date 2015年10月27日 上午10:53:30
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_SERIAL")
public class ApplySerial extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	private SerialNameEnum name;		//申请名称
	private SerialTypeEnum type;		//申请类型
	private Integer max;				//序号最大值
	private Integer year;				//年份
	
	public ApplySerial() {
		super();
	}
	
	public ApplySerial(SerialNameEnum name, SerialTypeEnum type, Integer max,
			Integer year) {
		super();
		this.name = name;
		this.type = type;
		this.max = max;
		this.year = year;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "name")
	public SerialNameEnum getName() {
		return name;
	}
	public void setName(SerialNameEnum name) {
		this.name = name;
	}
	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	public SerialTypeEnum getType() {
		return type;
	}
	public void setType(SerialTypeEnum type) {
		this.type = type;
	}
	@Column(name = "max")
	public Integer getMax() {
		return max;
	}
	public void setMax(Integer max) {
		this.max = max;
	}
	@Column(name = "year")
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
}
