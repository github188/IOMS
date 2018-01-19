/**
 * @ProjectName PCSP
 * @FileName DateUtil.java
 * @PackageName:cn.com.atnc.pcsp.util
 * @author WangLingbin
 * @date 2015年5月20日下午3:50:04
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.jasperreports.engine.util.ObjectUtils;

/**
 * 日期工具类
 * 
 * @author WangLingbin
 * @date 2015年5月20日 下午3:50:04
 * @since 1.0.0
 */
public class DateUtilTools {

	public static final String PATTERN_DATE_1 = "yyyy-MM-dd";
	public static final String PATTERN_DATE_2 = "HH:mm:ss";
	public static final String PATTERN_DATE_3 = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_DATE_4 = "yyyy-MM";
	public static final String PATTERN_DATE_5 = "yyyyMM";
	public static final String PATTERN_DATE_6 = "yyyy";

	private DateUtilTools() {
	}

	/**
	 * 将日期类型格式化为指定日期格式的日期字符串
	 * 
	 * @param date
	 * @return ****年**月**日
	 * @author WangLingbin
	 * @date 2015年11月25日下午1:16:28
	 * @since 1.0.0
	 */
	public static String format(Date date) {
		String formatDate = DateUtilTools.format(date, PATTERN_DATE_1);
		String[] dates = formatDate.split("\\-");
		if (ObjectUtils.equals(dates, null)) {
			return formatDate;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(dates[0]).append("年").append(dates[1]).append("月")
				.append(dates[2]).append("日");
		return sb.toString();
	}

	/**
	 * 将日期字符串格式化为指定日期格式的日期类型
	 *
	 * @param dateString
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return Date 日期类型
	 * @author ATNC
	 * @date 2015年1月6日下午4:34:14
	 * @since 1.0.0
	 */
	public static Date parseDate(String dateString, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(dateString);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 将日期类型格式化为指定日期格式的日期字符串
	 *
	 * @param date
	 *            日期类型
	 * @param pattern
	 *            日期格式
	 * @return String 日期字符串
	 * @author ATNC
	 * @date 2015年1月6日下午4:35:11
	 * @since 1.0.0
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 得到当前系统时间字符串 格式：yyyy-MM-dd HH:mm:ss
	 * 
	 * @return String 日期字符串
	 * @author KuYonggang
	 * @date 2015年1月6日下午4:31:29
	 * @since 1.0.0
	 */
	public static String getCurrentDate() {
		return format(new Date(), DateUtilTools.PATTERN_DATE_3);
	}

	/**
	 * 返回日期类型字符串 yyyy-MM-dd
	 * 
	 * @author 段衍林
	 * @2016年11月30日 上午8:54:32
	 * @return String
	 */
	public static String getNowDateStr() {
		return format(new Date(), DateUtilTools.PATTERN_DATE_1);
	}

	/**
	 * 得到指定格式的当前系统时间对象类型 格式：yyyy-MM-dd HH:mm:ss
	 *
	 * @return Date 日期类型
	 * @author ATNC
	 * @date 2015年1月6日下午4:30:58
	 * @since 1.0.0
	 */
	public static Date getNowDateTime() {
		return DateUtilTools.parseDate(getCurrentDate(), PATTERN_DATE_3);
	}

	/**
	 * 得到指定格式的当前系统时间对象类型 格式：yyyy-MM-dd
	 *
	 * @return Date 日期类型
	 * @author ATNC
	 * @date 2015年1月6日下午4:30:08
	 * @since 1.0.0
	 */
	public static Date getNowDate() {
		return DateUtilTools.parseDate(getCurrentDate(),
				DateUtilTools.PATTERN_DATE_1);
	}

	/**
	 * 得到指定格式的当前系统年月字符串 格式：yyyy-MM
	 *
	 * @return String 日期字符串
	 * @author ATNC
	 * @date 2015年1月6日下午4:30:08
	 * @since 1.0.0
	 */
	public static String getNowYearMonthStr() {
		return format(new Date(), DateUtilTools.PATTERN_DATE_4);
	}

	/**
	 * 
	 * 得到指定格式的当前系统年份字符串 格式：yyyy
	 *
	 * @return String 日期字符串
	 * @author ATNC
	 * @date 2015年1月21日上午9:41:09
	 * @since 1.0.0
	 */
	public static String getNowYearStr() {
		return format(new Date(), DateUtilTools.PATTERN_DATE_6);
	}
}
