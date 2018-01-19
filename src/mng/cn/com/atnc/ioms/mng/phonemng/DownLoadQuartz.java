package cn.com.atnc.ioms.mng.phonemng;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.atnc.ioms.dao.phonemng.ICallInfoDao;
import cn.com.atnc.ioms.entity.phonemng.CallInformation;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;

public class DownLoadQuartz {
	@Autowired
	private ICallInfoService callService;
	@Autowired
	private ICallInfoDao callDao;
    
	
	private String copyFilePath="//120.27.133.149//monitor//bj.ali.3.7//20160912";//"//132.138.36.163//d//test";
	//  \\132.138.36.163\d
	public void executeInternal() {
		
		
		try{
			System.err.println("一小时"+new Date());
			//查找内存溢出问题先关闭
			//handle();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	
		
	}
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:createFile
	 * @Description:创建文件夹
	 * @Param:
	 * @Return:void
	 * @Creatime:2016年9月1日 下午2:48:24
	 */
	public void createFile(String filepath){
		File file=new File(filepath);
		if (!file.exists()) {
			file.mkdir();
			System.err.println("创建文件夹成功！");
		}
		else{
			System.err.println("文件夹已存在！");
		}
	}
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:copyFile
	 * @Description:复制文件
	 * @Param:
	 * @Return:void
	 * @Creatime:2016年9月2日 上午9:28:29
	 */
	public void copyFile(String HTTp_URL){
		 BufferedInputStream bis=null;
         BufferedOutputStream bos=null;
		
		try{
			//FileUtils.copyDirectory(new File(copyFilePath), new File(filepath));
			URL url = new URL(HTTp_URL);
            HttpURLConnection connection =  (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            
            bis = new BufferedInputStream(is);
            //生成文件
            File file = new File("E:/test/"+HTTp_URL.substring((HTTp_URL.lastIndexOf("/"))));//名字截取 可以省略
            //设置输出流
            FileOutputStream fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            int b = 0;
            byte[] byArr = new byte[1024*4];
            while((b=bis.read(byArr))!=-1){
                bos.write(byArr, 0, b);
            }
            fos.close();
			//打印下载成功
			System.err.println("下载成功");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void handle(){
		String filepath="E:\\test";
		
		Date nextDate=getNextDay(new Date());
	   SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	   CallInformationQueryModel qm=new CallInformationQueryModel();
	   //filepath=filepath+callService.getFileByDate(qm);
	   //获取未备份的录音文件列表
	   List<CallInformation> callList=callService.getBackUpList(qm);
	   if(callList.size()>0){
		   for(int i=0;i<callList.size();i++){
			   CallInformation call=callList.get(i);
			   //设置备份标识位
			   call.setSpare2("BACKUP");
			   //获取录音文件路径
			   String recordFile=call.getFileServer()+"/"+call.getRecordFileName();
			   //打印
			   System.err.println(recordFile);
			   
			   try{
				   //创建文件夹
				   createFile(filepath);
				   //下载复制
				   copyFile(recordFile);
				   //更新数据库
				   callDao.update(call);
			   }
			   catch(Exception e){
				   e.printStackTrace();
			   }
			   
			   System.err.println(filepath);
		   }

	   }
	   
	   
	   
	}
	public Date getNextDay(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date=calendar.getTime();
		return date;
	}
}
