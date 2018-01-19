package cn.com.atnc.ioms.dao.duty.vgduty;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.duty.vgduty.VGSystem;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;

/**
 * VG系统检查DAO
 * @author 
 * @date 
 * @since 
 */
public interface VGSystemDao extends IBaseDao<VGSystem> {
	/**
	 * 根据查询条件Model查询VG网入网申请记录
	 * @param queryModel
	 * @return 
	 * @author 
	 * @date  
	 * @since 
	 */
	Pagination queryPageByModel(TeleGraphSystemQueryModel queryModel);
}
