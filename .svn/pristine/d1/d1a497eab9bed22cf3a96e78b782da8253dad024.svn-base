/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-7-1 下午4:17:18
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package com.fivestars.interfaces.bbs.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.fivestars.interfaces.bbs.client.Client;

/**
 * @author:HuangYijie
 * @date:2014-7-1 下午4:17:18
 * @version:1.0
 */

public class DiscuzTools {
	public static String md5(String input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		return byte2hex(md.digest(input.getBytes()));
	}

	public static String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString();
	}

	public static String md5(long input) {
		return md5(String.valueOf(input));
	}

	public static String getPassword(String password, String salt) {
		return md5(md5(password) + salt);
	}

	public static void main(String[] args) {
		UUID uuid = UUID.randomUUID();
		String salt = uuid.toString().substring(0, 6);
		System.out.println(DiscuzTools.getPassword("123456", "cf2066"));
	}
}
