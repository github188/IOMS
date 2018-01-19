package cn.com.atnc.ioms.entity.phonemng;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.phonemng.AgentStateEnum;
/**
 * 
 * @author hantianyu
 *
 */
@Entity
@Table(name = "TB_TEL_AGENTINFORMATION")
public class AgentInformation  extends MyStringUUIDEntity{
	private static final long serialVersionUID = -6739376065386900888L;

	private String agentinfo;//坐席号
	private AgentStateEnum agentState;//坐席状态，登录、未登录
	private String agentPwd;//密码
	private String agentAccount;//账户
	private String loginType;//电话连接方式
	private String username;
	
	@Column(name = "USERNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "AGENT")
	public String getAgentinfo() {
		return agentinfo;
	}
	public void setAgentinfo(String agentinfo) {
		this.agentinfo = agentinfo;
	}
	
	@Enumerated(EnumType.STRING)
    @Column(name="AGENT_STATE")
	public AgentStateEnum getAgentState() {
		return agentState;
	}
	public void setAgentState(AgentStateEnum agentState) {
		this.agentState = agentState;
	}
	@Column(name="AGENT_PWD")
	public String getAgentPwd() {
		return agentPwd;
	}
	public void setAgentPwd(String agentPwd) {
		this.agentPwd = agentPwd;
	}
	@Column(name="AGENT_ACCOUNT")
	public String getAgentAccount() {
		return agentAccount;
	}
	public void setAgentAccount(String agentAccount) {
		this.agentAccount = agentAccount;
	}
	@Column(name="LOGIN_TYPE")
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	
}
