package cn.com.atnc.ioms.entity.duty.satellite;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.acl.User;
import cn.com.atnc.ioms.enums.duty.environment.CheckCatagory;

/**
 * 通信基-KU-室内设备检查 民航局-KU-室内设备检查 十里河-KU-室内设备检查
 * 
 * @author shijiyong
 * @date 2016年11月1日 下午1:53:06
 * @version 1.0, 2016年11月1日 下午1:53:06
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_KUEQU")
public class KuEqu extends MyStringUUIDEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String slot1;
	private String slot2;
	private String slot3;
	private String slot4;

	private String type1;
	private String type2;
	private String type3;
	private String type4;
	private String type5;
	private String type6;
	private String type7;
	private String type8;
	private String type9;
	private String type10;
	private String type11;
	private String type12;
	private String type13;
	private String type14;
	private String type15;
	private String type16;
	private String type17;
	private String type18;
	private String type19;
	private String type20;
	private String type21;
	private String type22;
	private String type23;
	private String type24;
	private String type25;
	private String type26;
	private String type27;
	private String type28;
	private String type29;
	private String type30;
	private String type31;
	private String type32;
	private String type33;
	private String type34;
	private String type35;
	private String type36;
	private String type37;
	private String type38;
	private String type39;
	private String type40;
	private String type41;
	private String type42;
	private String type43;
	private String type44;

	private String usepor1;
	private String usepor2;
	private String usepor3;
	private String usepor4;
	private String usepor6;
	private String usepor7;
	private String usepor8;
	private String usepor10;
	private String usepor11;
	private String usepor12;
	private String usepor14;
	private String usepor15;
	private String usepor16;
	private String usepor18;
	private String usepor19;
	private String usepor20;
	private String usepor22;
	private String usepor23;
	private String usepor24;
	private String usepor26;
	private String usepor27;
	private String usepor28;
	private String usepor30;
	private String usepor31;
	private String usepor32;
	private String usepor34;
	private String usepor35;
	private String usepor36;
	private String usepor38;
	private String usepor39;
	private String usepor40;
	private String usepor42;
	private String usepor43;
	private String usepor44;

	private String surpor1;
	private String surpor2;
	private String surpor3;
	private String surpor4;
	private String surpor6;
	private String surpor7;
	private String surpor8;
	private String surpor10;
	private String surpor11;
	private String surpor12;
	private String surpor14;
	private String surpor15;
	private String surpor16;
	private String surpor18;
	private String surpor19;
	private String surpor20;
	private String surpor22;
	private String surpor23;
	private String surpor24;
	private String surpor26;
	private String surpor27;
	private String surpor28;
	private String surpor30;
	private String surpor31;
	private String surpor32;
	private String surpor34;
	private String surpor35;
	private String surpor36;
	private String surpor38;
	private String surpor39;
	private String surpor40;
	private String surpor42;
	private String surpor43;
	private String surpor44;

	private String subnet10Remark;
	private String subnet11Remark;
	private String subnet20Remark;
	private String subnet21Remark;
	private String subnet30Remark;
	private String subnet31Remark;
	private String subnet40Remark;
	private String subnet41Remark;
	private String subnet0Remark;
	private String subnet1Remark;
	private String subnet7Remark;

	private User operator; // 操作人
	private Date checkTime; // 检查时间
	private Date checkDate; // 检查日期
	private User updater; // 操作人
	private Date updateTime; // 检查时间
	private CheckCatagory checkType;
	private String optType;

	@ManyToOne
	@JoinColumn(name = "UPDATER")
	public User getUpdater() {
		return updater;
	}

	public void setUpdater(User updater) {
		this.updater = updater;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "UPDATE_TIME")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@ManyToOne
	@JoinColumn(name = "operator")
	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
	}

	@DateTimeFormat(iso = ISO.DATE_TIME)
	@Column(name = "check_time")
	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "check_date")
	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "check_type")
	public CheckCatagory getCheckType() {
		return checkType;
	}

	public void setCheckType(CheckCatagory checkType) {
		this.checkType = checkType;
	}

	@Column(name = "optType")
	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	@Column(name = "subnet10_Remark")
	public String getSubnet10Remark() {
		return subnet10Remark;
	}

	public void setSubnet10Remark(String subnet10Remark) {
		this.subnet10Remark = subnet10Remark;
	}

	@Column(name = "subnet11_Remark")
	public String getSubnet11Remark() {
		return subnet11Remark;
	}

	public void setSubnet11Remark(String subnet11Remark) {
		this.subnet11Remark = subnet11Remark;
	}

	@Column(name = "subnet20_Remark")
	public String getSubnet20Remark() {
		return subnet20Remark;
	}

	public void setSubnet20Remark(String subnet20Remark) {
		this.subnet20Remark = subnet20Remark;
	}

	@Column(name = "subnet21_Remark")
	public String getSubnet21Remark() {
		return subnet21Remark;
	}

	public void setSubnet21Remark(String subnet21Remark) {
		this.subnet21Remark = subnet21Remark;
	}

	@Column(name = "subnet30_Remark")
	public String getSubnet30Remark() {
		return subnet30Remark;
	}

	public void setSubnet30Remark(String subnet30Remark) {
		this.subnet30Remark = subnet30Remark;
	}

	@Column(name = "subnet31_Remark")
	public String getSubnet31Remark() {
		return subnet31Remark;
	}

	public void setSubnet31Remark(String subnet31Remark) {
		this.subnet31Remark = subnet31Remark;
	}

	@Column(name = "subnet40_Remark")
	public String getSubnet40Remark() {
		return subnet40Remark;
	}

	public void setSubnet40Remark(String subnet40Remark) {
		this.subnet40Remark = subnet40Remark;
	}

	@Column(name = "subnet41_Remark")
	public String getSubnet41Remark() {
		return subnet41Remark;
	}

	public void setSubnet41Remark(String subnet41Remark) {
		this.subnet41Remark = subnet41Remark;
	}

	@Column(name = "subnet0_Remark")
	public String getSubnet0Remark() {
		return subnet0Remark;
	}

	public void setSubnet0Remark(String subnet0Remark) {
		this.subnet0Remark = subnet0Remark;
	}

	@Column(name = "subnet1_Remark")
	public String getSubnet1Remark() {
		return subnet1Remark;
	}

	public void setSubnet1Remark(String subnet1Remark) {
		this.subnet1Remark = subnet1Remark;
	}

	@Column(name = "subnet7_Remark")
	public String getSubnet7Remark() {
		return subnet7Remark;
	}

	public void setSubnet7Remark(String subnet7Remark) {
		this.subnet7Remark = subnet7Remark;
	}

	@Column(name = "slot1")
	public String getSlot1() {
		return slot1;
	}

	public void setSlot1(String slot1) {
		this.slot1 = slot1;
	}

	@Column(name = "slot2")
	public String getSlot2() {
		return slot2;
	}

	public void setSlot2(String slot2) {
		this.slot2 = slot2;
	}

	@Column(name = "slot3")
	public String getSlot3() {
		return slot3;
	}

	public void setSlot3(String slot3) {
		this.slot3 = slot3;
	}

	@Column(name = "slot4")
	public String getSlot4() {
		return slot4;
	}

	public void setSlot4(String slot4) {
		this.slot4 = slot4;
	}

	@Column(name = "type1")
	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	@Column(name = "type2")
	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	@Column(name = "type3")
	public String getType3() {
		return type3;
	}

	public void setType3(String type3) {
		this.type3 = type3;
	}

	@Column(name = "type4")
	public String getType4() {
		return type4;
	}

	public void setType4(String type4) {
		this.type4 = type4;
	}

	@Column(name = "type5")
	public String getType5() {
		return type5;
	}

	public void setType5(String type5) {
		this.type5 = type5;
	}

	@Column(name = "type6")
	public String getType6() {
		return type6;
	}

	public void setType6(String type6) {
		this.type6 = type6;
	}

	@Column(name = "type7")
	public String getType7() {
		return type7;
	}

	public void setType7(String type7) {
		this.type7 = type7;
	}

	@Column(name = "type8")
	public String getType8() {
		return type8;
	}

	public void setType8(String type8) {
		this.type8 = type8;
	}

	@Column(name = "type9")
	public String getType9() {
		return type9;
	}

	public void setType9(String type9) {
		this.type9 = type9;
	}

	@Column(name = "type10")
	public String getType10() {
		return type10;
	}

	public void setType10(String type10) {
		this.type10 = type10;
	}

	@Column(name = "type11")
	public String getType11() {
		return type11;
	}

	public void setType11(String type11) {
		this.type11 = type11;
	}

	@Column(name = "type12")
	public String getType12() {
		return type12;
	}

	public void setType12(String type12) {
		this.type12 = type12;
	}

	@Column(name = "type13")
	public String getType13() {
		return type13;
	}

	public void setType13(String type13) {
		this.type13 = type13;
	}

	@Column(name = "type14")
	public String getType14() {
		return type14;
	}

	public void setType14(String type14) {
		this.type14 = type14;
	}

	@Column(name = "type15")
	public String getType15() {
		return type15;
	}

	public void setType15(String type15) {
		this.type15 = type15;
	}

	@Column(name = "type16")
	public String getType16() {
		return type16;
	}

	public void setType16(String type16) {
		this.type16 = type16;
	}

	@Column(name = "type17")
	public String getType17() {
		return type17;
	}

	public void setType17(String type17) {
		this.type17 = type17;
	}

	@Column(name = "type18")
	public String getType18() {
		return type18;
	}

	public void setType18(String type18) {
		this.type18 = type18;
	}

	@Column(name = "type19")
	public String getType19() {
		return type19;
	}

	public void setType19(String type19) {
		this.type19 = type19;
	}

	@Column(name = "type20")
	public String getType20() {
		return type20;
	}

	public void setType20(String type20) {
		this.type20 = type20;
	}

	@Column(name = "type21")
	public String getType21() {
		return type21;
	}

	public void setType21(String type21) {
		this.type21 = type21;
	}

	@Column(name = "type22")
	public String getType22() {
		return type22;
	}

	public void setType22(String type22) {
		this.type22 = type22;
	}

	@Column(name = "type23")
	public String getType23() {
		return type23;
	}

	public void setType23(String type23) {
		this.type23 = type23;
	}

	@Column(name = "type24")
	public String getType24() {
		return type24;
	}

	public void setType24(String type24) {
		this.type24 = type24;
	}

	@Column(name = "type25")
	public String getType25() {
		return type25;
	}

	public void setType25(String type25) {
		this.type25 = type25;
	}

	@Column(name = "type26")
	public String getType26() {
		return type26;
	}

	public void setType26(String type26) {
		this.type26 = type26;
	}

	@Column(name = "type27")
	public String getType27() {
		return type27;
	}

	public void setType27(String type27) {
		this.type27 = type27;
	}

	@Column(name = "type28")
	public String getType28() {
		return type28;
	}

	public void setType28(String type28) {
		this.type28 = type28;
	}

	@Column(name = "type29")
	public String getType29() {
		return type29;
	}

	public void setType29(String type29) {
		this.type29 = type29;
	}

	@Column(name = "type30")
	public String getType30() {
		return type30;
	}

	public void setType30(String type30) {
		this.type30 = type30;
	}

	@Column(name = "type31")
	public String getType31() {
		return type31;
	}

	public void setType31(String type31) {
		this.type31 = type31;
	}

	@Column(name = "type32")
	public String getType32() {
		return type32;
	}

	public void setType32(String type32) {
		this.type32 = type32;
	}

	@Column(name = "type33")
	public String getType33() {
		return type33;
	}

	public void setType33(String type33) {
		this.type33 = type33;
	}

	@Column(name = "type34")
	public String getType34() {
		return type34;
	}

	public void setType34(String type34) {
		this.type34 = type34;
	}

	@Column(name = "type35")
	public String getType35() {
		return type35;
	}

	public void setType35(String type35) {
		this.type35 = type35;
	}

	@Column(name = "type36")
	public String getType36() {
		return type36;
	}

	public void setType36(String type36) {
		this.type36 = type36;
	}

	@Column(name = "type37")
	public String getType37() {
		return type37;
	}

	public void setType37(String type37) {
		this.type37 = type37;
	}

	@Column(name = "type38")
	public String getType38() {
		return type38;
	}

	public void setType38(String type38) {
		this.type38 = type38;
	}

	@Column(name = "type39")
	public String getType39() {
		return type39;
	}

	public void setType39(String type39) {
		this.type39 = type39;
	}

	@Column(name = "type40")
	public String getType40() {
		return type40;
	}

	public void setType40(String type40) {
		this.type40 = type40;
	}

	@Column(name = "type41")
	public String getType41() {
		return type41;
	}

	public void setType41(String type41) {
		this.type41 = type41;
	}

	@Column(name = "type42")
	public String getType42() {
		return type42;
	}

	public void setType42(String type42) {
		this.type42 = type42;
	}

	@Column(name = "type43")
	public String getType43() {
		return type43;
	}

	public void setType43(String type43) {
		this.type43 = type43;
	}

	@Column(name = "type44")
	public String getType44() {
		return type44;
	}

	public void setType44(String type44) {
		this.type44 = type44;
	}

	@Column(name = "useport1")
	public String getUsepor1() {
		return usepor1;
	}

	public void setUsepor1(String usepor1) {
		this.usepor1 = usepor1;
	}

	@Column(name = "useport2")
	public String getUsepor2() {
		return usepor2;
	}

	public void setUsepor2(String usepor2) {
		this.usepor2 = usepor2;
	}

	@Column(name = "useport3")
	public String getUsepor3() {
		return usepor3;
	}

	public void setUsepor3(String usepor3) {
		this.usepor3 = usepor3;
	}

	@Column(name = "useport4")
	public String getUsepor4() {
		return usepor4;
	}

	public void setUsepor4(String usepor4) {
		this.usepor4 = usepor4;
	}

	@Column(name = "useport6")
	public String getUsepor6() {
		return usepor6;
	}

	public void setUsepor6(String usepor6) {
		this.usepor6 = usepor6;
	}

	@Column(name = "useport7")
	public String getUsepor7() {
		return usepor7;
	}

	public void setUsepor7(String usepor7) {
		this.usepor7 = usepor7;
	}

	@Column(name = "useport8")
	public String getUsepor8() {
		return usepor8;
	}

	public void setUsepor8(String usepor8) {
		this.usepor8 = usepor8;
	}

	@Column(name = "useport10")
	public String getUsepor10() {
		return usepor10;
	}

	public void setUsepor10(String usepor10) {
		this.usepor10 = usepor10;
	}

	@Column(name = "useport11")
	public String getUsepor11() {
		return usepor11;
	}

	public void setUsepor11(String usepor11) {
		this.usepor11 = usepor11;
	}

	@Column(name = "useport12")
	public String getUsepor12() {
		return usepor12;
	}

	public void setUsepor12(String usepor12) {
		this.usepor12 = usepor12;
	}

	@Column(name = "useport14")
	public String getUsepor14() {
		return usepor14;
	}

	public void setUsepor14(String usepor14) {
		this.usepor14 = usepor14;
	}

	@Column(name = "useport15")
	public String getUsepor15() {
		return usepor15;
	}

	public void setUsepor15(String usepor15) {
		this.usepor15 = usepor15;
	}

	@Column(name = "useport16")
	public String getUsepor16() {
		return usepor16;
	}

	public void setUsepor16(String usepor16) {
		this.usepor16 = usepor16;
	}

	@Column(name = "useport18")
	public String getUsepor18() {
		return usepor18;
	}

	public void setUsepor18(String usepor18) {
		this.usepor18 = usepor18;
	}

	@Column(name = "useport19")
	public String getUsepor19() {
		return usepor19;
	}

	public void setUsepor19(String usepor19) {
		this.usepor19 = usepor19;
	}

	@Column(name = "useport20")
	public String getUsepor20() {
		return usepor20;
	}

	public void setUsepor20(String usepor20) {
		this.usepor20 = usepor20;
	}

	@Column(name = "useport22")
	public String getUsepor22() {
		return usepor22;
	}

	public void setUsepor22(String usepor22) {
		this.usepor22 = usepor22;
	}

	@Column(name = "useport23")
	public String getUsepor23() {
		return usepor23;
	}

	public void setUsepor23(String usepor23) {
		this.usepor23 = usepor23;
	}

	@Column(name = "useport24")
	public String getUsepor24() {
		return usepor24;
	}

	public void setUsepor24(String usepor24) {
		this.usepor24 = usepor24;
	}

	@Column(name = "useport26")
	public String getUsepor26() {
		return usepor26;
	}

	public void setUsepor26(String usepor26) {
		this.usepor26 = usepor26;
	}

	@Column(name = "useport27")
	public String getUsepor27() {
		return usepor27;
	}

	public void setUsepor27(String usepor27) {
		this.usepor27 = usepor27;
	}

	@Column(name = "useport28")
	public String getUsepor28() {
		return usepor28;
	}

	public void setUsepor28(String usepor28) {
		this.usepor28 = usepor28;
	}

	@Column(name = "useport30")
	public String getUsepor30() {
		return usepor30;
	}

	public void setUsepor30(String usepor30) {
		this.usepor30 = usepor30;
	}

	@Column(name = "useport31")
	public String getUsepor31() {
		return usepor31;
	}

	public void setUsepor31(String usepor31) {
		this.usepor31 = usepor31;
	}

	@Column(name = "useport32")
	public String getUsepor32() {
		return usepor32;
	}

	public void setUsepor32(String usepor32) {
		this.usepor32 = usepor32;
	}

	@Column(name = "useport34")
	public String getUsepor34() {
		return usepor34;
	}

	public void setUsepor34(String usepor34) {
		this.usepor34 = usepor34;
	}

	@Column(name = "useport35")
	public String getUsepor35() {
		return usepor35;
	}

	public void setUsepor35(String usepor35) {
		this.usepor35 = usepor35;
	}

	@Column(name = "useport36")
	public String getUsepor36() {
		return usepor36;
	}

	public void setUsepor36(String usepor36) {
		this.usepor36 = usepor36;
	}

	@Column(name = "useport38")
	public String getUsepor38() {
		return usepor38;
	}

	public void setUsepor38(String usepor38) {
		this.usepor38 = usepor38;
	}

	@Column(name = "useport39")
	public String getUsepor39() {
		return usepor39;
	}

	public void setUsepor39(String usepor39) {
		this.usepor39 = usepor39;
	}

	@Column(name = "useport40")
	public String getUsepor40() {
		return usepor40;
	}

	public void setUsepor40(String usepor40) {
		this.usepor40 = usepor40;
	}

	@Column(name = "useport42")
	public String getUsepor42() {
		return usepor42;
	}

	public void setUsepor42(String usepor42) {
		this.usepor42 = usepor42;
	}

	@Column(name = "useport43")
	public String getUsepor43() {
		return usepor43;
	}

	public void setUsepor43(String usepor43) {
		this.usepor43 = usepor43;
	}

	@Column(name = "useport44")
	public String getUsepor44() {
		return usepor44;
	}

	public void setUsepor44(String usepor44) {
		this.usepor44 = usepor44;
	}

	@Column(name = "surport1")
	public String getSurpor1() {
		return surpor1;
	}

	public void setSurpor1(String surpor1) {
		this.surpor1 = surpor1;
	}

	@Column(name = "surport2")
	public String getSurpor2() {
		return surpor2;
	}

	public void setSurpor2(String surpor2) {
		this.surpor2 = surpor2;
	}

	@Column(name = "surport3")
	public String getSurpor3() {
		return surpor3;
	}

	public void setSurpor3(String surpor3) {
		this.surpor3 = surpor3;
	}

	@Column(name = "surport4")
	public String getSurpor4() {
		return surpor4;
	}

	public void setSurpor4(String surpor4) {
		this.surpor4 = surpor4;
	}

	@Column(name = "surport6")
	public String getSurpor6() {
		return surpor6;
	}

	public void setSurpor6(String surpor6) {
		this.surpor6 = surpor6;
	}

	@Column(name = "surport7")
	public String getSurpor7() {
		return surpor7;
	}

	public void setSurpor7(String surpor7) {
		this.surpor7 = surpor7;
	}

	@Column(name = "surport8")
	public String getSurpor8() {
		return surpor8;
	}

	public void setSurpor8(String surpor8) {
		this.surpor8 = surpor8;
	}

	@Column(name = "surport10")
	public String getSurpor10() {
		return surpor10;
	}

	public void setSurpor10(String surpor10) {
		this.surpor10 = surpor10;
	}

	@Column(name = "surport11")
	public String getSurpor11() {
		return surpor11;
	}

	public void setSurpor11(String surpor11) {
		this.surpor11 = surpor11;
	}

	@Column(name = "surport12")
	public String getSurpor12() {
		return surpor12;
	}

	public void setSurpor12(String surpor12) {
		this.surpor12 = surpor12;
	}

	@Column(name = "surport14")
	public String getSurpor14() {
		return surpor14;
	}

	public void setSurpor14(String surpor14) {
		this.surpor14 = surpor14;
	}

	@Column(name = "surport15")
	public String getSurpor15() {
		return surpor15;
	}

	public void setSurpor15(String surpor15) {
		this.surpor15 = surpor15;
	}

	@Column(name = "surport16")
	public String getSurpor16() {
		return surpor16;
	}

	public void setSurpor16(String surpor16) {
		this.surpor16 = surpor16;
	}

	@Column(name = "surport18")
	public String getSurpor18() {
		return surpor18;
	}

	public void setSurpor18(String surpor18) {
		this.surpor18 = surpor18;
	}

	@Column(name = "surport19")
	public String getSurpor19() {
		return surpor19;
	}

	public void setSurpor19(String surpor19) {
		this.surpor19 = surpor19;
	}

	@Column(name = "surport20")
	public String getSurpor20() {
		return surpor20;
	}

	public void setSurpor20(String surpor20) {
		this.surpor20 = surpor20;
	}

	@Column(name = "surport22")
	public String getSurpor22() {
		return surpor22;
	}

	public void setSurpor22(String surpor22) {
		this.surpor22 = surpor22;
	}

	@Column(name = "surport23")
	public String getSurpor23() {
		return surpor23;
	}

	public void setSurpor23(String surpor23) {
		this.surpor23 = surpor23;
	}

	@Column(name = "surport24")
	public String getSurpor24() {
		return surpor24;
	}

	public void setSurpor24(String surpor24) {
		this.surpor24 = surpor24;
	}

	@Column(name = "surport26")
	public String getSurpor26() {
		return surpor26;
	}

	public void setSurpor26(String surpor26) {
		this.surpor26 = surpor26;
	}

	@Column(name = "surport27")
	public String getSurpor27() {
		return surpor27;
	}

	public void setSurpor27(String surpor27) {
		this.surpor27 = surpor27;
	}

	@Column(name = "surport28")
	public String getSurpor28() {
		return surpor28;
	}

	public void setSurpor28(String surpor28) {
		this.surpor28 = surpor28;
	}

	@Column(name = "surport30")
	public String getSurpor30() {
		return surpor30;
	}

	public void setSurpor30(String surpor30) {
		this.surpor30 = surpor30;
	}

	@Column(name = "surport31")
	public String getSurpor31() {
		return surpor31;
	}

	public void setSurpor31(String surpor31) {
		this.surpor31 = surpor31;
	}

	@Column(name = "surport32")
	public String getSurpor32() {
		return surpor32;
	}

	public void setSurpor32(String surpor32) {
		this.surpor32 = surpor32;
	}

	@Column(name = "surport34")
	public String getSurpor34() {
		return surpor34;
	}

	public void setSurpor34(String surpor34) {
		this.surpor34 = surpor34;
	}

	@Column(name = "surport35")
	public String getSurpor35() {
		return surpor35;
	}

	public void setSurpor35(String surpor35) {
		this.surpor35 = surpor35;
	}

	@Column(name = "surport36")
	public String getSurpor36() {
		return surpor36;
	}

	public void setSurpor36(String surpor36) {
		this.surpor36 = surpor36;
	}

	@Column(name = "surport38")
	public String getSurpor38() {
		return surpor38;
	}

	public void setSurpor38(String surpor38) {
		this.surpor38 = surpor38;
	}

	@Column(name = "surport39")
	public String getSurpor39() {
		return surpor39;
	}

	public void setSurpor39(String surpor39) {
		this.surpor39 = surpor39;
	}

	@Column(name = "surport40")
	public String getSurpor40() {
		return surpor40;
	}

	public void setSurpor40(String surpor40) {
		this.surpor40 = surpor40;
	}

	@Column(name = "surport42")
	public String getSurpor42() {
		return surpor42;
	}

	public void setSurpor42(String surpor42) {
		this.surpor42 = surpor42;
	}

	@Column(name = "surport43")
	public String getSurpor43() {
		return surpor43;
	}

	public void setSurpor43(String surpor43) {
		this.surpor43 = surpor43;
	}

	@Column(name = "surport44")
	public String getSurpor44() {
		return surpor44;
	}

	public void setSurpor44(String surpor44) {
		this.surpor44 = surpor44;
	}

	// @ManyToOne
	// @JoinColumn(name = "checkid")
	// public EnvironmentEquipCheck getCheckid() {
	// return checkid;
	// }
	//
	// public void setCheckid(EnvironmentEquipCheck checkid) {
	// this.checkid = checkid;
	// }

}
