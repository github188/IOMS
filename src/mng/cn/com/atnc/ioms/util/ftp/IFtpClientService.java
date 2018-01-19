package cn.com.atnc.ioms.util.ftp;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.net.ftp.FTPFile;

import cn.com.atnc.ioms.util.ftp.helper.FtpFileNameComparator;
import cn.com.atnc.ioms.util.ftp.helper.FtpFileSizeComparator;
import cn.com.atnc.ioms.util.ftp.helper.FtpFileTimeComparator;

/**
 * 
 * @author:HuangYijie
 * @date:2014-4-16 下午5:57:14
 * @version:1.0
 */
public interface IFtpClientService {
	/**
	 * 服务是否运行
	 * 
	 * @return 服务运行状态
	 */
	public boolean isRunning();

	/**
	 * 启动服务
	 * 
	 * @throws Exception
	 *             启动服务失败抛出的异常
	 */
	public void start() throws Exception;

	/**
	 * 停止服务
	 */
	public void stop();

	/**
	 * 列出指定远程目录下的所有文件名
	 * 
	 * @param pathname
	 * @return
	 * @throws IOException
	 */
	public String[] listNames(String pathname) throws IOException;

	/**
	 * 列出指定远程目录下的所有文件
	 * 
	 * @param pathname
	 *            远程文件目录
	 * @return 文件列表
	 * @throws IOException
	 */
	public FTPFile[] listFiles(String pathname) throws IOException;

	/**
	 * 列出指定远程目录下的所有文件，用指定的比较器排序
	 * 
	 * @param path
	 *            远程文件目录
	 * @param comparator
	 *            比较器
	 * @return 文件列表
	 * @throws IOException
	 * @see {@link FtpFileNameComparator}
	 * @see {@link FtpFileSizeComparator}
	 * @see {@link FtpFileTimeComparator}
	 */
	public List<FTPFile> listFiles(String path, Comparator<FTPFile> comparator)
			throws IOException;

	/**
	 * 列出指定远程目录下名字符合正则表达式的文件
	 * 
	 * @param path
	 *            远程文件目录
	 * @param namePattern
	 *            名字正则
	 * @return 文件列表
	 * @throws IOException
	 */
	public List<FTPFile> listFiles(String path, Pattern namePattern)
			throws IOException;

	/**
	 * 新开一个连接从ftp服务器上下载文件
	 * 
	 * @param remote
	 *            远程文件路径
	 * @param local
	 *            本地文件路径
	 * @param binaryTransfer
	 *            是否用bin文件方式下载，默认为bin模式
	 * @param suffix
	 *            临时文件使用的后缀
	 * @return 是否下载成功
	 * @throws IOException
	 */
	public boolean downFile(String remote, String local,
			boolean binaryTransfer, String suffix) throws IOException;

	/**
	 * 新开一个连接从ftp服务器上下载文件
	 * 
	 * @param remote
	 *            远程文件路径
	 * @param local
	 *            本地文件路径
	 * @param binaryTransfer
	 *            是否用bin文件方式下载，默认为bin模式
	 * @return 是否下载成功
	 * @throws IOException
	 */
	public boolean downFile(String remote, String local, boolean binaryTransfer)
			throws IOException;

	/**
	 * 新开一个连接从ftp服务器上下载文件
	 * 
	 * @param remote
	 *            远程文件路径
	 * @param local
	 *            本地文件路径
	 * @return 是否下载成功
	 * @throws IOException
	 */
	public boolean downFile(String remote, String local) throws IOException;
	/**
	 * 新开一个连接从ftp服务器上下载文件
	 * 
	 * @param remote
	 *            远程文件路径
	 * @param local
	 *            本地文件路径
	 * @return 是否下载成功
	 * @throws IOException
	 */
	public boolean putFile(String remote, String local) throws IOException;

	/**
	 * 删除ftp服务器上的文件
	 * 
	 * @param pathname
	 *            文件的目录
	 * @return 是否删除成功，不存在返回false
	 * @throws IOException
	 *             由于连接的错误之类抛出IOException
	 */
	public boolean deleteFile(String pathname) throws IOException;

	/**
	 * 判断远程服务器上是否有指定文件
	 * 
	 * @param pathname
	 * @return
	 * @throws IOException
	 */
	public boolean hasFile(String pathname) throws IOException;

	/**
	 * 查看当前工作目录
	 * 
	 * @return
	 * @throws IOException
	 */
	public String printWorkingDirectory() throws IOException;

	/**
	 * FTP连接是否正常
	 * 
	 * @return
	 */
	public boolean isConnected();

	/**
	 * 临时文件的后缀
	 * 
	 * @return 后缀 .part
	 */
	public String getPartSuffix();

	public abstract String getServer();

	public abstract int getPort();

	public abstract String getUsername();

	public abstract String getPassword();

	public abstract String getEncoding();

	public abstract long getLiveCheckInterval();

}
