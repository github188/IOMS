/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-16 下午6:54:09
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.dataprocess.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.mng.dataprocess.IDataParser;
import cn.com.atnc.ioms.mng.dataprocess.IDataProcessor;
import cn.com.atnc.ioms.mng.maintain.alarminfo.ILinkAlarmMonitorManager;
import cn.com.atnc.ioms.mng.maintain.alarminfo.IStatusAlarmMonitorManager;
import cn.com.atnc.ioms.util.ftp.IFtpClientService;

/**
 * @author KuYonggang
 * @date 2015年4月1日 上午11:11:53
 * @since 1.0.0
 */
@Service("dataProcessor")
public class DataProcessorImpl extends AbstractService implements
		IDataProcessor {

	@Value("#{ftpProperties.ftpIp}")
	private String ftpIp;
	@Value("#{ftpProperties.ftpPort}")
	private String ftpPort;
	@Value("#{ftpProperties.ftpUser}")
	private String ftpUser;
	@Value("#{ftpProperties.ftpPsw}")
	private String ftpPsw;
	@Value("#{ftpProperties.encode}")
	private String encode;
	@Value("#{ftpProperties.liveCheckInterval}")
	private String liveCheckInterval;
	@Value("#{ftpProperties.path}")
	private String path;

	@Autowired
	@Qualifier(value = "myExecutor")
	private TaskExecutor excutor;

	@Autowired
	@Qualifier(value = "ftpClientService")
	private IFtpClientService client;

	@Autowired
	private IDataParser parser;
	@Autowired
	private IStatusAlarmMonitorManager statusAlarmMonitorManager;
	@Autowired
	private ILinkAlarmMonitorManager linkAlarmMonitorManager;

	@PostConstruct
	public void init() throws Exception {
		client.start();
	}

	@PreDestroy
	public void destroy() throws Exception {
		Thread.yield();
		client.stop();
	}

	@Override
	/*@Scheduled(cron = "0 0/1 * * * ?")*/
	public void handler() throws IOException {
		logger.info("************ftp check every minute1234****************");
		FTPFile[] firstFiles = client.listFiles("/"); // 查找根目录下的所有文件
		logger.info("根目录下的所有文件个数：" + firstFiles.length);
		if (firstFiles == null || firstFiles.length < 1) {
			logger.info("************ftp check no file****************");
			return;
		}
		for (final FTPFile file : firstFiles) {
			if (file.isDirectory()) {// 如果是目录
				final String directoryName = file.getName();
				logger.info("directoryName:" + directoryName);
				FTPFile[] secondFiles = client.listFiles("/" + directoryName);
				if (secondFiles == null || secondFiles.length < 1) {
					logger.info("************ftp check no file****************directoryName:"
							+ directoryName);
					continue;
				}
				for (final FTPFile ftpFile : secondFiles) {
					if (ftpFile.isDirectory()) {
						continue; // 如果是目录的话跳过
					} else {
						logger.info("************ftp check file:" + ftpFile.getName());
						try {
							jsonParse(readFile(ftpFile, directoryName),
									ftpFile.getName());
						} catch (ServiceException e1) {
							logger.error(e1.getMessage());
							//如果解析出现异常则删除下载到本地的文件，但需要保留FTP服务器上面未解析成功的文件
							File tempfile = new File(ProjectFilePath.getTmpPath() + ftpFile.getName());
							if(tempfile.exists()){
								tempfile.delete();
							}
							continue;
						}
						// 多线程处理
						excutor.execute(new Runnable() {
							@Override
							public void run() {
								try {
									// 解析完成后删除本地文件
									while(true){
										boolean delLocal = new File(ProjectFilePath.getTmpPath() + ftpFile.getName()).delete();
										if(delLocal){
											break;
										}
										Thread.sleep(1000);
									}
									// 解析完成后删除服务器端的文件
									while (true) {
										boolean delServer = client.deleteFile(client.printWorkingDirectory() + directoryName + "/" + ftpFile.getName());
										if (delServer) {
											break;
										}
										Thread.sleep(1000);
									}
								} catch (IOException | InterruptedException e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
			} else {
				continue;// 如果是文件的话跳过
			}
		}
		//更新状态告警监控信息
		statusAlarmMonitorManager.updateStatusAlarmState();
		//更新链路告警监控信息
		linkAlarmMonitorManager.updateLinkAlarmState();
	}

	/**
	 * 从FTP服务器上读取指定文件的内容，返回不含回车tab的字符串
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-17 上午10:16:51
	 * @param file
	 *            指定ftp文件
	 * @return
	 * @throws IOException
	 *             String 不含回车tab的字符串
	 */
	private String readFile(FTPFile file, String directoryName)
			throws IOException {

		boolean downloadStatus = client.downFile(client.printWorkingDirectory()
				+ directoryName + "/" + file.getName(),
				ProjectFilePath.getTmpPath() + file.getName());

		if (!downloadStatus) {
			throw new IOException(file.getName() + "下载失败");
		}
		File tempFile = new File(ProjectFilePath.getTmpPath() + file.getName());

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(tempFile), "UTF-8"));
			StringBuilder jsonTemp = new StringBuilder();
			String lineStr = "";
			while (StringTools.hasText(lineStr = reader.readLine())) {
				jsonTemp.append(lineStr.replace("\\n\\r", ""));
			}
			return jsonTemp.toString();
		} finally {
			reader.close();
		}
	}

	/**
	 * 解析字符串，根据不同类型处理入库
	 * 
	 * @author:ku
	 * @Date:2014-4-17 上午10:17:41
	 * @throws ServiceException
	 */
	@Transactional
	public void jsonParse(String str, String fileName) throws ServiceException {
		// 解析出文件名中包含的FTP类别信息：
		// WAFR08Port0Stat、KuAnacomOdu、KuCarrierFrequencies
		// KuNodeInfo、KuNodeParameters、STATUSWARN、LINKWARN
		int index = fileName.indexOf(".txt");
		if (index < 0) {
			throw new ServiceException("不是有效的txt文件:" + fileName);
		}
		String nameStr = fileName.substring(0, index);
		String[] infoArr = StringUtils.tokenizeToStringArray(nameStr,"_");//根据“_”分隔文件名
		//String nodeName = infoArr[0];
		//String nodeIp = infoArr[1];
		String type = infoArr[3];	//FTP文件类别信息
		if (!StringTools.hasText(type) || !StringTools.hasText(str)) {
			return;
		}
		//文件类别为“WAFR08Port0Stat”、“KuNodeParameters”和“KuAnacomOdu”，因为这几种类型文件内容格式相同所以放在一起进行解析
		if (type.equals("WAFR08Port0Stat") || type.equals("KuNodeParameters")
				|| type.equals("KuAnacomOdu")) {
			//文件内容格式验证
			String typeStr = "Type\":\"";
			int beg = str.indexOf(typeStr);
			if (beg < 0) {
				throw new ServiceException("Json数据格式不正确,无type:" + str);
			}
			int end = str.indexOf("\"", beg + typeStr.length());
			if (end < 0) {
				throw new ServiceException("Json数据格式不正确，无\\:" + str);
			}
			//解析出文件内容中包含的类型信息
			String innerType = str.substring(beg + typeStr.length(), end);
			int infoBeg = str.indexOf("{", 2);
			if (infoBeg < 0) {
				throw new ServiceException("Json数据格式不正确,无{:" + str);
			}
			int infoEnd = str.lastIndexOf("}");
			if (infoEnd < 0) {
				throw new ServiceException("Json数据格式不正确,无}:" + str);
			}
			//解析出文件内容
			String infoStr = str.substring(infoBeg, infoEnd);
			logger.info("innerType:" + innerType + " infoStr:" + infoStr);
			if (!StringTools.hasText(innerType) || !StringTools.hasText(infoStr)) {
				return;
			}
			// ku节点参数
			if (innerType.equals("KuNodeParameters")) {
				parser.parseKuNodeParameter(infoStr, fileName);
			}
			// wafr08设备轮询信息
			if (innerType.equals("WAFR08Port0Stat")) {
				parser.parseWafr08Port0Stat(infoStr, fileName);
			}
			//odu轮询信息
			if (innerType.equals("KuAnacomOdu")) {
				parser.parseOduPolling(infoStr, fileName);
			}
		}
		//文件类别为“KuCarrierFrequencies”和“KuNodeInfo”，因为这几种类型文件内容格式相同所以放在一起进行解析
		if (type.equals("KuCarrierFrequencies") || type.equals("KuNodeInfo")) {
			//文件内容格式验证
			String typeStr = "Type\":\"";
			int beg = str.indexOf(typeStr);
			if (beg < 0) {
				throw new ServiceException("Json数据格式不正确,无type:" + str);
			}
			int end = str.indexOf("\"", beg + typeStr.length());
			if (end < 0) {
				throw new ServiceException("Json数据格式不正确，无\\:" + str);
			}
			//解析出文件内容中包含的类型信息
			String innerType = str.substring(beg + typeStr.length(), end);
			int infoBeg = str.indexOf("[", 1);
			if (infoBeg < 0) {
				throw new ServiceException("Json数据格式不正确,无[:" + str);
			}
			int infoEnd = str.lastIndexOf("]");
			if (infoEnd < 0) {
				throw new ServiceException("Json数据格式不正确,无]:" + str);
			}
			//解析出文件内容
			String infoStr = str.substring(infoBeg, infoEnd+1);
			logger.info("innerType:" + innerType + " infoStr:" + infoStr);
			if (!StringTools.hasText(innerType) || !StringTools.hasText(infoStr)) {
				return;
			}
			// ku载波频率
			if (innerType.equals("KuCarrierFrequencies")) {
				parser.parseKuCarrierFreq(infoStr, fileName);
			}
			// ku节点信息
			if (innerType.equals("KuNodeInfo")) {
				parser.parseKuNodeInfo(infoStr, fileName);
			}
		}
		// 状态告警
		if (type.equals("STATUSWARN")) {
			int infoBeg = str.indexOf("{");
			if (infoBeg < 0) {
				throw new ServiceException("Json数据格式不正确:" + str);
			}
			int infoEnd = str.lastIndexOf("}");
			if (infoEnd < 0) {
				throw new ServiceException("Json数据格式不正确:" + str);
			}
			//解析出状态告警中的内容
			String infoStr = str.substring(infoBeg, infoEnd + 1);
			parser.parseStatusWarn(infoStr, fileName);
		}
		// 链路告警
		if (type.equals("LINKWARN")) {
			int infoBeg = str.indexOf("{");
			if (infoBeg < 0) {
				throw new ServiceException("Json数据格式不正确:" + str);
			}
			int infoEnd = str.lastIndexOf("}");
			if (infoEnd < 0) {
				throw new ServiceException("Json数据格式不正确:" + str);
			}
			//解析出链路告警中的内容
			String infoStr = str.substring(infoBeg, infoEnd + 1);
			parser.parseLinkedWarn(infoStr, fileName);
		}
		//ftp心跳检测文件
		if(type.equals("FTPLINK")){
			int infoBeg = str.indexOf("{");
			if (infoBeg < 0) {
				throw new ServiceException("Json数据格式不正确:" + str);
			}
			int infoEnd = str.lastIndexOf("}");
			if (infoEnd < 0) {
				throw new ServiceException("Json数据格式不正确:" + str);
			}
			//解析FTP心跳文件
			String infoStr = str.substring(infoBeg, infoEnd + 1);
			parser.parseFtpLink(infoStr, fileName);
		}
	}
}
