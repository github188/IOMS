/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:34:46
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.tes;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;

@Entity
@Table(name = "TB_BD_TES_SLOT")
public class TesSlot extends MyStringUUIDEntity {
	private static final long serialVersionUID = -4636035371499706701L;
	private TesNode tesNode;	
	private String cu;// 编号
	private Integer occ;//槽位控制值道
	private String info;//备注信息	
	private String tesNodeId;//TES节点ID	
	private Calendar optTime;// 操作时间
	
	@Column(name = "OPT_TIME")
	public Calendar getOptTime() {
		if (optTime == null) {
			return Calendar.getInstance();
		}
		return optTime;
	}

	@ManyToOne
	@JoinColumn(name = "OPT_USER")
	public User getOptUser() {
		return optUser;
	}

	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}

	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}



	private User optUser;// 操作用户
	
	@ManyToOne
	@JoinColumn(name = "TES_NODE_ID")
	public TesNode getTesNode() {
		return tesNode;
	}
	
	@Column(name = "CU")
	public String getCu() {
		return cu;
	}

	
	@Column(name = "OCC")
	public Integer getOcc() {
		return occ;
	}
	
	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}
	
	@Transient
	public String getTesNodeId() {
		return tesNodeId;
	}
	public void setTesNode(TesNode tesNode) {
		this.tesNode = tesNode;
	}
	
	public void setOcc(Integer occ) {
		this.occ = occ;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setTesNodeId(String tesNodeId) {
		this.tesNodeId = tesNodeId;
	}
	
	

	public void setCu(String cu) {
		this.cu = cu;
	}
		
	
}
