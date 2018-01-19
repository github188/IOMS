package cn.com.atnc.ioms.model.publicnotice;

import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeColumnEnum;
import cn.com.atnc.ioms.enums.publicnotice.PnNoticeStatusEnum;
import cn.com.atnc.ioms.model.MyPaginModel;

/**
 * @author:lizhisheng
 * @date:2014-4-25 上午11:14:20
 * @version:1.0
 */
public class PublicNoticeQueryModel extends MyPaginModel{
	private String titleLike;//标题模糊查询
	private User user;//用户
	private PnNoticeColumnEnum pnNoticeColumnEnum;//栏目
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Calendar startTime;//操作信息
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Calendar endTime;
	private String userNameLike;
	private String startOptTime; //操作时间
	private String endOptTime; //操作时间
	 private String startCreateTime;   // 发布时间
	    private String endCreateTime;   // 发布时间
	    
	public String getStartCreateTime() {
			return startCreateTime;
		}
		public void setStartCreateTime(String startCreateTime) {
			this.startCreateTime = startCreateTime;
		}
		public String getEndCreateTime() {
			return endCreateTime;
		}
		public void setEndCreateTime(String endCreateTime) {
			this.endCreateTime = endCreateTime;
		}
	public String getStartOptTime() {
		return startOptTime;
	}
	public void setStartOptTime(String startOptTime) {
		this.startOptTime = startOptTime;
	}
	public String getEndOptTime() {
		return endOptTime;
	}
	public void setEndOptTime(String endOptTime) {
		this.endOptTime = endOptTime;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}
	public Calendar getEndTime() {
		return endTime;
	}
	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}
	public String getUserNameLike() {
		return userNameLike;
	}
	public void setUserNameLike(String userNameLike) {
		this.userNameLike = userNameLike;
	}
	public PnNoticeColumnEnum getPnNoticeColumnEnum() {
		return pnNoticeColumnEnum;
	}
	public void setPnNoticeColumnEnum(PnNoticeColumnEnum pnNoticeColumnEnum) {
		this.pnNoticeColumnEnum = pnNoticeColumnEnum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private PnNoticeColumnEnum columns;
	
	public PnNoticeColumnEnum getColumns() {
		return columns;
	}
	public void setColumns(PnNoticeColumnEnum columns) {
		this.columns = columns;
	}
	public String getTitleLike() {
		return titleLike;
	}
	public void setTitleLike(String titleLike) {
		this.titleLike = titleLike;
	}

	
	
}
