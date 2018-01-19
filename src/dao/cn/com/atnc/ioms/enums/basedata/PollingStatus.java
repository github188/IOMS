/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-4-17 下午12:55:48
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;

/**
 * @author:HuangYijie
 * @date:2013-4-17 下午12:55:48
 * @version:1.0
 */

public enum PollingStatus {
	Settingup, // 正在启动
	Stopped, // 未轮询
	Running, // 已成功启动
	Pausing, // 暂停

	// NoPolling

}
