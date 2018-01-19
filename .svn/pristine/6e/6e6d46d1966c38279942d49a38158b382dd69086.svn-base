/* Copyright ? 2014 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2014-4-17 上午10:58:27
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.dao.basedata.tes.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTxPowerLogDao;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerLog;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;

/**
 * @author:HuangYijie
 * @date:2014-4-17 上午10:58:27
 * @version:1.0
 */
@Repository("resTxPowerLogDao")
public class TesTxPowerLogDaoImpl extends MyBaseDao<TesTxPowerLog> implements
		ITesTxPowerLogDao {

    SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public Pagination queryPage(TesStatQueryModel queryModel) {
        StringBuilder hql = new StringBuilder("from TesTxPowerLog where 1=1");
        Map<String, Object> params = new HashMap<String, Object>();

        if (!StringUtils.isEmpty(queryModel.getCu())) {
            hql.append(" and tesSlot.cu =:cu");
            params.put("cu", queryModel.getCu());
        }

        if (!StringUtils.isEmpty(queryModel.getTesnode())) {
            hql.append(" and tesSlot.tesNode.tesNodeCode =:nodecode");
            params.put("nodecode", queryModel.getTesnode());
        }
        if(!StringUtils.isEmpty(queryModel.getStartStatTime())){
            hql.append(" and recordTime>=:recordStartTime");
            try {
                Calendar start = new GregorianCalendar();
                if(queryModel.getStartStatTime().length()==19){
                    start.setTime(startDate.parse(queryModel.getStartStatTime()));
                }else{
                    start.setTime(startDate.parse(queryModel.getStartStatTime()+" 00:00:00"));
                }
                params.put("recordStartTime",start);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!StringUtils.isEmpty(queryModel.getEndStatTime())){
            hql.append(" and recordTime<=:recordEndTime");
            try {
                Calendar end = new GregorianCalendar();
                if(queryModel.getEndStatTime().length()==19){
                    end.setTime(endDate.parse(queryModel.getEndStatTime()));
                }else{
                    end.setTime(endDate.parse(queryModel.getEndStatTime()+" 23:59:59"));
                }
                params.put("recordEndTime",end);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String countHql = COUNT_ID + hql.toString();
        hql.append(" order by recordTime desc,tesSlot.tesNode.tesNodeCode,tesSlot.cu");
        return super.pageQuery(hql.toString(), params, countHql,
                queryModel.getPageNo(), queryModel.getPageSize());
    }
}
