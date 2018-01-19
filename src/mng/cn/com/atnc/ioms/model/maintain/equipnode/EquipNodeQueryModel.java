package cn.com.atnc.ioms.model.maintain.equipnode;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.SubnetType;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * 此处添加类AlarmInfoQueryModel的描述信息
 *
 * @author wangzhicheng
 * @date 2015-5-4 上午8:57:10
 * @since 1.0.0
 */
public class EquipNodeQueryModel extends MyPaginModel {

	private MaintainEquip maintainEquip; // 维保设备
	private Equip equip; // 抽象设备（节点表）

	// dyl 添加
	private String code;
	// 设备节点名称
	private String kuNodeName;
	private Bureau bureau;
	// 子网类型
	private SubnetType subnetType;
	//设备名称
	private String menameLike;
	//节点名称
	private String eqnameLike;

	public String getKuNodeName() {
		return kuNodeName;
	}

	public void setKuNodeName(String kuNodeName) {
		this.kuNodeName = kuNodeName;
	}

	public SubnetType getSubnetType() {
		return subnetType;
	}

	public void setSubnetType(SubnetType subnetType) {
		this.subnetType = subnetType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar startRecordTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar endRecordTime;

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Calendar createTime; // 配置时间

	public MaintainEquip getMaintainEquip() {
		return maintainEquip;
	}

	public void setMaintainEquip(MaintainEquip maintainEquip) {
		this.maintainEquip = maintainEquip;
	}

	public Equip getEquip() {
		return equip;
	}

	public void setEquip(Equip equip) {
		this.equip = equip;
	}

	public Calendar getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Calendar createTime) {
		this.createTime = createTime;
	}

	public String getMenameLike() {
		return menameLike;
	}

	public void setMenameLike(String menameLike) {
		this.menameLike = menameLike;
	}

	public String getEqnameLike() {
		return eqnameLike;
	}

	public void setEqnameLike(String eqnameLike) {
		this.eqnameLike = eqnameLike;
	}

	public Calendar getStartRecordTime() {
		return startRecordTime;
	}

	public void setStartRecordTime(Calendar startRecordTime) {
		this.startRecordTime = startRecordTime;
	}

	public Calendar getEndRecordTime() {
		return endRecordTime;
	}

	public void setEndRecordTime(Calendar endRecordTime) {
		this.endRecordTime = endRecordTime;
	}

}
