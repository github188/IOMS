/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-16 下午8:03:15
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.ku;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * @author:HuangYijie
 * @date:2014-4-16 下午8:03:15
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_KU_STATUS")
public class KuNodeStatus extends StringUUIDEntity {

	private static final long serialVersionUID = -743885007810798911L;
	private String status;
	private Calendar statusTime;
	private BigDecimal rxLevel;
	private Calendar rxLevelTime;
	private BigDecimal ebno;
	private Calendar ebnoTime;
	private Integer kuNodeNo;
	private KuNode kuNode;
	private KuNodeStatusStat kuNodeStatusStat;
	private Integer UP;
	private Integer DOWN;

	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "KU_NODE_NO")
	public Integer getKuNodeNo() {
		return kuNodeNo;
	}

	public void setKuNodeNo(Integer kuNodeNo) {
		this.kuNodeNo = kuNodeNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "STATUS_TIME")
	public Calendar getStatusTime() {
		return statusTime;
	}

	public void setStatusTime(Calendar statusTime) {
		this.statusTime = statusTime;
	}

	@Column(name = "RXLEVEL")
	public BigDecimal getRxLevel() {
		return rxLevel;
	}

	public void setRxLevel(BigDecimal rxLevel) {
		this.rxLevel = rxLevel;
	}

	@Column(name = "RXLEVEL_TIME")
	public Calendar getRxLevelTime() {
		return rxLevelTime;
	}

	public void setRxLevelTime(Calendar rxLevelTime) {
		this.rxLevelTime = rxLevelTime;
	}

	@Column(name = "EBNO")
	public BigDecimal getEbno() {
		return ebno;
	}

	public void setEbno(BigDecimal ebno) {
		this.ebno = ebno;
	}

	@Column(name = "EBNO_TIME")
	public Calendar getEbnoTime() {
		return ebnoTime;
	}

	public void setEbnoTime(Calendar ebnoTime) {
		this.ebnoTime = ebnoTime;
	}

	@ManyToOne
	@JoinColumn(name = "KU_NODE_ID")
	public KuNode getKuNode() {
		return kuNode;
	}

	public void setKuNode(KuNode kuNode) {
		this.kuNode = kuNode;
	}

	@ManyToOne
	@JoinColumn(name = "KU_STAT_ID")
	public KuNodeStatusStat getKuNodeStatusStat() {
		return kuNodeStatusStat;
	}

	public void setKuNodeStatusStat(KuNodeStatusStat kuNodeStatusStat) {
		this.kuNodeStatusStat = kuNodeStatusStat;
	}
	@Column(name = "UP")
	public Integer getUP() {
		return UP;
	}

	public void setUP(Integer uP) {
		UP = uP;
	}
	@Column(name = "DOWN")
	public Integer getDOWN() {
		return DOWN;
	}

	public void setDOWN(Integer dOWN) {
		DOWN = dOWN;
	}
}
