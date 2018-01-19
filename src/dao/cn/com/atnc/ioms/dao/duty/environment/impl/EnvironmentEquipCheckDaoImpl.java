package cn.com.atnc.ioms.dao.duty.environment.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.dao.hibernate.BaseDaoHibernateImpl;
import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.environment.ups.UpsContentCheck;
import cn.com.atnc.ioms.enums.duty.environment.acc.SlhImosen;
import cn.com.atnc.ioms.enums.duty.environment.acc.TxjdAcc;
import cn.com.atnc.ioms.enums.duty.environment.dg.DgName;
import cn.com.atnc.ioms.enums.duty.environment.psot.DcPowerName;
import cn.com.atnc.ioms.enums.duty.environment.psot.DdnName;
import cn.com.atnc.ioms.enums.duty.environment.psot.NccName;
import cn.com.atnc.ioms.enums.duty.environment.psot.OticalName;
import cn.com.atnc.ioms.enums.duty.environment.psot.PdsName;
import cn.com.atnc.ioms.enums.duty.environment.psot.TxjdOticalName;
import cn.com.atnc.ioms.enums.duty.environment.psot.ZjOticalName;
import cn.com.atnc.ioms.enums.duty.environment.ups.KuUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.SlhUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.TxjdUpsName;
import cn.com.atnc.ioms.enums.duty.environment.ups.ZjUpsName;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;

