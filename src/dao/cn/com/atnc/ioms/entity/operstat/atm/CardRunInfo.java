/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Mar 7, 2011 3:31:51 PM
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.operstat.atm;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.IsAlarm;

/**
 * 板卡运行信息实体类
 * 
 * @author wangpeng
 * @date:Mar 7, 2011 3:31:51 PM
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_CARD_RUNINFO")
public class CardRunInfo extends StringUUIDEntity {

	/***************************************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -8629116500005510657L;
	private Card card;
	private String nodeCode;
	private String cardSlot;
	private String cardFbState;
	private String cardType;
	private String cardAlarmStatus;
	private String cardRedundantSlot;
	private String cardRedundancyType;
	private Integer cardRunTime;
	private IsAlarm isAlarm;
	private Calendar recordTime;
	
	@ManyToOne
	@JoinColumn(name = "TB_CARD_ID")
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}
	
	/**
	 * @return the nodeCode
	 */
	@Column(name = "NODE_CODE")
	public String getNodeCode() {
		return nodeCode;
	}

	/**
	 * @param nodeCode
	 *            the nodeCode to set
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	/**
	 * @return the cardSlot
	 */
	@Column(name = "CARD_SLOT")
	public String getCardSlot() {
		return cardSlot;
	}

	/**
	 * @param cardSlot
	 *            the cardSlot to set
	 */
	public void setCardSlot(String cardSlot) {
		this.cardSlot = cardSlot;
	}

	/**
	 * @return the cardFbState
	 */
	@Column(name = "CARD_FB_STATE")
	public String getCardFbState() {
		return cardFbState;
	}

	/**
	 * @param cardFbState
	 *            the cardFbState to set
	 */
	public void setCardFbState(String cardFbState) {
		this.cardFbState = cardFbState;
	}

	/**
	 * @return the cardType
	 */
	@Column(name = "CARD_TYPE")
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType
	 *            the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	/**
	 * @return the cardAlarmStatus
	 */
	@Column(name = "CARD_ALARM_STATUS")
	public String getCardAlarmStatus() {
		return cardAlarmStatus;
	}

	/**
	 * @param cardAlarmStatus
	 *            the cardAlarmStatus to set
	 */
	public void setCardAlarmStatus(String cardAlarmStatus) {
		this.cardAlarmStatus = cardAlarmStatus;
	}

	/**
	 * @return the cardRedundantSlot
	 */
	@Column(name = "CARD_REDUNDANT_SLOT")
	public String getCardRedundantSlot() {
		return cardRedundantSlot;
	}

	/**
	 * @param cardRedundantSlot
	 *            the cardRedundantSlot to set
	 */
	public void setCardRedundantSlot(String cardRedundantSlot) {
		this.cardRedundantSlot = cardRedundantSlot;
	}

	/**
	 * @return the cardRedundancyType
	 */
	@Column(name = "CARD_REDUNDANCY_TYPE")
	public String getCardRedundancyType() {
		return cardRedundancyType;
	}

	/**
	 * @param cardRedundancyType
	 *            the cardRedundancyType to set
	 */
	public void setCardRedundancyType(String cardRedundancyType) {
		this.cardRedundancyType = cardRedundancyType;
	}
	
	
	@Column(name = "CARD_RUN_TIME")
	public Integer getCardRunTime() {
		return cardRunTime;
	}

	public void setCardRunTime(Integer cardRunTime) {
		this.cardRunTime = cardRunTime;
	}

	@Column(name="ISALARM")
	public IsAlarm getIsAlarm() {
		return isAlarm;
	}

	public void setIsAlarm(IsAlarm isAlarm) {
		this.isAlarm = isAlarm;
	}

	@Column(name="RECORDTIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
