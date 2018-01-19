package cn.com.atnc.ioms.mng.duty.statellitemqy.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.atnc.common.entity.Pagination;
import cn.com.atnc.ioms.dao.duty.environment.EnvironmentEquipCheckDao;
import cn.com.atnc.ioms.dao.duty.satellitemqy.KuEquDao;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
import cn.com.atnc.ioms.entity.duty.satellite.KuEqu;
import cn.com.atnc.ioms.mng.duty.statellitemqy.KuEquService;
import cn.com.atnc.ioms.model.duty.environment.EnvironmentCheckQueryModel;
import cn.com.atnc.ioms.model.duty.statellite.mqy.KuEquModel;
import cn.com.atnc.ioms.util.DateUtilTools;

@Transactional
@Service("KuEquService")
public class KuEquServiceImpl implements KuEquService {

	@Autowired
	private EnvironmentEquipCheckDao environmentEquipCheckDao;
	@Autowired
	private KuEquDao kuequdao;

	@Override
	public KuEqu save(KuEquModel kuequmodel) {
		KuEqu KuEqu = new KuEqu();
		KuEqu.setOperator(kuequmodel.getOperator());
		KuEqu.setCheckDate(DateUtilTools.getNowDate());
		KuEqu.setCheckTime(DateUtilTools.getNowDateTime());
		KuEqu.setCheckType(kuequmodel.getCheckType());
		KuEqu.setOptType(kuequmodel.getOptType());

		KuEqu.setSlot1(kuequmodel.getSlot1());
		KuEqu.setSlot2(kuequmodel.getSlot2());
		KuEqu.setSlot3(kuequmodel.getSlot3());
		KuEqu.setSlot4(kuequmodel.getSlot4());

		KuEqu.setType1(kuequmodel.getType1());
		KuEqu.setType2(kuequmodel.getType2());
		KuEqu.setType3(kuequmodel.getType3());
		KuEqu.setType4(kuequmodel.getType4());
		KuEqu.setType5(kuequmodel.getType5());
		KuEqu.setType6(kuequmodel.getType6());
		KuEqu.setType7(kuequmodel.getType7());
		KuEqu.setType8(kuequmodel.getType8());
		KuEqu.setType9(kuequmodel.getType9());
		KuEqu.setType10(kuequmodel.getType10());
		KuEqu.setType11(kuequmodel.getType11());
		KuEqu.setType12(kuequmodel.getType12());
		KuEqu.setType13(kuequmodel.getType13());
		KuEqu.setType14(kuequmodel.getType14());
		KuEqu.setType15(kuequmodel.getType15());
		KuEqu.setType16(kuequmodel.getType16());
		KuEqu.setType17(kuequmodel.getType17());
		KuEqu.setType18(kuequmodel.getType18());
		KuEqu.setType19(kuequmodel.getType19());
		KuEqu.setType20(kuequmodel.getType20());
		KuEqu.setType21(kuequmodel.getType21());
		KuEqu.setType22(kuequmodel.getType22());
		KuEqu.setType23(kuequmodel.getType23());
		KuEqu.setType24(kuequmodel.getType24());
		KuEqu.setType25(kuequmodel.getType25());
		KuEqu.setType26(kuequmodel.getType26());
		KuEqu.setType27(kuequmodel.getType27());
		KuEqu.setType28(kuequmodel.getType28());
		KuEqu.setType29(kuequmodel.getType29());
		KuEqu.setType30(kuequmodel.getType30());
		KuEqu.setType31(kuequmodel.getType31());
		KuEqu.setType32(kuequmodel.getType32());
		KuEqu.setType33(kuequmodel.getType33());
		KuEqu.setType34(kuequmodel.getType34());
		KuEqu.setType35(kuequmodel.getType35());
		KuEqu.setType36(kuequmodel.getType36());
		KuEqu.setType37(kuequmodel.getType37());
		KuEqu.setType38(kuequmodel.getType38());
		KuEqu.setType39(kuequmodel.getType39());
		KuEqu.setType40(kuequmodel.getType40());
		KuEqu.setType41(kuequmodel.getType41());
		KuEqu.setType42(kuequmodel.getType42());
		KuEqu.setType43(kuequmodel.getType43());
		KuEqu.setType44(kuequmodel.getType44());

		KuEqu.setUsepor1(kuequmodel.getUsepor1());
		KuEqu.setUsepor2(kuequmodel.getUsepor2());
		KuEqu.setUsepor3(kuequmodel.getUsepor3());
		KuEqu.setUsepor4(kuequmodel.getUsepor4());
		KuEqu.setUsepor6(kuequmodel.getUsepor6());
		KuEqu.setUsepor7(kuequmodel.getUsepor7());
		KuEqu.setUsepor8(kuequmodel.getUsepor8());
		KuEqu.setUsepor10(kuequmodel.getUsepor10());
		KuEqu.setUsepor11(kuequmodel.getUsepor11());
		KuEqu.setUsepor12(kuequmodel.getUsepor12());
		KuEqu.setUsepor14(kuequmodel.getUsepor14());
		KuEqu.setUsepor15(kuequmodel.getUsepor15());
		KuEqu.setUsepor16(kuequmodel.getUsepor16());
		KuEqu.setUsepor18(kuequmodel.getUsepor18());
		KuEqu.setUsepor19(kuequmodel.getUsepor19());
		KuEqu.setUsepor20(kuequmodel.getUsepor20());
		KuEqu.setUsepor22(kuequmodel.getUsepor22());
		KuEqu.setUsepor23(kuequmodel.getUsepor23());
		KuEqu.setUsepor24(kuequmodel.getUsepor24());
		KuEqu.setUsepor26(kuequmodel.getUsepor26());
		KuEqu.setUsepor27(kuequmodel.getUsepor27());
		KuEqu.setUsepor28(kuequmodel.getUsepor28());
		KuEqu.setUsepor30(kuequmodel.getUsepor30());
		KuEqu.setUsepor31(kuequmodel.getUsepor31());
		KuEqu.setUsepor32(kuequmodel.getUsepor32());
		KuEqu.setUsepor34(kuequmodel.getUsepor34());
		KuEqu.setUsepor35(kuequmodel.getUsepor35());
		KuEqu.setUsepor36(kuequmodel.getUsepor36());
		KuEqu.setUsepor38(kuequmodel.getUsepor38());
		KuEqu.setUsepor39(kuequmodel.getUsepor39());
		KuEqu.setUsepor40(kuequmodel.getUsepor40());
		KuEqu.setUsepor42(kuequmodel.getUsepor42());
		KuEqu.setUsepor43(kuequmodel.getUsepor43());
		KuEqu.setUsepor44(kuequmodel.getUsepor44());

		KuEqu.setSurpor1(kuequmodel.getSurpor1());
		KuEqu.setSurpor2(kuequmodel.getSurpor2());
		KuEqu.setSurpor3(kuequmodel.getSurpor3());
		KuEqu.setSurpor4(kuequmodel.getSurpor4());
		KuEqu.setSurpor6(kuequmodel.getSurpor6());
		KuEqu.setSurpor7(kuequmodel.getSurpor7());
		KuEqu.setSurpor8(kuequmodel.getSurpor8());
		KuEqu.setSurpor10(kuequmodel.getSurpor10());
		KuEqu.setSurpor11(kuequmodel.getSurpor11());
		KuEqu.setSurpor12(kuequmodel.getSurpor12());
		KuEqu.setSurpor14(kuequmodel.getSurpor14());
		KuEqu.setSurpor15(kuequmodel.getSurpor15());
		KuEqu.setSurpor16(kuequmodel.getSurpor16());
		KuEqu.setSurpor18(kuequmodel.getSurpor18());
		KuEqu.setSurpor19(kuequmodel.getSurpor19());
		KuEqu.setSurpor20(kuequmodel.getSurpor20());
		KuEqu.setSurpor22(kuequmodel.getSurpor22());
		KuEqu.setSurpor23(kuequmodel.getSurpor23());
		KuEqu.setSurpor24(kuequmodel.getSurpor24());
		KuEqu.setSurpor26(kuequmodel.getSurpor26());
		KuEqu.setSurpor27(kuequmodel.getSurpor27());
		KuEqu.setSurpor28(kuequmodel.getSurpor28());
		KuEqu.setSurpor30(kuequmodel.getSurpor30());
		KuEqu.setSurpor31(kuequmodel.getSurpor31());
		KuEqu.setSurpor32(kuequmodel.getSurpor32());
		KuEqu.setSurpor34(kuequmodel.getSurpor34());
		KuEqu.setSurpor35(kuequmodel.getSurpor35());
		KuEqu.setSurpor36(kuequmodel.getSurpor36());
		KuEqu.setSurpor38(kuequmodel.getSurpor38());
		KuEqu.setSurpor39(kuequmodel.getSurpor39());
		KuEqu.setSurpor40(kuequmodel.getSurpor40());
		KuEqu.setSurpor42(kuequmodel.getSurpor42());
		KuEqu.setSurpor43(kuequmodel.getSurpor43());
		KuEqu.setSurpor44(kuequmodel.getSurpor44());

		KuEqu.setSubnet10Remark(kuequmodel.getSubnet10Remark());
		KuEqu.setSubnet11Remark(kuequmodel.getSubnet11Remark());
		KuEqu.setSubnet20Remark(kuequmodel.getSubnet20Remark());
		KuEqu.setSubnet21Remark(kuequmodel.getSubnet21Remark());
		KuEqu.setSubnet30Remark(kuequmodel.getSubnet30Remark());
		KuEqu.setSubnet31Remark(kuequmodel.getSubnet31Remark());
		KuEqu.setSubnet40Remark(kuequmodel.getSubnet40Remark());
		KuEqu.setSubnet41Remark(kuequmodel.getSubnet41Remark());
		KuEqu.setSubnet0Remark(kuequmodel.getSubnet0Remark());
		KuEqu.setSubnet1Remark(kuequmodel.getSubnet1Remark());
		KuEqu.setSubnet7Remark(kuequmodel.getSubnet7Remark());

		kuequdao.save(KuEqu);
		return KuEqu;
	}

