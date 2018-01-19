package cn.com.atnc.ioms.entity.business.evaluate;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.business.baseinfo.ApplyBaseInfo;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.enums.business.evaluate.GradeEnum;

 /**
 * 用户评价实体类
 *
 * @author Wang zhicheng
 * @date 2015年5月26日 上午9:20:40
 * @since 1.0.0
 */
@Entity
@Table(name="TB_OM_APPLY_EVALUATE")
public class ApplyEvaluate extends MyStringUUIDEntity {

	private static final long serialVersionUID = -822397277443380962L;
	
	private ApplyBaseInfo applyBaseInfo;
	private GradeEnum grade;
	private String remark;
	private Client evaluateUser;
	private Calendar evaluateTime;
	
	@ManyToOne
	@JoinColumn(name="apply_baseinfo")
	public ApplyBaseInfo getApplyBaseInfo() {
		return applyBaseInfo;
	}
	public void setApplyBaseInfo(ApplyBaseInfo applyBaseInfo) {
		this.applyBaseInfo = applyBaseInfo;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name="grade")
	public GradeEnum getGrade() {
		return grade;
	}
	public void setGrade(GradeEnum grade) {
		this.grade = grade;
	}
	
	@Column(name="remark")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@ManyToOne
	@JoinColumn(name="evaluate_user")
	public Client getEvaluateUser() {
		return evaluateUser;
	}
	public void setEvaluateUser(Client evaluateUser) {
		this.evaluateUser = evaluateUser;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name="evaluate_time")
	public Calendar getEvaluateTime() {
		return evaluateTime;
	}
	public void setEvaluateTime(Calendar evaluateTime) {
		this.evaluateTime = evaluateTime;
	}
	
}
