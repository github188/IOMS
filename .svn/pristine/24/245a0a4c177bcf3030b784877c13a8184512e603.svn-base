package cn.com.atnc.ioms.mng.business.satellite;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.business.satellite.KuSatellite;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteQueryModel;
import cn.com.atnc.ioms.model.business.satellite.KuSatelliteReortModel;


/**
 *  Ku卫星网远端站入网申请信息Service接口
 *
 * @author ku
 * @date 2015年5月13日 下午4:03:05
 * @since 1.0.0
 */
public interface IKuSatelliteService {

	/**
	 * 通过查询条件model查询ku卫星网远端站入网申请记录
	 *
	 * @param queryModel
	 * @return Pagination
	 * @author ku
	 * @date  2015年5月25日下午2:21:40
	 * @since 1.0.0
	 */
	Pagination queryPageByModel(KuSatelliteQueryModel queryModel);

	/**
	 * 通过ID查询KU卫星网入网申请记录信息
	 *
	 * @param id
	 * @return 
	 * @author ku
	 * @date  2015年5月25日下午2:49:41
	 * @since 1.0.0
	 */
	Object findById(String id);

	/**
	 * 处理表单保存操作
	 *
	 * @param queryModel 
	 * @author ku
	 * @return 
	 * @date  2015年5月25日下午3:36:08
	 * @since 1.0.0
	 */
	KuSatellite dealForm(HttpServletRequest request, KuSatelliteQueryModel queryModel,User user);

	/**
	 * 通过基础申请信息ID获取ku入网申请实体
	 *
	 * @param id
	 * @return 
	 * @author ku
	 * @date  2015年5月26日下午2:37:58
	 * @since 1.0.0
	 */
	Object findByApplyBaseInfoId(String id);
	
	/**
	 * 持久化KU入网申请记录
	 *
	 * @param entity 
	 * @author ku
	 * @date  2015年6月2日上午10:23:15
	 * @since 1.0.0
	 */
	void add(KuSatellite entity);

	/**
	 * 修改信息
	 * @param kuSatellite 
	 * @author WangLingbin
	 * @date  2015年10月21日下午2:09:51
	 * @since 1.0.0
	 */
	void update(KuSatellite kuSatellite);

	/**
	 * 删除信息
	 * @author WangLingbin
	 * @date  2015年5月21日上午9:42:39
	 * @since 1.0.0
	 */
	void delete(KuSatellite kuSatellite);
	/**
	 * 根据主键ID获取申请对象
	 *
	 * @param id 主键ID
	 * @return KuSatellite
	 * @author ku
	 * @date  2015年5月15日上午9:01:55
	 * @since 1.0.0
	 */
	KuSatellite getKuSatelliteById(String id);
	
	/**
	 * 得到打印报表信息
	 *
	 * @param id
	 * @return 
	 * @date  2015年7月8日下午3:39:33
	 * @since 1.0.0
	*/
	List<KuSatelliteReortModel> getReportDateSource(String id);
	
	/**
	 * 获取报表填充参数
	 * @author WangLingbin
	 * @date  2015年11月10日下午4:53:09
	 * @since 1.0.0
	 */
	Map<String, Object> getReportParams(HttpServletRequest request, String id, String reportName);

	/**
	 * 获取需要发送短信的数据
	 *
	 * @return 
	 * @author Wang Zhicheng
	 * @date  2015年11月16日下午2:52:38
	 * @since 1.0.0
	 */
	List<KuSatellite> getListSendMessage();
}
