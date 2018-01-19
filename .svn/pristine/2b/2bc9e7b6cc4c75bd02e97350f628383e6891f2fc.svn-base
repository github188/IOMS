/**
 * @ProjectName PCSP_CIRCUIT
 * @FileName KuSatelliteAttachServiceImpl.java
 * @PackageName:cn.com.atnc.pcsp.mng.business.satellite.impl
 * @author ku
 * @date 2015年5月28日下午4:10:19
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.mng.business.telegraph.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.telegraph.TeleGraphAttachDao;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphAttach;
import cn.com.atnc.ioms.enums.business.telegraph.TeleAttachTypeEnum;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphAttachService;

/**
 * 转报地址入网申请上传附件Service接口实现类
 * @author WangLingbin
 * @date 2015年10月14日 下午5:07:43
 * @since 1.0.0
 */
@Service
@Transactional
public class TeleGraphAttachServiceImpl extends BaseService implements TeleGraphAttachService {

	@Autowired
	private TeleGraphAttachDao teleGraphAttachDao;
	@Autowired
	@Qualifier(value = "myExecutor")
	private TaskExecutor excutor;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true,timeout=1)
	public List<TeleGraphAttach> queryListByTeleGraphId(String id) {
		return (List<TeleGraphAttach>) teleGraphAttachDao.queryList("from TeleGraphAttach where teleGraph.id = ?", id);
	}

	@Override
	public TeleGraphAttach physicalDelById(String id) {
		try {
			final TeleGraphAttach teleGraphAttach = teleGraphAttachDao.findById(id);
			// 多线程处理
			excutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						teleGraphAttachDao.delete(teleGraphAttach);
						String address = teleGraphAttach.getAttachAddress();
						File file = new File(address);
						if(file.exists()){
							file.delete();
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new RuntimeException("物理删除附件信息出错，原因是："+e.getMessage());
					}
				}
			});
			return teleGraphAttach;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("物理删除附件信息出错，原因是："+e.getMessage());
		}
	}

	@Override
	public TeleGraphAttach findById(String id) {
		return teleGraphAttachDao.findById(id);
	}
	
	@Override
	@Transactional(readOnly=true,timeout=1)
	public List<TeleGraphAttach> queryListByMulti(String id, TeleAttachTypeEnum type){
		return teleGraphAttachDao.queryListByMulti(id, type);
	}

}
