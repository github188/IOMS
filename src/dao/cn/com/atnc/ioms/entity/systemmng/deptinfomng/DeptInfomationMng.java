package cn.com.atnc.ioms.entity.systemmng.deptinfomng;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.systemmng.deptinfomng.DeptTypeEnum;
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_EM_DEPT_INFORMATION")
public class DeptInfomationMng extends StringUUIDEntity{
    private String deptNumberOa;
    private String deptName;
    private User creater;
    private Date creatime;
    private User updater;
    private Date updatime;
    private String parentInfo;
    private DeptTypeEnum deptType;
    private String spare1;
    private String spare2;
    private String spare3;
    
    
    @Column(name="OA_DEPT_NUMBER")
	public String getDeptNumberOa() {
		return deptNumberOa;
	}
	public void setDeptNumberOa(String deptNumberOa) {
		this.deptNumberOa = deptNumberOa;
	}
	
	@Column(name="OA_DEPT_NAME")
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@ManyToOne
	@JoinColumn(name="CREATER")
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	@Column(name = "CREATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	@ManyToOne
	@JoinColumn(name="UPDATER")
	public User getUpdater() {
		return updater;
	}
	public void setUpdater(User updater) {
		this.updater = updater;
	}
	@Column(name = "UPDATE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	
	@Column(name="PARENT_ID")
	public String getParentInfo() {
		return parentInfo;
	}
	public void setParentInfo(String parentInfo) {
		this.parentInfo = parentInfo;
	}
	@Enumerated(EnumType.STRING)
	@Column(name="DEPT_TYPE")
	public DeptTypeEnum getDeptType() {
		return deptType;
	}
	public void setDeptType(DeptTypeEnum deptType) {
		this.deptType = deptType;
	}
	@Column(name="SPARE1")
	public String getSpare1() {
		return spare1;
	}
	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}
	@Column(name="SPARE2")
	public String getSpare2() {
		return spare2;
	}
	public void setSpare2(String spare2) {
		this.spare2 = spare2;
	}
	@Column(name="SPARE3")
	public String getSpare3() {
		return spare3;
	}
	public void setSpare3(String spare3) {
		this.spare3 = spare3;
	}
    
    
    
}
