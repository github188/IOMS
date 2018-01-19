/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName IKuSatelliteAttachService.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite
 * @author ku
 * @date 2015年5月28日下午4:09:37
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.telegraph;

import java.util.List;

import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphAttach;
import cn.com.atnc.ioms.enums.business.telegraph.TeleAttachTypeEnum;

/**
 * 转报地址入网申请上传附件Service接口
 * @author WangLingbin
 * @date 2015年10月14日 下午5:05:19
 * @since 1.0.0
 */
public interface TeleGraphAttachService {

	/**
	 * 根据转报地址入网申请记录ID查询对应的上传附件集合
	 *
	 * @param id
	 * @return 
	 * @author WangLingbin
	 * @date  2015年10月14日下午5:05:47
	 * @since 1.0.0
	 */
	List<TeleGraphAttach> queryListByTeleGraphId(String id);

	/**
	 * 物理删除已经上传的附件
	 * @author WangLingbin
	 * @date  2015年10月14日下午5:06:26
	 * @since 1.0.0
	 */
	TeleGraphAttach physicalDelById(String id);

	/**
	 * 根据ID获取附件信息对象
	 * @author WangLingbin
	 * @date  2015年10月14日下午5:06:53
	 * @since 1.0.0
	 */
	TeleGraphAttach findById(String id);
	
	/**
	 * 根据转报地址入网申请记录ID和类型查找实体
	 *
	 * @param id
	 * @param type
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年10月30日上午10:28:24
	 * @since 1.0.0
	 */
	List<TeleGraphAttach> queryListByMulti(String id, TeleAttachTypeEnum type);

}
