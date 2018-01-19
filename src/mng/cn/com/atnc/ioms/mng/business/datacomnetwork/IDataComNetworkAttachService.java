package cn.com.atnc.ioms.mng.business.datacomnetwork;

import java.util.List;

import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkAttach;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkAttachTypeEnum;


/**
 * 数据通信网申请上传附件Service接口
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:17:24
 * @since 1.0.0
 */
public interface IDataComNetworkAttachService {

	/**
	 * 根据数据通信网申请记录ID查询对应的上传附件集合
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:17:56
	 * @since 1.0.0
	 */
	List<DataComNetworkAttach> queryListByDCNId(String id);

	/**
	 * 物理删除已经上传的附件
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:18:17
	 * @since 1.0.0
	 */
	DataComNetworkAttach physicalDelById(String id);

	/**
	 * 根据ID获取附件信息对象
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:18:38
	 * @since 1.0.0
	 */
	DataComNetworkAttach findById(String id);
	
	/**
	 * 根据ID、类型获取附件信息对象List
	 *
	 * @param id
	 * @param type
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月29日下午12:58:40
	 * @since 1.0.0
	 */
	List<DataComNetworkAttach> queryListByFCIdType(String id, NetWorkAttachTypeEnum type);
}
