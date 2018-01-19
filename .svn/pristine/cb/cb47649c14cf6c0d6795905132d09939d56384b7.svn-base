/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:15:09
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity;

import java.io.IOException;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * 自动生成UUID基础entity类，覆写toString()
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:15:09
 */
public class MyStringUUIDEntity extends StringUUIDEntity {
	private static final long serialVersionUID = 1838860829268536784L;

	public String toString() {
		try {
			return super.toJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return this.toString();
		}
	}
}
