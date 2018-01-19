/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-19 下午8:02:18
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.tes;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.tes.TesNode;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.model.basedata.tes.TesSlotQueryModel;



public interface ITesSlotDao extends IBaseDao<TesSlot> {

	public Pagination queryPage(TesSlotQueryModel queryModel);
	
	public Long querySize(TesSlotQueryModel model);
	
	public List<TesSlot> queryList(TesSlotQueryModel queryModel);
	
	//public List<TesSlot> queryList(TesSlotQueryModel queryModel);
	public List<TesSlot> queryListByTesNode(TesNode tesNode);

    public TesSlot findByTesSlot(String code,String cu);
}
