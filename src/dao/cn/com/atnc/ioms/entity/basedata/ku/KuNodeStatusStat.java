/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-16 下午8:08:38
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.ku;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * @author:HuangYijie
 * @date:2014-4-16 下午8:08:38
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_KU_STATUS_STAT")
public class KuNodeStatusStat extends StringUUIDEntity {

	private static final long serialVersionUID = 7690013251370098701L;
	private String statusStandard;
	private Integer statusOver = 0;
	private Integer statusNormal = 0;
	private Double rxLevelTop;
	private Double rxLevelLow;
	private Integer rxLevelOver = 0;
	private Integer rxLevelNormal = 0;
	private Double ebnoTop;
	private Integer ebnoOver = 0;
	private Integer ebnoNormal = 0;
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	private Calendar statDate;

	@Column(name = "STATUS_STANDARD")
	public String getStatusStandard() {
		return statusStandard;
	}

	public void setStatusStandard(String statusStandard) {
		this.statusStandard = statusStandard;
	}

	@Column(name = "STATUS_OVER")
	public Integer getStatusOver() {
		return statusOver;
	}

	public void setStatusOver(Integer statusOver) {
		this.statusOver = statusOver;
	}

	@Column(name = "RXLEVEL_OVER")
	public Integer getRxLevelOver() {
		return rxLevelOver;
	}

	public void setRxLevelOver(Integer rxLevelOver) {
		this.rxLevelOver = rxLevelOver;
	}

	@Column(name = "RXLEVEL_TOP")
	public Double getRxLevelTop() {
		return rxLevelTop;
	}

	public void setRxLevelTop(Double rxLevelTop) {
		this.rxLevelTop = rxLevelTop;
	}

	@Column(name = "RXLEVEL_LOW")
	public Double getRxLevelLow() {
		return rxLevelLow;
	}

	public void setRxLevelLow(Double rxLevelLow) {
		this.rxLevelLow = rxLevelLow;
	}

	@Column(name = "EBNO_TOP")
	public Double getEbnoTop() {
		return ebnoTop;
	}

	public void setEbnoTop(Double ebnoTop) {
		this.ebnoTop = ebnoTop;
	}

	@Column(name = "EBNO_OVER")
	public Integer getEbnoOver() {
		return ebnoOver;
	}

	public void setEbnoOver(Integer ebnoOver) {
		this.ebnoOver = ebnoOver;
	}

	@Column(name = "STAT_DATE", columnDefinition = "date")
	public Calendar getStatDate() {
		return statDate;
	}

	public void setStatDate(Calendar statDate) {
		this.statDate = statDate;
	}

	@Column(name = "STATUS_NORMAL")
	public Integer getStatusNormal() {
		return statusNormal;
	}

	public void setStatusNormal(Integer statusNormal) {
		this.statusNormal = statusNormal;
	}

	@Column(name = "RXLEVEL_NORMAL")
	public Integer getRxLevelNormal() {
		return rxLevelNormal;
	}

	public void setRxLevelNormal(Integer rxLevelNormal) {
		this.rxLevelNormal = rxLevelNormal;
	}

	@Column(name = "EBNO_NORMAL")
	public Integer getEbnoNormal() {
		return ebnoNormal;
	}

	public void setEbnoNormal(Integer ebnoNormal) {
		this.ebnoNormal = ebnoNormal;
	}

}
