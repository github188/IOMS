package cn.com.atnc.ioms.entity.operstat.tes;

import cn.com.atnc.ioms.enums.basedata.Bureau;


public class TesStat {
    // 统计一个时间段内的正常总数，异常总数。
    /*select equ.ID,equ.NAME,SUM(stat.OVER),SUM(stat.STANDARD),SUM(stat.NORMAL) from tb_bd_equip equ 
    inner join TB_BD_TES_NODE node on equ.ID=node.EQUIP_ID
    inner join TB_BD_TES_SLOT slot on slot.TES_NODE_ID = node.ID
    inner join TB_BD_TES_TXPOWER txpower on slot.ID= txpower.TES_SLOT_ID
    inner join TB_BD_TES_TXPOWER_STAT stat on txpower.TES_STAT_ID=stat.ID
    where stat.STAT_DATE BETWEEN TO_DATE('01/04/04', 'DD/MM/YY') and TO_DATE('01/05/04', 'DD/MM/YY')
    group by equ.ID,equ.NAME*/
    
    // 统计正常和不正常的数据
    /*select equip.CODE,node.CHASSIS,slot.CU,nvl(tp.POWER,'正常'),slot.INFO from TB_BD_TES_SLOT slot 
    left OUTER join TB_BD_TES_TXPOWER tp on slot.ID = tp.TES_SLOT_ID
    inner join TB_BD_TES_TXPOWER_STAT stat on stat.ID = tp.TES_STAT_ID
    inner join TB_BD_TES_NODE node on node.ID= slot.TES_NODE_ID
    inner join TB_BD_EQUIP equip on equip.ID=node.EQUIP_ID
    where stat.ID='e8a959f1295e4b6f8a97b8edc639c8a6'*/
    private String code;
    private String chassis;
    private String cu;
    private String power;
    private String info;
    private String model;
    private Bureau bureau;
    
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getChassis() {
        return chassis;
    }
    public void setChassis(String chassis) {
        this.chassis = chassis;
    }
    public String getCu() {
        return cu;
    }
    public void setCu(String cu) {
        this.cu = cu;
    }
    public String getPower() {
        return power;
    }
    public void setPower(String power) {
        this.power = power;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
	public Bureau getBureau() {
		return bureau;
	}
	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}
    
    
}
