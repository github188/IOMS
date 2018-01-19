/* Copyright @2017 Beijing ATNC Co.,Ltd. All rights reserved
 *
 * 创建人：王凌斌
 * 创建时间：@2017年1月19日 上午11:20:37
 * 
 * 修改人：
 * 修改时间：
 * 修改内容：
 */
package cn.com.atnc.ioms.entity.reports;

import java.util.Date;

/**
 * 电路运行情况
 * 
 * @author 王凌斌
 * @2017年1月19日 下午4:39:20
 */
public class KuMaintenceOperEntity {

	// legend
	private String legend;
	// 日期
	private Date date;
	// 值
	private Number value;

	public KuMaintenceOperEntity() {
		super();
	}

	public KuMaintenceOperEntity(String legend, Date date, Number value) {
		super();
		this.legend = legend;
		this.date = date;
		this.value = value;
	}

	public String getLegend() {
		return legend;
	}

	public void setLegend(String legend) {
		this.legend = legend;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Number getValue() {
		return value;
	}

	public void setValue(Number value) {
		this.value = value;
	}

}
