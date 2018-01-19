/**
 * @ProjectName IOMS
 * @FileName FtpClientServiceTest.java
 * @PackageName:tests.cn.com.atnc.ioms.mng.util.ftp
 * @author KuYonggang
 * @date 2015年3月23日上午9:53:23
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package mng.tests.cn.com.atnc.ioms.mng.util.ftp;

import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.util.ftp.IFtpClientService;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 此处添加类FtpClientServiceTest的描述信息
 *
 * @author KuYonggang
 * @date 2015年3月23日 上午9:53:23
 * @since 1.0.0
 */
public class FtpClientServiceTest extends MyBaseTransationalTest {

	@Autowired
	private IFtpClientService ftpClientService;
	
	
}
