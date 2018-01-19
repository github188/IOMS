package cn.com.atnc.ioms.mng.basedata.equip;

import java.io.Serializable;
import java.util.List;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;

/**
 * 类说明:设备服务接口
 *
 * @author 潘涛
 * @date 2014-3-19 下午3:54:59
 * @version:1.0
 */
public interface IEquipService {
	/**
	 * 查询
	 * 
	 * @author 潘涛
	 * @date:2014年4月10日 17:31:33
	 * 
	 * */
	public List<Equip> queryList(EquipQueryModel qm);

	/**
	 * 列表查询
	 * 
	 * @author 段衍林
	 * @2016年11月22日 下午12:58:49
	 * @param qm
	 * @return List<Equip>
	 */
	public List<Equip> queryListGroup(EquipQueryModel qm);

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午10:21:29
	 * @param model
	 * @return Pagination
	 */
	public Pagination queryPage(EquipQueryModel qm);

	/**
	 * 按主键查询
	 * 
	 * @author 潘涛
	 * @date:2014年4月11日 16:26:41
	 * */
	public Equip findById(Serializable id);

	public List<Equip> atmNoteList(EquipQueryModel qm);

}
