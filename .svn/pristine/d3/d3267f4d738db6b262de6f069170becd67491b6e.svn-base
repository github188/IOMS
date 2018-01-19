/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:42:07
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.entity.basedata.tes;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.atnc.common.entity.StringUUIDEntity;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:42:07
 * @version:1.0
 */
@Entity
@Table(name = "TB_BD_TES_TXPOWER_STAT")
public class TesTxPowerStat extends StringUUIDEntity {

	private static final long serialVersionUID = -7221983038497936261L;
	private Integer over;// 超限频点总数
	private Integer normal;// 正常频点总数
	private String standard;// 标准值
	private Calendar statDate;// 时间
	private String info;

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getOver() {
		return over;
	}

	public void setOver(Integer over) {
		this.over = over;
	}

	public Integer getNormal() {
		return normal;
	}

	public void setNormal(Integer normal) {
		this.normal = normal;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	@Column(name = "STAT_DATE", columnDefinition = "date")
	public Calendar getStatDate() {
		return statDate;
	}

	public void setStatDate(Calendar statDate) {
		this.statDate = statDate;
	}

}
