package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
/**
 * 卫星转发器频带资源使用统计
 * 
 * @author shijiyong
 * @date 2016年11月1日 下午1:53:06
 * @version 1.0, 2016年11月1日 下午1:53:06
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_FORWARD")
public class Forward extends MyStringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tesSum;
	private String tesUse;
	private String tesSur;
	private String tesDbm;
	private String tesDb;
	
	private String pesSum;
	private String pesUse;
	private String pesSur;
	private String pesDbm;
	private String pesDb;
	
	private String vsatSum;
	private String vsatUse;
	private String vsatSur;
	private String vsatDbm;
	private String vsatDb;
	
	private String comSum;
	private String comUse;
	private String comSur;
	private String comDbm;
	private String comDb;
	
	
	private EnvironmentEquipCheck checkid;// 巡检id

	@Column(name = "tes_sum")
	public String getTesSum() {
		return tesSum;
	}


	public void setTesSum(String tesSum) {
		this.tesSum = tesSum;
	}

	@Column(name = "tes_use")
	public String getTesUse() {
		return tesUse;
	}


	public void setTesUse(String tesUse) {
		this.tesUse = tesUse;
	}

	@Column(name = "tes_sur")
	public String getTesSur() {
		return tesSur;
	}


	public void setTesSur(String tesSur) {
		this.tesSur = tesSur;
	}

	@Column(name = "tes_Dbm")
	public String getTesDbm() {
		return tesDbm;
	}


	public void setTesDbm(String tesDbm) {
		this.tesDbm = tesDbm;
	}

	@Column(name = "tes_db")
	public String getTesDb() {
		return tesDb;
	}


	public void setTesDb(String tesDb) {
		this.tesDb = tesDb;
	}

	@Column(name = "pes_sum")
	public String getPesSum() {
		return pesSum;
	}


	public void setPesSum(String pesSum) {
		this.pesSum = pesSum;
	}

	@Column(name = "pes_use")
	public String getPesUse() {
		return pesUse;
	}


	public void setPesUse(String pesUse) {
		this.pesUse = pesUse;
	}

	@Column(name = "pes_sur")
	public String getPesSur() {
		return pesSur;
	}


	public void setPesSur(String pesSur) {
		this.pesSur = pesSur;
	}

	@Column(name = "pes_Dbm")
	public String getPesDbm() {
		return pesDbm;
	}


	public void setPesDbm(String pesDbm) {
		this.pesDbm = pesDbm;
	}

	@Column(name = "pes_db")
	public String getPesDb() {
		return pesDb;
	}


	public void setPesDb(String pesDb) {
		this.pesDb = pesDb;
	}

	@Column(name = "vsat_sum")
	public String getVsatSum() {
		return vsatSum;
	}


	public void setVsatSum(String vsatSum) {
		this.vsatSum = vsatSum;
	}

	@Column(name = "vsat_use")
	public String getVsatUse() {
		return vsatUse;
	}


	public void setVsatUse(String vsatUse) {
		this.vsatUse = vsatUse;
	}

	@Column(name = "vsat_sur")
	public String getVsatSur() {
		return vsatSur;
	}


	public void setVsatSur(String vsatSur) {
		this.vsatSur = vsatSur;
	}

	@Column(name = "vsat_dbm")
	public String getVsatDbm() {
		return vsatDbm;
	}


	public void setVsatDbm(String vsatDbm) {
		this.vsatDbm = vsatDbm;
	}

	@Column(name = "vsat_db")
	public String getVsatDb() {
		return vsatDb;
	}


	public void setVsatDb(String vsatDb) {
		this.vsatDb = vsatDb;
	}

	@Column(name = "com_sum")
	public String getComSum() {
		return comSum;
	}


	public void setComSum(String comSum) {
		this.comSum = comSum;
	}

	@Column(name = "com_use")
	public String getComUse() {
		return comUse;
	}


	public void setComUse(String comUse) {
		this.comUse = comUse;
	}

	@Column(name = "com_sur")
	public String getComSur() {
		return comSur;
	}


	public void setComSur(String comSur) {
		this.comSur = comSur;
	}

	@Column(name = "com_dbm")
	public String getComDbm() {
		return comDbm;
	}


	public void setComDbm(String comDbm) {
		this.comDbm = comDbm;
	}

	@Column(name = "com_db")
	public String getComDb() {
		return comDb;
	}


	public void setComDb(String comDb) {
		this.comDb = comDb;
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
