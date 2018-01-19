/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:17:38
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity;

import java.io.IOException;

import cn.com.atnc.common.entity.BaseEntity;

/**
 * 基础entity类，覆写toString()
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午2:17:38
 */
public class MyBaseEntity extends BaseEntity {

	private static final long serialVersionUID = -1029846444766533249L;

	public String toString() {
		try {
			return super.toJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return this.toString();
		}
	}
}
