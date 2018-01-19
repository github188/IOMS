/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:37:31
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.antenna;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.satellite.SatelliteSite;
import cn.com.atnc.ioms.entity.clientmng.Client;

@Entity
@Table(name = "TB_BD_ANTENNA")
public class Antenna extends MyStringUUIDEntity {

	private static final long serialVersionUID = 1749042121772025856L;

	private Integer longitudeDegree;// 经度——度
	private Integer longitudeMinute;// 经度——分
	private Integer longitudeSecond;// 经度——秒
	private Integer latitudeDegree;// 纬度——度
	private Integer latitudeMinute;// 纬度——分
	private Integer latitudeSecond;// 纬度——秒
	private String positionAngle;// 方位角度
	private String pitchingAngle;// 俯仰角度
	private Float antennaSize;// 天线尺寸
	private String spare;// 备件情况
	private String antennaDesc;// 天线描述
	private String elevation;// 海拔
	private String info;// 备注信息
	private transient String clientId;//

	private Calendar clientOptTime;
	private SatelliteSite site;

	private transient String siteCode;
	private transient String siteId;
	private Client client;
	private Calendar recordTime;
	private transient String recordTimeStr;// 前端客户创建时间
	private transient String longitude;
	private transient String latitude;
	private User optUser;
	private Calendar optTime;// 操作时间

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	public User getOptUser() {
		return optUser;
	}

	public void setOptUser(User optUser) {
		this.optUser = optUser;
	}

	@Column(name = "USER_OPT_TIME")
	public Calendar getOptTime() {
		return optTime;
	}

	public void setOptTime(Calendar optTime) {
		this.optTime = optTime;
	}

	@Transient
	public String getLongitude() {
		longitude = "";
		longitude += this.getLongitudeDegree() == null ? "" : this
				.getLongitudeDegree() + "°";
		longitude += this.getLongitudeMinute() == null ? "" : this
				.getLongitudeMinute() + "′";
		longitude += this.getLongitudeSecond() == null ? "" : this
				.getLongitudeSecond() + "＂";
		return longitude;
	}

	@Transient
	public String getLatitude() {

		latitude = "";
		latitude += this.getLatitudeDegree() == null ? "" : this
				.getLatitudeDegree() + "°";
		latitude += this.getLatitudeMinute() == null ? "" : this
				.getLatitudeMinute() + "′";
		latitude += this.getLatitudeSecond() == null ? "" : this
				.getLatitudeSecond() + "＂";
		return latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Transient
	public String getRecordTimeStr() {
		return recordTimeStr;
	}

	public void setRecordTimeStr(String recordTimeStr) {
		this.recordTimeStr = recordTimeStr;
	}

	@Column(name = "RECORDTIME")
	public Calendar getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Calendar recordTime) {
		this.recordTime = recordTime;
	}

	@ManyToOne
	@JoinColumn(name = "SITE_ID")
	public SatelliteSite getSite() {
		return site;
	}

	public void setSite(SatelliteSite site) {
		this.site = site;
	}

	@Column(name = "CLIENT_OPT_TIME")
	public Calendar getClientOptTime() {
		if (clientOptTime == null) {
			return Calendar.getInstance();
		}
		return clientOptTime;
	}

	public void setClientOptTime(Calendar clientOptTime) {
		this.clientOptTime = clientOptTime;
	}

	@Transient
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Column(name = "ANTSIZE")
	public Float getAntennaSize() {
		return antennaSize;
	}

	public void setAntennaSize(Float antennaSize) {
		this.antennaSize = antennaSize;
	}

	@Column(name = "LONGITUDE_DEGREE")
	public Integer getLongitudeDegree() {
		return longitudeDegree;
	}

	public void setLongitudeDegree(Integer longitudeDegree) {
		this.longitudeDegree = longitudeDegree;
	}

	@Column(name = "LONGITUDE_MINUTE")
	public Integer getLongitudeMinute() {
		return longitudeMinute;
	}

	public void setLongitudeMinute(Integer longitudeMinute) {
		this.longitudeMinute = longitudeMinute;
	}

	@Column(name = "LONGITUDE_SECOND")
	public Integer getLongitudeSecond() {
		return longitudeSecond;
	}

	public void setLongitudeSecond(Integer longitudeSecond) {
		this.longitudeSecond = longitudeSecond;
	}

	@Column(name = "LATITUDE_DEGREE")
	public Integer getLatitudeDegree() {
		return latitudeDegree;
	}

	public void setLatitudeDegree(Integer latitudeDegree) {
		this.latitudeDegree = latitudeDegree;
	}

	@Column(name = "LATITUDE_MINUTE")
	public Integer getLatitudeMinute() {
		return latitudeMinute;
	}

	public void setLatitudeMinute(Integer latitudeMinute) {
		this.latitudeMinute = latitudeMinute;
	}

	@Column(name = "LATITUDE_SECOND")
	public Integer getLatitudeSecond() {
		return latitudeSecond;
	}

	public void setLatitudeSecond(Integer latitudeSecond) {
		this.latitudeSecond = latitudeSecond;
	}

	@Column(name = "POSITION_ANGLE")
	public String getPositionAngle() {
		return positionAngle;
	}

	public void setPositionAngle(String positionAngle) {
		this.positionAngle = positionAngle;
	}

	@Column(name = "PITCHING_ANGLE")
	public String getPitchingAngle() {
		return pitchingAngle;
	}

	public void setPitchingAngle(String pitchingAngle) {
		this.pitchingAngle = pitchingAngle;
	}

	@Column(name = "SPARE")
	public String getSpare() {
		return spare;
	}

	public void setSpare(String spare) {
		this.spare = spare;
	}

	@Column(name = "ANTENNA_DESC")
	public String getAntennaDesc() {
		return antennaDesc;
	}

	public void setAntennaDesc(String antennaDesc) {
		this.antennaDesc = antennaDesc;
	}

	@Column(name = "INFO")
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Column(name = "ELEVATION")
	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	@Transient
	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	@Transient
	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
