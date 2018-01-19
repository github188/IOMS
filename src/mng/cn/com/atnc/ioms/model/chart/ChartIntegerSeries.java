/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-26 下午3:27:11
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.chart;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:HuangYijie
 * @date:2014-5-26 下午3:27:11
 * @version:1.0
 */

public class ChartIntegerSeries {

	public ChartIntegerSeries() {

	}

	public ChartIntegerSeries(String name) {
		this.name = name;
	}

	public String name;
	public List<Integer> data = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

}
