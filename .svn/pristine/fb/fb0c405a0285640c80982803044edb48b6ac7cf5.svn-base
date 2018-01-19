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

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:25:18
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_TES_TXPOWER_LOG")
public class TesTxPowerLog extends StringUUIDEntity {
	private static final long serialVersionUID = -5400118841405788536L;
	private TesSlot tesSlot;//槽号
	private String fromNum;//变更前数值
	private String toNum;//变更后数值
	private Calendar recordTime;//变更时间
	private String info;//描述信息

	@ManyToOne
	@JoinColumn(name = "TES_SLOT_ID")
	public TesSlot getTesSlot() {
		return tesSlot;
	}

	public void setTesSlot(TesSlot tesSlot) {
		this.tesSlot = tesSlot;
	}

	@Column(name = "RECORD_TIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

    @Column(name = "FROM_NUM")
	public String getFromNum() {
        return fromNum;
    }

    public void setFromNum(String fromNum) {
        this.fromNum = fromNum;
    }

    @Column(name = "TO_NUM")
    public String getToNum() {
        return toNum;
    }

    public void setToNum(String toNum) {
        this.toNum = toNum;
    }

    public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
