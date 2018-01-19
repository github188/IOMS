/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-29 下午8:02:40
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.systemmng.param;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.atnc.common.entity.BaseEntity;

/**
 * @author:HuangYijie
 * @date:2014-4-29 下午8:02:40
 * @version:1.0
 */
@Entity
@Table(name = "TB_OM_SYSTEM_CONFIG")
public class SystemConfig extends BaseEntity {

	private static final long serialVersionUID = -3155897373648526914L;
	private String key;
	private String value;

	public SystemConfig() {

	}

	public SystemConfig(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Id
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
