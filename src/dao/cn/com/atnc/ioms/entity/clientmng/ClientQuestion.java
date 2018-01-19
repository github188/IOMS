/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-12 下午3:15:02
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.clientmng;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * 用户问题绑定
 * @author duanyanlin
 * @date 2016年4月13日上午10:53:09
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_CS_ACL_CLIENT_QUESTION")
public class ClientQuestion extends StringUUIDEntity {

	public String questionId;				//问题编号
	public String answer;					//问题回答
	public String clientId;					//问题描述
	public Calendar createDate;				//回答问题时间
	
	@Column(name = "QUESTIONID")
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	
	@Column(name = "ANSWER")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Cascade(value = CascadeType.DELETE)
	@Column(name = "CLIENTID")
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	@Column(name = "CREATE_DATE")
	public Calendar getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Calendar createDate) {
		this.createDate = createDate;
	}
}
