package cn.com.atnc.ioms.mng.operstat.tes;

import java.util.List;
import java.util.Map;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerStat;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesTxPowerQueryModel;

public interface ITesStatService {
	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public Pagination queryPage(TesStatQueryModel qm);

	/**
	 * 获得所有异常站点信息
	 * @param qm
	 * @return
	 */
	public List<TesTxPowerStat> findlist(TesStatQueryModel qm);

	/**
	 * 分页查询异常站点信息
	 * @param qm
	 * @return
	 */
	public Pagination queryTxPowerPage(TesTxPowerQueryModel qm);

	/**
	 * 获得一个异常站点信息
	 * @param id
	 * @return
	 */
	public TesTxPowerStat findById(String id);

	/**
	 * 保存异常站点槽号信息
	 * @param equip
	 * @param nodecu
	 * @param id
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public String save(String equip, String nodecu, String id, User user)
			throws Exception;

	/**
	 * 删除站点状态信息,此方法没有用到
	 * @param id
	 */
	public void removeStatusById(String id);

	/**
	 * 分页统计查询SQL异常站点信息
	 * @param qm
	 * @return
	 */
	public Pagination querySQLPage(TesTxPowerQueryModel qm);

	/**
	 * 方法说明：tes槽位报警数量
	 * 
	 * @return
	 */
	public Map<String, Integer> tesSlotWarningList();

	/**
	 * 根据站点槽号查询日志
	 * @param queryModel
	 * @return
	 */
    public Pagination queryLogPage(TesStatQueryModel queryModel);
}
