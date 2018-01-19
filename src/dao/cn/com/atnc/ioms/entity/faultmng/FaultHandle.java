package cn.com.atnc.ioms.entity.faultmng;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.faultmng.FaultHandelType;
import cn.com.atnc.ioms.enums.faultmng.TransferType;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 故障单处置过程记录
 * @author duanyanlin 
 * 2016年6月17日 下午2:07:16
 */
@Entity
@Table(name = "TB_FM_FAULT_HANDLE")
public class FaultHandle extends MyStringUUIDEntity {
	private static final long serialVersionUID = -6739376065386900888L;
	private String faultId;						//故障单id
	private String faultNumber;					//故障单编号
	private Integer faultChildNumber;			//故障单子级编号
	private TransferType transferType;			//移交类别
	private String transferDept;				//移交部门
	private String nextHanleUser;				//下一个处理人
	private String faultDesc;					//故障单描述
	private String handleDesc;					//故障处理过程记录
	private String remark;						//备注
	private User operator;						//操作人
	private Date operatTime;					//操作时间
	private Date oaEndTime;						//跨部门移交的需要完成时间
	private FaultHandelType handleType;			//处理类别

	@Column(name = "USER_NAME")
	public String getNextHanleUser() {
		return this.nextHanleUser;
	}

	public void setNextHanleUser(String nextHanleUser) {
		this.nextHanleUser = nextHanleUser;
	}

	@Column(name = "FAULT_ID")
	public String getFaultId() {
		return this.faultId;
	}

	public void setFaultId(String faultId) {
		this.faultId = faultId;
	}

	@Column(name = "FAULT_NUMBER")
	public String getFaultNumber() {
		return this.faultNumber;
	}

	public void setFaultNumber(String faultNumber) {
		this.faultNumber = faultNumber;
	}

	@Column(name = "FAULT_CHLILD_NUMBER")
	public Integer getFaultChildNumber() {
		return this.faultChildNumber;
	}

	public void setFaultChildNumber(Integer faultChildNumber) {
		this.faultChildNumber = faultChildNumber;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TRANSFER_TYPE")
	public TransferType getTransferType() {
		return this.transferType;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	@Column(name = "TRANSFER_DEPT")
	public String getTransferDept() {
		return this.transferDept;
	}

	public void setTransferDept(String transferDept) {
		this.transferDept = transferDept;
	}

	@Column(name = "FAULT_DESC")
	public String getFaultDesc() {
		return this.faultDesc;
	}

	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	@Column(name = "HANDLE_DESC")
	public String getHandleDesc() {
		return this.handleDesc;
	}

	public void setHandleDesc(String handleDesc) {
		this.handleDesc = handleDesc;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne
	@JoinColumn(name = "OPERATOR")
	public User getOperator() {
		return this.operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@Column(name = "OPERAT_TIME")
	public Date getOperatTime() {
		return this.operatTime;
	}

	public void setOperatTime(Date operatTime) {
		this.operatTime = operatTime;
	}

	@Column(name = "OA_END_TIME")
	public Date getOaEndTime() {
		return this.oaEndTime;
	}

	public void setOaEndTime(Date oaEndTime) {
		this.oaEndTime = oaEndTime;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "HANDLE_TYPE")
	public FaultHandelType getHandleType() {
		return this.handleType;
	}

	public void setHandleType(FaultHandelType handleType) {
		this.handleType = handleType;
	}
}