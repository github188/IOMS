package cn.com.atnc.ioms.mng.duty.environment.impl;

import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.environment.acc.AccCheckContentDao;
import cn.com.atnc.ioms.dao.duty.environment.acc.AccDataRecordDao;
import cn.com.atnc.ioms.dao.duty.environment.dg.DgCheckContentDao;
import cn.com.atnc.ioms.dao.duty.environment.psot.PsOtCheckContentDao;
import cn.com.atnc.ioms.dao.duty.environment.statellite.TesDataStateDao;
import cn.com.atnc.ioms.dao.duty.environment.ups.BatteryMeasureDao;
import cn.com.atnc.ioms.dao.duty.environment.ups.DischargeProcessDao;
import cn.com.atnc.ioms.dao.duty.environment.ups.DischargeTestDao;
import cn.com.atnc.ioms.dao.duty.environment.ups.SystemConnMeasureDao;
import cn.com.atnc.ioms.dao.duty.environment.ups.SystemMeasureDao;
import cn.com.atnc.ioms.dao.duty.environment.ups.UpsContentCheckDao;
import cn.com.atnc.ioms.dao.duty.environment.ups.ZgvZlcMeasureDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.environment.acc.AccCheckContent;
import cn.com.atnc.ioms.entity.duty.environment.acc.AccDataRecord;
import cn.com.atnc.ioms.entity.duty.environment.dg.DgCheckContent;
import cn.com.atnc.ioms.entity.duty.environment.psot.PsOtCheckContent;
import cn.com.atnc.ioms.entity.duty.environment.ups.BatteryMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeProcess;
import cn.com.atnc.ioms.entity.duty.environment.ups.DischargeTest;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemConnMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.SystemMeasure;
import cn.com.atnc.ioms.entity.duty.environment.ups.UpsContentCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.ZgvZlcMeasure;
import cn.com.atnc.ioms.entity.duty.satellite.day.tes.DataState;
import cn.com.atnc.ioms.mng.duty.environment.EnvironmentEquipCheckService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentEquipCheckQueryModel;
import cn.com.atnc.ioms.model.duty.environment.acc.AccAddForm;
import cn.com.atnc.ioms.model.duty.environment.dg.DgAddForm;
import cn.com.atnc.ioms.model.duty.environment.psot.PsOtAddForm;
import cn.com.atnc.ioms.model.duty.environment.ups.DischargeProcessQueryModel;
import cn.com.atnc.ioms.model.duty.environment.ups.MeasureQueryModel;
import cn.com.atnc.ioms.model.duty.environment.ups.UpsMonthAddForm;
import cn.com.atnc.ioms.util.DateUtilTools;
/**
 * Ups检查service实现类
 * @author renyujuan
 * @date 2016年7月11日下午2:15:46
 */
