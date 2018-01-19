package cn.com.atnc.ioms.mng.business.datacomnetwork.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.datacomnetwork.IDataComNetworkAttachDao;
import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkAttach;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkAttachTypeEnum;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkAttachService;

/**
 * 数据通信网申请上传附件Service接口实现类
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:19:32
 * @since 1.0.0
 */
@Service
@Transactional
public class DataComNetworkAttachServiceImpl extends BaseService implements
             IDataComNetworkAttachService {

	@Autowired
	private IDataComNetworkAttachDao DataComNetworkAttachDao;
	@Autowired
	@Qualifier(value = "myExecutor")
	private TaskExecutor excutor;

	@Override
	public List<DataComNetworkAttach> queryListByDCNId(String id) {
		return  DataComNetworkAttachDao.findByDCNId(id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IDataComNetworkAttachService#physicalDelById(java.lang.String)
	 */
	@Override
	public DataComNetworkAttach physicalDelById(String id) {
		try {
			final DataComNetworkAttach DataComNetworkAttach = DataComNetworkAttachDao.findById(id);
			// 多线程处理
			excutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						DataComNetworkAttachDao.delete(DataComNetworkAttach);
						String address = DataComNetworkAttach.getAttachAddress();
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
			return DataComNetworkAttach;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("物理删除附件信息出错，原因是："+e.getMessage());
		}
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IDataComNetworkAttachService#findById(java.lang.String)
	 */
	@Override
	public DataComNetworkAttach findById(String id) {
		// TODO Auto-generated method stub
		return DataComNetworkAttachDao.findById(id);
	}
	
	@Override
	public List<DataComNetworkAttach> queryListByFCIdType(String id, NetWorkAttachTypeEnum type) {
		return DataComNetworkAttachDao.findByDCNIdType(id, type);
	}
}
