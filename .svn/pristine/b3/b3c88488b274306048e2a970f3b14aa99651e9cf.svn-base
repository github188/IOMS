package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;

/**
 * 维护总结
 * 
 * @author shijiyong
 * @date 2016年11月8日 下午1:53:06
 * @version 1.0, 2016年11月8日 下午1:53:06
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_WH")
public class Wh extends MyStringUUIDEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String result;
	private String opinion;
	private EnvironmentEquipCheck checkid;
	
	
	@Column(name = "result")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	@Column(name = "opinion")
	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@ManyToOne
	@JoinColumn(name = "checkid")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}
	
	

}































