package cn.com.atnc.ioms.entity.duty.satellite.day.tes;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.atnc.ioms.entity.duty.satellite.day.BaseSatelliteInfo;
import cn.com.atnc.ioms.enums.duty.satellite.SatelliteCheckContent;

/**
 * 通讯基地-TES-查看网管同步状态父级数据表
 *
 * @author 段衍林
 * @2017年2月15日 下午1:00:47
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "TB_OM_DUTY_SAT_TXJD_SYN_STATE")
public class TxjdSynState extends BaseSatelliteInfo {
	
	private transient List<TxjdSynResult> txjdSynResults;// 子数据列表

	public TxjdSynState() {
		super();
	}

	public TxjdSynState(BaseSatelliteInfo baseSatelliteInfo,
			SatelliteCheckContent content) {
		super();
		super.setCheckContent(content);
		super.setCreateDate(baseSatelliteInfo.getCreateDate());
		super.setCreateTime(baseSatelliteInfo.getCreateTime());
		super.setCreater(baseSatelliteInfo.getCreater());
	}

	@Transient
	public List<TxjdSynResult> getTxjdSynResults() {
		return txjdSynResults;
	}

	public void setTxjdSynResults(List<TxjdSynResult> txjdSynResults) {
		this.txjdSynResults = txjdSynResults;
	}
}
