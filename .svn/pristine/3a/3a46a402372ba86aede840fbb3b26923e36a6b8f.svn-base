/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Mar 7, 2011 3:44:52 PM
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.operstat.atm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.enums.operstat.atm.EnumCollections.LnsType;

/**
 * Pnni：本地端口运行信息实体类
 * 
 * @author wangpeng
 * @date:Mar 7, 2011 3:44:52 PM
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_PNNI_LNS")
public class PnniLns extends MyStringUUIDEntity {

	/***************************************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = 8846370040939239850L;
	private AtmNode node;
	private Card card;
	private String nodeName;
	private String slot;
	private String lineNUm;
	private String lineType;
	private LnsType type;
	private String typeDetail;
	private boolean use;

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
	public String getLineNUm() {
		return lineNUm;
	}

	public void setLineNUm(String lineNUm) {
		this.lineNUm = lineNUm;
	}

	@Column(name = "LINE_TYPE")
	public String getLineType() {
		return lineType;
	}

	public void setLineType(String lineType) {
		this.lineType = lineType;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE")
	public LnsType getType() {
		return type;
	}

	public void setType(LnsType type) {
		this.type = type;
	}

	@Column(name = "TYPE_DETAIL")
	public String getTypeDetail() {
		return typeDetail;
	}

	public void setTypeDetail(String typeDetail) {
		this.typeDetail = typeDetail;
	}

	@Column(name = "USE")
	public boolean isUse() {
		return use;
	}

	public void setUse(boolean use) {
		this.use = use;
	}

}
