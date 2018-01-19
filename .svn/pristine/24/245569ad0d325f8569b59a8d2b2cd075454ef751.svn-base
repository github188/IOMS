/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-16 下午6:54:09
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.mng.dataprocess.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

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
import org.springframework.util.CollectionUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.entity.basedata.ku.KuNodeStatus;
import cn.com.atnc.ioms.entity.basedata.ku.KuService;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPower;
import cn.com.atnc.ioms.mng.dataprocess.ISatelliteDataParser;
import cn.com.atnc.ioms.mng.dataprocess.ISatelliteDataProcessor;
import cn.com.atnc.ioms.util.ftp.IFtpClientService;

/**
 * @author:HuangYijie
 * @date:2014-4-16 下午6:54:09
 * @version:1.0
 */
@Service("SatelliteDataProcessor")
public class SatelliteDataProcessorImpl extends AbstractService implements
		ISatelliteDataProcessor {

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
	private ISatelliteDataParser parser;

	@PostConstruct
	public void init() throws Exception {
		client.start();
	}

	@PreDestroy
	public void destroy() throws Exception {
		Thread.yield();
		client.stop();
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @throws IOException
	 * 
	 * 
	 * @see cn.com.atnc.ioms.mng.dataprocess.ISatelliteDataProcessor#handler(java.lang.String)
	 */
	@Override
	/*@Scheduled(cron = "0 * * * * ?")*/
	public void handler() throws IOException {
		logger.info("************ftp check every minute****************");
		String regex = "\\w+\\.txt";// 所有以.txt结尾的文件
		Pattern namePattern = Pattern.compile(regex);
		List<FTPFile> list = client.listFiles("/", namePattern);// 查找根目录下所有以.txt结尾的文件
		if (CollectionUtils.isEmpty(list)) {
			logger.info("************ftp check no file****************");
			return;
		}
		for (final FTPFile file : list) {
			logger.info("************ftp check file:" + file.getName());
			try {
				jsonParse(readFile(file), file.getName());
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				logger.error(e1.getMessage());
			}
			// 多线程处理
			excutor.execute(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						// 解析完成后删除文件
						while (true) {
							boolean delete;

							delete = client.deleteFile(file.getName());

							if (delete) {
								break;
							}
							Thread.sleep(10000);
						}
					} catch (IOException | InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
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
	private String readFile(FTPFile file) throws IOException {
		boolean downloadStatus = client
				.downFile(client.printWorkingDirectory() + file.getName(),
						ProjectFilePath.getTmpPath() + file.getName());

		if (!downloadStatus) {
			throw new IOException(file.getName() + "下载失败");
		}
		File tempFile = new File(ProjectFilePath.getTmpPath() + file.getName());

		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(tempFile));

			StringBuilder jsonTemp = new StringBuilder();
			String lineStr = "";
			int line = 1;
			while (StringTools.hasText(lineStr = reader.readLine())) {
				jsonTemp.append(lineStr.replace("\\n\\r", ""));
				line++;
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
	 * @throws IOException
	 * @throws ClassNotFoundException
	 *             void
	 * @throws ServiceException
	 */
	@Transactional
	public void jsonParse(String str, String fileName) throws ServiceException {

		// 解析出type和info
		String typeStr = "Type\":\"";
		int beg = str.indexOf(typeStr);
		if (beg < 0) {
			throw new ServiceException("Json数据格式不正确,无type:" + str);
		}
		int end = str.indexOf("\"", beg + typeStr.length());
		if (end < 0) {
			throw new ServiceException("Json数据格式不正确，无\\:" + str);
		}
		String type = str.substring(beg + typeStr.length(), end);
		int infoBeg = str.indexOf("[", 1);
		if (infoBeg < 0) {
			throw new ServiceException("Json数据格式不正确,无[:" + str);
		}
		int infoEnd = str.lastIndexOf("]");
		if (infoEnd < 0) {
			throw new ServiceException("Json数据格式不正确,无]:" + str);
		}
		String infoStr = str.substring(infoBeg, infoEnd + 1);
		// infoEnd = infoStr.lastIndexOf("}");
		// if (infoEnd < 0) {
		// throw new ServiceException("Json数据格式不正确:" + str);
		// }
		// infoStr = infoStr.substring(0, infoEnd + 1);

		if (!StringTools.hasText(type) || !StringTools.hasText(infoStr)) {
			return;
		}
		// 根据type，反序列化出info，保存入库
		if (type.equals(KuNodeStatus.class.getSimpleName())) {
			parser.parseKuStatus(infoStr, fileName);
		}
		if (type.equals(KuService.class.getSimpleName())) {
			parser.parseKuMaplist(infoStr, fileName);
		}

		if (type.equals(TesTxPower.class.getSimpleName())) {
			parser.parseTesTxPower(infoStr, fileName);
		}

	}

}
