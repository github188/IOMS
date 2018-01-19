/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:25:18
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.tes;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:25:18
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_TES_TXPOWER")
public class TesTxPower extends StringUUIDEntity {
	private static final long serialVersionUID = -5400118841405788536L;
	private TesSlot tesSlot;
	private String power;
	private String freq;
	private Calendar recordTime;
	private User optUser;
	private Calendar optTime;
	private Boolean valid;
	private TesTxPowerStat tesStat;
	private String over;

	@ManyToOne
	@JoinColumn(name = "TES_SLOT_ID")
	public TesSlot getTesSlot() {
		return tesSlot;
	}

	public void setTesSlot(TesSlot tesSlot) {
		this.tesSlot = tesSlot;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	@Column(name = "FREQ")
	public String getFreq() {
		return freq;
	}

	public void setFreq(String freq) {
		this.freq = freq;
	}

	@Column(name = "RECORD_TIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	@ManyToOne
	@JoinColumn(name = "OPT_USER")
	public User getOptUser() {
		return optUser;
	}

	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}

	@Column(name = "OPT_TIME")
	public Calendar getOptTime() {
		return optTime;
	}

	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}

	@Column(name = "VALID")
	public Boolean getValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	@ManyToOne
	@JoinColumn(name = "TES_STAT_ID")
	public TesTxPowerStat getTesStat() {
		return tesStat;
	}

	public void setTesStat(TesTxPowerStat tesStat) {
		this.tesStat = tesStat;
	}

	@Column(name = "IS_OVER")
	public String getOver() {
		return over;
	}

	public void setOver(String over) {
		this.over = over;
	}

}
