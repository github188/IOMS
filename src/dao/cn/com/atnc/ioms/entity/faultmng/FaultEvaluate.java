package cn.com.atnc.ioms.entity.faultmng;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.business.evaluate.GradeEnum;

/**
 * 事件单评价实体
 *
 * @author 段衍林
 * @2016年11月9日 下午4:28:06
 */
@Entity
@Table(name = "TB_FM_FAULT_EVALUATE")
public class FaultEvaluate extends MyStringUUIDEntity {
	private static final long serialVersionUID = -6739376065386900888L;
	private String faultId;						//故障单id
	private GradeEnum evaluate;					//事件单评价
	private String remark;						//备注
	private User operator;						//评价人
	private Date operatTime;					//评价时间
	
	@Column(name = "FAULT_ID")
	public String getFaultId() {
		return faultId;
	}

	public void setFaultId(String faultId) {
		this.faultId = faultId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EVALUATE")
	public GradeEnum getEvaluate() {
		return evaluate;
	}

	public void setEvaluate(GradeEnum evaluate) {
		this.evaluate = evaluate;
	}

	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ManyToOne
	@JoinColumn(name = "OPERATOR")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@Column(name = "OPERAT_TIME")
	public Date getOperatTime() {
		return operatTime;
	}

	public void setOperatTime(Date operatTime) {
		this.operatTime = operatTime;
	}
}