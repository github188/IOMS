package cn.com.atnc.ioms.model.clientmng;

import cn.com.atnc.ioms.entity.clientmng.ClientQuestion;

/**
 * 用户注册回答问题
 * @author duanyanlin
 * @date 2016年4月14日下午12:17:34
 */
@SuppressWarnings("serial")
public class ClientQuestionForm extends ClientQuestion {
	
	private String answer1;
	private String answer2;
	private String answer3;
	private String questionId1;
	private String questionId2;
	private String questionId3;
	private String description1;
	private String description2;
	private String description3;
	private Integer size;			//问题数量
	
	
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getDescription1() {
		return description1;
	}
	public void setDescription1(String description1) {
		this.description1 = description1;
	}
	public String getDescription2() {
		return description2;
	}
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	public String getDescription3() {
		return description3;
	}
	public void setDescription3(String description3) {
		this.description3 = description3;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getQuestionId1() {
		return questionId1;
	}
	public void setQuestionId1(String questionId1) {
		this.questionId1 = questionId1;
	}
	public String getQuestionId2() {
		return questionId2;
	}
	public void setQuestionId2(String questionId2) {
		this.questionId2 = questionId2;
	}
	public String getQuestionId3() {
		return questionId3;
	}
	public void setQuestionId3(String questionId3) {
		this.questionId3 = questionId3;
	}
}
