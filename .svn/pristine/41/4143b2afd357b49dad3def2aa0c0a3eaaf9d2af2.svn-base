package cn.com.atnc.ioms.util.ftp.helper;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.net.ftp.FTPFile;

/**
 * 
 * @author:HuangYijie
 * @date:2014-4-16 下午5:54:42
 * @version:1.0
 */

public class FtpFileSizeComparator implements Comparator<FTPFile>, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1695007234111922953L;
	private boolean desc;

	public FtpFileSizeComparator()
	{
		this.desc = false;
	}

	public FtpFileSizeComparator(boolean desc)
	{
		super();
		this.desc = desc;
	}

	public int compare(FTPFile o1, FTPFile o2)
	{
		if (o1 == o2) return 0;
		if (o1 == null) return desc ? 1 : -1;
		if (o2 == null) return desc ? -1 : 1;
		if (desc) return Long.valueOf(o2.getSize() - o1.getSize()).intValue();
		return Long.valueOf(o1.getSize() - o2.getSize()).intValue();
	}

}
