package cn.com.atnc.ioms.model.duty.environment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.environment.EquipType;
import cn.com.atnc.ioms.enums.duty.environment.acc.SlhImosen;
import cn.com.atnc.ioms.enums.duty.environment.acc.SlhLbote;
import cn.com.atnc.ioms.enums.duty.environment.acc.TxjdAcc;
import cn.com.atnc.ioms.enums.duty.environment.dg.DgName;
import cn.com.atnc.ioms.enums.duty.environment.psot.DcPowerName;
import cn.com.atnc.ioms.enums.duty.environment.psot.DdnName;
import cn.com.atnc.ioms.enums.duty.environment.psot.NccName;
import cn.com.atnc.ioms.enums.duty.environment.psot.OticalName;
import cn.com.atnc.ioms.enums.duty.environment.psot.PdsName;
import cn.com.atnc.ioms.enums.duty.environment.psot.TxjdOticalName;
import cn.com.atnc.ioms.enums.duty.environment.psot.ZjOticalName;
import cn.com.atnc.ioms.enums.duty.environment.ups.KuUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.SlhUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.TxjdUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.ZjUpsName;
import cn.com.atnc.ioms.enums.duty.satellite.OutSideEquipType;
import cn.com.atnc.ioms.model.MyPaginModel;
/**
 * 环境设备巡检查询model
 * @author renyujuan
 * @date 2016年7月7日上午8:56:17
 */
public class EnvironmentCheckQueryModel extends MyPaginModel {
	//dyl add 
	private String id;				//记录id
	private int index;
	
	private String name;				//环境设备名称
	private String operator;			//操作人名称
	private Date checkDate;				//查询日期
	private Date startTime;			//查询起始时间
	private Date endTime;			//查询结束时间
	private String optType;				//tab页类型
	private CheckCatagory checkType;
	
	//dyl 添加
	private String equipName;
	
	/** 室外设备枚举 **/
	private OutSideEquipType checkEquip;
	private EquipType equipType;
	
	//设备名称
	/*十里河ups设备*/
    private List<String> slhUpsName;
    /*ku实验室设备名称*/
    private List<String> kuUpsName;
    private List<String> txjdList;
    private List<String> zjList;
    /*柴油发电机设备名称*/
    private List<String> dgList;
    /*空调设备名称*/
    private List<String> accList;
    private List<String> txjdAccList;
    private List<String> lbtAccList;
    /*传输设备及通讯线路*/
    private List<String> dcpList;
    private List<String> oticalList;
    private List<String> zjOticalList;
    private List<String> txjdOticalList;
    private List<String> ddnList;
    private List<String> nccList;
    private List<String> slhPdsList;
    private List<String> txjdPdsList;
    public List<String> getSlhUpsName() {
         if(ObjectUtils.equals(slhUpsName, null)) {
             slhUpsName = new ArrayList<String>();
             SlhUpsName[] names = SlhUpsName.values();
             for (SlhUpsName name : names) {
                 slhUpsName.add(name.getValue());
             }
         }
         return slhUpsName;
    }
	public List<String> getKuUpsName() {
        if(ObjectUtils.equals(kuUpsName, null)) {
            kuUpsName = new ArrayList<String>();
            KuUpsName[] names = KuUpsName.values();
            for (KuUpsName name : names) {
                kuUpsName.add(name.getValue());
            }
        }
        return kuUpsName;
    }
    public List<String> getTxjdList() {
        if(ObjectUtils.equals(txjdList, null)) {
            txjdList = new ArrayList<String>();
            TxjdUpsName[] txjdUpsNames = TxjdUpsName.values();
            for (TxjdUpsName name : txjdUpsNames) {
                txjdList.add(name.getValue());
            }
        }
        return txjdList;
    }
    public List<String> getZjList() {
        if(ObjectUtils.equals(zjList, null)) {
            zjList = new ArrayList<String>();
            ZjUpsName[] zjUpsNames = ZjUpsName.values();
            for (ZjUpsName name : zjUpsNames) {
                zjList.add(name.getValue());
            }
        }
        return zjList;
    }
    
