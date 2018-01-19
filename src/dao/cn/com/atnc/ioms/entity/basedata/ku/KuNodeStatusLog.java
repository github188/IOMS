/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-16 下午8:08:23
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.ku;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * @author:HuangYijie
 * @date:2014-4-16 下午8:08:23
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_KU_STATUS_LOG")
public class KuNodeStatusLog extends StringUUIDEntity {
	private static final long serialVersionUID = 5033972707650737577L;
	private String param;
	private String from;
	private String to;
	private Calendar recordTime;
	private KuNode kuNode;
	private KuNodeStatus kuStatus;
	private Integer kuNodeNo;

	@Column(name = "KU_NODE_NO")
	public Integer getKuNodeNo() {
		return kuNodeNo;
	}

	public void setKuNodeNo(Integer kuNodeNo) {
		this.kuNodeNo = kuNodeNo;
	}

	@ManyToOne
	@JoinColumn(name = "KU_STATUS_ID")
	public KuNodeStatus getKuStatus() {
		return kuStatus;
	}

	public void setKuStatus(KuNodeStatus kuStatus) {
		this.kuStatus = kuStatus;
	}

	@Column(name = "PARAM_NAME")
	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	@Column(name = "FROM_VALUE")
	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Column(name = "TO_VALUE")
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Column(name = "RECORD_TIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	@ManyToOne
	@JoinColumn(name = "KU_NODE_ID")
	public KuNode getKuNode() {
		return kuNode;
	}

	public void setKuNode(KuNode kuNode) {
		this.kuNode = kuNode;
	}

}
