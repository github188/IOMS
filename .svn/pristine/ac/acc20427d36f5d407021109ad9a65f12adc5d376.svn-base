/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at 2011-6-1 下午01:14:48
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.operstat.atm;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.CardType;

/**
 * dspports信息实体类
 * 
 * @author wangpeng
 * @date:2014-6-6 下午01:14:48
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_PORTS")
public class Ports extends MyStringUUIDEntity {

	/*****************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -3636005091486288203L;
	private AtmNode node;
	private Card card;
	private String ifnum;
	private CardType cardType;
	private String portTypeDetail;
	private Calendar recordTime;// 记录时间

	@ManyToOne
	@JoinColumn(name = "TB_NODE_ID")
	public AtmNode getNode() {
		return node;
	}

	public void setNode(AtmNode node) {
		this.node = node;
	}

	@ManyToOne
	@JoinColumn(name = "TB_CARD_ID")
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	@Column(name = "IF_NUM")
	public String getIfnum() {
		return ifnum;
	}

	public void setIfnum(String ifnum) {
		this.ifnum = ifnum;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "PORT_TYPE")
	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	@Column(name = "RECORDTIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}
	@Column(name="PORT_TYPE_DETAIL")
	public String getPortTypeDetail() {
		return portTypeDetail;
	}

	public void setPortTypeDetail(String portTypeDetail) {
		this.portTypeDetail = portTypeDetail;
	}
	
}
