package cn.com.atnc.ioms.model.duty.statellite.day;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.model.MyPaginModel;

public class TxjdLinkStateModel extends MyPaginModel {

	private String id;
	private EnvironmentEquipCheck checkid;// 巡检id
	private String name; // 卫星设备名称
	private User operator; // 操作人名称
	private Date checkTime; // 查询日期
	private Date checkDate; // 检查日期
	private String outType; // tab页类型
	private CheckCatagory checkType;
	private EquipType equipType;

	private Date startTime; // 查询起始时间
	private Date endTime; // 查询结束时间

	private CheckResult link10071; // 1007机箱1号
	private CheckResult link10072; // 1007机箱2号
	private CheckResult link10073; // 1007机箱3号
	private CheckResult link10074; // 1007机箱4号(仰光)

	private CheckResult link10081; // 1008机箱1号(俄罗斯)
	private CheckResult link10082; // 1008机箱2号(沈阳PYB)
	private CheckResult link10083; // 1008机箱3号(广州PQB)
	private CheckResult link10084; // 1008机箱4号(上海PSA)

	private CheckResult link10091; // 1009机箱1号(乌鲁木齐PUA)
	private CheckResult link10092; // 1009机箱2号(首都机场PBK)
	private CheckResult link10093; // 1009机箱3号(首尔)
	private CheckResult link10094; // 1009机箱4号(平壤PGA)

	private CheckResult link100a1; // 100A机箱1号(加德满都)
	private CheckResult link100a2; // 100A机箱2号()
	private CheckResult link100a3; // 100A机箱3号()
	private CheckResult link100a4; // 100A机箱4号(成都PIA)

	private CheckResult link100f1; // 100F机箱1号(168A)
	private CheckResult link100f2; // 100F机箱2号(168B)
	private CheckResult link100f3; // 100F机箱3号(169)
	private CheckResult link100f4; // 100F机箱4号(外蒙833)

	private CheckResult link100111; // 1011机箱1号(乌兰巴托)
	private CheckResult link100112; // 1011机箱1号(昆明PKB)
	private CheckResult link100113; // 1011机箱1号(西安PXB)
	private CheckResult link100114; // 1011机箱1号()

	public TxjdLinkStateModel() {
	}

