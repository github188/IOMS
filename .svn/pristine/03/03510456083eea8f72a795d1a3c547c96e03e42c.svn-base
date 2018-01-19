package cn.com.atnc.ioms.dao.business.datacomnetwork;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkAttach;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkAttachTypeEnum;

/**
 * 数据通信网申请附件信息Dao接口
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:10:04
 * @since 1.0.0
 */
public interface IDataComNetworkAttachDao extends IBaseDao<DataComNetworkAttach> {

	/**
	 * 数据通信网申请记录ID删除对应上传的附件信息
	 *
	 * @param id 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:09:42
	 * @since 1.0.0
	 */
	void delByDataComNetworkId(String id);

	/**
	 * 根据数据通信网ID查找实体
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月19日上午10:13:40
	 * @since 1.0.0
	 */
	public List<DataComNetworkAttach> findByDCNId(String id);
	
	/**
	 * 根据数据通信网ID、类型查找实体List
	 *
	 * @param id
	 * @param valueOf
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月29日下午12:59:31
	 * @since 1.0.0
	 */
	List<DataComNetworkAttach> findByDCNIdType(String id, NetWorkAttachTypeEnum type);

}
