package cn.com.atnc.ioms.dao.business.formalcircuit;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitAttach;
import cn.com.atnc.ioms.enums.business.baseinfo.AttachSourceEnum;

/**
 * 正式电路申请附件信息Dao接口
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:10:04
 * @since 1.0.0
 */
public interface IFormalCircuitAttachDao extends IBaseDao<FormalCircuitAttach> {

	/**
	 * 正式电路申请记录ID删除对应上传的附件信息
	 *
	 * @param id 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:09:42
	 * @since 1.0.0
	 */
	void delByFormalCircuitId(String id);

	/**
	 * 根据正式电路ID查找实体
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月19日上午10:13:40
	 * @since 1.0.0
	 */
	public FormalCircuitAttach findByFCId(String id);
	
	/**
	 * 根据正式电路ID、地区查找实体List
	 *
	 * @param id
	 * @param area
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月28日下午2:54:07
	 * @since 1.0.0
	 */
	public List<FormalCircuitAttach> findByFCIdAREA(String id, AttachSourceEnum area);

}
