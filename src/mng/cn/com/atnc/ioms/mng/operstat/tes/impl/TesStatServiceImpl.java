package cn.com.atnc.ioms.mng.operstat.tes.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.common.service.AbstractService;
import cn.com.atnc.ioms.dao.basedata.tes.ITesSlotDao;
import cn.com.atnc.ioms.dao.basedata.tes.ITesTxPowerLogDao;
import cn.com.atnc.ioms.dao.operstat.tes.ITesStatDao;
import cn.com.atnc.ioms.dao.operstat.tes.ITesTxPowerDao;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.entity.basedata.tes.TesSlot;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPower;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerLog;
import cn.com.atnc.ioms.entity.basedata.tes.TesTxPowerStat;
import cn.com.atnc.ioms.mng.operstat.tes.ITesStatService;
import cn.com.atnc.ioms.model.operstat.tes.TesStatQueryModel;
import cn.com.atnc.ioms.model.operstat.tes.TesTxPowerQueryModel;

@Service("tesStatService")
public class TesStatServiceImpl extends AbstractService implements
		ITesStatService {

    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
	@Autowired
	private ITesStatDao tesStatDao;

	@Autowired
	private ITesTxPowerDao tesTxPowerDao;

	@Autowired
	private ITesSlotDao tesSlotDao;

	@Autowired
	private ITesTxPowerLogDao tesTxPowerLogDao;
	
	@Override
	public Pagination queryPage(TesStatQueryModel qm) {
		return tesStatDao.queryPage(qm);
	}

	@Override
	public List<TesTxPowerStat> findlist(TesStatQueryModel qm) {
		return tesStatDao.findlist(qm);
	}

	@Override
	public Pagination queryTxPowerPage(TesTxPowerQueryModel qm) {
		return tesTxPowerDao.queryPage(qm);
	}

	@Override
	public TesTxPowerStat findById(String id) {
		return tesStatDao.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String save(String equip, String nodecu, String id, User user)
			throws Exception {
	    boolean isMod = false;
		TesTxPower power = tesTxPowerDao.findById(id);
		
		TesSlot slot = tesSlotDao.findByTesSlot(equip,nodecu);
		Long size = tesTxPowerDao.findTesPower(equip, nodecu,power.getTesStat().getId());

		if(power.getTesSlot()==null && size>0){
            throw new Exception("槽数据已经存在，请重新填写");
		}
		if(power.getTesSlot()!=null){
		    TesSlot slottemp = power.getTesSlot();
		    if(slottemp.getTesNode().getTesNodeCode().equals(slot.getTesNode().getTesNodeCode()) &&
		            slottemp.getCu().equals(slot.getCu())){
		        throw new Exception("槽数据修改没有意义");
		    }
		}
		if (slot == null) {
			// slot = new TesSlot();
			// slot.setCu("20002");
			// slot.setInfo("测试数据");
			// slot.setOptUser(user);
			// slot.setOptTime(Calendar.getInstance());
			// slot.setOcc(12);
			// TesNode tn =
			// tesNodeDao.findById("f25c66fc812c43b286a1ad8d331d393c");
			// slot.setTesNode(tn);
			// tesSlotDao.save(slot);
			throw new Exception("槽数据不存在！");
		}
		// 修改记录则删除原先留下来的日志记录
		if (power.getTesSlot() != null) {
			// 修改保存过的数据，删除修改前的槽日志，新增槽的日志
			// 查原先槽位的记录
			List<TesTxPowerLog> ttpltemp = (List<TesTxPowerLog>) tesTxPowerLogDao
					.queryList(
							"from TesTxPowerLog where tesSlot.cu=? order by recordTime desc",
							power.getTesSlot().getCu());
			// 删除最近的日志记录
			tesTxPowerLogDao.delete(ttpltemp.get(0));
			
			isMod=true;
		}
		// 保存日志记录
		TesTxPowerLog log = new TesTxPowerLog();
		// 保存新数据新槽的日志

		// 查询日志找该槽是否有日志，如果没有则根据离testxpower中Stat的最近的记录找到该槽的记录，如果没有找到则应该是从正常变为了异常并记录日志
		List<TesTxPowerLog> ttpl = (List<TesTxPowerLog>) tesTxPowerLogDao
				.queryList(
						"from TesTxPowerLog d where d.tesSlot.cu=? order by d.recordTime desc",
						slot.getCu());

		if (ttpl != null && ttpl.size() > 0) {
			// 找到历史记录
			log.setFromNum(ttpl.get(0).getToNum());
		} else {
			// 没找到历史
			TesTxPowerStat stat = power.getTesStat();
			List<TesTxPowerStat> statlist = (List<TesTxPowerStat>) tesStatDao
					.queryList(
							"from TesTxPowerStat where statDate<? order by statDate desc",
							stat.getStatDate());
			if (statlist != null && statlist.size() > 0) {
				// 找到较早的槽记录
				TesTxPowerStat stemp = statlist.get(0);
				stemp.getId();
				List<TesTxPower> ttp = (List<TesTxPower>) tesTxPowerDao
						.queryList(
								"from TesTxPower where tesStat.id=? and tesSlot.cu=?",
								new Object[] { stemp.getId(), slot.getCu() });
				if (ttp != null && ttp.size() > 0) {
					// 找到对应槽的记录
					log.setFromNum(ttp.get(0).getPower());
				} else {
					// 没有找到槽的记录，默认为正常
					log.setFromNum("正常");
				}
			} else {
				// 没有找到更早的记录，默认为from:正常
				log.setFromNum("正常");
			}
		}

		power.setTesSlot(slot);
		power.setOptUser(user);
		power.setOptTime(Calendar.getInstance());

		log.setTesSlot(power.getTesSlot());
		log.setRecordTime(Calendar.getInstance());
		log.setToNum(power.getPower());// 日志记录最新功率值
		if(!log.getToNum().equals(log.getFromNum())){
			// 保存日志
			tesTxPowerLogDao.save(log);
		}
		tesTxPowerDao.saveOrUpdate(power);
		StringBuffer sb = new StringBuffer();
		sb.append("操作:");
		sb.append(isMod?"修改":"保存");
        sb.append(",机箱号:");
        sb.append(log.getTesSlot().getTesNode().getTesNodeCode());
        sb.append(",槽号:");
        sb.append(log.getTesSlot().getCu());
        //IOMSCS-366 不用记录频率值，没有意义
//        sb.append(",变更值前:");
//        sb.append(log.getFromNum());
//        sb.append(",变更值后:");
//        sb.append(log.getToNum());
        sb.append(",变更时间:");
        sb.append(formatDate.format(log.getRecordTime().getTime()));
		return sb.toString();
	}

	public void removeStatusById(String id) {
		TesTxPower power = tesTxPowerDao.findById(id);
		// tesTxPowerDao.saveOrUpdate(power);
		// TODO 是删除还是改状态
		tesTxPowerDao.delete(power);
	}

	public Map<String, Integer> tesSlotWarningList() {
		return tesStatDao.tesSlotWarningList();
	}

	@Override
	public Pagination querySQLPage(TesTxPowerQueryModel qm) {
		return tesStatDao.querySQLPage(qm);
	}

    public Pagination queryLogPage(TesStatQueryModel queryModel){
        return tesTxPowerLogDao.queryPage(queryModel);
    }
}
