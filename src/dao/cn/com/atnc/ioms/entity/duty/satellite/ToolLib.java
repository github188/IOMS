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
import cn.com.atnc.ioms.enums.duty.satellite.ToolStatus;

/**
 * 卫星工具库
 *
 * @author 段衍林
 * @2016年11月29日 上午10:22:09
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_TOOl_LIB")
public class ToolLib extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String name; // 工具名称
	private String address; // 存放位置
	private String num; // 数量
	private User keeper; // 保管人
	private String remark; // 备注
	private Date storeTime; // 入库时间
	private ToolStatus lendStatus; // 借出状态（借出或入库）
	private User borrower; // 借用人
	private Date lendTime; // 借出时间
	private Date backTime; // 归还时间

	private Date checkTime; // 记录时间
	private Date updateTime; // 记录时间
	private User operator; // 操作人

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "NUM")
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	@ManyToOne
	@JoinColumn(name = "KEEPER")
	public User getKeeper() {
		return keeper;
	}

	public void setKeeper(User keeper) {
		this.keeper = keeper;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "STORE_TIME")
	public Date getStoreTime() {
		return storeTime;
	}

	public void setStoreTime(Date storeTime) {
		this.storeTime = storeTime;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LEND_STATUS")
	public ToolStatus getLendStatus() {
		return lendStatus;
	}

	public void setLendStatus(ToolStatus lendStatus) {
		this.lendStatus = lendStatus;
	}

	@ManyToOne
	@JoinColumn(name = "BORROWER")
	public User getBorrower() {
		return borrower;
	}

	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "LEND_TIME")
	public Date getLendTime() {
		return lendTime;
	}

	public void setLendTime(Date lendTime) {
		this.lendTime = lendTime;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "BACK_TIME")
	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
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
}
