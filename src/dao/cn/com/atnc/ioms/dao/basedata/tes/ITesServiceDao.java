package cn.com.atnc.ioms.dao.basedata.tes;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.tes.TesService;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;


public interface ITesServiceDao extends IBaseDao<TesService> {

	public Pagination queryPage(TesServiceQueryModel queryModel);
    public Pagination queryPage(TesStatQueryModel queryModel);
	public Long querySize(TesServiceQueryModel model);
	public List<TesService> queryList(TesServiceQueryModel queryModel);
	
	public int deleteByNodeId(String nodeId);
}
