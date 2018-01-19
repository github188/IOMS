/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-3-25 上午8:57:52
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.equip;

import java.util.List;

import cn.com.atnc.common.dao.IBaseDao;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.entity.basedata.Equip;
import cn.com.atnc.ioms.model.basedata.EquipQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-3-25 上午8:57:52
 * @version:1.0
 */

public interface IEquipDao extends IBaseDao<Equip> {

	public List<Equip> queryList(EquipQueryModel qm);

	/**
	 * 分页查询
	 * 
	 * @author 段衍林
	 * @2016年11月22日 上午10:22:37
	 * @param qm
	 * @return Pagination
	 */
	public Pagination queryPage(EquipQueryModel qm);

	public List<Equip> atmNoteList(EquipQueryModel qm);

}
