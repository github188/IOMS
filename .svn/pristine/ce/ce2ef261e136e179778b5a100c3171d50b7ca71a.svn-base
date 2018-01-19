package cn.com.atnc.ioms.mng.business.transfernet.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.business.transfernet.ITransferNetAttachDao;
import cn.com.atnc.ioms.entity.business.transfernet.TransferNetAttach;
import cn.com.atnc.ioms.enums.business.transfernet.TransferAttachTypeEnum;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetAttachService;

/**
 * 自动转报申请上传附件Service接口实现类
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:19:32
 * @since 1.0.0
 */
@Service
@Transactional
public class TransferNetAttachServiceImpl extends BaseService implements
             ITransferNetAttachService {

	@Autowired
	private ITransferNetAttachDao transferNetAttachDao;
	@Autowired
	@Qualifier(value = "myExecutor")
	private TaskExecutor excutor;

	@Override
	public List<TransferNetAttach> queryListByTNId(String id) {
		return transferNetAttachDao.findByTNId(id);
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.ITransferNetAttachService#physicalDelById(java.lang.String)
	 */
	@Override
	public TransferNetAttach physicalDelById(String id) {
		try {
			final TransferNetAttach TransferNetAttach = transferNetAttachDao.findById(id);
			// 多线程处理
			excutor.execute(new Runnable() {
				@Override
				public void run() {
					try {
						transferNetAttachDao.delete(TransferNetAttach);
						String address = TransferNetAttach.getAttachAddress();
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
			return TransferNetAttach;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("物理删除附件信息出错，原因是："+e.getMessage());
		}
	}

	/**
	 * (non-Javadoc)
	 * @see cn.com.atnc.pcsp.mng.business.satellite.ITransferNetAttachService#findById(java.lang.String)
	 */
	@Override
	public TransferNetAttach findById(String id) {
		// TODO Auto-generated method stub
		return transferNetAttachDao.findById(id);
	}
	
	@Override
	public List<TransferNetAttach> queryListByTNIdType(String id, TransferAttachTypeEnum type) {
		return transferNetAttachDao.findByTNIdType(id, type);
	}

}
