/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Mar 7, 2011 3:44:52 PM
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.operstat.atm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 * Pnni：本地端口运行信息实体类
 * 
 * @author wangpeng
 * @date:Mar 7, 2011 3:44:52 PM
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_PNNI_LNS_FRSM")
public class PnniLnsFrsm extends MyStringUUIDEntity {

	/***************************************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 8846370040939239850L;
	private PnniLns pnniLns;
	private Card card;
	private String nodeName;
	private String slot;
	private String lineNum;
	private String lineType;
	private String ALARM;
	private String INTERFACE_TYPE;
	private String RATE;
	private String STATUS;
	private boolean use;

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

	@ManyToOne
	@JoinColumn(name = "TB_PNNI_LNS_ID")
	public PnniLns getPnniLns() {
		return pnniLns;
	}

	public void setPnniLns(PnniLns pnniLns) {
		this.pnniLns = pnniLns;
	}

	@Column(name = "NODE_NAME")
	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	@Column(name = "SLOT")
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	@Column(name = "LINE_NUM")
	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	@Column(name = "LINE_TYPE")
	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	@Column(name = "USE")
	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	@Column(name = "ALARM")
	public String getALARM() {
		return ALARM;
	}

	public void setALARM(String aLARM) {
		ALARM = aLARM;
	}

	@Column(name = "INTERFACE_TYPE")
	public String getINTERFACE_TYPE() {
		return INTERFACE_TYPE;
	}

	public void setINTERFACE_TYPE(String iNTERFACE_TYPE) {
		INTERFACE_TYPE = iNTERFACE_TYPE;
	}

	@Column(name = "RATE")
	public String getRATE() {
		return RATE;
	}

	public void setRATE(String rATE) {
		RATE = rATE;
	}

	@Column(name = "STATUS")
	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}

}