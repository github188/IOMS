package cn.com.atnc.ioms.entity.duty.satellite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;

/**
 * 东四-PES-TES链路工作状态
 *
 * @author 段衍林
 * @2016年11月16日 下午2:51:23
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_DS_LINK")
public class DsPesTesLink extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String link1001A; // 1001_1
	private String link1001B; // 1001_2
	private String link1001C; // 1001_3
	private String link1001D; // 1001_4

	private String link1002A; // 1002_1
	private String link1002B; // 1002_2
	private String link1002C; // 1002_3
	private String link1002D; // 1002_4

	private String link1003A; // 1003_1
	private String link1003B; // 1003_2
	private String link1003C; // 1003_3
	private String link1003D; // 1003_4

	private Date checkTime; // 记录时间
	private User operator; // 操作人
	private Date updateTime; // 更新时间
	private User updater; // 更新操作人
	private SatelliteDayAutoType equipName; // 设备名称

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@ManyToOne
	@JoinColumn(name = "UPDATER")
	public User getUpdater() {
		return updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}

	@Column(name = "LINK_1001_A")
	public String getLink1001A() {
		return link1001A;
	}

	public void setLink1001A(String link1001a) {
		link1001A = link1001a;
	}

	@Column(name = "LINK_1001_B")
	public String getLink1001B() {
		return link1001B;
	}

	public void setLink1001B(String link1001b) {
		link1001B = link1001b;
	}

	@Column(name = "LINK_1001_C")
	public String getLink1001C() {
		return link1001C;
	}

	public void setLink1001C(String link1001c) {
		link1001C = link1001c;
	}

	@Column(name = "LINK_1001_D")
	public String getLink1001D() {
		return link1001D;
	}

	public void setLink1001D(String link1001d) {
		link1001D = link1001d;
	}

	@Column(name = "LINK_1002_A")
	public String getLink1002A() {
		return link1002A;
	}

	public void setLink1002A(String link1002a) {
		link1002A = link1002a;
	}

	@Column(name = "LINK_1002_B")
	public String getLink1002B() {
		return link1002B;
	}

	public void setLink1002B(String link1002b) {
		link1002B = link1002b;
	}

	@Column(name = "LINK_1002_C")
	public String getLink1002C() {
		return link1002C;
	}

	public void setLink1002C(String link1002c) {
		link1002C = link1002c;
	}

	@Column(name = "LINK_1002_D")
	public String getLink1002D() {
		return link1002D;
	}

	public void setLink1002D(String link1002d) {
		link1002D = link1002d;
	}

	@Column(name = "LINK_1003_A")
	public String getLink1003A() {
		return link1003A;
	}

	public void setLink1003A(String link1003a) {
		link1003A = link1003a;
	}

	@Column(name = "LINK_1003_B")
	public String getLink1003B() {
		return link1003B;
	}

	public void setLink1003B(String link1003b) {
		link1003B = link1003b;
	}

	@Column(name = "LINK_1003_C")
	public String getLink1003C() {
		return link1003C;
	}

	public void setLink1003C(String link1003c) {
		link1003C = link1003c;
	}

	@Column(name = "LINK_1003_D")
	public String getLink1003D() {
		return link1003D;
	}

	public void setLink1003D(String link1003d) {
		link1003D = link1003d;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "RECORD_TIME")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@ManyToOne
	@JoinColumn(name = "OPERATOR")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EQUIP_NAME")
	public SatelliteDayAutoType getEquipName() {
		return equipName;
	}

	public void setEquipName(SatelliteDayAutoType equipName) {
		this.equipName = equipName;
	}
}
