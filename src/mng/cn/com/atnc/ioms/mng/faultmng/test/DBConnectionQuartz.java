package cn.com.atnc.ioms.mng.faultmng.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import cn.com.atnc.ioms.mng.faultmng.IFaultMQService;
import cn.com.atnc.ioms.mng.phonemng.ICallInfoService;
import cn.com.atnc.ioms.model.phonemng.CallInformationQueryModel;

public class DBConnectionQuartz {
	//@Autowired
	//private IFaultMQService faultMQService;
	@Autowired
	private ICallInfoService callService;
    
	private String filepath="D:\\test";
	private String copyFilePath="//132.138.36.163//d//test";
	//  \\132.138.36.163\d
	public void executeInternal() {
		
		//faultMQService.receive();
		File file=new File(filepath);
		try{
			//createFile(file);
			//copyFile();
			handle();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//CallInformationQueryModel qm=new CallInformationQueryModel();
		//System.err.println("job started..."+new Date()+"////"+callService.getNameList(qm)); 
		
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
	public void createFile(File file){
		if (!file.exists()) {
			file.mkdir();
			System.err.println("创建文件夹test成功！");
		}
		else{
			System.err.println("已存在！");
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
	public void copyFile(){
		try{
			FileUtils.copyDirectory(new File(copyFilePath), new File(filepath));
			System.err.println("复制成功");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void handle(){
	   Date nextDate=getNextDay(new Date());
	   SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
	   CallInformationQueryModel qm=new CallInformationQueryModel();
	   System.err.println(callService.getFileByDate(qm));
	   
	}
	public Date getNextDay(Date date){
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date=calendar.getTime();
		return date;
	}
}
