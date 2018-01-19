package cn.com.atnc.ioms.entity.clientmng;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.enums.clientmng.ClientOptEnum;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;

/**
 *类说明:操作客户日志
 *@author 潘涛
 *@date 2014-3-19	下午3:03:57
 *@version:1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="TB_CS_CLIENT_OPTLOG")
public class ClientOptLog extends StringUUIDEntity {
	private Client client;
	private ClientOptEnum clientOpt;//操作
	private CsUserStatusEnum fromStatus;
	private CsUserStatusEnum toStatus;
	private String optName;//记录操作人姓名
	private Calendar optTime;//操作时间 
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="OPT_TYPE")
	public ClientOptEnum getClientOpt() {
		return clientOpt;
	}
	public void setClientOpt(ClientOptEnum clientOpt) {
		this.clientOpt = clientOpt;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="FROM_STATUS")
	public CsUserStatusEnum getFromStatus() {
		return fromStatus;
	}
	public void setFromStatus(CsUserStatusEnum fromStatus) {
		this.fromStatus = fromStatus;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="TO_STATUS")
	public CsUserStatusEnum getToStatus() {
		return toStatus;
	}
	public void setToStatus(CsUserStatusEnum toStatus) {
		this.toStatus = toStatus;
	}
	@Column(name="OPT_USER")
	public String getOptName() {
		return optName;
	}
	public void setOptName(String optName) {
		this.optName = optName;
	}
	@Column(name="OPT_TIME")
	public Calendar getOptTime() {
		return optTime;
	}
	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}
	
	
	
}
