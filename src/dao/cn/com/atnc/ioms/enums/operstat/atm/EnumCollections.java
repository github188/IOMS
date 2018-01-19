/* Copyright  2010 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Sep 27, 2010 11:12:41 AM
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */
package cn.com.atnc.ioms.enums.operstat.atm;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.annotate.JsonValue;

/**
 * 枚举类集合
 * 
 * @author wangpeng
 * @date:Sep 25, 2010 2:02:40 PM
 * @version 1.0
 */
public class EnumCollections {

	/**
	 * 交换机节点等级
	 * 
	 * @author wangpeng
	 * @date:2011-7-20 下午01:46:40
	 * @version 1.0
	 */
	public enum NodeLevel {
		CORE("核心"), FIRST("一级"), SECOND("二级"), THIRD("三级"), TEST("实验");
		private String value;

		NodeLevel(String value) {
			this.value = value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static NodeLevel getNodeLevelByOrdinal(int value) {
			for (NodeLevel type : NodeLevel.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static NodeLevel getNodeLevelByValue(String value) {
			for (NodeLevel type : NodeLevel.values()) {
				if (StringUtils.equals(type.value, value)) {
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	/**
	 * 配置信息类型
	 * 
	 * @author wangpeng
	 * @date:Mar 14, 2011 10:34:26 AM
	 * @version 1.0
	 */
	public enum ConfigInfoType {
		ATM("交换机配置信息"), PNNI("中继配置信息");
		private String value;

		ConfigInfoType(String value) {
			this.value = value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static ConfigInfoType getCofigInfoTypeByOrdinal(int value) {
			for (ConfigInfoType type : ConfigInfoType.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static ConfigInfoType getCofigInfoTypeByValue(String value) {
			for (ConfigInfoType type : ConfigInfoType.values()) {
				if (StringUtils.equals(type.value, value)) {
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	/**
	 * 是否告警
	 * 
	 * @author wangpeng
	 * @date:Mar 14, 2011 12:52:21 PM
	 * @version 1.0
	 */
	public enum IsAlarm {
		NotAlarm("正常"), Alarm("告警");
		private final String value;

		IsAlarm(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static IsAlarm getIsAlarmByOrdinal(int value) {
			for (IsAlarm type : IsAlarm.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static IsAlarm getIsAlarmTypeByValue(String value) {
			for (IsAlarm type : IsAlarm.values()) {
				if (StringUtils.equals(type.value, value)) {
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	/**
	 * 
	 * 定义用户是否被锁定
	 * 
	 * @author wangpeng
	 * @version 1.0
	 * @Date Jul 24, 2009 1:18:35 PM
	 */
	public enum Disabled {
		NotDisabled("激活"), IsDisabled("锁定");
		private final String value;

		Disabled(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * ATM交换机运行信息告警类别
	 * 
	 * @author wangpeng
	 * @date:Mar 15, 2011 10:23:07 AM
	 * @version 1.0
	 */
	public enum ATMRunInfoType {
		Clock("时钟告警"), Switching("交换告警"), Environment("环境告警"), Card("板卡告警"), NodeLicense(
				"License告警");
		private String value;

		ATMRunInfoType(String value) {
			this.value = value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static ATMRunInfoType getATMRunInfoTypeByOrdinal(int value) {
			for (ATMRunInfoType type : ATMRunInfoType.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static ATMRunInfoType getATMRunInfoTypeByValue(String value) {
			for (ATMRunInfoType type : ATMRunInfoType.values()) {
				if (StringUtils.equals(type.value, value)) {
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return value;
		}

		@JsonValue
		public EnumModel toEnumModel() {
			EnumModel em = new EnumModel();
			em.setName(this.name());
			em.setOrdinal(this.ordinal());
			em.setValue(this.getValue());

			return em;
		}
	}

	/**
	 * ATM交换机板卡运行信息告警类别
	 * 
	 * @author wangpeng
	 * @date:Mar 15, 2011 10:23:07 AM
	 * @version 1.0
	 */
	public enum ATMCardRunInfoType {
		HardwareAlarm("Hardware Alarm"), CardStateAlarm("Card State Alarm"), DiskAlarm(
				"Disk Alarm"), DiagAlarm("Diag Alarm"), ImaAlarm("IMA Alarm"), ResourceAlarm(
				"Resource Alarm"), SRMAlarm("SRM Alarm"), LineAlarm(
				"Line Alarm"), PortAlarm("Port Alarm"), PathAlarm("Path Alarm"), LMIAlarm(
				"LMI Alarm"), ChannelAlarm("Channel Alarm"), SARAlarm(
				"SAR Alarm");
		private String value;

		ATMCardRunInfoType(String value) {
			this.value = value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static ATMCardRunInfoType getATMCardRunInfoTypeByOrdinal(
				int value) {
			for (ATMCardRunInfoType type : ATMCardRunInfoType.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static ATMCardRunInfoType getATMCardRunInfoTypeByValue(
				String value) {
			for (ATMCardRunInfoType type : ATMCardRunInfoType.values()) {
				if (StringUtils.equals(type.value, value)) {
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return value;
		}

		@JsonValue
		public EnumModel toEnumModel() {
			EnumModel em = new EnumModel();
			em.setName(this.name());
			em.setOrdinal(this.ordinal());
			em.setValue(this.getValue());

			return em;
		}
	}

	/**
	 * 交换机板块类型
	 * 
	 * @author wangpeng
	 * @date:2011-7-20 下午01:46:40
	 * @version 1.0
	 */
	public enum CardType {
		AXSM("AXSM"), AXSME("AXSME"), AXSMXG("AXSMXG"), CESM("CESM"), MPSMATM(
				"MPSMATM"), MPSMFR("MPSMFR"), PXM("PXM"), FRSM("FRSM"), NA("NA");
		private String value;

		CardType(String value) {
			this.value = value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static CardType getCardTypeByOrdinal(int value) {
			for (CardType type : CardType.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static CardType getCardTypeByValue(String value) {
			for (CardType type : CardType.values()) {
				if (StringUtils.equals(type.value, value)) {
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	/**
	 * Trigger运行状态
	 * 
	 * @author wangpeng
	 * @date:Mar 15, 2011 10:23:07 AM
	 * @version 1.0
	 */
	public enum TriggerState {
		STATE_NONE("无状态", -1), STATE_NORMAL("正常", 0), STATE_PAUSED("暂停", 1), STATE_COMPLETE(
				"完成", 2), STATE_ERROR("错误", 3), STATE_BLOCKED("阻塞", 4);

		private String value;
		private int ordinal;

		TriggerState(String value, int ordinal) {
			this.value = value;
			this.ordinal = ordinal;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getOrdinal() {
			return ordinal;
		}

		public void setOrdinal(int ordinal) {
			this.ordinal = ordinal;
		}

		public static TriggerState getTriggerStateByOrdinal(int value) {
			for (TriggerState type : TriggerState.values()) {
				if (type.getOrdinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static TriggerState getTriggerStateByValue(String value) {
			for (TriggerState type : TriggerState.values()) {
				if (StringUtils.equals(type.getValue(), value)) {
					return type;
				}
			}
			return null;
		}

		@JsonValue
		public EnumModel toEnumModel() {
			EnumModel em = new EnumModel();
			em.setName(this.name());
			em.setOrdinal(this.ordinal());
			em.setValue(this.getValue());

			return em;
		}
	}

	/**
	 * Schedule运行状态
	 * 
	 * @author wangpeng
	 * @date:Mar 15, 2011 10:23:07 AM
	 * @version 1.0
	 */
	public enum ScheduleState {
		STATE_START("启动"), STATE_STOP("停止"), STATE_PAUSED("暂停"), STATE_ERROR(
				"错误");
		private String value;

		ScheduleState(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public static ScheduleState getScheduleStateByOrdinal(int value) {
			for (ScheduleState type : ScheduleState.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static ScheduleState getScheduleStateByValue(String value) {
			for (ScheduleState type : ScheduleState.values()) {
				if (StringUtils.equals(type.getValue(), value)) {
					return type;
				}
			}
			return null;
		}

		@JsonValue
		public EnumModel toEnumModel() {
			EnumModel em = new EnumModel();
			em.setName(this.name());
			em.setOrdinal(this.ordinal());
			em.setValue(this.getValue());

			return em;
		}
	}

	/**
	 * ServiceRouteAlarmType运行状态
	 * 
	 * @author wangpeng
	 * @date:Mar 15, 2011 10:23:07 AM
	 * @version 1.0
	 */
	public enum ServiceRouteAlarmType {
		ROUTE_NORMAL("正常"), ROUTE_UNCONNECTION("连接未建立"), ROUTE_CHANGE("路由变化");
		private String value;

		ServiceRouteAlarmType(String value) {
			this.value = value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public static ServiceRouteAlarmType getServiceRouteAlarmTypeByOrdinal(
				int value) {
			for (ServiceRouteAlarmType type : ServiceRouteAlarmType.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static ServiceRouteAlarmType getServiceRouteAlarmTypeByValue(
				String value) {
			for (ServiceRouteAlarmType type : ServiceRouteAlarmType.values()) {
				if (StringUtils.equals(type.value, value)) {
					return type;
				}
			}
			return null;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	/**
	 * 
	 * @author：KuYonggang
	 * @date：2014-8-25下午3:02:43
	 * @version：1.0
	 */
	public enum LnsType {
		AXSMT1E1("AXSMT1E1"), AXSMOC3("AXSMOC3"), AXSMXG("AXSMXG"), AXSMT3E3(
				"AXSMT3E3"), PXM155("PXM155"), PXMT1E1("PXMT1E1"), FRSM("FRSM"), CESM(
				"CESM"), MPSM("MPSM"), MPSMFRM("MPSMFRM");

		private String value;

		LnsType(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public static LnsType getLnsTypeByOrdinal(int value) {
			for (LnsType type : LnsType.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static LnsType getLnsTypeByValue(String value) {
			for (LnsType type : LnsType.values()) {
				if (StringUtils.equals(type.getValue(), value)) {
					return type;
				}
			}
			return null;
		}

		@JsonValue
		public EnumModel toEnumModel() {
			EnumModel em = new EnumModel();
			em.setName(this.name());
			em.setOrdinal(this.ordinal());
			em.setValue(this.getValue());

			return em;
		}
	}

	/**
	 * 
	 * @author：KuYonggang
	 * @date：2014-8-25下午3:02:43
	 * @version：1.0
	 */
	public enum LnsTypeDetail {
		AXSM32T1E1E("AXSM-32-T1E1-E"), AXSM16OC3B("AXSM_16OC3_B"), AXSM16155XG(
				"AXSM-16-155-XG"), AXSME16T3E3("AXSME_16T3E3"), PXM1E8155(
				"PXM1E-8-155"), PXM1E16T1E1("PXM1E-16-T1E1"), FRSMHS2B12IN1(
				"FRSM_HS2/B_12IN1"), FRSMHS2B12INNONE("FRSM_HS2/B_12INNONE"), FRSMHS2BHSSI(
				"FRSM_HS2/B_HSSI"), CESM8E1("CESM_8E1"), MPSM8E1FRM(
				"MPSM_8E1_FRM"), MPSM16T1E1("MPSM-16-T1E1"), MPSM8E1CES(
				"MPSM_8E1_CES"), MPSM8E1ATM("MPSM_8E1_ATM");

		private String value;

		LnsTypeDetail(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public static LnsTypeDetail getLnsTypeDetailByOrdinal(int value) {
			for (LnsTypeDetail type : LnsTypeDetail.values()) {
				if (type.ordinal() == value) {
					return type;
				}
			}
			return null;
		}

		public static LnsTypeDetail getLnsTypeDetailByValue(String value) {
			for (LnsTypeDetail type : LnsTypeDetail.values()) {
				if (StringUtils.equals(type.getValue(), value)) {
					return type;
				}
			}
			return null;
		}

		@JsonValue
		public EnumModel toEnumModel() {
			EnumModel em = new EnumModel();
			em.setName(this.name());
			em.setOrdinal(this.ordinal());
			em.setValue(this.getValue());

			return em;
		}
	}

	/**
	 * 属性数据类型
	 * 
	 * @author wangpeng
	 * @date:Mar 31, 2011 2:27:55 PM
	 * @version 1.0
	 */
	public enum PropertyType {
		S(String.class), I(Integer.class), L(Long.class), N(Double.class), D(
				Date.class), B(Boolean.class), E(Enum.class);
		;

		private final Class<?> clazz;

		private PropertyType(Class<?> clazz) {
			this.clazz = clazz;
		}

		public Class<?> getValue() {
			return clazz;
		}
	}

	public static Object getEnumByValue(String value) {
		for (ATMRunInfoType type : ATMRunInfoType.values()) {
			if (StringUtils.equals(type.value, value)) {
				return type;
			}
		}
		for (ConfigInfoType type : ConfigInfoType.values()) {
			if (StringUtils.equals(type.value, value)) {
				return type;
			}
		}
		for (IsAlarm alarm : IsAlarm.values()) {
			if (StringUtils.equals(alarm.value, value)) {
				return alarm;
			}
		}
		for (ATMCardRunInfoType type : ATMCardRunInfoType.values()) {
			if (StringUtils.equals(type.value, value)) {
				return type;
			}
		}
		for (ServiceRouteAlarmType type : ServiceRouteAlarmType.values()) {
			if (StringUtils.equals(type.value, value)) {
				return type;
			}
		}
		return null;
	}
}
