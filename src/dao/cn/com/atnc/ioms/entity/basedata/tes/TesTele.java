package cn.com.atnc.ioms.entity.basedata.tes;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;

@Entity
@Table(name = "TB_BD_TES_TELE")
public class TesTele extends MyStringUUIDEntity {

	private static final long serialVersionUID = -4636035371499706701L;	

    private TesNode tesNode;//节点    
    private String cu;// 编号
    private String phoneNum;//电话号码
    private String info;//备注信息    
    private Calendar optTime;// 操作时间
    private User optUser;// 操作用户
    private Calendar recordTime;// 记录时间
    private String tesNodeId;//节点ID
    private transient SatelliteSite satelliteSite;
    private transient String tesNodeCode;
    private transient  List<String>  cus;// 主叫槽号	
	/*private transient String siteId;

    
	@Transient
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}*/

    @Transient
	public List<String> getCus() {
		return cus;
	}

	public void setCus(List<String> cus) {
		this.cus = cus;
	}

	@Transient
	public String getTesNodeId() {
		return tesNodeId;
	}

	public void setTesNodeId(String tesNodeId) {
		this.tesNodeId = tesNodeId;
	}	
	
	
	@ManyToOne
	@JoinColumn(name = "TES_NODE_ID")
	public TesNode getTesNode() {
		return tesNode;
	}
	
	@Column(name = "CU")
	public String getCu() {
		return cu;
	}
	
	@Column(name = "PHONENUM")
	public String getPhoneNum() {
		return phoneNum;
	}
	
	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}
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
	
	@Column(name = "RECORDTIME")
	public Calendar getRecordTime() {
		if (recordTime == null) {
			return Calendar.getInstance();
		}		
		
		return recordTime;
	}
	public void setTesNode(TesNode tesNode) {
		this.tesNode = tesNode;
	}
	public void setCu(String cu) {
		this.cu = cu;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}
	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}
	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	@Transient
	public String getTesNodeCode() {
		return tesNodeCode;
	}

	public void setTesNodeCode(String tesNodeCode) {
		this.tesNodeCode = tesNodeCode;
	}

	@Transient
	public SatelliteSite getSatelliteSite() {
		return satelliteSite;
	}

	public void setSatelliteSite(SatelliteSite satelliteSite) {
		this.satelliteSite = satelliteSite;
	}
}
