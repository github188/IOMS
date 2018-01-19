package mng.tests.cn.com.atnc.ioms.mng.basedata.ku.service;

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

import cn.com.atnc.ioms.mng.basedata.ku.IKuServiceManager;
import cn.com.atnc.ioms.util.ftp.FtpClientServiceImpl;
import dao.tests.cn.com.atnc.ioms.dao.MyBaseTransationalTest;

/**
 * 
 * @author:HuangYijie
 * @date:2014-4-16 下午6:03:45
 * @version:1.0
 */
public class TestKuServiceService extends MyBaseTransationalTest {

	@Autowired
	private IKuServiceManager kuServiceManager;

	@Test
	public void findById() {
		System.out.println(kuServiceManager.findById("cc6c4785aa9e418d85a5a9fa7da11803"));
	}

}
