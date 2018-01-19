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
import cn.com.atnc.ioms.enums.duty.satellite.LR;
import cn.com.atnc.ioms.enums.duty.satellite.OnOff;

/**
 * 十里河-PES-PES网管设备状态
 * 
 * @author shijiyong
 * @date 2016年10月13日 下午2:09:01
 * @version 1.0, 2016年10月13日 下午2:09:01
 */
@Entity
@Table(name="TB_OM_DUTY_STA_SLH_EQU_STATE")
public class SlhEquState extends MyStringUUIDEntity {

	
	private static final long serialVersionUID = 1L;


	private String dpc38;	//DPC组1备用(DPC38)
	private String dpc58;	//DPC组1备用(DPC58)
	private OnOff NCC62;	//NCC2(62)
	private OnOff NCC63;	//NCC2(63)
	private LR umodup;		//UMOD(上)
	private LR umoddown;	//UNMD(下)

	private EnvironmentEquipCheck checkid;  //巡检id

	@Enumerated(EnumType.STRING)
	@Column(name = "dpc38")
	public String getDpc38() {
		return dpc38;
	}

	public void setDpc38(String dpc38) {
		this.dpc38 = dpc38;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "dpc58")
	public String getDpc58() {
		return dpc58;
	}

	public void setDpc58(String dpc58) {
		this.dpc58 = dpc58;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ncc62")
	public OnOff getNCC62() {
		return NCC62;
	}

	public void setNCC62(OnOff nCC62) {
		NCC62 = nCC62;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "ncc63")
	public OnOff getNCC63() {
		return NCC63;
	}

	public void setNCC63(OnOff nCC63) {
		NCC63 = nCC63;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "umod_up")
	public LR getUmodup() {
		return umodup;
	}

	public void setUmodup(LR umodup) {
		this.umodup = umodup;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "umod_down")
	public LR getUmoddown() {
		return umoddown;
	}

	public void setUmoddown(LR umoddown) {
		this.umoddown = umoddown;
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
