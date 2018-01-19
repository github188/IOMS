package cn.com.atnc.ioms.util;

import java.io.*;

import java.util.*;

import org.activiti.bpmn.model.BpmnModel;
import org.activiti.engine.impl.bpmn.diagram.*;
import org.activiti.engine.impl.cmd.*;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.ExecutionEntityManager;
/**
 * 类说明:生成流程图和流向图
 * @author WhiteYj
 * @date 2014-05-13 1415
 */
public class ProcessInstanceDiagramCmd implements Command<InputStream> {
    protected String processInstanceId;

    public ProcessInstanceDiagramCmd(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
    // 调用activiti的cmd命令,用于生成及时的流程图流向 具体生成参照newsController下的graph方法
    public InputStream execute(CommandContext commandContext) {
        ExecutionEntityManager executionEntityManager = commandContext.getExecutionEntityManager();
        ExecutionEntity executionEntity = executionEntityManager.findExecutionById(processInstanceId);
        List<String> activiityIds = executionEntity.findActiveActivityIds();
        String processDefinitionId = executionEntity.getProcessDefinitionId();

        GetBpmnModelCmd getBpmnModelCmd = new GetBpmnModelCmd(processDefinitionId);
        BpmnModel bpmnModel = getBpmnModelCmd.execute(commandContext);

        InputStream is = ProcessDiagramGenerator.generateDiagram(bpmnModel, "png", activiityIds);

        return is;
    }
}
