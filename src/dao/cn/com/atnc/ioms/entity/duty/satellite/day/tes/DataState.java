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
 * 通信基地-TES-TES 网管数据库状态 /十里河-PES-PES 网管数据状态
 *
 * @author 段衍林
 * @2017年2月13日 下午12:27:34
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_OM_DUTY_SAT_DATA_STATE")
public class DataState extends BaseSatelliteInfo {

	private SatelliteStatus dataState; // 网管系统在线数据库为擦caac081

	public DataState() {
		super();
	}

	public DataState(TesBaseDataModel tesBaseDataModel,
			BaseSatelliteInfo baseSatelliteInfo, SatelliteCheckContent content) {
		super();
		this.dataState = tesBaseDataModel.getDataState();
		super.setCheckContent(content);
		super.setCreateDate(baseSatelliteInfo.getCreateDate());
		super.setCreateTime(baseSatelliteInfo.getCreateTime());
		super.setCreater(baseSatelliteInfo.getCreater());
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "DATA_STATE")
	public SatelliteStatus getDataState() {
		return dataState;
	}

	public void setDataState(SatelliteStatus dataState) {
		this.dataState = dataState;
	}
}
