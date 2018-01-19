package cn.com.atnc.ioms.dao.operstat.tes.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.operstat.tes.ITesTxPowerDao;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPower;
import cn.com.atnc.ioms.model.operstat.tes.TesTxPowerQueryModel;

@Repository("tesTxPowerDaoImpl")
public class TesTxPowerDaoImpl extends MyBaseDao<TesTxPower> implements ITesTxPowerDao {
    SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Long findTesPower(String tesNodeCode,String cu,String statid){
        List<Object> params = new ArrayList<Object>();
        params.add(tesNodeCode);
        params.add(cu);
        params.add(statid);
        return super.querySize("select count(id) from TesTxPower where tesSlot.tesNode.tesNodeCode=? and tesSlot.cu=? and tesStat.id=?",params.toArray());
    }
    
    public Pagination queryPage(TesTxPowerQueryModel qm) {
        StringBuffer hql = new StringBuffer(" from TesTxPower where 1=1 ");
        List<Object> params = new ArrayList<Object>();
        if (qm.getStat() != null) {
            hql.append(" and tesStat.id=?");
            params.add(qm.getStat().getId());
        }
        if(!StringUtils.isEmpty(qm.getTesNode())){
            hql.append(" and tesSlot.tesNode.tesNodeCode=?");
            params.add(qm.getTesNode());
        }
        if(!StringUtils.isEmpty(qm.getTesSlot())){
            hql.append(" and tesSlot.cu=?");
            params.add(qm.getTesSlot());
        }
        if (!StringUtils.isEmpty(qm.getStartRecordTime())) {
            hql.append(" and recordTime>=?");
            try {
                params.add(startDate.parse(qm.getStartRecordTime() + " 00:00:00"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isEmpty(qm.getEndRecordTime())) {
            hql.append(" and recordTime<=?");
            try {
                params.add(endDate.parse(qm.getEndRecordTime() + " 23:59:59"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        hql.append(" order by recordTime desc");
        String countHql = super.COUNT_ID + hql.toString();
        return super.pageQuery(hql.toString(), params.toArray(), countHql, qm.getPageNo(), qm.getPageSize());
    }
}
