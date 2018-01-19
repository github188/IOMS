package cn.com.atnc.ioms.dao.news.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.news.INewsOptlogDao;
import cn.com.atnc.ioms.entity.news.NewsOptlog;
import cn.com.atnc.ioms.enums.news.NewsStatusEnum;
import cn.com.atnc.ioms.model.news.NewsOptLogQueryModel;
import cn.com.atnc.ioms.model.news.NewsQueryModel;

@Repository("newsOptlogDaoImpl")
public class NewsOptlogDaoImpl extends MyBaseDao<NewsOptlog> implements INewsOptlogDao{
    @Override
    @SuppressWarnings("unchecked")
    public NewsOptlog findLastTimeById(String id) {
        List<NewsOptlog> list = (List<NewsOptlog>) super.queryList(
                "from NewsOptlog where news.id = ? order by optTime desc limit 0,1", id);
        if(!list.isEmpty()){
            return list.size() > 0 ? list.get(0) : null;
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<NewsOptlog> findListById(String id) {
        return (List<NewsOptlog>) this.queryList("from NewsOptlog where news.id=? order by optTime asc", id);
    }

    SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public Pagination queryPage(NewsOptLogQueryModel qm) {
        // TODO 通知公告分页
        StringBuffer hql = new StringBuffer(" from NewsOptlog where 1=1 ");
        List<Object> params = new ArrayList<Object>();
        
        if(StringUtils.isNotEmpty(qm.getOptUserEq())){
            hql.append(" and (optUser.loginName like ? escape '\t'");
            hql.append(" or optUser.name like ? escape '\t')");
            String name = qm.getOptUserEq();
            name = name.replace("%", "\\t%");
            name = name.replace("_", "\\t_");
            params.add("%"+name+"%");
            params.add("%"+name+"%");
        }
        if(StringUtils.isNotEmpty(qm.getCreateUserEq())){
            hql.append(" and news.createUser.loginName like ? escape '\t'");
            hql.append(" or news.createUser.name like ? escape '\t'");
            String name = qm.getCreateUserEq();
            name = name.replace("%", "\\t%");
            name = name.replace("_", "\\t_");
            params.add("%"+name+"%");
            params.add("%"+name+"%");
        }
        if(qm.getColumnsEq()!=null){
            hql.append(" and news.columns=?");
            params.add(qm.getColumnsEq());
        }
        if(qm.getStatusEq()!=null && !StringUtils.isEmpty(qm.getStatusEq().getValue())){
            hql.append(" and newsStatusEnum = ?");
            params.add(qm.getStatusEq());
        }
        if(qm.getInStatusEq()!=null && qm.getInStatusEq().length>0){
            hql.append(" and newsStatusEnum ");
            hql.append("not in(");

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

        if(!StringUtils.isEmpty(qm.getStartOptTime())){
            hql.append(" and optTime>=?");
            try {
                params.add(startDate.parse(qm.getStartOptTime()+" 00:00:00"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!StringUtils.isEmpty(qm.getEndOptTime())){
            hql.append(" and optTime<=?");
            try {
                params.add(endDate.parse(qm.getEndOptTime()+" 23:59:59"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        hql.append(" order by optTime desc ");
        String countHql = super.COUNT_ID + hql.toString();
        
        return super.pageQuery(hql.toString(),params.toArray(),countHql,qm.getPageNo(), qm.getPageSize());
    }
    @Override
    public Pagination queryPage(NewsQueryModel qm) {
        // TODO 通知公告分页
        
        StringBuffer hql = new StringBuffer(" from NewsOptlog where 1=1 ");
        List<Object> params = new ArrayList<Object>();

        if(!StringUtils.isEmpty(qm.getTitleLike())){
            hql.append(" and news.title like ? escape '\t'");
            String titlelike = qm.getTitleLike();
            titlelike = titlelike.replace("%", "\\t%");
            titlelike = titlelike.replace("_", "\\t_");
            params.add("%"+titlelike+"%");
        }
		if(StringUtils.isNotEmpty(qm.getOptUserEq())){
            hql.append(" and (optUser.loginName like ? escape '\t'");
            hql.append(" or optUser.name like ? escape '\t')");
            String name = qm.getOptUserEq();
            name = name.replace("%", "\\t%");
            name = name.replace("_", "\\t_");
            params.add("%"+name+"%");
            params.add("%"+name+"%");
        }
        if(StringUtils.isNotEmpty(qm.getCreateUserEq())){
            hql.append(" and news.createUser.loginName like ? escape '\t'");
            hql.append(" and news.createUser.name like ? escape '\t'");
            String name = qm.getCreateUserEq();
            name = name.replace("%", "\\t%");
            name = name.replace("_", "\\t_");
            params.add("%"+name+"%");
            params.add("%"+name+"%");
        }
        if(qm.getColumnsEq()!=null){
            hql.append(" and news.columns=?");
            params.add(qm.getColumnsEq());
        }
        if(qm.getStatusEq()!=null && !StringUtils.isEmpty(qm.getStatusEq().getValue())){
            hql.append(" and newsStatusEnum = ?");
            params.add(qm.getStatusEq());
        }
        if(qm.getInStatusEq()!=null && qm.getInStatusEq().length>0){
            hql.append(" and newsStatusEnum ");
            hql.append("not in(");

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

        if(!StringUtils.isEmpty(qm.getStartOptTime())){
            hql.append(" and optTime>=?");
            try {
                params.add(startDate.parse(qm.getStartOptTime()+" 00:00:00"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if(!StringUtils.isEmpty(qm.getEndOptTime())){
            hql.append(" and optTime<=?");
            try {
                params.add(endDate.parse(qm.getEndOptTime()+" 23:59:59"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        hql.append(" order by optTime desc ");
        String countHql = super.COUNT_ID + hql.toString();

        return super.pageQuery(hql.toString(),params.toArray(),countHql,qm.getPageNo(), qm.getPageSize());
    }
}
