package cn.com.atnc.ioms.entity.phonemng;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.phonemng.AtncCallTypeEnum;
import cn.com.atnc.ioms.enums.phonemng.CallIsDel;
import cn.com.atnc.ioms.enums.phonemng.CallStateEnum;
import cn.com.atnc.ioms.enums.phonemng.CallTypeEnum;

/**
 * 
 * @author hantianyu
 *
 */
@Entity
@Table(name = "TB_TEL_CALLING_INFORMATION")
public class CallInformation extends MyStringUUIDEntity{
	private static final long serialVersionUID = -6739376065386900888L;
	private String callonNumber;//主叫号码
	private String calledNumber;//被叫号码
	private String callonCity;//主叫号码-所在城市
	private String callonProvince;//主叫号码-所在省
	private Date ringingTime;//响铃时间
	private Date pickupTime;//摘机时间
	private Date callendTime;//通话结束时间
	private double callDuration;//通话时间 精确到秒
	private String stationNumber;//坐席号 8000/8001/8002/8003
	private CallTypeEnum callType;//通话类型
	private String recordFileName;//录音文件名称
	private String fileServer;//服务器名称
	private CallStateEnum callState;//接听状态
	private String callId;//唯一标识
	private String callSheetId;//通话记录id
	private String userName;//坐席对应工程师
	private CallIsDel isDel;//是否删除标志位
	
	private transient String contactName;   //联系人姓名
	private transient String companyInfo;   //联系人所属公司信息
	private transient String contactArea;   //联系人所属区域
	
	private String spare2;//是否备份在指定文件夹
	//新增170105
	private AtncCallTypeEnum atncType;
	private String remark;
	private User optUser;//创建人
	private Date optTime;//操作时间
	

	
	
	
	
	@Enumerated(EnumType.STRING)
    @Column(name="ATNC_CALL_TYPE")
	public AtncCallTypeEnum getAtncType() {
		return atncType;
	}
	public void setAtncType(AtncCallTypeEnum atncType) {
		this.atncType = atncType;
	}
	@Column(name = "REMARK")
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@ManyToOne
	@JoinColumn(name="OPERATION_USER")
	public User getOptUser() {
		return optUser;
	}
	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}
	
	@Column(name = "OPERATION_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getOptTime() {
		return optTime;
	}
	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}
	
	@Column(name="SPARE2")
	public String getSpare2() {
		return spare2;
	}
	public void setSpare2(String spare2) {
		this.spare2 = spare2;
	}
	@Transient
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	@Transient
	public String getCompanyInfo() {
		return companyInfo;
	}
	public void setCompanyInfo(String companyInfo) {
		this.companyInfo = companyInfo;
	}
	@Transient
	public String getContactArea() {
		return contactArea;
	}
	public void setContactArea(String contactArea) {
		this.contactArea = contactArea;
	}
	@Enumerated(EnumType.STRING)
    @Column(name="ISDEL")
	public CallIsDel getIsDel() {
		return isDel;
	}
	public void setIsDel(CallIsDel isDel) {
		this.isDel = isDel;
	}
	@Column(name = "CALLER_NUMBER")
	public String getCallonNumber() {
		return callonNumber;
	}
	public void setCallonNumber(String callonNumber) {
		this.callonNumber = callonNumber;
	}
	@Column(name = "CALLED_NUMBER")
	public String getCalledNumber() {
		return calledNumber;
	}
	public void setCalledNumber(String calledNumber) {
		this.calledNumber = calledNumber;
	}
	@Column(name = "CALLER_CITY")
	public String getCallonCity() {
		return callonCity;
	}
	public void setCallonCity(String callonCity) {
		this.callonCity = callonCity;
	}
	@Column(name = "CALLER_PROVINCE")
	public String getCallonProvince() {
		return callonProvince;
	}
	public void setCallonProvince(String callonProvince) {
		this.callonProvince = callonProvince;
	}
	@Column(name = "RING_DOWN_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRingingTime() {
		return ringingTime;
	}
	public void setRingingTime(Date ringingTime) {
		this.ringingTime = ringingTime;
	}
	@Column(name = "PICK_UP_PHONE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPickupTime() {
		return pickupTime;
	}
	public void setPickupTime(Date pickupTime) {
		this.pickupTime = pickupTime;
	}
	@Column(name = "CALL_END_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCallendTime() {
		return callendTime;
	}
	public void setCallendTime(Date callendTime) {
		this.callendTime = callendTime;
	}
	@Column(name="CALL_DURATION")
	public double getCallDuration() {
		return callDuration;
	}
	public void setCallDuration(double callDuration) {
		this.callDuration = callDuration;
	}
	@Column(name="STATION_NUMBER")
	public String getStationNumber() {
		return stationNumber;
	}
	public void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}
	@Enumerated(EnumType.STRING)
    @Column(name="CALL_TYPE")
	public CallTypeEnum getCallType() {
		return callType;
	}
	public void setCallType(CallTypeEnum callType) {
		this.callType = callType;
	}
	@Column(name="RECORD_FILE_NAME")
	public String getRecordFileName() {
		return recordFileName;
	}
	public void setRecordFileName(String recordFileName) {
		this.recordFileName = recordFileName;
	}
	@Column(name="FILE_SERVER")
	public String getFileServer() {
		return fileServer;
	}
	public void setFileServer(String fileServer) {
		this.fileServer = fileServer;
	}
	@Enumerated(EnumType.STRING)
    @Column(name="CALL_STATE")
	public CallStateEnum getCallState() {
		return callState;
	}
	public void setCallState(CallStateEnum callState) {
		this.callState = callState;
	}
	@Column(name="CALL_ID")
	public String getCallId() {
		return callId;
	}
	public void setCallId(String callId) {
		this.callId = callId;
	}
	@Column(name="CALL_SHEET_ID")
	public String getCallSheetId() {
		return callSheetId;
	}
	public void setCallSheetId(String callSheetId) {
		this.callSheetId = callSheetId;
	}
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

	

	
}
