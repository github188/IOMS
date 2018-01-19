package cn.com.atnc.ioms.entity.duty.satellite.day.tes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.duty.satellite.TxjdSynEquip;

/**
 * 通讯基地-TES-查看网管同步状态子级数据表
 *
 * @author 段衍林
 * @2017年2月15日 下午1:00:47
 */
@Entity
@Table(name = "TB_OM_DUTY_SAT_TXJD_SYN_RESULT")
public class TxjdSynResult extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;
	private TxjdSynState txjdSynState;// 绑定主数据表
	private Long serial;// 序号
	private TxjdSynEquip equipName;// 巡检设备类别
	private String cu;// CU
	private String ckt;// CKT
	private String hg;// HG
	private String dd;// DD
	private String route;// ROUTE

	public TxjdSynResult() {
		super();
	}

	public TxjdSynResult(TxjdSynState txjdSynState, Long serial,
			TxjdSynEquip equipName, String cu, String ckt, String hg,
			String dd, String route) {
		super();
		this.txjdSynState = txjdSynState;
		this.serial = serial;
		this.equipName = equipName;
		this.cu = cu;
		this.ckt = ckt;
		this.hg = hg;
		this.dd = dd;
		this.route = route;
	}

	@ManyToOne
	@JoinColumn(name = "STATE_ID")
	public TxjdSynState getTxjdSynState() {
		return txjdSynState;
	}

	public void setTxjdSynState(TxjdSynState txjdSynState) {
		this.txjdSynState = txjdSynState;
	}

	@Column(name = "SERIAL")
	public Long getSerial() {
		return serial;
	}

	public void setSerial(Long serial) {
		this.serial = serial;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EQUIP_NAME")
	public TxjdSynEquip getEquipName() {
		return equipName;
	}

	public void setEquipName(TxjdSynEquip equipName) {
		this.equipName = equipName;
	}

	@Column(name = "CU")
	public String getCu() {
		return cu;
	}

	public void setCu(String cu) {
		this.cu = cu;
	}

	@Column(name = "CKT")
	public String getCkt() {
		return ckt;
	}

	public void setCkt(String ckt) {
		this.ckt = ckt;
	}

	@Column(name = "HG")
	public String getHg() {
		return hg;
	}

	public void setHg(String hg) {
		this.hg = hg;
	}

	@Column(name = "DD")
	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	@Column(name = "ROUTE")
	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}
}
