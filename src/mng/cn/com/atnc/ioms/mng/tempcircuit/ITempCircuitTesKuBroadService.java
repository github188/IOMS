package cn.com.atnc.ioms.mng.tempcircuit;

import java.util.List;

import cn.com.atnc.ioms.entity.tempcircuit.TempCircuitTesKuBroad;

/**
 * @author wangpeng
 * @date 2014-8-29 下午3:20:12
 * @version 1.0
 */

public interface ITempCircuitTesKuBroadService {
	public void add(TempCircuitTesKuBroad obj);

	public List<TempCircuitTesKuBroad> findListByTempcircuitID(String id);

	public TempCircuitTesKuBroad findById(String id);
	
	public void CancleTempCircuitTesKuBroadList(List<TempCircuitTesKuBroad> list);
}
