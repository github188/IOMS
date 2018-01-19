package cn.com.atnc.ioms.mng.faultmng.message.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.mng.faultmng.IFaultMQService;
import cn.com.atnc.ioms.mng.faultmng.message.IAcceptMessageManager;

/**
 * 
 * @author hantianyu
 *
 */
@Service("acceptMessageManager")
public class AcceptMessageManagerImpl extends BaseService implements
IAcceptMessageManager{
    @Autowired
    private IFaultMQService faultMQService;

	@Transactional
	public void accept(String msg) {
		// TODO Auto-generated method stub
		faultMQService.receive(msg);
	}

}
