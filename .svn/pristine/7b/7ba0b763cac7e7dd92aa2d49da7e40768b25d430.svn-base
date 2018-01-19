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
 * dspport信息实体类CESM
 * 
 * @author wangpeng
 * @date:2014-6-6 下午01:14:48
 * @version 1.0
 */
@Entity
@Table(name = "TB_BD_ATM_PORT_CESM")
public class PortCESM extends MyStringUUIDEntity {

	/*****************************************************
	 * serialVersionUID:
	 */
	private static final long serialVersionUID = -3636005091486288203L;
	private Ports port;
	private String SLOT_NUM;
	private String LINE_NUM;
	private String PORT_ROW_STATE;
	private String PORT_NUM_SLOTS;
	private String PORT_DS0_CONFIG_BITMAP;
	private String PORT_SPEED;
	private String PORT_TYPE;
	private String PORT_STATE;
	private String PORT_NUM;
	private Calendar recordTime;// 记录时间

	@ManyToOne
	@JoinColumn(name = "TB_PORTS_ID")
	public Ports getPort() {
		return port;
	}

	public void setPort(Ports port) {
		this.port = port;
	}

	public String getSLOT_NUM() {
		return SLOT_NUM;
	}

	public void setSLOT_NUM(String sLOT_NUM) {
		SLOT_NUM = sLOT_NUM;
	}

	public String getLINE_NUM() {
		return LINE_NUM;
	}

	public void setLINE_NUM(String lINE_NUM) {
		LINE_NUM = lINE_NUM;
	}

	public String getPORT_ROW_STATE() {
		return PORT_ROW_STATE;
	}

	public void setPORT_ROW_STATE(String pORT_ROW_STATE) {
		PORT_ROW_STATE = pORT_ROW_STATE;
	}

	public String getPORT_NUM_SLOTS() {
		return PORT_NUM_SLOTS;
	}

	public void setPORT_NUM_SLOTS(String pORT_NUM_SLOTS) {
		PORT_NUM_SLOTS = pORT_NUM_SLOTS;
	}

	public String getPORT_DS0_CONFIG_BITMAP() {
		return PORT_DS0_CONFIG_BITMAP;
	}

	public void setPORT_DS0_CONFIG_BITMAP(String pORT_DS0_CONFIG_BITMAP) {
		PORT_DS0_CONFIG_BITMAP = pORT_DS0_CONFIG_BITMAP;
	}

	public String getPORT_SPEED() {
		return PORT_SPEED;
	}

	public void setPORT_SPEED(String pORT_SPEED) {
		PORT_SPEED = pORT_SPEED;
	}

	public String getPORT_TYPE() {
		return PORT_TYPE;
	}

	public void setPORT_TYPE(String pORT_TYPE) {
		PORT_TYPE = pORT_TYPE;
	}

	public String getPORT_STATE() {
		return PORT_STATE;
	}

	public void setPORT_STATE(String pORT_STATE) {
		PORT_STATE = pORT_STATE;
	}

	public String getPORT_NUM() {
		return PORT_NUM;
	}

	public void setPORT_NUM(String pORT_NUM) {
		PORT_NUM = pORT_NUM;
	}

	@Column(name = "RECORDTIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}
}
