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
@Table(name = "TB_BD_ATM_PNNI_LNS_PXM_155")
public class PnniLnsPxm155 extends MyStringUUIDEntity {

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
	private String lineLpbk;
	private String MEDIUM_LINE_SRC;
	private String MEDIUM_LINE_TYPE;
	private String medium_line_codeing;
	private String alarmState;
	private String validIntvl;
	private boolean use;
	private String sonet;
	private String lineState;
	private String aspEnable;

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

	@Column(name = "LINE_LPBK")
	public String getLineLpbk() {
		return lineLpbk;
	}

	public void setLineLpbk(String lineLpbk) {
		this.lineLpbk = lineLpbk;
	}

	@Column(name = "ALARM_STATE")
	public String getAlarmState() {
		return alarmState;
	}

	public void setAlarmState(String alarmState) {
		this.alarmState = alarmState;
	}

	@Column(name = "USE")
	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

	@Column(name = "MEDIUM_LINE_TYPE")
	public String getMEDIUM_LINE_TYPE() {
		return MEDIUM_LINE_TYPE;
	}

	public void setMEDIUM_LINE_TYPE(String mEDIUM_LINE_TYPE) {
		MEDIUM_LINE_TYPE = mEDIUM_LINE_TYPE;
	}

	@Column(name = "MEDIUM_LINE_SCR")
	public String getMEDIUM_LINE_SRC() {
		return MEDIUM_LINE_SRC;
	}

	public void setMEDIUM_LINE_SRC(String mEDIUM_LINE_SRC) {
		MEDIUM_LINE_SRC = mEDIUM_LINE_SRC;
	}

	@Column(name = "VALID_INTVLS")
	public String getValidIntvl() {
		return validIntvl;
	}

	public void setValidIntvl(String validIntvl) {
		this.validIntvl = validIntvl;
	}

	@Column(name = "SONET")
	public String getSonet() {
		return sonet;
	}

	public void setSonet(String sonet) {
		this.sonet = sonet;
	}

	@Column(name = "LINE_STATE")
	public String getLineState() {
		return lineState;
	}

	public void setLineState(String lineState) {
		this.lineState = lineState;
	}
	@Column(name = "MEDIUM_LINE_CODE")
	public String getMedium_line_codeing() {
		return medium_line_codeing;
	}

	public void setMedium_line_codeing(String medium_line_codeing) {
		this.medium_line_codeing = medium_line_codeing;
	}
	@Column(name = "APS_ENABLE")
	public String getAspEnable() {
		return aspEnable;
	}

	public void setAspEnable(String aspEnable) {
		this.aspEnable = aspEnable;
	}

}
