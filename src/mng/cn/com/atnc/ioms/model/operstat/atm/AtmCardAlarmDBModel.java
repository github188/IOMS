/**
 * 
 */
package cn.com.atnc.ioms.model.operstat.atm;
import java.util.Calendar;

import cn.com.atnc.ioms.entity.operstat.atm.Card;

/**
 * ATM板卡告警DBModel
 * @author：KuYonggang
 * @date：2014-8-22下午6:24:58
 * @version：1.0
 */
public class AtmCardAlarmDBModel {

	private Card card;
	private String cardSlot;
	private String cardType;
	private int cardCriticalSum;
	private int cardMajorSum;
	private int cardMinorSum;
	private Calendar recordTime;
	private Boolean isAlarm;
	/**
	 * @param card
	 * @param cardSlot
	 * @param cardType
	 * @param cardCriticalSum
	 * @param cardMajorSum
	 * @param cardMinorSum
	 * @param recordTime
	 * @param isAlarm
	 */
	public AtmCardAlarmDBModel(Card card, String cardSlot, String cardType,
			int cardCriticalSum, int cardMajorSum, int cardMinorSum,
			Calendar recordTime, Boolean isAlarm) {
		super();
		this.card = card;
		this.cardSlot = cardSlot;
		this.cardType = cardType;
		this.cardCriticalSum = cardCriticalSum;
		this.cardMajorSum = cardMajorSum;
		this.cardMinorSum = cardMinorSum;
		this.recordTime = recordTime;
		this.isAlarm = isAlarm;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public String getCardSlot() {
		return cardSlot;
	}
	public void setCardSlot(String cardSlot) {
		this.cardSlot = cardSlot;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public int getCardCriticalSum() {
		return cardCriticalSum;
	}
	public void setCardCriticalSum(int cardCriticalSum) {
		this.cardCriticalSum = cardCriticalSum;
	}
	public int getCardMajorSum() {
		return cardMajorSum;
	}
	public void setCardMajorSum(int cardMajorSum) {
		this.cardMajorSum = cardMajorSum;
	}
	public int getCardMinorSum() {
		return cardMinorSum;
	}
	public void setCardMinorSum(int cardMinorSum) {
		this.cardMinorSum = cardMinorSum;
	}
	public Calendar getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}
	public Boolean getIsAlarm() {
		return isAlarm;
	}
	public void setIsAlarm(Boolean isAlarm) {
		this.isAlarm = isAlarm;
	}
	
}
