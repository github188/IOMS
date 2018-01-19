package cn.com.atnc.ioms.entity.duty.satelliteauto.day;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;

/**
 * 通信基地-TES-TES OCC状态实体
 *
 * @author 段衍林
 * @2016年11月10日 下午1:18:30
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_KUDAY_FLAG")
public class SatTxjdKuDayFlag extends MyStringUUIDEntity{
	
private static final long serialVersionUID = 1L;
	
	private String odutAuct;			//ODUT_A_UCT
	private String odutAdct;			//ODUT_A_DCT
	private String odutAmct;			//ODUT_A_MCT
	private String odutBuct;			//ODUT_B_UCT
	private String odutBdct;			//ODUT_B_DCT
	private String odutBmct;			//ODUT_B_MCT
	private String odutAucf;			//ODUT_A_UCF
	private String odutAuca;			//ODUT_A_UCA
	private String odutAdcf;			//ODUT_A_DCF
	private String odutAdca;			//ODUT_A_DCA
	private String odutBucf;			//ODUT_B_UCF
	private String odutBuca;			//ODUT_B_UCA
	private String odutBdcf;			//ODUT_B_DCF
	private String odutBdca;			//ODUT_B_DCA
	private String net1Map;				//NET1_MAP
	private String net2Map;				//NET2_MAP
	private String net3Map;				//NET3_MAP
	private String net4Map;				//NET4_MAP
	private String netfrMap;			//NETFR_MAP
	
	private String net10Rx0;			//NET1_0_RX0
	private String net10Eb0;			//NET1_0_EB0
	private String net10Rx1;			//NET1_0_RX1
	private String net10Eb1;			//NET1_0_EB1
	private String net10Rx130;			//NET1_0_RX130
	private String net10Eb130;			//NET1_0_EB130
	private String net10Peak;			//NET1_0_PEAK
	private String net10Noise;			//NET1_0_NOISE
	private String net1Znum;			//NET1_Z_NUM
	private String net1Zweather;		//NET1_Z_WEATHER
	private String net1Zstate;			//NET1_Z_STATE
	private String net1Zrx;				//NET1_Z_RX
	private String net1Zeb;				//NET1_Z_EB
	private String net1Bnum;			//NET1_B_NUM
	private String net1Bweather;		//NET1_B_WEATHER
	private String net1Bstate;			//NET1_B_STATE
	private String net1Brx;				//NET1_B_RX
	private String net1Beb;				//NET1_B_EB
	
	private String net20Rx0;			//NET2_0_RX0
	private String net20Eb0;			//NET2_0_EB0
	private String net20Rx1;			//NET2_0_RX1
	private String net20Eb1;			//NET2_0_EB1
	private String net20Peak;			//NET2_0_PEAK
	private String net20Noise;			//NET2_0_NOISE
	private String net2Znum;			//NET2_Z_NUM
	private String net2Zweather;		//NET2_Z_WEATHER
	private String net2Zstate;			//NET2_Z_STATE
	private String net2Zrx;				//NET2_Z_RX
	private String net2Zeb;				//NET2_Z_EB
	private String net2Bnum;			//NET2_B_NUM
	private String net2Bweather;		//NET2_B_WEATHER
	private String net2Bstate;			//NET2_B_STATE
	private String net2Brx;				//NET2_B_RX
	private String net2Beb;				//NET2_B_EB
	private String net30Rx0;			//NET3_0_RX0
	private String net30Eb0;			//NET3_0_EB0
	private String net30Rx1;			//NET3_0_RX1
	private String net30Eb1;			//NET3_0_EB1
	private String net30Peak;			//NET3_0_PEAK
	private String net30Noise;			//NET3_0_NOISE
	private String net3Znum;			//NET3_Z_NUM
	private String net3Zweather;		//NET3_Z_WEATHER
	private String net3Zstate;			//NET3_Z_STATE
	private String net3Zrx;				//NET3_Z_RX
	private String net3Zeb;				//NET3_Z_EB
	private String net3Bnum;			//NET3_B_NUM
	private String net3Bweather;		//NET3_B_WEATHER
	private String net3Bstate;			//NET3_B_STATE
	private String net3Brx;				//NET3_B_RX
	private String net3Beb;				//NET3_B_EB
	private String net40Rx0;			//NET4_0_RX0
	private String net40Eb0;			//NET4_0_EB0
	private String net40Rx1;			//NET4_0_RX1
	private String net40Eb1;			//NET4_0_EB1
	private String net40Peak;			//NET4_0_PEAK
	private String net40Noise;			//NET4_0_NOISE
	private String net4Znum;			//NET4_Z_NUM
	private String net4Zweather;		//NET4_Z_WEATHER
	private String net4Zstate;			//NET4_Z_STATE
	private String net4Zrx;				//NET4_Z_RX
	private String net4Zeb;				//NET4_Z_EB
	private String net4Bnum;			//NET4_B_NUM
	private String net4Bweather;		//NET4_B_WEATHER
	private String net4Bstate;			//NET4_B_STATE
	private String net4Brx;				//NET4_B_RX
	private String net4Beb;				//NET4_B_EB
	private String netfrPeak;			//NETFR_PEAK
	private String netfrNoise;			//NETFR_NOISE
	private String netfrZnum;			//NETFR_Z_NUM
	private String netfrZweather;		//NETFR_Z_WEATHER
	private String netfrZstate;			//NETFR_Z_STATE
	private String netfrZrx;			//NETFR_Z_RX
	private String netfrZeb;			//NETFR_Z_EB
	private String netfrBnum;			//NETFR_B_NUM
	private String netfrBweather;		//NETFR_B_WEATHER
	private String netfrBstate;			//NETFR_B_STATE
	private String netfrBrx;			//NETFR_B_RX
	private String netfrBeb;			//NETFR_B_EB
	private String odusAresult;//ODUS_A_RESULT
	private String odusBresult;//ODUS_B_RESULT
	private String net1Work;	//NET1_WORK
	private String net2Work;	//NET2_WORK
	private String net3Work;	//NET3_WORK
	private String net4Work;	//NET4_WORK
	private String netfrWork;	//NETFR_WORK
	
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