@Repository("EnvironmentEquipCheckDao")
public class EnvironmentEquipCheckDaoImpl extends MyBaseDao<EnvironmentEquipCheck> implements EnvironmentEquipCheckDao {

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
        // 查询语句
        StringBuilder hql = new StringBuilder(
                "from EnvironmentEquipCheck u where 1=1");
        // 定义一个集合，存储查询参数信息
        List<Object> queryParams = new ArrayList<Object>();
        // 设备类型
        if (!ObjectUtils.equals(queryModel.getEquipType(), null)) {
            hql.append(" and u.equipType = ? ");
            queryParams.add(queryModel.getEquipType());
        }
        // 巡检类别
        if (!ObjectUtils.equals(queryModel.getCheckType(), null)) {
            hql.append(" and u.checkType = ? ");
            queryParams.add(queryModel.getCheckType());
        }
        // 设备名称
        if ((queryModel.getEquipType().toString()).equals("ups设备")) {
            if (queryModel.getOptType().equals("slhUpsCheck")
                    || queryModel.getOptType().equals("")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?,?,?,?,?)");
                    queryParams.addAll(queryModel.getSlhUpsName());
                }
            } else if (queryModel.getOptType().equals("kuUpsCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?,?,?,?,?)");
                    queryParams.addAll(queryModel.getKuUpsName());
                }
            } else if (queryModel.getOptType().equals("txjdUpsCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?,?,?)");

                    queryParams.addAll(queryModel.getTxjdList());
                }
            } else if (queryModel.getOptType().equals("zjUpsCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?)");
                    queryParams.addAll(queryModel.getZjList());
                }
            }
        } else if ((queryModel.getEquipType().toString()).equals("柴油发电机")) {
            if (queryModel.getOptType().equals("dgCheck")
                    || queryModel.getOptType().equals("")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?)");
                    queryParams.addAll(queryModel.getDgList());
                }
            }
        } else if ((queryModel.getEquipType().toString()).equals("空调设备")) {
            if (queryModel.getOptType().equals("slhAccCheck")
                    || queryModel.getOptType().equals("")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?,?)");
                    queryParams.addAll(queryModel.getAccList());
                }
            } else if(queryModel.getOptType().equals("slhLbtAccCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                }else {
                    hql.append(" and u.name in(?,?,?)");
                    queryParams.addAll(queryModel.getLbtAccList());
                }
                
            }else {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    queryParams.addAll(queryModel.getTxjdAccList());
                }
            }

        } else if((queryModel.getEquipType().toString()).equals("传输设备及通讯线路")) {
            if(queryModel.getOptType().equals("dcpCheck")
                    || queryModel.getOptType().equals("")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?,?,?)");
                    queryParams.addAll(queryModel.getDcpList());
                }
            }else if(queryModel.getOptType().equalsIgnoreCase("oticalCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?,?,?,?,?)");
                    queryParams.addAll(queryModel.getOticalList());
                }
            
            }else if(queryModel.getOptType().equalsIgnoreCase("zjOticalCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?) ");
                    queryParams.addAll(queryModel.getZjOticalList());
                }
                
            }else if(queryModel.getOptType().equalsIgnoreCase("txjdOticalCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?,?,?)");
                    queryParams.addAll(queryModel.getTxjdOticalList());
                }
                
            }else if(queryModel.getOptType().equalsIgnoreCase("ddnCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?) ");
                    queryParams.addAll(queryModel.getDdnList());
                }
            }else if(queryModel.getOptType().equalsIgnoreCase("nccCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?) ");
                    queryParams.addAll(queryModel.getNccList());
                }
            }else if(queryModel.getOptType().equalsIgnoreCase("slhPdsCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?) ");
                    queryParams.addAll(queryModel.getSlhPdsList());
                }
            }else if(queryModel.getOptType().equalsIgnoreCase("txjdPdsCheck")) {
                if (StringUtils.isNotEmpty(queryModel.getName())) {
                    hql.append(" and u.name like ? escape '\\' ");
                    queryParams.add(queryModel.getName());
                } else {
                    hql.append(" and u.name in(?) ");
                    queryParams.addAll(queryModel.getTxjdPdsList());
                }
            }
        }

        // 操作人
        if (StringUtils.isNotEmpty(queryModel.getOperator())) {
            hql.append(" and u.operator.name like ? escape '\\' ");
            queryParams.add("%"+queryModel.getOperator()+"%");
        }
        // 按日期查找
        if (!ObjectUtils.equals(queryModel.getCheckDate(), null)) {
            hql.append(" and u.checkDate = ? ");
            queryParams.add(queryModel.getCheckDate());
        }
        // 起始时间
        if (!ObjectUtils.equals(queryModel.getStartTime(), null)) {
            hql.append(" and u.checkTime >= ? ");
            queryParams.add(queryModel.getStartTime());
        }
        // 结束时间
        if (!ObjectUtils.equals(queryModel.getEndTime(), null)) {
            hql.append(" and u.checkTime <= ? ");
            queryParams.add(queryModel.getEndTime());
        }
        // 根据checkTime降序排序
        hql.append(" order by u.checkTime desc");
        String countHql = BaseDaoHibernateImpl.COUNT_ID + hql.toString();
        return super.pageQuery(hql.toString(), queryParams.toArray(), countHql,
                queryModel.getPageNo(), queryModel.getPageSize());
    }


	@SuppressWarnings("unchecked")
	@Override
	public List<EnvironmentEquipCheck> queryListByModel(EnvironmentCheckQueryModel queryModel) {
		StringBuffer hql = new StringBuffer("from EnvironmentEquipCheck u where 1=1");
		List<Object> queryParams = new ArrayList<Object>();
		//设备名称
		if(StringUtils.isNotEmpty(queryModel.getName())) {
			hql.append(" and u.name like ? escape '\\' ");
			queryParams.add(queryModel.getName());
		}
		//操作人
		if(StringUtils.isNotEmpty(queryModel.getOperator())) {
			hql.append(" and u.operator.name like ? escape '\\' ");
			queryParams.add(queryModel.getOperator());
		}
		//起始时间
		if(!ObjectUtils.equals(queryModel.getStartTime(), null)){
			hql.append(" and u.checkTime >= ? ");
			queryParams.add(queryModel.getStartTime());
		}
		//结束时间
		if(!ObjectUtils.equals(queryModel.getEndTime(), null)){
			hql.append(" and u.checkTime <= ? ");
			queryParams.add(queryModel.getEndTime());
		}
		//按日期查找
		if(!ObjectUtils.equals(queryModel.getCheckDate(), null)){
			hql.append(" and u.checkDate = ?");
			queryParams.add(queryModel.getCheckDate());
		}
		return  (List<EnvironmentEquipCheck>) super.queryList(hql.toString(), queryParams.toArray());
	}
	
	@Override
	public List<UpsContentCheck> upsContentCheckList(EnvironmentCheckQueryModel queryModel){
		@SuppressWarnings("unchecked")
		List<EnvironmentEquipCheck> list=(List<EnvironmentEquipCheck>) this.queryPageByModel(queryModel);
		List<UpsContentCheck> uccList=new ArrayList<UpsContentCheck>();
		for(EnvironmentEquipCheck u : list){
			StringBuilder hql=new StringBuilder("from UpsContentCheck u where 1=1");
			List<Object> params=new ArrayList<Object>(); 
			if(!ObjectUtils.equals(u, null)){
				hql.append(" and u.upsCheck = ?");
				params.add(u);
			}
			UpsContentCheck ucc=(UpsContentCheck) super.queryList(hql.toString(), params.toArray());
			uccList.add(ucc);
		}
		return uccList;
	}
}
