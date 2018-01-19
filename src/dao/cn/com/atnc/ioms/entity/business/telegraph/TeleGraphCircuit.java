package cn.com.atnc.ioms.entity.business.telegraph;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;


/**
 * 民航转报网转报电路申请
 * @author WangLingbin
 * @date 2015年10月16日 下午3:58:09
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_OM_APPLY_TELEGRAM_CIRCUIT")
public class TeleGraphCircuit extends MyStringUUIDEntity {
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
	private String identifier;
	/**
	 * TODO（使用地点）
	 * @since 1.0.0
	 */
	private String userArea;
	
	/**
	 * TODO（信道名称）
	 * @since 1.0.0
	 */
	private String channelName;
	
	/**
	 * TODO（入冠字）
	 * @since 1.0.0
	 */
	private String inWord;
	
	/**
	 * TODO（出冠字）
	 * @since 1.0.0
	 */
	private String outWord;
	
	/**
	 * TODO（告警地址）
	 * @since 1.0.0
	 */
	private String alarmAddress;
	
	/**
	 * TODO（报头）
	 * @since 1.0.0
	 */
	private String masthead;
	
	/**
	 * TODO（报尾）
	 * @since 1.0.0
	 */
	private String trailer;
	/**
	 * TODO（信道速率）
	 * @since 1.0.0
	 */
	private String speed;
	/**
	 * TODO（码制）
	 * @since 1.0.0
	 */
	private String code;
	/**
	 * TODO（所属队列）
	 * @since 1.0.0
	 */
	private String queue;
	/**
	 * TODO（申请时间）
	 * @since 1.0.0
	 */
	private Date applyTime;
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
	@Column(name = "identifier")
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	@Column(name = "use_area")
	public String getUserArea() {
		return userArea;
	}
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}
	@Column(name = "channel_name")
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	@Column(name = "in_word")
	public String getInWord() {
		return inWord;
	}
	public void setInWord(String inWord) {
		this.inWord = inWord;
	}
	@Column(name = "out_word")
	public String getOutWord() {
		return outWord;
	}
	public void setOutWord(String outWord) {
		this.outWord = outWord;
	}
	@Column(name = "alram_address")
	public String getAlarmAddress() {
		return alarmAddress;
	}
	public void setAlarmAddress(String alarmAddress) {
		this.alarmAddress = alarmAddress;
	}
	@Column(name = "masthead")
	public String getMasthead() {
		return masthead;
	}
	public void setMasthead(String masthead) {
		this.masthead = masthead;
	}
	@Column(name = "trailer")
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	@Column(name = "speed")
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	@Column(name = "code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Column(name = "queue")
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "apply_time")
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	@Column(name = "num")
	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
