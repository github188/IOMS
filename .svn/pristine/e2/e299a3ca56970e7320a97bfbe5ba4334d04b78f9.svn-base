package cn.com.atnc.ioms.util;

import java.util.Calendar;

/**
 * 
 * 类说明：CalendarUtils
 * 
 * @author: 局域网_王鹏
 * @time: 2014年5月20日下午2:31:24
 * @version:1.0
 */
public class CalendarTools {
	public static long milOfDay = 24 * 60 * 60 * 1000;

	/**
	 * 
	 * 方法说明：计算两个日期相差天数
	 * 
	 * @author 局域网_王鹏
	 * @date：2014年5月20日下午2:42:31
	 * @param start
	 *            起始日期
	 * @param end
	 *            结束日期
	 * @return int
	 * 
	 */
	public static int daysBetween(Calendar start, Calendar end) {
		return Integer.parseInt(String.valueOf((end.getTimeInMillis() - start
				.getTimeInMillis()) / milOfDay));
	}

	public static void main(String args[]) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2014, 8, 2);
		System.out.println(daysBetween(Calendar.getInstance(), calendar));
	}
}