    public List<String> getDgList() {
        if(ObjectUtils.equals(dgList, null)) {
            dgList = new ArrayList<String>();
            DgName[] dgName = DgName.values();
            for (DgName name : dgName) {
                dgList.add(name.getValue());
            }
        }
        return dgList;
    }
    public List<String> getAccList() {
        if(ObjectUtils.equals(accList, null)) {
            accList = new ArrayList<String>();
            SlhImosen[] slhImosen = SlhImosen.values();
            for (SlhImosen name : slhImosen) {
                accList.add(name.getValue());
            }
        }
        return accList;
    }
    public List<String> getLbtAccList() {
        if(ObjectUtils.equals(accList, null)) {
            lbtAccList = new ArrayList<String>();
            SlhLbote[] slhLbots = SlhLbote.values();
            for (SlhLbote name : slhLbots) {
                lbtAccList.add(name.getValue());
            }
        }
        return lbtAccList;
    }
    public List<String> getTxjdAccList() {
        if(ObjectUtils.equals(txjdAccList, null)) {
            txjdAccList = new ArrayList<String>();
            TxjdAcc[] txjdAcc = TxjdAcc.values();
            for (TxjdAcc name : txjdAcc) {
                txjdAccList.add(name.getValue());
            }
        }
        return txjdAccList;
    }
    public List<String> getDcpList() {
        if(ObjectUtils.equals(dcpList, null)) {
            dcpList = new ArrayList<String>();
            DcPowerName[] dcpNames = DcPowerName.values();
            for(DcPowerName name : dcpNames) {
                dcpList.add(name.getValue());
            }
        }
        return dcpList;
    }
    public List<String> getOticalList() {
        if(ObjectUtils.equals(oticalList, null)) {
            oticalList = new ArrayList<String>();
            OticalName[] oticalNames = OticalName.values();
            for(OticalName name : oticalNames) {
                oticalList.add(name.getValue());
            }
        }
        return oticalList;
    }
    public List<String> getZjOticalList() {
        if(ObjectUtils.equals(zjOticalList, null)) {
            zjOticalList = new ArrayList<String>();
            ZjOticalName[] zjOticalNames = ZjOticalName.values();
            for(ZjOticalName name : zjOticalNames) {
                zjOticalList.add(name.getValue());
            }
        }
        return zjOticalList;
    }
    public List<String> getTxjdOticalList() {
        if(ObjectUtils.equals(txjdOticalList, null)) {
            txjdOticalList = new ArrayList<String>();
            TxjdOticalName[] txjdOticalNames = TxjdOticalName.values();
            for(TxjdOticalName name : txjdOticalNames) {
                txjdOticalList.add(name.getValue());
            }
        }
        return txjdOticalList;
    }
    public List<String> getDdnList() {
        if(ObjectUtils.equals(ddnList, null)) {
            ddnList = new ArrayList<String>();
            DdnName[] ddnNames = DdnName.values();
            for(DdnName name : ddnNames) {
                ddnList.add(name.getValue());
            }
        }
        return ddnList;
    }
    public List<String> getNccList() {
        if(ObjectUtils.equals(nccList, null)) {
            nccList = new ArrayList<String>();
            NccName[] nccNames = NccName.values();
            for(NccName name : nccNames) {
                nccList.add(name.getValue());
            }
        }
        return nccList;
    }
    public List<String> getSlhPdsList() {
        if(ObjectUtils.equals(slhPdsList, null)) {
            slhPdsList = new ArrayList<String>();
            PdsName[] pdsNames = PdsName.values();
            for(PdsName name : pdsNames) {
                if(name.getValue().equalsIgnoreCase("十里河楼内综合布线")) {
                    slhPdsList.add(name.getValue());
                }
            }
        }
        return slhPdsList;
    }
    public List<String> getTxjdPdsList() {
        if(ObjectUtils.equals(txjdPdsList, null)) {
            txjdPdsList = new ArrayList<String>();
            PdsName[] pdsNames = PdsName.values();
            for(PdsName name : pdsNames) {
                if(name.getValue().equalsIgnoreCase("通信基地楼内综合布线")) {
                    txjdPdsList.add(name.getValue());
                }
            }
        }
        return txjdPdsList;
    }
    
    public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	public EquipType getEquipType() {
		return equipType;
	}

	public void setEquipType(EquipType equipType) {
		this.equipType = equipType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
	public String getOptType() {
		return optType;
	}
	@DateTimeFormat(iso=ISO.DATE)
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public OutSideEquipType getCheckEquip() {
		return checkEquip;
	}
	public void setCheckEquip(OutSideEquipType checkEquip) {
		this.checkEquip = checkEquip;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
}
