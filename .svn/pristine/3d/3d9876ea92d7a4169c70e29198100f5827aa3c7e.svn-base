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
@Table(name = "TB_BD_ATM_PNNI_LNS_AXSM_XG")
public class PnniLnsAxsmXG extends MyStringUUIDEntity {

	/***************************************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 8846370040939239850L;
	private PnniLns pnniLns;
	private Card card;
	private String nodeName;
	private String slot;
	private String lineNum;
	private String lineState;
	private String lineType;
	private String lineLpbk;
	private String FRAME_SCRAMBLE;
	private String MEDIUM_LINE_CODING;
	private String MEDIUM_LINE_TYPE;
	private String valid_intvls;
	private String APS_ENABLE;
	private String alarmState;
	private String channel;
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

	@Column(name = "FRAME_SCRAMBLE")
	public String getFRAME_SCRAMBLE() {
		return FRAME_SCRAMBLE;
	}

	public void setFRAME_SCRAMBLE(String fRAME_SCRAMBLE) {
		FRAME_SCRAMBLE = fRAME_SCRAMBLE;
	}

	@Column(name = "MEDIUM_LINE_CODEING")
	public String getMEDIUM_LINE_CODING() {
		return MEDIUM_LINE_CODING;
	}

	public void setMEDIUM_LINE_CODING(String mEDIUM_LINE_CODING) {
		MEDIUM_LINE_CODING = mEDIUM_LINE_CODING;
	}

	@Column(name = "MEDIUM_LINE_TYPE")
	public String getMEDIUM_LINE_TYPE() {
		return MEDIUM_LINE_TYPE;
	}

	public void setMEDIUM_LINE_TYPE(String mEDIUM_LINE_TYPE) {
		MEDIUM_LINE_TYPE = mEDIUM_LINE_TYPE;
	}

	@Column(name = "APS_ENABLE")
	public String getAPS_ENABLE() {
		return APS_ENABLE;
	}

	public void setAPS_ENABLE(String aPS_ENABLE) {
		APS_ENABLE = aPS_ENABLE;
	}

	@Column(name = "CHANNLE")
	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Column(name = "LINE_STATE")
	public String getLineState() {
		return lineState;
	}

	public void setLineState(String lineState) {
		this.lineState = lineState;
	}
	@Column(name = "VALID_INTVLS")
	public String getValid_intvls() {
		return valid_intvls;
	}

	public void setValid_intvls(String valid_intvls) {
		this.valid_intvls = valid_intvls;
	}

}
