package cn.com.atnc.ioms.dao.basedata.atm.node;



import java.io.UnsupportedEncodingException;
import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.atm.node.AtmNode;
import cn.com.atnc.ioms.model.basedata.atm.node.AtmNodeQueryModel;

/**
 * @author:xiongzhikang
 * @date:2014-4-11 下午8:02:18
 * @version:1.0
 */

public interface IAtmNodeDao extends IBaseDao<AtmNode> {

	public Pagination queryPage(AtmNodeQueryModel queryModel);
	
	public Long querySize(AtmNodeQueryModel model) throws UnsupportedEncodingException;
	
	public List<AtmNode> queryList(AtmNodeQueryModel queryModel);

	/**
	 * @author：KuYonggang
	 * @date：2014-6-19下午7:13:08
	 * @param：
	 * @return：Object
	 */
	public AtmNode getAtmNodeByNodeCode(String nodeCode);
}
