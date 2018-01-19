package cn.com.atnc.ioms.mng.phonemng.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.phonemng.ICallInfoDao;
import cn.com.atnc.ioms.dao.phonemng.IContactsMngDao;
import cn.com.atnc.ioms.dao.turndutymng.ISignLeaveDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.entity.phonemng.ContactsMng;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.phonemng.CallIsDel;
import cn.com.atnc.ioms.enums.phonemng.CallStateEnum;
import cn.com.atnc.ioms.enums.phonemng.CallTypeEnum;
import cn.com.atnc.ioms.enums.phonemng.ContactStatusEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyStatusEnum;
import cn.com.atnc.ioms.mng.phonemng.IAgentInfoService;
import cn.com.atnc.ioms.mng.phonemng.ICallInfoService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;
import cn.com.atnc.ioms.model.phonemng.ContactsMngQueryModel;
import cn.com.atnc.ioms.model.phonemng.CountCallModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;

/**
 * 
 * @author hantianyu
 * 
 */
@Service("ICallInfoService")
public class CallInfoServiceImpl extends BaseService implements
		ICallInfoService {
	@Autowired
	private ICallInfoDao callInfoDao;
	@Autowired
	private IContactsMngDao contactsMngDao;
	@Autowired
	private ISignLeaveService signLeaveService;

	@Autowired
	private IAgentInfoService agentInfoService;

	@Autowired
	private ISignLeaveDao signLeaveDao;

	SimpleDateFormat ringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat beginDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public Pagination queryPage(CallInformationQueryModel queryModel) {
		// TODO Auto-generated method stub
		return callInfoDao.queryPage(queryModel);
	}

	public Pagination queryPageExport(CallInformationQueryModel queryModel) {
		// TODO Auto-generated method stub
		return callInfoDao.queryPageExport(queryModel);
	}

	public Pagination queryPageMissedCall(CallInformationQueryModel queryModel) {
		// TODO Auto-generated method stub
		Pagination page = callInfoDao.queryPageMissedCall(queryModel);
		List<CallInformation> callInfoList = (List<CallInformation>) page
				.getResult();

		for (CallInformation callInfo : callInfoList) {
			// 根据电话查询联系人信息
			ContactsMngQueryModel qm = new ContactsMngQueryModel();
			qm.setTelNumber(callInfo.getCallonNumber());
			List<ContactsMng> contactList = contactsMngDao
					.getContactsInfoTel(qm);
			if (contactList.size() > 0) {
				// 当前数据库已存入联系人信息
				if (contactList.size() > 1) {
					// 同一个电话可能会对应不同的联系人信息
					String str_name = "";
					String str_com = "";
					String str_area = "";
					// 拼接字符串
					for (ContactsMng contacts : contactList) {
						if (str_name.equals("")) {
							// 第一次循环
							str_name = contacts.getContactName();
							str_com = contacts.getCompanyInfo();
							str_area = contacts.getContactPlace();
						} else {
							str_name = str_name + "、"
									+ contacts.getContactName();
							str_com = str_com + "、" + contacts.getCompanyInfo();
							str_area = str_area + "、"
									+ contacts.getContactPlace();
						}
					}
					callInfo.setContactName(str_name);
					callInfo.setContactArea(str_com);
					callInfo.setCompanyInfo(str_area);
				} else {
					// 该号码仅对应唯一的联系人信息
					ContactsMng contactsMng = contactList.get(0);
					callInfo.setContactName(contactsMng.getContactName());
					callInfo.setContactArea(contactsMng.getContactPlace());
					callInfo.setCompanyInfo(contactsMng.getCompanyInfo());
				}
			} else {
				// 为存入数据库的联系人
				callInfo.setContactName("未知");
				callInfo.setContactArea("未知");
				callInfo.setCompanyInfo("未知");
			}
		}
		return page;
	}

	public String save(CallInformation callInfo) {
		String result = "";

		CallInformationQueryModel qm = new CallInformationQueryModel();
		qm.setCallSheetId(callInfo.getCallSheetId());
		List<CallInformation> callInfoList = callInfoDao
				.getCallInfoListByCallSheetId(qm);
		// 判断是否添加过
		if (callInfoList.size() <= 0) {
			result = callInfoDao.save(callInfo).toString();
		}
		return result;
	}

	public CallInformation saveInt(String callstatus, String beginTime,
			String endTime, String recordFile, String ringTime,
			String callType, String callsheetId, String agent, String callNo,
			String calledNo, String callerCity, String callerProvince,
			String fileServer, String username) {

		CallInformation callInfo = new CallInformation();
		callInfo.setIsDel(CallIsDel.NOTDEL);
		callInfo.setCalledNumber(calledNo);
		callInfo.setCallonCity(callerCity.toString());
		callInfo.setCallonNumber(callNo);
		callInfo.setCallonProvince(callerProvince.toString());
		callInfo.setCallSheetId(callsheetId);
		// 接听状态
		if (!StringUtils.isEmpty(callstatus)) {
			// 转换成大写 获取对应的枚举
			CallStateEnum callStateEnum = CallStateEnum.valueOf(callstatus
					.toUpperCase());
			callInfo.setCallState(callStateEnum);
		}
		// 通话类型
		if (!StringUtils.isEmpty(callType)) {
			CallTypeEnum callTypeEnum = CallTypeEnum.valueOf(callType
					.toUpperCase());
			callInfo.setCallType(callTypeEnum);
		}
		callInfo.setFileServer(fileServer);
		callInfo.setRecordFileName(recordFile);
		callInfo.setStationNumber(agent);
		callInfo.setUserName(username);
		double number = 0.00;
		callInfo.setCallDuration(number);

		try {
			// 转换时间
			// 响铃时间,外呼为空
			if (!StringUtils.isEmpty(ringTime)) {
				if (callInfo.getCallType().name().equals("NORMAL")) {
					// 不等于外呼
					callInfo.setRingingTime(ringDate.parse(ringTime));
				} else
					System.err.println("DIALOUT外呼通话");

			}

			// 挂电话时间
			if (!StringUtils.isEmpty(endTime)) {
				if (callType.equals(CallTypeEnum.TRANSFER)
						|| callType.equals(CallTypeEnum.DIALTRANSFER)) {
					endTime = endTime.replace("%20", " ");
				}

				callInfo.setCallendTime(endDate.parse(endTime));
			}
			// 未接来电没有开始时间
			if (!StringUtils.isEmpty(beginTime)) {

				if (callType.equals(CallTypeEnum.TRANSFER)
						|| callType.equals(CallTypeEnum.DIALTRANSFER)) {
					beginTime = beginTime.replace("%20", " ");
				}
				if (!beginTime.equals("undefined")) {

					// 非未接
					callInfo.setPickupTime(beginDate.parse(beginTime));

					Date dt1 = callInfo.getPickupTime();
					Date dt2 = callInfo.getCallendTime();
					// 结束时间-开始时间
					long diff = dt2.getTime() - dt1.getTime();
					long seconds = diff / (1000);// 秒
					// 通话时间插入数据库，单位（分钟）
					callInfo.setCallDuration(seconds);
				} else
					System.err.println("undefined通话开始时间");
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return callInfo;

	}

	public String callDelByIds(String[] ids) {
		// CallInformation callInformation=null;
		int i = 0;

		for (String sid : ids) {
			System.err.println("dellist" + sid);
			CallInformation callInformation = callInfoDao.findById(sid);
			callInformation.setIsDel(CallIsDel.DEL);
			callInfoDao.saveOrUpdate(callInformation);
			i++;
		}
		return null;
	}

	public CallInformation findViewById(String id) {
		return callInfoDao.findById(id);
	}

	public CallInformation callDelById(CallInformation callInfo) {
		callInfo.setIsDel(CallIsDel.DEL);
		callInfoDao.saveOrUpdate(callInfo);
		return callInfo;
	}

	public String missedCallCount(String username) {
		String result = "0";
		CallInformationQueryModel qm = new CallInformationQueryModel();
		qm.setUserName(username);
		List<CallInformation> missedCallList = callInfoDao
				.getMissedCallListByUser(qm);
		if (missedCallList.size() > 0) {
			result = String.valueOf(missedCallList.size());
		}

		return result;
	}

	public List<CallInformation> getMissedCallList(String username) {
		CallInformationQueryModel qm = new CallInformationQueryModel();
		qm.setUserName(username);
		List<CallInformation> callList = callInfoDao
				.getMissedCallListByUser(qm);
		// 生明一个空的list
		List<CallInformation> list = new ArrayList<CallInformation>();
		if (callList.size() > 0) {
			for (int i = 0; i < callList.size(); i++) {
				if (i <= 2) {
					// 只插入前三条
					list.add(callList.get(i));
				} else {
					break;
				}
			}
		}
		return list;
	}

	public List<String> getNameList(CallInformationQueryModel qm) {
		List<String> callInfoList = callInfoDao.getNameList(qm);
		List<String> nameList = new ArrayList<String>();
		if (callInfoList.size() > 0) {
			for (int i = 0; i < callInfoList.size(); i++) {
				if (callInfoList.get(i) != null) {
					// 存在为null的可能
					nameList.add(callInfoList.get(i));
				}

			}
		}
		return nameList;
	}

	public Map<String, Map<String, List<String>>> getCountList(
			CallInformationQueryModel qm) {
		Map<String, List<String>> callChartMap = new LinkedHashMap();
		Map<String, Map<String, List<String>>> allChart = new LinkedHashMap();
		List<String> keyList = this.getKeyList();
		// 获取工程师姓名
		List<String> nameList = this.getNameList(qm);
		if (nameList.size() > 0) {

			for (int j = 0; j < keyList.size(); j++) {
				List<String> valueList = new ArrayList<String>();

				for (int i = 0; i < nameList.size(); i++) {
					// 查询条件赋值
					qm.setUserName(nameList.get(i));
					if (keyList.get(j).equals("未接")) {
						// 未接来电
						qm.setCallState(CallStateEnum.NOTDEAL);
						List<CallInformation> list = callInfoDao
								.getCountByName(qm);
						// 插入
						valueList.add(String.valueOf(list.size()));
					}
					if (keyList.get(j).equals("正常来电")) {
						qm.setCallState(CallStateEnum.DEALING);
						qm.setCallType(CallTypeEnum.NORMAL);
						List<CallInformation> list = callInfoDao
								.getCountByName(qm);
						// 插入
						valueList.add(String.valueOf(list.size()));
					}
					if (keyList.get(j).equals("外呼")) {
						qm.setCallState(CallStateEnum.DEALING);
						qm.setCallType(CallTypeEnum.DIALOUT);
						List<CallInformation> list = callInfoDao
								.getCountByName(qm);
						// 插入
						valueList.add(String.valueOf(list.size()));
					}
					if (keyList.get(j).equals("转接")) {

						qm.setCallState(CallStateEnum.DEALING);
						// 来电转接
						qm.setCallType(CallTypeEnum.TRANSFER);
						List<CallInformation> list = callInfoDao
								.getCountByName(qm);

						// 外呼转接
						qm.setCallType(CallTypeEnum.DIALTRANSFER);
						List<CallInformation> list2 = callInfoDao
								.getCountByName(qm);
						Integer count = list.size() + list2.size();
						// 插入
						valueList.add(String.valueOf(count));
					}
				}

				callChartMap.put(keyList.get(j), valueList);
			}//
			for (int i = 0; i < nameList.size(); i++) {
				allChart.put(nameList.get(i), callChartMap);
			}
		}

		return allChart;
	}

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getKeyList
	 * @Description:统计类别
	 * @Param:@return
	 * @Return:List<String>
	 * @Creatime:2016年8月25日 下午1:41:56
	 */
	public List<String> getKeyList() {
		List<String> keyList = new ArrayList<String>();
		keyList.add("未接");
		keyList.add("正常来电");
		keyList.add("外呼");
		keyList.add("转接");

		return keyList;
	}

	public Map<String, String> getCountPieByName(CallInformationQueryModel qm) {
		Map<String, String> callChartMap = new LinkedHashMap();
		List<String> keyList = this.getKeyList();
		for (int j = 0; j < keyList.size(); j++) {

			if (keyList.get(j).equals("未接")) {
				// 未接来电
				qm.setCallState(CallStateEnum.NOTDEAL);
				List<CallInformation> list = callInfoDao.getCountPieByName(qm);
				// 插入
				callChartMap.put(keyList.get(j), String.valueOf(list.size()));
			}
			if (keyList.get(j).equals("正常来电")) {
				qm.setCallState(CallStateEnum.DEALING);
				qm.setCallType(CallTypeEnum.NORMAL);
				List<CallInformation> list = callInfoDao.getCountPieByName(qm);

				callChartMap.put(keyList.get(j), String.valueOf(list.size()));

			}
			if (keyList.get(j).equals("外呼")) {
				qm.setCallState(CallStateEnum.DEALING);
				qm.setCallType(CallTypeEnum.DIALOUT);
				List<CallInformation> list = callInfoDao.getCountPieByName(qm);

				callChartMap.put(keyList.get(j), String.valueOf(list.size()));
			}
			if (keyList.get(j).equals("转接")) {

				qm.setCallState(CallStateEnum.DEALING);
				// 来电转接
				qm.setCallType(CallTypeEnum.TRANSFER);
				List<CallInformation> list = callInfoDao.getCountPieByName(qm);

				// 外呼转接
				qm.setCallType(CallTypeEnum.DIALTRANSFER);
				List<CallInformation> list2 = callInfoDao.getCountPieByName(qm);
				Integer count = list.size() + list2.size();

				callChartMap.put(keyList.get(j), String.valueOf(count));
			}
		}
		return callChartMap;
	}

	public Map<String, String> getLineChartByName(CallInformationQueryModel qm) {
		Map<String, String> callChartMap = new LinkedHashMap();

		List<String> names = this.getNameList(qm);
		if (names.size() > 0) {
			for (int i = 0; i < names.size(); i++) {
				String val = "";
				qm.setUserName(names.get(i));
				List<Double> listDouble = callInfoDao.getCountLineByName(qm,
						"2");
				if (listDouble.size() > 0) {
					val = String.valueOf(listDouble.get(0));
				} else {
					val = "0";
				}
				callChartMap.put(names.get(i), val);
			}
		}

		return callChartMap;
	}

	// getFileByDate
	public String getFileByDate(CallInformationQueryModel qm) {
		String fileStr = "";
		List<CallInformation> list = callInfoDao.getFileByDate(qm);

		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				CallInformation callInfo = list.get(i);
				if (!callInfo.getRecordFileName().equals("undefined")) {
					String[] listFile = callInfo.getRecordFileName().split("/");
					if (listFile.length > 1) {
						for (int j = 0; j < listFile.length; j++) {
							if (j != (listFile.length - 1)) {
								fileStr = fileStr + "\\" + listFile[j];
							}

						}
						break;
					}
				}
			}

		}

		return fileStr;
	}

	public Workbook exportCallRecord(CallInformationQueryModel qm) {

		List<CallInformation> list = callInfoDao.listExport(qm);
		Workbook wb = null;
		Sheet sheet = null;
		int count = 0;
		int rowCount = 0;
		wb = new HSSFWorkbook();
		sheet = wb.createSheet("call-record");// 注意获取sheet的方式不一样
		Row titleRow1 = sheet.createRow(rowCount++);

		titleRow1.createCell(count++).setCellValue("电话类型");
		titleRow1.createCell(count++).setCellValue("接听状态");
		titleRow1.createCell(count++).setCellValue("是否删除");
		titleRow1.createCell(count++).setCellValue("主叫电话");
		titleRow1.createCell(count++).setCellValue("被叫电话");

		titleRow1.createCell(count++).setCellValue("打入时间");
		titleRow1.createCell(count++).setCellValue("摘机时间");
		titleRow1.createCell(count++).setCellValue("通话结束时间");
		titleRow1.createCell(count++).setCellValue("通话时长");
		titleRow1.createCell(count++).setCellValue("主叫地区");
		titleRow1.createCell(count++).setCellValue("值班工程师");

		int column = count;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// 导入统计的数据
		for (int x = 0; x < list.size(); x++) {
			CallInformation callinfo = list.get(x);
			// System.err.println(callinfo.getUserName()+"--------");
			count = 0;

			Row row = sheet.createRow(rowCount++);
			// hty
			String ringtime = "";
			String pickuptime = "";
			String endtime = "";
			if (callinfo.getRingingTime() != null) {
				ringtime = format.format(callinfo.getRingingTime());
			}
			if (callinfo.getPickupTime() != null) {
				pickuptime = format.format(callinfo.getPickupTime());
			}
			if (callinfo.getCallendTime() != null) {
				endtime = format.format(callinfo.getCallendTime());
			}
			// end
			row.createCell(count++).setCellValue(
					callinfo.getCallType().getValue());
			row.createCell(count++).setCellValue(
					callinfo.getCallState().getValue());
			row.createCell(count++)
					.setCellValue(callinfo.getIsDel().getValue());
			row.createCell(count++).setCellValue(callinfo.getCallonNumber());
			row.createCell(count++).setCellValue(callinfo.getCalledNumber());

			row.createCell(count++).setCellValue(ringtime);
			row.createCell(count++).setCellValue(pickuptime);
			row.createCell(count++).setCellValue(endtime);

			row.createCell(count++).setCellValue(
					String.valueOf(callinfo.getCallDuration()));
			row.createCell(count++).setCellValue(
					callinfo.getCallonProvince() + callinfo.getCallonCity());
			row.createCell(count++).setCellValue(callinfo.getUserName());

		}

		// 设置合适的列宽
		for (int i = 0; i < column; i++) {
			Row inial = sheet.getRow(0);
			String inialStr = inial.getCell(i).getStringCellValue();
			int inialLength = inialStr.length() + getChineseNum(inialStr);
			for (int j = 0; j < rowCount - 1; j++) {
				Row anthor = sheet.getRow(j + 1);
				String anthorStr = anthor.getCell(i).getStringCellValue();
				int anthorLength = anthorStr.length()
						+ getChineseNum(anthorStr);
				if (inialLength < anthorLength) {
					inialLength = anthorLength;
				}
			}
			sheet.setColumnWidth(i, (inialLength + 2) * 256);
		}
		return wb;
	}

	public int getChineseNum(String content) {
		int num = 0;
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(content);
		while (m.find()) {
			num++;
		}
		return num;
	}

	public boolean judgeStatus(User user, String opt) {

		// flase 不需要改标志位，true需要改
		boolean flag = false;
		SignLeaveRecord sign = signLeaveService.findViewByUser(user);
		String dutyStatus = sign.getDutyStatus().name();
		System.err.println("dutyStatus:" + dutyStatus);
		if (opt.equals("signout")) {
			if (dutyStatus.equals("SIGNINACTIVE")) {
				// 已签到已激活坐席 SIGNINACTIVE 签出时 判断
				flag = true;
			}
		} else {
			if (dutyStatus.equals("SIGNIN")) {
				// 进入时，未激活坐席的状态
				flag = true;
			}
		}

		return flag;
	}

	public String modDutyStatus(User user, String opt) {
		// 签出，进入时进行的操作
		String result = "FAIL";
		String str = "";
		System.err.println("modDutyStatus---" + user.getName());
		if (this.judgeStatus(user, opt)) {
			System.err.println("true---" + user.getName());
			// 调整
			str = modSignAndAgent(user, opt);
			if (str.equals("YES")) {
				result = "SUCCESS";
			}
		}

		return result;
	}

	public String modSignAndAgent(User user, String opt) {
		SignLeaveRecord sign = signLeaveService.findViewByUser(user);

		String result = "NO";
		if (opt.equals("signout")) {
			// 签出
			agentInfoService.modLeave(sign.getAgentNumber());
			sign.setAgentNumber(null);
			sign.setDutyStatus(DutyStatusEnum.SIGNIN);

			signLeaveDao.saveOrUpdate(sign);
			result = "YES";
		} else {
			// 从 值班页面进入点击按钮后进行的操作
			SignLeaveQueryModel queryModel = new SignLeaveQueryModel();
			queryModel.setDutyStatus(DutyStatusEnum.SIGNINACTIVE);
			List<SignLeaveRecord> listSign = signLeaveDao
					.getDutyStatus(queryModel);

			if (listSign.size() < 4) {

				// 需要激活坐席
				sign.setDutyStatus(DutyStatusEnum.SIGNINACTIVE);
				// 调整坐席状态
				sign.setAgentNumber(agentInfoService.modSign(sign.getUserinfo()
						.getName()));
				signLeaveDao.saveOrUpdate(sign);
				result = "YES";
			}

		}

		return result;
	}

	/**
	 * 查询未经过备份的录音文件
	 */
	public List<CallInformation> getBackUpList(
			CallInformationQueryModel callModel) {
		List<CallInformation> list = callInfoDao.backupCallInfo(callModel);
		return list;
	}

	/**
	 * 归类
	 * 
	 * @author 韩天驭
	 * @2017年1月5日 下午5:23:47
	 * @param callInfo
	 *            通话记录实体
	 * @param ids
	 *            通话记录id void
	 */
	public void callClassify(CallInformation callInfo, String[] ids,User user) {
         if(ids.length>0){
        	 //选择结果>0
        	 for(int i=0;i<ids.length;i++){
        		 //循环获取实体
        		 CallInformation newCallInfo=this.findViewById(ids[i].toString());
        		 if(newCallInfo!=null){
        			 //判断是否为空；非空
        			 //设置类别
        			 newCallInfo.setAtncType(callInfo.getAtncType());
        			 //设置操作信息
        			 newCallInfo.setOptTime(new Date());
        			 newCallInfo.setOptUser(user);
        			 //设置备注信息
        			 newCallInfo.setRemark(callInfo.getRemark());
        			 //保存
        			 callInfoDao.saveOrUpdate(newCallInfo);
        		 }
        		 
        	 }
         }
	}
	/**
	 * 查询统计
	 */
	public Map<String,List<String>> CountTimes(CallInformationQueryModel qm){
		
		//CallInformationQueryModel qm=new CallInformationQueryModel();

	    System.err.println("username:"+qm.getUserName());
		Map<String,List<String>> callMap=callInfoDao.CountTimes(qm);
	
		return callMap;
		
	}
	/**
	 * 计算总和
	 * @author 韩天驭
	 * @2017年1月10日 下午3:45:02
	 * @param list
	 * 查询结果（秒）
	 * @return
	 * List<String>
	 */
	public List<String> getCountAllTimes(Map<String,List<String>> map){
		
		List<String> list=map.get("通话时长(秒)");
		List<String> resultList=new ArrayList<String>();
		double allnum=0.00;
		if(list.size()>0){
			//循环计算
			for(int i=0;i<list.size();i++){
				//转换成double
				if(list.get(i)!=null || !list.get(i).isEmpty()||!list.get(i).equals("null")){
					//不为空 不为null
					//转换成double
					double num1= Double.parseDouble(list.get(i));
					allnum=allnum+num1;
				}
			}
			if(allnum>0){
				//和大于0 计算
				//秒
				resultList.add(Double.toString(allnum)+"秒");
				double min=60.00;
				resultList.add( String.format("%.2f",allnum/min)+"分钟");
			}
			else{
				//秒
				resultList.add("0秒");
				//分钟
				resultList.add("0分钟");
			}
		}
		else{
			//秒
			resultList.add("0秒");
			//分钟
			resultList.add("0分钟");
		}
		return resultList;
	}
}
