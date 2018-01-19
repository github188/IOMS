package cn.com.atnc.ioms.model.maintain.pollinginfo;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.entity.maintain.circuit.EquipCircuit;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuCarrierFreq;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.KuNodeParameter;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.OduPolling;
import cn.com.atnc.ioms.entity.maintain.pollinginfo.Wafr08Port0Stat;
import cn.com.atnc.ioms.enums.basedata.Bureau;

 /**
 * 此处添加类PollingQueryModel的描述信息
 *
 * @author wangzhicheng
 * @date 2015-4-27 下午2:44:16
 * @since 1.0.0
 */
public class PollingInfoQueryModel extends MyPaginModel {
	
	private MaintainEquip equipId;// 告警关联设备id
	private Bureau bureau;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date startRecordTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date endRecordTime;
	
    private String stname;
    private OduPolling oduPolling;
    private KuNodeParameter kuNodeParameter;
    private KuCarrierFreq kuCarrierFreq;
    private Wafr08Port0Stat wafr08Port0Stat;
    private EquipCircuit equipCircuit;
    
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date recordTime;
    private String optType;
    private int index;
    
	public MaintainEquip getEquipId() {
		return equipId;
	}
	public void setEquipId(MaintainEquip equipId) {
		this.equipId = equipId;
	}
	public String getOptType() {
		return optType;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public OduPolling getOduPolling() {
		return oduPolling;
	}
	public void setOduPolling(OduPolling oduPolling) {
		this.oduPolling = oduPolling;
	}
	public KuNodeParameter getKuNodeParameter() {
		return kuNodeParameter;
	}
	public void setKuNodeParameter(KuNodeParameter kuNodeParameter) {
		this.kuNodeParameter = kuNodeParameter;
	}
	public KuCarrierFreq getKuCarrierFreq() {
		return kuCarrierFreq;
	}
	public void setKuCarrierFreq(KuCarrierFreq kuCarrierFreq) {
		this.kuCarrierFreq = kuCarrierFreq;
	}
	public String getStname() {
		return stname;
	}
	public void setStname(String stname) {
		this.stname = stname;
	}
	public Date getEndRecordTime() {
		return endRecordTime;
	}
	public void setEndRecordTime(Date endRecordTime) {
		this.endRecordTime = endRecordTime;
	}
	public Date getStartRecordTime() {
		return startRecordTime;
	}
	public void setStartRecordTime(Date startRecordTime) {
		this.startRecordTime = startRecordTime;
	}
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
	public Wafr08Port0Stat getWafr08Port0Stat() {
		return wafr08Port0Stat;
	}
	public void setWafr08Port0Stat(Wafr08Port0Stat wafr08Port0Stat) {
		this.wafr08Port0Stat = wafr08Port0Stat;
	}
	public EquipCircuit getEquipCircuit() {
		return equipCircuit;
	}
	public void setEquipCircuit(EquipCircuit equipCircuit) {
		this.equipCircuit = equipCircuit;
	}
	public Date getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
}
