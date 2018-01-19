package cn.com.atnc.ioms.mng.duty.vgduty;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.duty.vgduty.VGSystem;
import cn.com.atnc.ioms.model.duty.telegraphduty.TeleGraphSystemQueryModel;


/**
 * VG系统检查Service
 * @author 
 * @date 
 * @since 
 */
public interface VGSystemService {
	
	/**
	 * 通过查询条件model查询记录
	 * @param queryModel
	 * @author 
	 * @date  
	 * @since 
	 */
	Pagination queryPageByModel(TeleGraphSystemQueryModel queryModel);

	/**
	 * 获取所有记录
	 * @author 
	 * @date  
	 * @since 
	 */
	List<VGSystem> getAll();
	
	/**
	 * 保存记录
	 * @author 
	 * @date  
	 * @since 
	 */
	VGSystem save(VGSystem vgSystem);

	/**
	 * 更新记录
	 * @author 
	 * @date  
	 * @since 
	 */
	VGSystem update(VGSystem vgSystem);

	/**
	 * 删除记录
	 * @param vGSystem 
	 * @author 
	 * @date  
	 * @since 
	 */
	void delete(VGSystem vgSystem);
	
	/**
	 * 根据主键ID查找记录
	 * @author 
	 * @date  
	 * @since 
	 */
	VGSystem findById(String id);
}
