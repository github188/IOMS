/**
 * @ProjectName IOMS
 * @FileName KuCarrierFreqModel.java
 * @PackageName:cn.com.atnc.ioms.model.maintain.pollinginfo
 * @author XuTongYang
 * @date 2015年6月18日上午9:22:45
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.model.maintain.pollinginfo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;

/**
 * 此处添加类KuCarrierFreqModel的描述信息
 *
 * @author XuTongYang
 * @date 2015年6月18日 上午9:22:45
 * @since 1.0.0
 */
public class KuCarrierFreqModel extends BaseModel {
	private MaintainEquip equipId;// 告警关联设备id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date recordTime;
	
	public KuCarrierFreqModel(MaintainEquip equipId,Date recordTime) {
		super();
		this.equipId = equipId;
		this.recordTime = recordTime;
	}
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
}
