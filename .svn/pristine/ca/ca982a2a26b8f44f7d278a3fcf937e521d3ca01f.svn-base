package cn.com.atnc.ioms.dao.basedata.antenna;
import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.antenna.Antenna;
import cn.com.atnc.ioms.entity.basedata.tes.TesService;
import cn.com.atnc.ioms.model.basedata.satellite.AntennaQueryModel;
import cn.com.atnc.ioms.model.basedata.tes.TesServiceQueryModel;


public interface IAntennaDao extends IBaseDao<Antenna> {
	public Pagination queryPage(AntennaQueryModel queryModel);	
	public Long querySize(AntennaQueryModel queryModel);	
	public List<Antenna> queryList(AntennaQueryModel queryModel);
}