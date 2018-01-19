/**
 * 
 */
package cn.com.atnc.ioms.model.techsupport.fault;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.common.model.TimePaginModel;
import cn.com.atnc.ioms.enums.techsupport.fault.DeclareType;
import cn.com.atnc.ioms.enums.techsupport.fault.AllStatus;
import cn.com.atnc.ioms.enums.techsupport.fault.FaultType;

/**
 * 类说明：故障申报记录查询Model
 * 
 * @author：KuYonggang
 * @date：2014-4-28下午8:14:56
 * @version：1.0
 */
public class FaultDeclareRecordQueryModel extends TimePaginModel {
	
	private FaultType faultType;       //精确匹配咨询类型
	private List<AllStatus> statusList; //精确匹配状态集合
	private AllStatus status;        //精确匹配状态
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fromConsultDate;    //精确匹配咨询时间始
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date toConsultDate;      //精确匹配咨询时间至
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date fromOptDate;        //精确匹配处理时间始
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date toOptDate;          //精确匹配处理时间至
	private DeclareType declareType;   //精确匹配申报类型
	private String optClientLike;      //模糊匹配咨询人员姓名
	private String optUserLike;        //模糊匹配处理人员
	
	public FaultType getFaultType() {
		return faultType;
	}
	public void setFaultType(FaultType faultType) {
		this.faultType = faultType;
	}
	public AllStatus getStatus() {
		return status;
	}
	public void setStatus(AllStatus status) {
		this.status = status;
	}
	public Date getFromConsultDate() {
		return fromConsultDate;
	}
	public void setFromConsultDate(Date fromConsultDate) {
		this.fromConsultDate = fromConsultDate;
	}
	public Date getToConsultDate() {
		return toConsultDate;
	}
	public void setToConsultDate(Date toConsultDate) {
		this.toConsultDate = toConsultDate;
	}
	public Date getFromOptDate() {
		return fromOptDate;
	}
	public void setFromOptDate(Date fromOptDate) {
		this.fromOptDate = fromOptDate;
	}
	public Date getToOptDate() {
		return toOptDate;
	}
	public void setToOptDate(Date toOptDate) {
		this.toOptDate = toOptDate;
	}
	public String getOptClientLike() {
		return optClientLike;
	}
	public void setOptClientLike(String optClientLike) {
		this.optClientLike = optClientLike;
	}
	public String getOptUserLike() {
		return optUserLike;
	}
	public void setOptUserLike(String optUserLike) {
		this.optUserLike = optUserLike;
	}
	public DeclareType getDeclareType() {
		return declareType;
	}
	public void setDeclareType(DeclareType declareType) {
		this.declareType = declareType;
	}
	public List<AllStatus> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<AllStatus> statusList) {
		this.statusList = statusList;
	}
	
}
