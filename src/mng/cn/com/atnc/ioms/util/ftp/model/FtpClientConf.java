package cn.com.atnc.ioms.util.ftp.model;

import cn.com.atnc.common.model.BaseModel;

/**
 * 
 * @author:HuangYijie
 * @date:2014-4-16 下午5:56:20
 * @version:1.0
 */
public class FtpClientConf extends BaseModel
{
	private String server;
	private int port = 21;
	private String username;
	private String password;

	public String getServer()
	{
		return server;
	}

	public void setServer(String server)
	{
		this.server = server;
	}

	public int getPort()
	{
		return port;
	}

	public void setPort(int port)
	{
		this.port = port;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
