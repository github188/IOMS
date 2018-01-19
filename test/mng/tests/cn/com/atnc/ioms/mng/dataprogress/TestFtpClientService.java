package mng.tests.cn.com.atnc.ioms.mng.dataprogress;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import junit.framework.Assert;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTPFile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.StringUtils;

import test.cn.com.atnc.common.MyBaseTransationalTest;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.common.util.StringTools;
import cn.com.atnc.common.util.file.ProjectFilePath;
import cn.com.atnc.ioms.mng.dataprocess.IDataParser;
import cn.com.atnc.ioms.mng.dataprocess.IDataProcessor;
import cn.com.atnc.ioms.util.ftp.FtpClientServiceImpl;

/**
 * 
 * @author:HuangYijie
 * @date:2014-4-16 下午6:03:45
 * @version:1.0
 */
public class TestFtpClientService extends MyBaseTransationalTest {
	private FtpClientServiceImpl client;

	@Autowired
	private IDataProcessor processor;
	@Autowired
	private IDataParser parser;

	private static final String STATUS_WARN = "STATUSWARN";
	private static final String LINK_WARN = "LINKWARN";

	@Before
	public void init() throws IOException {
		client = new FtpClientServiceImpl("132.138.7.148", 14731, "ftpuser",
				"FTP#140731", 30000, "UTF-8");
		List<ProtocolCommandListener> listeners = new ArrayList<ProtocolCommandListener>();
		listeners.add(new PrintCommandListener(new PrintWriter(
				new OutputStreamWriter(System.out, "ISO8859-1"))));
		client.setListeners(listeners);
		client.start();
	}

	// @Test
	public void printWorkingDirectory() throws IOException {
		echo(client.printWorkingDirectory());
	}

	@Test
	public void isRunning() {
		Assert.assertTrue(client.isRunning());
	}

	// @Test
	public void downFile() throws IOException {
		echo("\n----------down file------------------");
		client.downFile("/test111.txt", "E:/test14411.txt", true);
	}

	// @Test
	public void deleteFile() throws IOException {
		String remote = "/test222.txt";
		boolean rs = client.deleteFile(remote);
		echo("rs = " + rs);
	}

	// @Test
	public void hasFile() throws IOException {
		long now = System.currentTimeMillis();
		client.hasFile("/test111.txt");
		echo("time = " + (System.currentTimeMillis() - now));

	}

	@Test
	/* @Rollback(value=false) */
	public void listFiles() throws Exception {
		echo("\n-----------------------------------------");
		FTPFile[] firstFiles = client.listFiles("/");
		for (FTPFile file : firstFiles) {
			if (file.isDirectory()) {
				System.out.println("----------directoryName:" + file.getName());
				String directoryName = file.getName();
				if (!"BaYanNRG".equals(directoryName)) {
					continue;
				}
				FTPFile[] secondFiles = client.listFiles("/" + directoryName);
				for (FTPFile ftpFile : secondFiles) {
					if (ftpFile.isDirectory()) {
						continue;
					} else {
						System.out.println("---------------filename:"
								+ ftpFile.getName());
						String fileJson = readFile(ftpFile, directoryName);
						System.out.println("---------------***fileJson:"
								+ fileJson);
						jsonParse(fileJson, ftpFile.getName());
					}
				}
			} else {
			}
		}
	}

	@Test
	@Rollback(value = false)
	public void parstSolidJson() {
		echo("-------------------****--------------------");
		String jsonStr = "{\"id\":\"57abe5a7-39d2-4f64-ab1d-cb71f8f8777a\",\"equipId\":\"a0f0c514-1794-4438-82ce-1254d0bbbae1\",\"type\":\"StatusWarning\",\"severity\":\"CRITICAL\",\"startTime\":\"2015-03-31 13:47:39\",\"endTime\":null,\"repTimes\":1,\"recordTime\":\"2015-03-31 13:47:39\",\"info\":\"串口打开失败，无法与KuModem板卡建立通信连接！\"}";
		try {
			parser.parseStatusWarn(jsonStr, "text.txt");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

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
			reader = new BufferedReader(new FileReader(tempFile));

			StringBuilder jsonTemp = new StringBuilder();
			String lineStr = "";
			int line = 1;
			while (StringTools.hasText(lineStr = reader.readLine())) {
				lineStr = lineStr.replace("\\n\\r", "");
				jsonTemp.append(lineStr);
				line++;
			}
			return jsonTemp.toString();
		} finally {
			reader.close();
		}
	}

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

	public void jsonParse(String str, String fileName) throws ServiceException {

		int index = fileName.indexOf(".txt");
		if (index < 0) {
			throw new ServiceException("不是有效的txt文件:" + fileName);
		}
		String nameStr = fileName.substring(0, index);
		String[] infoArr = StringUtils.tokenizeToStringArray(nameStr, "_");
		String type = infoArr[3];
		if (!StringTools.hasText(type) || !StringTools.hasText(str)) {
			return;
		}
		// 根据json字符串，反序列化出链路告警，保存入库
		if (type.equals(LINK_WARN)) {
			parser.parseLinkedWarn(str, fileName);
		}
		// 根据json字符串，反序列化出状态告警，保存入库
		if (type.equals(STATUS_WARN)) {
			parser.parseStatusWarn(str, fileName);
		}
	}

	@Test
	public void parseKuNodeParameter() {
		try {
			processor.handler();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void parseKuCarrierFreq() {
		try {
			processor.handler();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void parseKuNodeInfo() {
		try {
			processor.handler();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	@Rollback(false)
	public void parseOduPolling() {
		try {
			processor.handler();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void parseWafr08Port0Stat() {
		try {
			processor.handler();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void listNames() throws IOException {
		String[] names = client.listNames("XiAn-ACC/");
		echo(names);
	}

	@Test
	public void listByPattern() throws IOException {
		String regex = "\\w+\\.txt";
		Pattern namePattern = Pattern.compile(regex);
		List<FTPFile> list = client.listFiles("/", namePattern);
		for (FTPFile file : list) {
			System.out.println("***filename***:   " + file.getName());
		}
	}

	@After
	public void destroy() throws Exception {
		Thread.yield();
		client.stop();
	}

}
