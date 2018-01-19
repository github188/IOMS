package cn.com.atnc.ioms.entity.duty.satellite.day.tes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.duty.satellite.day.BaseSatelliteInfo;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteStatus;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TesBaseDataModel;

/**
 * 通信基地-TES—DecServer 连通性
 *
 * @author 段衍林
 * @2017年2月15日 上午9:28:13
 */
@Entity
@Table(name = "TB_OM_DUTY_SAT_TXJD_DEC_CON")
public class TxjdDecCon extends BaseSatelliteInfo {

	private static final long serialVersionUID = 1L;

	private SatelliteStatus decServerCon08A; // DECServer工作状态连通性08A
	private SatelliteStatus decServerCon08B; // DECServer工作状态连通性08B
	private SatelliteStatus decServerCon08C; // DECServer工作状态连通性08C

	public TxjdDecCon() {
		super();
	}

	public TxjdDecCon(TesBaseDataModel tesBaseDataModel,
			BaseSatelliteInfo baseSatelliteInfo, SatelliteCheckContent content) {
		super();
		this.decServerCon08A = tesBaseDataModel.getDecServerCon08A();
		this.decServerCon08B = tesBaseDataModel.getDecServerCon08B();
		this.decServerCon08C = tesBaseDataModel.getDecServerCon08C();
		super.setCheckContent(content);
		super.setCreateDate(baseSatelliteInfo.getCreateDate());
		super.setCreateTime(baseSatelliteInfo.getCreateTime());
		super.setCreater(baseSatelliteInfo.getCreater());
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DECSERVER_CON08A")
	public SatelliteStatus getDecServerCon08A() {
		return decServerCon08A;
	}

	public void setDecServerCon08A(SatelliteStatus decServerCon08A) {
		this.decServerCon08A = decServerCon08A;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DECSERVER_CON08B")
	public SatelliteStatus getDecServerCon08B() {
		return decServerCon08B;
	}

	public void setDecServerCon08B(SatelliteStatus decServerCon08B) {
		this.decServerCon08B = decServerCon08B;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DECSERVER_CON08C")
	public SatelliteStatus getDecServerCon08C() {
		return decServerCon08C;
	}

	public void setDecServerCon08C(SatelliteStatus decServerCon08C) {
		this.decServerCon08C = decServerCon08C;
	}
}
