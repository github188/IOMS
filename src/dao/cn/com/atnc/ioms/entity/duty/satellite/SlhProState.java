package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.enums.duty.environment.CheckResult;

/**   
 *    十里河-PES-PES 网管进程状态
 * @author shijiyong
 * @date 2016年10月13日 下午1:57:53
 * @version   
 *       1.0, 2016年10月13日 下午1:57:53   
 */
@Entity
@Table(name="TB_OM_DUTY_STA_SLH_PRO_STATE")
public class SlhProState extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	
	private CheckResult process;		//网管进程
	private EnvironmentEquipCheck checkid;//巡检id
	@Enumerated(EnumType.STRING)
	@Column(name="process")
	public CheckResult getProcess() {
		return process;
	}
	public void setProcess(CheckResult process) {
		this.process = process;
	}
	@ManyToOne
	@JoinColumn(name="check_id")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}
	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}
	
	
	
}
