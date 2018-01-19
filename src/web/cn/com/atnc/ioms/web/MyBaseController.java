/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午4:15:06
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.TaskService;
import org.activiti.engine.impl.cmd.GetDeploymentProcessDiagramCmd;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.task.Task;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.util.WebUtils;

import cn.com.atnc.common.model.SessionNames;
import cn.com.atnc.common.util.AssertUtil;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.ioms.entity.acl.Resource;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.clientmng.Client;
import cn.com.atnc.ioms.entity.clientmng.ClientOptLog;
import cn.com.atnc.ioms.entity.systemmng.userlog.UserLog;
import cn.com.atnc.ioms.enums.clientmng.ClientOptEnum;
import cn.com.atnc.ioms.enums.clientmng.CsUserStatusEnum;
import cn.com.atnc.ioms.mng.acl.IResourceManager;
import cn.com.atnc.ioms.mng.clientmng.IClientOptLogService;
import cn.com.atnc.ioms.mng.systemmng.userlog.IUserLogManager;
import cn.com.atnc.ioms.util.ProcessInstanceDiagramCmd;

/**
 * 基础控制器类
 * 
 * @author:huangyijie
 * @date:2013-9-2 下午4:15:06
 */

public class MyBaseController {

    protected static final String RETURNNOTE = "returnnote";
    protected static final String RETURNSTR = "returnStr";
    protected static final String GBK = "GBK";
    protected static final String UTF8 = "UTF-8";
    protected static final String ISO8859 = "ISO8859-1";
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    protected IUserLogManager userLogManager;
    @Autowired
    protected IClientOptLogService clientOptLogService;
    @Autowired
    protected IResourceManager resourceManager;

    @javax.annotation.Resource(name = "taskService")
    protected TaskService taskService;

    @Autowired
    private ProcessEngineFactoryBean processEngineFactoryBean;
    
    protected static String iso2UTF8(String str)
            throws UnsupportedEncodingException {
        return StringTools.getStringUTF8(str);
    }

    /**
     * 添加，修改，删除等操作完成成功后，返回页面操作成功的信息 写在父类的原因是，<BR>
     * manage的jquery插件目前需要使用此固定名称进行处理
     * 
     * @param model
     * @param message
     *            页面显示的成功信息
     */
    protected void addSuccess(Model model, String message) {
        model.addAttribute("my_result", "my_success");
        model.addAttribute("my_message", message);
    }

    /**
     * 添加，修改，删除等操作完成成功后，返回页面操作失败的信息 写在父类的原因是，<BR>
     * manage的jquery插件目前需要使用此固定名称进行处理
     * 
     * @param model
     * @param error
     *            失败的原因
     */
    protected void addError(Model model, String error) {
        model.addAttribute("my_result", "my_error");
        model.addAttribute("my_message", error);
    }

