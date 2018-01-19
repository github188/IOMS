package cn.com.atnc.ioms.mng.business.transfernet;

import java.util.List;

import cn.com.atnc.ioms.entity.business.transfernet.TransferNetAttach;
import cn.com.atnc.ioms.enums.business.transfernet.TransferAttachTypeEnum;

/**
 * 自动转报网申请上传附件Service接口
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:17:24
 * @since 1.0.0
 */
public interface ITransferNetAttachService {

	/**
	 * 根据自动转报网申请记录ID查询对应的上传附件集合
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:17:56
	 * @since 1.0.0
	 */
	List<TransferNetAttach> queryListByTNId(String id);

	/**
	 * 物理删除已经上传的附件
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:18:17
	 * @since 1.0.0
	 */
	TransferNetAttach physicalDelById(String id);

	/**
	 * 根据ID获取附件信息对象
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:18:38
	 * @since 1.0.0
	 */
	TransferNetAttach findById(String id);
	
	/**
	 * 根据ID、类型获取附件信息对象List
	 *
	 * @param id
	 * @param type
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月29日下午3:12:41
	 * @since 1.0.0
	 */
	List<TransferNetAttach> queryListByTNIdType(String id, TransferAttachTypeEnum type);

}
