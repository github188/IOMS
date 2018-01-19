package cn.com.atnc.ioms.util.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import org.apache.commons.net.ProtocolCommandEvent;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.common.util.AssertUtil;
import cn.com.atnc.common.util.StringTools;

/**
 * 
 * @author:HuangYijie
 * @date:2014-4-16 下午5:57:08
 * @version:1.0
 */
public class FtpClientServiceImpl extends AbstractService implements
		IFtpClientService, ProtocolCommandListener, Runnable {
	private static final String ISO8859 = "ISO8859-1";
	public static final String PART_FILE_SUFFIX = ".part";
	private FTPClient ftp;
	private FTPClientConfig clientConfig;
	private AtomicBoolean connected = new AtomicBoolean(false);
	private List<ProtocolCommandListener> listeners;

	private AtomicBoolean running = new AtomicBoolean(false);
	private AtomicBoolean stop = new AtomicBoolean(false);
	private Thread keepAliveThread;

	private String server;
	private int port = 21;
	private String username;
	private String password;
	private String encoding = "UTF-8";
	private long liveCheckInterval = 100;

	private Object lock = new Object();

	public FtpClientServiceImpl() {

	}

	public FtpClientServiceImpl(String server, int port, String username,
			String password, long liveCheckInterval, String encoding) {
		AssertUtil.notNull(server, "server can not be null");
		this.server = server;
		this.port = port;
		if (username == null)
			this.username = "";
		else
			this.username = username;
		if (password == null)
			this.password = "";
		else
			this.password = password;
		if (liveCheckInterval < 100)
			throw new IllegalArgumentException(
					"liveCheckInterVal can not less than 100");
		this.liveCheckInterval = liveCheckInterval;
		this.encoding = encoding;
	}

	public FtpClientServiceImpl(String server, int port, String username,
			String password, long liveCheckInterval) {
		this(server, port, username, password, liveCheckInterval, "UTF-8");
	}

	public FtpClientServiceImpl(String server, int port, String username,
			String password) {
		this(server, port, username, password, 15000);// 15 seconds
	}

	public FtpClientServiceImpl(String server, String username,
			String password, String encoding) {
		this(server, 21, username, password, 15000, encoding);
	}

	public FtpClientServiceImpl(String server, String username, String password) {
		this(server, 21, username, password);
	}

	@Override
	public boolean isRunning() {
		return running.get();
	}

	@Override
	public synchronized void start() throws IOException {
		if (running.get()) {
			logger.info("ftp client service already start.");
			return;
		}
		stop.set(false);
		connect();// ftp 连接
		// if (!connected)
		// throw new IOException("Can not create ftp connection server:"
		// + server + "\tusername:" + username + "\tpassword:"
		// + password);
		if (keepAliveThread == null) {
			keepAliveThread = new Thread(this);
			keepAliveThread.start();// 启动连接监听线程
			Thread.yield();
		}
		logger.info("Star ftp client service...\t" + server);
		running.set(true);
	}

	@Override
	public synchronized void stop() {
		if (!running.get()) {
			logger.info("Ftp client service is not running.");
			return;
		}
		try {
			stop.set(true);
			if (keepAliveThread != null) {
				keepAliveThread.interrupt();
				Thread.yield();
			}
			disconnect();
		} finally {
			running.set(false);
			logger.info("Stop Ftp client service...\t" + server);
		}

	}

	@Override
	public String[] listNames(String pathname) throws IOException {
		prepare();
		try {
			String isoPath = new String(pathname.getBytes(encoding), ISO8859);
			synchronized (lock) {
				return ftp.listNames(isoPath);
			}
		} catch (Exception e) {
			disconnect();
			logger.error("", e);
			throw new IOException(e.getMessage());
		}
	}

	@Override
	public FTPFile[] listFiles(String pathname) throws IOException {
		prepare();
		try {
			String isoPath = new String(pathname.getBytes(encoding), ISO8859);
			synchronized (lock) {
				return ftp.listFiles(isoPath);
			}
		} catch (Exception e) {
			disconnect();
			logger.error("", e);
			throw new IOException(e.getMessage());
		}
	}

	@Override
	public List<FTPFile> listFiles(String path, Comparator<FTPFile> comparator)
			throws IOException {
		prepare();
		AssertUtil.notNull(comparator, "Comparator can not be null");
		try {
			List<FTPFile> list;
			String isoPath = new String(path.getBytes(encoding), ISO8859);
			synchronized (lock) {
				FTPFile[] files = ftp.listFiles(isoPath);
				list = (ObjectUtils.isEmpty(files)) ? new ArrayList<FTPFile>()
						: Arrays.asList(files);
			}
			Collections.sort(list, comparator);
			return list;
		} catch (Exception e) {
			disconnect();
			logger.error("", e);
			throw new IOException(e.getMessage());
		}
	}

	public List<FTPFile> listFiles(String path, Pattern namePattern,
			Comparator<FTPFile> comparator) throws IOException {
		prepare();
		AssertUtil.notNull(namePattern, "Name pattern can not be null.");
		try {
			List<FTPFile> list = new ArrayList<FTPFile>();
			String isoPath = new String(path.getBytes(encoding), ISO8859);
			synchronized (lock) {
				FTPFile[] files = ftp.listFiles(isoPath);
				for (FTPFile file : files) {
					if (namePattern.matcher(file.getName()).matches())
						list.add(file);
				}
			}
			if (comparator != null)
				Collections.sort(list, comparator);
			return list;
		} catch (Exception e) {
			disconnect();
			logger.error("", e);
			throw new IOException(e.getMessage());
		}
	}

	@Override
	public List<FTPFile> listFiles(String path, Pattern namePattern)
			throws IOException {
		return listFiles(path, namePattern, null);
	}

	@Override
	public boolean downFile(String remote, String local,
			boolean binaryTransfer, String suffix) throws IOException {
		AssertUtil.notNull(remote, "param remote can not be null");
		AssertUtil.notNull(local, "param local can not be null");
		String mySuffix = StringTools.hasText(suffix) ? suffix
				: PART_FILE_SUFFIX;
		File localFile = new File(local);
		String localTmp = local + mySuffix;
		File tmpFile = new File(localTmp);
		FTPClient ftp = prepareClient(binaryTransfer);
		OutputStream out = new FileOutputStream(tmpFile);
		try {
			String isoRemote = new String(remote.getBytes(encoding), ISO8859);
			boolean rs = ftp.retrieveFile(isoRemote, out);
			out.close();
			out = null;
			if (!rs) {
				logger.error("下载文件({})失败", remote);
				if (!tmpFile.delete())
					logger.error("删除临时文件({})失败", tmpFile.getAbsolutePath());
				return false;
			}
			if (localFile.exists() && !localFile.delete())
				logger.error("delete local file failed:{}", local);
			rs = tmpFile.renameTo(localFile);
			if (!rs) {
				logger.error("rename file failed.");
				if (!tmpFile.delete())
					logger.error("删除临时文件({})失败", tmpFile.getAbsolutePath());
			}
			return rs;
		} finally {
			if (out != null)
				out.close();
			disconnect(ftp);
		}
	}

	@Override
	public boolean downFile(String remote, String local, boolean binaryTransfer)
			throws IOException {
		return downFile(remote, local, binaryTransfer, getPartSuffix());
	}

	@Override
	public boolean downFile(String remote, String local) throws IOException {
		return downFile(remote, local, true);
	}

	/**
	 * 
	 * @author 段衍林
	 * @2016年12月8日 下午1:18:03
	 * @param filePath
	 *            上传文件的路径
	 * @param ftpRePath
	 *            ftp相对路径
	 * @return boolean
	 */
	@SuppressWarnings("finally")
	public boolean putFile(String ftpRePath, String filePath) {
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient = getClient();
			iterateUpload(ftpClient, filePath, ftpRePath);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("FTP上传失败  ", e);
		} finally {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("关闭FTP出现异常  ", e);
			}
			return true;
		}
	}

	public void iterateUpload(FTPClient ftpClient, String filePath,
			String ftpRePath) throws IOException {
		File srcFile = new File(filePath);
		if (srcFile.isFile()) {
			FileInputStream fis = new FileInputStream(srcFile);
			ftpClient.changeWorkingDirectory(ftpRePath);
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftpClient.storeFile(srcFile.getName(), fis);
		} else if (srcFile.isDirectory()) {
			ftpClient.makeDirectory(ftpRePath + File.separator
					+ srcFile.getName());
			File[] files = srcFile.listFiles();
			for (File f : files) {
				iterateUpload(ftpClient, f.getAbsolutePath(), ftpRePath
						+ File.separator + srcFile.getName());
			}
		}
	}

	@Override
	public boolean deleteFile(String pathname) throws IOException {
		AssertUtil.notNull(pathname, "param pathname can not be null.");
		String isoPath = new String(pathname.getBytes(encoding), ISO8859);
		synchronized (lock) {
			return ftp.deleteFile(isoPath);
		}
	}

	@Override
	public boolean hasFile(String pathname) throws IOException {
		AssertUtil.notNull(pathname, "Param pathname can not be null.");
		FTPFile[] files = listFiles(pathname);
		return (files.length > 0);
	}

	@Override
	public String printWorkingDirectory() throws IOException {
		synchronized (lock) {
			return ftp.printWorkingDirectory();
		}
	}

	@Override
	public String getPartSuffix() {
		return PART_FILE_SUFFIX;
	}

	private synchronized void connect() {
		if (connected.get()) {
			logger.info("Ftp Already connected!");
			return;
		}
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(this);// 监听命令执行错误事件
		if (!CollectionUtils.isEmpty(listeners)) {
			for (ProtocolCommandListener listener : listeners)
				ftp.addProtocolCommandListener(listener);
		}
		try {
			if (getClientConfig() != null)
				ftp.configure(getClientConfig());
			ftp.setConnectTimeout(30000);
			ftp.connect(server, port);
			int reply = ftp.getReplyCode();
			// After connection attempt, you should check the reply code to
			// verify success
			if (!FTPReply.isPositiveCompletion(reply)) {
				disconnect();
				return;
			}
			if (!ftp.login(username, password)) {
				logger.info("Ftp login failed.");
				disconnect();
				return;
			}
			// Use passive mode as default because most of us are
			// behind firewalls these days.
			ftp.enterLocalPassiveMode();
			ftp.setControlEncoding(encoding);
			logger.info("connect to server success.server:" + server);
			connected.set(true);
		} catch (Exception e) {
			logger.error("can not connect to:" + server, e);
			disconnect();
		}
	}

	private FTPClient getClient() {
		FTPClient ftp = new FTPClient();
		try {
			if (getClientConfig() != null)
				ftp.configure(getClientConfig());
			// 连接30秒超时
			ftp.setConnectTimeout(30000);
			ftp.connect(server, port);
			int reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				disconnect(ftp);
				return null;
			}
			if (!ftp.login(username, password)) {
				logger.info("Ftp login failed.");
				disconnect(ftp);
				return null;
			}
			ftp.enterLocalPassiveMode();
			ftp.setControlEncoding(encoding);
			return ftp;
		} catch (Exception e) {
			logger.error("can not connect to:" + server, e);
			disconnect(ftp);
			return null;
		}
	}

	@Override
	public boolean isConnected() {
		return connected.get();
	}

	private synchronized void disconnect() {
		try {
			disconnect(ftp);
		} finally {
			connected.set(false);
		}
	}

	private void disconnect(FTPClient ftp) {
		try {
			// if (ftp == null || !(ftp.isConnected())) return;
			if (ftp == null)
				return;
			logger.debug("Disconnect ftp client here:{}", ftp);
			ftp.disconnect();
		} catch (Exception e) {
			logger.error("", e);
		}
	}

	protected boolean autoReconnect() {
		if (!connected.get())
			connect();
		return connected.get();
	}

	@Override
	public void run() {
		while (!stop.get()) {
			try {
				if (connected.get()) {
					synchronized (lock) {
						ftp.sendNoOp();
					}
				} else {
					logger.info("The Connection is broken,Reconnect here..");
					connect();
				}
				Thread.sleep(liveCheckInterval);
			} catch (InterruptedException e) {
				logger.info("Catch interrupt ,stop connection listen thread.");
				stop.set(true);
			} catch (IOException e) {
				logger.error(e.getMessage());
				disconnect();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	public void protocolCommandSent(ProtocolCommandEvent event) {
		// do nothing
	}

	@Override
	public void protocolReplyReceived(ProtocolCommandEvent event) {
		int reply = event.getReplyCode();
		// 主要是421 Connection timed out - closing.
		// 命令错误时断开连接
		if (FTPReply.isNegativeTransient(reply)) {
			logger.warn("command failed,reason : " + event.getMessage());
			disconnect();
		}
	}

	protected void prepare() throws IOException {
		if (!autoReconnect())
			throw new IOException("Can not connect to server:" + server);
	}

	protected FTPClient prepareClient(boolean binaryTransfer)
			throws IOException {
		FTPClient ftp = getClient();
		if (ftp == null)
			throw new IOException("Can not create Connection: " + server);
		if (binaryTransfer)
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
		// 1分钟服务器无反馈，主动关闭连接
		ftp.setDefaultTimeout(60000);
		return ftp;
	}

	public FTPClientConfig getClientConfig() {
		if (clientConfig == null)
			clientConfig = new FTPClientConfig();
		return clientConfig;
	}

	public void setClientConfig(FTPClientConfig clientConfig) {
		this.clientConfig = clientConfig;
	}

	public void setListeners(List<ProtocolCommandListener> listeners) {
		this.listeners = listeners;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public long getLiveCheckInterval() {
		return liveCheckInterval;
	}

	public void setLiveCheckInterval(long liveCheckInterval) {
		this.liveCheckInterval = liveCheckInterval;
	}

}
