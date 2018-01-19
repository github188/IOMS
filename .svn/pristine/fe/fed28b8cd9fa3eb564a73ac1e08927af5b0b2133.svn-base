/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-5-6 下午3:43:48
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.welcome;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import jodd.util.ObjectUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.util.jackson.JacksonTools;
import cn.com.atnc.ioms.entity.acl.Role;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphApply;
import cn.com.atnc.ioms.entity.business.telegraph.TeleGraphCircuit;
import cn.com.atnc.ioms.entity.clientmng.CsRole;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.enums.basedata.RoleEnum;
import cn.com.atnc.ioms.enums.business.datacomnetwork.NetWorkStatEnum;
import cn.com.atnc.ioms.enums.business.formalcircuit.FormalStatEnum;
import cn.com.atnc.ioms.enums.business.satellite.ApproveStatEnum;
import cn.com.atnc.ioms.enums.business.telegraph.TeleGraphApproveStatEnum;
import cn.com.atnc.ioms.enums.business.transfernet.TransferNetStatEnum;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.enums.welcome.MenuType;
import cn.com.atnc.ioms.enums.welcome.SonMenuType;
import cn.com.atnc.ioms.mng.business.datacomnetwork.IDataComNetworkManager;
import cn.com.atnc.ioms.mng.business.formalcircuit.IFormalCircuitManager;
import cn.com.atnc.ioms.mng.business.satellite.IKuSatelliteService;
import cn.com.atnc.ioms.mng.business.signoutnet.ISignoutNetManager;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphApplyService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphCircuitService;
import cn.com.atnc.ioms.mng.business.telegraph.TeleGraphService;
import cn.com.atnc.ioms.mng.business.transfernet.ITransferNetManager;
import cn.com.atnc.ioms.mng.clientmng.IClientManager;
import cn.com.atnc.ioms.mng.news.INewsMngService;
import cn.com.atnc.ioms.mng.operstat.atm.INetworkStatService;
import cn.com.atnc.ioms.mng.operstat.ku.IKuStatusStatManager;
import cn.com.atnc.ioms.mng.operstat.tes.ITesStatService;
import cn.com.atnc.ioms.mng.techsupport.IFaultDeclareService;
import cn.com.atnc.ioms.mng.tempcircuit.ITempCircuitMngService;
import cn.com.atnc.ioms.model.business.datacomnetwork.DataComNetworkQueryModel;
import cn.com.atnc.ioms.model.business.formalcircuit.FormalCircuitQueryModel;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel;
import cn.com.atnc.ioms.model.business.signoutnet.SignoutNetQueryModel;
import cn.com.atnc.ioms.model.business.telegraph.TeleGraphQueryModel;
import cn.com.atnc.ioms.model.business.transfernet.TransferNetQueryModel;
import cn.com.atnc.ioms.model.operstat.atm.AtmAlarmDBModel;
import cn.com.atnc.ioms.model.welcome.AlarmStatResultModel;
import cn.com.atnc.ioms.model.welcome.AlarmTotalStatModel;
import cn.com.atnc.ioms.model.welcome.IndexNoticeModel;
import cn.com.atnc.ioms.model.welcome.ServiceNoticeModel;

/**
 * @author:HuangYijie
 * @date:2014-5-6 下午3:43:48
 * @version:1.0
 */
