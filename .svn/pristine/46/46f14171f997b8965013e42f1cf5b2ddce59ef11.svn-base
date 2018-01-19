package cn.com.atnc.ioms.mng.turndutymng.impl;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.dao.turndutymng.ISignLeaveDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.entity.turndutymng.TimeControl;
import cn.com.atnc.ioms.enums.turndutymng.DutyPlaceEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.enums.turndutymng.DutyStatusEnum;
import cn.com.atnc.ioms.enums.turndutymng.SignLeaveStatusEnum;
import cn.com.atnc.ioms.mng.phonemng.IAgentInfoService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.mng.turndutymng.ITimeControlService;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author hantianyu
 * @creatime 2016-5-26下午3:41:14
 * TODO
 */
@Service("ISignLeaveService")
public class SignLeaveServiceImpl extends BaseService implements ISignLeaveService{

	@Autowired
	private ISignLeaveDao signLeaveDao;
	@Autowired
	private IAgentInfoService agentInfoService;
	@Autowired
	private ITimeControlService timeControlService;
	@Override
	public Pagination queryPage(TurnDutyQueryModel queryModel) throws ServiceException {
		// TODO Auto-generated method stub
		SignLeaveQueryModel qm=new SignLeaveQueryModel();
		qm.setDutyPlace(DutyPlaceEnum.COMMUNICATION);
		List<User> list=this.getEngineerListByPlace(qm);
		System.out.println(list.size()+"------getEngineerListByPlace------");
		this.getCountTimes(queryModel);
		return signLeaveDao.queryPage(queryModel);
	}

