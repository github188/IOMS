package cn.com.atnc.ioms.model.operstat.atm;

import java.util.Calendar;

import cn.com.atnc.ioms.entity.operstat.atm.Card;
import cn.com.atnc.ioms.model.MyPaginModel;
import cn.com.atnc.ioms.util.HqlStringTools;

/**
 * ATM板卡运行信息Model
 * 
 * @author Chenwei
 * @date 2014-8-26 上午10:44:47
 * @version 1.0
 */

public class AtmCardRunInfoModel extends MyPaginModel {
	private Card card;
	private String bureau;
	private String nodeCode;
	private String cardSlot;
	private String cardFbState;
	private String cardType;
	private String cardAlarmStatus;
	private String cardRedundantSlot;
	private String cardRedundancyType;
	private Integer cardRunTime;
	private Boolean isAlarm;
	private Calendar recordTime;
	
	private String atmNodeCodeLike;// 节点代码查询
	private String cardTypeLike;// 板卡类型查询

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public String getNodeCode() {
		return nodeCode;
	}

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getCardSlot() {
		return cardSlot;
	}

	public void setCardSlot(String cardSlot) {
		this.cardSlot = cardSlot;
	}

	public String getCardFbState() {
		return cardFbState;
	}

	public void setCardFbState(String cardFbState) {
		this.cardFbState = cardFbState;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardAlarmStatus() {
		return cardAlarmStatus;
	}

	public void setCardAlarmStatus(String cardAlarmStatus) {
		this.cardAlarmStatus = cardAlarmStatus;
	}

	public String getCardRedundantSlot() {
		return cardRedundantSlot;
	}

	public void setCardRedundantSlot(String cardRedundantSlot) {
		this.cardRedundantSlot = cardRedundantSlot;
	}

	public String getCardRedundancyType() {
		return cardRedundancyType;
	}

	public void setCardRedundancyType(String cardRedundancyType) {
		this.cardRedundancyType = cardRedundancyType;
	}

	public Integer getCardRunTime() {
		return cardRunTime;
	}

	public void setCardRunTime(Integer cardRunTime) {
		this.cardRunTime = cardRunTime;
	}

	public Boolean getIsAlarm() {
		return isAlarm;
	}

	public void setIsAlarm(Boolean isAlarm) {
		this.isAlarm = isAlarm;
	}

	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	public String getAtmNodeCodeLike() {
		return HqlStringTools.replaceSpecialChar(atmNodeCodeLike);
	}

	public void setAtmNodeCodeLike(String atmNodeCodeLike) {
		this.atmNodeCodeLike = atmNodeCodeLike;
	}

	public String getCardTypeLike() {
		return HqlStringTools.replaceSpecialChar(cardTypeLike);
	}

	public void setCardTypeLike(String cardTypeLike) {
		this.cardTypeLike = cardTypeLike;
	}

}
