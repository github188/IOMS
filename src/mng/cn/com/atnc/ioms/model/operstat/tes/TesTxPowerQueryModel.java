package cn.com.atnc.ioms.model.operstat.tes;

import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerStat;
import cn.com.atnc.ioms.model.MyPaginModel;

public class TesTxPowerQueryModel extends MyPaginModel {
 // 起止时间
    private String startRecordTime;
    private String endRecordTime;
    
    private String statid;
    private String bureau;
    
    private TesTxPowerStat stat;

    private String optType;
    
    private String tesNode;// 机箱号
    private String tesSlot;// 槽位号
    
    
    public String getTesNode() {
        return tesNode;
    }

    public void setTesNode(String tesNode) {
        this.tesNode = tesNode;
    }

    public String getTesSlot() {
        return tesSlot;
    }

    public void setTesSlot(String tesSlot) {
        this.tesSlot = tesSlot;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getStatid() {
        return statid;
    }

    public void setStatid(String statid) {
        this.statid = statid;
    }

    public String getStartRecordTime() {
        return startRecordTime;
    }

    public void setStartRecordTime(String startRecordTime) {
        this.startRecordTime = startRecordTime;
    }

    public String getEndRecordTime() {
        return endRecordTime;
    }

    public void setEndRecordTime(String endRecordTime) {
        this.endRecordTime = endRecordTime;
    }

    public TesTxPowerStat getStat() {
        return stat;
    }

    public void setStat(TesTxPowerStat stat) {
        this.stat = stat;
    }

	public String getBureau() {
		return bureau;
	}

	public void setBureau(String bureau) {
		this.bureau = bureau;
	}
}
