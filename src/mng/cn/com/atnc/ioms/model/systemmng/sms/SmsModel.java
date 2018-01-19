/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-6-17 下午4:12:26
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.systemmng.sms;

import cn.com.atnc.common.model.BaseModel;

/**
 * @author:HuangYijie
 * @date:2014-6-17 下午4:12:26
 * @version:1.0
 */

public class SmsModel extends BaseModel {
	private String mobile;
	private String content;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
