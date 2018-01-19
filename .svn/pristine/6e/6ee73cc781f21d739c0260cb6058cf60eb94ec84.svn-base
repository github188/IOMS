/**
 * @Title:AtmDay.java
 * @author shijiyong
 * @data 2016年9月21日上午10:33:03
 * @version v1.0
 */
package cn.com.atnc.ioms.entity.duty.atm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.enums.duty.atm.CityEnum;
import cn.com.atnc.ioms.enums.duty.atm.HaveNoEnum;
import cn.com.atnc.ioms.enums.duty.atm.StatusResultEnum;

/**
 * ATM日检业务路由器和交换机子类
 * 
 * @author 王凌斌
 * @2017年2月9日 下午1:33:20
 */
@Entity
@Table(name = "TB_OM_DUTY_ATM_DAY_SON")
public class ATMDaySon extends MyStringUUIDEntity {

	private static final long serialVersionUID = -7017960876370690346L;
	// 序号
	private Integer serial;
	// 传输情况地点名称
	private CityEnum name;
	// 检查结果
	private HaveNoEnum result;
	// 连通性检查结果
	private StatusResultEnum conResult;
	// ATM日检业务路由器ID
	private ATMDayRoute route;
	// ATM日检交换机ID
	private ATMDayMgx mgx;

	@Column(name = "SERIAL")
	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	@Enumerated(value = EnumType.STRING)
	@Column(name = "NAME")
	public CityEnum getName() {
		return name;
	}

	public void setName(CityEnum name) {
		this.name = name;
	}

	@Enumerated(value = EnumType.STRING)
	@Column(name = "RESULT")
	public HaveNoEnum getResult() {
		return result;
	}

	public void setResult(HaveNoEnum result) {
		this.result = result;
	}
	
	@Enumerated(value = EnumType.STRING)
    @Column(name = "CON_RESULT")
	public StatusResultEnum getConResult() {
        return conResult;
    }

    public void setConResult(StatusResultEnum conResult) {
        this.conResult = conResult;
    }

    @ManyToOne
	@JoinColumn(name = "ROUTE_ID")
	public ATMDayRoute getRoute() {
		return route;
	}

	public void setRoute(ATMDayRoute route) {
		this.route = route;
	}

	@ManyToOne
    @JoinColumn(name = "MGX_ID")
    public ATMDayMgx getMgx() {
        return mgx;
    }
    
    public void setMgx(ATMDayMgx mgx) {
        this.mgx = mgx;
    }
   

}