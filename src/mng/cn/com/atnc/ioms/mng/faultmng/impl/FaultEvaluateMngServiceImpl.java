package cn.com.atnc.ioms.mng.faultmng.impl;

import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.faultmng.IFaultEvaluateDao;
import cn.com.atnc.ioms.dao.faultmng.IFaultInformationDao;
import cn.com.atnc.ioms.entity.faultmng.FaultEvaluate;
import cn.com.atnc.ioms.entity.faultmng.FaultInformation;
import cn.com.atnc.ioms.enums.faultmng.FaultEvaluateStatus;
import cn.com.atnc.ioms.mng.faultmng.IFaultEvaluateMngService;
import cn.com.atnc.ioms.model.faultmng.FaultEvaluateModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 事件单评价实现类
 *
 * @author 段衍林
 * @2016年11月9日 下午4:40:19
 */
@Service("faultEvaluateMngService")
public class FaultEvaluateMngServiceImpl extends BaseService implements
		IFaultEvaluateMngService {

	@Autowired
	private IFaultEvaluateDao faultEvaluateDao;
	@Autowired
	private IFaultInformationDao faultInformationDao;
	
	
	/**
	 * 事件单评价查询model
	 * @author 段衍林
	 * @2016年11月9日 下午4:38:15
	 * @param qm
	 * @return
	 * List<FaultEvaluate>
	 */
	public List<FaultEvaluate> queryList(FaultEvaluateModel qm){
		return faultEvaluateDao.queryList(qm);
	}
	
	/**
	 * 事件单评价保存
	 * @author 段衍林
	 * @2016年11月9日 下午4:39:18
	 * @param faultEvaluateModel
	 * void
	 * @throws Exception 
	 */
	public void saveEvaluate(FaultEvaluateModel faultEvaluateModel) throws Exception{
		
		//根据faultId查询事件单
		FaultInformation faultInformation = faultInformationDao.findById(faultEvaluateModel.getFaultId());
		if(ObjectUtils.equals(faultInformation, null)){
			throw new Exception("无事件单");
		}
		/**
		 * 保存事件单评价记录
		 */
		//声明评价类
		FaultEvaluate faultEvaluate = new FaultEvaluate();
		//保存处理人
		faultEvaluate.setOperator(faultEvaluateModel.getUser());
		//保存处理时间--当前时间
		faultEvaluate.setOperatTime(DateUtilTools.getNowDateTime());
		//保存事件单id
		faultEvaluate.setFaultId(faultEvaluateModel.getFaultId());
		//保存评价
		faultEvaluate.setEvaluate(faultEvaluateModel.getEvaluate());
		//保存评价内容 
		faultEvaluate.setRemark(faultEvaluateModel.getRemark());
		//保存
		faultEvaluateDao.save(faultEvaluate);
		/**
		 * 修改事件单中的评价字段状态为已评价
		 */
		faultInformation.setFaultEvaluateStatus(FaultEvaluateStatus.EVALUATE);
		//更新
		faultInformationDao.update(faultInformation);
	}
}