/* Copyright  2011 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at 2011-6-1 下午01:14:48
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.operstat.atm;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 * dspport信息实体类AXSME
 * 
 * @author wangpeng
 * @date:2014-6-6 下午01:14:48
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_PORT_AXSMXG")
public class PortAXSMXG extends MyStringUUIDEntity {

	/*****************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -3636005091486288203L;
	private Ports port;
	private String IF_NUM;
	private String LINE_NUM;
	private String ADMIN_STATE;
	private String OPER_STATE;
	private String GUARANTEED_BANDWIDTH;
	private String MAX_BANDWIDTH;
	private String SCT_ID;
	private String IF_TYPE;
	private String VPI;
	private String MIN_VPI;
	private String MAX_VPI;
	private String NUM_PARTITIONS;
	private String NUM_SPVC;
	private String NUM_SPVP;
	private String NUM_SVC;
	private String F4TOF5;
	private Calendar recordTime;// 记录时间

	@ManyToOne
	@JoinColumn(name = "TB_PORTS_ID")
	public Ports getPort() {
		return port;
	}

	public void setPort(Ports port) {
		this.port = port;
	}

	public String getIF_NUM() {
		return IF_NUM;
	}

	public void setIF_NUM(String iF_NUM) {
		IF_NUM = iF_NUM;
	}

	public String getLINE_NUM() {
		return LINE_NUM;
	}

	public void setLINE_NUM(String lINE_NUM) {
		LINE_NUM = lINE_NUM;
	}

	public String getADMIN_STATE() {
		return ADMIN_STATE;
	}

	public void setADMIN_STATE(String aDMIN_STATE) {
		ADMIN_STATE = aDMIN_STATE;
	}

	public String getOPER_STATE() {
		return OPER_STATE;
	}

	public void setOPER_STATE(String oPER_STATE) {
		OPER_STATE = oPER_STATE;
	}

	public String getGUARANTEED_BANDWIDTH() {
		return GUARANTEED_BANDWIDTH;
	}

	public void setGUARANTEED_BANDWIDTH(String gUARANTEED_BANDWIDTH) {
		GUARANTEED_BANDWIDTH = gUARANTEED_BANDWIDTH;
	}

	public String getMAX_BANDWIDTH() {
		return MAX_BANDWIDTH;
	}

	public void setMAX_BANDWIDTH(String mAX_BANDWIDTH) {
		MAX_BANDWIDTH = mAX_BANDWIDTH;
	}

	public String getSCT_ID() {
		return SCT_ID;
	}

	public void setSCT_ID(String sCT_ID) {
		SCT_ID = sCT_ID;
	}

	public String getIF_TYPE() {
		return IF_TYPE;
	}

	public void setIF_TYPE(String iF_TYPE) {
		IF_TYPE = iF_TYPE;
	}

	public String getVPI() {
		return VPI;
	}

	public void setVPI(String vPI) {
		VPI = vPI;
	}

	public String getMIN_VPI() {
		return MIN_VPI;
	}

	public void setMIN_VPI(String mIN_VPI) {
		MIN_VPI = mIN_VPI;
	}

	public String getMAX_VPI() {
		return MAX_VPI;
	}

	public void setMAX_VPI(String mAX_VPI) {
		MAX_VPI = mAX_VPI;
	}

	public String getNUM_PARTITIONS() {
		return NUM_PARTITIONS;
	}

	public void setNUM_PARTITIONS(String nUM_PARTITIONS) {
		NUM_PARTITIONS = nUM_PARTITIONS;
	}

	public String getNUM_SPVC() {
		return NUM_SPVC;
	}

	public void setNUM_SPVC(String nUM_SPVC) {
		NUM_SPVC = nUM_SPVC;
	}

	public String getNUM_SPVP() {
		return NUM_SPVP;
	}

	public void setNUM_SPVP(String nUM_SPVP) {
		NUM_SPVP = nUM_SPVP;
	}

	public String getNUM_SVC() {
		return NUM_SVC;
	}

	public void setNUM_SVC(String nUM_SVC) {
		NUM_SVC = nUM_SVC;
	}

	public String getF4TOF5() {
		return F4TOF5;
	}

	public void setF4TOF5(String f4tof5) {
		F4TOF5 = f4tof5;
	}

	@Column(name = "RECORDTIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}
}
