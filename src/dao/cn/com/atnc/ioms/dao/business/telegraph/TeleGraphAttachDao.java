/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName IKuSatelliteAttachDao.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.satellite
 * @author ku
 * @date 2015年5月13日下午3:54:52
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.business.telegraph;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphAttach;
import cn.com.atnc.ioms.enums.business.telegraph.TeleAttachTypeEnum;

/**
 * 转报地址入网申请附件信息Dao接口
 * @author WangLingbin
 * @date 2015年10月14日 下午4:59:46
 * @since 1.0.0
 */
public interface TeleGraphAttachDao extends IBaseDao<TeleGraphAttach> {

	/**
	 * 通过转报地址入网申请记录ID删除对应上传的附件信息
	 * @param id 
	 * @author WangLingbin
	 * @date  2015年10月14日下午5:00:04
	 * @since 1.0.0
	 */
	void delByTeleGraphId(String id);
	
	/**
	 * 根据父类主键ID和类型查找实体
	 * @param id
	 * @param type
	 * @return 
	 * @author WangLingbin
	 * @date  2015年10月29日下午3:05:21
	 * @since 1.0.0
	 */
	public List<TeleGraphAttach> queryListByMulti(String id, TeleAttachTypeEnum type) ;

}