@Service("WelcomeManagerImpl")
public class WelcomeManagerImpl extends AbstractService implements
		IWelcomeManager {

	@Autowired
	private IClientManager clientManager;
	@Autowired
	private INewsMngService newsMngSerivce;
	@Autowired
	private ITempCircuitMngService tempCircuitMngService;
	@Autowired
	private IFaultDeclareService faultDeclareService;

	public Map<String, Bureau> cityMap = new HashMap<String, Bureau>();

	@Autowired
	private IKuStatusStatManager kuStatusStatManager;
	@Autowired
	private ITesStatService tesStatService;
	@Autowired
	private INetworkStatService networkStatService;
	@Autowired
	private IFormalCircuitManager formalCircuitManager;
	@Autowired
	private IDataComNetworkManager dataComNetworkManager;
	@Autowired
	private ITransferNetManager transferNetManager;
	@Autowired
	private IKuSatelliteService kuSatelliteService;
	@Autowired
	private TeleGraphService teleGraphService;
	@Autowired
	private TeleGraphCircuitService teleGraphCircuitService;
	@Autowired
	private TeleGraphApplyService teleGraphApplyService;
	@Autowired
	private ISignoutNetManager signoutNetManager;

	@PostConstruct
	public void initCities() {
		cityMap.put("XINJIANG", Bureau.ZWWW);
		cityMap.put("XIZANG", Bureau.ZUUU);
		cityMap.put("SICHUAN", Bureau.ZUUU);
		cityMap.put("CHONGQING", Bureau.ZUUU);
		cityMap.put("YUNNAN", Bureau.ZUUU);
		cityMap.put("GUIZHOU", Bureau.ZUUU);
		cityMap.put("QINGHAI", Bureau.ZLXY);
		cityMap.put("GANSU", Bureau.ZLXY);
		cityMap.put("SHAANXI", Bureau.ZLXY);
		cityMap.put("NINGXIA", Bureau.ZLXY);
		cityMap.put("BEIJING", Bureau.ZBBB);
		cityMap.put("NEIMENG", Bureau.ZBAA);
		cityMap.put("SHANXI", Bureau.ZBAA);
		cityMap.put("HEBEI", Bureau.ZBAA);
		cityMap.put("TIANJIN", Bureau.ZBAA);
		cityMap.put("LIAONING", Bureau.ZYTX);
		cityMap.put("JILIN", Bureau.ZYTX);
		cityMap.put("HEILONGJIANG", Bureau.ZYTX);
		cityMap.put("JIANGSU", Bureau.ZSSS);
		cityMap.put("ZHEJIANG", Bureau.ZSSS);
		cityMap.put("ANHUI", Bureau.ZSSS);
		cityMap.put("SHANGHAI", Bureau.ZSSS);
		cityMap.put("SHANDONG", Bureau.ZSSS);
		cityMap.put("JIANGXI", Bureau.ZSSS);
		cityMap.put("FUJIAN", Bureau.ZSSS);
		cityMap.put("HUBEI", Bureau.ZGGG);
		cityMap.put("HUNAN", Bureau.ZGGG);
		cityMap.put("HENAN", Bureau.ZGGG);
		cityMap.put("GUANGXI", Bureau.ZGGG);
		cityMap.put("GUANGDONG", Bureau.ZGGG);
		cityMap.put("HAINAN", Bureau.ZGGG);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @throws IOException
	 * 
	 * @see cn.com.atnc.ioms.mng.welcome.IWelcomeManager#getAlarmStat()
	 */
	@Override
	public String getAlarmStat() throws IOException {
		AlarmStatResultModel statResult = new AlarmStatResultModel();
		// TODO Auto-generated method stub
		// 包装各城市所属管局的统计。

		List<AlarmTotalStatModel> cityAlarmStatList = new ArrayList<>();
		List<AlarmTotalStatModel> bureauAlarmStatList = kuStatusStatManager
				.getLatestStat();
		Map<String, Integer> tesStatResult = tesStatService
				.tesSlotWarningList();
		List<AtmAlarmDBModel> atmStatResult = networkStatService
				.getAllAtmAlarm();
		// Ku统计时返回所有bureau的告警数，含无告警的管局。
		bureauAlarmStatList = kuStatusStatManager.getLatestStat();
		for (AlarmTotalStatModel totalStat : bureauAlarmStatList) {
			// 添加tes的管局告警统计结果
			if (!CollectionUtils.isEmpty(tesStatResult)) {
				for (String bureau : tesStatResult.keySet()) {
					if (totalStat.getBureau().getName().equals(bureau)) {
						totalStat.setTesAlarm(tesStatResult.get(bureau));
						break;
					}

				}

			}
			if (!CollectionUtils.isEmpty(atmStatResult)) {
				for (AtmAlarmDBModel model : atmStatResult) {
					if (totalStat.getBureau().equals(model.getBureau())) {
						totalStat.setAtmCritical(model.getCritical());
						totalStat.setAtmMajor(model.getMajor());
						totalStat.setAtmMinor(model.getMinor());
						break;
					}

				}

			}

		}
		// 前台地图的code为城市名，因此包装数据时需要额外包装成城市对应管局的告警。
		// 用于map悬停lable数据的展示
		for (String city : cityMap.keySet()) {
			AlarmTotalStatModel model = new AlarmTotalStatModel();
			model.setBureau(cityMap.get(city));
			// 包装对应管局的ku告警（三类）
			for (AlarmTotalStatModel bureauStat : bureauAlarmStatList) {
				if (model.getBureau().equals(bureauStat.getBureau())) {
					BeanUtils.copyProperties(bureauStat, model);
					break;
				}
			}
			model.setCha(city);
			cityAlarmStatList.add(model);
		}

		statResult.setBureauAlarmStatList(bureauAlarmStatList);
		statResult.setCityAlarmStatList(cityAlarmStatList);
		return JacksonTools.toJsonStr(statResult);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see cn.com.atnc.ioms.mng.welcome.IWelcomeManager#getServiceNoticeCount()
	 */
	@Override
	public ServiceNoticeModel getServiceNoticeCount(User user) {
		// TODO Auto-generated method stub
		ServiceNoticeModel model = new ServiceNoticeModel();
		if (user == null) {
			return model;
		}
		model.setClientCount(clientManager.getUnresolvedCount());
		model.setFaultCount(faultDeclareService.getFaultDeclareNum(user.getId()));
		model.setTechCount(faultDeclareService.getTechConsultNum());
		model.setNoticeCount(newsMngSerivce.getApproveNum(user.getId()));
		model.setCircuitCount(tempCircuitMngService
				.getCurrentUserUndoTaskNum(user.getId()));
		return model;
	}

	@Override
	public List<IndexNoticeModel> getIndexNotice(User user) {
		List<IndexNoticeModel> inmodel = new ArrayList<IndexNoticeModel>();
		if (user == null) {
			return inmodel;
		}
		//角色名
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if(!CollectionUtils.isEmpty(roles)){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		
		//公司领导和网络经理不显示电路信息
		Boolean flag = true;
		System.out.println(roleNames);
		if(!CollectionUtils.isEmpty(roles)){
			if(roles.size() == 1){
				if(roles.get(0).getName().equals(RoleEnum.leader.name()) 
						|| roles.get(0).getName().equals(RoleEnum.netmanager.name())){
					flag = false;
				}
			}else if(roles.size() == 2){
				if((roles.get(0).getName().equals(RoleEnum.leader.name()) 
						&& roles.get(1).getName().equals(RoleEnum.netmanager.name())) ||
				   (roles.get(1).getName().equals(RoleEnum.leader.name()) 
						&& roles.get(0).getName().equals(RoleEnum.netmanager.name()))){
					flag = false;
				}
			}
		}
		
		//获取页面参数
		int tcnum = tempCircuitMngService.getCurrentUserUndoTaskNum(user.getId());
		int fcnum = this.getCountNum(user, MenuType.business, SonMenuType.formalcircuit);
		int nwnum = this.getCountNum(user, MenuType.business, SonMenuType.datacomnetwork);
		int tnnum = this.getCountNum(user, MenuType.business, SonMenuType.transfernet);
		int kunum = this.getCountNum(user, MenuType.business, SonMenuType.kusatellite);
		int tgnum = this.getCountNum(user, MenuType.business, SonMenuType.telegraph);
		int gcnum = this.getCountNum(user, MenuType.business, SonMenuType.telegraphcircuit);
		//退网申请
		int ocnum = this.getCountNum(user, MenuType.business, SonMenuType.signoutnet);
		
		IndexNoticeModel indexNotice = new IndexNoticeModel();
		
		//未审核的临时注册用户数量
		if ((roleNames.toString().contains("|" + RoleEnum.admin.name() + "|")) || (roleNames.toString().contains("|" + RoleEnum.audituser.name() + "|"))){
			//临时用户注册后台审核(角色：admin/audituser)
			int tunum = this.getCountNum(user, MenuType.clientmng, SonMenuType.tempUserRegister);
			indexNotice = new IndexNoticeModel();
			indexNotice.setSonMenuType(SonMenuType.tempUserRegister);
			indexNotice.setNum(tunum);
			indexNotice.setUrl("systemmng/client/manage.do");
			inmodel.add(indexNotice);
		}
		
		indexNotice = new IndexNoticeModel();
		indexNotice.setMenuType(MenuType.business);
		indexNotice.setSonMenuType(SonMenuType.tempcircuit);
		indexNotice.setNum(tcnum);
		indexNotice.setUrl("tempcircuit/tasklist.do");
		inmodel.add(indexNotice);
		
		if(flag){
			indexNotice = new IndexNoticeModel();
			indexNotice.setSonMenuType(SonMenuType.formalcircuit);
			indexNotice.setNum(fcnum);
			indexNotice.setUrl("formalcircuit/tasklist.do");
			inmodel.add(indexNotice);
			indexNotice = new IndexNoticeModel();
			indexNotice.setSonMenuType(SonMenuType.telegraph);
			indexNotice.setNum(tgnum);
			indexNotice.setUrl("telegraph/tasklist.do");
			inmodel.add(indexNotice);
			indexNotice = new IndexNoticeModel();
			indexNotice.setSonMenuType(SonMenuType.telegraphcircuit);
			indexNotice.setNum(gcnum);
			indexNotice.setUrl("telegraphcircuit/tasklist.do");
			inmodel.add(indexNotice);
			
		}

		indexNotice = new IndexNoticeModel();
		indexNotice.setSonMenuType(SonMenuType.datacomnetwork);
		indexNotice.setNum(nwnum);
		indexNotice.setUrl("datacomnetwork/tasklist.do");
		inmodel.add(indexNotice);
		indexNotice = new IndexNoticeModel();
		indexNotice.setSonMenuType(SonMenuType.transfernet);
		indexNotice.setNum(tnnum);
		indexNotice.setUrl("transfernet/tasklist.do");
		inmodel.add(indexNotice);
		indexNotice = new IndexNoticeModel();
		indexNotice.setSonMenuType(SonMenuType.kusatellite);
		indexNotice.setNum(kunum);
		indexNotice.setUrl("kusatellite/tasklist.do");
		inmodel.add(indexNotice);
		//退网申请
		indexNotice = new IndexNoticeModel();
		indexNotice.setSonMenuType(SonMenuType.signoutnet);
		indexNotice.setNum(ocnum);
		indexNotice.setUrl("signoutnet/tasklist.do");
		inmodel.add(indexNotice);
		
		return inmodel;
	}

	/**
	 * 根据菜单属性获取数据数目
	 *
	 * @param user
	 * @param business
	 * @param formalcircuit 
	 * @author Wang Zhicheng
	 * @date  2015年11月4日下午4:33:02
	 * @since 1.0.0
	 */
	private int getCountNum(User user, MenuType menutype,
			SonMenuType sonmenutype) {
		
		//查询数量
		int num = 0;
		
		StringBuffer roleNames = new StringBuffer("|");
		List<Role> roles = user.getRoles();
		if(!CollectionUtils.isEmpty(roles)){
			for (Role role : roles) {
				roleNames.append(role.getName());
				roleNames.append("|");
			}
		}
		
		//未审核的临时用户查询(属于客户管理模块)
		if(ObjectUtil.equals(MenuType.clientmng, menutype)){
			if(ObjectUtil.equals(SonMenuType.tempUserRegister, sonmenutype)){
				if ((roleNames.toString().contains("|" + RoleEnum.admin.name() + "|")) || (roleNames.toString().contains("|" + RoleEnum.audituser.name() + "|"))){
					CsRole role = new CsRole();
					role.setName(RoleEnum.aaTempUser.name());
					role.setInfo(RoleEnum.aaTempUser.getValue());
					num = this.clientManager.getTimeUserRegistedCount(role, CsUserStatusEnum.REGISTED);
				}
			}
		}
		
		if(ObjectUtil.equals(MenuType.business, menutype)){
			
			if(ObjectUtil.equals(SonMenuType.formalcircuit, sonmenutype)){
				//正式电路
				FormalCircuitQueryModel queryModel = new FormalCircuitQueryModel();
				//根据不同角色获取不同的数据
				List<FormalStatEnum> approveStatList = new ArrayList<FormalStatEnum>();
				if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
					approveStatList.add(FormalStatEnum.csleader_approve);
					queryModel.setStatusList(approveStatList);
				}
				if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
					approveStatList.add(FormalStatEnum.csstaff_firstdeal);
					approveStatList.add(FormalStatEnum.csstaff_deal);
				}
				if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
					approveStatList.add(FormalStatEnum.atncleader_approve);
					approveStatList.add(FormalStatEnum.atncleader_seconddeal);
					approveStatList.add(FormalStatEnum.atncleader_firstdeal);
					//段衍林添加
					approveStatList.add(FormalStatEnum.atncleader_thirddeal);
				}
				if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
					approveStatList.add(FormalStatEnum.engineer_config);
					approveStatList.add(FormalStatEnum.engineer_firstaudit);
					approveStatList.add(FormalStatEnum.engineer_secondaudit);
					approveStatList.add(FormalStatEnum.engineer_transfer);
					queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
				}
				if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")){ //事业部领导
					approveStatList.add(FormalStatEnum.generalmanager_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")){ //财务部经理
					approveStatList.add(FormalStatEnum.fundmanager_approve);
				}
				queryModel.setStatusList(approveStatList);
				if(formalCircuitManager.queryPage(queryModel).getResult() != null){
					num = (int) formalCircuitManager.queryPage(queryModel).getTotalCount();
				}
			}else if(ObjectUtil.equals(SonMenuType.datacomnetwork, sonmenutype)){
				//数据通信网
				DataComNetworkQueryModel queryModel = new DataComNetworkQueryModel();
				//根据不同角色获取不同的数据
				List<NetWorkStatEnum> approveStatList = new ArrayList<NetWorkStatEnum>();
				if(roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
					approveStatList.add(NetWorkStatEnum.csleader_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
					approveStatList.add(NetWorkStatEnum.csstaff_firstdeal);
					approveStatList.add(NetWorkStatEnum.csstaff_deal);
				}
				if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
					approveStatList.add(NetWorkStatEnum.atncleader_approve);
					approveStatList.add(NetWorkStatEnum.atncleader_seconddeal);
					approveStatList.add(NetWorkStatEnum.atncleader_firstdeal);
					approveStatList.add(NetWorkStatEnum.atncleader_thirddeal);
				}
				if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
					approveStatList.add(NetWorkStatEnum.engineer_config);
					approveStatList.add(NetWorkStatEnum.engineer_firstaudit);
					approveStatList.add(NetWorkStatEnum.engineer_secondaudit);
					approveStatList.add(NetWorkStatEnum.engineer_transfer);
					queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
				}
				if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")){ //事业部领导
					approveStatList.add(NetWorkStatEnum.generalmanager_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.netmanager.name() + "|")){ //网控事业部经理
					approveStatList.add(NetWorkStatEnum.netmanager_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")){ //公司领导
					approveStatList.add(NetWorkStatEnum.compenyleader_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")){ //财务部经理
					approveStatList.add(NetWorkStatEnum.fundmanager_approve);
				}
				queryModel.setStatusList(approveStatList);
				if(dataComNetworkManager.queryPage(queryModel).getResult() != null){
					num = (int) dataComNetworkManager.queryPage(queryModel).getTotalCount();
				}
			}else if(ObjectUtil.equals(SonMenuType.transfernet, sonmenutype)){
				//自动转报网
				TransferNetQueryModel queryModel = new TransferNetQueryModel();
				//根据不同角色获取不同的数据
				List<TransferNetStatEnum> approveStatList = new ArrayList<TransferNetStatEnum>();
				if(roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
					approveStatList.add(TransferNetStatEnum.csleader_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
					approveStatList.add(TransferNetStatEnum.csstaff_firstdeal);
					approveStatList.add(TransferNetStatEnum.csstaff_deal);
				}
				if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
					approveStatList.add(TransferNetStatEnum.atncleader_approve);
					approveStatList.add(TransferNetStatEnum.atncleader_seconddeal);
					approveStatList.add(TransferNetStatEnum.atncleader_firstdeal);
					approveStatList.add(TransferNetStatEnum.atncleader_thirddeal);
				}
				if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
					approveStatList.add(TransferNetStatEnum.engineer_config);
					approveStatList.add(TransferNetStatEnum.engineer_firstaudit);
					approveStatList.add(TransferNetStatEnum.engineer_secondaudit);
					approveStatList.add(TransferNetStatEnum.engineer_transfer);
					queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
				}
				if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")){ //事业部领导
					approveStatList.add(TransferNetStatEnum.generalmanager_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.netmanager.name() + "|")){ //网控事业部经理
					approveStatList.add(TransferNetStatEnum.netmanager_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")){ //公司领导
					approveStatList.add(TransferNetStatEnum.compenyleader_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")){ //财务部经理
					approveStatList.add(TransferNetStatEnum.fundmanager_approve);
				}
				queryModel.setStatusList(approveStatList);
				if(transferNetManager.queryPage(queryModel).getResult() != null){
					num = (int) transferNetManager.queryPage(queryModel).getTotalCount();
				}
			}else if(ObjectUtil.equals(SonMenuType.kusatellite, sonmenutype)){
				//卫星通信网
				KuSatelliteQueryModel queryModel = new KuSatelliteQueryModel();
				//根据不同角色获取不同的数据
				List<ApproveStatEnum> approveStatList = new ArrayList<ApproveStatEnum>();
				if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
					approveStatList.add(ApproveStatEnum.csleader_review);
				}
				if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
					approveStatList.add(ApproveStatEnum.csstaff_audit);
					approveStatList.add(ApproveStatEnum.csstaff_deal);
				}
				if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
					approveStatList.add(ApproveStatEnum.atncleader_firstdeal);
					approveStatList.add(ApproveStatEnum.atncleader_review);
					approveStatList.add(ApproveStatEnum.atncleader_approve);
					approveStatList.add(ApproveStatEnum.atncleader_audit);
				}
				if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
					approveStatList.add(ApproveStatEnum.engineer_firstaudit);
					approveStatList.add(ApproveStatEnum.engineer_config);
					approveStatList.add(ApproveStatEnum.assist_config);
					approveStatList.add(ApproveStatEnum.engineer_audit);
					queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
				} 
				if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) {	//营销事业部总经理
					approveStatList.add(ApproveStatEnum.marketmanager_approve);
				} 
				if(roleNames.toString().contains("|" + RoleEnum.netmanager.name() + "|")) {
					approveStatList.add(ApproveStatEnum.netmanager_approve);
				} 
				if(roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")) {
					approveStatList.add(ApproveStatEnum.leader_approve);
				} 
				if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")) {
					approveStatList.add(ApproveStatEnum.fundmanager_confirm);
				}
				queryModel.setStatusList(approveStatList);
				if(kuSatelliteService.queryPageByModel(queryModel).getResult() != null){
					num = (int) kuSatelliteService.queryPageByModel(queryModel).getTotalCount();
				}
			}else if(ObjectUtil.equals(SonMenuType.telegraph, sonmenutype)){
				//转报网路由地址
				TeleGraphQueryModel queryModel = new TeleGraphQueryModel();
				//根据不同角色获取不同的数据
				List<TeleGraphApproveStatEnum> approveStatList = new ArrayList<TeleGraphApproveStatEnum>();
				if (roleNames.toString().contains("|"+RoleEnum.csLeader.name()+"|")){ // 客服领导
					approveStatList.add(TeleGraphApproveStatEnum.csleader_review);
				}
				if(roleNames.toString().contains("|"+RoleEnum.csStaff.name()+"|")){ // 客服专员
					approveStatList.add(TeleGraphApproveStatEnum.csstaff_audit);
					approveStatList.add(TeleGraphApproveStatEnum.csstaff_deal);
				}
				if(roleNames.toString().contains("|"+RoleEnum.atncLeader.name()+"|")){// 网控领导
					approveStatList.add(TeleGraphApproveStatEnum.atncleader_approve);
					approveStatList.add(TeleGraphApproveStatEnum.atncleader_audit);
					approveStatList.add(TeleGraphApproveStatEnum.atncleader_firstdeal);
					approveStatList.add(TeleGraphApproveStatEnum.atncleader_review);
				} 
				if(roleNames.toString().contains("|"+RoleEnum.manager.name()+"|")) {		//事业部总经理
					approveStatList.add(TeleGraphApproveStatEnum.generalmanager_approve);
				}
				if(roleNames.toString().contains("|"+RoleEnum.fundmanager.name()+"|")) {		//事业部总经理
					approveStatList.add(TeleGraphApproveStatEnum.fundmanager_confirm);
				}
				if(roleNames.toString().contains("|"+RoleEnum.engineer.name()+"|")){ // 工程师
					approveStatList.add(TeleGraphApproveStatEnum.engineer_config);
					approveStatList.add(TeleGraphApproveStatEnum.assist_config);
					approveStatList.add(TeleGraphApproveStatEnum.atnc_test);
					approveStatList.add(TeleGraphApproveStatEnum.engineer_audit);
					queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
				}
				queryModel.setStatusList(approveStatList);
				//筛选转报地址申请信息，区分转报电路
				List<TeleGraphApply> teleGraphApplys = teleGraphApplyService.getAll();
				queryModel.setTeleGraphApplys(teleGraphApplys);
				if(teleGraphService.queryPageByModel(queryModel).getResult() != null){
					num = (int) teleGraphService.queryPageByModel(queryModel).getTotalCount();
				}
			}else if(ObjectUtil.equals(SonMenuType.telegraphcircuit, sonmenutype)){
				//转报网电路
				TeleGraphQueryModel queryModel = new TeleGraphQueryModel();
				//根据不同角色获取不同的数据
				List<TeleGraphApproveStatEnum> approveStatList = new ArrayList<TeleGraphApproveStatEnum>();
				if (roleNames.toString().contains("|"+RoleEnum.csLeader.name()+"|")){ // 客服领导
					approveStatList.add(TeleGraphApproveStatEnum.csleader_review);
				}
				if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
					approveStatList.add(TeleGraphApproveStatEnum.csstaff_audit);
					approveStatList.add(TeleGraphApproveStatEnum.csstaff_deal);
				}
				if(roleNames.toString().contains("|"+RoleEnum.atncLeader.name()+"|")){// 网控领导
					approveStatList.add(TeleGraphApproveStatEnum.atncleader_firstdeal);
					approveStatList.add(TeleGraphApproveStatEnum.atncleader_review);
					approveStatList.add(TeleGraphApproveStatEnum.atncleader_approve);
					approveStatList.add(TeleGraphApproveStatEnum.atncleader_audit);
				}
				if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) {		//事业部总经理
					approveStatList.add(TeleGraphApproveStatEnum.generalmanager_approve);
				}
				if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")) {		//事业部总经理
					approveStatList.add(TeleGraphApproveStatEnum.fundmanager_confirm);
				}
				if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
					approveStatList.add(TeleGraphApproveStatEnum.engineer_firstaudit);
					approveStatList.add(TeleGraphApproveStatEnum.engineer_audit);
					approveStatList.add(TeleGraphApproveStatEnum.engineer_config);
					approveStatList.add(TeleGraphApproveStatEnum.assist_config);
					approveStatList.add(TeleGraphApproveStatEnum.atnc_test);
					queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
				}
				queryModel.setStatusList(approveStatList);
				//筛选转报电路申请信息，与转报地址分开
				List<TeleGraphCircuit> teleGraphCircuits = teleGraphCircuitService.getAll();
				queryModel.setTeleGraphCircuits(teleGraphCircuits);
				if(teleGraphCircuitService.queryPageByModel(queryModel).getResult() != null){
					num = (int) teleGraphCircuitService.queryPageByModel(queryModel).getTotalCount();
				}
			}else if(ObjectUtil.equals(SonMenuType.signoutnet, sonmenutype)){
				//卫星通信网
				SignoutNetQueryModel queryModel = new SignoutNetQueryModel();
				//根据不同角色获取不同的数据
				List<ApproveStatEnum> approveStatList = new ArrayList<ApproveStatEnum>();
				if (roleNames.toString().contains("|" + RoleEnum.csLeader.name() + "|")){ // 客服领导
					approveStatList.add(ApproveStatEnum.csleader_review);
				}
				if(roleNames.toString().contains("|" + RoleEnum.csStaff.name() + "|")){ // 客服专员
					approveStatList.add(ApproveStatEnum.csstaff_audit);
					approveStatList.add(ApproveStatEnum.csstaff_deal);
				}
				if(roleNames.toString().contains("|" + RoleEnum.atncLeader.name() + "|")){// 网控领导
					approveStatList.add(ApproveStatEnum.atncleader_firstdeal);
					approveStatList.add(ApproveStatEnum.atncleader_review);
					approveStatList.add(ApproveStatEnum.atncleader_approve);
					approveStatList.add(ApproveStatEnum.atncleader_audit);
				}
				if(roleNames.toString().contains("|" + RoleEnum.engineer.name() + "|")){ // 工程师
					approveStatList.add(ApproveStatEnum.engineer_firstaudit);
					approveStatList.add(ApproveStatEnum.engineer_config);
					approveStatList.add(ApproveStatEnum.assist_config);
					approveStatList.add(ApproveStatEnum.engineer_audit);
					queryModel.setNextUser(user.getId()); //该查询条件查询上一步移交给自己的记录
				} 
				if(roleNames.toString().contains("|" + RoleEnum.manager.name() + "|")) {	//营销事业部总经理
					approveStatList.add(ApproveStatEnum.marketmanager_approve);
				} 
				if(roleNames.toString().contains("|" + RoleEnum.netmanager.name() + "|")) {
					approveStatList.add(ApproveStatEnum.netmanager_approve);
				} 
				if(roleNames.toString().contains("|" + RoleEnum.leader.name() + "|")) {
					approveStatList.add(ApproveStatEnum.leader_approve);
				} 
				if(roleNames.toString().contains("|" + RoleEnum.fundmanager.name() + "|")) {
					approveStatList.add(ApproveStatEnum.fundmanager_confirm);
				}
				queryModel.setStatusList(approveStatList);
				if(signoutNetManager.queryPage(queryModel).getResult() != null){
					num = (int) signoutNetManager.queryPage(queryModel).getTotalCount();
				}
			}
		}
		return num;
	}
}
