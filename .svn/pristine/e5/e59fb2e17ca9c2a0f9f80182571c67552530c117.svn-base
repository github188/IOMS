package cn.com.atnc.ioms.entity.techsupport.fault;
import cn.com.atnc.ioms.entity.acl.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
/**
 * TODO：故障申报协助解决关系表
 * @author KuYonggang
 * @date 2014-4-3下午2:09:48
 * @version 1.0
 */
@Entity
@Table(name="TB_OM_FAULT_DECLARE_ASSIST")
public class FaultDeclareAssist extends StringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7052788406203463364L;
	
	private FaultDeclareOptLog optLogId;//故障申报记录ID
	private User userId;
	
	@OneToOne
	@JoinColumn(name="OPTLOG_ID")
	public FaultDeclareOptLog getOptLogId() {
		return optLogId;
	}
	public void setOptLogId(FaultDeclareOptLog optLogId) {
		this.optLogId = optLogId;
	}
	
	@ManyToOne
	@JoinColumn(name="ASSIST_USER")
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
