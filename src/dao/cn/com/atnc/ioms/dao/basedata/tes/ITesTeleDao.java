package cn.com.atnc.ioms.dao.basedata.tes;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.tes.TesTele;
import cn.com.atnc.ioms.model.basedata.tes.TesTeleQueryModel;

public interface ITesTeleDao extends IBaseDao<TesTele> {

	public Pagination queryPage(TesTeleQueryModel queryModel);	
	public Long querySize(TesTeleQueryModel model);	
	public List<TesTele> queryList(TesTeleQueryModel queryModel);	
}
