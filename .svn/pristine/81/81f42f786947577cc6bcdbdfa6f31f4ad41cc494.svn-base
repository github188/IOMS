package cn.com.atnc.ioms.mng.phonemng.servletdemo;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.atnc.ioms.dao.phonemng.IAgentInfoDao;
import cn.com.atnc.ioms.dao.phonemng.ICallInfoDao;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.enums.phonemng.CallIsDel;
import cn.com.atnc.ioms.enums.phonemng.CallStateEnum;
import cn.com.atnc.ioms.enums.phonemng.CallTypeEnum;
import cn.com.atnc.ioms.model.phonemng.AgentQueryModel;

/**
 * 
 * @author hantianyu
 * @creatime 2016-8-18下午5:50:52 TODO
 */
@Component
public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = -625457173468419476L;

	@Autowired
	private ICallInfoDao callInfoDao;
	@Autowired
	private IAgentInfoDao agentInfoDao;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletConfig.getServletContext());

		callInfoDao = (ICallInfoDao) webApplicationContext
				.getBean("ICallInfoDao");
		agentInfoDao = (IAgentInfoDao) webApplicationContext
				.getBean("IAgentInfoDao");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		SimpleDateFormat ringDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat beginDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String cityname = "";
		String provincename = "";
		if (request != null) {

			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 北京容联

			CallInformation callInfo = new CallInformation();
			// 初始化实体
			callInfo.setIsDel(CallIsDel.NOTDEL);
			// 判断
			if (request.getParameter("CalledNo") != null) {
				callInfo.setCalledNumber(request.getParameter("CalledNo"));
			} else {
				callInfo.setCalledNumber("");
			}

			if (request.getParameter("CallNo") != null) {
				callInfo.setCallonNumber(request.getParameter("CallNo"));
			} else {
				callInfo.setCallonNumber("");
			}

			// 省市
			try {
				// 转换字符串
				// 判断参数是否为空
				if (request.getParameter("District") != null
						&& request.getParameter("Province") != null) {
					cityname = new String(request.getParameter("District")
							.getBytes("ISO-8859-1"), "utf-8");
					provincename = new String(request.getParameter("Province")
							.getBytes("ISO-8859-1"), "utf-8");
				} else {
					cityname = "";
					provincename = "";
				}

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			callInfo.setCallonCity(cityname);
			callInfo.setCallonProvince(provincename);
			//
			if (request.getParameter("CallSheetID") != null) {
				callInfo.setCallSheetId(request.getParameter("CallSheetID"));
			} else {
				callInfo.setCallSheetId("");
			}
			if (request.getParameter("State") != null) {
				String callstatus = request.getParameter("State");
				// 接听状态
				if (!StringUtils.isEmpty(callstatus)) {
					// 转换成大写 获取对应的枚举
					CallStateEnum callStateEnum = CallStateEnum
							.valueOf(callstatus.toUpperCase());
					callInfo.setCallState(callStateEnum);
				}
			}

			// 文件服务器地址
			if (request.getParameter("FileServer") != null) {
				callInfo.setFileServer(request.getParameter("FileServer"));
			} else {
				callInfo.setFileServer("");
			}
			// 录音文件地址
			if (request.getParameter("RecordFile") != null) {
				callInfo.setRecordFileName(request.getParameter("RecordFile"));
			} else {
				callInfo.setRecordFileName("");
			}

			if (request.getParameter("Agent") != null) {
				callInfo.setStationNumber(request.getParameter("Agent"));
			} else {
				callInfo.setStationNumber("");
			}

			double number = 0.00;
			callInfo.setCallDuration(number);

			// 通话类型
			String callType = "";
			if (request.getParameter("CallType") != null) {
				callType = request.getParameter("CallType");
				if (!StringUtils.isEmpty(callType)) {
					CallTypeEnum callTypeEnum = CallTypeEnum.valueOf(callType
							.toUpperCase());
					callInfo.setCallType(callTypeEnum);
				}
			}
			// 响铃时间
			if (request.getParameter("Ring") != null
					&& request.getParameter("End") != null
					&& request.getParameter("Begin") != null) {

				String ringTime = request.getParameter("Ring");
				String endTime = request.getParameter("End");
				String beginTime = request.getParameter("Begin");

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
						// 通话类型不为空
						if (callType != "") {
							if (callType.equals(CallTypeEnum.TRANSFER)
									|| callType
											.equals(CallTypeEnum.DIALTRANSFER)) {
								endTime = endTime.replace("%20", " ");
							}
							callInfo.setCallendTime(endDate.parse(endTime));
						}

					}
					// 未接来电没有开始时间
					if (!StringUtils.isEmpty(beginTime)) {
						// 通话类型不为空
						if (callType != "") {
							if (callType.equals(CallTypeEnum.TRANSFER)
									|| callType
											.equals(CallTypeEnum.DIALTRANSFER)) {
								beginTime = beginTime.replace("%20", " ");
							}
							if (!beginTime.equals("undefined")) {

								// 非未接
								callInfo.setPickupTime(beginDate
										.parse(beginTime));

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

					}

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			try {
				System.err.println(callInfo);
				// 根据坐席号获取 在岗工程师 start
				AgentQueryModel qm = new AgentQueryModel();
				if (request.getParameter("Agent") != null) {
					// 坐席号不为空
					qm.setAgentinfo(request.getParameter("Agent"));
					// 获取工程师信息
					List<AgentInformation> agentlist = agentInfoDao
							.viewAgentInfoByNumber(qm);
					if (agentlist.size() > 0) {
						// 工程师信息>0
						callInfo.setUserName(agentlist.get(0).getUsername());
					}
				} else {
					callInfo.setUserName("");
				}

				// end
				callInfoDao.save(callInfo);
			} catch (NullPointerException e) {
				System.err.println("发生异常的原因为 :" + e.getMessage());
			}
		}
	}
}
