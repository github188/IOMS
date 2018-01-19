package cn.com.atnc.ioms.enums.news;

public enum NewsStatusEnum {
    /*DRAFT("草稿"),
    DELET("删除"),
    DELETED("已删除"),
    INSERT("新增"),
    SUBMIT("提交"),
    SUBMITTED("已提交"),
    MODIFI("驳回修改"),
    MODIFIED("已修改"),
    FIRSTED("网控经理审批"),
    SECONDED("事业部领导审批"),
    PUBLISH("信息待发布"),
    PUBLISHED("信息已发布"),
    FIRSTDISSENT("网控经理驳回"),
    SECONDDISSENT("事业部领导驳回"),
    FIRSTPASSED("网控经理通过"),
    SECONDPASSED("事业部领导通过");*/
    
//  状态    
//  已提交     部门经理通过           事业部领导通过     已发布
//         部门经理驳回          事业部领导驳回      修改提交      已删除
    //操作状态
    DRAFT("草稿"),
    SUBMIT("提交通知公告"),
    SUBMITTED("已提交"),
    FIRSTPASSED("部门经理通过"),
    SECONDPASSED("事业部领导通过"),
    PUBLISHED("已发布"),
    FIRSTDISSENT("部门经理驳回"),
    SECONDDISSENT("事业部领导驳回"),
    MODIFIED("修改提交"),
    CDELETED("已删除"),
    DELETED("已删除"),
    
    //操作
    FIRST("部门经理审批"),
    SECOND("事业部领导审批"),
    PUBLISH("通知公告发布"),
    MODIFI("通知公告修改");
    
//  操作
//  部门经理审批，事业部领导审批，通知公告发布，通知公告修改
    
//  网控经理审批 
//  事业部领导审批
//  信息待发布
//  信息已发布
//
//  新增
//  提交
//  驳回修改
//
//  已提交
//  网控经理审批通过
//  网控经理审批驳回
//  驳回修改
    
    private String value;
    public String getValue(){
        return this.value;
    }
    private NewsStatusEnum(String value) {
        this.value = value;
    }
}
