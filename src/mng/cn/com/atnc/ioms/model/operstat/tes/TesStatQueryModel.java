package cn.com.atnc.ioms.model.operstat.tes;

import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.model.MyPaginModel;

public class TesStatQueryModel extends MyPaginModel {
    // 起止时间
    private String startStatTime;
    private String endStatTime;
    private String optType;
    private String tesnode;
    private String cu;

    
    private String activeNodeCodeLike;
    private String passiveNodeCodeLike;
    private String circuitNameLike;// 被叫槽号

    private String activeNodeId;// 主叫机箱ID
    private String passiveNodeId;// 主叫机箱ID
    private TesNode activeNode;// 主叫机箱
    private TesNode passiveNode;// 被叫机箱
    private String activeNodeCode;// 主叫机箱号
    private String passiveNodeCode;// 被叫机箱号
    private String activeNodeSlot;//主叫槽号
    private String passiveNodeSlot;// 被叫槽号
    private String circuitName;// 电路名称
    private String rate;
    private boolean isValid;
    private String excludeId;
    
    public String getTesnode() {
        return tesnode;
    }
    public void setTesnode(String tesnode) {
        this.tesnode = tesnode;
    }
    public String getCu() {
        return cu;
    }
    public void setCu(String cu) {
        this.cu = cu;
    }
    public String getStartStatTime() {
        return startStatTime;
    }
    public void setStartStatTime(String startStatTime) {
        this.startStatTime = startStatTime;
    }
    public String getEndStatTime() {
        return endStatTime;
    }
    public void setEndStatTime(String endStatTime) {
        this.endStatTime = endStatTime;
    }
    public String getOptType() {
        return optType;
    }
    public void setOptType(String optType) {
        this.optType = optType;
    }
    public String getActiveNodeCodeLike() {
        return activeNodeCodeLike;
    }
    public void setActiveNodeCodeLike(String activeNodeCodeLike) {
        this.activeNodeCodeLike = activeNodeCodeLike;
    }
    public String getPassiveNodeCodeLike() {
        return passiveNodeCodeLike;
    }
    public void setPassiveNodeCodeLike(String passiveNodeCodeLike) {
        this.passiveNodeCodeLike = passiveNodeCodeLike;
    }
    public String getCircuitNameLike() {
        return circuitNameLike;
    }
    public void setCircuitNameLike(String circuitNameLike) {
        this.circuitNameLike = circuitNameLike;
    }
    public String getActiveNodeId() {
        return activeNodeId;
    }
    public void setActiveNodeId(String activeNodeId) {
        this.activeNodeId = activeNodeId;
    }
    public String getPassiveNodeId() {
        return passiveNodeId;
    }
    public void setPassiveNodeId(String passiveNodeId) {
        this.passiveNodeId = passiveNodeId;
    }
    public TesNode getActiveNode() {
        return activeNode;
    }
    public void setActiveNode(TesNode activeNode) {
        this.activeNode = activeNode;
    }
    public TesNode getPassiveNode() {
        return passiveNode;
    }
    public void setPassiveNode(TesNode passiveNode) {
        this.passiveNode = passiveNode;
    }
    public String getActiveNodeCode() {
        return activeNodeCode;
    }
    public void setActiveNodeCode(String activeNodeCode) {
        this.activeNodeCode = activeNodeCode;
    }
    public String getPassiveNodeCode() {
        return passiveNodeCode;
    }
    public void setPassiveNodeCode(String passiveNodeCode) {
        this.passiveNodeCode = passiveNodeCode;
    }
    public String getActiveNodeSlot() {
        return activeNodeSlot;
    }
    public void setActiveNodeSlot(String activeNodeSlot) {
        this.activeNodeSlot = activeNodeSlot;
    }
    public String getPassiveNodeSlot() {
        return passiveNodeSlot;
    }
    public void setPassiveNodeSlot(String passiveNodeSlot) {
        this.passiveNodeSlot = passiveNodeSlot;
    }
    public String getCircuitName() {
        return circuitName;
    }
    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }
    public boolean isValid() {
        return isValid;
    }
    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }
    public String getExcludeId() {
        return excludeId;
    }
    public void setExcludeId(String excludeId) {
        this.excludeId = excludeId;
    }
    
}
