/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-1 下午3:53:25
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.tes;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;


@Entity
@Table(name = "TB_BD_TES_SERVICE")
public class TesService extends MyStringUUIDEntity {
	// node->equip->site 所以不用 定义  site
	
	private static final long serialVersionUID = 428760460877268773L;	
	
	//private Bureau bureau;// 管局
	private TesNode activeNode;//主叫节点
	private String activeSlot;// 主叫槽号	
	
	private String activeSiteId;// 主叫站点	
	private String passiveSiteId;// 被叫站点id
	
	private String passiveNodeId;//被叫节点id
	
	private String activeNodeId;//主叫节点id

	private TesNode passiveNode;//被叫节点
	private String passiveSlot;// 被叫槽号
	private String circuitName;// 电路名称，客服平台不显示
	private String rate;//速率 
	private String sync;// 是否同步 
	private String clock;//时钟    ????excel静态  表中没有 	
	private String serviceMemo;
	
	private transient  List<String>  activeSlots;// 主叫槽号	
	private String clientInfo;// 客户备注
	
	@Column(name = "MEMO")
	public String getServiceMemo() {
		return serviceMemo;
	}

	public void setServiceMemo(String serviceMemo) {
		this.serviceMemo = serviceMemo;
	}

	@Column(name = "CLIENT_INFO")
	public String getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}

	@Transient
	public List<String>  getActiveSlots() {
		return activeSlots;
	}
	
	@Transient
	public List<String>  getPassiveSlots() {
		return passiveSlots;
	}

	public void setActiveSlots(List<String>  activeSlots) {
		this.activeSlots = activeSlots;
	}

	public void setPassiveSlots(List<String>  passiveSlots) {
		this.passiveSlots = passiveSlots;
	}

	private transient  List<String>  passiveSlots;// 主叫槽号	
	@Column(name = "SYNC")
	public String getSync() {
		return sync;
	}

	public void setSync(String sync) {
		this.sync = sync;
	}

	private String bandWidthPool;//频带池
	private String info;//备注
	private boolean isValid;// 是否有效  ?? excel静态  表中没有 
	
	private User optUser;// 更新人
	private Calendar optTime;// 更新时间	
	
	// 非持久化对象	
	private transient String activeNodeCode;
	private transient String passiveNodeCode;
	private  SatelliteSite activeSatelliteSite;
	private  SatelliteSite passiveSatelliteSite;
	
	@ManyToOne
	@JoinColumn(name = "ACTIVE_SITE")
	public SatelliteSite getActiveSatelliteSite() {
		return activeSatelliteSite;
	}
	
	@ManyToOne
	@JoinColumn(name = "PASSIVE_SITE")
	public SatelliteSite getPassiveSatelliteSite() {
		return passiveSatelliteSite;
	}


	@Transient
	public String getActiveSiteId() {
		return activeSiteId;
	}
	
	@Transient
	public String getPassiveSiteId() {
		return passiveSiteId;
	}


	
	@ManyToOne
	@JoinColumn(name = "OPT_USER")
	public User getOptUser() {
		return optUser;
	}	
	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}

	public void setOptTime(Calendar optTime) {
		
		this.optTime = optTime;
	}

	@Column(name = "OPT_TIME")	
	public Calendar getOptTime() {
		if (optTime == null) {
			return Calendar.getInstance();
		}
		return optTime;
	}
	
		
	
	@Transient
	public String getActiveNodeCode() {
		return activeNodeCode;
	}
	@Transient
	public String getPassiveNodeCode() {
		return passiveNodeCode;
	}



	@Transient
	public String getActiveNodeId() {
		return activeNodeId;
	}
	
	@Transient
	public String getPassiveNodeId() {
		return passiveNodeId;
	}


	
/*	@Enumerated(EnumType.STRING)
	@Column(name = "BUREAU")
	public Bureau getBureau() {
		return bureau;
	}*/
	
	@ManyToOne
	@JoinColumn(name = "ACTIVE_NODE")
	public TesNode getActiveNode() {
		return activeNode;
	}
	
	
	@Column(name = "ACTIVE_SLOT")
	public String getActiveSlot() {
		return activeSlot;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "PASSIVE_NODE")
	public TesNode getPassiveNode() {
		return passiveNode;
	}
	
	
	@Column(name = "PASSIVE_SLOT")
	public String getPassiveSlot() {
		return passiveSlot;
	}
	
	
	@Column(name = "CIRCUIT_NAME")
	public String getCircuitName() {
		return circuitName;
	}
	
	
	@Column(name = "RATE")
	public String getRate() {
		return rate;
	}
	
	
	
	
	
	
	@Column(name = "CLOCK")
	public String getClock() {
		return clock;
	}
	
	@Column(name = "BAND_WIDTH_POOL")
	public String getBandWidthPool() {
		return bandWidthPool;
	}
	
	
	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}
	
	@Column(name = "VALID")
	public boolean isValid() {
		return isValid;
	}
	
	
	public void setActiveSiteId(String activeSiteId) {
		this.activeSiteId = activeSiteId;
	}

	public void setPassiveSiteId(String passiveSiteId) {
		this.passiveSiteId = passiveSiteId;
	}
	public void setActiveSatelliteSite(SatelliteSite activeSatelliteSite) {
		this.activeSatelliteSite = activeSatelliteSite;
	}
	public void setPassiveSatelliteSite(SatelliteSite passiveSatelliteSite) {
		this.passiveSatelliteSite = passiveSatelliteSite;
	}
	
	public void setActiveNodeCode(String activeNodeCode) {
		this.activeNodeCode = activeNodeCode;
	}

	public void setPassiveNodeCode(String passiveNodeCode) {
		this.passiveNodeCode = passiveNodeCode;
	}
	
	/*public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}*/
	public void setActiveNode(TesNode activeNode) {
		this.activeNode = activeNode;
	}
	public void setActiveSlot(String activeSlot) {
		this.activeSlot = activeSlot;
	}
	public void setPassiveNode(TesNode passiveNode) {
		this.passiveNode = passiveNode;
	}
	public void setPassiveSlot(String passiveSlot) {
		this.passiveSlot = passiveSlot;
	}
	public void setCircuitName(String circuitName) {
		this.circuitName = circuitName;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	public void setClock(String clock) {
		this.clock = clock;
	}
	public void setBandWidthPool(String bandWidthPool) {
		this.bandWidthPool = bandWidthPool;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	public void setActiveNodeId(String activeNodeId) {
		this.activeNodeId = activeNodeId;
	}

	public void setPassiveNodeId(String passiveNodeId) {
		this.passiveNodeId = passiveNodeId;
	}
}
