package cn.com.atnc.ioms.model.faultmng;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.business.evaluate.GradeEnum;

/**
 * 事件评价model
 *
 * @author 段衍林
 * @2016年11月9日 下午4:16:29
 */
public class FaultEvaluateModel extends BaseModel {
	private String faultId;								//故障单ID
	private GradeEnum evaluate;							//事件单评价
	private String remark;								//评价备注
	private User user;									//评价人
	
	public String getFaultId() {
		return faultId;
	}
	public void setFaultId(String faultId) {
		this.faultId = faultId;
	}
	public GradeEnum getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(GradeEnum evaluate) {
		this.evaluate = evaluate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}