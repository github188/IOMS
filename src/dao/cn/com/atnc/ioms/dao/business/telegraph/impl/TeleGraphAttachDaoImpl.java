/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteAttachDao.java
 * @PackageName:cn.com.atnc.pcsp.dao.business.satellite.hibernate
 * @author ku
 * @date 2015年5月13日下午3:54:24
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.business.telegraph.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphAttachDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphAttach;
import cn.com.atnc.ioms.enums.business.telegraph.TeleAttachTypeEnum;
import cn.com.atnc.sample.dao.MyBaseDao;


/**
 * 转报地址入网申请附件信息Dao接口实现类
 *
 * @author WangLingbin
 * @date 2015年10月14日 下午5:01:30
 * @since 1.0.0
 */
@Repository
public class TeleGraphAttachDaoImpl extends MyBaseDao<TeleGraphAttach> implements TeleGraphAttachDao {

	@Override
	public void delByTeleGraphId(String id) {
		this.executeHql("delete from TeleGraphAttach where teleGraph.id = ?", id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TeleGraphAttach> queryListByMulti(String id, TeleAttachTypeEnum type) {
		StringBuilder sb = new StringBuilder("from TeleGraphAttach where 1=1");
		List<Object> params = new ArrayList<>();
		if(StringUtils.isNotEmpty(id)) {
			sb.append(" and teleGraph.id = ?");
			params.add(id);
		}
		if(!ObjectUtils.equals(type, null)) {
			sb.append(" and attachType = ?");
			params.add(type);
		}
		return (List<TeleGraphAttach>) this.queryList(sb.toString(), params.toArray());
	}

}