	@Override
	public String save(SignLeaveRecord signLeave) {

		//获取 当前激活并处于签到状态下的 记录集合
		SignLeaveQueryModel queryModel=new SignLeaveQueryModel();
	    queryModel.setDutyStatus(DutyStatusEnum.SIGNINACTIVE);
	    List<SignLeaveRecord> listSign=signLeaveDao.getDutyStatus(queryModel);

	    if(signLeave.getDutyRole().equals(DutyRoleEnum.DUTYENGINEER)){
	    	//工程师才需要判断是否需要激活坐席
	       if(signLeave.getDutyPlace().equals(DutyPlaceEnum.COMMUNICATION)){
	    	   //只有在通信基地的值班工程师才有坐席
	    	   if(listSign.size()>=4){
		 	    	//大于等于4 说明没有坐席
		 	    	signLeave.setDutyStatus(DutyStatusEnum.SIGNIN);
		 	    }
		 	    else{
		 	    	//需要激活坐席
		 	    	signLeave.setDutyStatus(DutyStatusEnum.SIGNINACTIVE);
		 	    	//调整坐席状态
		 	    	signLeave.setAgentNumber(agentInfoService.modSign(signLeave.getUserinfo().getName()));
		 	    	
		 	    }
	       }
	       else{
	    	   signLeave.setDutyStatus(DutyStatusEnum.SIGNIN);
	       }
	    	
	    }
	    else{
	    	signLeave.setDutyStatus(DutyStatusEnum.SIGNIN);
	    }
	    //判断是否早退
	    signLeave=setSignDate(signLeave);
		return signLeaveDao.save(signLeave).toString();
	}
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:setSignDate
	 * @Description:是否早退
	 * @Param:@param sign
	 * @Return:void
	 * @Creatime:2016年10月13日 下午4:31:33
	 */
    public SignLeaveRecord setSignDate(SignLeaveRecord sign){
    	SignLeaveRecord signLeaveRecord=sign;
    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	//获取签到时间
    	Date SignTime=signLeaveRecord.getSignTime();
    
    	//获取数据库中 时间阈值
    	TimeControl timeControl=timeControlService.getView();
    	// Date--Calendar
    	
    	if(timeControl!=null){
    		//存在已激活的 阈值
    		String limitDateStr="1900-01-01 "+timeControl.getAmHour()+":"+timeControl.getAmMin()+":00";
    		String signDateStr="1900-01-01 "+SignTime.getHours()+":"+SignTime.getMinutes()+":"+SignTime.getSeconds();
    		System.err.println("limitDateStr:"+limitDateStr);
    		System.err.println("signDateStr:"+signDateStr);
    		try {
				Date limitDate = sdf.parse(limitDateStr);
				Date signDate=sdf.parse(signDateStr);
				long diff=signDate.getTime()-limitDate.getTime();//计算实际签到时间与 阈值的差
				long mins=diff/(1000*60);//精确到分钟
				long limit=Long.parseLong(timeControl.getLimitTime());
				System.err.println("limit:"+limit);
				if(mins-limit>0){
					//迟到
					signLeaveRecord.setSpare3(SignLeaveStatusEnum.LATE);
					long lateStr=mins-limit;
					signLeaveRecord.setLateTime(String.valueOf(lateStr));
				}
				else{
					signLeaveRecord.setSpare3(SignLeaveStatusEnum.NORMAL);
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else{
    		//考勤正常
    		signLeaveRecord.setSpare3(SignLeaveStatusEnum.NORMAL);
    	}
    	return signLeaveRecord;
    }
    
    /**
     * 
     * @Author:hantianyu 
     * @Title:setLeaveDate
     * @Description:判读是否早退
     * @Param:@param sign
     * @Param:@return
     * @Return:SignLeaveRecord
     * @Creatime:2016年10月13日 下午4:50:57
     */
    public SignLeaveRecord setLeaveDate(SignLeaveRecord sign){
    	SignLeaveRecord signLeaveRecord=sign;
    	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	//获取签到时间
    	Date LeaveTime=signLeaveRecord.getLeaveTime();
    	//获取数据库中 时间阈值
    	TimeControl timeControl=timeControlService.getView();
    	// Date--Calendar
    	
    	
    	if(timeControl!=null){
    		//存在已激活的 阈值
    		String limitDateStr="1900-01-01 "+timeControl.getPmHour()+":"+timeControl.getPmMin()+":00";
    		String leaveDateStr="1900-01-01 "+LeaveTime.getHours()+":"+LeaveTime.getMinutes()+":"+LeaveTime.getSeconds();
    		try {
				Date limitDate = sdf.parse(limitDateStr);
				Date leaveDate=sdf.parse(leaveDateStr);
				long diff=limitDate.getTime()-leaveDate.getTime();//计算实际签到时间与 阈值的差
				long mins=diff/(1000*60);//精确到分钟
				long limit=Long.parseLong(timeControl.getLimitTime());
				
				if(mins-limit>0){
					//早退
					if(signLeaveRecord.getSpare3().name().equals("LATE")){
						//已迟到
						signLeaveRecord.setSpare3(SignLeaveStatusEnum.UNNORMAL);
					}
					else{
						signLeaveRecord.setSpare3(SignLeaveStatusEnum.EARLY);
					}
					
					long earlyStr=mins-limit;
					//早退时间
					signLeaveRecord.setEarlyTime(String.valueOf(earlyStr));
				}
				else{
					signLeaveRecord.setSpare3(SignLeaveStatusEnum.NORMAL);
				}
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	else{
    		//考勤正常
    		signLeaveRecord.setSpare3(SignLeaveStatusEnum.NORMAL);
    	}
    	return signLeaveRecord;
    }
	@Override
	public SignLeaveRecord findById(String id) {
		// TODO Auto-generated method stub
		return signLeaveDao.findById(id);
	}
	/**
	 * 判断当前用户是否在岗
	 */
    public boolean isOndutyByUser(User user){
		boolean resultbool=true;
    	SignLeaveQueryModel queryModel=new SignLeaveQueryModel();
		queryModel.setUserinfo(user);
		String flag=this.getDutyStatusByUser(queryModel);
		
		if(flag.equals("NORECORD")||flag.equals(DutyStatusEnum.LEAVE.name())){
			//不在岗
			resultbool=false;
		}
		
		return resultbool;
    } 
    
    /**
     * 判断当前用户是否已激活坐席
     */
    public boolean isActiveByUser(User user){
		boolean resultbool=false;
		SignLeaveQueryModel queryModel=new SignLeaveQueryModel();
		queryModel.setUserinfo(user);
		String flag=this.getDutyStatusByUser(queryModel);
		
		if(flag.equals("SIGNINACTIVE")){
			//激活坐席
			resultbool=true;
		}
		return resultbool;
    } 
    
    public boolean isMangerByUser(User user){
		boolean resultbool=false;
		SignLeaveQueryModel signQueryModel=new SignLeaveQueryModel();
		signQueryModel.setUserinfo(user);
        List<SignLeaveRecord> signLists=signLeaveDao.getViewByUser(signQueryModel);
	    if(signLists.size()>0){
	    	//查询结果有数据
	    	SignLeaveRecord signleave=signLists.get(0);
	 
	    	if(DutyRoleEnum.DUTYMANAGER.equals(signleave.getDutyRole())){
				//角色是值班经理
				resultbool=true;
			}
	    }
		
		return resultbool;
    } 
    
    /**
     * 
     * @Auther Administrator
     * @creatime 2016-5-25上午9:16:22
     * @param queryModel
     * @return String
     * TODO 根据当前登录用户判断其当前值班 状态
     */
	public String getDutyStatusByUser(SignLeaveQueryModel queryModel) {
		String resultStr="";
	
		//获取记录中不等于Leave 并且签到用户为当前用户 的数据集
		List<SignLeaveRecord> listSign=signLeaveDao.getOnDutyStatusByUser(queryModel);
		if(listSign.size()>0){
			SignLeaveRecord signleave=listSign.get(0);
			resultStr=signleave.getDutyStatus().name();
		}
		else{
			//工程师处于不在岗状态
			resultStr="NORECORD";
		}
		return resultStr;
	}

	@Override
	public List<SignLeaveRecord> getSignRecordListByDate(Date today,User name) {
		SignLeaveQueryModel queryModel=new SignLeaveQueryModel();
		//查询开始时间
		queryModel.setSignTime(getNextDay(today));
		//查询结束时间
		queryModel.setLeaveTime(DateUtilTools.getNowDateTime());
		SignLeaveRecord signleave=this.findViewByUser(name);
		if(signleave!=null){
			queryModel.setDutyPlace(signleave.getDutyPlace());
		}
		
		return signLeaveDao.getSignRecordListByDate(queryModel);
	}
	/**
	 * 
	 * @Auther hantianyu
	 * @creatime 2016-5-25上午11:32:29
	 * @param now
	 * @return Date
	 * TODO 获取前一天
	 */
	public Date getNextDay(Date now){
		Date date=now;
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date=calendar.getTime();
		
		return date;
	}
	
	public SignLeaveRecord findViewByUser(User user) {
	    SignLeaveQueryModel queryModel=new SignLeaveQueryModel();
	    SignLeaveRecord sign=null;
	    queryModel.setUserinfo(user);
		//获取记录中不等于Leave 并且签到用户为当前用户 的数据集
		List<SignLeaveRecord> listSign=signLeaveDao.getViewByUser(queryModel);
		if(listSign.size()>0){
			sign=listSign.get(0);
		
		}
		return sign;
	}
	
    public String getDutyPlaceByUser(User user){
    	
    	String dutyplace="";
    	
		SignLeaveRecord signleave=this.findViewByUser(user);
		System.err.println("getDutyPlaceByUser:---"+signleave);
	    if(signleave!=null){
	    	
		    dutyplace=signleave.getDutyPlace().name();
	    }
    	return dutyplace;
    }
    
    /**
     * 正常离岗
     */
    @Override
	public String dutyLeave(SignLeaveRecord sign) {
		String result="NOT";
		SignLeaveQueryModel queryModel=new SignLeaveQueryModel();
		queryModel.setDutyPlace(sign.getDutyPlace());
		//正常的离岗-当前值班人员自己离岗
		sign.setLeaveTime(new Date());
		//根据地点确定离岗是否成功
		if(ObjectUtils.equals(DutyPlaceEnum.COMMUNICATION, sign.getDutyPlace())){
			/**
			 * 通信基地
			 */
			queryModel.setDutyRole(DutyRoleEnum.DUTYENGINEER);
			//值班经理、值班工程师---相同条件：至少一个工程师在岗
			List<SignLeaveRecord> listPlaces = signLeaveDao.getOnDutyCountByPlace(queryModel);
			//值班工程师不为空且大于等于1
			if(CollectionUtils.isNotEmpty(listPlaces) && listPlaces.size() >= 1){
				//当前值班工程师在岗人数大于等于1人，可以离岗
				try{
					//值班工程师人数离岗条件：值班工程师人数大于等于1(不包含自己)
				    if(DutyRoleEnum.DUTYENGINEER.equals(sign.getDutyRole())){
				    	if(listPlaces.size() > 1){
				    		//当前离岗人是值班工程师
				    		
				    		this.leave(sign);
				    		
				    		result="SUCCESS";
				    	}else{
				    		result="LESS2";
				    	}
				    } else if(DutyRoleEnum.DUTYMANAGER.equals(sign.getDutyRole())){
				    	//值班经理离岗
				    	queryModel.setDutyRole(DutyRoleEnum.DUTYMANAGER);
				    	List<SignLeaveRecord> listPlacesM = signLeaveDao.getOnDutyCountByPlace(queryModel);
				    	if(CollectionUtils.isNotEmpty(listPlacesM)){
				    		if(listPlacesM.size() > 1){
				    			//至少还有一名值班经理已签到
				    			this.leave(sign);
				    			result = "SUCCESS";
				    		}else{
				    			result = "MANAGE2";
				    		}
				    	}
				    }
				} catch(Exception e){
					System.out.println(e.getMessage());
				}
			} else{
				//当前在岗工程师小于1人，不能离岗
				result = "LESS2";
			}
		}else if(ObjectUtils.equals(DutyPlaceEnum.SHILIHE, sign.getDutyPlace())){
			/**
			 * 十里河：有一人值班就可以离岗
			 */
			//在岗值班工程师s数量
			List<SignLeaveRecord> listPlaces = signLeaveDao.getOnDutyCountByPlace(queryModel);
			//值班工程师不为空且大于等于1
			try {
				if(CollectionUtils.isNotEmpty(listPlaces) && listPlaces.size() >= 2){
					this.leave(sign);
					result = "SUCCESS";
				}else{
					result = "LESS2";
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}else if(ObjectUtils.equals(DutyPlaceEnum.GENERALOFFICE, sign.getDutyPlace())){
			/**
			 * 总局：随意离岗
			 */
			try {
				this.leave(sign);
				result = "SUCCESS";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return result;
	}
    
    public String dutyMngLeave(SignLeaveRecord sign) {
		String result="SUCCESS";
		//sign.setLeaveTime(leaveDate.parse(leavedate));//赋值离岗时间
		this.leave(sign);
		return result;
    }
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:setEntity
	 * @Description:赋值
	 * @Param:@param sign
	 * @Param:@return
	 * @Return:SignLeaveRecord
	 * @Creatime:2016年6月2日 下午2:49:38
	 */
	public void leave(SignLeaveRecord sign){
		//sign=setLeaveDate(sign);
		Date dt1=sign.getSignTime();
		Date dt2=sign.getLeaveTime();
		
		long diff=dt2.getTime()-dt1.getTime();
		long mins=diff/(1000*60);
		long days=diff/(1000*60*60*24);
		sign.setTotalTimes(mins);
		sign.setDutyStatus(DutyStatusEnum.LEAVE);
		sign.setLeaveTime(dt2);
		//hty
		if(!StringUtils.isEmpty(sign.getAgentNumber())){
			agentInfoService.modLeave(sign.getAgentNumber());
		}
		//
		signLeaveDao.saveOrUpdate(sign);
		
	}

	public Pagination getCountTimes(TurnDutyQueryModel qm) throws ServiceException{
		
		SignLeaveQueryModel signQm=new SignLeaveQueryModel();
		
		Pagination page = signLeaveDao.getUserListByIds(qm);
		List<User> uList = (List<User>) page.getResult();
		for (User user : uList){
			signQm.setUserinfo(user);
			signQm.setStartOptTime(qm.getStartOptTime());
			signQm.setEndOptTime(qm.getEndOptTime());
			signQm.setDutyRole(DutyRoleEnum.DUTYMANAGER);
			
			user.setManagetimes(this.getTimesByUser(signQm));
			signQm.setDutyRole(DutyRoleEnum.DUTYENGINEER);
			user.setEngineertimes(this.getTimesByUser(signQm));
			user.setSumtimes(user.getManagetimes()+user.getEngineertimes());
		}
		return page;
	}
	public double getTimesByUser(SignLeaveQueryModel qm) throws ServiceException{
		DecimalFormat df= new DecimalFormat("######0.00");   
		double number=0;
		List<SignLeaveRecord> listSigns=signLeaveDao.sumTotalTimes(qm);
		if(listSigns.size()>0){
			//有值班记录
			for(SignLeaveRecord sign:listSigns){
				number=number+sign.getTotalTimes();
			}
			try{
				number=number/60;//精确到小时
				df.format(number);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
		return number;
	}
	
	/**
	 * 查询值班用户列表
	 * @author duanyanlin
	 * @date 2016年7月6日下午2:36:08
	 */
    public List<User> getEngineerListByPlace(SignLeaveQueryModel qm){
    	return signLeaveDao.getEngineerListByPlace(qm);
    }
    /**
     * 查询值班用户列表
     * @author duanyanlin
     * @date 2016年7月6日下午2:36:08
     */
    public List<User> getEngineerListByPlaceDuty(SignLeaveQueryModel qm){
    	return signLeaveDao.getEngineerListByPlaceDuty(qm);
    }
    /**
     * 
     * @Author:hantianyu 
     * @Title:getViewByUser
     * @Description:查询统计页展示个人信息
     * @Param:@param qm
     * @Param:@return
     * @Return:SignLeaveRecord
     * @Creatime:2016年8月31日 下午3:26:24
     */
    public SignLeaveRecord getViewByUser(SignLeaveQueryModel qm) {
		String resultStr="";
	   
	    SignLeaveRecord sign=new SignLeaveRecord();

		List<SignLeaveRecord> listSign=signLeaveDao.getViewByUser(qm);
		if(listSign.size()>0){
			sign=listSign.get(0);
		
		}
		return sign;
	}
    
    
}
