/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 下午1:20:33
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model;

/**
 * @author:HuangYijie
 * @date:2014-4-17 下午1:20:33
 * @version:1.0
 */

public class SysFinals {
	public static String tesTxPowerStandard = "tesTxPowerStandard";// 发射功率标准

	public static String kuRxLevelTopLimit = "kuRxLevelTopLimit";// rx level 上限

	public static String kuRxLevelLowerLimit = "kuRxLevelLowerLimit";// rxlevel下限

	public static String kuEbNoTopLimit = "kuEbNoTopLimit"; // ebno标准值

	public static String kuNetworkStatusStandard = "kuNetworkStatusStandard"; // ebno标准值

	public static String clientNoticeType = "clientNoticeType";// 客户通报类型

	public static String tempCircuitNotice = "tempCircuitNotice";// 临时电路逾期提醒（天）

	public static String techConsultClose = "techConsultClose";// 技术支持关闭时间（小时）

	public static String ebno = "Eb/N0";
	public static String rxLevel = "RxLvl";
	public static String networkStatus = "Status";

	public static String COMMA = ",";

	public static String SEPARATE = "、";

	public static String DIVIDE = ";";

	public static int tempcircuitUpcoming = 10;// 临时电路即将到期天数判定

	public static int tempcircuitExpire = 0;// 临时电路到期天数判定
	
	public static String busiStatTopLimit = "busiStatTopLimit";  //业务通断上限
	
	public static String busiStatLowerLimit = "busiStatLowerLimit";  //业务通断下限
	
	public static String ftpLinkAlarmMin = "ftpLinkAlarmMin";  //站点告警时间限制（分钟）

	public static String YES = "yes";		//属性yes常量
	
	public static String NO = "no";			//属性no常量
}
