package cn.com.atnc.ioms.entity.duty.satelliteauto.day;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteStatus;

/**
 * 通信基地-境外站-主站华为路由器 实体
 *
 * @author 段衍林
 * @2016年11月11日 下午4:25:58
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_ABROAD_HUAWEI")
public class SatTxjdOverseaHW extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String cpuResult; // cpu利用率结果
	private SatelliteStatus cpuState; // cpu利用率状态
	private SatelliteStatus jdmdPortResult; // 加德满都端口状态结果(up/down)
	private SatelliteStatus jdmdPortState; // 加德满都端口状态(ok/failed)
	private SatelliteStatus ygPortResult; // 仰光端口状态结果(up/down)
	private SatelliteStatus ygPortState; // 仰光端口状态(ok/failed)
	private SatelliteStatus nbePortResult; // 尼泊尔端口状态结果(up/down)
	private SatelliteStatus nbePortState; // 尼泊尔端口状态(ok/failed)
	private SatelliteStatus ygResult; // 仰光结果(up/down)
	private SatelliteStatus ygState; // 仰光状态(ok/failed)
	private String jdmdAddrResult; // 加德满都地址结果
	private SatelliteStatus jdmdAddrState; // 加德满都地址状态
	private String ygAddrResult; // 仰光地址结果
	private SatelliteStatus ygAddrState; // 仰光地址状态
	private String kmAddrResult; // 昆明地址结果
	private SatelliteStatus kmAddrState; // 昆明地址状态
	private String laAddrResult; // 拉萨地址结果
	private SatelliteStatus laAddrState; // 拉萨地址状态

	private Date checkTime; // 记录时间
	private Date updateTime; // 记录时间
	private User operator; // 操作人
	private SatelliteDayAutoType equipName; // 设备名称

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "CPU_RESULT")
	public String getCpuResult() {
		return cpuResult;
	}

	public void setCpuResult(String cpuResult) {
		this.cpuResult = cpuResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "CPU_STATE")
	public SatelliteStatus getCpuState() {
		return cpuState;
	}

	public void setCpuState(SatelliteStatus cpuState) {
		this.cpuState = cpuState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "JDMD_PORT_RESULT")
	public SatelliteStatus getJdmdPortResult() {
		return jdmdPortResult;
	}

	public void setJdmdPortResult(SatelliteStatus jdmdPortResult) {
		this.jdmdPortResult = jdmdPortResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "JDMD_PORT_STATE")
	public SatelliteStatus getJdmdPortState() {
		return jdmdPortState;
	}

	public void setJdmdPortState(SatelliteStatus jdmdPortState) {
		this.jdmdPortState = jdmdPortState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "YG_PORT_RESULT")
	public SatelliteStatus getYgPortResult() {
		return ygPortResult;
	}

	public void setYgPortResult(SatelliteStatus ygPortResult) {
		this.ygPortResult = ygPortResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "YG_PORT_STATE")
	public SatelliteStatus getYgPortState() {
		return ygPortState;
	}

	public void setYgPortState(SatelliteStatus ygPortState) {
		this.ygPortState = ygPortState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "NBE_RESULT")
	public SatelliteStatus getNbePortResult() {
		return nbePortResult;
	}

	public void setNbePortResult(SatelliteStatus nbePortResult) {
		this.nbePortResult = nbePortResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "NBE_STATE")
	public SatelliteStatus getNbePortState() {
		return nbePortState;
	}

	public void setNbePortState(SatelliteStatus nbePortState) {
		this.nbePortState = nbePortState;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "YG_RESULT")
	public SatelliteStatus getYgResult() {
		return ygResult;
	}

	public void setYgResult(SatelliteStatus ygResult) {
		this.ygResult = ygResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "YG_STATE")
	public SatelliteStatus getYgState() {
		return ygState;
	}

	public void setYgState(SatelliteStatus ygState) {
		this.ygState = ygState;
	}

	@Column(name = "JDMD_ADDR_RESULT")
	public String getJdmdAddrResult() {
		return jdmdAddrResult;
	}

	public void setJdmdAddrResult(String jdmdAddrResult) {
		this.jdmdAddrResult = jdmdAddrResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "JDMD_ADDR_STATE")
	public SatelliteStatus getJdmdAddrState() {
		return jdmdAddrState;
	}

	public void setJdmdAddrState(SatelliteStatus jdmdAddrState) {
		this.jdmdAddrState = jdmdAddrState;
	}

	@Column(name = "YG_ADDR__RESULT")
	public String getYgAddrResult() {
		return ygAddrResult;
	}

	public void setYgAddrResult(String ygAddrResult) {
		this.ygAddrResult = ygAddrResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "YG_ADDR_STATE")
	public SatelliteStatus getYgAddrState() {
		return ygAddrState;
	}

	public void setYgAddrState(SatelliteStatus ygAddrState) {
		this.ygAddrState = ygAddrState;
	}

	@Column(name = "KM_ADDR_RESULT")
	public String getKmAddrResult() {
		return kmAddrResult;
	}

	public void setKmAddrResult(String kmAddrResult) {
		this.kmAddrResult = kmAddrResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "KM_ADDR_STATE")
	public SatelliteStatus getKmAddrState() {
		return kmAddrState;
	}

	public void setKmAddrState(SatelliteStatus kmAddrState) {
		this.kmAddrState = kmAddrState;
	}

	@Column(name = "LA_ADDR_RESULT")
	public String getLaAddrResult() {
		return laAddrResult;
	}

	public void setLaAddrResult(String laAddrResult) {
		this.laAddrResult = laAddrResult;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "LA_ADDR_STATE")
	public SatelliteStatus getLaAddrState() {
		return laAddrState;
	}

	public void setLaAddrState(SatelliteStatus laAddrState) {
		this.laAddrState = laAddrState;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "RECORD_TIME")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@ManyToOne
	@JoinColumn(name = "OPERATOR")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "EQUIP_NAME")
	public SatelliteDayAutoType getEquipName() {
		return equipName;
	}

	public void setEquipName(SatelliteDayAutoType equipName) {
		this.equipName = equipName;
	}
}
