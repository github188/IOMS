/**
 * @Title:AtmdayCheckDaoImpl.java
 * @author shijiyong
 * @data 2016年9月26日上午11:06:08
 * @version v1.0
 */
package cn.com.atnc.ioms.dao.duty.atm.day.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.atm.day.AtmDaySonDao;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayMgx;
import cn.com.atnc.ioms.entity.duty.atm.ATMDayRoute;
import cn.com.atnc.ioms.entity.duty.atm.ATMDaySon;
import cn.com.atnc.sample.dao.MyBaseDao;

/**
 * ATM日检路由器子类DAO实现类
 * 
 * @author 王凌斌
 * @2017年2月9日 下午4:27:08
 */
@Repository("atmDaySonDao")
public class AtmDaySonDaoImpl extends MyBaseDao<ATMDaySon> implements
		AtmDaySonDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ATMDaySon> findByRouteOrderBySerial(ATMDayRoute atmDayRoute) {
		return (List<ATMDaySon>) super.queryList(
				"from ATMDaySon where route = ? order by serial asc",
				atmDayRoute);
	}

    @SuppressWarnings("unchecked")
    @Override
    public List<ATMDaySon> findByRouteOrderBySerial(ATMDayMgx atmDayMgx) {
        // TODO Auto-generated method stub
        return (List<ATMDaySon>) super.queryList(
                "from ATMDaySon where mgx = ? order by serial asc",
                atmDayMgx);
    }

}