    /**
     * 用于菜单定位
     * 
     * @author:HuangYijie
     * @Date:2011-10-12 上午10:55:07
     * 
     * @param model
     * @param request
     *            void
     */
    protected void pageInfo(Model model, HttpServletRequest request) {
        Resource resource = resourceManager.getColumnResourceByUrl(request
                .getRequestURI());

        if (resource != null) {
            try {
                logger.debug("pageMode:{}", resource.toJson());
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            model.addAttribute("menuId",
                    StringTools.hasText(resource.getPid()) ? resource.getPid()
                            : resource.getId());
            model.addAttribute("columnId", resource.getId());
        } else {
            logger.error(request.getRequestURI() + " has no record!");
        }

    }

    protected User getCurrentUser(HttpServletRequest request) {
        return (User) WebUtils.getSessionAttribute(request,
                SessionNames.LOGIN_USER);

    }
    protected void addClientOptLog(Client client,ClientOptEnum opt,CsUserStatusEnum fromStatus,CsUserStatusEnum toStatus,String userName ){
        ClientOptLog log=new ClientOptLog();
        log.setClient(client);
        log.setClientOpt(opt);
        log.setFromStatus(fromStatus);
        log.setToStatus(toStatus);
        log.setOptTime(Calendar.getInstance());
        log.setOptName(userName);
        this.clientOptLogService.add(log);
    }
    protected void addLog(HttpServletRequest request, String info) {
        UserLog log = new UserLog();
        Resource resource = resourceManager.getColumnResourceByUrl(request
                .getRequestURI());
        if (resource != null) {
            switch (resource.getType()) {
            case MENU:
                log.setMenu(resource.getName());
                log.setOptType(resource.getName());
                log.setSubMenu(resource.getName());
                break;
            case COLUMN:
                log.setOptType(resource.getName());
                log.setSubMenu(resource.getName());
                Resource parent = resourceManager.getParentByUrl(request
                        .getRequestURI());
                log.setMenu(parent == null ? "" : parent.getName());
                break;
            case URL:
                log.setOptType(resource.getName());
                Resource urlParent = resourceManager.getParentByUrl(request
                        .getRequestURI());
                log.setSubMenu(urlParent == null ? "" : urlParent.getName());
                Resource urlGrandpa = resourceManager.getGrandpaByUrl(request
                        .getRequestURI());
                log.setMenu(urlGrandpa == null ? "" : urlGrandpa.getName());
                break;
            default:
                break;
            }
        }
        log.setUser(getCurrentUser(request));
        log.setOptTime(new Date());
        log.setInfo(info);
        log.setIp(request.getRemoteAddr());
        userLogManager.saveOrUpdate(log);
    }

    protected InputStream graph(String proInsId) throws Exception {
        processEngineFactoryBean.getProcessEngineConfiguration().setActivityFontName("微软雅黑");
        processEngineFactoryBean.getProcessEngineConfiguration().setLabelFontName("微软雅黑");
        Context.setProcessEngineConfiguration(processEngineFactoryBean.getProcessEngineConfiguration());
        Task taskbean = taskService.createTaskQuery()
                .processInstanceId(proInsId).list().get(0);
        String processDefinitionId = taskbean.getProcessDefinitionId();
        String processInstanceId = taskbean.getProcessInstanceId();
        String taskId = taskbean.getId();
        // RepositoryService repositoryService =
        // processEngine.getRepositoryService();
        Command<InputStream> cmd = null;
        if (processDefinitionId != null) {
            cmd = new GetDeploymentProcessDiagramCmd(processDefinitionId);
        }
        if (processInstanceId != null) {
            cmd = new ProcessInstanceDiagramCmd(processInstanceId);
        }
        if (taskId != null) {
            Task task = processEngineFactoryBean.getObject().getTaskService().createTaskQuery()
                    .taskId(taskId).singleResult();
            cmd = new ProcessInstanceDiagramCmd(task.getProcessInstanceId());
        }
        if (cmd != null) {
            return processEngineFactoryBean.getObject().getManagementService().executeCommand(cmd);
        }
        return null;
    }
    
    protected void doDownLoad(final HttpServletRequest request,
			final HttpServletResponse response, final InputStream stream,
			String displayName) throws IOException {
		AssertUtil.notNull(stream, "被下载的文件流不能为空");
		AssertUtil.hasText(displayName, "显示名称必须指定");
		String ua = request.getHeader("user-agent"); // 获取终端类型
		if (ua == null)
			ua = " User-Agent: Mozilla/4.0 (compatible; MSIE 6.0;) ";
		boolean isIE = ua.toLowerCase().indexOf(" msie ") != -1;
		response.reset();
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("application/octet-stream;charset=ISO8859-1");
		if (isIE)
			response.setContentType("application/x-download");// 设置为下载application/x-download
		// 解决中文乱码
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String(displayName.getBytes(GBK), ISO8859));

		OutputStream output = null;
		InputStream fis = null;
		try {
			output = response.getOutputStream();
			fis = stream;
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = fis.read(b)) > 0) {
				output.write(b, 0, i);
			}
			output.flush();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (fis != null) {
				fis.close();
				fis = null;
			}
			if (output != null) {
				output.close();
				output = null;
			}
		}
	}
    
    protected void doDownLoad(final HttpServletRequest request,final HttpServletResponse response, 
    		byte[] data, String fileName) throws IOException {
    	ServletOutputStream outputStream = null;
    	try {
	    	int length = data.length;
			response.setContentType("application/octet-stream");
			response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(GBK), ISO8859));
			response.setContentLength(length);
			outputStream = response.getOutputStream();
			outputStream.write(data, 0, length);
			outputStream.flush();
    	} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (outputStream != null) {
				outputStream.close();
				outputStream = null;
			}
		}
    }
}
