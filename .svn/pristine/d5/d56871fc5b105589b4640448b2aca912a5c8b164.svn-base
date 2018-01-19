package cn.com.atnc.ioms.entity.duty.satelliteauto.day;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteDayAutoType;

/**
 * 通信基地-TES-TES OCC状态实体
 *
 * @author 段衍林
 * @2016年11月10日 下午1:18:30
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_KUDAY")
public class SatTxjdKuDay extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1L;

	private String odutAuct; // ODUT_A_UCT
	private String odutAdct; // ODUT_A_DCT
	private String odutAmct; // ODUT_A_MCT
	private String odutBuct; // ODUT_B_UCT
	private String odutBdct; // ODUT_B_DCT
	private String odutBmct; // ODUT_B_MCT
	private String odutAucf; // ODUT_A_UCF
	private String odutAuca; // ODUT_A_UCA
	private String odutAdcf; // ODUT_A_DCF
	private String odutAdca; // ODUT_A_DCA
	private String odutBucf; // ODUT_B_UCF
	private String odutBuca; // ODUT_B_UCA
	private String odutBdcf; // ODUT_B_DCF
	private String odutBdca; // ODUT_B_DCA
	private String net1Map; // NET1_MAP
	private String net2Map; // NET2_MAP
	private String net3Map; // NET3_MAP
	private String net4Map; // NET4_MAP
	private String netfrMap; // NETFR_MAP

	private String net10Rx0; // NET1_0_RX0
	private String net10Eb0; // NET1_0_EB0
	private String net10Rx1; // NET1_0_RX1
	private String net10Eb1; // NET1_0_EB1
	private String net10Rx130; // NET1_0_RX130
	private String net10Eb130; // NET1_0_EB130
	private String net10Peak; // NET1_0_PEAK
	private String net10Noise; // NET1_0_NOISE
	private String net1Znum; // NET1_Z_NUM
	private String net1Zweather; // NET1_Z_WEATHER
	private String net1Zstate; // NET1_Z_STATE
	private String net1Zrx; // NET1_Z_RX
	private String net1Zeb; // NET1_Z_EB
	private String net1Bnum; // NET1_B_NUM
	private String net1Bweather; // NET1_B_WEATHER
	private String net1Bstate; // NET1_B_STATE
	private String net1Brx; // NET1_B_RX
	private String net1Beb; // NET1_B_EB

	private String net20Rx0; // NET2_0_RX0
	private String net20Eb0; // NET2_0_EB0
	private String net20Rx1; // NET2_0_RX1
	private String net20Eb1; // NET2_0_EB1
	private String net20Peak; // NET2_0_PEAK
	private String net20Noise; // NET2_0_NOISE
	private String net2Znum; // NET2_Z_NUM
	private String net2Zweather; // NET2_Z_WEATHER
	private String net2Zstate; // NET2_Z_STATE
	private String net2Zrx; // NET2_Z_RX
	private String net2Zeb; // NET2_Z_EB
	private String net2Bnum; // NET2_B_NUM
	private String net2Bweather; // NET2_B_WEATHER
	private String net2Bstate; // NET2_B_STATE
	private String net2Brx; // NET2_B_RX
	private String net2Beb; // NET2_B_EB
	private String net30Rx0; // NET3_0_RX0
	private String net30Eb0; // NET3_0_EB0
	private String net30Rx1; // NET3_0_RX1
	private String net30Eb1; // NET3_0_EB1
	private String net30Peak; // NET3_0_PEAK
	private String net30Noise; // NET3_0_NOISE
	private String net3Znum; // NET3_Z_NUM
	private String net3Zweather; // NET3_Z_WEATHER
	private String net3Zstate; // NET3_Z_STATE
	private String net3Zrx; // NET3_Z_RX
	private String net3Zeb; // NET3_Z_EB
	private String net3Bnum; // NET3_B_NUM
	private String net3Bweather; // NET3_B_WEATHER
	private String net3Bstate; // NET3_B_STATE
	private String net3Brx; // NET3_B_RX
	private String net3Beb; // NET3_B_EB
	private String net40Rx0; // NET4_0_RX0
	private String net40Eb0; // NET4_0_EB0
	private String net40Rx1; // NET4_0_RX1
	private String net40Eb1; // NET4_0_EB1
	private String net40Peak; // NET4_0_PEAK
	private String net40Noise; // NET4_0_NOISE
	private String net4Znum; // NET4_Z_NUM
	private String net4Zweather; // NET4_Z_WEATHER
	private String net4Zstate; // NET4_Z_STATE
	private String net4Zrx; // NET4_Z_RX
	private String net4Zeb; // NET4_Z_EB
	private String net4Bnum; // NET4_B_NUM
	private String net4Bweather; // NET4_B_WEATHER
	private String net4Bstate; // NET4_B_STATE
	private String net4Brx; // NET4_B_RX
	private String net4Beb; // NET4_B_EB
	private String netfrPeak; // NETFR_PEAK
	private String netfrNoise; // NETFR_NOISE
	private String netfrZnum; // NETFR_Z_NUM
	private String netfrZweather; // NETFR_Z_WEATHER
	private String netfrZstate; // NETFR_Z_STATE
	private String netfrZrx; // NETFR_Z_RX
	private String netfrZeb; // NETFR_Z_EB
	private String netfrBnum; // NETFR_B_NUM
	private String netfrBweather; // NETFR_B_WEATHER
	private String netfrBstate; // NETFR_B_STATE
	private String netfrBrx; // NETFR_B_RX
	private String netfrBeb; // NETFR_B_EB

	private Date checkTime; // 记录时间
	private Date updateTime; // 更新时间
	private User operator; // 操作人
	private User updater; // 更新人
	private SatelliteDayAutoType equipName; // 设备名称

	private String odusAresult;// ODUS_A_RESULT
	private String odusBresult;// ODUS_B_RESULT
	private String net1Work; // NET1_WORK
	private String net2Work; // NET2_WORK
	private String net3Work; // NET3_WORK
	private String net4Work; // NET4_WORK
	private String netfrWork; // NETFR_WORK
	/**
	 * 冗余 前端页面展示时使用
	 */
	private transient String uctAtemp; // 温度
	private transient String dctAtemp;
	private transient String mctAtemp;
	private transient String uctBtemp; // 温度
	private transient String dctBtemp;
	private transient String mctBtemp;

	private transient String net10Rx0Show; // 峰值底噪等
	private transient String net10Eb0Show;
	private transient String net10Rx1Show;
	private transient String net10Eb1Show;
	private transient String net10Rx130Show;
	private transient String net10Eb130Show;
	private transient String net10PeakShow;
	private transient String net10NoiseShow;
	private transient String net1ZrxShow;
	private transient String net1ZebShow;
	private transient String net1BrxShow;
	private transient String net1BebShow;

	private transient String net20Rx0Show; // 峰值底噪等
	private transient String net20Eb0Show;
	private transient String net20Rx1Show;
	private transient String net20Eb1Show;
	private transient String net20PeakShow;
	private transient String net20NoiseShow;
	private transient String net2ZrxShow;
	private transient String net2ZebShow;
	private transient String net2BrxShow;
	private transient String net2BebShow;

	private transient String net30Rx0Show; // 峰值底噪等
	private transient String net30Eb0Show;
	private transient String net30Rx1Show;
	private transient String net30Eb1Show;
	private transient String net30PeakShow;
	private transient String net30NoiseShow;
	private transient String net3ZrxShow;
	private transient String net3ZebShow;
	private transient String net3BrxShow;
	private transient String net3BebShow;

	private transient String net40Rx0Show; // 峰值底噪等
	private transient String net40Eb0Show;
	private transient String net40Rx1Show;
	private transient String net40Eb1Show;
	private transient String net40PeakShow;
	private transient String net40NoiseShow;
	private transient String net4ZrxShow;
	private transient String net4ZebShow;
	private transient String net4BrxShow;
	private transient String net4BebShow;

	private transient String frPeakShow;
	private transient String frNoiseShow;
	private transient String frZrxShow;
	private transient String frZebShow;
	private transient String frBrxShow;
	private transient String frBebShow;

	@ManyToOne
	@JoinColumn(name = "UPDATER")
	public User getUpdater() {
		return updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}

	@Transient
	public String getUctAtemp() {
		return uctAtemp;
	}

	public void setUctAtemp(String uctAtemp) {
		this.uctAtemp = uctAtemp;
	}

	@Transient
	public String getDctAtemp() {
		return dctAtemp;
	}

	public void setDctAtemp(String dctAtemp) {
		this.dctAtemp = dctAtemp;
	}

	@Transient
	public String getMctAtemp() {
		return mctAtemp;
	}

	public void setMctAtemp(String mctAtemp) {
		this.mctAtemp = mctAtemp;
	}

	@Transient
	public String getUctBtemp() {
		return uctBtemp;
	}

	public void setUctBtemp(String uctBtemp) {
		this.uctBtemp = uctBtemp;
	}

	@Transient
	public String getDctBtemp() {
		return dctBtemp;
	}

	public void setDctBtemp(String dctBtemp) {
		this.dctBtemp = dctBtemp;
	}

	@Transient
	public String getMctBtemp() {
		return mctBtemp;
	}

	public void setMctBtemp(String mctBtemp) {
		this.mctBtemp = mctBtemp;
	}

	@Transient
	public String getNet10Rx0Show() {
		return net10Rx0Show;
	}

	public void setNet10Rx0Show(String net10Rx0Show) {
		this.net10Rx0Show = net10Rx0Show;
	}

	@Transient
	public String getNet10Eb0Show() {
		return net10Eb0Show;
	}

	public void setNet10Eb0Show(String net10Eb0Show) {
		this.net10Eb0Show = net10Eb0Show;
	}

	@Transient
	public String getNet10Rx1Show() {
		return net10Rx1Show;
	}

	public void setNet10Rx1Show(String net10Rx1Show) {
		this.net10Rx1Show = net10Rx1Show;
	}

	@Transient
	public String getNet10Eb1Show() {
		return net10Eb1Show;
	}

	public void setNet10Eb1Show(String net10Eb1Show) {
		this.net10Eb1Show = net10Eb1Show;
	}

	@Transient
	public String getNet10Rx130Show() {
		return net10Rx130Show;
	}

	public void setNet10Rx130Show(String net10Rx130Show) {
		this.net10Rx130Show = net10Rx130Show;
	}

	@Transient
	public String getNet10Eb130Show() {
		return net10Eb130Show;
	}

	public void setNet10Eb130Show(String net10Eb130Show) {
		this.net10Eb130Show = net10Eb130Show;
	}

	@Transient
	public String getNet10PeakShow() {
		return net10PeakShow;
	}

	public void setNet10PeakShow(String net10PeakShow) {
		this.net10PeakShow = net10PeakShow;
	}

	@Transient
	public String getNet10NoiseShow() {
		return net10NoiseShow;
	}

	public void setNet10NoiseShow(String net10NoiseShow) {
		this.net10NoiseShow = net10NoiseShow;
	}

	@Transient
	public String getNet1ZrxShow() {
		return net1ZrxShow;
	}

	public void setNet1ZrxShow(String net1ZrxShow) {
		this.net1ZrxShow = net1ZrxShow;
	}

	@Transient
	public String getNet1ZebShow() {
		return net1ZebShow;
	}

	public void setNet1ZebShow(String net1ZebShow) {
		this.net1ZebShow = net1ZebShow;
	}

	@Transient
	public String getNet1BrxShow() {
		return net1BrxShow;
	}

	public void setNet1BrxShow(String net1BrxShow) {
		this.net1BrxShow = net1BrxShow;
	}

	@Transient
	public String getNet1BebShow() {
		return net1BebShow;
	}

	public void setNet1BebShow(String net1BebShow) {
		this.net1BebShow = net1BebShow;
	}

	@Transient
	public String getNet20Rx0Show() {
		return net20Rx0Show;
	}

	public void setNet20Rx0Show(String net20Rx0Show) {
		this.net20Rx0Show = net20Rx0Show;
	}

	@Transient
	public String getNet20Eb0Show() {
		return net20Eb0Show;
	}

	public void setNet20Eb0Show(String net20Eb0Show) {
		this.net20Eb0Show = net20Eb0Show;
	}

	@Transient
	public String getNet20Rx1Show() {
		return net20Rx1Show;
	}

	public void setNet20Rx1Show(String net20Rx1Show) {
		this.net20Rx1Show = net20Rx1Show;
	}

	@Transient
	public String getNet20Eb1Show() {
		return net20Eb1Show;
	}

	public void setNet20Eb1Show(String net20Eb1Show) {
		this.net20Eb1Show = net20Eb1Show;
	}

	@Transient
	public String getNet20PeakShow() {
		return net20PeakShow;
	}

	public void setNet20PeakShow(String net20PeakShow) {
		this.net20PeakShow = net20PeakShow;
	}

	@Transient
	public String getNet20NoiseShow() {
		return net20NoiseShow;
	}

	public void setNet20NoiseShow(String net20NoiseShow) {
		this.net20NoiseShow = net20NoiseShow;
	}

	@Transient
	public String getNet2ZrxShow() {
		return net2ZrxShow;
	}

	public void setNet2ZrxShow(String net2ZrxShow) {
		this.net2ZrxShow = net2ZrxShow;
	}

	@Transient
	public String getNet2ZebShow() {
		return net2ZebShow;
	}

	public void setNet2ZebShow(String net2ZebShow) {
		this.net2ZebShow = net2ZebShow;
	}

	@Transient
	public String getNet2BrxShow() {
		return net2BrxShow;
	}

	public void setNet2BrxShow(String net2BrxShow) {
		this.net2BrxShow = net2BrxShow;
	}

	@Transient
	public String getNet2BebShow() {
		return net2BebShow;
	}

	public void setNet2BebShow(String net2BebShow) {
		this.net2BebShow = net2BebShow;
	}

	@Transient
	public String getNet30Rx0Show() {
		return net30Rx0Show;
	}

	public void setNet30Rx0Show(String net30Rx0Show) {
		this.net30Rx0Show = net30Rx0Show;
	}

	@Transient
	public String getNet30Eb0Show() {
		return net30Eb0Show;
	}

	public void setNet30Eb0Show(String net30Eb0Show) {
		this.net30Eb0Show = net30Eb0Show;
	}

	@Transient
	public String getNet30Rx1Show() {
		return net30Rx1Show;
	}

	public void setNet30Rx1Show(String net30Rx1Show) {
		this.net30Rx1Show = net30Rx1Show;
	}

	@Transient
	public String getNet30Eb1Show() {
		return net30Eb1Show;
	}

	public void setNet30Eb1Show(String net30Eb1Show) {
		this.net30Eb1Show = net30Eb1Show;
	}

	@Transient
	public String getNet30PeakShow() {
		return net30PeakShow;
	}

	public void setNet30PeakShow(String net30PeakShow) {
		this.net30PeakShow = net30PeakShow;
	}

	@Transient
	public String getNet30NoiseShow() {
		return net30NoiseShow;
	}

	public void setNet30NoiseShow(String net30NoiseShow) {
		this.net30NoiseShow = net30NoiseShow;
	}

	@Transient
	public String getNet3ZrxShow() {
		return net3ZrxShow;
	}

	public void setNet3ZrxShow(String net3ZrxShow) {
		this.net3ZrxShow = net3ZrxShow;
	}

	@Transient
	public String getNet3ZebShow() {
		return net3ZebShow;
	}

	public void setNet3ZebShow(String net3ZebShow) {
		this.net3ZebShow = net3ZebShow;
	}

	@Transient
	public String getNet3BrxShow() {
		return net3BrxShow;
	}

	public void setNet3BrxShow(String net3BrxShow) {
		this.net3BrxShow = net3BrxShow;
	}

	@Transient
	public String getNet3BebShow() {
		return net3BebShow;
	}

	public void setNet3BebShow(String net3BebShow) {
		this.net3BebShow = net3BebShow;
	}

	@Transient
	public String getNet40Rx0Show() {
		return net40Rx0Show;
	}

	public void setNet40Rx0Show(String net40Rx0Show) {
		this.net40Rx0Show = net40Rx0Show;
	}

	@Transient
	public String getNet40Eb0Show() {
		return net40Eb0Show;
	}

	public void setNet40Eb0Show(String net40Eb0Show) {
		this.net40Eb0Show = net40Eb0Show;
	}

	@Transient
	public String getNet40Rx1Show() {
		return net40Rx1Show;
	}

	public void setNet40Rx1Show(String net40Rx1Show) {
		this.net40Rx1Show = net40Rx1Show;
	}

	@Transient
	public String getNet40Eb1Show() {
		return net40Eb1Show;
	}

	public void setNet40Eb1Show(String net40Eb1Show) {
		this.net40Eb1Show = net40Eb1Show;
	}

	@Transient
	public String getNet40PeakShow() {
		return net40PeakShow;
	}

	public void setNet40PeakShow(String net40PeakShow) {
		this.net40PeakShow = net40PeakShow;
	}

	@Transient
	public String getNet40NoiseShow() {
		return net40NoiseShow;
	}

	public void setNet40NoiseShow(String net40NoiseShow) {
		this.net40NoiseShow = net40NoiseShow;
	}

	@Transient
	public String getNet4ZrxShow() {
		return net4ZrxShow;
	}

	public void setNet4ZrxShow(String net4ZrxShow) {
		this.net4ZrxShow = net4ZrxShow;
	}

	@Transient
	public String getNet4ZebShow() {
		return net4ZebShow;
	}

	public void setNet4ZebShow(String net4ZebShow) {
		this.net4ZebShow = net4ZebShow;
	}

	@Transient
	public String getNet4BrxShow() {
		return net4BrxShow;
	}

	public void setNet4BrxShow(String net4BrxShow) {
		this.net4BrxShow = net4BrxShow;
	}

	@Transient
	public String getNet4BebShow() {
		return net4BebShow;
	}

	public void setNet4BebShow(String net4BebShow) {
		this.net4BebShow = net4BebShow;
	}

	@Transient
	public String getFrPeakShow() {
		return frPeakShow;
	}

	public void setFrPeakShow(String frPeakShow) {
		this.frPeakShow = frPeakShow;
	}

	@Transient
	public String getFrNoiseShow() {
		return frNoiseShow;
	}

	public void setFrNoiseShow(String frNoiseShow) {
		this.frNoiseShow = frNoiseShow;
	}

	@Transient
	public String getFrZrxShow() {
		return frZrxShow;
	}

	public void setFrZrxShow(String frZrxShow) {
		this.frZrxShow = frZrxShow;
	}

	@Transient
	public String getFrZebShow() {
		return frZebShow;
	}

	public void setFrZebShow(String frZebShow) {
		this.frZebShow = frZebShow;
	}

	@Transient
	public String getFrBrxShow() {
		return frBrxShow;
	}

	public void setFrBrxShow(String frBrxShow) {
		this.frBrxShow = frBrxShow;
	}

	@Transient
	public String getFrBebShow() {
		return frBebShow;
	}

	public void setFrBebShow(String frBebShow) {
		this.frBebShow = frBebShow;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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

	@Column(name = "ODUS_A_RESULT")
	public String getOdusAresult() {
		return odusAresult;
	}

	public void setOdusAresult(String odusAresult) {
		this.odusAresult = odusAresult;
	}

	@Column(name = "ODUS_B_RESULT")
	public String getOdusBresult() {
		return odusBresult;
	}

	public void setOdusBresult(String odusBresult) {
		this.odusBresult = odusBresult;
	}

	@Column(name = "NET1_WORK")
	public String getNet1Work() {
		return net1Work;
	}

	public void setNet1Work(String net1Work) {
		this.net1Work = net1Work;
	}

	@Column(name = "NET2_WORK")
	public String getNet2Work() {
		return net2Work;
	}

	public void setNet2Work(String net2Work) {
		this.net2Work = net2Work;
	}

	@Column(name = "NET3_WORK")
	public String getNet3Work() {
		return net3Work;
	}

	public void setNet3Work(String net3Work) {
		this.net3Work = net3Work;
	}

	@Column(name = "NET4_WORK")
	public String getNet4Work() {
		return net4Work;
	}

	public void setNet4Work(String net4Work) {
		this.net4Work = net4Work;
	}

	@Column(name = "NETFR_WORK")
	public String getNetfrWork() {
		return netfrWork;
	}

	public void setNetfrWork(String netfrWork) {
		this.netfrWork = netfrWork;
	}

	@Column(name = "ODUT_A_UCT")
	public String getOdutAuct() {
		return odutAuct;
	}

	public void setOdutAuct(String odutAuct) {
		this.odutAuct = odutAuct;
	}

	@Column(name = "ODUT_A_DCT")
	public String getOdutAdct() {
		return odutAdct;
	}

	public void setOdutAdct(String odutAdct) {
		this.odutAdct = odutAdct;
	}

	@Column(name = "ODUT_A_MCT")
	public String getOdutAmct() {
		return odutAmct;
	}

	public void setOdutAmct(String odutAmct) {
		this.odutAmct = odutAmct;
	}

	@Column(name = "ODUT_B_UCT")
	public String getOdutBuct() {
		return odutBuct;
	}

	public void setOdutBuct(String odutBuct) {
		this.odutBuct = odutBuct;
	}

	@Column(name = "ODUT_B_DCT")
	public String getOdutBdct() {
		return odutBdct;
	}

	public void setOdutBdct(String odutBdct) {
		this.odutBdct = odutBdct;
	}

	@Column(name = "ODUT_B_MCT")
	public String getOdutBmct() {
		return odutBmct;
	}

	public void setOdutBmct(String odutBmct) {
		this.odutBmct = odutBmct;
	}

	@Column(name = "ODUC_A_UCF")
	public String getOdutAucf() {
		return odutAucf;
	}

	public void setOdutAucf(String odutAucf) {
		this.odutAucf = odutAucf;
	}

	@Column(name = "ODUC_A_UCA")
	public String getOdutAuca() {
		return odutAuca;
	}

	public void setOdutAuca(String odutAuca) {
		this.odutAuca = odutAuca;
	}

	@Column(name = "ODUC_A_DCF")
	public String getOdutAdcf() {
		return odutAdcf;
	}

	public void setOdutAdcf(String odutAdcf) {
		this.odutAdcf = odutAdcf;
	}

	@Column(name = "ODUC_A_DCA")
	public String getOdutAdca() {
		return odutAdca;
	}

	public void setOdutAdca(String odutAdca) {
		this.odutAdca = odutAdca;
	}

	@Column(name = "ODUC_B_UCF")
	public String getOdutBucf() {
		return odutBucf;
	}

	public void setOdutBucf(String odutBucf) {
		this.odutBucf = odutBucf;
	}

	@Column(name = "ODUC_B_UCA")
	public String getOdutBuca() {
		return odutBuca;
	}

	public void setOdutBuca(String odutBuca) {
		this.odutBuca = odutBuca;
	}

	@Column(name = "ODUC_B_DCF")
	public String getOdutBdcf() {
		return odutBdcf;
	}

	public void setOdutBdcf(String odutBdcf) {
		this.odutBdcf = odutBdcf;
	}

	@Column(name = "ODUC_B_DCA")
	public String getOdutBdca() {
		return odutBdca;
	}

	public void setOdutBdca(String odutBdca) {
		this.odutBdca = odutBdca;
	}

	@Column(name = "NET1_MAP")
	public String getNet1Map() {
		return net1Map;
	}

	public void setNet1Map(String net1Map) {
		this.net1Map = net1Map;
	}

	@Column(name = "NET2_MAP")
	public String getNet2Map() {
		return net2Map;
	}

	public void setNet2Map(String net2Map) {
		this.net2Map = net2Map;
	}

	@Column(name = "NET3_MAP")
	public String getNet3Map() {
		return net3Map;
	}

	public void setNet3Map(String net3Map) {
		this.net3Map = net3Map;
	}

	@Column(name = "NET4_MAP")
	public String getNet4Map() {
		return net4Map;
	}

	public void setNet4Map(String net4Map) {
		this.net4Map = net4Map;
	}

	@Column(name = "NETFR_MAP")
	public String getNetfrMap() {
		return netfrMap;
	}

	public void setNetfrMap(String netfrMap) {
		this.netfrMap = netfrMap;
	}

	@Column(name = "NET1_0_RX0")
	public String getNet10Rx0() {
		return net10Rx0;
	}

	public void setNet10Rx0(String net10Rx0) {
		this.net10Rx0 = net10Rx0;
	}

	@Column(name = "NET1_0_EB0")
	public String getNet10Eb0() {
		return net10Eb0;
	}

	public void setNet10Eb0(String net10Eb0) {
		this.net10Eb0 = net10Eb0;
	}

	@Column(name = "NET1_0_RX1")
	public String getNet10Rx1() {
		return net10Rx1;
	}

	public void setNet10Rx1(String net10Rx1) {
		this.net10Rx1 = net10Rx1;
	}

	@Column(name = "NET1_0_EB1")
	public String getNet10Eb1() {
		return net10Eb1;
	}

	public void setNet10Eb1(String net10Eb1) {
		this.net10Eb1 = net10Eb1;
	}

	@Column(name = "NET1_0_RX130")
	public String getNet10Rx130() {
		return net10Rx130;
	}

	public void setNet10Rx130(String net10Rx130) {
		this.net10Rx130 = net10Rx130;
	}

	@Column(name = "NET1_0_EB130")
	public String getNet10Eb130() {
		return net10Eb130;
	}

	public void setNet10Eb130(String net10Eb130) {
		this.net10Eb130 = net10Eb130;
	}

	@Column(name = "NET1_0_PEAK")
	public String getNet10Peak() {
		return net10Peak;
	}

	public void setNet10Peak(String net10Peak) {
		this.net10Peak = net10Peak;
	}

	@Column(name = "NET1_0_NOISE")
	public String getNet10Noise() {
		return net10Noise;
	}

	public void setNet10Noise(String net10Noise) {
		this.net10Noise = net10Noise;
	}

	@Column(name = "NET1_Z_NUM")
	public String getNet1Znum() {
		return net1Znum;
	}

	public void setNet1Znum(String net1Znum) {
		this.net1Znum = net1Znum;
	}

	@Column(name = "NET1_Z_WEATHER")
	public String getNet1Zweather() {
		return net1Zweather;
	}

	public void setNet1Zweather(String net1Zweather) {
		this.net1Zweather = net1Zweather;
	}

	@Column(name = "NET1_Z_STATE")
	public String getNet1Zstate() {
		return net1Zstate;
	}

	public void setNet1Zstate(String net1Zstate) {
		this.net1Zstate = net1Zstate;
	}

	@Column(name = "NET1_Z_RX")
	public String getNet1Zrx() {
		return net1Zrx;
	}

	public void setNet1Zrx(String net1Zrx) {
		this.net1Zrx = net1Zrx;
	}

	@Column(name = "NET1_Z_EB")
	public String getNet1Zeb() {
		return net1Zeb;
	}

	public void setNet1Zeb(String net1Zeb) {
		this.net1Zeb = net1Zeb;
	}

	@Column(name = "NET1_B_NUM")
	public String getNet1Bnum() {
		return net1Bnum;
	}

	public void setNet1Bnum(String net1Bnum) {
		this.net1Bnum = net1Bnum;
	}

	@Column(name = "NET1_B_WEATHER")
	public String getNet1Bweather() {
		return net1Bweather;
	}

	public void setNet1Bweather(String net1Bweather) {
		this.net1Bweather = net1Bweather;
	}

	@Column(name = "NET1_B_STATE")
	public String getNet1Bstate() {
		return net1Bstate;
	}

	public void setNet1Bstate(String net1Bstate) {
		this.net1Bstate = net1Bstate;
	}

	@Column(name = "NET1_B_RX")
	public String getNet1Brx() {
		return net1Brx;
	}

	public void setNet1Brx(String net1Brx) {
		this.net1Brx = net1Brx;
	}

	@Column(name = "NET1_B_EB")
	public String getNet1Beb() {
		return net1Beb;
	}

	public void setNet1Beb(String net1Beb) {
		this.net1Beb = net1Beb;
	}

	@Column(name = "NET2_0_RX0")
	public String getNet20Rx0() {
		return net20Rx0;
	}

	public void setNet20Rx0(String net20Rx0) {
		this.net20Rx0 = net20Rx0;
	}

	@Column(name = "NET2_0_EB0")
	public String getNet20Eb0() {
		return net20Eb0;
	}

	public void setNet20Eb0(String net20Eb0) {
		this.net20Eb0 = net20Eb0;
	}

	@Column(name = "NET2_0_RX1")
	public String getNet20Rx1() {
		return net20Rx1;
	}

	public void setNet20Rx1(String net20Rx1) {
		this.net20Rx1 = net20Rx1;
	}

	@Column(name = "NET2_0_EB1")
	public String getNet20Eb1() {
		return net20Eb1;
	}

	public void setNet20Eb1(String net20Eb1) {
		this.net20Eb1 = net20Eb1;
	}

	@Column(name = "NET2_0_PEAK")
	public String getNet20Peak() {
		return net20Peak;
	}

	public void setNet20Peak(String net20Peak) {
		this.net20Peak = net20Peak;
	}

	@Column(name = "NET2_0_NOISE")
	public String getNet20Noise() {
		return net20Noise;
	}

	public void setNet20Noise(String net20Noise) {
		this.net20Noise = net20Noise;
	}

	@Column(name = "NET2_Z_NUM")
	public String getNet2Znum() {
		return net2Znum;
	}

	public void setNet2Znum(String net2Znum) {
		this.net2Znum = net2Znum;
	}

	@Column(name = "NET2_Z_WEATHER")
	public String getNet2Zweather() {
		return net2Zweather;
	}

	public void setNet2Zweather(String net2Zweather) {
		this.net2Zweather = net2Zweather;
	}

	@Column(name = "NET2_Z_STATE")
	public String getNet2Zstate() {
		return net2Zstate;
	}

	public void setNet2Zstate(String net2Zstate) {
		this.net2Zstate = net2Zstate;
	}

	@Column(name = "NET2_Z_RX")
	public String getNet2Zrx() {
		return net2Zrx;
	}

	public void setNet2Zrx(String net2Zrx) {
		this.net2Zrx = net2Zrx;
	}

	@Column(name = "NET2_Z_EB")
	public String getNet2Zeb() {
		return net2Zeb;
	}

	public void setNet2Zeb(String net2Zeb) {
		this.net2Zeb = net2Zeb;
	}

	@Column(name = "NET2_B_NUM")
	public String getNet2Bnum() {
		return net2Bnum;
	}

	public void setNet2Bnum(String net2Bnum) {
		this.net2Bnum = net2Bnum;
	}

	@Column(name = "NET2_B_WEATHER")
	public String getNet2Bweather() {
		return net2Bweather;
	}

	public void setNet2Bweather(String net2Bweather) {
		this.net2Bweather = net2Bweather;
	}

	@Column(name = "NET2_B_STATE")
	public String getNet2Bstate() {
		return net2Bstate;
	}

	public void setNet2Bstate(String net2Bstate) {
		this.net2Bstate = net2Bstate;
	}

	@Column(name = "NET2_B_RX")
	public String getNet2Brx() {
		return net2Brx;
	}

	public void setNet2Brx(String net2Brx) {
		this.net2Brx = net2Brx;
	}

	@Column(name = "NET2_B_EB")
	public String getNet2Beb() {
		return net2Beb;
	}

	public void setNet2Beb(String net2Beb) {
		this.net2Beb = net2Beb;
	}

	@Column(name = "NET3_0_RX0")
	public String getNet30Rx0() {
		return net30Rx0;
	}

	public void setNet30Rx0(String net30Rx0) {
		this.net30Rx0 = net30Rx0;
	}

	@Column(name = "NET3_0_EB0")
	public String getNet30Eb0() {
		return net30Eb0;
	}

	public void setNet30Eb0(String net30Eb0) {
		this.net30Eb0 = net30Eb0;
	}

	@Column(name = "NET3_0_RX1")
	public String getNet30Rx1() {
		return net30Rx1;
	}

	public void setNet30Rx1(String net30Rx1) {
		this.net30Rx1 = net30Rx1;
	}

	@Column(name = "NET3_0_EB1")
	public String getNet30Eb1() {
		return net30Eb1;
	}

	public void setNet30Eb1(String net30Eb1) {
		this.net30Eb1 = net30Eb1;
	}

	@Column(name = "NET3_0_PEAK")
	public String getNet30Peak() {
		return net30Peak;
	}

	public void setNet30Peak(String net30Peak) {
		this.net30Peak = net30Peak;
	}

	@Column(name = "NET3_0_NOISE")
	public String getNet30Noise() {
		return net30Noise;
	}

	public void setNet30Noise(String net30Noise) {
		this.net30Noise = net30Noise;
	}

	@Column(name = "NET3_Z_NUM")
	public String getNet3Znum() {
		return net3Znum;
	}

	public void setNet3Znum(String net3Znum) {
		this.net3Znum = net3Znum;
	}

	@Column(name = "NET3_Z_WEATHER")
	public String getNet3Zweather() {
		return net3Zweather;
	}

	public void setNet3Zweather(String net3Zweather) {
		this.net3Zweather = net3Zweather;
	}

	@Column(name = "NET3_Z_STATE")
	public String getNet3Zstate() {
		return net3Zstate;
	}

	public void setNet3Zstate(String net3Zstate) {
		this.net3Zstate = net3Zstate;
	}

	@Column(name = "NET3_Z_RX")
	public String getNet3Zrx() {
		return net3Zrx;
	}

	public void setNet3Zrx(String net3Zrx) {
		this.net3Zrx = net3Zrx;
	}

	@Column(name = "NET3_Z_EB")
	public String getNet3Zeb() {
		return net3Zeb;
	}

	public void setNet3Zeb(String net3Zeb) {
		this.net3Zeb = net3Zeb;
	}

	@Column(name = "NET3_B_NUM")
	public String getNet3Bnum() {
		return net3Bnum;
	}

	public void setNet3Bnum(String net3Bnum) {
		this.net3Bnum = net3Bnum;
	}

	@Column(name = "NET3_B_WEATHER")
	public String getNet3Bweather() {
		return net3Bweather;
	}

	public void setNet3Bweather(String net3Bweather) {
		this.net3Bweather = net3Bweather;
	}

	@Column(name = "NET3_B_STATE")
	public String getNet3Bstate() {
		return net3Bstate;
	}

	public void setNet3Bstate(String net3Bstate) {
		this.net3Bstate = net3Bstate;
	}

	@Column(name = "NET3_B_RX")
	public String getNet3Brx() {
		return net3Brx;
	}

	public void setNet3Brx(String net3Brx) {
		this.net3Brx = net3Brx;
	}

	@Column(name = "NET3_B_EB")
	public String getNet3Beb() {
		return net3Beb;
	}

	public void setNet3Beb(String net3Beb) {
		this.net3Beb = net3Beb;
	}

	@Column(name = "NET4_0_RX0")
	public String getNet40Rx0() {
		return net40Rx0;
	}

	public void setNet40Rx0(String net40Rx0) {
		this.net40Rx0 = net40Rx0;
	}

	@Column(name = "NET4_0_EB0")
	public String getNet40Eb0() {
		return net40Eb0;
	}

	public void setNet40Eb0(String net40Eb0) {
		this.net40Eb0 = net40Eb0;
	}

	@Column(name = "NET4_0_RX1")
	public String getNet40Rx1() {
		return net40Rx1;
	}

	public void setNet40Rx1(String net40Rx1) {
		this.net40Rx1 = net40Rx1;
	}

	@Column(name = "NET4_0_EB1")
	public String getNet40Eb1() {
		return net40Eb1;
	}

	public void setNet40Eb1(String net40Eb1) {
		this.net40Eb1 = net40Eb1;
	}

	@Column(name = "NET4_0_PEAK")
	public String getNet40Peak() {
		return net40Peak;
	}

	public void setNet40Peak(String net40Peak) {
		this.net40Peak = net40Peak;
	}

	@Column(name = "NET4_0_NOISE")
	public String getNet40Noise() {
		return net40Noise;
	}

	public void setNet40Noise(String net40Noise) {
		this.net40Noise = net40Noise;
	}

	@Column(name = "NET4_Z_NUM")
	public String getNet4Znum() {
		return net4Znum;
	}

	public void setNet4Znum(String net4Znum) {
		this.net4Znum = net4Znum;
	}

	@Column(name = "NET4_Z_WEATHER")
	public String getNet4Zweather() {
		return net4Zweather;
	}

	public void setNet4Zweather(String net4Zweather) {
		this.net4Zweather = net4Zweather;
	}

	@Column(name = "NET4_Z_STATE")
	public String getNet4Zstate() {
		return net4Zstate;
	}

	public void setNet4Zstate(String net4Zstate) {
		this.net4Zstate = net4Zstate;
	}

	@Column(name = "NET4_Z_RX")
	public String getNet4Zrx() {
		return net4Zrx;
	}

	public void setNet4Zrx(String net4Zrx) {
		this.net4Zrx = net4Zrx;
	}

	@Column(name = "NET4_Z_EB")
	public String getNet4Zeb() {
		return net4Zeb;
	}

	public void setNet4Zeb(String net4Zeb) {
		this.net4Zeb = net4Zeb;
	}

	@Column(name = "NET4_B_NUM")
	public String getNet4Bnum() {
		return net4Bnum;
	}

	public void setNet4Bnum(String net4Bnum) {
		this.net4Bnum = net4Bnum;
	}

	@Column(name = "NET4_B_WEATHER")
	public String getNet4Bweather() {
		return net4Bweather;
	}

	public void setNet4Bweather(String net4Bweather) {
		this.net4Bweather = net4Bweather;
	}

	@Column(name = "NET4_B_STATE")
	public String getNet4Bstate() {
		return net4Bstate;
	}

	public void setNet4Bstate(String net4Bstate) {
		this.net4Bstate = net4Bstate;
	}

	@Column(name = "NET4_B_RX")
	public String getNet4Brx() {
		return net4Brx;
	}

	public void setNet4Brx(String net4Brx) {
		this.net4Brx = net4Brx;
	}

	@Column(name = "NET4_B_EB")
	public String getNet4Beb() {
		return net4Beb;
	}

	public void setNet4Beb(String net4Beb) {
		this.net4Beb = net4Beb;
	}

	@Column(name = "NETFR_PEAK")
	public String getNetfrPeak() {
		return netfrPeak;
	}

	public void setNetfrPeak(String netfrPeak) {
		this.netfrPeak = netfrPeak;
	}

	@Column(name = "NETFR_NOISE")
	public String getNetfrNoise() {
		return netfrNoise;
	}

	public void setNetfrNoise(String netfrNoise) {
		this.netfrNoise = netfrNoise;
	}

	@Column(name = "NETFR_Z_NUM")
	public String getNetfrZnum() {
		return netfrZnum;
	}

	public void setNetfrZnum(String netfrZnum) {
		this.netfrZnum = netfrZnum;
	}

	@Column(name = "NETFR_Z_WEATHER")
	public String getNetfrZweather() {
		return netfrZweather;
	}

	public void setNetfrZweather(String netfrZweather) {
		this.netfrZweather = netfrZweather;
	}

	@Column(name = "NETFR_Z_STATE")
	public String getNetfrZstate() {
		return netfrZstate;
	}

	public void setNetfrZstate(String netfrZstate) {
		this.netfrZstate = netfrZstate;
	}

	@Column(name = "NETFR_Z_RX")
	public String getNetfrZrx() {
		return netfrZrx;
	}

	public void setNetfrZrx(String netfrZrx) {
		this.netfrZrx = netfrZrx;
	}

	@Column(name = "NETFR_Z_EB")
	public String getNetfrZeb() {
		return netfrZeb;
	}

	public void setNetfrZeb(String netfrZeb) {
		this.netfrZeb = netfrZeb;
	}

	@Column(name = "NETFR_B_NUM")
	public String getNetfrBnum() {
		return netfrBnum;
	}

	public void setNetfrBnum(String netfrBnum) {
		this.netfrBnum = netfrBnum;
	}

	@Column(name = "NETFR_B_WEATHER")
	public String getNetfrBweather() {
		return netfrBweather;
	}

	public void setNetfrBweather(String netfrBweather) {
		this.netfrBweather = netfrBweather;
	}

	@Column(name = "NETFR_B_STATE")
	public String getNetfrBstate() {
		return netfrBstate;
	}

	public void setNetfrBstate(String netfrBstate) {
		this.netfrBstate = netfrBstate;
	}

	@Column(name = "NETFR_B_RX")
	public String getNetfrBrx() {
		return netfrBrx;
	}

	public void setNetfrBrx(String netfrBrx) {
		this.netfrBrx = netfrBrx;
	}

	@Column(name = "NETFR_B_EB")
	public String getNetfrBeb() {
		return netfrBeb;
	}

	public void setNetfrBeb(String netfrBeb) {
		this.netfrBeb = netfrBeb;
	}
}
