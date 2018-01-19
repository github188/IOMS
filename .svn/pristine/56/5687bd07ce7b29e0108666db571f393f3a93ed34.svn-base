package cn.com.atnc.ioms.dao.operstat.tes;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPower;
import cn.com.atnc.ioms.model.operstat.tes.TesTxPowerQueryModel;

public interface ITesTxPowerDao extends IBaseDao<TesTxPower> {

    /**
     * 查询站号和槽位号的记录中是否重复
     * @param tesNodeCode
     * @param cu
     * @param statid
     * @return
     */
    public Long findTesPower(String tesNodeCode,String cu,String statid);
    
    /**
     * 分页查询异常站点列表
     * @param qm
     * @return
     */
    public Pagination queryPage(TesTxPowerQueryModel qm);

}
