package cn.com.atnc.ioms.entity.faultmng;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.faultmng.FaultBureau;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * 故障区域管理
 * @author duanyanlin 
 * 2016年6月17日 下午2:06:24
 */
@Entity
@Table(name = "TB_FM_AREA_MNG")
public class FaultArea extends MyStringUUIDEntity {
	private static final long serialVersionUID = -6739376065386900888L;
	private String areaInfo;			//故障区域信息
	private String fourCode;			//四字码
	private String threeCode;			//三字码
	private String kuCode;				//ku节点码
	private FaultBureau parentArea;		//区域所属大区
	private String creater;				//创建人
	private Date createTime;			//创建时间
	private String operator;			//操作人
	private Date operatTime;			//操作时间

	@Column(name = "FOUR_CODE")
	public String getFourCode() {
		return fourCode;
	}

	public void setFourCode(String fourCode) {
		this.fourCode = fourCode;
	}

	@Column(name = "THREE_CODE")
	public String getThreeCode() {
		return threeCode;
	}

	public void setThreeCode(String threeCode) {
		this.threeCode = threeCode;
	}

	@Column(name = "KU_CODE")
	public String getKuCode() {
		return kuCode;
	}

	public void setKuCode(String kuCode) {
		this.kuCode = kuCode;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PARENT_AREA")
	public FaultBureau getParentArea() {
		return parentArea;
	}

	public void setParentArea(FaultBureau parentArea) {
		this.parentArea = parentArea;
	}

	@Column(name = "AREA_INFO")
	public String getAreaInfo() {
		return this.areaInfo;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	@Column(name = "CREATER")
	public String getCreater() {
		return this.creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	@Column(name = "CREATE_TIME")
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "OPERATOR")
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "OPERAT_TIME")
	public Date getOperatTime() {
		return this.operatTime;
	}

	public void setOperatTime(Date operatTime) {
		this.operatTime = operatTime;
	}
}