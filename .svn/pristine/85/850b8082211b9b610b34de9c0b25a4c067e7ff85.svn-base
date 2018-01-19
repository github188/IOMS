package cn.com.atnc.ioms.mng.phonemng.servletdemo;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.com.atnc.ioms.dao.phonemng.IAgentInfoDao;
import cn.com.atnc.ioms.dao.phonemng.ICallAgentMngDao;
import cn.com.atnc.ioms.dao.phonemng.ICallInfoDao;
import cn.com.atnc.ioms.entity.phonemng.AgentInformation;
import cn.com.atnc.ioms.entity.phonemng.CallAgentMng;
import cn.com.atnc.ioms.model.phonemng.AgentQueryModel;

public class AgentReceiveServlet extends HttpServlet {

	private static final long serialVersionUID = -625457173468419476L;
	@Autowired
	private ICallAgentMngDao callAgentMngDao;
	@Autowired
	private IAgentInfoDao agentInfoDao;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		WebApplicationContext webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(servletConfig.getServletContext());

		callAgentMngDao = (ICallAgentMngDao) webApplicationContext
				.getBean("ICallAgentMngDao");
		agentInfoDao = (IAgentInfoDao) webApplicationContext
				.getBean("IAgentInfoDao");

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat timeDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (request != null) {

			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			CallAgentMng callAgentMng = new CallAgentMng();

			if (request.getParameter("BusyType") != null) {
				callAgentMng.setBusyType(request.getParameter("BusyType"));
			}
			if (request.getParameter("Type") != null) {
				callAgentMng.setEventState(request.getParameter("Type"));
			}
			if (request.getParameter("Exten") != null) {
				callAgentMng.setExten(request.getParameter("Exten"));
			}
			if (request.getParameter("ExtenType") != null) {
				callAgentMng.setExtenType(request.getParameter("ExtenType"));
			}
			if (request.getParameter("State") != null) {
				callAgentMng.setEventType(request.getParameter("State"));
			}
			if (request.getParameter("Time") != null) {
				String nowTime = request.getParameter("Time");
				try {
					if (!StringUtils.isEmpty(nowTime)) {
						callAgentMng.setNowTime(timeDate.parse(nowTime));
					}
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (request.getParameter("Agent") != null) {
				callAgentMng.setAgent(request.getParameter("Agent"));

				// callAgentMng.setUserName(userName);
				try {
					System.err.println(callAgentMng);
					// 根据坐席号获取 在岗工程师 start
					AgentQueryModel qm = new AgentQueryModel();
					qm.setAgentinfo(request.getParameter("Agent"));
					List<AgentInformation> agentlist = agentInfoDao
							.viewAgentInfoByNumber(qm);
					if (agentlist.size() > 0) {
						callAgentMng
								.setUserName(agentlist.get(0).getUsername());
					}
					// end
					callAgentMngDao.save(callAgentMng);
				} catch (NullPointerException e) {
					System.err.println("发生异常的原因为 :" + e.getMessage());
				}
			}

		}
	}
}
