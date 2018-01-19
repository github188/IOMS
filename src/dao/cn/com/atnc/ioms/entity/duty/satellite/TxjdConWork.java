package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.satellite.AF;

/**
 * 通信基地-TES-控制信道工作情况
 * 
 * @author shijiyong
 * @date 2016年10月13日 下午1:00:01
 * @version 1.0, 2016年10月13日 下午1:00:01
 */
@Entity
@Table(name="TB_OM_DUTY_STA_TXJD_CON_WORK")
public class TxjdConWork extends MyStringUUIDEntity {

	
	private static final long serialVersionUID = 1L;


	private AF control100101;		//控制信道工作情况100101
	private AF control100102;		//控制信道工作情况100102
	private AF control100103;		//控制信道工作情况100103
	private AF control100104;		//控制信道工作情况100104
	private AF control100201;		//控制信道工作情况100201
	private AF control100202;		//控制信道工作情况100202
	private AF control100203;		//控制信道工作情况100203
	private AF control100204;		//控制信道工作情况100204
	private AF control100301;		//控制信道工作情况100301
	private AF control100302;		//控制信道工作情况100302
	private AF control100303;		//控制信道工作情况100303
	private AF control100304;		//控制信道工作情况100304
	private AF control100401;		//控制信道工作情况100401
	private AF control100402;		//控制信道工作情况100402
	private AF control100403;		//控制信道工作情况100403
	private AF control100404;		//控制信道工作情况100404

	private EnvironmentEquipCheck checkid;  //巡检id

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100101")
	public AF getControl100101() {
		return control100101;
	}

	public void setControl100101(AF control100101) {
		this.control100101 = control100101;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100102")
	public AF getControl100102() {
		return control100102;
	}

	public void setControl100102(AF control100102) {
		this.control100102 = control100102;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100103")
	public AF getControl100103() {
		return control100103;
	}

	public void setControl100103(AF control100103) {
		this.control100103 = control100103;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100104")
	public AF getControl100104() {
		return control100104;
	}

	public void setControl100104(AF control100104) {
		this.control100104 = control100104;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100201")
	public AF getControl100201() {
		return control100201;
	}

	public void setControl100201(AF control100201) {
		this.control100201 = control100201;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100202")
	public AF getControl100202() {
		return control100202;
	}

	public void setControl100202(AF control100202) {
		this.control100202 = control100202;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100203")
	public AF getControl100203() {
		return control100203;
	}

	public void setControl100203(AF control100203) {
		this.control100203 = control100203;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100204")
	public AF getControl100204() {
		return control100204;
	}

	public void setControl100204(AF control100204) {
		this.control100204 = control100204;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100301")
	public AF getControl100301() {
		return control100301;
	}

	public void setControl100301(AF control100301) {
		this.control100301 = control100301;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100302")
	public AF getControl100302() {
		return control100302;
	}

	public void setControl100302(AF control100302) {
		this.control100302 = control100302;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100303")
	public AF getControl100303() {
		return control100303;
	}

	public void setControl100303(AF control100303) {
		this.control100303 = control100303;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100304")
	public AF getControl100304() {
		return control100304;
	}

	public void setControl100304(AF control100304) {
		this.control100304 = control100304;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100401")
	public AF getControl100401() {
		return control100401;
	}

	public void setControl100401(AF control100401) {
		this.control100401 = control100401;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100402")
	public AF getControl100402() {
		return control100402;
	}

	public void setControl100402(AF control100402) {
		this.control100402 = control100402;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100403")
	public AF getControl100403() {
		return control100403;
	}

	public void setControl100403(AF control100403) {
		this.control100403 = control100403;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "control_work100404")
	public AF getControl100404() {
		return control100404;
	}

	public void setControl100404(AF control100404) {
		this.control100404 = control100404;
	}

	@ManyToOne
	@JoinColumn(name = "check_id")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}

}
