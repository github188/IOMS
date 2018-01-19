package cn.com.atnc.ioms.model.duty.telegraphduty;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.model.MyPaginModel;


/**
 * 转报系统检查查询MODEL
 * @author WangLingbin
 * @date 2016年1月8日 上午10:50:54
 * @since 1.0.0
 */
public class TeleGraphSystemQueryModel extends MyPaginModel {

	private String creater;		//创建人
	private String auditer;		//审核人
	private Calendar fromCreateTime;                //申请开始时间
	private Calendar toCreateTime;				   //申请结束时间
	
    private String optType;			//tab页类型
	
	public String getCreater() {
		return creater;
	}
	public void setCreater(String creater) {
		this.creater = creater;
	}
	public String getAuditer() {
		return auditer;
	}
	public void setAuditer(String auditer) {
		this.auditer = auditer;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Calendar getFromCreateTime() {
		return fromCreateTime;
	}
	public void setFromCreateTime(Calendar fromCreateTime) {
		this.fromCreateTime = fromCreateTime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Calendar getToCreateTime() {
		return toCreateTime;
	}
	public void setToCreateTime(Calendar toCreateTime) {
		this.toCreateTime = toCreateTime;
	}
	
	public String getOptType() {
		return optType;
	}
	public void setOptType(String optType) {
		this.optType = optType;
	}
	
}
