package cn.com.atnc.ioms.mng.phonemng;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;

/**
 * 
 * @author hantianyu
 *
 */
public interface ICallInfoService {
	/**
	 * 
	 * @Author:hantianyu
	 * @Title:queryPage
	 * @Description:查询
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年8月9日 上午10:45:15
	 */
	public Pagination queryPage(CallInformationQueryModel queryModel);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:queryPageMissedCall
	 * @Description:未接来电
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年8月11日 下午2:00:57
	 */
	public Pagination queryPageMissedCall(CallInformationQueryModel queryModel);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:save
	 * @Description:添加通话记录
	 * @Param:@param callInfo
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月5日 下午1:40:18
	 */
	public String save(CallInformation callInfo);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:saveInt
	 * @Description:初始化
	 * @Param:@param callstatus
	 * @Param:@param beginTime
	 * @Param:@param endTime
	 * @Param:@param recordFile
	 * @Param:@param ringTime
	 * @Param:@param callType
	 * @Param:@param callsheetId
	 * @Param:@param agent
	 * @Param:@param callNo
	 * @Param:@param calledNo
	 * @Param:@param callerCity
	 * @Param:@param callerProvince
	 * @Param:@param fileServer
	 * @Param:@param username
	 * @Param:@return
	 * @Return:CallInformation
	 * @Creatime:2016年8月8日 上午9:47:26
	 */
	public CallInformation saveInt(String callstatus, String beginTime,
			String endTime, String recordFile, String ringTime,
			String callType, String callsheetId, String agent, String callNo,
			String calledNo, String callerCity, String callerProvince,
			String fileServer, String username);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:callDelByIds
	 * @Description:批量删除
	 * @Param:@param ids
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月15日 下午2:41:33
	 */
	public String callDelByIds(String[] ids);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:findViewById
	 * @Description:TODO
	 * @Param:@param id
	 * @Param:@return
	 * @Return:CallInformation
	 * @Creatime:2016年8月16日 上午9:32:25
	 */
	public CallInformation findViewById(String id);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:callDelById
	 * @Description:删除
	 * @Param:@param callInfo
	 * @Param:@return
	 * @Return:CallInformation
	 * @Creatime:2016年8月16日 上午9:32:47
	 */
	public CallInformation callDelById(CallInformation callInfo);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:missedCallCount
	 * @Description:获取某工程师未接来电数量
	 * @Param:@param username
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年8月24日 下午1:53:13
	 */
	public String missedCallCount(String username);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getMissedCallList
	 * @Description:获取某工程师未接来电信息列表
	 * @Param:@param username
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年8月24日 下午1:53:44
	 */
	public List<CallInformation> getMissedCallList(String username);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getNameList
	 * @Description:获取工程师姓名
	 * @Param:@param qm
	 * @Return:List<String>
	 * @Creatime:2016年8月25日 上午11:41:57
	 */
	public List<String> getNameList(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getCountList
	 * @Description:堆叠柱状图
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:Map<String,Map<String,List<String>>>
	 * @Creatime:2016年8月25日 下午2:22:45
	 */
	public Map<String, Map<String, List<String>>> getCountList(
			CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getCountPieByName
	 * @Description:饼图-个数
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:Map<String,String>
	 * @Creatime:2016年8月25日 下午7:59:19
	 */
	public Map<String, String> getCountPieByName(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getLineChartByName
	 * @Description:获取线图
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:Map<String,String>
	 * @Creatime:2016年8月26日 下午3:07:02
	 */
	public Map<String, String> getLineChartByName(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getFileByDate
	 * @Description:获取文件夹
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年9月2日 下午2:25:30
	 */
	public String getFileByDate(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:queryPageExport
	 * @Description:通话记录
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年9月6日 下午2:38:07
	 */
	public Pagination queryPageExport(CallInformationQueryModel queryModel);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:exportCallRecord
	 * @Description:导出
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:Workbook
	 * @Creatime:2016年9月6日 下午4:19:23
	 */
	public Workbook exportCallRecord(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:modDutyStatus
	 * @Description:签到时更改两张表的内容
	 * @Param:@param user
	 * @Param:@param opt
	 * @Param:@return
	 * @Return:String
	 * @Creatime:2016年10月10日 下午2:19:31
	 */
	public String modDutyStatus(User user, String opt);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getBackUpList
	 * @Description:获取准备备份的列表
	 * @Param:@param callModel
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年11月21日 上午9:25:18
	 */
	public List<CallInformation> getBackUpList(
			CallInformationQueryModel callModel);

	/**
	 * 更改通话记录类别
	 * 
	 * @author 韩天驭
	 * @2017年1月5日 下午5:29:43
	 * @param callInfo
	 *            通话记录实体
	 * @param ids
	 *            选中列表id
	 * @param user
	 *            操作用户 void
	 */
	public void callClassify(CallInformation callInfo, String[] ids, User user);

	/**
	 * 查询统计
	 * 
	 * @author 韩天驭
	 * @2017年1月9日 下午2:31:41
	 * @param username
	 *            工程师姓名
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @param atncType
	 *            电话类型 void
	 */
	public Map<String, List<String>> CountTimes(CallInformationQueryModel qm);

	/**
	 * 计算总和
	 * 
	 * @author 韩天驭
	 * @2017年1月10日 下午3:58:20
	 * @param map
	 *            返回的查询结果
	 * @return List<String>
	 */
	public List<String> getCountAllTimes(Map<String, List<String>> map);
}
