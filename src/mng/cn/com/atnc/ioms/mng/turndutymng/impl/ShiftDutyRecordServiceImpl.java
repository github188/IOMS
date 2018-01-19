package cn.com.atnc.ioms.mng.turndutymng.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.turndutymng.IShiftDutyRecordDao;
import cn.com.atnc.ioms.dao.turndutymng.ISignLeaveDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.turndutymng.ShiftDutyRecord;
import cn.com.atnc.ioms.entity.turndutymng.SignLeaveRecord;
import cn.com.atnc.ioms.enums.turndutymng.DutyRoleEnum;
import cn.com.atnc.ioms.mng.turndutymng.IShiftDutyRecordService;
import cn.com.atnc.ioms.mng.turndutymng.ISignLeaveService;
import cn.com.atnc.ioms.model.turndutymng.ShiftDutyQueryModel;
import cn.com.atnc.ioms.model.turndutymng.SignLeaveQueryModel;
import cn.com.atnc.ioms.model.turndutymng.TurnDutyQueryModel;
import cn.com.atnc.ioms.util.DateUtilTools;

/**
 * 
 * @author hantianyu
 * @creatime 2016-5-26下午3:41:03
 * TODO
 */
@Service("IShiftDutyRecordService")
public class ShiftDutyRecordServiceImpl  extends BaseService implements IShiftDutyRecordService{

	@Autowired
	IShiftDutyRecordDao shiftDao;
	@Autowired
	ISignLeaveService signService;
	@Override
	public Pagination queryPage(TurnDutyQueryModel queryModel) {
		// TODO Auto-generated method stub
		return shiftDao.queryPage(queryModel);
	}
	public Pagination queryRecyclePage(TurnDutyQueryModel queryModel) {
		// TODO Auto-generated method stub
		return shiftDao.queryRecyclePage(queryModel);
	}
	@Override
	public String save(ShiftDutyRecord shiftDuty) {
		
    	SignLeaveRecord sign =signService.findViewByUser(shiftDuty.getCreater());
    	shiftDuty.setDutyPlaces(sign.getDutyPlace());
    	shiftDuty.setDutyRoles(sign.getDutyRole());
    	shiftDuty.setSignRecord(sign);
		shiftDuty.setCreatime(new Date());
		shiftDuty.setSpare1("0");
		return shiftDao.save(shiftDuty).toString();
	}

	@Override
	public List<ShiftDutyRecord> getRecordList(ShiftDutyQueryModel queryModel,User user) {
		//查询开始时间
		queryModel.setSignTime(queryModel.getCreatime());
		//查询结束时间
		queryModel.setLeaveTime(DateUtilTools.getNowDateTime());
		SignLeaveRecord sign=signService.findViewByUser(user);
		queryModel.setSignRecord(sign);
		return shiftDao.getRecordList(queryModel);
	}
	
	/**
	 * 
	 * @Author:hantianyu 
	 * @Title:getRecordListBySign
	 * @Description:签到时查看
	 * @Param:@param queryModel
	 * @Param:@param user
	 * @Param:@return
	 * @Return:List<ShiftDutyRecord>
	 * @Creatime:2016年10月17日 上午9:41:44
	 */
	public List<ShiftDutyRecord> getRecordListBySign(ShiftDutyQueryModel queryModel) {
		//查询开始时间
		queryModel.setSignTime(setStartDate(queryModel.getCreatime()));
		//查询结束时间
		queryModel.setLeaveTime(DateUtilTools.getNowDateTime());
	
		return shiftDao.getRecordListBySign(queryModel);
	}
	
	public Date setStartDate(Date nowDate){
		SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Calendar calDate = Calendar.getInstance();
		calDate.setTime(nowDate);
		calDate.add(calDate.DAY_OF_MONTH, -1);
		calDate.add(calDate.HOUR_OF_DAY, 8);
		calDate.add(calDate.MINUTE, 30);
		Date enddate=new Date();
		try {
			enddate = dft.parse(dft.format(calDate.getTime()));
			//System.err.println("enddate:"+enddate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enddate;
	}
	@Override
	public ShiftDutyRecord findViewById(String id) {
		
		return shiftDao.findById(id);
	}
	public ShiftDutyRecord Update(ShiftDutyRecord shiftDuty){
		
		shiftDao.saveOrUpdate(shiftDuty);
		return shiftDao.findById(shiftDuty.getId());
	}
    public void Del(ShiftDutyRecord shiftDuty){
    	shiftDuty.setSpare1("1");
    	shiftDao.saveOrUpdate(shiftDuty);
    }
    public String getDutyPlaceByUser(User user){
    	
    	String dutyplace="";
    	
		SignLeaveRecord signleave=signService.findViewByUser(user);
	    if(signleave!=null){
	    	if(DutyRoleEnum.DUTYMANAGER.equals(signleave.getDutyRole())){
		    	   dutyplace=signleave.getDutyPlace().name();
	    	}
	    }
	    	
    	return dutyplace;
    }
    
    public List<ShiftDutyRecord> getRecordBySignId(ShiftDutyQueryModel queryModel){
    	return shiftDao.getRecordBySignId(queryModel);
    }
}
