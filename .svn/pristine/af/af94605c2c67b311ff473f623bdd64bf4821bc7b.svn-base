package cn.com.atnc.ioms.dao.basedata.attenuator;
import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.attenuator.Attenuator;
import cn.com.atnc.ioms.entity.basedata.ku.KuNode;
import cn.com.atnc.ioms.model.basedata.satellite.AttenuatorQueryModel;

import java.util.List;


public interface IAttenuatorDao extends IBaseDao<Attenuator> {
	public Pagination queryPage(AttenuatorQueryModel queryModel);	
	public Long querySize(AttenuatorQueryModel queryModel);
	//public List<SatelliteSite> queryList(SiteQueryModel queryModel);
	public List<Attenuator> queryList(AttenuatorQueryModel queryModel);
}
