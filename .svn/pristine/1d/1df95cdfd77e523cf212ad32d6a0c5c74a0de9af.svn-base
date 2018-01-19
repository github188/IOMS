package cn.com.atnc.ioms.dao.operstat.tes;

import java.util.List;
import java.util.Map;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerStat;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesTxPowerQueryModel;

public interface ITesStatDao extends IBaseDao<TesTxPowerStat> {
    /**
     * 返回列表数据分页查询
     * @param qm
     * @return
     */
	public Pagination queryPage(TesStatQueryModel qm);

	/**
	 * 查询异常节点列表
	 * @param qm
	 * @return
	 */
	public List<TesTxPowerStat> findlist(TesStatQueryModel qm);

	/**
	 * 查询异常站点统计并分页显示
	 * @param qm
	 * @return
	 */
	public Pagination querySQLPage(TesTxPowerQueryModel qm);

	/**
	 * 方法说明：查询槽位报警数
	 * 
	 * @return
	 */
	public Map<String, Integer> tesSlotWarningList();
}
