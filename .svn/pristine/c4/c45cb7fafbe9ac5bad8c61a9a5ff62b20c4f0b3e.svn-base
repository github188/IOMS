/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Mar 7, 2011 3:05:32 PM
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.operstat.atm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;

/**
 * 交换机板卡实体类
 * 
 * @author wangpeng
 * @date:Mar 7, 2011 3:05:32 PM
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_CARD")
public class Card extends MyStringUUIDEntity {

	/***************************************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -3404114479128933416L;
	private AtmNode node;
	private String nodeCode;
	private String cardSlot;
	private String cardFrontType;
	private String cardFrontSerial;
	private String cardBackUpperType;
	private String cardBackUpperSerial;
	private String cardBackLowerType;
	private String cardBackLowerSerial;
	private String cardBackType;
	private String cardBackSerial;
	private Date recordTime;

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
	 * @return the cardFrontType
	 */
	@Column(name = "CARD_FRONT_TYPE")
	public String getCardFrontType() {
		return cardFrontType;
	}

	/**
	 * @param cardFrontType
	 *            the cardFrontType to set
	 */
	public void setCardFrontType(String cardFrontType) {
		this.cardFrontType = cardFrontType;
	}

	/**
	 * @return the cardFrontSerial
	 */
	@Column(name = "CARD_FRONT_SERIAL")
	public String getCardFrontSerial() {
		return cardFrontSerial;
	}

	/**
	 * @param cardFrontSerial
	 *            the cardFrontSerial to set
	 */
	public void setCardFrontSerial(String cardFrontSerial) {
		this.cardFrontSerial = cardFrontSerial;
	}

	/**
	 * @return the cardBackUpperType
	 */
	@Column(name = "CARD_BACK_UPPER_TYPE")
	public String getCardBackUpperType() {
		return cardBackUpperType;
	}

	/**
	 * @param cardBackUpperType
	 *            the cardBackUpperType to set
	 */
	public void setCardBackUpperType(String cardBackUpperType) {
		this.cardBackUpperType = cardBackUpperType;
	}

	/**
	 * @return the cardBackUpperSerial
	 */
	@Column(name = "CARD_BACK_UPPER_SERIAL")
	public String getCardBackUpperSerial() {
		return cardBackUpperSerial;
	}

	/**
	 * @param cardBackUpperSerial
	 *            the cardBackUpperSerial to set
	 */
	public void setCardBackUpperSerial(String cardBackUpperSerial) {
		this.cardBackUpperSerial = cardBackUpperSerial;
	}

	/**
	 * @return the cardBackLowerType
	 */
	@Column(name = "CARD_BACK_LOWER_TYPE")
	public String getCardBackLowerType() {
		return cardBackLowerType;
	}

	/**
	 * @param cardBackLowerType
	 *            the cardBackLowerType to set
	 */
	public void setCardBackLowerType(String cardBackLowerType) {
		this.cardBackLowerType = cardBackLowerType;
	}

	/**
	 * @return the cardBackLowerSerial
	 */
	@Column(name = "CARD_BACK_LOWER_SERIAL")
	public String getCardBackLowerSerial() {
		return cardBackLowerSerial;
	}

	/**
	 * @param cardBackLowerSerial
	 *            the cardBackLowerSerial to set
	 */
	public void setCardBackLowerSerial(String cardBackLowerSerial) {
		this.cardBackLowerSerial = cardBackLowerSerial;
	}

	/**
	 * @return the cardBackType
	 */
	@Column(name = "CARD_BACK_TYPE")
	public String getCardBackType() {
		return cardBackType;
	}

	/**
	 * @param cardBackType
	 *            the cardBackType to set
	 */
	public void setCardBackType(String cardBackType) {
		this.cardBackType = cardBackType;
	}

	/**
	 * @return the cardBackSerial
	 */
	@Column(name = "CARD_BACK_SERIAL")
	public String getCardBackSerial() {
		return cardBackSerial;
	}

	/**
	 * @param cardBackSerial
	 *            the cardBackSerial to set
	 */
	public void setCardBackSerial(String cardBackSerial) {
		this.cardBackSerial = cardBackSerial;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
