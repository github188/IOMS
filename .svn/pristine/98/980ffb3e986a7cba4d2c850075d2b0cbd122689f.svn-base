package cn.com.atnc.ioms.mng.business.formalcircuit.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitAttachDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitAttach;
import cn.com.atnc.ioms.enums.business.baseinfo.AttachSourceEnum;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitAttachService;

/**
 * 正式电路申请上传附件Service接口实现类
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:19:32
 * @since 1.0.0
 */
@Service
@Transactional
public class FormalCircuitAttachServiceImpl extends BaseService implements
IFormalCircuitAttachService {

	@Autowired
	private IFormalCircuitAttachDao FormalCircuitAttachDao;
	@Autowired
	@Qualifier(value = "myExecutor")
	private TaskExecutor excutor;
	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IDataComNetworkAttachService#queryListByKuSateId(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true,timeout=1)
	public List<FormalCircuitAttach> queryListByFCId(String id) {
		return (List<FormalCircuitAttach>) FormalCircuitAttachDao.queryList("from FormalCircuitAttach where formalCircuit.id = ?", id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.IDataComNetworkAttachService#physicalDelById(java.lang.String)
	 */
	@Override
	public FormalCircuitAttach physicalDelById(String id) {
		try {
			final FormalCircuitAttach FormalCircuitAttach = FormalCircuitAttachDao.findById(id);
			// 多线程处理
			excutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						FormalCircuitAttachDao.delete(FormalCircuitAttach);
						String address = FormalCircuitAttach.getAttachAddress();
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
			return FormalCircuitAttach;
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
	public FormalCircuitAttach findById(String id) {
		// TODO Auto-generated method stub
		return FormalCircuitAttachDao.findById(id);
	}
	
	@Override
	public List<FormalCircuitAttach> queryListByMulti(String id,
			AttachSourceEnum area) {
		return FormalCircuitAttachDao.findByFCIdAREA(id, area);
	}

}