	public TxjdLinkStateModel(CheckResult link10071, CheckResult link10072, CheckResult link10073,
			CheckResult link10074,

			CheckResult link10081, CheckResult link10082, CheckResult link10083, CheckResult link10084,

			CheckResult link10091, CheckResult link10092, CheckResult link10093, CheckResult link10094,

			CheckResult link100a1, CheckResult link100a2, CheckResult link100a3, CheckResult link100a4,

			CheckResult link100f1, CheckResult link100f2, CheckResult link100f3, CheckResult link100f4,

			CheckResult link100111, CheckResult link100112, CheckResult link100113, CheckResult link100114, String id,
			EnvironmentEquipCheck checkid, Date checkDate, Date checkTime, User operator) {

		this.link10071 = link10071;
		this.link10072 = link10072;
		this.link10073 = link10073;
		this.link10074 = link10074;

		this.link10081 = link10081;
		this.link10082 = link10082;
		this.link10083 = link10083;
		this.link10084 = link10084;

		this.link10091 = link10091;
		this.link10092 = link10092;
		this.link10093 = link10093;
		this.link10094 = link10094;

		this.link100a1 = link100a1;
		this.link100a2 = link100a2;
		this.link100a3 = link100a3;
		this.link100a4 = link100a4;

		this.link100f1 = link100f1;
		this.link100f2 = link100f2;
		this.link100f3 = link100f3;
		this.link100f4 = link100f4;

		this.link100111 = link100111;
		this.link100112 = link100112;
		this.link100113 = link100113;
		this.link100114 = link100114;
		this.id = id;
		this.checkid = checkid;
		this.checkDate = checkDate;
		this.checkTime = checkTime;
		this.operator = operator;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getOutType() {
		return outType;
	}

	public void setOutType(String outType) {
		this.outType = outType;
	}

	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public CheckResult getLink10071() {
		return link10071;
	}

	public void setLink10071(CheckResult link10071) {
		this.link10071 = link10071;
	}

	public CheckResult getLink10072() {
		return link10072;
	}

	public void setLink10072(CheckResult link10072) {
		this.link10072 = link10072;
	}

	public CheckResult getLink10073() {
		return link10073;
	}

	public void setLink10073(CheckResult link10073) {
		this.link10073 = link10073;
	}

	public CheckResult getLink10074() {
		return link10074;
	}

	public void setLink10074(CheckResult link10074) {
		this.link10074 = link10074;
	}

	public CheckResult getLink10081() {
		return link10081;
	}

	public void setLink10081(CheckResult link10081) {
		this.link10081 = link10081;
	}

	public CheckResult getLink10082() {
		return link10082;
	}

	public void setLink10082(CheckResult link10082) {
		this.link10082 = link10082;
	}

	public CheckResult getLink10083() {
		return link10083;
	}

	public void setLink10083(CheckResult link10083) {
		this.link10083 = link10083;
	}

	public CheckResult getLink10084() {
		return link10084;
	}

	public void setLink10084(CheckResult link10084) {
		this.link10084 = link10084;
	}

	public CheckResult getLink10091() {
		return link10091;
	}

	public void setLink10091(CheckResult link10091) {
		this.link10091 = link10091;
	}

	public CheckResult getLink10092() {
		return link10092;
	}

	public void setLink10092(CheckResult link10092) {
		this.link10092 = link10092;
	}

	public CheckResult getLink10093() {
		return link10093;
	}

	public void setLink10093(CheckResult link10093) {
		this.link10093 = link10093;
	}

	public CheckResult getLink10094() {
		return link10094;
	}

	public void setLink10094(CheckResult link10094) {
		this.link10094 = link10094;
	}

	public CheckResult getLink100a1() {
		return link100a1;
	}

	public void setLink100a1(CheckResult link100a1) {
		this.link100a1 = link100a1;
	}

	public CheckResult getLink100a2() {
		return link100a2;
	}

	public void setLink100a2(CheckResult link100a2) {
		this.link100a2 = link100a2;
	}

	public CheckResult getLink100a3() {
		return link100a3;
	}

	public void setLink100a3(CheckResult link100a3) {
		this.link100a3 = link100a3;
	}

	public CheckResult getLink100a4() {
		return link100a4;
	}

	public void setLink100a4(CheckResult link100a4) {
		this.link100a4 = link100a4;
	}

	public CheckResult getLink100f1() {
		return link100f1;
	}

	public void setLink100f1(CheckResult link100f1) {
		this.link100f1 = link100f1;
	}

	public CheckResult getLink100f2() {
		return link100f2;
	}

	public void setLink100f2(CheckResult link100f2) {
		this.link100f2 = link100f2;
	}

	public CheckResult getLink100f3() {
		return link100f3;
	}

	public void setLink100f3(CheckResult link100f3) {
		this.link100f3 = link100f3;
	}

	public CheckResult getLink100f4() {
		return link100f4;
	}

	public void setLink100f4(CheckResult link100f4) {
		this.link100f4 = link100f4;
	}

	public CheckResult getLink100111() {
		return link100111;
	}

	public void setLink100111(CheckResult link100111) {
		this.link100111 = link100111;
	}

	public CheckResult getLink100112() {
		return link100112;
	}

	public void setLink100112(CheckResult link100112) {
		this.link100112 = link100112;
	}

	public CheckResult getLink100113() {
		return link100113;
	}

	public void setLink100113(CheckResult link100113) {
		this.link100113 = link100113;
	}

	public CheckResult getLink100114() {
		return link100114;
	}

	public void setLink100114(CheckResult link100114) {
		this.link100114 = link100114;
	}

}
