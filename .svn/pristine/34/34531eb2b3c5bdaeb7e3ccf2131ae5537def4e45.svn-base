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
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.net.ftp.FTPFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.enums.duty.satelliteauto.SatelliteCheckType;
import cn.com.atnc.ioms.mng.dataprocess.ISatelliteCheckParser;
import cn.com.atnc.ioms.mng.dataprocess.ISatelliteCheckProcessor;
import cn.com.atnc.ioms.util.DateUtilTools;
import cn.com.atnc.ioms.util.ftp.IFtpClientService;

/**
 * 卫星自检解析实现类
 *
 * @author 段衍林
 * @2016年11月29日 下午2:36:04
 */
@Service("SatelliteCheckProcessor")
public class SatelliteCheckProcessorImpl extends AbstractService implements
		ISatelliteCheckProcessor {

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
	private ISatelliteCheckParser parser;

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
	//@Scheduled(cron = "0 0/1 * * * ?")
	public void handler() throws IOException {
		logger.info("************ftp check every minute****************");
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
				// 不是卫星自检目录，跳出
				if (!StringUtils.equalsIgnoreCase(directoryName, "txjd")) {
					continue;
				}
				// 卫星自检目录下的文件查询
				FTPFile[] secondFiles = client.listFiles("/" + directoryName);
				if (secondFiles == null || secondFiles.length < 1) {
					logger.info("************satellite ftp check no file****************directoryName:"
							+ directoryName);
					return;
				}
				for (final FTPFile ftpFile : secondFiles) {
					if (ftpFile.isDirectory()) {
						continue; // 如果是目录的话跳过
					} else {
						logger.info("************satellite ftp check file:"
								+ ftpFile.getName());
						try {
							// 解析卫星自检文件
							jsonParse(readFile(ftpFile, directoryName),
									ftpFile.getName());
						} catch (ServiceException e1) {
							logger.error(e1.getMessage());
							// 如果解析出现异常则删除下载到本地的文件，但需要保留FTP服务器上面未解析成功的文件
							File tempfile = new File(
									ProjectFilePath.getTmpPath()
											+ ftpFile.getName());
							//上传文件到ftp（/txjd/txjdfaild）目录下
							client.putFile(
									client.printWorkingDirectory()
											+ directoryName + "/txjdfaild",
									ProjectFilePath.getTmpPath()
											+ ftpFile.getName());

							if (tempfile.exists()) {
								tempfile.delete();
							}
							// 删除文件
							client.deleteFile(client.printWorkingDirectory()
									+ directoryName + "/" + ftpFile.getName());
							continue;
						}
						// 多线程处理
						excutor.execute(new Runnable() {
							@Override
							public void run() {
								try {
									// 解析完成后删除本地文件
									while (true) {
										boolean delLocal = new File(
												ProjectFilePath.getTmpPath()
														+ ftpFile.getName())
												.delete();
										if (delLocal) {
											break;
										}
										Thread.sleep(1000);
									}
									// 解析完成后删除服务器端的文件
									while (true) {
										boolean delServer = client.deleteFile(client
												.printWorkingDirectory()
												+ directoryName
												+ "/"
												+ ftpFile.getName());
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
	}

	/**
	 * 从FTP服务器上读取指定文件的内容，返回不含回车tab的字符串
	 * 
	 * @author:HuangYijie
	 * @Date:2014-4-17 上午10:16:51
	 * 
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
			reader = new BufferedReader(new InputStreamReader(
					new FileInputStream(tempFile), "UTF-8"));
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
	 * @author:HuangYijie
	 * @Date:2014-4-17 上午10:17:41
	 * 
	 * @param str
	 *            文件内容
	 * @param fileName
	 *            文件名称
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *             void
	 * @throws ServiceException
	 */
	@Transactional
	public void jsonParse(String str, String fileName) throws ServiceException {

		// 取文件“.txt”位置
		int index = fileName.indexOf(".txt");
		if (index < 0) {
			throw new ServiceException("不是有效的txt文件:" + fileName);
		}
		// 文件名（不含文件格式）
		String nameStr = fileName.substring(0, index);
		// 文件名转换为相关数组
		String[] infoArr = org.springframework.util.StringUtils
				.tokenizeToStringArray(nameStr, "_");// 根据“_”分隔文件名
		// 节点名称（通信基地等）
		// String nodeName = infoArr[0];
		// ip地址
		// String nodeIp = infoArr[1];
		// 设备类型
		String equipName = infoArr[2]; // FTP文件类别信息
		// 参数类型
		String checkType = infoArr[3]; // FTP文件类别信息
		String time = infoArr[4]; // 采集时间
		// 拼接时间字符串
		if (time.length() == 14) {
			time = time.substring(0, 4) + "-" + time.substring(4, 6) + "-"
					+ time.substring(6, 8) + " " + time.substring(8, 10) + ":"
					+ time.substring(10, 12) + ":" + time.substring(12, 14);
		} else {
			throw new ServiceException("文件名格式有误:" + fileName);
		}
		// 巡检时间
		Date checkTime = null;
		// 非空验证和格式转换
		if (StringUtils.isNotEmpty(time)) {
			// 时间格式"2016-11-29 16:26:00"
			checkTime = DateUtilTools.parseDate(time,
					DateUtilTools.PATTERN_DATE_3);
		}

		if (!StringTools.hasText(checkType) || !StringTools.hasText(checkType)) {
			return;
		}

		/**
		 * 解析文件内容：type和具体info
		 */
		String typeStr = "Type\":\"";
		int beg = str.indexOf(typeStr);
		if (beg < 0) {
			throw new ServiceException("Json数据格式不正确,无type:" + str);
		}
		int end = str.indexOf("\"", beg + typeStr.length());
		if (end < 0) {
			throw new ServiceException("Json数据格式不正确，无\\:" + str);
		}
		// 文件参数类型
		String type = str.substring(beg + typeStr.length(), end);
		int infoBeg = str.indexOf("[", 1);
		if (infoBeg < 0) {
			// 补充数据
			String infoStr = "\"Info\":";
			int strNo = str.indexOf(infoStr);
			str = str.substring(strNo + 7);
			str = infoStr + "[" + str;
			// throw new ServiceException("Json数据格式不正确,无[:" + str);
		}
		int infoEnd = str.lastIndexOf("]");
		if (infoEnd < 0) {
			// 拼接字符串
			str = str.substring(0, str.length() - 1) + "]}";
			// throw new ServiceException("Json数据格式不正确,无]:" + str);
		}
		int infoBegR = str.indexOf("[", 1);
		int infoEndR = str.lastIndexOf("]");
		// 文件中的具体数据
		String infoStr = str.substring(infoBegR, infoEndR + 1);
		if (!StringTools.hasText(type) || !StringTools.hasText(infoStr)) {
			return;
		}

		/**
		 * 频谱监测--通信基地-TES-TES OCC状态实体
		 */
		if (StringUtils.equalsIgnoreCase(SatelliteCheckType.TxPower.name(),
				checkType)) {
			parser.parseTesOcc(infoStr, fileName, checkTime);
		}
		/**
		 * 通信基地-TES-TES ODU
		 */
		if (StringUtils.equalsIgnoreCase(SatelliteCheckType.CAgilisRcu.name(),
				checkType)) {
			parser.parseTxjdOdu(infoStr, fileName, checkTime);
		}
		/**
		 * 通信基地-KU卫星--子网自动信息（1，2，3，4，FR）
		 */
		if (StringUtils.equalsIgnoreCase(SatelliteCheckType.LinkParas.name(),
				checkType)) {
			parser.parseKuData(infoStr, fileName, checkTime, equipName);
		}
		/**
		 * 通信基地-KU卫星--温度、参数、状态信息
		 */
		if (StringUtils.equalsIgnoreCase(SatelliteCheckType.KuEfdataRju.name(),
				checkType)) {
			parser.parseKuEfdataRju(infoStr, fileName, checkTime);
		}
		/**
		 * 东四--odu
		 */
		if (StringUtils.equalsIgnoreCase(SatelliteCheckType.VitacomOdu.name(),
				checkType)) {
			parser.parseDsOdu(infoStr, fileName, checkTime);
		}
	}
}
