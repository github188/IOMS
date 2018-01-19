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
 * 通讯基地-TES-TES 网管进程状态
 *
 * @author 段衍林
 * @2017年2月13日 下午3:53:38
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_OM_DUTY_SAT_TXJD_PRO_STATE")
public class TxjdProState extends BaseSatelliteInfo {

	private SatelliteStatus PROCESS_STATE081; // 网管工作站进程081
	private SatelliteStatus PROCESS_STATE281; // 网管工作站进程281
	private SatelliteStatus PROCESS_STATE381; // 网管工作站进程381
	private SatelliteStatus PROCESS_STATE481; // 网管工作站进程481

	public TxjdProState() {
		super();
	}

	public TxjdProState(TesBaseDataModel tesBaseDataModel,
			BaseSatelliteInfo baseSatelliteInfo, SatelliteCheckContent content) {
		super();
		this.PROCESS_STATE081 = tesBaseDataModel.getPROCESS_STATE081();
		this.PROCESS_STATE281 = tesBaseDataModel.getPROCESS_STATE281();
		this.PROCESS_STATE381 = tesBaseDataModel.getPROCESS_STATE381();
		this.PROCESS_STATE481 = tesBaseDataModel.getPROCESS_STATE481();
		super.setCheckContent(content);
		super.setCreateDate(baseSatelliteInfo.getCreateDate());
		super.setCreateTime(baseSatelliteInfo.getCreateTime());
		super.setCreater(baseSatelliteInfo.getCreater());
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "process_state081")
	public SatelliteStatus getPROCESS_STATE081() {
		return PROCESS_STATE081;
	}

	public void setPROCESS_STATE081(SatelliteStatus PROCESS_STATE081) {
		this.PROCESS_STATE081 = PROCESS_STATE081;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "process_state281")
	public SatelliteStatus getPROCESS_STATE281() {
		return PROCESS_STATE281;
	}

	public void setPROCESS_STATE281(SatelliteStatus PROCESS_STATE281) {
		this.PROCESS_STATE281 = PROCESS_STATE281;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "process_state381")
	public SatelliteStatus getPROCESS_STATE381() {
		return PROCESS_STATE381;
	}

	public void setPROCESS_STATE381(SatelliteStatus PROCESS_STATE381) {
		this.PROCESS_STATE381 = PROCESS_STATE381;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "process_state481")
	public SatelliteStatus getPROCESS_STATE481() {
		return PROCESS_STATE481;
	}

	public void setPROCESS_STATE481(SatelliteStatus PROCESS_STATE481) {
		this.PROCESS_STATE481 = PROCESS_STATE481;
	}
}
