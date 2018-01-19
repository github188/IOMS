package cn.com.atnc.ioms.dao.operstat.tes.hibernate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.Finishings;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.MyBaseDao;
import cn.com.atnc.ioms.dao.operstat.tes.ITesStatDao;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerStat;
import cn.com.atnc.ioms.entity.operstat.tes.TesStat;
import cn.com.atnc.ioms.enums.basedata.Bureau;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesTxPowerQueryModel;

@Repository("tesStatDao")
public class TesStatDaoImpl extends MyBaseDao<TesTxPowerStat> implements
		ITesStatDao {
	SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Pagination queryPage(TesStatQueryModel qm) {
		StringBuffer hql = new StringBuffer(" from TesTxPowerStat where 1=1 ");
		List<Object> params = new ArrayList<Object>();

		if (!StringUtils.isEmpty(qm.getStartStatTime())) {
			hql.append(" and statDate>=?");
			try {
	            Calendar start = new GregorianCalendar();
	            start.setTime(startDate.parse(qm.getStartStatTime() + " 00:00:00"));
				params.add(start);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!StringUtils.isEmpty(qm.getEndStatTime())) {
			hql.append(" and statDate<=?");
			try {
                Calendar end = new GregorianCalendar();
                end.setTime(endDate.parse(qm.getEndStatTime() + " 23:59:59"));
				params.add(end);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		hql.append(" order by statDate desc");
		String countHql = super.COUNT_ID + hql.toString();
		return super.pageQuery(hql.toString(), params.toArray(), countHql,
				qm.getPageNo(), qm.getPageSize());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TesTxPowerStat> findlist(TesStatQueryModel qm) {
	    Session session = this.getSession();
		StringBuffer hql = new StringBuffer(" from TesTxPowerStat where 1=1 ");
		List<Object> params = new ArrayList<Object>();

		if (!StringUtils.isEmpty(qm.getStartStatTime())) {
			hql.append(" and statDate>=?");
			try {
                Calendar start = new GregorianCalendar();
                start.setTime(startDate.parse(qm.getStartStatTime() + " 00:00:00"));
                params.add(start);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (!StringUtils.isEmpty(qm.getEndStatTime())) {
			hql.append(" and statDate<=?");
			try {
                Calendar end = new GregorianCalendar();
                end.setTime(endDate.parse(qm.getEndStatTime() + " 23:59:59"));
                params.add(end);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		hql.append(" order by statDate desc");
		try{
	        Query query = session.createQuery(hql.toString());
	        Object[] values = params.toArray();
	        for (int i = 0; i < values.length; i++)
	            query.setParameter(i, values[i]);
	        if(qm.getPageSize()==0){
	            query.setFirstResult(0);
	            query.setMaxResults(10);
	        }else{
	            query.setFirstResult(0);
	            query.setMaxResults(qm.getPageSize());
	        }
	        return (List<TesTxPowerStat>) query.list();
		}catch (Exception e) {
            // TODO: handle exception
        }finally{
            session.close();
        }
		return null;
	}

	/*
	 * select equip.CODE,node.CHASSIS,slot.CU,nvl(tp.POWER,'正常'),slot.INFO from
	 * TB_BD_TES_SLOT slot left OUTER join TB_BD_TES_TXPOWER tp on slot.ID =
	 * tp.TES_SLOT_ID inner join TB_BD_TES_TXPOWER_STAT stat on stat.ID =
	 * tp.TES_STAT_ID inner join TB_BD_TES_NODE node on node.ID=
	 * slot.TES_NODE_ID inner join TB_BD_EQUIP equip on equip.ID=node.EQUIP_ID
	 * where stat.ID='e8a959f1295e4b6f8a97b8edc639c8a6'
	 */

	public Pagination querySQLPage(TesTxPowerQueryModel qm) {
		
	    StringBuffer hql = new StringBuffer("");
        hql.append("from ( ");
        hql.append("select ");
        hql.append("equip.BUREAU as BUREAU,");
        hql.append("site.BUREAU as BUREAU1,");
        hql.append("site.SITE_NAME as CODE,");
        hql.append("node.NODE_CODE as CHASSIS,");
        hql.append("slot.CU as CU,");
        hql.append("tp.POWER as POWER,");
        hql.append("slot.INFO as INFO,");
        hql.append("slot.OCC,");
        hql.append("stat.STAT_DATE as STATDATE, ");
        hql.append("equip.ID as EQUIPID ");
        hql.append("from TB_BD_EQUIP equip ");
        hql.append("left join TB_BD_SATELLITE_SITE site on site.ID=equip.SATELLITE_ID ");
        hql.append("left join TB_BD_TES_NODE node on equip.ID=node.EQUIP_ID ");
        hql.append("left join TB_BD_TES_SLOT slot on node.ID= slot.TES_NODE_ID ");
        hql.append("left join TB_BD_TES_TXPOWER tp on slot.ID = tp.TES_SLOT_ID ");
        hql.append("left join TB_BD_TES_TXPOWER_STAT stat on stat.ID = tp.TES_STAT_ID ");
        hql.append("where equip.type='TES' ");
        hql.append("and stat.ID=? ");
        hql.append("union ");
        hql.append("select ");
        hql.append("equip.BUREAU as BUREAU,");
        hql.append("site.BUREAU as BUREAU1,");
        hql.append("site.SITE_NAME as CODE,");
        hql.append("node.NODE_CODE as CHASSIS,");
        hql.append("slot.CU as CU,");
        hql.append("null as POWER,");
        hql.append("slot.INFO as INFO,");
        hql.append("slot.OCC,");
        hql.append("null as STATDATE, ");
        hql.append("equip.ID as EQUIPID ");
        hql.append("from TB_BD_EQUIP equip ");
        hql.append("left join TB_BD_SATELLITE_SITE site on site.ID=equip.SATELLITE_ID ");
        hql.append("left join TB_BD_TES_NODE node on equip.ID=node.EQUIP_ID ");
        hql.append("left join TB_BD_TES_SLOT slot on node.ID= slot.TES_NODE_ID ");
        hql.append("where equip.type='TES' ");
        hql.append(") where 1=1 and CHASSIS is not null and CU is not null ");
	    
		List<Object[]> params = new ArrayList<Object[]>();
		params.add(new Object[] { qm.getStatid(), StandardBasicTypes.STRING });

		if(!StringUtils.isEmpty(qm.getTesNode())){
		    hql.append(" and CHASSIS=?"); 
		    params.add(new Object[]{qm.getTesNode(),StandardBasicTypes.STRING}); 
		}
        if(!StringUtils.isEmpty(qm.getTesSlot())){
            hql.append(" and CU=?"); 
            params.add(new Object[]{qm.getTesSlot(),StandardBasicTypes.STRING}); 
        }
        if(!StringUtils.isEmpty(qm.getBureau())){
            hql.append(" and BUREAU=?"); 
            params.add(new Object[]{qm.getBureau(),StandardBasicTypes.STRING}); 
        }
//		
//		String countHql = "select count(*) from TB_BD_EQUIP equip "+
//                            "left join TB_BD_SATELLITE_SITE site on site.ID=equip.SATELLITE_ID "+
//                            "left join TB_BD_TES_NODE node on equip.ID=node.EQUIP_ID "+
//                            "left join TB_BD_TES_SLOT slot on node.ID= slot.TES_NODE_ID where equip.type='TES' "+
//                            "and 1=1 and node.NODE_CODE is not null and slot.CU is not null";

        String countHql = "select count(*)over() as count "+hql.toString()+" group by BUREAU,CODE,CHASSIS,CU,INFO,OCC,EQUIPID order by CHASSIS,CU";
        String sql = "select BUREAU,CODE,CHASSIS,CU,nvl(max(POWER),'正常') as POWER,INFO,OCC,max(STATDATE),EQUIPID "+
                        hql.toString()+
                     " group by BUREAU,CODE,CHASSIS,CU,INFO,OCC,EQUIPID order by CHASSIS,CU";
        
		return pageSqlQuery(sql, countHql, params, qm.getPageNo(),
				qm.getPageSize());
	}

	public Map<String, Integer> tesSlotWarningList() {
        Session session = this.getSession();
		StringBuffer hql = new StringBuffer("from TB_BD_TES_SLOT slot ");
		hql.append("inner join TB_BD_TES_TXPOWER tp on slot.ID = tp.TES_SLOT_ID ");
		hql.append("inner join TB_BD_TES_TXPOWER_STAT stat on stat.ID = tp.TES_STAT_ID ");
		hql.append("inner join TB_BD_TES_NODE node on node.ID= slot.TES_NODE_ID ");
		hql.append("inner join TB_BD_EQUIP equip on equip.ID=node.EQUIP_ID ");
		hql.append("where stat.ID = (select ID from (select tts.ID,rownum from TB_BD_TES_TXPOWER_STAT tts ORDER BY tts.STAT_DATE desc) where ROWNUM>0 and ROWNUM<2)");
		String countsql = "select  equip.BUREAU as bureau, count(slot.id) as count "
				+ hql.toString() + " group by equip.BUREAU ";

		Query queryCount = session.createSQLQuery(countsql);

		Map<String, Integer> map = new HashMap<>();
		Iterator<?> it = queryCount.list().iterator();
        while (it.hasNext()) {
            Object[] object = (Object[]) it.next();
            if (object[0] != null) {
                map.put(object[0].toString(), object[1] != null ? Integer.parseInt(object[1].toString()) : 0);
            }
        }
        session.close();
        return map;
	}

    protected int pageSqlQueryCount(String sql, String countsql,
            List<Object[]> params, int pageNumber, int pageSize) {
        Session session = this.getSession();
        Object[] po = new Object[params.size()];
        org.hibernate.type.Type[] pt = new org.hibernate.type.Type[params.size()];
        if (params != null && params.size() > 0) {
            int i = 0;
            for (Object[] objs : params) {
                po[i] = objs[0];
                pt[i] = (org.hibernate.type.Type) objs[1];
                i++;
            }
        }
        Query queryCount = session.createSQLQuery(countsql);
        if (params != null && params.size() > 0) {
            queryCount.setParameters(po, pt);
        }
        BigDecimal ret = (BigDecimal) queryCount.list().get(0);
        session.close();
        return ret.intValue();
    }
	protected Pagination pageSqlQuery(String sql, String countsql,
			List<Object[]> params, int pageNumber, int pageSize) {
        Session session = this.getSession();
		Object[] po = new Object[params.size()];
		org.hibernate.type.Type[] pt = new org.hibernate.type.Type[params.size()];
		if (params != null && params.size() > 0) {
			int i = 0;
			for (Object[] objs : params) {
				po[i] = objs[0];
				pt[i] = (org.hibernate.type.Type) objs[1];
				i++;
			}
		}
		Pagination pagination = new Pagination();
		int countvalue = pageSqlQueryCount(sql, countsql, params, pageNumber, pageSize);
		long count = Pagination.getPageCount(countvalue, pageSize);
		pageNumber = (int) ((long) pageNumber <= count ? pageNumber : count);

		Query query = session.createSQLQuery(sql);// .addEntity(TesStat.class);
		if (params != null && params.size() > 0) {
			query.setParameters(po, pt);
		}
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);

		List<TesStat> list = new ArrayList<>();
		if (query.list() != null) {
			Iterator<?> it = query.list().iterator();
			while (it.hasNext()) {
				Object[] object = (Object[]) it.next();
				TesStat stat = new TesStat();
				stat.setBureau(Bureau.getBureauByValue(object[0] == null ? "" : object[0].toString()));
				stat.setCode(object[1] == null ? "" : object[1].toString());
				stat.setChassis(object[2] == null ? "" : object[2].toString());
				stat.setCu(object[3] == null ? "" : object[3].toString());
				stat.setPower(object[4] == null ? "" : object[4].toString());
				stat.setInfo(object[5] == null ? "" : object[5].toString());
				stat.setModel(object[6] == null ? "" : object[6].toString());
				list.add(stat);
			}
		}
		pagination.setTotalCount(countvalue);
		pagination.setResult(list);
		pagination.setCurrentPage(pageNumber);
		pagination.setPageSize(pageSize);
		pagination.setPageCount(count);
		session.close();
		return pagination;
	}

	private Bureau string2Enum(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
