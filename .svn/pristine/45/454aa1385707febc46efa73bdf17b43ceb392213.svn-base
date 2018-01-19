/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午7:34:46
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.maintain.equipmobile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.enums.clientnotice.NoticeFlag;

/**
 * 设备绑定发短信的手机号
 *
 * @author 段衍林
 * @2016年11月22日 上午9:38:54
 */
@Entity
@Table(name = "TB_BD_EQUIP_MOBILE")
public class KuMobile extends MyStringUUIDEntity {

	private static final long serialVersionUID = -4636035371499706701L;
	private Equip equip;			//绑定设备
	private String name;			//用户名称
	private String mobile;			//用户手机号
	private NoticeFlag sendmsgFlag;	//发送短信控制

	@Enumerated(EnumType.STRING)
	@Column(name = "SENDMSG_FLAG")
	public NoticeFlag getSendmsgFlag() {
		return sendmsgFlag;
	}

	public void setSendmsgFlag(NoticeFlag sendmsgFlag) {
		this.sendmsgFlag = sendmsgFlag;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MOBILE")
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@ManyToOne
	@JoinColumn(name = "EQUIP_ID")
	public Equip getEquip() {
		return equip;
	}

	public void setEquip(Equip equip) {
		this.equip = equip;
	}
}
