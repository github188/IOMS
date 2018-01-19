package cn.com.atnc.ioms.entity.business.telegraph;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.business.telegraph.ConnectionConditionEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphUsageEnum;

/**
 * 民航转报网转报地址及路由申请信息表
 * @author WangLingbin
 * @date 2015年6月18日 上午9:11:08
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_OM_APPLY_TELEGRAM_APPLYINFO")
public class TeleGraphApply extends MyStringUUIDEntity {
	/**
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * TODO（基础信息）
	 * @since 1.0.0
	 */
	private TeleGraph teleGraph;
	
	/**
	 * TODO（序号）
	 * @since 1.0.0
	 */
	private String identify;
	/**
	 * TODO（使用地点）
	 * @since 1.0.0
	 */
	private String userArea;
	
	/**
	 * TODO（申请时间）
	 * @since 1.0.0
	 */
	private Date applyTime;
	
	
	/**
	 * TODO（要求启用时间）
	 * @since 1.0.0
	 */
	private Date useTime;
	
	/**
	 * TODO（原地址）
	 * @since 1.0.0
	 */
	private String originalAddr;
	
	/**
	 * TODO（分配的通信路由地址）
	 * @since 1.0.0
	 */
	private String allocatedAddr;
	
	/**
	 * TODO（经办人）
	 * @since 1.0.0
	 */
	private String operPeople;
	
	/**
	 * TODO（经办时间）
	 * @since 1.0.0
	 */
	private Date operTime;
	
	/**
	 * TODO（终端连接情况）
	 * @since 1.0.0
	 */
	private ConnectionConditionEnum connection;
	
	/**
	 * TODO（申请用途）
	 * @since 1.0.0
	 */
	private TeleGraphUsageEnum usage;
	/**
	 * TODO（排序编号）
	 * @since 1.0.0
	 */
	private Integer num;

	@OneToOne
	@JoinColumn(name = "baseinfo")
	public TeleGraph getTeleGraph() {
		return teleGraph;
	}

	public void setTeleGraph(TeleGraph teleGraph) {
		this.teleGraph = teleGraph;
	}

	@Column(name = "identify")
	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	@Column(name = "use_area")
	public String getUserArea() {
		return userArea;
	}

	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "apply_time")
	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "use_time")
	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
	}

	@Column(name = "original_address")
	public String getOriginalAddr() {
		return originalAddr;
	}

	public void setOriginalAddr(String originalAddr) {
		this.originalAddr = originalAddr;
	}

	@Column(name = "allocated_address")
	public String getAllocatedAddr() {
		return allocatedAddr;
	}

	public void setAllocatedAddr(String allocatedAddr) {
		this.allocatedAddr = allocatedAddr;
	}

	@Column(name = "oper_people")
	public String getOperPeople() {
		return operPeople;
	}

	public void setOperPeople(String operPeople) {
		this.operPeople = operPeople;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "oper_time")
	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "connection")
	public ConnectionConditionEnum getConnection() {
		return connection;
	}

	public void setConnection(ConnectionConditionEnum connection) {
		this.connection = connection;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "usage")
	public TeleGraphUsageEnum getUsage() {
		return usage;
	}
	public void setUsage(TeleGraphUsageEnum usage) {
		this.usage = usage;
	}
	@Column(name = "num")
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
