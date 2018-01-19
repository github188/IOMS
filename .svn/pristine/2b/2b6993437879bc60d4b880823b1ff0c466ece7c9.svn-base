package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;

/**
 * 十里河——PES-中频机架运行情况
 * 
 * @author shijiyong
 * @date 2016年10月13日 下午2:25:42
 * @version 1.0, 2016年10月13日 下午2:25:42
 */
@Entity
@Table(name="TB_OM_DUTY_STA_SLH_ZPJJ_STATE")
public class SlhZpjjState extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;


	private String inr1;	//INR1
	private String inr2;	//INR2
	private String inr3;	//INR3
	private String inr4;	//INR4
	private String inr5;	//INR5
	private String inr6;	//INR6
	private String inr7;	//INR7
	private String inrb;	//备用INR
	private String ebi;		//EBI/No(dB)
	private String ebt;		//EBT/No(dB)
	private EnvironmentEquipCheck checkid; //巡检id

	@Column(name = "inr1")
	public String getInr1() {
		return inr1;
	}

	public void setInr1(String inr1) {
		this.inr1 = inr1;
	}

	@Column(name = "inr2")
	public String getInr2() {
		return inr2;
	}

	public void setInr2(String inr2) {
		this.inr2 = inr2;
	}

	@Column(name = "inr3")
	public String getInr3() {
		return inr3;
	}

	public void setInr3(String inr3) {
		this.inr3 = inr3;
	}

	@Column(name = "inr4")
	public String getInr4() {
		return inr4;
	}

	public void setInr4(String inr4) {
		this.inr4 = inr4;
	}

	@Column(name = "inr5")
	public String getInr5() {
		return inr5;
	}

	public void setInr5(String inr5) {
		this.inr5 = inr5;
	}

	@Column(name = "inr6")
	public String getInr6() {
		return inr6;
	}

	public void setInr6(String inr6) {
		this.inr6 = inr6;
	}

	@Column(name = "inrb")
	public String getInrb() {
		return inrb;
	}

	public void setInrb(String inrb) {
		this.inrb = inrb;
	}

	@Column(name = "ebi")
	public String getEbi() {
		return ebi;
	}

	public void setEbi(String ebi) {
		this.ebi = ebi;
	}

	@Column(name = "ebt")
	public String getEbt() {
		return ebt;
	}

	public void setEbt(String ebt) {
		this.ebt = ebt;
	}

	@ManyToOne
	@JoinColumn(name = "check_id")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}
	@Column(name = "inr7")
	public String getInr7() {
		return inr7;
	}

	public void setInr7(String inr7) {
		this.inr7 = inr7;
	}

	

}
