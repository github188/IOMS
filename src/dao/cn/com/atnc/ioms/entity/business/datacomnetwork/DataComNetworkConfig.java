/**
 * @ProjectName IOMS
 * @FileName FormalCircuitATMConfig.java
 * @PackageName:cn.com.atnc.ioms.entity.business.formalcircuit
 * @author WangLingbin
 * @date 2015年7月30日上午10:35:38
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.entity.business.datacomnetwork;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 * 数据通信网配置表
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午1:24:02
 * @since 1.0.0
 */
@Entity
@Table(name = "TB_OM_APPLY_DATACOMNETWORK_CON")
public class DataComNetworkConfig extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String operateUser; // 操作人员
	private Calendar operateTime; // 配置时间
	private String placeATM; // ATM地址/广域网地址
	private String placeATMO; // ATMO地址/Loopback地址
	private Boolean connectivity; //连通性
	private Boolean nodemng; //节点管理
	private String remark; 	// 入网意见
	private String atncLeader;		//领导

	public DataComNetworkConfig() {
		super();
	}

	public DataComNetworkConfig(String atncLeader) {
		super();
		this.atncLeader = atncLeader;
	}

	public DataComNetworkConfig(String operateUser,Calendar operateTime,
			String placeATM,String placeATMO,String remark,
			Boolean connectivity,Boolean nodemng,
			String atncLeader) {
		super();
		this.atncLeader = atncLeader;
		this.operateUser = operateUser;
		this.operateTime = operateTime;
		this.placeATM = placeATM;
		this.placeATMO = placeATMO;
		this.remark = remark;
		this.connectivity = connectivity;
		this.nodemng = nodemng;
	}

	@Column(name = "atnc_leader")
	public String getAtncLeader() {
		return atncLeader;
	}
	public void setAtncLeader(String atncLeader) {
		this.atncLeader = atncLeader;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "operate_time")
	public Calendar getOperateTime() {
		return operateTime;
	}
	
	public void setOperateTime(Calendar operateTime) {
		this.operateTime = operateTime;
	}
	
	@Column(name = "operate_user")
	public String getOperateUser() {
		return operateUser;
	}
	
	public void setOperateUser(String operateUser) {
		this.operateUser = operateUser;
	}

	@Column(name = "place_atm")
	public String getPlaceATM() {
		return placeATM;
	}

	public void setPlaceATM(String placeATM) {
		this.placeATM = placeATM;
	}

	@Column(name = "place_atmo")
	public String getPlaceATMO() {
		return placeATMO;
	}

	public void setPlaceATMO(String placeATMO) {
		this.placeATMO = placeATMO;
	}

	@Column(name = "connectivity")
	public Boolean getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(Boolean connectivity) {
		this.connectivity = connectivity;
	}

	@Column(name = "nodemng")
	public Boolean getNodemng() {
		return nodemng;
	}

	public void setNodemng(Boolean nodemng) {
		this.nodemng = nodemng;
	}

	@Column(name = "remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
