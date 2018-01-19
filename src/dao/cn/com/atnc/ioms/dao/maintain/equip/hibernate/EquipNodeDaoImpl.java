/**
 * @ProjectName IOMS_MAINTAIN
 * @FileName EquipNodeDaoImpl.java
 * @PackageName:cn.com.atnc.ioms.dao.maintain.equip.hibernate
 * @author ku
 * @date 2015年5月6日上午10:42:06
 * @since 1.0.0
 * @Copyright (c) 2015,ATNC ###@atnc.com All Rights Reserved.
 */
package cn.com.atnc.ioms.dao.maintain.equip.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.maintain.equip.IEquipNodeDao;
import cn.com.atnc.ioms.entity.maintain.equip.EquipNode;
import cn.com.atnc.ioms.entity.maintain.equip.MaintainEquip;
import cn.com.atnc.ioms.model.maintain.equipnode.EquipNodeQueryModel;

/**
 * 设备节点Dao接口实现类
 *
 * @author ku
 * @date 2015年5月6日 上午10:42:06
 * @since 1.0.0
 */
@Repository
public class EquipNodeDaoImpl extends MyBaseDao<EquipNode> implements IEquipNodeDao {

	@Override
	public Pagination queryPage(EquipNodeQueryModel queryModel) {
		StringBuilder hql = new StringBuilder("from EquipNode where 1=1");
		Map<String, Object> params = new HashMap<String, Object>();
		if (StringUtils.isEmpty(queryModel.getEqnameLike()) == false) {
			hql.append(" and equip.name like:eqname  escape '\\' ");
			params.put("eqname", "%" + queryModel.getEqnameLike() + "%");
		}
		if (StringUtils.isEmpty(queryModel.getMenameLike()) == false) {
			hql.append(" and maintainEquip.name like:mename  escape '\\' ");
			params.put("mename", "%" + queryModel.getMenameLike() + "%");
		}
		
		/**
		 * dyl添加查询条件
		 */
		if (!ObjectUtils.equals(queryModel.getBureau(), null)) {
			hql.append(" and equip.bureau=:bureau ");
			params.put("bureau", queryModel.getBureau());
		}
		
		if(queryModel.getStartRecordTime() != null){
            hql.append(" and createTime>=:startRecordTime");
            params.put("startRecordTime",queryModel.getStartRecordTime());
        }
        if(queryModel.getStartRecordTime() != null){
            hql.append(" and createTime<=:endRecordTime");
            params.put("endRecordTime",queryModel.getEndRecordTime());
        }
		String countHql = COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params, countHql,
				queryModel.getPageNo(), queryModel.getPageSize());
	}

	@Override
	public EquipNode findByMaintainEquip(MaintainEquip maintainEquip) {
		return super.findByProperty("maintainEquip", maintainEquip);
	}

}
