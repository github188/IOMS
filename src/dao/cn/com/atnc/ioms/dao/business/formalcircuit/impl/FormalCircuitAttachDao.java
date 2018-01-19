package cn.com.atnc.ioms.dao.business.formalcircuit.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.business.formalcircuit.IFormalCircuitAttachDao;
import cn.com.atnc.ioms.entity.business.formalcircuit.FormalCircuitAttach;
import cn.com.atnc.ioms.enums.business.baseinfo.AttachSourceEnum;


/**
 * 正式电路申请附件信息Dao接口实现类
 *
 * @author Wang Zhicheng
 * @date 2015年10月15日 上午10:07:59
 * @since 1.0.0
 */
@Repository
public class FormalCircuitAttachDao extends MyBaseDao<FormalCircuitAttach> implements IFormalCircuitAttachDao {

	@Override
	public void delByFormalCircuitId(String id) {
		this.executeHql("delete from FormalCircuitAttach where formalCircuit.id = ?", id);
	}

	@Override
	public FormalCircuitAttach findByFCId(String id) {
		return  super.findByProperty("formalCircuit.id", id);
	}

	@Override
	public List<FormalCircuitAttach> findByFCIdAREA(String id,
			AttachSourceEnum area) {
		StringBuilder sb = new StringBuilder("from FormalCircuitAttach where 1=1");
		List<Object> params = new ArrayList<>();
		if(StringUtils.isNotEmpty(id)) {
			sb.append(" and formalCircuit.id = ?");
			params.add(id);
		}
		if(!ObjectUtils.equals(area, null)) {
			sb.append(" and attachSourceEnum = ?");
			params.add(area);
		}
		return (List<FormalCircuitAttach>) this.queryList(sb.toString(), params.toArray());
	}
}
