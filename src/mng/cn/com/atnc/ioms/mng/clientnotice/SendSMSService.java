package cn.com.atnc.ioms.mng.clientnotice;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * @author:lizhisheng
 * @date:2014-4-21 上午9:15:51
 * @version:1.0
 */
public interface SendSMSService extends Library {
	 public static final SendSMSService INSTANCE = (SendSMSService)Native.loadLibrary("GSM", SendSMSService.class);

	  public abstract int LinkModem(int paramInt);//连接短信猫

	  public abstract int CheckModem();//检查和短信猫的连接是否正常

	  public abstract String GetService();//获得短信中心号码

	  public abstract int SendSMS(String smsCent,String phone,String smsContent);//发送短信

	  public abstract int CloseModem(int paramInt);//关闭短信猫
}
