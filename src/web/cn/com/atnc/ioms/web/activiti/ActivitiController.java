package cn.com.atnc.ioms.web.activiti;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.bpmn.diagram.ProcessDiagramGenerator;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.spring.ProcessEngineFactoryBean;
import org.apache.commons.io.FilenameUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.ObjectNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.atnc.ioms.mng.activiti.WorkflowProcessDefinitionService;
import cn.com.atnc.ioms.mng.activiti.WorkflowTraceService;
import cn.com.atnc.ioms.util.WorkflowUtils;

/**
 * 
 * @author: 局域网_王鹏
 * @time: 2014年4月18日下午7:14:12
 * @version:1.0
 */
@Controller
@RequestMapping(value = "/workflow/")
public class ActivitiController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	protected WorkflowProcessDefinitionService workflowProcessDefinitionService;
	@Autowired
	protected RepositoryService repositoryService;
	@Autowired
	protected RuntimeService runtimeService;
	@Autowired
	protected TaskService taskService;
	@Autowired
	protected WorkflowTraceService traceService;
	@Autowired
	ProcessEngineFactoryBean processEngine;
	protected static Map<String, ProcessDefinition> PROCESS_DEFINITION_CACHE = new HashMap<String, ProcessDefinition>();

	/**
	 * 读取资源，通过部署ID
	 * 
	 * @param processDefinitionId
	 *            流程定义
	 * @param resourceType
	 *            资源类型(xml|image)
	 * @throws Exception
	 */
	@RequestMapping(value = "resource/read.do")
	public void loadByDeployment(
			@RequestParam("processDefinitionId") String processDefinitionId,
			@RequestParam("resourceType") String resourceType,
			HttpServletResponse response) throws Exception {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		String resourceName = "";
		if (resourceType.equals("image")) {
			resourceName = processDefinition.getDiagramResourceName();
		} else if (resourceType.equals("xml")) {
			resourceName = processDefinition.getResourceName();
		}
		InputStream resourceAsStream = repositoryService.getResourceAsStream(
				processDefinition.getDeploymentId(), resourceName);
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	/**
	 * 读取资源，通过流程ID
	 * 
	 * @param resourceType
	 *            资源类型(xml|image)
	 * @param processInstanceId
	 *            流程实例ID
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "resource/process-instance.dox")
	public void loadByProcessInstance(
			@RequestParam("type") String resourceType,
			@RequestParam("pid") String processInstanceId,
			HttpServletResponse response) throws Exception {
		InputStream resourceAsStream = null;
		ProcessInstance processInstance = runtimeService
				.createProcessInstanceQuery()
				.processInstanceId(processInstanceId).singleResult();
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processInstance.getProcessDefinitionId())
				.singleResult();
		logger.debug("getDiagramResourceName:"
				+ processDefinition.getDiagramResourceName());
		logger.debug("processDefinition:" + processDefinition.getCategory());
		logger.debug("getDescription:" + processDefinition.getDescription());
		logger.debug("getKey:" + processDefinition.getKey());
		logger.debug("getResourceName:" + processDefinition.getResourceName());
		logger.debug("getName:" + processDefinition.getName());

		String resourceName = "";
		if (resourceType.equals("image")) {
			resourceName = processDefinition.getDiagramResourceName();
		} else if (resourceType.equals("xml")) {
			resourceName = processDefinition.getResourceName();
		}
		resourceAsStream = repositoryService.getResourceAsStream(
				processDefinition.getDeploymentId(), resourceName);
		byte[] b = new byte[1024];
		int len = -1;
		while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	/**
	 * 删除部署的流程，级联删除流程实例
	 * 
	 * @param deploymentId
	 *            流程部署ID
	 */
	@RequestMapping(value = "process/delete.do")
	public String delete(@RequestParam("deploymentId") String deploymentId) {
		repositoryService.deleteDeployment(deploymentId, true);
		return "redirect:/workflow/process-list";
	}

	/**
	 * 输出跟踪流程信息
	 * 
	 * @param processInstanceId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/process/trace.dox")
	@ResponseBody
	public List<Map<String, Object>> traceProcess(
			@RequestParam("pid") String processInstanceId) throws Exception {
		List<Map<String, Object>> activityInfos = traceService
				.traceProcess(processInstanceId);
		return activityInfos;
	}

	// @RequestMapping(value = "/process/trace.do")
	// public String traceProcess(
	// @RequestParam("pid") String
	// processInstanceId,org.springframework.ui.Model model ) throws Exception {
	// List<Map<String, Object>> activityInfos = traceService
	// .traceProcess(processInstanceId);
	// model.addAttribute("returnStr", activityInfos);
	// return "returnnote";
	// }

	/**
	 * 读取带跟踪的图片
	 */
	@RequestMapping(value = "/process/trace/auto.do")
	public void readResource(@RequestParam("executionId") String executionId,
			HttpServletResponse response) throws Exception {
		ProcessInstance processInstance = runtimeService
				.createProcessInstanceQuery().processInstanceId(executionId)
				.singleResult();
		BpmnModel bpmnModel = repositoryService.getBpmnModel(processInstance
				.getProcessDefinitionId());
		List<String> activeActivityIds = runtimeService
				.getActiveActivityIds(executionId);
		logger.debug("processInstance:" + processInstance.getActivityId());
		logger.debug("bpmnModel:" + bpmnModel.getMainProcess().getId());
		logger.debug("activeActivityIds:" + activeActivityIds.get(0));
		// 不使用spring请使用下面的两行代码
		// ProcessEngineImpl defaultProcessEngine = (ProcessEngineImpl)
		// ProcessEngines.getDefaultProcessEngine();
		// Context.setProcessEngineConfiguration(defaultProcessEngine.getProcessEngineConfiguration());

		// 使用spring注入引擎请使用下面的这行代码
		Context.setProcessEngineConfiguration(processEngine
				.getProcessEngineConfiguration());

		InputStream imageStream = ProcessDiagramGenerator.generateDiagram(
				bpmnModel, "png", activeActivityIds);

		// 输出资源内容到相应对象
		byte[] b = new byte[1024];
		int len;
		while ((len = imageStream.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}

	@RequestMapping(value = "deploy.do")
	public String deploy(
			@Value("#{APP_PROPERTIES['export.diagram.path']}") String exportDir,
			@RequestParam(value = "file", required = false) MultipartFile file) {

		String fileName = file.getOriginalFilename();

		try {
			InputStream fileInputStream = file.getInputStream();
			Deployment deployment = null;

			String extension = FilenameUtils.getExtension(fileName);
			if (extension.equals("zip") || extension.equals("bar")) {
				ZipInputStream zip = new ZipInputStream(fileInputStream);
				deployment = repositoryService.createDeployment()
						.addZipInputStream(zip).deploy();
			} else {
				deployment = repositoryService.createDeployment()
						.addInputStream(fileName, fileInputStream).deploy();
			}

			List<ProcessDefinition> list = repositoryService
					.createProcessDefinitionQuery()
					.deploymentId(deployment.getId()).list();

			for (ProcessDefinition processDefinition : list) {
				WorkflowUtils.exportDiagramToFile(repositoryService,
						processDefinition, exportDir);
			}

		} catch (Exception e) {
			logger.error(
					"error on deploy process, because of file input stream", e);
		}

		return "redirect:/workflow/process-list";
	}

	@RequestMapping(value = "process/convert-to-model/{processDefinitionId}")
	public String convertToModel(
			@PathVariable("processDefinitionId") String processDefinitionId)
			throws UnsupportedEncodingException, XMLStreamException {
		ProcessDefinition processDefinition = repositoryService
				.createProcessDefinitionQuery()
				.processDefinitionId(processDefinitionId).singleResult();
		InputStream bpmnStream = repositoryService.getResourceAsStream(
				processDefinition.getDeploymentId(),
				processDefinition.getResourceName());
		XMLInputFactory xif = XMLInputFactory.newInstance();
		InputStreamReader in = new InputStreamReader(bpmnStream, "UTF-8");
		XMLStreamReader xtr = xif.createXMLStreamReader(in);
		BpmnModel bpmnModel = new BpmnXMLConverter().convertToBpmnModel(xtr);

		BpmnJsonConverter converter = new BpmnJsonConverter();
		ObjectNode modelNode = converter.convertToJson(bpmnModel);
		Model modelData = repositoryService.newModel();
		modelData.setKey(processDefinition.getKey());
		modelData.setName(processDefinition.getResourceName());
		modelData.setCategory(processDefinition.getDeploymentId());

		ObjectNode modelObjectNode = new ObjectMapper().createObjectNode();
		modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME,
				processDefinition.getName());
		modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, 1);
		modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION,
				processDefinition.getDescription());
		modelData.setMetaInfo(modelObjectNode.toString());

		repositoryService.saveModel(modelData);

		repositoryService.addModelEditorSource(modelData.getId(), modelNode
				.toString().getBytes("utf-8"));

		return "redirect:/workflow/model/list";
	}

	/**
	 * 导出图片文件到硬盘
	 * 
	 * @return
	 */
	@RequestMapping(value = "export/diagrams")
	@ResponseBody
	public List<String> exportDiagrams(
			@Value("#{APP_PROPERTIES['export.diagram.path']}") String exportDir)
			throws IOException {
		List<String> files = new ArrayList<String>();
		List<ProcessDefinition> list = repositoryService
				.createProcessDefinitionQuery().list();

		for (ProcessDefinition processDefinition : list) {
			files.add(WorkflowUtils.exportDiagramToFile(repositoryService,
					processDefinition, exportDir));
		}

		return files;
	}
}