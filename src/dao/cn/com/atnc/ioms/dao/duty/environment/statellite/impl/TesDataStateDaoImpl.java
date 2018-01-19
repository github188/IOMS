package cn.com.atnc.ioms.dao.duty.environment.statellite.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.dg.DgCheckContentDao;
import cn.com.atnc.ioms.dao.duty.environment.statellite.TesDataStateDao;
import cn.com.atnc.ioms.entity.duty.environment.dg.DgCheckContent;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.DataState;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentEquipCheckQueryModel;
import cn.com.atnc.ioms.web.duty.statellite.day.tes.DataStateCheckController;
import cn.com.atnc.sample.dao.MyBaseDao;


/**   
 *    
 * @author shijiyong
 * @date 2016年10月17日 上午10:02:02
 * @version   
 *       1.0, 2016年10月17日 上午10:02:02   
 */
@Repository("TesDataStateDao")
public class TesDataStateDaoImpl extends MyBaseDao<DataState> implements
TesDataStateDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<DataState> queryByModel(
			EnvironmentEquipCheckQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from TxjdDataState d where 1=1");
		ArrayList<Object> params = new ArrayList<Object>();
		if(!ObjectUtils.equals(queryModel.getEeCheck(), null)){
			hql.append(" and d.checkid = ?");
			params.add(queryModel.getEeCheck());
		}
		System.err.println(hql);
		return (List<DataState>) super.queryList(hql.toString(), params.toArray());
	
	}

}
