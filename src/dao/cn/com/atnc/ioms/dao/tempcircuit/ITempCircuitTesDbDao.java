/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-9-2 下午2:26:26
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.tempcircuit;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitTesDb;

/**
 * 
 * 类说明：TempCircuitTesDb DAO
 * 
 * @author: 局域网_王鹏
 * @time: 2014年3月26日下午7:01:45
 * @version:1.0
 */
public interface ITempCircuitTesDbDao extends IBaseDao<TempCircuitTesDb> {
	public TempCircuitTesDb getByTempcircuitId(String id);
}
