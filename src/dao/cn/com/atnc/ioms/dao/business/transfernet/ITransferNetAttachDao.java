package cn.com.atnc.ioms.dao.business.transfernet;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNetAttach;
import cn.com.atnc.ioms.enums.business.transfernet.TransferAttachTypeEnum;

/**
 * 自动转报网申请附件信息Dao接口
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:10:04
 * @since 1.0.0
 */
public interface ITransferNetAttachDao extends IBaseDao<TransferNetAttach> {

	/**
	 * 自动转报网申请记录ID删除对应上传的附件信息
	 *
	 * @param id 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:09:42
	 * @since 1.0.0
	 */
	void delByTransferNetId(String id);

	/**
	 * 根据自动转报网ID查找实体
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月19日上午10:13:40
	 * @since 1.0.0
	 */
	public List<TransferNetAttach> findByTNId(String id);
	
	/**
	 * 根据自动转报网ID、Type查找实体List
	 *
	 * @param id
	 * @param area
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月29日下午2:58:45
	 * @since 1.0.0
	 */
	public List<TransferNetAttach> findByTNIdType(String id, TransferAttachTypeEnum type);

}
