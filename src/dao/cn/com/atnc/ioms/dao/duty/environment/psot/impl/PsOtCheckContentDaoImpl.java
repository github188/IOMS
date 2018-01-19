package cn.com.atnc.ioms.dao.duty.environment.psot.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.ioms.dao.duty.environment.psot.PsOtCheckContentDao;
import cn.com.atnc.ioms.entity.duty.environment.psot.PsOtCheckContent;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentEquipCheckQueryModel;
import cn.com.atnc.sample.dao.MyBaseDao;
@Repository("PsOtCheckContent")
public class PsOtCheckContentDaoImpl extends MyBaseDao<PsOtCheckContent>
        implements PsOtCheckContentDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<PsOtCheckContent> queryByModel(
            EnvironmentEquipCheckQueryModel queryModel) {
        StringBuilder hql = new StringBuilder("from PsOtCheckContent p where 1=1");
        List<Object> params = new ArrayList<Object>();
        if(!ObjectUtils.equals(queryModel.getEeCheck(), null)) {
            hql.append(" and p.psOtCheck = ? ");
            params.add(queryModel.getEeCheck());
        }
        
        return (List<PsOtCheckContent>) super.queryList(hql.toString(), params.toArray());
    }

}
