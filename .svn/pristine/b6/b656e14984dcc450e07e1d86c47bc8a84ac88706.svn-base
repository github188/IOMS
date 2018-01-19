package cn.com.atnc.ioms.entity.duty.satellite.day.tes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.duty.satellite.day.BaseSatelliteInfo;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.enums.duty.satellite.TxjdMainResult;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TesBaseDataModel;

/**
 * 通讯基地-TES-TES 网管工作站主备状态
 *
 * @author 段衍林
 * @2017年2月17日 上午10:54:14
 */
@Entity
@Table(name = "TB_OM_DUTY_SAT_TXJD_MAIN_STATE")
public class TxjdMainState extends BaseSatelliteInfo {

	private static final long serialVersionUID = 1L;

	private TxjdMainResult tes081; // TES081
	private TxjdMainResult tes281; // TES281
	private TxjdMainResult tes381; // TES381
	private TxjdMainResult tes481; // TES481

	public TxjdMainState() {
		super();
	}

	public TxjdMainState(TesBaseDataModel tesBaseDataModel,
			BaseSatelliteInfo baseSatelliteInfo, SatelliteCheckContent content) {
		super();
		this.tes081 = tesBaseDataModel.getTes081();
		this.tes281 = tesBaseDataModel.getTes281();
		this.tes381 = tesBaseDataModel.getTes381();
		this.tes481 = tesBaseDataModel.getTes481();
		super.setCheckContent(content);
		super.setCreateDate(baseSatelliteInfo.getCreateDate());
		super.setCreateTime(baseSatelliteInfo.getCreateTime());
		super.setCreater(baseSatelliteInfo.getCreater());
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TES081")
	public TxjdMainResult getTes081() {
		return tes081;
	}

	public void setTes081(TxjdMainResult tes081) {
		this.tes081 = tes081;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TES281")
	public TxjdMainResult getTes281() {
		return tes281;
	}

	public void setTes281(TxjdMainResult tes281) {
		this.tes281 = tes281;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TES381")
	public TxjdMainResult getTes381() {
		return tes381;
	}

	public void setTes381(TxjdMainResult tes381) {
		this.tes381 = tes381;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TES481")
	public TxjdMainResult getTes481() {
		return tes481;
	}

	public void setTes481(TxjdMainResult tes481) {
		this.tes481 = tes481;
	}
}