@Transactional
@Service("UpsCheckService")
public class EnvironmentEquipCheckServiceImpl extends BaseService implements EnvironmentEquipCheckService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private UpsContentCheckDao upsContentCheckDao;
	@Autowired
	private SystemMeasureDao systemMeasureDao;
	@Autowired
	private ZgvZlcMeasureDao zgvZlcMeasuredao;
	@Autowired
	private BatteryMeasureDao batteryMeasureDao;
	@Autowired
	private SystemConnMeasureDao systemConnMeasureDao;
	@Autowired
	private DischargeTestDao dischargeTestDao;
	@Autowired
	private DischargeProcessDao dischargeProcessDao;
	@Autowired
	private DgCheckContentDao dgCheckContentDao;
	@Autowired
	private AccCheckContentDao accCheckContentDao;
	@Autowired
	private AccDataRecordDao accDataRecordDao;
	@Autowired
	private PsOtCheckContentDao psOtCheckContentDao;
	@Autowired
	private TesDataStateDao tesDateStateDao;
	
	/**
	 * 获取分页查询信息
	 * @author renyujuan
	 * @date 2016年7月21日 上午11:14:56
	 */
	@SuppressWarnings("unchecked")
	@Override
    public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
    	Pagination p = environmentEquipCheckDao.queryPageByModel(queryModel);
    	//System.err.println(p.getTotalCount());
    	List<EnvironmentEquipCheck> equipChecks = (List<EnvironmentEquipCheck>) p
    		.getResult();
    	// System.err.println(equipChecks.toString());
    	// 根据设备类型，查询相应的分页信息
    	if ((queryModel.getEquipType().toString()).equals("ups设备")) {
    	    if (equipChecks.size() > 0) {
        		for (EnvironmentEquipCheck upsCheck : equipChecks) {
        		    MeasureQueryModel qm = new MeasureQueryModel();
        		    qm.setUpsCheck(upsCheck);
        		    // 根据upsCheck查询对应的upsContentCheck
        		    List<UpsContentCheck> upsContentChecks = upsContentCheckDao
        			    .queryByModel(qm);
        		    if (upsContentChecks.size() > 0) {
        			upsCheck.setUpsContentCheck(upsContentChecks);
        		    }
        		    // 根据upsCheck查询对应的systemMeasure
        		    List<SystemMeasure> sms = systemMeasureDao.queryByModel(qm);
        		    if (sms.size() > 0) {
        			upsCheck.setSystemMeasure(sms);
        		    }
        		    // 根据upsCheck查询对应的zgvzlvmeasure
        		    List<ZgvZlcMeasure> zzms = zgvZlcMeasuredao
        			    .queryByModel(qm);
        		    if (zzms.size() > 0) {
        			upsCheck.setZgvZlcMeasure(zzms);
        		    }
        		    // 根据upsCheck查询对应的batterymeasure
        		    List<BatteryMeasure> bms = batteryMeasureDao
        			    .queryByModel(qm);
        		    if (bms.size() > 0) {
        			upsCheck.setBatteryMeasure(bms);
        		    }
        		    // 根据upsCheck查询对应的systemconnMeasure
        		    List<SystemConnMeasure> scms = systemConnMeasureDao
        			    .queryByModel(qm);
        		    if (scms.size() > 0) {
        			// System.err.println(scms.size());
        			upsCheck.setSystemConnMeasure(scms);
        		    }
        		    // 根据upsCheck查询对应的放电测试
        		    List<DischargeTest> dts = dischargeTestDao.queryByModel(qm);
        		    if (dts.size() > 0) {
        			for (DischargeTest dt : dts) {
        			    DischargeProcessQueryModel qm1 = new DischargeProcessQueryModel();
        			    qm1.setDischargeTest(dt);
        			    List<DischargeProcess> dps = dischargeProcessDao
        				    .queryByModel(qm1);
        			    if (dps.size() > 0) {
        				dt.setDischargeProcess(dps);
        			    }
        			}
        			upsCheck.setDischargeTest(dts);
        		    }
        		}
    	    }
    	} else if ((queryModel.getEquipType().toString()).equals("柴油发电机")) {
    	    if (equipChecks.size() > 0) {
        		for (EnvironmentEquipCheck dgCheck : equipChecks) {
        		    EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
        		    qm.setEeCheck(dgCheck);
        		    System.err.println(qm.getEeCheck());
        		    // 根据dgCheck查询对应的dgCheckContent
        		    List<DgCheckContent> dgCheckContents = dgCheckContentDao
        			    .queryByModel(qm);
        		    System.err.println(dgCheckContents);
        		    if (dgCheckContents.size() > 0) {
        			dgCheck.setDgCheckContent(dgCheckContents);
        		    }
        		}
    	    }
    	}else if ((queryModel.getEquipType().toString()).equals("TES")) {
    	    if (equipChecks.size() > 0) {
        		for (EnvironmentEquipCheck stCheck : equipChecks) {
        		    EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
        		    qm.setEeCheck(stCheck);
        		    
        		    System.err.println("------------TES-----------");
        		    
        		    System.err.println(qm.getEeCheck());
        		    // 根据dgCheck查询对应的dgCheckContent
        		    List<DataState> dgCheckContents = tesDateStateDao
        			    .queryByModel(qm);
        		    System.err.println(dgCheckContents);
        		    if (dgCheckContents.size() > 0) {
        		    	stCheck.setTxjddatastate(dgCheckContents);
        		    	System.err.println(stCheck.getTxjddatastate());
        		    }
        		}
    	    }
    	} else if ((queryModel.getEquipType().toString()).equals("空调设备")) {
    	    if(equipChecks.size() > 0) {
        		for(EnvironmentEquipCheck accCheck : equipChecks) {
        		    EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
        		    qm.setEeCheck(accCheck);
        		    //根据accCheck查询对应的AccCheckContent
        		    List<AccCheckContent> accCheckContents = accCheckContentDao
        			    .queryByModel(qm);
        		    if(accCheckContents.size()>0) {
        			accCheck.setAccCheckContent(accCheckContents);
        		    }
        		    //根据accCheck查询对应的AccDataContent实体
        		    List<AccDataRecord> accDataRecords = accDataRecordDao
        			    .queryByModel(qm);
        		    if(accDataRecords.size()>0) {
        			accCheck.setAccDataRecord(accDataRecords);
        		    }
        		    
        		}
    	    }
    
    	} else if((queryModel.getEquipType().toString()).equals("传输设备及通讯线路")){
    	    if(equipChecks.size()>0) {
    	        for(EnvironmentEquipCheck psOtCheck : equipChecks) {
    	            EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
    	            qm.setEeCheck(psOtCheck);
    	            /*根据psOtCheck查询相应的PsOtCheckContent*/
    	            List<PsOtCheckContent> psOtCheckContents = psOtCheckContentDao
    	                    .queryByModel(qm);
    	            if(psOtCheckContents.size()>0) {
    	                psOtCheck.setPsOtCheckContent(psOtCheckContents);
    	            }
    	        }
    	    }
    	}
    	return p;
    }

	@Override
	public List<UpsContentCheck> upsContentCheckList(EnvironmentCheckQueryModel queryModel){
		return environmentEquipCheckDao.upsContentCheckList(queryModel);
	}
	
	@Override
	public List<EnvironmentEquipCheck> getAll() {
		return environmentEquipCheckDao.getAll();	
	}
	
	/**
	 * ups季检年检记录保存
	 * @author renyujuan
	 * @date 2016年8月3日上午10:06:51
	 * @param form
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @param dsTime
	 * @param batTotalV
	 * @param dsCurrent
	 * @param singleMaxV
	 * @param singleMinV
	 * @param remark
	 */
	@Override
	public void saveQuarter(UpsMonthAddForm form, List<Integer> number,List<String> termialV,
			List<String> interR, List<String> remarks,
			List<String> dsTime, List<String> batTotalV, List<String> dsCurrent,
			List<String> singleMaxV, List<String> singleMinV, List<String> remark){
		//添加ups巡检记录
		EnvironmentEquipCheck upsCheck=new EnvironmentEquipCheck();
		upsCheck.setName(form.getName());
		upsCheck.setOperator(form.getOperator());
		upsCheck.setProblem(form.getProblem());
		upsCheck.setSuggestion(form.getSuggestion());
		upsCheck.setResult(form.getResult());
		//System.err.println(form.getCheckTime());
		upsCheck.setEquipType(form.getEquipType());
		upsCheck.setCheckType(form.getCheckType());
		upsCheck.setCheckTime(DateUtilTools.parseDate(form.getCheckTime(), DateUtilTools.PATTERN_DATE_3));
		upsCheck.setCheckDate(DateUtilTools.parseDate(form.getCheckDate(), DateUtilTools.PATTERN_DATE_1));
		environmentEquipCheckDao.save(upsCheck);
		
		//添加内容检查
		UpsContentCheck upsContentCheck=new UpsContentCheck();
		upsContentCheck.setTemperature(form.getTemperature());
		upsContentCheck.setAtIsAdjustable(form.getAtIsAdjustable());
		upsContentCheck.setHumidity(form.getHumidity());
		upsContentCheck.setEaIsIntact(form.getEaIsIntact());
		upsContentCheck.setRadiateIsNormal(form.getRadiateIsNormal());
		upsContentCheck.setEsGroundVoltage(form.getEsGroundVoltage());
		upsContentCheck.setUpsRvIsNormal(form.getUpsRvIsNormal());
		upsContentCheck.setUpsUidisIsNormal(form.getUpsUidisIsNormal());
		upsContentCheck.setRaIsFlow(form.getRaIsFlow());
		upsContentCheck.setBatLeakage(form.getBatLeakage());
		upsContentCheck.setUpsOutletIsClean(form.getUpsOutletIsClean());
		upsContentCheck.setBatSurfaceIsClean(form.getBatSurfaceIsClean());
		upsContentCheck.setConnCo(form.getConnCo());
		upsContentCheck.setUpsCurFAlarm(form.getUpsCurFAlarm());
		upsContentCheck.setUpsHisFAlarm(form.getUpsHisFAlarm());
		upsContentCheck.setInputVLN(form.getInputVLN());
		upsContentCheck.setInputVLD(form.getInputVLD());
		upsContentCheck.setInputVND(form.getInputVND());
		upsContentCheck.setInputCurrent(form.getInputCurrent());
		upsContentCheck.setLoadCapacity(form.getLoadCapacity());
		upsContentCheck.setInputAirTemperature(form.getInputAirTemperature());
		upsContentCheck.setInputCableTemperature(form.getInputCableTemperature());
		upsContentCheck.setOutputVLN(form.getOutputVLN());
		upsContentCheck.setOutputVLD(form.getOutputVLD());
		upsContentCheck.setOutputVND(form.getOutputVND());
		upsContentCheck.setOutputCurrent(form.getOutputCurrent());
		upsContentCheck.setOutputAirTemperature(form.getOutputAirTemperature());
		upsContentCheck.setEquipDustRemoval(form.getEquipDustRemoval());
		upsContentCheck.setUpsCheck(upsCheck);
		upsContentCheckDao.save(upsContentCheck);
			
		//系统测量
		SystemMeasure sm=new SystemMeasure();
		sm.setPvANDisOutValue(form.getPvANDisOutValue());
		sm.setPvANMeaInValue(form.getPvANMeaInValue());
		sm.setPvANMeaOutValue(form.getPvANMeaOutValue());
		sm.setPvANRemark(form.getPvANRemark());
		sm.setPvBNDisOutValue(form.getPvBNDisOutValue());
		sm.setPvBNMeaInValue(form.getPvBNMeaInValue());
		sm.setPvBNMeaOutValue(form.getPvBNMeaOutValue());
		sm.setPvBNRemark(form.getPvBNRemark());
		sm.setPvCNDisOutValue(form.getPvCNDisOutValue());
		sm.setPvCNMeaInValue(form.getPvCNMeaInValue());
		sm.setPvCNMeaOutValue(form.getPvCNMeaOutValue());
		sm.setPvCNRemark(form.getPvCNRemark());
		sm.setLvABDisOutValue(form.getLvABDisOutValue());
		sm.setLvABMeaInValue(form.getLvABMeaInValue());
		sm.setLvABMeaOutValue(form.getLvABMeaOutValue());
		sm.setLvABRemark(form.getLvABRemark());
		sm.setLvACDisOutValue(form.getLvACDisOutValue());
		sm.setLvACMeaInValue(form.getLvACMeaInValue());
		sm.setLvACMeaOutValue(form.getLvACMeaOutValue());
		sm.setLvACRemark(form.getLvACRemark());
		sm.setLvBCDisOutValue(form.getLvBCDisOutValue());
		sm.setLvBCMeaInValue(form.getLvBCMeaInValue());
		sm.setLvBCMeaOutValue(form.getLvBCMeaOutValue());
		sm.setLvBCRemark(form.getLvBCRemark());
		sm.setPcADisOutValue(form.getPcADisOutValue());
		sm.setPcAMeaInValue(form.getPcAMeaInValue());
		sm.setPcAMeaOutValue(form.getPcAMeaOutValue());
		sm.setPcARemark(form.getPcARemark());
		sm.setPcBDisOutValue(form.getPcBDisOutValue());
		sm.setPcBMeaInValue(form.getPcBMeaInValue());
		sm.setPcBMeaOutValue(form.getPcBMeaOutValue());
		sm.setPcBRemark(form.getPcBRemark());
		sm.setPcCDisOutValue(form.getPcCDisOutValue());
		sm.setPcCMeaInValue(form.getPcCMeaInValue());
		sm.setPcCMeaOutValue(form.getPcCMeaOutValue());
		sm.setPcCRemark(form.getPcCRemark());
		sm.setPpADisOutValue(form.getPpADisOutValue());
		sm.setPpAMeaCalValue(form.getPpAMeaCalValue());
		sm.setPpARemark(form.getPpARemark());
		sm.setPpBDisOutValue(form.getPpBDisOutValue());
		sm.setPpBMeaCalValue(form.getPpBMeaCalValue());
		sm.setPpBRemark(form.getPpBRemark());
		sm.setPpCDisOutValue(form.getPpCDisOutValue());
		sm.setPpCMeaCalValue(form.getPpCMeaCalValue());
		sm.setPpCRemark(form.getPpCRemark());
		sm.setUpsCheck(upsCheck);
		systemMeasureDao.save(sm);
		
		//零地电压及零线电流测量
		ZgvZlcMeasure zm=new ZgvZlcMeasure();
		zm.setZgvInputResult(form.getZgvInputResult());
		zm.setZgvInputRemark(form.getZgvInputRemark());
		zm.setZgvOutputResult(form.getZgvOutputResult());
		zm.setZgvOutputRemark(form.getZgvOutputRemark());
		zm.setZlcInputResult(form.getZlcInputResult());
		zm.setZlcInputRemark(form.getZlcInputRemark());
		zm.setZlcOutputResult(form.getZlcOutputResult());
		zm.setZlcOutputRemark(form.getZlcOutputRemark());
		//20160802 renyujuan
		zm.setZgvInputMeasure(form.getZgvInputMeasure());
		zm.setZgvOutputMeasure(form.getZgvOutputMeasure());
		zm.setZlcInputMeasure(form.getZlcInputMeasure());
		zm.setZlcOutputMeasure(form.getZlcOutputMeasure());
		zm.setUpsCheck(upsCheck);
		zgvZlcMeasuredao.save(zm);

		//电池测量
		if((dealbatMea(number,termialV,interR,remarks))!= null){
			List<BatteryMeasure> bmli=dealbatMea(number,termialV,interR,remarks);
			for(BatteryMeasure bm : bmli){
				//System.err.println(bm.toString());
				bm.setUpsCheck(upsCheck);
				batteryMeasureDao.save(bm);
			}
		}
		
		//放电测试
		DischargeTest dt=new DischargeTest();
		dt.setStartTime(DateUtilTools.parseDate(form.getStartTime(),DateUtilTools.PATTERN_DATE_3));
		dt.setEndTime(DateUtilTools.parseDate(form.getEndTime(), DateUtilTools.PATTERN_DATE_3));
		dt.setDurationTime(form.getDurationTime());
		dt.setPreTotalV(form.getPreTotalV());
		dt.setEndTotalV(form.getEndTotalV());
		dt.setBatChargingC(form.getBatChargingC());
		dt.setUpsCheck(upsCheck);
		dischargeTestDao.save(dt);
		
		//放电过程
		if((dealdispro(dsTime, batTotalV, dsCurrent, singleMaxV, singleMinV, remark))!= null){
			List<DischargeProcess> dps=dealdispro(dsTime, batTotalV, dsCurrent, singleMaxV, singleMinV, remark);
			System.err.println(dps.toString());
			for(DischargeProcess dp : dps){
				dp.setDischargeTest(dt);
				dischargeProcessDao.save(dp);
			}
		}
		
		
		//系统连接检查
		SystemConnMeasure scm=new SystemConnMeasure();
		scm.setUpsIcTr(form.getUpsIcTr());
		scm.setUpsIcRemark(form.getUpsIcRemark());
		scm.setUpsFRunTr(form.getUpsFRunTr());
		scm.setUpsFRunRemark(form.getUpsFRunRemark());
		scm.setUpsIbFirmTr(form.getUpsIbFirmTr());
		scm.setUpsIbFirmRemark(form.getUpsIbFirmRemark());
		scm.setUpsCwOhTr(form.getUpsCwOhTr());
		scm.setUpsCwOhRemark(form.getUpsCwOhRemark());
		scm.setUpsRvTr(form.getUpsRvTr());
		scm.setUpsRvRemark(form.getUpsRvRemark());
		scm.setBatCTr(form.getBatCTr());
		scm.setBatCRemark(form.getBatCRemark());
		scm.setUpsPdcIowTr(form.getUpsPdcIowTr());
		scm.setUpsPdcIowRemark(form.getUpsPdcIowRemark());
		scm.setBpdbTr(form.getBpdbTr());
		scm.setBpdbRemark(form.getBpdbRemark());
		scm.setPdcCTr(form.getPdcCTr());
		scm.setPdcCRemark(form.getPdcCRemark());
		scm.setPdcMIlTr(form.getPdcMIlTr());
		scm.setPdcMIlRemark(form.getPdcMIlRemark());
		scm.setBfnRemark(form.getBfnRemark());
		scm.setBfnTr(form.getBfnTr());
		scm.setLtCwFTr(form.getLtCwFTr());
		scm.setLtCwFRemark(form.getLtCwFRemark());
		scm.setLtLcTr(form.getLtLcTr());
		scm.setLtLcRemark(form.getLtLcRemark());
		scm.setLtSTr(form.getLtSTr());
		scm.setLtSRemark(form.getLtSRemark());
		scm.setUpsCheck(upsCheck);
		//System.err.println(scm.toString());
		systemConnMeasureDao.save(scm);
	}
	/**
	 * 保存ups设备月检记录
	 * @author renyujuan
	 * @date 2016年8月3日上午10:05:20
	 * @param form
	 * @param termialV
	 * @param interR
	 * @param remarks
	 */
	@Override
    public void save(UpsMonthAddForm form, List<Integer> number,
	    List<String> termialV, List<String> interR, List<String> remarks) {
    	// 添加ups巡检记录
    	EnvironmentEquipCheck upsCheck = new EnvironmentEquipCheck();
    	upsCheck.setName(form.getName());
    	upsCheck.setOperator(form.getOperator());
    	upsCheck.setProblem(form.getProblem());
    	upsCheck.setSuggestion(form.getSuggestion());
    	upsCheck.setResult(form.getResult());
    	upsCheck.setEquipType(form.getEquipType());
    	upsCheck.setCheckType(form.getCheckType());
    	// System.err.println(form.getCheckTime());
    	upsCheck.setCheckTime(DateUtilTools.parseDate(form.getCheckTime(),
    		DateUtilTools.PATTERN_DATE_3));
    	upsCheck.setCheckDate(DateUtilTools.parseDate(form.getCheckDate(),
    		DateUtilTools.PATTERN_DATE_1));
    	// System.err.println(upsCheck.getCheckTime().toString());
    	// System.err.println(upsCheck.getCheckDate().toString());
    	environmentEquipCheckDao.save(upsCheck);
    
    	// 添加内容检查
    	UpsContentCheck upsContentCheck = new UpsContentCheck();
    	upsContentCheck.setTemperature(form.getTemperature());
    	upsContentCheck.setAtIsAdjustable(form.getAtIsAdjustable());
    	upsContentCheck.setHumidity(form.getHumidity());
    	upsContentCheck.setEaIsIntact(form.getEaIsIntact());
    	upsContentCheck.setRadiateIsNormal(form.getRadiateIsNormal());
    	upsContentCheck.setEsGroundVoltage(form.getEsGroundVoltage());
    	upsContentCheck.setUpsRvIsNormal(form.getUpsRvIsNormal());
    	upsContentCheck.setUpsUidisIsNormal(form.getUpsUidisIsNormal());
    	upsContentCheck.setRaIsFlow(form.getRaIsFlow());
    	upsContentCheck.setBatLeakage(form.getBatLeakage());
    	upsContentCheck.setUpsOutletIsClean(form.getUpsOutletIsClean());
    	upsContentCheck.setBatSurfaceIsClean(form.getBatSurfaceIsClean());
    	upsContentCheck.setConnCo(form.getConnCo());
    	upsContentCheck.setUpsCurFAlarm(form.getUpsCurFAlarm());
    	upsContentCheck.setUpsHisFAlarm(form.getUpsHisFAlarm());
    	upsContentCheck.setInputVLN(form.getInputVLN());
    	upsContentCheck.setInputVLD(form.getInputVLD());
    	upsContentCheck.setInputVND(form.getInputVND());
    	upsContentCheck.setInputCurrent(form.getInputCurrent());
    	upsContentCheck.setLoadCapacity(form.getLoadCapacity());
    	upsContentCheck.setInputAirTemperature(form.getInputAirTemperature());
    	upsContentCheck.setInputCableTemperature(form
    		.getInputCableTemperature());
    	upsContentCheck.setOutputVLN(form.getOutputVLN());
    	upsContentCheck.setOutputVLD(form.getOutputVLD());
    	upsContentCheck.setOutputVND(form.getOutputVND());
    	upsContentCheck.setOutputCurrent(form.getOutputCurrent());
    	upsContentCheck.setOutputAirTemperature(form.getOutputAirTemperature());
    	upsContentCheck.setEquipDustRemoval(form.getEquipDustRemoval());
    	upsContentCheck.setUpsCheck(upsCheck);
    	upsContentCheckDao.save(upsContentCheck);
    
    	// 系统测量
    	SystemMeasure sm = new SystemMeasure();
    	sm.setPvANDisOutValue(form.getPvANDisOutValue());
    	sm.setPvANMeaInValue(form.getPvANMeaInValue());
    	sm.setPvANMeaOutValue(form.getPvANMeaOutValue());
    	sm.setPvANRemark(form.getPvANRemark());
    	sm.setPvBNDisOutValue(form.getPvBNDisOutValue());
    	sm.setPvBNMeaInValue(form.getPvBNMeaInValue());
    	sm.setPvBNMeaOutValue(form.getPvBNMeaOutValue());
    	sm.setPvBNRemark(form.getPvBNRemark());
    	sm.setPvCNDisOutValue(form.getPvCNDisOutValue());
    	sm.setPvCNMeaInValue(form.getPvCNMeaInValue());
    	sm.setPvCNMeaOutValue(form.getPvCNMeaOutValue());
    	sm.setPvCNRemark(form.getPvCNRemark());
    	sm.setLvABDisOutValue(form.getLvABDisOutValue());
    	sm.setLvABMeaInValue(form.getLvABMeaInValue());
    	sm.setLvABMeaOutValue(form.getLvABMeaOutValue());
    	sm.setLvABRemark(form.getLvABRemark());
    	sm.setLvACDisOutValue(form.getLvACDisOutValue());
    	sm.setLvACMeaInValue(form.getLvACMeaInValue());
    	sm.setLvACMeaOutValue(form.getLvACMeaOutValue());
    	sm.setLvACRemark(form.getLvACRemark());
    	sm.setLvBCDisOutValue(form.getLvBCDisOutValue());
    	sm.setLvBCMeaInValue(form.getLvBCMeaInValue());
    	sm.setLvBCMeaOutValue(form.getLvBCMeaOutValue());
    	sm.setLvBCRemark(form.getLvBCRemark());
    	sm.setPcADisOutValue(form.getPcADisOutValue());
    	sm.setPcAMeaInValue(form.getPcAMeaInValue());
    	sm.setPcAMeaOutValue(form.getPcAMeaOutValue());
    	sm.setPcARemark(form.getPcARemark());
    	sm.setPcBDisOutValue(form.getPcBDisOutValue());
    	sm.setPcBMeaInValue(form.getPcBMeaInValue());
    	sm.setPcBMeaOutValue(form.getPcBMeaOutValue());
    	sm.setPcBRemark(form.getPcBRemark());
    	sm.setPcCDisOutValue(form.getPcCDisOutValue());
    	sm.setPcCMeaInValue(form.getPcCMeaInValue());
    	sm.setPcCMeaOutValue(form.getPcCMeaOutValue());
    	sm.setPcCRemark(form.getPcCRemark());
    	sm.setPpADisOutValue(form.getPpADisOutValue());
    	sm.setPpAMeaCalValue(form.getPpAMeaCalValue());
    	sm.setPpARemark(form.getPpARemark());
    	sm.setPpBDisOutValue(form.getPpBDisOutValue());
    	sm.setPpBMeaCalValue(form.getPpBMeaCalValue());
    	sm.setPpBRemark(form.getPpBRemark());
    	sm.setPpCDisOutValue(form.getPpCDisOutValue());
    	sm.setPpCMeaCalValue(form.getPpCMeaCalValue());
    	sm.setPpCRemark(form.getPpCRemark());
    	sm.setUpsCheck(upsCheck);
    	systemMeasureDao.save(sm);
    
    	// 零地电压及零线电流测量
    	ZgvZlcMeasure zm = new ZgvZlcMeasure();
    	zm.setZgvInputResult(form.getZgvInputResult());
    	zm.setZgvInputRemark(form.getZgvInputRemark());
    	zm.setZgvOutputResult(form.getZgvOutputResult());
    	zm.setZgvOutputRemark(form.getZgvOutputRemark());
    	zm.setZlcInputResult(form.getZlcInputResult());
    	zm.setZlcInputRemark(form.getZlcInputRemark());
    	zm.setZlcOutputResult(form.getZlcOutputResult());
    	zm.setZlcOutputRemark(form.getZlcOutputRemark());
    	// 20160802 renyujuan
    	zm.setZgvInputMeasure(form.getZgvInputMeasure());
    	zm.setZgvOutputMeasure(form.getZgvOutputMeasure());
    	zm.setZlcInputMeasure(form.getZlcInputMeasure());
    	zm.setZlcOutputMeasure(form.getZlcOutputMeasure());
    	zm.setUpsCheck(upsCheck);
    	zgvZlcMeasuredao.save(zm);
    
    	// 电池测量
    	if ((dealbatMea(number, termialV, interR, remarks)) != null) {
    	    List<BatteryMeasure> bmli = dealbatMea(number, termialV, interR,
    		    remarks);
    	    // System.err.println(bmli.toString());
    	    for (BatteryMeasure bm : bmli) {
    		// System.err.println(bm.toString());
    		bm.setUpsCheck(upsCheck);
    		batteryMeasureDao.save(bm);
    	    }
    	}
    
    	// 系统连接检查
    	SystemConnMeasure scm = new SystemConnMeasure();
    	scm.setUpsIcTr(form.getUpsIcTr());
    	scm.setUpsIcRemark(form.getUpsIcRemark());
    	scm.setUpsFRunTr(form.getUpsFRunTr());
    	scm.setUpsFRunRemark(form.getUpsFRunRemark());
    	scm.setUpsIbFirmTr(form.getUpsIbFirmTr());
    	scm.setUpsIbFirmRemark(form.getUpsIbFirmRemark());
    	scm.setUpsCwOhTr(form.getUpsCwOhTr());
    	scm.setUpsCwOhRemark(form.getUpsCwOhRemark());
    	scm.setUpsRvTr(form.getUpsRvTr());
    	scm.setUpsRvRemark(form.getUpsRvRemark());
    	scm.setBatCTr(form.getBatCTr());
    	scm.setBatCRemark(form.getBatCRemark());
    	scm.setUpsPdcIowTr(form.getUpsPdcIowTr());
    	scm.setUpsPdcIowRemark(form.getUpsPdcIowRemark());
    	scm.setBpdbTr(form.getBpdbTr());
    	scm.setBpdbRemark(form.getBpdbRemark());
    	scm.setPdcCTr(form.getPdcCTr());
    	scm.setPdcCRemark(form.getPdcCRemark());
    	scm.setPdcMIlTr(form.getPdcMIlTr());
    	scm.setPdcMIlRemark(form.getPdcMIlRemark());
    	scm.setBfnRemark(form.getBfnRemark());
    	scm.setBfnTr(form.getBfnTr());
    	scm.setLtCwFTr(form.getLtCwFTr());
    	scm.setLtCwFRemark(form.getLtCwFRemark());
    	scm.setLtLcTr(form.getLtLcTr());
    	scm.setLtLcRemark(form.getLtLcRemark());
    	scm.setLtSTr(form.getLtSTr());
    	scm.setLtSRemark(form.getLtSRemark());
    	scm.setUpsCheck(upsCheck);
    	// System.err.println(scm.toString());
    	systemConnMeasureDao.save(scm);
    }
	
    @Override
    public void saveDgCheck(DgAddForm form) {
        if (!ObjectUtils.equals(form, null)) {
            // 添加dg巡检记录
            EnvironmentEquipCheck dgCheck = new EnvironmentEquipCheck();
            dgCheck.setName(form.getName());
            dgCheck.setOperator(form.getOperator());
            dgCheck.setEquipType(form.getEquipType());
            dgCheck.setCheckType(form.getCheckType());
            dgCheck.setCheckTime(DateUtilTools.parseDate(form.getCheckTime(),
        	    DateUtilTools.PATTERN_DATE_3));
            dgCheck.setCheckDate(DateUtilTools.parseDate(form.getCheckDate(),
        	    DateUtilTools.PATTERN_DATE_1));
            environmentEquipCheckDao.save(dgCheck);
            /* 添加dgCheckContent记录 */
            DgCheckContent dcc = new DgCheckContent();
            dcc.setEnCheckResult(form.getEnCheckResult());
            dcc.setEnRemarks(form.getEnRemarks());
            dcc.setBhCheckResult(form.getBhCheckResult());
            dcc.setBhRemarks(form.getBhRemarks());
            dcc.setEcpiCheckResult(form.getEcpiCheckResult());
            dcc.setEcpiRemarks(form.getEcpiRemarks());
            dcc.setRmhCheckResult(form.getRmhCheckResult());
            dcc.setRmhRemarks(form.getRmhRemarks());
            dcc.setErcCheckResult(form.getErcCheckResult());
            dcc.setErcRemarks(form.getErcRemarks());
            dcc.setAtsNumoneCheckResult(form.getAtsNumoneCheckResult());
            dcc.setAtsNumoneRemarks(form.getAtsNumoneRemarks());
            dcc.setAtsNumtwoCheckResult(form.getAtsNumtwoCheckResult());
            dcc.setAtsNumtwoRemarks(form.getAtsNumtwoRemarks());
            dcc.setUshCheckResult(form.getUshCheckResult());
            dcc.setUshRemarks(form.getUshRemarks());
            dcc.setCableTestResult(form.getCableTestResult());
            dcc.setCableTestRemarks(form.getCableTestRemarks());
            dcc.setLpCheckResult(form.getLpCheckResult());
            dcc.setLpRemarks(form.getLpRemarks());
            dcc.setFpCheckResult(form.getFpCheckResult());
            dcc.setFpRemarks(form.getFpRemarks());
            dcc.setOsCheckResult(form.getOsCheckResult());
            dcc.setOsRemarks(form.getOsRemarks());
            dcc.setCsCheckResult(form.getCsCheckResult());
            dcc.setCsRemarks(form.getCsRemarks());
            dcc.setFsCheckResult(form.getFsCheckResult());
            dcc.setFsRemarks(form.getFsRemarks());
            dcc.setBlCheckResult(form.getBlCheckResult());
            dcc.setBlRemarks(form.getBlRemarks());
            dcc.setEbCheckResult(form.getEbCheckResult());
            dcc.setEbRemarks(form.getEbRemarks());
            dcc.setAsCheckResult(form.getAsCheckResult());
            dcc.setAsRemarks(form.getAsRemarks());
            dcc.setRsCheckResult(form.getRsCheckResult());
            dcc.setRsRemarks(form.getRsRemarks());
            dcc.setAutosCheckResult(form.getAutosCheckResult());
            dcc.setAutosRemarks(form.getAutosRemarks());
            dcc.setSbvCheckResult(form.getSbvCheckResult());
            dcc.setSbvRemarks(form.getSbvRemarks());
            dcc.setDopCheckResult(form.getDopCheckResult());
            dcc.setDopRemarks(form.getDopRemarks());
            dcc.setOpCheckResult(form.getOpCheckResult());
            dcc.setOpRemarks(form.getOpRemarks());
            dcc.setPfCheckResult(form.getPfCheckResult());
            dcc.setPfRemarks(form.getPfRemarks());
            dcc.setEpCheckResult(form.getEpCheckResult());
            dcc.setEpRemarks(form.getEpRemarks());
            dcc.setEwtCheckResult(form.getEwtCheckResult());
            dcc.setEwtRemarks(form.getEwtRemarks());
            /* 相电压A-N B-N C-N */
            dcc.setPvANCheckResult(form.getPvANCheckResult());
            dcc.setPvANRemarks(form.getPvANRemarks());
            dcc.setPvBNCheckResult(form.getPvBNCheckResult());
            dcc.setPvBNRemarks(form.getPvBNRemarks());
            dcc.setPvCNCheckResult(form.getPvCNCheckResult());
            dcc.setPvCNRemarks(form.getPvCNRemarks());
            /* 线电压A-B A-C B-C */
            dcc.setLvABCheckResult(form.getLvABCheckResult());
            dcc.setLvABRemarks(form.getLvABRemarks());
            dcc.setLvACCheckResult(form.getLvACCheckResult());
            dcc.setLvACRemarks(form.getLvACRemarks());
            dcc.setLvBCCheckResult(form.getLvBCCheckResult());
            dcc.setLvBCRemarks(form.getLvBCRemarks());
            /* 电流A相，B相，C相 */
            dcc.setCaCheckResult(form.getCaCheckResult());
            dcc.setCaRemarks(form.getCaRemarks());
            dcc.setCbCheckResult(form.getCbCheckResult());
            dcc.setCbRemarks(form.getCbRemarks());
            dcc.setCcCheckResult(form.getCcCheckResult());
            dcc.setCcRemarks(form.getCcRemarks());
            /* 功率A相，B相，C相 */
            dcc.setPaCheckResult(form.getPaCheckResult());
            dcc.setPaRemarks(form.getPaRemarks());
            dcc.setPbCheckResult(form.getPbCheckResult());
            dcc.setPbRemarks(form.getPbRemarks());
            dcc.setPcCheckResult(form.getPcCheckResult());
            dcc.setPcRemarks(form.getPcRemarks());
            dcc.setDgCheck(dgCheck);
            dgCheckContentDao.save(dcc);
        }
    }

    /**
     * 保存空调设备巡检记录
     * @param form
     */
    @Override
    public void saveAccCheck(AccAddForm form) {

        /* 添加环境设备空调设备巡检记录 */
        EnvironmentEquipCheck accCheck = new EnvironmentEquipCheck();
        accCheck.setName(form.getName());
        accCheck.setOperator(form.getOperator());
        accCheck.setProblem(form.getProblem());
        accCheck.setSuggestion(form.getSuggestion());
        accCheck.setResult(form.getResult());
        accCheck.setEquipType(form.getEquipType());
        accCheck.setCheckType(form.getCheckType());
        accCheck.setCheckTime(DateUtilTools.parseDate(form.getCheckTime(),
                DateUtilTools.PATTERN_DATE_3));
        accCheck.setCheckDate(DateUtilTools.parseDate(form.getCheckDate(),
                DateUtilTools.PATTERN_DATE_1));
        environmentEquipCheckDao.save(accCheck);

        /* 添加空调设备巡检内容记录 */
        AccCheckContent acc = new AccCheckContent();
        acc.setMfrStatus(form.getMfrStatus());
        acc.setMfrRemarks(form.getMfrRemarks());
        acc.setFsStatus(form.getFsStatus());
        acc.setFsRemarks(form.getFsRemarks());
        acc.setCwppStatus(form.getCwppStatus());
        acc.setCwppRemarks(form.getCwppRemarks());
        acc.setEfStatus(form.getEfStatus());
        acc.setEfRemarks(form.getEfRemarks());
        acc.setEsRemarks(form.getEsRemarks());
        acc.setEsStatus(form.getEsStatus());
        acc.setEeRemarks(form.getEeRemarks());
        acc.setEeStatus(form.getEeStatus());
        acc.setWpStatus(form.getWpStatus());
        acc.setWpRemarks(form.getWpRemarks());
        acc.setHwlwRemarks(form.getHwlwRemarks());
        acc.setHwlwStatus(form.getHwlwStatus());
        acc.setAcwsRemarks(form.getAcwsRemarks());
        acc.setAcwsStatus(form.getAcwsStatus());
        acc.setActRemarks(form.getActRemarks());
        acc.setActStatus(form.getActStatus());
        acc.setAcvcRemarks(form.getAcvcRemarks());
        acc.setAcvcStatus(form.getAcvcStatus());
        acc.setDplWfRemarks(form.getDplWfRemarks());
        acc.setDplWfStatus(form.getDplWfStatus());
        acc.setMirrorRemarks(form.getMirrorRemarks());
        acc.setMirrorStatus(form.getMirrorStatus());
        acc.setSepRemarks(form.getSepRemarks());
        acc.setSepStatus(form.getSepStatus());
        acc.setRpRemarks(form.getRpRemarks());
        acc.setRpStatus(form.getRpStatus());
        acc.setCocRemarks(form.getCocRemarks());
        acc.setCocStatus(form.getCocStatus());
        acc.setOacuprStatus(form.getOacuprStatus());
        acc.setOacurpRemarks(form.getOacurpRemarks());
        acc.setMbfRemarks(form.getMbfRemarks());
        acc.setMbfStatus(form.getMbfStatus());
        acc.setChrfRemarks(form.getChrfRemarks());
        acc.setChrfStatus(form.getChrfStatus());
        acc.setWpbRemarks(form.getWpbRemarks());
        acc.setWpbStatus(form.getWpbStatus());
        acc.setWsbDpRemarks(form.getWsbDpRemarks());
        acc.setWpbStatus(form.getWpbStatus());
        acc.setWsbDpRemarks(form.getWsbDpRemarks());
        acc.setWsbDpStatus(form.getWsbDpStatus());
        acc.setAchRemarks(form.getAchRemarks());
        acc.setAchStatus(form.getAchStatus());
        acc.setHwcRemarks(form.getHwcRemarks());
        acc.setHwcStatus(form.getHwcStatus());
        acc.setPslRemarks(form.getPslRemarks());
        acc.setPslStatus(form.getPslStatus());
        acc.setConnRemarks(form.getConnRemarks());
        acc.setConnStatus(form.getConnStatus());
        acc.setEcpRemarks(form.getEcpRemarks());
        acc.setEcpStatus(form.getEcpStatus());
        acc.setRcEcRemarks(form.getRcEcRemarks());
        acc.setRcEcStatus(form.getRcEcStatus());
        acc.setHtRemarks(form.getHtRemarks());
        acc.setHtStatus(form.getHtStatus());
        acc.setCpRemarks(form.getCpRemarks());
        acc.setCpStatus(form.getCpStatus());
        acc.setAccCheck(accCheck);
        accCheckContentDao.save(acc);
        /* 添加数据记录 */
        AccDataRecord adr = new AccDataRecord();
        adr.setTvRemarks(form.getTvRemarks());
        adr.setTvStatus(form.getTvStatus());
        adr.setTvValue(form.getTvValue());
        adr.setTcRemarks(form.getTcRemarks());
        adr.setTcStatus(form.getTcStatus());
        adr.setTcValue(form.getTcValue());
        adr.setCcValue(form.getCcValue());
        adr.setCcRemarks(form.getCcRemarks());
        adr.setCcStatus(form.getCcStatus());
        adr.setCconeRemarks(form.getCconeRemarks());
        adr.setCconeStatus(form.getCconeStatus());
        adr.setCconeValue(form.getCconeValue());
        adr.setCctwoRemarks(form.getCctwoRemarks());
        adr.setCctwoStatus(form.getCctwoStatus());
        adr.setCctwoValue(form.getCctwoValue());
        adr.setMfcRemarks(form.getMfcRemarks());
        adr.setMfcStatus(form.getMfcStatus());
        adr.setMfcValue(form.getMfcValue());
        adr.setOmcRemarks(form.getOmcRemarks());
        adr.setOmcStatus(form.getOmcStatus());
        adr.setOmcValue(form.getOmcValue());
        adr.setAothRemarks(form.getAothRemarks());
        adr.setAothStatus(form.getAothStatus());
        adr.setAothValue(form.getAothValue());
        adr.setAowsRemarks(form.getAowsRemarks());
        adr.setAowsStatus(form.getAowsStatus());
        adr.setAowsValue(form.getAowsValue());
        adr.setHcValue(form.getHcValue());
        adr.setHcRemarks(form.getHcRemarks());
        adr.setHcStatus(form.getHcStatus());
        adr.setHcaRemarks(form.getHcaRemarks());
        adr.setHcaStatus(form.getHcaStatus());
        adr.setHcaValue(form.getHcaValue());
        adr.setHcbRemarks(form.getHcbRemarks());
        adr.setHcbStatus(form.getHcbStatus());
        adr.setHcbValue(form.getHcbValue());
        adr.setHccRemarks(form.getHccRemarks());
        adr.setHccStatus(form.getHccStatus());
        adr.setHccValue(form.getHccValue());
        adr.setAccCheck(accCheck);
        accDataRecordDao.save(adr);
    }

    /**
     * 保存传输设备与通讯线路巡检记录
     * @author renyujuan
     * @time:2016年8月17日 下午1:34:28
     * @param form
     */
    @Override
    public void savePsOtCheck(PsOtAddForm form) {
        /* 添加环境设备传输设备与通讯线路巡检记录 */
        EnvironmentEquipCheck psOtCheck = new EnvironmentEquipCheck();
        psOtCheck.setName(form.getName());
        psOtCheck.setOperator(form.getOperator());
        System.err.println(psOtCheck.getOperator());
        psOtCheck.setProblem(form.getProblem());
        psOtCheck.setSuggestion(form.getSuggestion());
        psOtCheck.setResult(form.getResult());
        psOtCheck.setEquipType(form.getEquipType());
        psOtCheck.setCheckType(form.getCheckType());
        psOtCheck.setCheckTime(DateUtilTools.parseDate(form.getCheckTime(),
                DateUtilTools.PATTERN_DATE_3));
        psOtCheck.setCheckDate(DateUtilTools.parseDate(form.getCheckDate(),
                DateUtilTools.PATTERN_DATE_1));
        environmentEquipCheckDao.save(psOtCheck);
        
        /*封装内容询价记录实体*/
        PsOtCheckContent pocc = new PsOtCheckContent();
        pocc.setEoeFanCheckResult(form.getEoeFanCheckResult());
        pocc.setEoeFanRemarks(form.getEoeFanRemarks());
        pocc.setEoeTemCheckResult(form.getEoeTemCheckResult());
        pocc.setEoeTemRemarks(form.getEoeTemRemarks());
        pocc.setEoeHumCheckResult(form.getEoeHumCheckResult());
        pocc.setEoeHumRemarks(form.getEoeHumRemarks());
        pocc.setScreenCheckResult(form.getScreenCheckResult());
        pocc.setScreenRemarks(form.getScreenRemarks());
        pocc.setDisCheckResult(form.getDisCheckResult());
        pocc.setDisRemarks(form.getDisRemarks());
        pocc.setCrsCheckResult(form.getCrsCheckResult());
        pocc.setCrsRemarks(form.getCrsRemarks());
        pocc.setDlccCheckResult(form.getDlccCheckResult());
        pocc.setDlccRemarks(form.getDlccRemarks());
        pocc.setPscCheckResult(form.getPscCheckResult());
        pocc.setPscRemarks(form.getPscRemarks());
        pocc.setAcivCheckResult(form.getAcivCheckResult());
        pocc.setAcivRemarks(form.getAcivRemarks());
        pocc.setDcovCheckResult(form.getDcovCheckResult());
        pocc.setDcovRemarks(form.getDcovRemarks());
        pocc.setBvCheckResult(form.getBvCheckResult());
        pocc.setBvRemarks(form.getBvRemarks());
        pocc.setBirCheckResult(form.getBirCheckResult());
        pocc.setBirRemarks(form.getBirRemarks());
        pocc.setBatteryConnRemarks(form.getBatteryConnRemarks());
        pocc.setBatteryConnResult(form.getBatteryConnResult());
        pocc.setInverterCheckResult(form.getInverterCheckResult());
        pocc.setInverterRemarks(form.getInverterRemarks());
        pocc.setInsuranceCheckResult(form.getInsuranceCheckResult());
        pocc.setInsuranceRemarks(form.getInsuranceRemarks());
        pocc.setEcCheckResult(form.getEcCheckResult());
        pocc.setEcRemarks(form.getEcRemarks());
        pocc.setGpCheckResult(form.getGpCheckResult());
        pocc.setGpRemarks(form.getGpRemarks());
        pocc.setDdfOdfCheckResult(form.getDdfOdfCheckResult());
        pocc.setDdfOdfRemarks(form.getDdfOdfRemarks());
        pocc.setOcuCheckResult(form.getOcuCheckResult());
        pocc.setOcuRemarks(form.getOcuRemarks());
        pocc.setOfcCheckResult(form.getOfcCheckResult());
        pocc.setOfcRemarks(form.getOfcRemarks());
        pocc.setCmuCheckResult(form.getCmuCheckResult());
        pocc.setCmuRemarks(form.getCmuRemarks());
        pocc.setMcbaCheckResult(form.getMcbaCheckResult());
        pocc.setMcbaRemarks(form.getMcbaRemarks());
        pocc.setCba1CheckResult(form.getCba1CheckResult());
        pocc.setCba1Remarks(form.getCba1Remarks());
        pocc.setCba2CheckResult(form.getCba2CheckResult());
        pocc.setCba2Remarks(form.getCba2Remarks());
        pocc.setCba3CheckResult(form.getCba3CheckResult());
        pocc.setCba3Remarks(form.getCba3Remarks());
        pocc.setCbae1CheckResult(form.getCbae1CheckResult());
        pocc.setCbae1Remarks(form.getCbae1Remarks());
        pocc.setMcbbCheckResult(form.getMcbbCheckResult());
        pocc.setMcbbRemarks(form.getMcbbRemarks());
        pocc.setCbb1v35CheckResult(form.getCbb1v35CheckResult());
        pocc.setCbb1v35Remarks(form.getCbb1v35Remarks());
        pocc.setCbb2v35CheckResult(form.getCbb2v35CheckResult());
        pocc.setCbb2v35Remarks(form.getCbb2v35Remarks());
        pocc.setCbb3v35CheckResult(form.getCbb2v35CheckResult());
        pocc.setCbb3v35Remarks(form.getCbb3v35Remarks());
        pocc.setCbb1v24CheckResult(form.getCbb1v24CheckResult());
        pocc.setCbb1v24Remarks(form.getCbb1v24Remarks());
        pocc.setCbb2v24CheckResult(form.getCbb2v24CheckResult());
        pocc.setCbb2v24Remarks(form.getCbb2v24Remarks());
        pocc.setCbb3v24CheckResult(form.getCbb3v24CheckResult());
        pocc.setCbb3v24Remarks(form.getCbb3v24Remarks());
        pocc.setCbbe1CheckResult(form.getCbbe1CheckResult());
        pocc.setCbbe1Remarks(form.getCbbe1Remarks());
        pocc.setV35icCheckResult(form.getV35icCheckResult());
        pocc.setV35icRemarks(form.getV35icRemarks());
        pocc.setV24icCheckResult(form.getV24icCheckResult());
        pocc.setV24icRemarks(form.getV24icRemarks());
        pocc.setMonthLrs(form.getMonthLrs());
        pocc.setMonthLas(form.getMonthLas());
        pocc.setMonthLcs(form.getMonthLcs());
        pocc.setMonthLfs(form.getMonthLfs());
        pocc.setMonthLcsc(form.getMonthLcsc());
        pocc.setUnderTlDlwrCheckResult(form.getUnderTlDlwrCheckResult());
        pocc.setUnderTlDlwrRemarks(form.getUnderTlDlwrRemarks());
        pocc.setFfTlDlwrCheckResult(form.getFfTlDlwrCheckResult());
        pocc.setFfTlDlwrRemarks(form.getFfTlDlwrRemarks());
        pocc.setFsTlDlwrCheckResult(form.getFsTlDlwrCheckResult());
        pocc.setFsTlDlwrRemarks(form.getFsTlDlwrRemarks());
        pocc.setFtTlDlwrCheckResult(form.getFtTlDlwrCheckResult());
        pocc.setFtTlDlwrRemarks(form.getFtTlDlwrRemarks());
        pocc.setFfoTlDlwrCheckResult(form.getFfoTlDlwrCheckResult());
        pocc.setFfoTlDlwrRemarks(form.getFfoTlDlwrRemarks());
        pocc.setFfiTlDlwrCheckResult(form.getFfiTlDlwrCheckResult());
        pocc.setFfiTlDlwrRemarks(form.getFfiTlDlwrRemarks());
        pocc.setFsiTlDlwrCheckResult(form.getFsiTlDlwrCheckResult());
        pocc.setFsiTlDlwrRemarks(form.getFsiTlDlwrRemarks());
        pocc.setPsOtCheck(psOtCheck);
        psOtCheckContentDao.save(pocc);
    }
    
	/**
	 * 更新ups月检记录
	 * @author renyujuan
	 * @date 2016年8月3日上午10:13:35
	 * @param upsCheck
	 * @param form
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @return
	 */
    @Override
    public EnvironmentEquipCheck update(EnvironmentEquipCheck upsCheck,
            UpsMonthAddForm form, List<String> termialV, List<String> interR,
            List<String> remarks) {
        if (!ObjectUtils.equals(upsCheck, null)) {
            // 封装upsCheck实体
            // upsCheck.setName(form.getName());
            // upsCheck.setOperator(form.getOperator());
            upsCheck.setProblem(form.getProblem());
            upsCheck.setSuggestion(form.getSuggestion());
            upsCheck.setResult(form.getResult());
            // upsCheck.setCheckTime(DateUtilTools.parseDate(form.getCheckTime(),
            // DateUtilTools.PATTERN_DATE_3));
            // upsCheck.setCheckDate(DateUtilTools.parseDate(form.getCheckDate(),
            // DateUtilTools.PATTERN_DATE_1));
            environmentEquipCheckDao.update(upsCheck);
            // 封装查询实体
            MeasureQueryModel qm = new MeasureQueryModel();
            qm.setUpsCheck(upsCheck);
            // 封装内容检查实体
            List<UpsContentCheck> uccs = upsContentCheckDao.queryByModel(qm);
            if (uccs.size() > 0) {
                for (UpsContentCheck ucc : uccs) {
                    ucc.setTemperature(form.getTemperature());
                    ucc.setAtIsAdjustable(form.getAtIsAdjustable());
                    ucc.setHumidity(form.getHumidity());
                    ucc.setEaIsIntact(form.getEaIsIntact());
                    ucc.setRadiateIsNormal(form.getRadiateIsNormal());
                    ucc.setEsGroundVoltage(form.getEsGroundVoltage());
                    ucc.setUpsRvIsNormal(form.getUpsRvIsNormal());
                    ucc.setUpsUidisIsNormal(form.getUpsUidisIsNormal());
                    ucc.setRaIsFlow(form.getRaIsFlow());
                    ucc.setBatLeakage(form.getBatLeakage());
                    ucc.setUpsOutletIsClean(form.getUpsOutletIsClean());
                    ucc.setBatSurfaceIsClean(form.getBatSurfaceIsClean());
                    ucc.setConnCo(form.getConnCo());
                    ucc.setUpsCurFAlarm(form.getUpsCurFAlarm());
                    ucc.setUpsHisFAlarm(form.getUpsHisFAlarm());
                    ucc.setInputVLN(form.getInputVLN());
                    ucc.setInputVLD(form.getInputVLD());
                    ucc.setInputVND(form.getInputVND());
                    ucc.setInputCurrent(form.getInputCurrent());
                    ucc.setLoadCapacity(form.getLoadCapacity());
                    ucc.setInputAirTemperature(form.getInputAirTemperature());
                    ucc.setInputCableTemperature(form
                            .getInputCableTemperature());
                    ucc.setOutputVLN(form.getOutputVLN());
                    ucc.setOutputVLN(form.getOutputVLN());
                    ucc.setOutputVND(form.getOutputVND());
                    ucc.setOutputCurrent(form.getOutputCurrent());
                    ucc.setOutputAirTemperature(form.getOutputAirTemperature());
                    ucc.setEquipDustRemoval(form.getEquipDustRemoval());
                    ucc.setUpsCheck(upsCheck);
                    // System.err.println(ucc.toString());
                    upsContentCheckDao.update(ucc);
                }
            }
            // 封装系统测量实体
            List<SystemMeasure> sms = systemMeasureDao.queryByModel(qm);
            if (sms.size() > 0) {
                for (SystemMeasure sm : sms) {
                    sm.setPvANDisOutValue(form.getPvANDisOutValue());
                    sm.setPvANMeaInValue(form.getPvANMeaInValue());
                    sm.setPvANMeaOutValue(form.getPvANMeaOutValue());
                    sm.setPvANRemark(form.getPvANRemark());
                    sm.setPvBNDisOutValue(form.getPvBNDisOutValue());
                    sm.setPvBNMeaInValue(form.getPvBNMeaInValue());
                    sm.setPvBNMeaOutValue(form.getPvBNMeaOutValue());
                    sm.setPvBNRemark(form.getPvBNRemark());
                    sm.setPvCNDisOutValue(form.getPvCNDisOutValue());
                    sm.setPvCNMeaInValue(form.getPvCNMeaInValue());
                    sm.setPvCNMeaOutValue(form.getPvCNMeaOutValue());
                    sm.setPvCNRemark(form.getPvCNRemark());
                    sm.setLvABDisOutValue(form.getLvABDisOutValue());
                    sm.setLvABMeaInValue(form.getLvABMeaInValue());
                    sm.setLvABMeaOutValue(form.getLvABMeaOutValue());
                    sm.setLvABRemark(form.getLvABRemark());
                    sm.setLvACDisOutValue(form.getLvACDisOutValue());
                    sm.setLvACMeaInValue(form.getLvACMeaInValue());
                    sm.setLvACMeaOutValue(form.getLvACMeaOutValue());
                    sm.setLvACRemark(form.getLvACRemark());
                    sm.setLvBCDisOutValue(form.getLvBCDisOutValue());
                    sm.setLvBCMeaInValue(form.getLvBCMeaInValue());
                    sm.setLvBCMeaOutValue(form.getLvBCMeaOutValue());
                    sm.setLvBCRemark(form.getLvBCRemark());
                    sm.setPcADisOutValue(form.getPcADisOutValue());
                    sm.setPcAMeaInValue(form.getPcAMeaInValue());
                    sm.setPcAMeaOutValue(form.getPcAMeaOutValue());
                    sm.setPcARemark(form.getPcARemark());
                    sm.setPcBDisOutValue(form.getPcBDisOutValue());
                    sm.setPcBMeaInValue(form.getPcBMeaInValue());
                    sm.setPcBMeaOutValue(form.getPcBMeaOutValue());
                    sm.setPcBRemark(form.getPcBRemark());
                    sm.setPcCDisOutValue(form.getPcCDisOutValue());
                    sm.setPcCMeaInValue(form.getPcCMeaInValue());
                    sm.setPcCMeaOutValue(form.getPcCMeaOutValue());
                    sm.setPcCRemark(form.getPcCRemark());
                    sm.setPpADisOutValue(form.getPpADisOutValue());
                    sm.setPpAMeaCalValue(form.getPpAMeaCalValue());
                    sm.setPpARemark(form.getPpARemark());
                    sm.setPpBDisOutValue(form.getPpBDisOutValue());
                    sm.setPpBMeaCalValue(form.getPpBMeaCalValue());
                    sm.setPpBRemark(form.getPpBRemark());
                    sm.setPpCDisOutValue(form.getPpCDisOutValue());
                    sm.setPpCMeaCalValue(form.getPpCMeaCalValue());
                    sm.setPpCRemark(form.getPpCRemark());
                    sm.setUpsCheck(upsCheck);
                    // System.err.println(sm.toString());
                    systemMeasureDao.update(sm);
                }
            }
            // 封装零地电压及零线电流测试实体并更新记录
            List<ZgvZlcMeasure> zzms = zgvZlcMeasuredao.queryByModel(qm);
            if (zzms.size() > 0) {
                for (ZgvZlcMeasure zzm : zzms) {
                    zzm.setZgvInputResult(form.getZgvInputResult());
                    zzm.setZgvInputRemark(form.getZgvInputRemark());
                    zzm.setZgvOutputResult(form.getZgvOutputResult());
                    zzm.setZgvOutputRemark(form.getZgvOutputRemark());
                    zzm.setZlcInputResult(form.getZlcInputResult());
                    zzm.setZlcInputRemark(form.getZlcInputRemark());
                    zzm.setZlcOutputResult(form.getZlcOutputResult());
                    zzm.setZlcOutputRemark(form.getZlcOutputRemark());
                    // 20160802
                    zzm.setZgvInputMeasure(form.getZgvInputMeasure());
                    zzm.setZgvOutputMeasure(form.getZgvOutputMeasure());
                    zzm.setZlcInputMeasure(form.getZlcInputMeasure());
                    zzm.setZlcOutputMeasure(form.getZlcOutputMeasure());
                    zzm.setUpsCheck(upsCheck);
                    zgvZlcMeasuredao.update(zzm);
                }
            }
            // 封装电池测量实体并更新
            List<BatteryMeasure> bms = batteryMeasureDao.queryByModel(qm);
            if (bms.size() > 0) {
                for (int i = 0; i < bms.size(); i++) {
                    BatteryMeasure bm = bms.get(i);
                    bm.setInterR(interR.get(i));
                    bm.setTermialV(termialV.get(i));
                    bm.setRemarks(remarks.get(i));
                    bm.setUpsCheck(upsCheck);
                    batteryMeasureDao.update(bm);
                }
            }
            // 封装系统连接检查实体并更新
            List<SystemConnMeasure> scms = systemConnMeasureDao
                    .queryByModel(qm);
            if (scms.size() > 0) {
                for (SystemConnMeasure scm : scms) {
                    scm.setUpsIcTr(form.getUpsIcTr());
                    scm.setUpsIcRemark(form.getUpsIcRemark());
                    scm.setUpsFRunTr(form.getUpsFRunTr());
                    scm.setUpsFRunRemark(form.getUpsFRunRemark());
                    scm.setUpsIbFirmTr(form.getUpsIbFirmTr());
                    scm.setUpsIbFirmRemark(form.getUpsIbFirmRemark());
                    scm.setUpsCwOhTr(form.getUpsCwOhTr());
                    scm.setUpsCwOhRemark(form.getUpsCwOhRemark());
                    scm.setUpsRvTr(form.getUpsRvTr());
                    scm.setUpsRvRemark(form.getUpsRvRemark());
                    scm.setBatCTr(form.getBatCTr());
                    scm.setBatCRemark(form.getBatCRemark());
                    scm.setUpsPdcIowTr(form.getUpsPdcIowTr());
                    scm.setUpsPdcIowRemark(form.getUpsPdcIowRemark());
                    scm.setBpdbTr(form.getBpdbTr());
                    scm.setBpdbRemark(form.getBpdbRemark());
                    scm.setPdcCTr(form.getPdcCTr());
                    scm.setPdcCRemark(form.getPdcCRemark());
                    scm.setPdcMIlTr(form.getPdcMIlTr());
                    scm.setPdcMIlRemark(form.getPdcMIlRemark());
                    scm.setBfnRemark(form.getBfnRemark());
                    scm.setBfnTr(form.getBfnTr());
                    scm.setLtCwFTr(form.getLtCwFTr());
                    scm.setLtCwFRemark(form.getLtCwFRemark());
                    scm.setLtLcTr(form.getLtLcTr());
                    scm.setLtLcRemark(form.getLtLcRemark());
                    scm.setLtSTr(form.getLtSTr());
                    scm.setLtSRemark(form.getLtSRemark());
                    scm.setUpsCheck(upsCheck);
                    systemConnMeasureDao.update(scm);
                }
            }
        }
        return environmentEquipCheckDao.findById(upsCheck.getId());
    }

	/**
	 * 更新ups年检季检实体
	 * @author renyujuan
	 * @date 2016年8月3日上午10:15:29
	 * @param upsCheck
	 * @param form
	 * @param termialV
	 * @param interR
	 * @param remarks
	 * @param dsTime
	 * @param batTotalV
	 * @param dsCurrent
	 * @param singleMaxV
	 * @param singleMinV
	 * @param remark
	 * @return
	 */
	@Override
    public EnvironmentEquipCheck updateQuarter(EnvironmentEquipCheck upsCheck,
	    UpsMonthAddForm form, List<String> termialV, List<String> interR,
	    List<String> remarks, List<String> dsTime, List<String> batTotalV,
	    List<String> dsCurrent, List<String> singleMaxV,
	    List<String> singleMinV, List<String> remark) {
	if (!ObjectUtils.equals(upsCheck, null)) {
	    upsCheck.setProblem(form.getProblem());
	    upsCheck.setSuggestion(form.getSuggestion());
	    upsCheck.setResult(form.getResult());
	    environmentEquipCheckDao.update(upsCheck);
	    // 封装查询实体
	    MeasureQueryModel qm = new MeasureQueryModel();
	    qm.setUpsCheck(upsCheck);
	    // 封装内容检查实体
	    List<UpsContentCheck> uccs = upsContentCheckDao.queryByModel(qm);
	    if (uccs.size() > 0) {
		for (UpsContentCheck ucc : uccs) {
		    ucc.setTemperature(form.getTemperature());
		    ucc.setAtIsAdjustable(form.getAtIsAdjustable());
		    ucc.setHumidity(form.getHumidity());
		    ucc.setEaIsIntact(form.getEaIsIntact());
		    ucc.setRadiateIsNormal(form.getRadiateIsNormal());
		    ucc.setEsGroundVoltage(form.getEsGroundVoltage());
		    ucc.setUpsRvIsNormal(form.getUpsRvIsNormal());
		    ucc.setUpsUidisIsNormal(form.getUpsUidisIsNormal());
		    ucc.setRaIsFlow(form.getRaIsFlow());
		    ucc.setBatLeakage(form.getBatLeakage());
		    ucc.setUpsOutletIsClean(form.getUpsOutletIsClean());
		    ucc.setBatSurfaceIsClean(form.getBatSurfaceIsClean());
		    ucc.setConnCo(form.getConnCo());
		    ucc.setUpsCurFAlarm(form.getUpsCurFAlarm());
		    ucc.setUpsHisFAlarm(form.getUpsHisFAlarm());
		    ucc.setInputVLN(form.getInputVLN());
		    ucc.setInputVLD(form.getInputVLD());
		    ucc.setInputVND(form.getInputVND());
		    ucc.setInputCurrent(form.getInputCurrent());
		    ucc.setLoadCapacity(form.getLoadCapacity());
		    ucc.setInputAirTemperature(form.getInputAirTemperature());
		    ucc.setInputCableTemperature(form
			    .getInputCableTemperature());
		    ucc.setOutputVLN(form.getOutputVLN());
		    ucc.setOutputVLN(form.getOutputVLN());
		    ucc.setOutputVND(form.getOutputVND());
		    ucc.setOutputCurrent(form.getOutputCurrent());
		    ucc.setOutputAirTemperature(form.getOutputAirTemperature());
		    ucc.setEquipDustRemoval(form.getEquipDustRemoval());
		    ucc.setUpsCheck(upsCheck);
		    // System.err.println(ucc.toString());
		    upsContentCheckDao.update(ucc);
		}
	    }
	    // 封装系统测量实体
	    List<SystemMeasure> sms = systemMeasureDao.queryByModel(qm);
	    if (sms.size() > 0) {
		for (SystemMeasure sm : sms) {
		    sm.setPvANDisOutValue(form.getPvANDisOutValue());
		    sm.setPvANMeaInValue(form.getPvANMeaInValue());
		    sm.setPvANMeaOutValue(form.getPvANMeaOutValue());
		    sm.setPvANRemark(form.getPvANRemark());
		    sm.setPvBNDisOutValue(form.getPvBNDisOutValue());
		    sm.setPvBNMeaInValue(form.getPvBNMeaInValue());
		    sm.setPvBNMeaOutValue(form.getPvBNMeaOutValue());
		    sm.setPvBNRemark(form.getPvBNRemark());
		    sm.setPvCNDisOutValue(form.getPvCNDisOutValue());
		    sm.setPvCNMeaInValue(form.getPvCNMeaInValue());
		    sm.setPvCNMeaOutValue(form.getPvCNMeaOutValue());
		    sm.setPvCNRemark(form.getPvCNRemark());
		    sm.setLvABDisOutValue(form.getLvABDisOutValue());
		    sm.setLvABMeaInValue(form.getLvABMeaInValue());
		    sm.setLvABMeaOutValue(form.getLvABMeaOutValue());
		    sm.setLvABRemark(form.getLvABRemark());
		    sm.setLvACDisOutValue(form.getLvACDisOutValue());
		    sm.setLvACMeaInValue(form.getLvACMeaInValue());
		    sm.setLvACMeaOutValue(form.getLvACMeaOutValue());
		    sm.setLvACRemark(form.getLvACRemark());
		    sm.setLvBCDisOutValue(form.getLvBCDisOutValue());
		    sm.setLvBCMeaInValue(form.getLvBCMeaInValue());
		    sm.setLvBCMeaOutValue(form.getLvBCMeaOutValue());
		    sm.setLvBCRemark(form.getLvBCRemark());
		    sm.setPcADisOutValue(form.getPcADisOutValue());
		    sm.setPcAMeaInValue(form.getPcAMeaInValue());
		    sm.setPcAMeaOutValue(form.getPcAMeaOutValue());
		    sm.setPcARemark(form.getPcARemark());
		    sm.setPcBDisOutValue(form.getPcBDisOutValue());
		    sm.setPcBMeaInValue(form.getPcBMeaInValue());
		    sm.setPcBMeaOutValue(form.getPcBMeaOutValue());
		    sm.setPcBRemark(form.getPcBRemark());
		    sm.setPcCDisOutValue(form.getPcCDisOutValue());
		    sm.setPcCMeaInValue(form.getPcCMeaInValue());
		    sm.setPcCMeaOutValue(form.getPcCMeaOutValue());
		    sm.setPcCRemark(form.getPcCRemark());
		    sm.setPpADisOutValue(form.getPpADisOutValue());
		    sm.setPpAMeaCalValue(form.getPpAMeaCalValue());
		    sm.setPpARemark(form.getPpARemark());
		    sm.setPpBDisOutValue(form.getPpBDisOutValue());
		    sm.setPpBMeaCalValue(form.getPpBMeaCalValue());
		    sm.setPpBRemark(form.getPpBRemark());
		    sm.setPpCDisOutValue(form.getPpCDisOutValue());
		    sm.setPpCMeaCalValue(form.getPpCMeaCalValue());
		    sm.setPpCRemark(form.getPpCRemark());
		    sm.setUpsCheck(upsCheck);
		    // System.err.println(sm.toString());
		    systemMeasureDao.update(sm);
		}
	    }
	    // 封装零地电压及零线电流测试实体并更新记录
	    List<ZgvZlcMeasure> zzms = zgvZlcMeasuredao.queryByModel(qm);
	    if (zzms.size() > 0) {
		for (ZgvZlcMeasure zzm : zzms) {
		    zzm.setZgvInputResult(form.getZgvInputResult());
		    zzm.setZgvInputRemark(form.getZgvInputRemark());
		    zzm.setZgvOutputResult(form.getZgvOutputResult());
		    zzm.setZgvOutputRemark(form.getZgvOutputRemark());
		    zzm.setZlcInputResult(form.getZlcInputResult());
		    zzm.setZlcInputRemark(form.getZlcInputRemark());
		    zzm.setZlcOutputResult(form.getZlcOutputResult());
		    zzm.setZlcOutputRemark(form.getZlcOutputRemark());
		    // 20160802
		    zzm.setZgvInputMeasure(form.getZgvInputMeasure());
		    zzm.setZgvOutputMeasure(form.getZgvOutputMeasure());
		    zzm.setZlcInputMeasure(form.getZlcInputMeasure());
		    zzm.setZlcOutputMeasure(form.getZlcOutputMeasure());
		    zzm.setUpsCheck(upsCheck);
		    zgvZlcMeasuredao.update(zzm);
		}
	    }
	    // 封装电池测量实体并更新
	    List<BatteryMeasure> bms = batteryMeasureDao.queryByModel(qm);
	    if (bms.size() > 0) {

		for (int i = 0; i < bms.size(); i++) {
		    BatteryMeasure bm = bms.get(i);
		    bm.setInterR(interR.get(i));
		    bm.setTermialV(termialV.get(i));
		    bm.setRemarks(remarks.get(i));
		    bm.setUpsCheck(upsCheck);
		    batteryMeasureDao.update(bm);
		}
	    }
	    // 封装放电测试实体
	    List<DischargeTest> dts = dischargeTestDao.queryByModel(qm);
	    if (dts.size() > 0) {
		for (DischargeTest dt : dts) {
		    dt.setStartTime(DateUtilTools.parseDate(
			    form.getStartTime(), DateUtilTools.PATTERN_DATE_3));
		    dt.setEndTime(DateUtilTools.parseDate(form.getEndTime(),
			    DateUtilTools.PATTERN_DATE_3));
		    dt.setDurationTime(form.getDurationTime());
		    dt.setPreTotalV(form.getPreTotalV());
		    dt.setEndTotalV(form.getEndTotalV());
		    dt.setBatChargingC(form.getBatChargingC());
		    dt.setUpsCheck(upsCheck);
		    dischargeTestDao.update(dt);
		    DischargeProcessQueryModel queryModel = new DischargeProcessQueryModel();
		    queryModel.setDischargeTest(dt);
		    List<DischargeProcess> dps = dischargeProcessDao
			    .queryByModel(queryModel);
		    if (dps.size() > 0) {
			for (int i = 0; i < dps.size(); i++) {
			    DischargeProcess dp = dps.get(i);
			    dp.setDsTime(dsTime.get(i));
			    dp.setBatTotalV(batTotalV.get(i));
			    dp.setDsCurrent(dsCurrent.get(i));
			    dp.setSingleMaxV(singleMaxV.get(i));
			    dp.setSingleMinV(singleMinV.get(i));
			    dp.setRemark(remark.get(i));
			    dp.setDischargeTest(dt);
			    dischargeProcessDao.update(dp);
			}

		    }
		}
	    }
	    // 封装系统连接检查实体并更新
	    List<SystemConnMeasure> scms = systemConnMeasureDao
		    .queryByModel(qm);
	    if (scms.size() > 0) {
		for (SystemConnMeasure scm : scms) {
		    scm.setUpsIcTr(form.getUpsIcTr());
		    scm.setUpsIcRemark(form.getUpsIcRemark());
		    scm.setUpsFRunTr(form.getUpsFRunTr());
		    scm.setUpsFRunRemark(form.getUpsFRunRemark());
		    scm.setUpsIbFirmTr(form.getUpsIbFirmTr());
		    scm.setUpsIbFirmRemark(form.getUpsIbFirmRemark());
		    scm.setUpsCwOhTr(form.getUpsCwOhTr());
		    scm.setUpsCwOhRemark(form.getUpsCwOhRemark());
		    scm.setUpsRvTr(form.getUpsRvTr());
		    scm.setUpsRvRemark(form.getUpsRvRemark());
		    scm.setBatCTr(form.getBatCTr());
		    scm.setBatCRemark(form.getBatCRemark());
		    scm.setUpsPdcIowTr(form.getUpsPdcIowTr());
		    scm.setUpsPdcIowRemark(form.getUpsPdcIowRemark());
		    scm.setBpdbTr(form.getBpdbTr());
		    scm.setBpdbRemark(form.getBpdbRemark());
		    scm.setPdcCTr(form.getPdcCTr());
		    scm.setPdcCRemark(form.getPdcCRemark());
		    scm.setPdcMIlTr(form.getPdcMIlTr());
		    scm.setPdcMIlRemark(form.getPdcMIlRemark());
		    scm.setBfnRemark(form.getBfnRemark());
		    scm.setBfnTr(form.getBfnTr());
		    scm.setLtCwFTr(form.getLtCwFTr());
		    scm.setLtCwFRemark(form.getLtCwFRemark());
		    scm.setLtLcTr(form.getLtLcTr());
		    scm.setLtLcRemark(form.getLtLcRemark());
		    scm.setLtSTr(form.getLtSTr());
		    scm.setLtSRemark(form.getLtSRemark());
		    scm.setUpsCheck(upsCheck);
		    systemConnMeasureDao.update(scm);
		}
	    }
	}
	return environmentEquipCheckDao.findById(upsCheck.getId());
    }

	/**
	 * 更新柴油发电机巡检实体
	 * @author renyujuan
	 * @date 2016年8月9日 下午12:34:20
	 */
	@Override
    public EnvironmentEquipCheck updateDgCheck(EnvironmentEquipCheck dgCheck,
            DgAddForm form) {
        if (!ObjectUtils.equals(dgCheck, null)) {
            /* 封装查询实体 */
            EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
            qm.setEeCheck(dgCheck);
            // 封装柴油发电机巡检实体
            List<DgCheckContent> dccs = dgCheckContentDao.queryByModel(qm);
            if (dccs.size() > 0) {
                for (DgCheckContent dcc : dccs) {
                    dcc.setEnCheckResult(form.getEnCheckResult());
                    dcc.setEnRemarks(form.getEnRemarks());
                    dcc.setBhCheckResult(form.getBhCheckResult());
                    dcc.setBhRemarks(form.getBhRemarks());
                    dcc.setEcpiCheckResult(form.getEcpiCheckResult());
                    dcc.setEcpiRemarks(form.getEcpiRemarks());
                    dcc.setRmhCheckResult(form.getRmhCheckResult());
                    dcc.setRmhRemarks(form.getRmhRemarks());
                    dcc.setErcCheckResult(form.getErcCheckResult());
                    dcc.setErcRemarks(form.getErcRemarks());
                    dcc.setAtsNumoneCheckResult(form.getAtsNumoneCheckResult());
                    dcc.setAtsNumoneRemarks(form.getAtsNumoneRemarks());
                    dcc.setAtsNumtwoCheckResult(form.getAtsNumtwoCheckResult());
                    dcc.setAtsNumtwoRemarks(form.getAtsNumtwoRemarks());
                    dcc.setUshCheckResult(form.getUshCheckResult());
                    dcc.setUshRemarks(form.getUshRemarks());
                    dcc.setCableTestResult(form.getCableTestResult());
                    dcc.setCableTestRemarks(form.getCableTestRemarks());
                    dcc.setLpCheckResult(form.getLpCheckResult());
                    dcc.setLpRemarks(form.getLpRemarks());
                    dcc.setFpCheckResult(form.getFpCheckResult());
                    dcc.setFpRemarks(form.getFpRemarks());
                    dcc.setOsCheckResult(form.getOsCheckResult());
                    dcc.setOsRemarks(form.getOsRemarks());
                    dcc.setCsCheckResult(form.getCsCheckResult());
                    dcc.setCsRemarks(form.getCsRemarks());
                    dcc.setFsCheckResult(form.getFsCheckResult());
                    dcc.setFsRemarks(form.getFsRemarks());
                    dcc.setBlCheckResult(form.getBlCheckResult());
                    dcc.setBlRemarks(form.getBlRemarks());
                    dcc.setEbCheckResult(form.getEbCheckResult());
                    dcc.setEbRemarks(form.getEbRemarks());
                    dcc.setAsCheckResult(form.getAsCheckResult());
                    dcc.setAsRemarks(form.getAsRemarks());
                    dcc.setRsCheckResult(form.getRsCheckResult());
                    dcc.setRsRemarks(form.getRsRemarks());
                    dcc.setAutosCheckResult(form.getAutosCheckResult());
                    dcc.setAutosRemarks(form.getAutosRemarks());
                    dcc.setSbvCheckResult(form.getSbvCheckResult());
                    dcc.setSbvRemarks(form.getSbvRemarks());
                    dcc.setDopCheckResult(form.getDopCheckResult());
                    dcc.setDopRemarks(form.getDopRemarks());
                    dcc.setOpCheckResult(form.getOpCheckResult());
                    dcc.setOpRemarks(form.getOpRemarks());
                    dcc.setPfCheckResult(form.getPfCheckResult());
                    dcc.setPfRemarks(form.getPfRemarks());
                    dcc.setEpCheckResult(form.getEpCheckResult());
                    dcc.setEpRemarks(form.getEpRemarks());
                    dcc.setEwtCheckResult(form.getEwtCheckResult());
                    dcc.setEwtRemarks(form.getEwtRemarks());
                    /* 相电压A-N B-N C-N */
                    dcc.setPvANCheckResult(form.getPvANCheckResult());
                    dcc.setPvANRemarks(form.getPvANRemarks());
                    dcc.setPvBNCheckResult(form.getPvBNCheckResult());
                    dcc.setPvBNRemarks(form.getPvBNRemarks());
                    dcc.setPvCNCheckResult(form.getPvCNCheckResult());
                    dcc.setPvCNRemarks(form.getPvCNRemarks());
                    /* 线电压A-B A-C B-C */
                    dcc.setLvABCheckResult(form.getLvABCheckResult());
                    dcc.setLvABRemarks(form.getLvABRemarks());
                    dcc.setLvACCheckResult(form.getLvACCheckResult());
                    dcc.setLvACRemarks(form.getLvACRemarks());
                    dcc.setLvBCCheckResult(form.getLvBCCheckResult());
                    dcc.setLvBCRemarks(form.getLvBCRemarks());
                    /* 电流A相，B相，C相 */
                    dcc.setCaCheckResult(form.getCaCheckResult());
                    dcc.setCaRemarks(form.getCaRemarks());
                    dcc.setCbCheckResult(form.getCbCheckResult());
                    dcc.setCbRemarks(form.getCbRemarks());
                    dcc.setCcCheckResult(form.getCcCheckResult());
                    dcc.setCcRemarks(form.getCcRemarks());
                    /* 功率A相，B相，C相 */
                    dcc.setPaCheckResult(form.getPaCheckResult());
                    dcc.setPaRemarks(form.getPaRemarks());
                    dcc.setPbCheckResult(form.getPbCheckResult());
                    dcc.setPbRemarks(form.getPbRemarks());
                    dcc.setPcCheckResult(form.getPcCheckResult());
                    dcc.setPcRemarks(form.getPcRemarks());
                    dcc.setDgCheck(dgCheck);
                    dgCheckContentDao.update(dcc);
                }
            }
        }
        return environmentEquipCheckDao.findById(dgCheck.getId());
    }
	
    /**
     * 更新空调设备记录
     * @param accCheck
     * @param form
     * @return
     */
	@Override
    public EnvironmentEquipCheck updateAccCheck(EnvironmentEquipCheck accCheck,
            AccAddForm form) {
        if(!ObjectUtils.equals(accCheck, null)) {
            /*如果空调设备巡检记录不为空，则封装查询model，查询其余子表记录并更新*/
            EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
            qm.setEeCheck(accCheck);
            /*更新AccCheckContent记录*/
            List<AccCheckContent> accs = accCheckContentDao.queryByModel(qm);
            if(accs.size()>0) {
                for(AccCheckContent acc : accs) {
                    acc.setMfrStatus(form.getMfrStatus());
                    acc.setMfrRemarks(form.getMfrRemarks());
                    acc.setFsStatus(form.getFsStatus());
                    acc.setFsRemarks(form.getFsRemarks());
                    acc.setCwppStatus(form.getCwppStatus());
                    acc.setCwppRemarks(form.getCwppRemarks());
                    acc.setEfStatus(form.getEfStatus());
                    acc.setEfRemarks(form.getEfRemarks());
                    acc.setEsRemarks(form.getEsRemarks());
                    acc.setEsStatus(form.getEsStatus());
                    acc.setEeRemarks(form.getEeRemarks());
                    acc.setEeStatus(form.getEeStatus());
                    acc.setWpStatus(form.getWpStatus());
                    acc.setWpRemarks(form.getWpRemarks());
                    acc.setHwlwRemarks(form.getHwlwRemarks());
                    acc.setHwlwStatus(form.getHwlwStatus());
                    acc.setAcwsRemarks(form.getAcwsRemarks());
                    acc.setAcwsStatus(form.getAcwsStatus());
                    acc.setActRemarks(form.getActRemarks());
                    acc.setActStatus(form.getActStatus());
                    acc.setAcvcRemarks(form.getAcvcRemarks());
                    acc.setAcvcStatus(form.getAcvcStatus());
                    acc.setDplWfRemarks(form.getDplWfRemarks());
                    acc.setDplWfStatus(form.getDplWfStatus());
                    acc.setMirrorRemarks(form.getMirrorRemarks());
                    acc.setMirrorStatus(form.getMirrorStatus());
                    acc.setSepRemarks(form.getSepRemarks());
                    acc.setSepStatus(form.getSepStatus());
                    acc.setRpRemarks(form.getRpRemarks());
                    acc.setRpStatus(form.getRpStatus());
                    acc.setCocRemarks(form.getCocRemarks());
                    acc.setCocStatus(form.getCocStatus());
                    acc.setOacuprStatus(form.getOacuprStatus());
                    acc.setOacurpRemarks(form.getOacurpRemarks());
                    acc.setMbfRemarks(form.getMbfRemarks());
                    acc.setMbfStatus(form.getMbfStatus());
                    acc.setChrfRemarks(form.getChrfRemarks());
                    acc.setChrfStatus(form.getChrfStatus());
                    acc.setWpbRemarks(form.getWpbRemarks());
                    acc.setWpbStatus(form.getWpbStatus());
                    acc.setWsbDpRemarks(form.getWsbDpRemarks());
                    acc.setWpbStatus(form.getWpbStatus());
                    acc.setWsbDpRemarks(form.getWsbDpRemarks());
                    acc.setWsbDpStatus(form.getWsbDpStatus());
                    acc.setAchRemarks(form.getAchRemarks());
                    acc.setAchStatus(form.getAchStatus());
                    acc.setHwcRemarks(form.getHwcRemarks());
                    acc.setHwcStatus(form.getHwcStatus());
                    acc.setPslRemarks(form.getPslRemarks());
                    acc.setPslStatus(form.getPslStatus());
                    acc.setConnRemarks(form.getConnRemarks());
                    acc.setConnStatus(form.getConnStatus());
                    acc.setEcpRemarks(form.getEcpRemarks());
                    acc.setEcpStatus(form.getEcpStatus());
                    acc.setRcEcRemarks(form.getRcEcRemarks());
                    acc.setRcEcStatus(form.getRcEcStatus());
                    acc.setHtRemarks(form.getHtRemarks());
                    acc.setHtStatus(form.getHtStatus());
                    acc.setCpRemarks(form.getCpRemarks());
                    acc.setCpStatus(form.getCpStatus());
                    accCheckContentDao.update(acc);
                }
            }
            /*更新数据记录记录*/
            List<AccDataRecord> adrs = accDataRecordDao.queryByModel(qm);
            if(adrs.size()>0) {
                for(AccDataRecord adr : adrs) {
                    adr.setTvRemarks(form.getTvRemarks());
                    adr.setTvStatus(form.getTvStatus());
                    adr.setTvValue(form.getTvValue());
                    adr.setTcRemarks(form.getTcRemarks());
                    adr.setTcStatus(form.getTcStatus());
                    adr.setTcValue(form.getTcValue());
                    adr.setCcValue(form.getCcValue());
                    adr.setCcRemarks(form.getCcRemarks());
                    adr.setCcStatus(form.getCcStatus());
                    adr.setCconeRemarks(form.getCconeRemarks());
                    adr.setCconeRemarks(form.getCconeRemarks());
                    adr.setCconeValue(form.getCconeValue());
                    adr.setCctwoRemarks(form.getCctwoRemarks());
                    adr.setCctwoStatus(form.getCctwoStatus());
                    adr.setCctwoValue(form.getCctwoValue());
                    adr.setMfcRemarks(form.getMfcRemarks());
                    adr.setMfcStatus(form.getMfcStatus());
                    adr.setMfcValue(form.getMfcValue());
                    adr.setOmcRemarks(form.getOmcRemarks());
                    adr.setOmcStatus(form.getOmcStatus());
                    adr.setOmcValue(form.getOmcValue());
                    adr.setAothRemarks(form.getAothRemarks());
                    adr.setAothStatus(form.getAothStatus());
                    adr.setAothValue(form.getAothValue());
                    adr.setAowsRemarks(form.getAowsRemarks());
                    adr.setAowsStatus(form.getAowsStatus());
                    adr.setAowsValue(form.getAowsValue());
                    adr.setHcValue(form.getHcValue());
                    adr.setHcRemarks(form.getHcRemarks());
                    adr.setHcStatus(form.getHcStatus());
                    adr.setHcaRemarks(form.getHcaRemarks());
                    adr.setHcaStatus(form.getHcaStatus());
                    adr.setHcaValue(form.getHcaValue());
                    adr.setHcbRemarks(form.getHcbRemarks());
                    adr.setHcbStatus(form.getHcbStatus());
                    adr.setHcbValue(form.getHcbValue());
                    adr.setHccRemarks(form.getHccRemarks());
                    adr.setHccStatus(form.getHccStatus());
                    adr.setHccValue(form.getHccValue());
                    accDataRecordDao.update(adr);
                }
            }
        }
        return environmentEquipCheckDao.findById(accCheck.getId());
    }
	
    /**
     * 更新传输设备与通讯线路巡检记录
     * @author renyujuan
     * @time:2016年8月17日 下午1:33:56
     * @param psOtCheck
     * @param form
     * @return
     */
	@Override
    public EnvironmentEquipCheck updatePsOtCheck(
            EnvironmentEquipCheck psOtCheck, PsOtAddForm form) {
        if(!ObjectUtils.equals(psOtCheck, null)) {
            EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
            qm.setEeCheck(psOtCheck);
            /*更新传输设备与通讯线路巡检内容记录*/
            List<PsOtCheckContent> psOtCheckContents = psOtCheckContentDao
                    .queryByModel(qm);
            if(psOtCheckContents.size()>0) {
                for(PsOtCheckContent pocc : psOtCheckContents) {
                    pocc.setEoeFanCheckResult(form.getEoeFanCheckResult());
                    pocc.setEoeFanRemarks(form.getEoeFanRemarks());
                    pocc.setEoeTemCheckResult(form.getEoeTemCheckResult());
                    pocc.setEoeTemRemarks(form.getEoeTemRemarks());
                    pocc.setEoeHumCheckResult(form.getEoeHumCheckResult());
                    pocc.setEoeHumRemarks(form.getEoeHumRemarks());
                    pocc.setScreenCheckResult(form.getScreenCheckResult());
                    pocc.setScreenRemarks(form.getScreenRemarks());
                    pocc.setDisCheckResult(form.getDisCheckResult());
                    pocc.setDisRemarks(form.getDisRemarks());
                    pocc.setCrsCheckResult(form.getCrsCheckResult());
                    pocc.setCrsRemarks(form.getCrsRemarks());
                    pocc.setDlccCheckResult(form.getDlccCheckResult());
                    pocc.setDlccRemarks(form.getDlccRemarks());
                    pocc.setPscCheckResult(form.getPscCheckResult());
                    pocc.setPscRemarks(form.getPscRemarks());
                    pocc.setAcivCheckResult(form.getAcivCheckResult());
                    pocc.setAcivRemarks(form.getAcivRemarks());
                    pocc.setDcovCheckResult(form.getDcovCheckResult());
                    pocc.setDcovRemarks(form.getDcovRemarks());
                    pocc.setBvCheckResult(form.getBvCheckResult());
                    pocc.setBvRemarks(form.getBvRemarks());
                    pocc.setBirCheckResult(form.getBirCheckResult());
                    pocc.setBirRemarks(form.getBirRemarks());
                    pocc.setBatteryConnRemarks(form.getBatteryConnRemarks());
                    pocc.setBatteryConnResult(form.getBatteryConnResult());
                    pocc.setInverterCheckResult(form.getInverterCheckResult());
                    pocc.setInverterRemarks(form.getInverterRemarks());
                    pocc.setInsuranceCheckResult(form.getInsuranceCheckResult());
                    pocc.setInsuranceRemarks(form.getInsuranceRemarks());
                    pocc.setEcCheckResult(form.getEcCheckResult());
                    pocc.setEcRemarks(form.getEcRemarks());
                    pocc.setGpCheckResult(form.getGpCheckResult());
                    pocc.setGpRemarks(form.getGpRemarks());
                    pocc.setDdfOdfCheckResult(form.getDdfOdfCheckResult());
                    pocc.setDdfOdfRemarks(form.getDdfOdfRemarks());
                    pocc.setOcuCheckResult(form.getOcuCheckResult());
                    pocc.setOcuRemarks(form.getOcuRemarks());
                    pocc.setOfcCheckResult(form.getOfcCheckResult());
                    pocc.setOfcRemarks(form.getOfcRemarks());
                    pocc.setCmuCheckResult(form.getCmuCheckResult());
                    pocc.setCmuRemarks(form.getCmuRemarks());
                    pocc.setMcbaCheckResult(form.getMcbaCheckResult());
                    pocc.setMcbaRemarks(form.getMcbaRemarks());
                    pocc.setCba1CheckResult(form.getCba1CheckResult());
                    pocc.setCba1Remarks(form.getCba1Remarks());
                    pocc.setCba2CheckResult(form.getCba2CheckResult());
                    pocc.setCba2Remarks(form.getCba2Remarks());
                    pocc.setCba3CheckResult(form.getCba3CheckResult());
                    pocc.setCba3Remarks(form.getCba3Remarks());
                    pocc.setCbae1CheckResult(form.getCbae1CheckResult());
                    pocc.setCbae1Remarks(form.getCbae1Remarks());
                    pocc.setMcbbCheckResult(form.getMcbbCheckResult());
                    pocc.setMcbbRemarks(form.getMcbbRemarks());
                    pocc.setCbb1v35CheckResult(form.getCbb1v35CheckResult());
                    pocc.setCbb1v35Remarks(form.getCbb1v35Remarks());
                    pocc.setCbb2v35CheckResult(form.getCbb2v35CheckResult());
                    pocc.setCbb2v35Remarks(form.getCbb2v35Remarks());
                    pocc.setCbb3v35CheckResult(form.getCbb2v35CheckResult());
                    pocc.setCbb3v35Remarks(form.getCbb3v35Remarks());
                    pocc.setCbb1v24CheckResult(form.getCbb1v24CheckResult());
                    pocc.setCbb1v24Remarks(form.getCbb1v24Remarks());
                    pocc.setCbb2v24CheckResult(form.getCbb2v24CheckResult());
                    pocc.setCbb2v24Remarks(form.getCbb2v24Remarks());
                    pocc.setCbb3v24CheckResult(form.getCbb3v24CheckResult());
                    pocc.setCbb3v24Remarks(form.getCbb3v24Remarks());
                    pocc.setCbbe1CheckResult(form.getCbbe1CheckResult());
                    pocc.setCbbe1Remarks(form.getCbbe1Remarks());
                    pocc.setV35icCheckResult(form.getV35icCheckResult());
                    pocc.setV35icRemarks(form.getV35icRemarks());
                    pocc.setV24icCheckResult(form.getV24icCheckResult());
                    pocc.setV24icRemarks(form.getV24icRemarks());
                    pocc.setMonthLrs(form.getMonthLrs());
                    pocc.setMonthLas(form.getMonthLas());
                    pocc.setMonthLcs(form.getMonthLcs());
                    pocc.setMonthLfs(form.getMonthLfs());
                    pocc.setMonthLcsc(form.getMonthLcsc());
                    pocc.setUnderTlDlwrCheckResult(form.getUnderTlDlwrCheckResult());
                    pocc.setUnderTlDlwrRemarks(form.getUnderTlDlwrRemarks());
                    pocc.setFfTlDlwrCheckResult(form.getFfTlDlwrCheckResult());
                    pocc.setFfTlDlwrRemarks(form.getFfTlDlwrRemarks());
                    pocc.setFsTlDlwrCheckResult(form.getFsTlDlwrCheckResult());
                    pocc.setFsTlDlwrRemarks(form.getFsTlDlwrRemarks());
                    pocc.setFtTlDlwrCheckResult(form.getFtTlDlwrCheckResult());
                    pocc.setFtTlDlwrRemarks(form.getFtTlDlwrRemarks());
                    pocc.setFfoTlDlwrCheckResult(form.getFfoTlDlwrCheckResult());
                    pocc.setFfoTlDlwrRemarks(form.getFfoTlDlwrRemarks());
                    pocc.setFfiTlDlwrCheckResult(form.getFfiTlDlwrCheckResult());
                    pocc.setFfiTlDlwrRemarks(form.getFfiTlDlwrRemarks());
                    pocc.setFsiTlDlwrCheckResult(form.getFsiTlDlwrCheckResult());
                    pocc.setFsiTlDlwrRemarks(form.getFsiTlDlwrRemarks());
                    psOtCheckContentDao.update(pocc);
                }
            }
        }
        return environmentEquipCheckDao.findById(psOtCheck.getId());
    }
	
	
	/**
	 * 删除环境设备巡检记录
	 * @author renyujuan
	 * @date 2016年8月9日 上午10:30:53
	 */
	@Override
    public void delete(EnvironmentEquipCheck equipCheck) {
        try {
            if (!ObjectUtils.equals(equipCheck, null)) {
                if ((equipCheck.getEquipType().toString()).equals("ups设备")) {
                    // 设置相应的queryModel
                    MeasureQueryModel qm = new MeasureQueryModel();
                    qm.setUpsCheck(equipCheck);
                    // 获取巡检内容实体并删除
                    List<UpsContentCheck> uccs = upsContentCheckDao
                            .queryByModel(qm);
                    if (uccs.size() > 0) {
                        for (UpsContentCheck ucc : uccs) {
                            upsContentCheckDao.delete(ucc);
                        }
                    }
                    // 获取系统测量实体并删除
                    List<SystemMeasure> sms = systemMeasureDao.queryByModel(qm);
                    if (sms.size() > 0) {
                        for (SystemMeasure sm : sms) {
                            systemMeasureDao.delete(sm);
                        }
                    }
                    // 获取零地电压及零线电流实体并删除
                    List<ZgvZlcMeasure> zzms = zgvZlcMeasuredao
                            .queryByModel(qm);
                    if (zzms.size() > 0) {
                        for (ZgvZlcMeasure zzm : zzms) {
                            zgvZlcMeasuredao.delete(zzm);
                        }
                    }
                    // 获取电池测量实体并删除
                    List<BatteryMeasure> bms = batteryMeasureDao
                            .queryByModel(qm);
                    if (bms.size() > 0) {
                        for (BatteryMeasure bm : bms) {
                            batteryMeasureDao.delete(bm);
                        }
                    }
                    // 获取系统连接检查实体并删除
                    List<SystemConnMeasure> scms = systemConnMeasureDao
                            .queryByModel(qm);
                    if (scms.size() > 0) {
                        for (SystemConnMeasure scm : scms) {
                            systemConnMeasureDao.delete(scm);
                        }
                    }
                    // 获取放电测试实体并删除
                    List<DischargeTest> dts = dischargeTestDao.queryByModel(qm);
                    if (dts.size() > 0) {
                        for (DischargeTest dt : dts) {
                            DischargeProcessQueryModel qm1 = new DischargeProcessQueryModel();
                            qm1.setDischargeTest(dt);
                            List<DischargeProcess> dps = dischargeProcessDao
                                    .queryByModel(qm1);
                            if (dps.size() > 0) {
                                for (DischargeProcess dp : dps) {
                                    dischargeProcessDao.delete(dp);
                                }
                            }
                            dischargeTestDao.delete(dt);
                        }
                    }
                    EnvironmentEquipCheck upsCheck = environmentEquipCheckDao
                            .findById(equipCheck.getId());
                    // 删除ups巡检实体
                    environmentEquipCheckDao.delete(upsCheck);
                } else if ((equipCheck.getEquipType().toString())
                        .equals("柴油发电机")) {
                    /* 封装查询model，并根据查询model，获得子表内容 */
                    EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
                    qm.setEeCheck(equipCheck);
                    /* 获取对应的柴油发电机巡检内容记录并删除 */
                    List<DgCheckContent> dgCheckContents = dgCheckContentDao
                            .queryByModel(qm);
                    if (dgCheckContents.size() > 0) {
                        for (DgCheckContent dcc : dgCheckContents) {
                            dgCheckContentDao.delete(dcc);
                        }
                    }
                    EnvironmentEquipCheck dgCheck = environmentEquipCheckDao
                            .findById(equipCheck.getId());
                    // 删除ups巡检实体
                    environmentEquipCheckDao.delete(dgCheck);
                } else if ((equipCheck.getEquipType().toString())
                        .equals("空调设备")) {
                    /* 封装查询model，并根据查询model，获得子表内容 */
                    EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
                    qm.setEeCheck(equipCheck);
                    /* 获取对应的空调设备巡检内容记录并删除 */
                    List<AccCheckContent> accCheckContents = accCheckContentDao
                            .queryByModel(qm);
                    if (accCheckContents.size() > 0) {
                        for (AccCheckContent acc : accCheckContents) {
                            accCheckContentDao.delete(acc);
                        }
                    }
                    /* 获取对应的空调设备数据jilu记录并删除 */
                    List<AccDataRecord> accDataRecords = accDataRecordDao
                            .queryByModel(qm);
                    if (accDataRecords.size() > 0) {
                        for (AccDataRecord adr : accDataRecords) {
                            accDataRecordDao.delete(adr);
                        }
                    }
                    EnvironmentEquipCheck accCheck = environmentEquipCheckDao
                            .findById(equipCheck.getId());
                    // 删除ups巡检实体
                    environmentEquipCheckDao.delete(accCheck);
                } else if((equipCheck.getEquipType().toString())
                        .equals("传输设备及通讯线路")){
                    /* 封装查询model，并根据查询model，获得子表内容 */
                    EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
                    qm.setEeCheck(equipCheck);
                    /*获取对应的传输设备与通讯线路对应的巡检内容记录并删除*/
                    List<PsOtCheckContent> psOtCheckContents = psOtCheckContentDao
                            .queryByModel(qm);
                    if(psOtCheckContents.size()>0) {
                        for(PsOtCheckContent pocc : psOtCheckContents) {
                            psOtCheckContentDao.delete(pocc);
                        }
                    }
                    EnvironmentEquipCheck accCheck = environmentEquipCheckDao
                            .findById(equipCheck.getId());
                    // 删除ups巡检实体
                    environmentEquipCheckDao.delete(accCheck);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

	@Override
    public EnvironmentEquipCheck findById(String id) {
        EnvironmentEquipCheck equipCheck = environmentEquipCheckDao
                .findById(id);
        if (!ObjectUtils.equals(equipCheck, null)) {
            if ((equipCheck.getEquipType().toString()).equals("ups设备")) {
                MeasureQueryModel qm = new MeasureQueryModel();
                qm.setUpsCheck(equipCheck);
                // 根据upsCheck查询对应的upsContentCheck
                List<UpsContentCheck> upsContentChecks = upsContentCheckDao
                        .queryByModel(qm);
                if (upsContentChecks.size() > 0) {
                    equipCheck.setUpsContentCheck(upsContentChecks);
                }
                // 根据upsCheck查询对应的systemMeasure
                List<SystemMeasure> sms = systemMeasureDao.queryByModel(qm);
                if (sms.size() > 0) {
                    equipCheck.setSystemMeasure(sms);
                }
                // 根据upsCheck查询对应的zgvzlvmeasure
                List<ZgvZlcMeasure> zzms = zgvZlcMeasuredao.queryByModel(qm);
                if (zzms.size() > 0) {
                    equipCheck.setZgvZlcMeasure(zzms);
                }
                // 根据upsCheck查询对应的batterymeasure
                List<BatteryMeasure> bms = batteryMeasureDao.queryByModel(qm);
                if (bms.size() > 0) {
                    equipCheck.setBatteryMeasure(bms);
                }
                // 根据upsCheck查询对应的systemconnMeasure
                List<SystemConnMeasure> scms = systemConnMeasureDao
                        .queryByModel(qm);
                if (scms.size() > 0) {
                    equipCheck.setSystemConnMeasure(scms);
                }
                // 根据UPSCheck查询对应的DischargeTest
                List<DischargeTest> dts = dischargeTestDao.queryByModel(qm);
                if (dts.size() > 0) {
                    for (DischargeTest dt : dts) {
                        DischargeProcessQueryModel qm1 = new DischargeProcessQueryModel();
                        qm1.setDischargeTest(dt);
                        // 根据放电测试实体查询相应的放电过程实体
                        List<DischargeProcess> dps = dischargeProcessDao
                                .queryByModel(qm1);
                        if (dps.size() > 0) {
                            dt.setDischargeProcess(dps);
                        }
                    }
                    equipCheck.setDischargeTest(dts);
                }
            } else if ((equipCheck.getEquipType().toString()).equals("柴油发电机")) {
                EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
                qm.setEeCheck(equipCheck);
                /* 根据柴油发电机巡检实体，查询相应的子表信息 */
                List<DgCheckContent> dccs = dgCheckContentDao.queryByModel(qm);
                if (dccs.size() > 0) {
                    equipCheck.setDgCheckContent(dccs);
                }
            } else if ((equipCheck.getEquipType().toString()).equals("空调设备")) {
                EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
                qm.setEeCheck(equipCheck);
                /*根据空调设备巡检记录，查询巡检内容记录与数据记录*/
                List<AccCheckContent> accs = accCheckContentDao.queryByModel(qm);
                if(accs.size()>0) {
                    equipCheck.setAccCheckContent(accs);
                }
                List<AccDataRecord> adrs = accDataRecordDao.queryByModel(qm);
                if(adrs.size()>0) {
                    equipCheck.setAccDataRecord(adrs);
                }
                
            } else if((equipCheck.getEquipType().toString())
                        .equals("传输设备及通讯线路")) {
                EnvironmentEquipCheckQueryModel qm = new EnvironmentEquipCheckQueryModel();
                qm.setEeCheck(equipCheck);
                /*根据传输设备与通讯线路巡检记录，查询巡检内容记录*/
                List<PsOtCheckContent> psOtCheckContents = psOtCheckContentDao
                        .queryByModel(qm);
                if(psOtCheckContents.size()>0) {
                    equipCheck.setPsOtCheckContent(psOtCheckContents);
                }
            }
        }
        return equipCheck;
    }

	/**
	 * 将电池测量的各个字段从对应集合取出，并封装成相应实体
	 * @author renyujuan
	 * @date 2016年8月9日 上午10:41:19
	 */
	@Override
    public List<BatteryMeasure> dealbatMea(List<Integer> number,
            List<String> termialV, List<String> interR, List<String> remarks) {

        if (termialV == null && interR == null && remarks == null
                && number == null) {
            return null;
        } else {
            List<BatteryMeasure> bmli = new ArrayList<BatteryMeasure>();
            for (int i = 0; i < termialV.size(); i++) {
                BatteryMeasure bm = new BatteryMeasure();
                bm.setNumber(number.get(i));
                bm.setInterR(interR.get(i));
                bm.setTermialV(termialV.get(i));
                bm.setRemarks(remarks.get(i));
                bmli.add(bm);
            }
            return bmli;
        }
    }

	/**
	 * 将放电过程的各个字段从对应的集合取出，并封装成相应实体
	 * @author renyujuan
	 * @date 2016年8月3日上午9:50:35
	 * @param dsTime
	 * @param batTotalV
	 * @param dsCurrent
	 * @param singleMaxV
	 * @param singleMinV
	 * @param remarks
	 * @return
	 */
    public List<DischargeProcess> dealdispro(List<String> dsTime,
            List<String> batTotalV, List<String> dsCurrent,
            List<String> singleMaxV, List<String> singleMinV,
            List<String> remark) {
        if (dsTime == null && batTotalV == null && dsCurrent == null
                && singleMaxV == null && singleMinV == null && remark == null) {
            return null;
        } else {
            List<DischargeProcess> dps = new ArrayList<DischargeProcess>();
            for (int i = 0; i < dsTime.size(); i++) {
                DischargeProcess dp = new DischargeProcess();
                dp.setDsTime(dsTime.get(i));
                dp.setBatTotalV(batTotalV.get(i));
                dp.setDsCurrent(dsCurrent.get(i));
                dp.setSingleMaxV(singleMaxV.get(i));
                dp.setSingleMinV(singleMinV.get(i));
                dp.setRemark(remark.get(i));
                dps.add(dp);
            }
            return dps;
        }
    }


    
}
