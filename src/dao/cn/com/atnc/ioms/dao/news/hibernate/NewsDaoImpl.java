package cn.com.atnc.ioms.dao.news.hibernate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.news.INewsDao;
import cn.com.atnc.ioms.entity.news.News;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
import cn.com.atnc.ioms.model.news.NewsQueryModel;

@Repository("newsDao")
public class NewsDaoImpl extends MyBaseDao<News> implements INewsDao {
    SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat eqDate = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public Pagination queryPage(NewsQueryModel qm) {
        // TODO 通知公告分页
        StringBuffer hql = new StringBuffer(" from News where 1=1 ");
        List<Object> params = new ArrayList<Object>();
        if(qm.getUser()!=null){
            hql.append(" and createUser.loginName = ?");
            params.add(qm.getUser().getLoginName());
        }
        if(!StringUtils.isEmpty(qm.getSubmitUserNameEq())){
            hql.append(" and (createUser.loginName like ? escape '\t'");
            hql.append(" or createUser.name like ? escape '\t')");
            String name = qm.getSubmitUserNameEq();
            name = name.replace("%", "\\t%");
            name = name.replace("_", "\\t_");
            params.add("%"+name+"%");
            params.add("%"+name+"%");
        }
        if(!StringUtils.isEmpty(qm.getTitleLike())){
            hql.append(" and title like ? escape '\t'");
            String titlelike = qm.getTitleLike();
            titlelike = titlelike.replace("%", "\\t%");
            titlelike = titlelike.replace("_", "\\t_");
            params.add("%"+titlelike+"%");
        }
        if(qm.getColumnEq()!=null && !StringUtils.isEmpty(qm.getColumnEq().getValue())){
            hql.append(" and columns = ?");
            params.add(qm.getColumnEq());
        }
        if(qm.getStatusEq()!=null && !StringUtils.isEmpty(qm.getStatusEq().getValue())){
            hql.append(" and status = ?");
            params.add(qm.getStatusEq());
        }
        if(qm.getStatusSearchEq()!=null && !StringUtils.isEmpty(qm.getStatusSearchEq().getValue())){
            hql.append(" and status = ?");
            params.add(qm.getStatusSearchEq());
        }
        if(qm.getNotInStatusEq()!=null && qm.getNotInStatusEq().length>0){
            hql.append(" and status ");
            hql.append(" not in(");

            for(int i=0;i<qm.getNotInStatusEq().length;i++){
                hql.append("?");
                if(i<qm.getNotInStatusEq().length-1){
                    hql.append(",");
                }
            }
            hql.append(")");
            for(NewsStatusEnum nse:qm.getNotInStatusEq()){
                params.add(nse);
            }
        }
        if(qm.getInStatusEq()!=null && qm.getInStatusEq().length>0){
            hql.append(" and status ");
            hql.append(" in(");

            for(int i=0;i<qm.getInStatusEq().length;i++){
                hql.append("?");
                if(i<qm.getInStatusEq().length-1){
                    hql.append(",");
                }
            }
            hql.append(")");
            for(NewsStatusEnum nse:qm.getInStatusEq()){
                params.add(nse);
            }
        }
        
        if(!StringUtils.isEmpty(qm.getStartCreateTime())){
            hql.append(" and publishTime>=?");
            try {
                params.add(startDate.parse(qm.getStartCreateTime()+" 00:00:00"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!StringUtils.isEmpty(qm.getEndCreateTime())){
            hql.append(" and publishTime<=?");
            try {
                params.add(endDate.parse(qm.getEndCreateTime()+" 23:59:59"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        
        hql.append(" order by publishTime desc");
        String countHql = super.COUNT_ID + hql.toString();

        return super.pageQuery(hql.toString(),params.toArray(),countHql,qm.getPageNo(), qm.getPageSize());
    }
    protected int pageSqlQueryCount(String sql,String countsql,List<Object[]> params, int pageNumber, int pageSize){
        Session session = this.getSession();
        try{
            org.hibernate.type.Type[] pt = new org.hibernate.type.Type[params.size()];
            Object[] po = new Object[params.size()];
            if(params!=null && params.size()>0){
                int i=0;
                for(Object[] objs:params){
                    po[i] = objs[0];
                    pt[i] = (org.hibernate.type.Type) objs[1];
                    i++;
                }
            }
            Query queryCount = session.createSQLQuery(countsql);
            if(params!=null && params.size()>0){
                queryCount.setParameters(po, pt);
            }
            BigDecimal ret = (BigDecimal) queryCount.uniqueResult();
            return ret.intValue();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
        return 0;
    }
    
    protected Pagination pageSqlQuery(String sql,String countsql,List<Object[]> params, int pageNumber, int pageSize)
    {
        
        Pagination pagination = new Pagination();
        org.hibernate.type.Type[] pt = new org.hibernate.type.Type[params.size()];
        Object[] po = new Object[params.size()];
        if(params!=null && params.size()>0){
            int i=0;
            for(Object[] objs:params){
                po[i] = objs[0];
                pt[i] = (org.hibernate.type.Type) objs[1];
                i++;
            }
        }
        int countvalue = pageSqlQueryCount(sql, countsql, params, pageNumber, pageSize);
        
        Session session = this.getSession();
        try{
            long count = Pagination.getPageCount(countvalue, pageSize);
            pageNumber = (int)((long)pageNumber <= count ? pageNumber : count);
            Query query = session.createSQLQuery(sql).addEntity(News.class);
            if(params!=null && params.size()>0){
                query.setParameters(po, pt);
            }
            query.setFirstResult((pageNumber-1)*pageSize);
            query.setMaxResults(pageSize);
            pagination.setTotalCount(countvalue);
            pagination.setResult(query.list());
            pagination.setCurrentPage(pageNumber);
            pagination.setPageSize(pageSize);
            pagination.setPageCount(count);
            return pagination;
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
        return null;
    }
    
    public int getFlowNum(String userId,NewsStatusEnum[] newsStatus)
    {
        Session session = this.getSession();
        try{
            StringBuffer sql = new StringBuffer("from TB_OM_PN_NOTICE notice ");
            sql.append("inner join ACT_RU_TASK task on notice.PROCESS_INSTANCE_ID=task.PROC_INST_ID_ ");
            sql.append("inner join ACT_RU_IDENTITYLINK tlink on tlink.TASK_ID_ = task.ID_ ");
            sql.append("inner join ACT_ID_MEMBERSHIP ship on ship.GROUP_ID_ = tlink.GROUP_ID_ ");
            sql.append(" where ship.USER_ID_ = ?");
            List<Object[]> params = new ArrayList<Object[]>();
            params.add(new Object[]{userId,StandardBasicTypes.STRING});
    
            if(newsStatus!=null && newsStatus.length>0){
                sql.append(" and notice.status ");
                sql.append(" in(");
                for(int i=0;i<newsStatus.length;i++){
                    sql.append("?");
                    if(i<newsStatus.length-1){
                        sql.append(",");
                    }
                }
                sql.append(")");
                for(NewsStatusEnum nse:newsStatus){
                    params.add(new Object[]{nse.name(),StandardBasicTypes.STRING});
                }
            }
            String countsql = "select count(notice.id) as count "+sql.toString();
            Object[] po = new Object[params.size()];
            org.hibernate.type.Type[] pt = new org.hibernate.type.Type[params.size()];
            if(params!=null && params.size()>0){
                int i=0;
                for(Object[] objs:params){
                    po[i] = objs[0];
                    pt[i] = (org.hibernate.type.Type) objs[1];
                    i++;
                }
            }
            Query queryCount = session.createSQLQuery(countsql);
            if(params!=null && params.size()>0){
                queryCount.setParameters(po, pt);
            }
            BigDecimal ret = (BigDecimal) queryCount.uniqueResult();
            return ret.intValue();
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            session.close();
        }
        return 0;
    }
    public Pagination queryFlowPage(NewsQueryModel qm) {
        // TODO 通知公告分页
        StringBuffer hql = new StringBuffer("from TB_OM_PN_NOTICE notice ");
        hql.append("inner join ACT_RU_TASK task on notice.PROCESS_INSTANCE_ID=task.PROC_INST_ID_ ");
        hql.append("inner join ACT_RU_IDENTITYLINK tlink on tlink.TASK_ID_ = task.ID_ ");
        hql.append("inner join ACT_ID_MEMBERSHIP ship on ship.GROUP_ID_ = tlink.GROUP_ID_ ");
        
        hql.append(" where 1=1 ");
        List<Object[]> params = new ArrayList<Object[]>();
        
        if(qm.getUser()!=null){
            hql.append(" and ship.USER_ID_ = ?");
            params.add(new Object[]{qm.getUser().getId(),StandardBasicTypes.STRING});
        }
        if(!StringUtils.isEmpty(qm.getTitleLike())){
            hql.append(" and notice.title like ? escape '\t'");
            String titlelike = qm.getTitleLike();
            titlelike = titlelike.replace("%", "\\t%");
            titlelike = titlelike.replace("_", "\\t_");
            params.add(new Object[]{"%"+titlelike+"%",StandardBasicTypes.STRING});
        }
        if(qm.getColumnEq()!=null && !StringUtils.isEmpty(qm.getColumnEq().getValue())){
            hql.append(" and notice.columns = ?");
            params.add(new Object[]{qm.getColumnEq().name(),StandardBasicTypes.STRING});
        }
        if(qm.getStatusEq()!=null && !StringUtils.isEmpty(qm.getStatusEq().getValue())){
            hql.append(" and notice.status = ?");
            params.add(new Object[]{qm.getStatusEq().name(),StandardBasicTypes.STRING});
        }
        if(qm.getStatusSearchEq()!=null && !StringUtils.isEmpty(qm.getStatusSearchEq().getValue())){
            hql.append(" and notice.status = ?");
            params.add(new Object[]{qm.getStatusSearchEq().name(),StandardBasicTypes.STRING});
        }
        if(qm.getInStatusEq()!=null && qm.getInStatusEq().length>0){
            hql.append(" and notice.status ");
            hql.append(" in(");
            for(int i=0;i<qm.getInStatusEq().length;i++){
                hql.append("?");
                if(i<qm.getInStatusEq().length-1){
                    hql.append(",");
                }
            }
            hql.append(")");
            for(NewsStatusEnum nse:qm.getInStatusEq()){
                params.add(new Object[]{nse.name(),StandardBasicTypes.STRING});
            }
        }

        if(!StringUtils.isEmpty(qm.getStartCreateTime()) && StringUtils.isEmpty(qm.getEndCreateTime())){
            hql.append(" and notice.PUBLISH_TIME>=?");
            try {
                params.add(new Object[]{startDate.parse(qm.getStartCreateTime()+" 00:00:00"),StandardBasicTypes.DATE});
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!StringUtils.isEmpty(qm.getEndCreateTime()) && StringUtils.isEmpty(qm.getStartCreateTime())){
            hql.append(" and notice.PUBLISH_TIME<=?");
            try {
                params.add(new Object[]{endDate.parse(qm.getEndCreateTime()+" 23:59:59"),StandardBasicTypes.DATE});
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!StringUtils.isEmpty(qm.getStartCreateTime()) && !StringUtils.isEmpty(qm.getStartCreateTime()) &&
                qm.getStartCreateTime().equals(qm.getStartCreateTime()) ){
            hql.append(" and to_char(notice.PUBLISH_TIME,'yyyy-mm-dd')=?");
            params.add(new Object[]{qm.getStartCreateTime(),StandardBasicTypes.STRING});
        }
        
        hql.append(" order by notice.PUBLISH_TIME desc");
        String countHql = "select count(notice.id) as count "+hql.toString();
        String sql = "select notice.* "+hql.toString();
        return pageSqlQuery(sql,countHql,params, qm.getPageNo(), qm.getPageSize());
                
    }
    /*    
    select notice.* from 
    TB_OM_PN_NOTICE notice
    inner join ACT_RU_TASK task on notice.PROCESS_INSTANCE_ID=task.PROC_INST_ID_
    inner join ACT_RU_IDENTITYLINK tlink on tlink.TASK_ID_ = task.ID_
    inner join act_id_membership ship on ship.GROUP_ID_ = tlink.GROUP_ID_

    where ship.USER_ID_='1f9c9e8853744749bcb972bf5951fae9'
    ;*/

}