	@Override
	public Pagination queryPageByModel(EnvironmentCheckQueryModel queryModel) {
		return kuequdao.queryPageByModel(queryModel);
	}

	@Override
	public KuEqu findById(String id) {
		return kuequdao.findById(id);
	}

	@Override
	public EnvironmentEquipCheck findByIden(String checkid) {
		return environmentEquipCheckDao.findById(checkid);
	}

	@Override
	public KuEqu update(KuEqu KuEqu, KuEquModel kuequmodel) {
		
		KuEqu.setUpdater(kuequmodel.getOperator());
		KuEqu.setUpdateTime(DateUtilTools.getNowDateTime());

		KuEqu.setSlot1(kuequmodel.getSlot1());
		KuEqu.setSlot2(kuequmodel.getSlot2());
		KuEqu.setSlot3(kuequmodel.getSlot3());
		KuEqu.setSlot4(kuequmodel.getSlot4());

		KuEqu.setType1(kuequmodel.getType1());
		KuEqu.setType2(kuequmodel.getType2());
		KuEqu.setType3(kuequmodel.getType3());
		KuEqu.setType4(kuequmodel.getType4());
		KuEqu.setType5(kuequmodel.getType5());
		KuEqu.setType6(kuequmodel.getType6());
		KuEqu.setType7(kuequmodel.getType7());
		KuEqu.setType8(kuequmodel.getType8());
		KuEqu.setType9(kuequmodel.getType9());
		KuEqu.setType10(kuequmodel.getType10());
		KuEqu.setType11(kuequmodel.getType11());
		KuEqu.setType12(kuequmodel.getType12());
		KuEqu.setType13(kuequmodel.getType13());
		KuEqu.setType14(kuequmodel.getType14());
		KuEqu.setType15(kuequmodel.getType15());
		KuEqu.setType16(kuequmodel.getType16());
		KuEqu.setType17(kuequmodel.getType17());
		KuEqu.setType18(kuequmodel.getType18());
		KuEqu.setType19(kuequmodel.getType19());
		KuEqu.setType20(kuequmodel.getType20());
		KuEqu.setType21(kuequmodel.getType21());
		KuEqu.setType22(kuequmodel.getType22());
		KuEqu.setType23(kuequmodel.getType23());
		KuEqu.setType24(kuequmodel.getType24());
		KuEqu.setType25(kuequmodel.getType25());
		KuEqu.setType26(kuequmodel.getType26());
		KuEqu.setType27(kuequmodel.getType27());
		KuEqu.setType28(kuequmodel.getType28());
		KuEqu.setType29(kuequmodel.getType29());
		KuEqu.setType30(kuequmodel.getType30());
		KuEqu.setType31(kuequmodel.getType31());
		KuEqu.setType32(kuequmodel.getType32());
		KuEqu.setType33(kuequmodel.getType33());
		KuEqu.setType34(kuequmodel.getType34());
		KuEqu.setType35(kuequmodel.getType35());
		KuEqu.setType36(kuequmodel.getType36());
		KuEqu.setType37(kuequmodel.getType37());
		KuEqu.setType38(kuequmodel.getType38());
		KuEqu.setType39(kuequmodel.getType39());
		KuEqu.setType40(kuequmodel.getType40());
		KuEqu.setType41(kuequmodel.getType41());
		KuEqu.setType42(kuequmodel.getType42());
		KuEqu.setType43(kuequmodel.getType43());
		KuEqu.setType44(kuequmodel.getType44());

		KuEqu.setUsepor1(kuequmodel.getUsepor1());
		KuEqu.setUsepor2(kuequmodel.getUsepor2());
		KuEqu.setUsepor3(kuequmodel.getUsepor3());
		KuEqu.setUsepor4(kuequmodel.getUsepor4());
		KuEqu.setUsepor6(kuequmodel.getUsepor6());
		KuEqu.setUsepor7(kuequmodel.getUsepor7());
		KuEqu.setUsepor8(kuequmodel.getUsepor8());
		KuEqu.setUsepor10(kuequmodel.getUsepor10());
		KuEqu.setUsepor11(kuequmodel.getUsepor11());
		KuEqu.setUsepor12(kuequmodel.getUsepor12());
		KuEqu.setUsepor14(kuequmodel.getUsepor14());
		KuEqu.setUsepor15(kuequmodel.getUsepor15());
		KuEqu.setUsepor16(kuequmodel.getUsepor16());
		KuEqu.setUsepor18(kuequmodel.getUsepor18());
		KuEqu.setUsepor19(kuequmodel.getUsepor19());
		KuEqu.setUsepor20(kuequmodel.getUsepor20());
		KuEqu.setUsepor22(kuequmodel.getUsepor22());
		KuEqu.setUsepor23(kuequmodel.getUsepor23());
		KuEqu.setUsepor24(kuequmodel.getUsepor24());
		KuEqu.setUsepor26(kuequmodel.getUsepor26());
		KuEqu.setUsepor27(kuequmodel.getUsepor27());
		KuEqu.setUsepor28(kuequmodel.getUsepor28());
		KuEqu.setUsepor30(kuequmodel.getUsepor30());
		KuEqu.setUsepor31(kuequmodel.getUsepor31());
		KuEqu.setUsepor32(kuequmodel.getUsepor32());
		KuEqu.setUsepor34(kuequmodel.getUsepor34());
		KuEqu.setUsepor35(kuequmodel.getUsepor35());
		KuEqu.setUsepor36(kuequmodel.getUsepor36());
		KuEqu.setUsepor38(kuequmodel.getUsepor38());
		KuEqu.setUsepor39(kuequmodel.getUsepor39());
		KuEqu.setUsepor40(kuequmodel.getUsepor40());
		KuEqu.setUsepor42(kuequmodel.getUsepor42());
		KuEqu.setUsepor43(kuequmodel.getUsepor43());
		KuEqu.setUsepor44(kuequmodel.getUsepor44());

		KuEqu.setSurpor1(kuequmodel.getSurpor1());
		KuEqu.setSurpor2(kuequmodel.getSurpor2());
		KuEqu.setSurpor3(kuequmodel.getSurpor3());
		KuEqu.setSurpor4(kuequmodel.getSurpor4());
		KuEqu.setSurpor6(kuequmodel.getSurpor6());
		KuEqu.setSurpor7(kuequmodel.getSurpor7());
		KuEqu.setSurpor8(kuequmodel.getSurpor8());
		KuEqu.setSurpor10(kuequmodel.getSurpor10());
		KuEqu.setSurpor11(kuequmodel.getSurpor11());
		KuEqu.setSurpor12(kuequmodel.getSurpor12());
		KuEqu.setSurpor14(kuequmodel.getSurpor14());
		KuEqu.setSurpor15(kuequmodel.getSurpor15());
		KuEqu.setSurpor16(kuequmodel.getSurpor16());
		KuEqu.setSurpor18(kuequmodel.getSurpor18());
		KuEqu.setSurpor19(kuequmodel.getSurpor19());
		KuEqu.setSurpor20(kuequmodel.getSurpor20());
		KuEqu.setSurpor22(kuequmodel.getSurpor22());
		KuEqu.setSurpor23(kuequmodel.getSurpor23());
		KuEqu.setSurpor24(kuequmodel.getSurpor24());
		KuEqu.setSurpor26(kuequmodel.getSurpor26());
		KuEqu.setSurpor27(kuequmodel.getSurpor27());
		KuEqu.setSurpor28(kuequmodel.getSurpor28());
		KuEqu.setSurpor30(kuequmodel.getSurpor30());
		KuEqu.setSurpor31(kuequmodel.getSurpor31());
		KuEqu.setSurpor32(kuequmodel.getSurpor32());
		KuEqu.setSurpor34(kuequmodel.getSurpor34());
		KuEqu.setSurpor35(kuequmodel.getSurpor35());
		KuEqu.setSurpor36(kuequmodel.getSurpor36());
		KuEqu.setSurpor38(kuequmodel.getSurpor38());
		KuEqu.setSurpor39(kuequmodel.getSurpor39());
		KuEqu.setSurpor40(kuequmodel.getSurpor40());
		KuEqu.setSurpor42(kuequmodel.getSurpor42());
		KuEqu.setSurpor43(kuequmodel.getSurpor43());
		KuEqu.setSurpor44(kuequmodel.getSurpor44());

		KuEqu.setSubnet10Remark(kuequmodel.getSubnet10Remark());
		KuEqu.setSubnet11Remark(kuequmodel.getSubnet11Remark());
		KuEqu.setSubnet20Remark(kuequmodel.getSubnet20Remark());
		KuEqu.setSubnet21Remark(kuequmodel.getSubnet21Remark());
		KuEqu.setSubnet30Remark(kuequmodel.getSubnet30Remark());
		KuEqu.setSubnet31Remark(kuequmodel.getSubnet31Remark());
		KuEqu.setSubnet40Remark(kuequmodel.getSubnet40Remark());
		KuEqu.setSubnet41Remark(kuequmodel.getSubnet41Remark());
		KuEqu.setSubnet0Remark(kuequmodel.getSubnet0Remark());
		KuEqu.setSubnet1Remark(kuequmodel.getSubnet1Remark());
		KuEqu.setSubnet7Remark(kuequmodel.getSubnet7Remark());

		kuequdao.update(KuEqu);
		return KuEqu;
	}

	@Override
	public void delete(KuEqu kuequ) {
		kuequdao.delete(kuequ);

	}

}
