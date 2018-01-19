package cn.com.atnc.ioms.util.ftp.helper;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.net.ftp.FTPFile;

/**
 * 
 * @author:HuangYijie
 * @date:2014-4-16 下午5:54:51
 * @version:1.0
 */

public class FtpFileTimeComparator implements Comparator<FTPFile>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6767109441423001190L;
	private boolean desc;

	public FtpFileTimeComparator() {
		this.desc = false;
	}

	public FtpFileTimeComparator(boolean desc) {
		super();
		this.desc = desc;
	}

	public int compare(FTPFile o1, FTPFile o2) {
		if (o1 == o2)
			return 0;
		if (o1 == null || o1.getTimestamp() == null)
			return desc ? 1 : -1;
		if (o2 == null || o2.getTimestamp() == null)
			return desc ? -1 : 1;
		if (desc)
			return o2.getTimestamp().compareTo(o1.getTimestamp());
		return o1.getTimestamp().compareTo(o2.getTimestamp());
	}

}
