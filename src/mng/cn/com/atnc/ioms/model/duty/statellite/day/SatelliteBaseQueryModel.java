package cn.com.atnc.ioms.model.duty.statellite.day;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * 卫星查询基础model
 *
 * @author 段衍林
 * @2017年2月13日 下午12:47:36
 */
public class SatelliteBaseQueryModel extends MyPaginModel {

	private String operator; // 操作人名称
	private String auditer; // 审核人
	private Date startTime; // 开始时间
	private Date endTime; // 结束时间
	private CheckCatagory checkType;// 巡检类型
	private SatelliteCheckContent content;// 巡检内容
	private String optType; // tab标签页
	private int index;

	public String getAuditer() {
		return auditer;
	}

	public void setAuditer(String auditer) {
		this.auditer = auditer;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public SatelliteCheckContent getContent() {
		return content;
	}

	public void setContent(SatelliteCheckContent content) {
		this.content = content;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
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

	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}
}
