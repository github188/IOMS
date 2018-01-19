/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Mar 7, 2011 3:31:51 PM
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.operstat.atm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;

/**
 * 板卡运行信息摘要实体类
 * 
 * @author wangpeng
 * @date:Mar 7, 2011 3:31:51 PM
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_CARD_RUNINFO_SUMMARY")
public class CardRunInfoSummary extends StringUUIDEntity {
	/*****************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 5165430260693457823L;
	private AtmNode node;
	private Card card;
	private String cardSlot;
	private int cardCriticalSum;
	private int cardMajorSum;
	private int cardMinorSum;
	private Boolean isAlarm;
	/**
	 * @return the node
	 */
	@ManyToOne
	@JoinColumn(name = "TB_NODE_ID")
	public AtmNode getNode() {
		return node;
	}

	public void setNode(AtmNode node) {
		this.node = node;
	}
	
	/**
	 * @return the card
	 */
	@ManyToOne
	@JoinColumn(name = "TB_CARD_ID")
	public Card getCard() {
		return card;
	}

	/**
	 * @param card
	 *            the card to set
	 */
	public void setCard(Card card) {
		this.card = card;
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
	 * @return the cardCriticalSum
	 */
	@Column(name = "CARD_CRITICAL_SUM")
	public int getCardCriticalSum() {
		return cardCriticalSum;
	}

	/**
	 * @param cardCriticalSum
	 *            the cardCriticalSum to set
	 */
	public void setCardCriticalSum(int cardCriticalSum) {
		this.cardCriticalSum = cardCriticalSum;
	}

	/**
	 * @return the cardMajorSum
	 */
	@Column(name = "CARD_MAJOR_SUM")
	public int getCardMajorSum() {
		return cardMajorSum;
	}

	/**
	 * @param cardMajorSum
	 *            the cardMajorSum to set
	 */
	public void setCardMajorSum(int cardMajorSum) {
		this.cardMajorSum = cardMajorSum;
	}

	/**
	 * @return the cardMinorSum
	 */
	@Column(name = "CARD_MINOR_SUM")
	public int getCardMinorSum() {
		return cardMinorSum;
	}

	/**
	 * @param cardMinorSum
	 *            the cardMinorSum to set
	 */
	public void setCardMinorSum(int cardMinorSum) {
		this.cardMinorSum = cardMinorSum;
	}

	public Boolean getIsAlarm() {
		return isAlarm;
	}

	public void setIsAlarm(Boolean isAlarm) {
		this.isAlarm = isAlarm;
	}
	
}
