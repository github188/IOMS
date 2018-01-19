package cn.com.atnc.ioms.model.duty.statellite.day.tes;

import java.util.List;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.enums.duty.satellite.TxjdMainResult;
import cn.com.atnc.ioms.enums.duty.satellite.TxjdSynEquip;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteStatus;

/**
 * 卫星日检tes基础数据model
 *
 * @author 段衍林
 * @2017年2月16日 下午1:04:03
 */
public class TesBaseDataModel extends BaseModel {

	/** 通信基地-TES-TES 网管数据库状态 /十里河-PES-PES 网管数据状态 */
	private SatelliteStatus dataState; // 网管系统在线数据库为擦caac081

	/** 通讯基地-TES-TES 网管进程状态 */
	private SatelliteStatus PROCESS_STATE081; // 网管工作站进程081
	private SatelliteStatus PROCESS_STATE281; // 网管工作站进程281
	private SatelliteStatus PROCESS_STATE381; // 网管工作站进程381
	private SatelliteStatus PROCESS_STATE481; // 网管工作站进程481

	/** 通讯基地-TES-TES网管工作站连通性 */
	private String packetLoss081; // 081丢包率
	private String packetLoss281; // 281丢包率
	private String packetLoss381; // 381丢包率
	private String packetLoss481; // 481丢包率

	/** 通信基地-TES—DecServer 连通性 */
	private SatelliteStatus decServerCon08A; // DECServer工作状态连通性08A
	private SatelliteStatus decServerCon08B; // DECServer工作状态连通性08B
	private SatelliteStatus decServerCon08C; // DECServer工作状态连通性08C

	/** 通讯基地-TES-查看网管同步状态 */
	private List<Long> serial;// 序号
	private List<TxjdSynEquip> equipName;// 巡检设备类别
	private List<String> cu;// CU
	private List<String> ckt;// CKT
	private List<String> hg;// HG
	private List<String> dd;// DD
	private List<String> route;// ROUTER
	/** 通信基地-TES-TES网管工作站主备状态 */
	private TxjdMainResult tes081; // TES081
	private TxjdMainResult tes281; // TES281
	private TxjdMainResult tes381; // TES381
	private TxjdMainResult tes481; // TES481

	public TxjdMainResult getTes081() {
		return tes081;
	}

	public void setTes081(TxjdMainResult tes081) {
		this.tes081 = tes081;
	}

	public TxjdMainResult getTes281() {
		return tes281;
	}

	public void setTes281(TxjdMainResult tes281) {
		this.tes281 = tes281;
	}

	public TxjdMainResult getTes381() {
		return tes381;
	}

	public void setTes381(TxjdMainResult tes381) {
		this.tes381 = tes381;
	}

	public TxjdMainResult getTes481() {
		return tes481;
	}

	public void setTes481(TxjdMainResult tes481) {
		this.tes481 = tes481;
	}

	public SatelliteStatus getDataState() {
		return dataState;
	}

	public void setDataState(SatelliteStatus dataState) {
		this.dataState = dataState;
	}

	public SatelliteStatus getPROCESS_STATE081() {
		return PROCESS_STATE081;
	}

	public void setPROCESS_STATE081(SatelliteStatus pROCESS_STATE081) {
		PROCESS_STATE081 = pROCESS_STATE081;
	}

	public SatelliteStatus getPROCESS_STATE281() {
		return PROCESS_STATE281;
	}

	public void setPROCESS_STATE281(SatelliteStatus pROCESS_STATE281) {
		PROCESS_STATE281 = pROCESS_STATE281;
	}

	public SatelliteStatus getPROCESS_STATE381() {
		return PROCESS_STATE381;
	}

	public void setPROCESS_STATE381(SatelliteStatus pROCESS_STATE381) {
		PROCESS_STATE381 = pROCESS_STATE381;
	}

	public SatelliteStatus getPROCESS_STATE481() {
		return PROCESS_STATE481;
	}

	public void setPROCESS_STATE481(SatelliteStatus pROCESS_STATE481) {
		PROCESS_STATE481 = pROCESS_STATE481;
	}

	public String getPacketLoss081() {
		return packetLoss081;
	}

	public void setPacketLoss081(String packetLoss081) {
		this.packetLoss081 = packetLoss081;
	}

	public String getPacketLoss281() {
		return packetLoss281;
	}

	public void setPacketLoss281(String packetLoss281) {
		this.packetLoss281 = packetLoss281;
	}

	public String getPacketLoss381() {
		return packetLoss381;
	}

	public void setPacketLoss381(String packetLoss381) {
		this.packetLoss381 = packetLoss381;
	}

	public String getPacketLoss481() {
		return packetLoss481;
	}

	public void setPacketLoss481(String packetLoss481) {
		this.packetLoss481 = packetLoss481;
	}

	public SatelliteStatus getDecServerCon08A() {
		return decServerCon08A;
	}

	public void setDecServerCon08A(SatelliteStatus decServerCon08A) {
		this.decServerCon08A = decServerCon08A;
	}

	public SatelliteStatus getDecServerCon08B() {
		return decServerCon08B;
	}

	public void setDecServerCon08B(SatelliteStatus decServerCon08B) {
		this.decServerCon08B = decServerCon08B;
	}

	public SatelliteStatus getDecServerCon08C() {
		return decServerCon08C;
	}

	public void setDecServerCon08C(SatelliteStatus decServerCon08C) {
		this.decServerCon08C = decServerCon08C;
	}

	public List<Long> getSerial() {
		return serial;
	}

	public void setSerial(List<Long> serial) {
		this.serial = serial;
	}

	public List<TxjdSynEquip> getEquipName() {
		return equipName;
	}

	public void setEquipName(List<TxjdSynEquip> equipName) {
		this.equipName = equipName;
	}

	public List<String> getCu() {
		return cu;
	}

	public void setCu(List<String> cu) {
		this.cu = cu;
	}

	public List<String> getCkt() {
		return ckt;
	}

	public void setCkt(List<String> ckt) {
		this.ckt = ckt;
	}

	public List<String> getHg() {
		return hg;
	}

	public void setHg(List<String> hg) {
		this.hg = hg;
	}

	public List<String> getDd() {
		return dd;
	}

	public void setDd(List<String> dd) {
		this.dd = dd;
	}

	public List<String> getRoute() {
		return route;
	}

	public void setRoute(List<String> route) {
		this.route = route;
	}
}
