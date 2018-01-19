package cn.com.atnc.ioms.mng.maintain.circuit;

import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.ServiceException;
import cn.com.atnc.ioms.entity.maintain.circuit.EquipCircuit;
import cn.com.atnc.ioms.model.basedata.ku.KuStatQueryModel;

 /**
 * 此处添加类IMaintainCircuitManager的描述信息
 *
 * @author wangzhicheng
 * @date 2015-5-4 下午4:43:56
 * @since 1.0.0
 */
public interface IMaintainCircuitManager {

	/**
	 * MaintainCircuit添加方法
	 *
	 * @param equipCircuit
	 * @throws ServiceException 
	 * @date  2015-5-6下午3:24:01
	 * @since 1.0.0
	*/
	public void add(EquipCircuit equipCircuit) throws ServiceException;

	/**
	 * 查询数据返回页面格式
	 *
	 * @param queryModel
	 * @return 
	 * @date  2015-5-6下午3:24:14
	 * @since 1.0.0
	*/
	public Pagination queryPage(KuStatQueryModel queryModel);

	/**
	 * 查找单一实体
	 *
	 * @param id
	 * @return 
	 * @date  2015-5-6下午3:24:34
	 * @since 1.0.0
	*/
	public EquipCircuit findById(String id);

	/**
	 * 更新操作
	 *
	 * @param equipCircuit
	 * @throws ServiceException 
	 * @date  2015-5-6下午3:24:45
	 * @since 1.0.0
	*/
	public void update(EquipCircuit equipCircuit) throws ServiceException;

	/**
	 * 删除操作
	 *
	 * @param equipCircuit 
	 * @date  2015-5-6下午3:24:59
	 * @since 1.0.0
	*/
	public void delete(EquipCircuit equipCircuit);

	/**
	 * 查询所有数据返回List
	 *
	 * @return 
	 * @date  2015-5-6下午3:25:11
	 * @since 1.0.0
	*/
	public List<EquipCircuit> findAll();

}
