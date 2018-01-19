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
 * dspport信息实体类MPSMFR
 * 
 * @author wangpeng
 * @date:2014-6-6 下午01:14:48
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_PORT_MPSM_FR")
public class PortMPSMFR extends MyStringUUIDEntity {

	/*****************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -3636005091486288203L;
	private Ports port;
	private String IF_NUM;
	private String LINE_NUM;
	private String DS0_SPEED;
	private String DS0_CONFIG_BITMAP;
	private String OPER_STATE;
	private String ADMIN_STATE;
	private String PORT_SIGNAL_STATE;
	private String SCT_ID;
	private String IF_TYPE;
	private String FRAME_HEADER_LENGTH;
	private String FLAGS_BETWEEN_FRAMES;
	private String EQUEUE_SERVICE_RATIO;
	private String PORT_SPEED;
	private String CHECKSUM_TYPE;
	private String OVER_SUBSCRIPTION;
	private String SIGNAL_PROTOCOL_TYPE;
	private String ENHANCED_LMI;
	private String FRF_SUPPORT;
	private String PORT_STATE;
	private String ASYN_UPDATE;
	private String T391_LINK_TIMER;
	private String T392_POLL_TIMER;
	private String N391_FULL_STATUS;
	private String N392_ERROR_THRESHOLD;
	private String N393_MONI_COUNT;
	private String FRF_FRAGMENT;
	private String FRF_FRAGMENT_SIZE;
	private String PORT_HDLC;
	private String NUM_PARTITION;
	private String NUM_SPVC;
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

	public String getDS0_SPEED() {
		return DS0_SPEED;
	}

	public void setDS0_SPEED(String dS0_SPEED) {
		DS0_SPEED = dS0_SPEED;
	}

	public String getDS0_CONFIG_BITMAP() {
		return DS0_CONFIG_BITMAP;
	}

	public void setDS0_CONFIG_BITMAP(String dS0_CONFIG_BITMAP) {
		DS0_CONFIG_BITMAP = dS0_CONFIG_BITMAP;
	}

	public String getOPER_STATE() {
		return OPER_STATE;
	}

	public void setOPER_STATE(String oPER_STATE) {
		OPER_STATE = oPER_STATE;
	}

	public String getADMIN_STATE() {
		return ADMIN_STATE;
	}

	public void setADMIN_STATE(String aDMIN_STATE) {
		ADMIN_STATE = aDMIN_STATE;
	}

	public String getPORT_SIGNAL_STATE() {
		return PORT_SIGNAL_STATE;
	}

	public void setPORT_SIGNAL_STATE(String pORT_SIGNAL_STATE) {
		PORT_SIGNAL_STATE = pORT_SIGNAL_STATE;
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

	public String getFRAME_HEADER_LENGTH() {
		return FRAME_HEADER_LENGTH;
	}

	public void setFRAME_HEADER_LENGTH(String fRAME_HEADER_LENGTH) {
		FRAME_HEADER_LENGTH = fRAME_HEADER_LENGTH;
	}

	public String getFLAGS_BETWEEN_FRAMES() {
		return FLAGS_BETWEEN_FRAMES;
	}

	public void setFLAGS_BETWEEN_FRAMES(String fLAGS_BETWEEN_FRAMES) {
		FLAGS_BETWEEN_FRAMES = fLAGS_BETWEEN_FRAMES;
	}

	public String getEQUEUE_SERVICE_RATIO() {
		return EQUEUE_SERVICE_RATIO;
	}

	public void setEQUEUE_SERVICE_RATIO(String eQUEUE_SERVICE_RATIO) {
		EQUEUE_SERVICE_RATIO = eQUEUE_SERVICE_RATIO;
	}

	public String getPORT_SPEED() {
		return PORT_SPEED;
	}

	public void setPORT_SPEED(String pORT_SPEED) {
		PORT_SPEED = pORT_SPEED;
	}

	public String getCHECKSUM_TYPE() {
		return CHECKSUM_TYPE;
	}

	public void setCHECKSUM_TYPE(String cHECKSUM_TYPE) {
		CHECKSUM_TYPE = cHECKSUM_TYPE;
	}

	public String getOVER_SUBSCRIPTION() {
		return OVER_SUBSCRIPTION;
	}

	public void setOVER_SUBSCRIPTION(String oVER_SUBSCRIPTION) {
		OVER_SUBSCRIPTION = oVER_SUBSCRIPTION;
	}

	public String getSIGNAL_PROTOCOL_TYPE() {
		return SIGNAL_PROTOCOL_TYPE;
	}

	public void setSIGNAL_PROTOCOL_TYPE(String sIGNAL_PROTOCOL_TYPE) {
		SIGNAL_PROTOCOL_TYPE = sIGNAL_PROTOCOL_TYPE;
	}

	public String getENHANCED_LMI() {
		return ENHANCED_LMI;
	}

	public void setENHANCED_LMI(String eNHANCED_LMI) {
		ENHANCED_LMI = eNHANCED_LMI;
	}

	public String getFRF_SUPPORT() {
		return FRF_SUPPORT;
	}

	public void setFRF_SUPPORT(String fRF_SUPPORT) {
		FRF_SUPPORT = fRF_SUPPORT;
	}

	public String getPORT_STATE() {
		return PORT_STATE;
	}

	public void setPORT_STATE(String pORT_STATE) {
		PORT_STATE = pORT_STATE;
	}

	public String getASYN_UPDATE() {
		return ASYN_UPDATE;
	}

	public void setASYN_UPDATE(String aSYN_UPDATE) {
		ASYN_UPDATE = aSYN_UPDATE;
	}

	public String getT391_LINK_TIMER() {
		return T391_LINK_TIMER;
	}

	public void setT391_LINK_TIMER(String t391_LINK_TIMER) {
		T391_LINK_TIMER = t391_LINK_TIMER;
	}

	public String getT392_POLL_TIMER() {
		return T392_POLL_TIMER;
	}

	public void setT392_POLL_TIMER(String t392_POLL_TIMER) {
		T392_POLL_TIMER = t392_POLL_TIMER;
	}

	public String getN391_FULL_STATUS() {
		return N391_FULL_STATUS;
	}

	public void setN391_FULL_STATUS(String n391_FULL_STATUS) {
		N391_FULL_STATUS = n391_FULL_STATUS;
	}

	public String getN392_ERROR_THRESHOLD() {
		return N392_ERROR_THRESHOLD;
	}

	public void setN392_ERROR_THRESHOLD(String n392_ERROR_THRESHOLD) {
		N392_ERROR_THRESHOLD = n392_ERROR_THRESHOLD;
	}

	public String getN393_MONI_COUNT() {
		return N393_MONI_COUNT;
	}

	public void setN393_MONI_COUNT(String n393_MONI_COUNT) {
		N393_MONI_COUNT = n393_MONI_COUNT;
	}

	public String getFRF_FRAGMENT() {
		return FRF_FRAGMENT;
	}

	public void setFRF_FRAGMENT(String fRF_FRAGMENT) {
		FRF_FRAGMENT = fRF_FRAGMENT;
	}

	public String getFRF_FRAGMENT_SIZE() {
		return FRF_FRAGMENT_SIZE;
	}

	public void setFRF_FRAGMENT_SIZE(String fRF_FRAGMENT_SIZE) {
		FRF_FRAGMENT_SIZE = fRF_FRAGMENT_SIZE;
	}

	public String getPORT_HDLC() {
		return PORT_HDLC;
	}

	public void setPORT_HDLC(String pORT_HDLC) {
		PORT_HDLC = pORT_HDLC;
	}

	public String getNUM_PARTITION() {
		return NUM_PARTITION;
	}

	public void setNUM_PARTITION(String nUM_PARTITION) {
		NUM_PARTITION = nUM_PARTITION;
	}

	public String getNUM_SPVC() {
		return NUM_SPVC;
	}

	public void setNUM_SPVC(String nUM_SPVC) {
		NUM_SPVC = nUM_SPVC;
	}

	@Column(name = "RECORDTIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}
}
