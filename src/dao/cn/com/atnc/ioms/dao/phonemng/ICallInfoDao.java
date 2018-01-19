package cn.com.atnc.ioms.dao.phonemng;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;
import cn.com.atnc.ioms.model.phonemng.CountCallModel;

/**
 * 
 * @author hantianyu
 *
 */
public interface ICallInfoDao extends IBaseDao<CallInformation> {
	/**
	 * 
	 * @Author:hantianyu
	 * @Title:queryPage
	 * @Description:通话记录查询
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年8月5日 上午11:33:35
	 */
	public Pagination queryPage(CallInformationQueryModel queryModel);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getCallInfoListByCallSheetId
	 * @Description:判断是否重复
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年8月8日 下午1:22:18
	 */
	public List<CallInformation> getCallInfoListByCallSheetId(
			CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:queryPageMissedCall
	 * @Description:通话状态-未接
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年8月11日 下午1:59:38
	 */
	public Pagination queryPageMissedCall(CallInformationQueryModel queryModel);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getMissedCallListByUser
	 * @Description:根据工程师获取未接来电的信息列表
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年8月24日 下午1:37:46
	 */
	public List<CallInformation> getMissedCallListByUser(
			CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getNameList
	 * @Description:获取现有的工程师姓名
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年8月25日 上午11:26:35
	 */
	public List<String> getNameList(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getCountByName
	 * @Description:根据姓名获取对应的信息
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年8月25日 下午1:20:02
	 */
	public List<CallInformation> getCountByName(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getCountPieByName
	 * @Description:饼图-统计次数
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年8月25日 下午7:51:23
	 */
	public List<CallInformation> getCountPieByName(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getCountLineByName
	 * @Description:线图
	 * @Param:@param qm
	 * @Param:@param type
	 * @Param:@return
	 * @Return:List<Double>
	 * @Creatime:2016年8月26日 上午11:38:14
	 */
	public List<Double> getCountLineByName(CallInformationQueryModel qm,
			String type);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:getFileByDate
	 * @Description:根据前一天 查询通话记录文件
	 * @Param:@param qm
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年9月2日 上午11:19:33
	 */
	public List<CallInformation> getFileByDate(CallInformationQueryModel qm);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:queryPageExport
	 * @Description:通话记录查询
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:Pagination
	 * @Creatime:2016年9月6日 下午2:37:03
	 */
	public Pagination queryPageExport(CallInformationQueryModel queryModel);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:listExport
	 * @Description:导出用
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年9月6日 下午4:17:42
	 */
	public List<CallInformation> listExport(CallInformationQueryModel queryModel);

	/**
	 * 
	 * @Author:hantianyu
	 * @Title:backupCallInfo
	 * @Description:查询没有备份过的数据
	 * @Param:@param queryModel
	 * @Param:@return
	 * @Return:List<CallInformation>
	 * @Creatime:2016年11月21日 上午9:23:11
	 */
	public List<CallInformation> backupCallInfo(
			CallInformationQueryModel queryModel);



	/**
	 * 查询统计
	 * 
	 * @author 韩天驭
	 * @2017年1月9日 下午2:28:51
	 * @param qm
	 *            call model层
	 * @return Map<Integer,List<String>>
	 */
	public Map<String, List<String>> CountTimes(CallInformationQueryModel qm);
}
