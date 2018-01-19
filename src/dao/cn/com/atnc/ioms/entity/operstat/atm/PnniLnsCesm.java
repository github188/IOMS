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
@Table(name = "TB_BD_ATM_PNNI_LNS_CESM")
public class PnniLnsCesm extends MyStringUUIDEntity {

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
	private String CONN_TYPE;
	private String LENGTH;
	private String STATUS_CODING;
	private String XMT_CLOCK_SOURCE;
	private String STATS_ALARM;
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

	@Column(name = "CONN_TYPE")
	public String getCONN_TYPE() {
		return CONN_TYPE;
	}

	public void setCONN_TYPE(String cONN_TYPE) {
		CONN_TYPE = cONN_TYPE;
	}

	@Column(name = "LENGTH")
	public String getLENGTH() {
		return LENGTH;
	}

	public void setLENGTH(String lENGTH) {
		LENGTH = lENGTH;
	}

	@Column(name = "STATUS_CODING")
	public String getSTATUS_CODING() {
		return STATUS_CODING;
	}

	public void setSTATUS_CODING(String sTATUS_CODING) {
		STATUS_CODING = sTATUS_CODING;
	}

	@Column(name = "XMT_CLOCK_SOURCE")
	public String getXMT_CLOCK_SOURCE() {
		return XMT_CLOCK_SOURCE;
	}

	public void setXMT_CLOCK_SOURCE(String xMT_CLOCK_SOURCE) {
		XMT_CLOCK_SOURCE = xMT_CLOCK_SOURCE;
	}

	@Column(name = "STATS_ALARM")
	public String getSTATS_ALARM() {
		return STATS_ALARM;
	}

	public void setSTATS_ALARM(String sTATS_ALARM) {
		STATS_ALARM = sTATS_ALARM;
	}

}
