package cn.com.atnc.ioms.mng.turndutymng.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.service.BaseService;
import cn.com.atnc.ioms.dao.turndutymng.ITimeControlDao;
import cn.com.atnc.ioms.entity.turndutymng.TimeControl;
import cn.com.atnc.ioms.mng.turndutymng.ITimeControlService;
/**
 * 
 * @author hantianyu
 *
 */
@Service("ITimeControlService")
public class TimeControlServiceImpl extends BaseService implements ITimeControlService{
    
	@Autowired
	private ITimeControlDao timeControlDao;
	
    public String mod(TimeControl timeControl){
    	//先删除，再添加
    	Del();
    	return timeControlDao.save(timeControl).toString();
    }
    
    public void Del(){
    	//TimeControl timeControl=timeControlDao.findById(arg0)
    	TimeControl timeControl=new TimeControl();
    	timeControl=this.getView();
    	if(timeControl!=null){
    		timeControlDao.delete(timeControl);
    	}
    }
    public List<String> getTimeControl(){
    	List<String> strList=new ArrayList<String>();
    	TimeControl timeControl=this.getView();
    	if(timeControl!=null){
    		strList.add(timeControl.getAmHour()+":"+timeControl.getAmMin());
    		strList.add(timeControl.getPmHour()+":"+timeControl.getPmMin());
    		strList.add(timeControl.getLimitTime());
    	}
    	return strList;
    }
    public TimeControl getView(){
    	//获取数据库中唯一一条记录
    	TimeControl timeControl=new TimeControl();
    	List<TimeControl> timeList=timeControlDao.getTimeControl();
    	if(timeList.size()>0){
    		timeControl=timeList.get(0);
    	}
    	else{
    		timeControl=null;
    	}
    	
    	return timeControl;
    	
    }
}
