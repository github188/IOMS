package cn.com.atnc.ioms.entity.faultmng;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 故障单种类子级管理
 * 
 * @author duanyanlin 2016年6月17日 下午2:07:41
 */
@Entity
@Table(name = "TB_FM_FAULT_TYPE_SON_MNG")
public class FaultTypeSon extends MyStringUUIDEntity {
	private static final long serialVersionUID = -6739376065386900888L;
	private String typeInfo;
	private FaultTypeParent parentId;
	private String creater;
	private Date createTime;
	private String updater;
	private Date updateTime;

	@Column(name = "TYPE_INFO")
	public String getTypeInfo() {
		return this.typeInfo;
	}

	public void setTypeInfo(String typeInfo) {
		this.typeInfo = typeInfo;
	}

	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	public FaultTypeParent getParentId() {
		return this.parentId;
	}

	public void setParentId(FaultTypeParent parentId) {
		this.parentId = parentId;
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

	@Column(name = "UPDATER")
	public String getUpdater() {
		return this.updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}