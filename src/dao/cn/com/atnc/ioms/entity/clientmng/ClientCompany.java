package cn.com.atnc.ioms.entity.clientmng;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;
import cn.com.atnc.ioms.entity.BaseUserInfo;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.enums.clientmng.SexEnum;

/**
 * 类说明:客服平台用户
 * 
 * @author 潘涛
 * @date 2014-3-18 下午3:16:23
 * @version:1.0
 */
@Entity
@Table(name = "TB_CS_CLIENT_COMPANY")
public class ClientCompany extends StringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3403004913740047133L;
	
	private String company;// 公司
	private Bureau bureau;// 管局
	private String address;// 地址
	private String postcode;// 邮编


	@Column(name = "COMPANY")
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "BUREAU")
	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "POSTCODE")
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
