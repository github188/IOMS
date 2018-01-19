package cn.com.atnc.ioms.model.faultmng;

import java.util.List;

import cn.com.atnc.ioms.entity.basedata.resource.Proxy;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.enums.faultmng.FaultAlarmStatus;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * 告警故障单查询model
 *
 * @author 段衍林
 * @2017年1月19日 下午3:10:26
 */
public class FaultAlarmQueryModel extends MyPaginModel {

	private FaultAlarmStatus status; // 告警事假单处置状态
	private MaintainEquip equip; // 告警设备
	private Proxy proxy; // 节点信息
	private List<FaultAlarmStatus> statuses; // 状态列表
	private String faultAlarmId;

	public String getFaultAlarmId() {
		return faultAlarmId;
	}

	public void setFaultAlarmId(String faultAlarmId) {
		this.faultAlarmId = faultAlarmId;
	}

	public Proxy getProxy() {
		return proxy;
	}

	public void setProxy(Proxy proxy) {
		this.proxy = proxy;
	}

	public List<FaultAlarmStatus> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<FaultAlarmStatus> statuses) {
		this.statuses = statuses;
	}

	public MaintainEquip getEquip() {
		return equip;
	}

	public void setEquip(MaintainEquip equip) {
		this.equip = equip;
	}

	public FaultAlarmStatus getStatus() {
		return status;
	}

	public void setStatus(FaultAlarmStatus status) {
		this.status = status;
	}
}