/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-26 下午3:25:05
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.model.chart;

import java.util.List;

/**
 * @author:HuangYijie
 * @date:2014-5-26 下午3:25:05
 * @version:1.0
 */

public class ChartModel {
	private String title;
	private String subTitle;
	private List<String> xAxisCategories;
	private String xAxisTitle;
	private List<String> yAxisCategories;
	private String yAxisTitle;
	private List<ChartIntegerSeries> seriesList;

	private ChartIntegerSeries[] serieses;

	public ChartIntegerSeries[] getSerieses() {
		return serieses;
	}

	public void setSerieses(ChartIntegerSeries[] serieses) {
		this.serieses = serieses;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public List<String> getxAxisCategories() {
		return xAxisCategories;
	}

	public void setxAxisCategories(List<String> xAxisCategories) {
		this.xAxisCategories = xAxisCategories;
	}

	public String getxAxisTitle() {
		return xAxisTitle;
	}

	public void setxAxisTitle(String xAxisTitle) {
		this.xAxisTitle = xAxisTitle;
	}

	public List<String> getyAxisCategories() {
		return yAxisCategories;
	}

	public void setyAxisCategories(List<String> yAxisCategories) {
		this.yAxisCategories = yAxisCategories;
	}

	public String getyAxisTitle() {
		return yAxisTitle;
	}

	public void setyAxisTitle(String yAxisTitle) {
		this.yAxisTitle = yAxisTitle;
	}

	public List<ChartIntegerSeries> getSeriesList() {
		return seriesList;
	}

	public void setSeriesList(List<ChartIntegerSeries> seriesList) {
		this.seriesList = seriesList;
	}

}
