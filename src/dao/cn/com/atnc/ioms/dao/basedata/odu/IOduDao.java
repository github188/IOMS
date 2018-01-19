package cn.com.atnc.ioms.dao.basedata.odu;
import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.odu.Odu;
import cn.com.atnc.ioms.model.basedata.satellite.OduQueryModel;


public interface IOduDao extends IBaseDao<Odu> {
	public Pagination queryPage(OduQueryModel queryModel);	
	public Long querySize(OduQueryModel queryModel);
	public List<Odu> queryList(OduQueryModel queryModel);
	public List<Odu> findODUBySite(OduQueryModel qm3);
}
