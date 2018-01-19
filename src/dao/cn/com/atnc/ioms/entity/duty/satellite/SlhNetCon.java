package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;

/**
 * 十里河-PES-PES 网络连通性
 * 
 * @author shijiyong
 * @date 2016年10月13日 下午2:03:52
 * @version 1.0, 2016年10月13日 下午2:03:52
 */
@Entity
@Table(name="TB_OM_DUTY_STA_SLH_NET_CON")
public class SlhNetCon extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;


	private String con3;	//网管连通性10.34.64.3
	private String con4;	//网管连通性10.34.64.4
	private String con5;	//网管连通性10.34.64.5
	private String con6;	//网管连通性10.34.64.6
	private EnvironmentEquipCheck checkid;	//巡检id

	@Column(name = "con3")
	public String getCon3() {
		return con3;
	}

	public void setCon3(String con3) {
		this.con3 = con3;
	}

	@Column(name = "con4")
	public String getCon4() {
		return con4;
	}

	public void setCon4(String con4) {
		this.con4 = con4;
	}

	@Column(name = "con5")
	public String getCon5() {
		return con5;
	}

	public void setCon5(String con5) {
		this.con5 = con5;
	}

	@Column(name = "con6")
	public String getCon6() {
		return con6;
	}

	public void setCon6(String con6) {
		this.con6 = con6;
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
