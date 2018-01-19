package cn.com.atnc.ioms.entity.operstat.atm;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.entity.basedata.atm.service.AtmService;

/**
 * 交换机运行信息实体类
 * 
 * @author：KuYonggang
 * @date：2014-6-19下午4:38:43
 * @version：1.0
 */
@Entity
@Table(name = "V_ATM_SERVICE_RUNINFO")
public class AtmServiceRunInfo extends MyStringUUIDEntity {

	private static final long serialVersionUID = -2681581242426311718L;
	private AtmService service;
	private AtmNode node;
	private Boolean isAlarm;
	private Date recordTime;

	@ManyToOne
	@JoinColumn(name = "TB_SERVICE_ID")
	public AtmService getService() {
		return service;
	}

	public void setService(AtmService service) {
		this.service = service;
	}

	@ManyToOne
	@JoinColumn(name = "TB_NODE_ID")
	public AtmNode getNode() {
		return node;
	}

	public void setNode(AtmNode node) {
		this.node = node;
	}

	public Boolean getIsAlarm() {
		return isAlarm;
	}

	public void setIsAlarm(Boolean isAlarm) {
		this.isAlarm = isAlarm;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

}
