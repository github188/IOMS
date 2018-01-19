package cn.com.atnc.ioms.util.ftp.helper;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.net.ftp.FTPFile;

/**
 * 
 * @author:HuangYijie
 * @date:2014-4-16 下午5:53:51
 * @version:1.0
 */
public class FtpFileNameComparator implements Comparator<FTPFile>, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4494290862256339280L;
	private boolean desc;

	public FtpFileNameComparator() {
		this.desc = false;
	}

	public FtpFileNameComparator(boolean desc) {
		super();
		this.desc = desc;
	}

	public int compare(FTPFile o1, FTPFile o2) {
		if (o1 == o2)
			return 0;
		if (o1 == null || o1.getName() == null)
			return desc ? 1 : -1;
		if (o2 == null || o2.getName() == null)
			return desc ? -1 : 1;
		if (desc)
			return o2.getName().compareToIgnoreCase(o1.getName());
		return o1.getName().compareToIgnoreCase(o2.getName());
	}

}
