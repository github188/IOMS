/**
 * @Title:AtmdayCheckQueryModel.java
 * @author shijiyong
 * @data 2016年9月26日上午10:15:33
 * @version v1.0
 */
package cn.com.atnc.ioms.model.duty.atm;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.enums.duty.atm.AtmDayMgxTabEnum;
import cn.com.atnc.ioms.enums.duty.atm.AtmDayTypeEnum;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * ATM日检交换机Model
 * 
 * @author wangzhipeng
 * @date 2016年9月26日 上午10:15:33
 * @version 1.0, 2016年9月26日 上午10:15:33
 */
public class AtmDayQueryModelMgx extends MyPaginModel {

	private String operator; // 操作人名称
	private String auditor;		//审核人名称
	private Date startTime; // 查询起始时间
	private Date endTime; // 查询结束时间
	// tab页类型
	private AtmDayMgxTabEnum tabType;
	private CheckCatagory checkType;
	private AtmDayTypeEnum atmtype; // ATM巡检设备

	// --------------------添加页面保存数据----------------------------//
	// 设备运行环境_风扇
	private List<String> env_fan;
	// 设备运行环境_电源
	private List<String> env_power;
	// 设备运行环境_温度
    private List<String> env_temperatuer;
    // 与网控中心8850节点的连通性
    private List<String> wkzx8850_con;
    // 与通信基地8830节点的连通性
    private List<String> txjd8830_con;
    // 中继连通状态
    private List<String> zj_con;
    // 网控中心8830连通性
    private List<String> wkzx8830_con;
    // 通信基地8850连通性
    private List<String> txjd8850_con;
    // 民航局空管局连通性
    private List<String> mhj_con;
    // 首都机场连通性
    private List<String> capital_con;
    // 十里河8850连通性
    private List<String> slh8850_con;
    // 成都
    private List<String> chengdu;
    // 广州
    private List<String> guangzhou;
    // 上海
    private List<String> shanghai;
    // 沈阳
    private List<String> shenyang;
    // 西安
    private List<String> xian;
    // 乌鲁木齐
    private List<String> wulumuqi;
    // 通信基地8850备注
    private List<String> txjdbz;  
    // 通信基地8830备注
    private List<String> txjdsbz;  
    // 十里河8850备注
    private List<String> slhbz;  
    // 十里河8830备注
    private List<String> slhsbz;  
    // 民航局8850备注
    private List<String> mhjbz;  
    // 民航局空管局8850备注
    private List<String> kgjbz;  
    // 财富中心8830备注
    private List<String> cfzxbz;  
    // 审核备注
    private String auditRemark;
    
    
    public List<String> getTxjdbz() {
        return txjdbz;
    }

    public void setTxjdbz(List<String> txjdbz) {
        this.txjdbz = txjdbz;
    }

    public List<String> getTxjdsbz() {
        return txjdsbz;
    }

    public void setTxjdsbz(List<String> txjdsbz) {
        this.txjdsbz = txjdsbz;
    }

    public List<String> getSlhbz() {
        return slhbz;
    }

    public void setSlhbz(List<String> slhbz) {
        this.slhbz = slhbz;
    }

    public List<String> getSlhsbz() {
        return slhsbz;
    }

    public void setSlhsbz(List<String> slhsbz) {
        this.slhsbz = slhsbz;
    }

    public List<String> getMhjbz() {
        return mhjbz;
    }

    public void setMhjbz(List<String> mhjbz) {
        this.mhjbz = mhjbz;
    }

    public List<String> getKgjbz() {
        return kgjbz;
    }

    public void setKgjbz(List<String> kgjbz) {
        this.kgjbz = kgjbz;
    }

    public List<String> getCfzxbz() {
        return cfzxbz;
    }

    public void setCfzxbz(List<String> cfzxbz) {
        this.cfzxbz = cfzxbz;
    }

	public List<String> getEnv_fan() {
        return env_fan;
    }

    public void setEnv_fan(List<String> env_fan) {
        this.env_fan = env_fan;
    }

    public List<String> getEnv_power() {
        return env_power;
    }

    public void setEnv_power(List<String> env_power) {
        this.env_power = env_power;
    }

    public List<String> getEnv_temperatuer() {
        return env_temperatuer;
    }

    public void setEnv_temperatuer(List<String> env_temperatuer) {
        this.env_temperatuer = env_temperatuer;
    }

    public List<String> getWkzx8850_con() {
        return wkzx8850_con;
    }

    public void setWkzx8850_con(List<String> wkzx8850_con) {
        this.wkzx8850_con = wkzx8850_con;
    }

    public List<String> getTxjd8830_con() {
        return txjd8830_con;
    }

    public void setTxjd8830_con(List<String> txjd8830_con) {
        this.txjd8830_con = txjd8830_con;
    }

    public List<String> getZj_con() {
        return zj_con;
    }

    public void setZj_con(List<String> zj_con) {
        this.zj_con = zj_con;
    }

    public List<String> getWkzx8830_con() {
        return wkzx8830_con;
    }

    public void setWkzx8830_con(List<String> wkzx8830_con) {
        this.wkzx8830_con = wkzx8830_con;
    }

    public List<String> getTxjd8850_con() {
        return txjd8850_con;
    }

    public void setTxjd8850_con(List<String> txjd8850_con) {
        this.txjd8850_con = txjd8850_con;
    }

    public List<String> getMhj_con() {
        return mhj_con;
    }

    public void setMhj_con(List<String> mhj_con) {
        this.mhj_con = mhj_con;
    }

    public List<String> getCapital_con() {
        return capital_con;
    }

    public void setCapital_con(List<String> capital_con) {
        this.capital_con = capital_con;
    }

    public List<String> getSlh8850_con() {
        return slh8850_con;
    }

    public void setSlh8850_con(List<String> slh8850_con) {
        this.slh8850_con = slh8850_con;
    }

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public AtmDayMgxTabEnum getTabType() {
		return tabType;
	}

	public void setTabType(AtmDayMgxTabEnum tabType) {
		this.tabType = tabType;
	}

	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	public AtmDayTypeEnum getAtmtype() {
		return atmtype;
	}

	public void setAtmtype(AtmDayTypeEnum atmtype) {
		this.atmtype = atmtype;
	}

	public List<String> getChengdu() {
		return chengdu;
	}

	public void setChengdu(List<String> chengdu) {
		this.chengdu = chengdu;
	}

	public List<String> getGuangzhou() {
		return guangzhou;
	}

	public void setGuangzhou(List<String> guangzhou) {
		this.guangzhou = guangzhou;
	}

	public List<String> getShanghai() {
		return shanghai;
	}

	public void setShanghai(List<String> shanghai) {
		this.shanghai = shanghai;
	}

	public List<String> getShenyang() {
		return shenyang;
	}

	public void setShenyang(List<String> shenyang) {
		this.shenyang = shenyang;
	}

	public List<String> getXian() {
		return xian;
	}

	public void setXian(List<String> xian) {
		this.xian = xian;
	}

	public List<String> getWulumuqi() {
		return wulumuqi;
	}

	public void setWulumuqi(List<String> wulumuqi) {
		this.wulumuqi = wulumuqi;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
}
