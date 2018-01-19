/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-12 下午3:15:02
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.acl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * 用户注册问题库实体
 * @author duanyanlin
 * @date 2016年4月13日上午10:46:16
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_CS_ACL_QUESTION")
public class Question extends StringUUIDEntity {

	public String answer;				//问题答案
	public String description;			//问题描述
	
	
	@Column(name = "ANSWER")
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}			
}
