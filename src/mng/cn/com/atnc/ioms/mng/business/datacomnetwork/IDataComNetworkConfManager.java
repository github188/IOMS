package cn.com.atnc.ioms.mng.business.datacomnetwork;

import cn.com.atnc.ioms.entity.business.datacomnetwork.DataComNetworkConfig;

/**
 * 数据通信网配置Service方法
 *
 * @author Wang Zhicheng
 * @date 2015年10月19日 下午2:03:51
 * @since 1.0.0
 */
public interface IDataComNetworkConfManager {

	/**
	 * 保存
	 *
	 * @param dataComNetworkConfig 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午11:09:56
	 * @since 1.0.0
	 */
	public void save(DataComNetworkConfig dataComNetworkConfig);

	/**
	 * 更新
	 *
	 * @param dataComNetworkConfig 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午11:09:47
	 * @since 1.0.0
	 */
	public void update(DataComNetworkConfig dataComNetworkConfig);

	/**
	 * 删除
	 *
	 * @param dataComNetworkConfig 
	 * @author Wang Zhicheng
	 * @date  2015年10月21日上午11:09:39
	 * @since 1.0.0
	 */
	public void delete(DataComNetworkConfig dataComNetworkConfig);
}
