package cn.com.atnc.ioms.entity.duty.satellite.day.tes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.duty.satellite.day.BaseSatelliteInfo;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.model.duty.statellite.day.tes.TesBaseDataModel;

/**
 * 通讯基地-TES-TES网管工作站连通性
 *
 * @author 段衍林
 * @2017年2月14日 上午9:36:34
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_OM_DUTY_SAT_TXJD_WORK_CON")
public class TxjdWorkCon extends BaseSatelliteInfo {

	private String packetLoss081; // 081丢包率
	private String packetLoss281; // 281丢包率
	private String packetLoss381; // 381丢包率
	private String packetLoss481; // 481丢包率

	public TxjdWorkCon() {
		super();
	}

	public TxjdWorkCon(TesBaseDataModel tesBaseDataModel,
			BaseSatelliteInfo baseSatelliteInfo, SatelliteCheckContent content) {
		super();
		this.packetLoss081 = tesBaseDataModel.getPacketLoss081();
		this.packetLoss281 = tesBaseDataModel.getPacketLoss281();
		this.packetLoss381 = tesBaseDataModel.getPacketLoss381();
		this.packetLoss481 = tesBaseDataModel.getPacketLoss481();
		super.setCheckContent(content);
		super.setCreateDate(baseSatelliteInfo.getCreateDate());
		super.setCreateTime(baseSatelliteInfo.getCreateTime());
		super.setCreater(baseSatelliteInfo.getCreater());
	}

	@Column(name = "PACKET_LOSS081")
	public String getPacketLoss081() {
		return packetLoss081;
	}

	public void setPacketLoss081(String packetLoss081) {
		this.packetLoss081 = packetLoss081;
	}

	@Column(name = "PACKET_LOSS281")
	public String getPacketLoss281() {
		return packetLoss281;
	}

	public void setPacketLoss281(String packetLoss281) {
		this.packetLoss281 = packetLoss281;
	}

	@Column(name = "PACKET_LOSS381")
	public String getPacketLoss381() {
		return packetLoss381;
	}

	public void setPacketLoss381(String packetLoss381) {
		this.packetLoss381 = packetLoss381;
	}

	@Column(name = "PACKET_LOSS481")
	public String getPacketLoss481() {
		return packetLoss481;
	}

	public void setPacketLoss481(String packetLoss481) {
		this.packetLoss481 = packetLoss481;
	}
}
