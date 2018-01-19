package cn.com.atnc.ioms.mng.business.formalcircuit;

import java.util.List;

import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitAttach;
import cn.com.atnc.ioms.enums.business.baseinfo.AttachSourceEnum;


/**
 * 正式电路申请上传附件Service接口
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:17:24
 * @since 1.0.0
 */
public interface IFormalCircuitAttachService {

	/**
	 * 根据正式电路申请记录ID查询对应的上传附件集合
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:17:56
	 * @since 1.0.0
	 */
	List<FormalCircuitAttach> queryListByFCId(String id);

	/**
	 * 物理删除已经上传的附件
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:18:17
	 * @since 1.0.0
	 */
	FormalCircuitAttach physicalDelById(String id);

	/**
	 * 根据ID获取附件信息对象
	 *
	 * @param id
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月15日上午10:18:38
	 * @since 1.0.0
	 */
	FormalCircuitAttach findById(String id);
	
	/**
	 * 根据ID、类型获取附件信息对象
	 *
	 * @param id
	 * @param area
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月28日下午2:52:16
	 * @since 1.0.0
	 */
	List<FormalCircuitAttach> queryListByMulti(String id, AttachSourceEnum area);

}
