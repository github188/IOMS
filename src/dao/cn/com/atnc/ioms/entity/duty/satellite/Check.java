package cn.com.atnc.ioms.entity.duty.satellite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
/**
 * 仪器仪表清查
 * 
 * @author shijiyong
 * @date 2016年11月8日 下午1:53:06
 * @version 1.0, 2016年11月8日 下午1:53:06
 * 
 * 修改人：duanyanlin
 * 修改内容：添加数量字段
 */
@Entity
@Table(name = "TB_OM_DUTY_STA_CHECK")
public class Check extends MyStringUUIDEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String address5;
	private String address6;
	private String address7;
	private String address8;
	private String address9;
	private String address10;
	private String address11;
	private String address12;
	private String address13;
	private String address14;
	private String address15;
	private String address16;
	private String address17;
	private String address18;
	private String address19;
	private String address20;
	private String address21;
	private String address22;
	private String address23;
	private String address24;
	private String address25;
	private String address26;
	private String remark1;
	private String remark2;
	private String remark3;
	private String remark4;
	private String remark5;
	private String remark6;
	private String remark7;
	private String remark8;
	private String remark9;
	private String remark10;
	private String remark11;
	private String remark12;  
	private String remark13;
	private String remark14;
	private String remark15;
	private String remark16;
	private String remark17;
	private String remark18;
	private String remark19;
	private String remark20;
	private String remark21;
	private String remark22;
	private String remark23;
	private String remark24;
	private String remark25;
	private String remark26;
	private Long num1;
	private Long num2;
	private Long num3;
	private Long num4;
	private Long num5;
	private Long num6;
	private Long num7;
	private Long num8;
	private Long num9;
	private Long num10;
	private Long num11;
	private Long num12;
	private Long num13;
	private Long num14;
	private Long num15;
	private Long num16;
	private Long num17;
	private Long num18;
	private Long num19;
	private Long num20;
	private Long num21;
	private Long num22;
	private Long num23;
	private Long num24;
	private Long num25;
	private Long num26;
	private String total;
	
	private EnvironmentEquipCheck checkid;
	
	@Column(name = "num1")
	public Long getNum1() {
		return num1;
	}

	public void setNum1(Long num1) {
		this.num1 = num1;
	}
	@Column(name = "num2")
	public Long getNum2() {
		return num2;
	}

	public void setNum2(Long num2) {
		this.num2 = num2;
	}
	@Column(name = "num3")
	public Long getNum3() {
		return num3;
	}

	public void setNum3(Long num3) {
		this.num3 = num3;
	}
	@Column(name = "num4")
	public Long getNum4() {
		return num4;
	}

	public void setNum4(Long num4) {
		this.num4 = num4;
	}
	@Column(name = "num5")
	public Long getNum5() {
		return num5;
	}

	public void setNum5(Long num5) {
		this.num5 = num5;
	}
	@Column(name = "num6")
	public Long getNum6() {
		return num6;
	}

	public void setNum6(Long num6) {
		this.num6 = num6;
	}
	@Column(name = "num7")
	public Long getNum7() {
		return num7;
	}

	public void setNum7(Long num7) {
		this.num7 = num7;
	}
	@Column(name = "num8")
	public Long getNum8() {
		return num8;
	}

	public void setNum8(Long num8) {
		this.num8 = num8;
	}
	@Column(name = "num9")
	public Long getNum9() {
		return num9;
	}

	public void setNum9(Long num9) {
		this.num9 = num9;
	}
	@Column(name = "num10")
	public Long getNum10() {
		return num10;
	}

	public void setNum10(Long num10) {
		this.num10 = num10;
	}
	@Column(name = "num11")
	public Long getNum11() {
		return num11;
	}

	public void setNum11(Long num11) {
		this.num11 = num11;
	}
	@Column(name = "num12")
	public Long getNum12() {
		return num12;
	}

	public void setNum12(Long num12) {
		this.num12 = num12;
	}
	@Column(name = "num13")
	public Long getNum13() {
		return num13;
	}

	public void setNum13(Long num13) {
		this.num13 = num13;
	}
	@Column(name = "num14")
	public Long getNum14() {
		return num14;
	}

	public void setNum14(Long num14) {
		this.num14 = num14;
	}
	@Column(name = "num15")
	public Long getNum15() {
		return num15;
	}

	public void setNum15(Long num15) {
		this.num15 = num15;
	}
	@Column(name = "num16")
	public Long getNum16() {
		return num16;
	}

	public void setNum16(Long num16) {
		this.num16 = num16;
	}
	@Column(name = "num17")
	public Long getNum17() {
		return num17;
	}

	public void setNum17(Long num17) {
		this.num17 = num17;
	}
	@Column(name = "num18")
	public Long getNum18() {
		return num18;
	}

	public void setNum18(Long num18) {
		this.num18 = num18;
	}
	@Column(name = "num19")
	public Long getNum19() {
		return num19;
	}

	public void setNum19(Long num19) {
		this.num19 = num19;
	}
	@Column(name = "num20")
	public Long getNum20() {
		return num20;
	}

	public void setNum20(Long num20) {
		this.num20 = num20;
	}
	@Column(name = "num21")
	public Long getNum21() {
		return num21;
	}

	public void setNum21(Long num21) {
		this.num21 = num21;
	}
	@Column(name = "num22")
	public Long getNum22() {
		return num22;
	}

	public void setNum22(Long num22) {
		this.num22 = num22;
	}
	@Column(name = "num23")
	public Long getNum23() {
		return num23;
	}

	public void setNum23(Long num23) {
		this.num23 = num23;
	}
	@Column(name = "num24")
	public Long getNum24() {
		return num24;
	}

	public void setNum24(Long num24) {
		this.num24 = num24;
	}
	@Column(name = "num25")
	public Long getNum25() {
		return num25;
	}

	public void setNum25(Long num25) {
		this.num25 = num25;
	}
	@Column(name = "num26")
	public Long getNum26() {
		return num26;
	}

	public void setNum26(Long num26) {
		this.num26 = num26;
	}
	
	@Column(name = "address1")
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	@Column(name = "address2")
	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	@Column(name = "address3")
	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	@Column(name = "address4")
	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}
	@Column(name = "address5")
	public String getAddress5() {
		return address5;
	}

	public void setAddress5(String address5) {
		this.address5 = address5;
	}
	@Column(name = "address6")
	public String getAddress6() {
		return address6;
	}

	public void setAddress6(String address6) {
		this.address6 = address6;
	}
	@Column(name = "address7")
	public String getAddress7() {
		return address7;
	}

	public void setAddress7(String address7) {
		this.address7 = address7;
	}
	@Column(name = "address8")
	public String getAddress8() {
		return address8;
	}

	public void setAddress8(String address8) {
		this.address8 = address8;
	}
	@Column(name = "address9")
	public String getAddress9() {
		return address9;
	}

	public void setAddress9(String address9) {
		this.address9 = address9;
	}
	@Column(name = "address10")
	public String getAddress10() {
		return address10;
	}

	public void setAddress10(String address10) {
		this.address10 = address10;
	}
	@Column(name = "address11")
	public String getAddress11() {
		return address11;
	}

	public void setAddress11(String address11) {
		this.address11 = address11;
	}
	@Column(name = "address12")
	public String getAddress12() {
		return address12;
	}

	public void setAddress12(String address12) {
		this.address12 = address12;
	}
	@Column(name = "address13")
	public String getAddress13() {
		return address13;
	}

	public void setAddress13(String address13) {
		this.address13 = address13;
	}
	@Column(name = "address14")
	public String getAddress14() {
		return address14;
	}

	public void setAddress14(String address14) {
		this.address14 = address14;
	}
	@Column(name = "address15")
	public String getAddress15() {
		return address15;
	}

	public void setAddress15(String address15) {
		this.address15 = address15;
	}
	@Column(name = "address16")
	public String getAddress16() {
		return address16;
	}

	public void setAddress16(String address16) {
		this.address16 = address16;
	}
	@Column(name = "address17")
	public String getAddress17() {
		return address17;
	}

	public void setAddress17(String address17) {
		this.address17 = address17;
	}
	@Column(name = "address18")
	public String getAddress18() {
		return address18;
	}

	public void setAddress18(String address18) {
		this.address18 = address18;
	}
	@Column(name = "address19")
	public String getAddress19() {
		return address19;
	}

	public void setAddress19(String address19) {
		this.address19 = address19;
	}
	@Column(name = "address20")
	public String getAddress20() {
		return address20;
	}

	public void setAddress20(String address20) {
		this.address20 = address20;
	}
	@Column(name = "address21")
	public String getAddress21() {
		return address21;
	}

	public void setAddress21(String address21) {
		this.address21 = address21;
	}
	@Column(name = "address22")
	public String getAddress22() {
		return address22;
	}

	public void setAddress22(String address22) {
		this.address22 = address22;
	}
	@Column(name = "address23")
	public String getAddress23() {
		return address23;
	}

	public void setAddress23(String address23) {
		this.address23 = address23;
	}
	@Column(name = "address24")
	public String getAddress24() {
		return address24;
	}

	public void setAddress24(String address24) {
		this.address24 = address24;
	}
	@Column(name = "address25")
	public String getAddress25() {
		return address25;
	}

	public void setAddress25(String address25) {
		this.address25 = address25;
	}
	@Column(name = "address26")
	public String getAddress26() {
		return address26;
	}

	public void setAddress26(String address26) {
		this.address26 = address26;
	}
	
	
	
	
	@Column(name = "remark1")
	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	@Column(name = "remark2")
	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	@Column(name = "remark3")
	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	@Column(name = "remark4")
	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}
	@Column(name = "remark5")
	public String getRemark5() {
		return remark5;
	}

	public void setRemark5(String remark5) {
		this.remark5 = remark5;
	}
	@Column(name = "remark6")
	public String getRemark6() {
		return remark6;
	}

	public void setRemark6(String remark6) {
		this.remark6 = remark6;
	}
	@Column(name = "remark7")
	public String getRemark7() {
		return remark7;
	}

	public void setRemark7(String remark7) {
		this.remark7 = remark7;
	}
	@Column(name = "remark8")

	public String getRemark8() {
		return remark8;
	}

	public void setRemark8(String remark8) {
		this.remark8 = remark8;
	}
	@Column(name = "remark9")
	public String getRemark9() {
		return remark9;
	}

	public void setRemark9(String remark9) {
		this.remark9 = remark9;
	}
	@Column(name = "remark10")
	public String getRemark10() {
		return remark10;
	}

	public void setRemark10(String remark10) {
		this.remark10 = remark10;
	}
	@Column(name = "remark11")
	public String getRemark11() {
		return remark11;
	}

	public void setRemark11(String remark11) {
		this.remark11 = remark11;
	}
	@Column(name = "remark12")
	public String getRemark12() {
		return remark12;
	}

	public void setRemark12(String remark12) {
		this.remark12 = remark12;
	}
	@Column(name = "remark13")
	public String getRemark13() {
		return remark13;
	}

	public void setRemark13(String remark13) {
		this.remark13 = remark13;
	}
	@Column(name = "remark14")
	public String getRemark14() {
		return remark14;
	}

	public void setRemark14(String remark14) {
		this.remark14 = remark14;
	}
	@Column(name = "remark15")
	public String getRemark15() {
		return remark15;
	}

	public void setRemark15(String remark15) {
		this.remark15 = remark15;
	}
	@Column(name = "remark16")
	public String getRemark16() {
		return remark16;
	}

	public void setRemark16(String remark16) {
		this.remark16 = remark16;
	}
	@Column(name = "remark17")
	public String getRemark17() {
		return remark17;
	}

	public void setRemark17(String remark17) {
		this.remark17 = remark17;
	}
	@Column(name = "remark18")
	public String getRemark18() {
		return remark18;
	}

	public void setRemark18(String remark18) {
		this.remark18 = remark18;
	}
	@Column(name = "remark19")
	public String getRemark19() {
		return remark19;
	}

	public void setRemark19(String remark19) {
		this.remark19 = remark19;
	}
	@Column(name = "remark20")
	public String getRemark20() {
		return remark20;
	}

	public void setRemark20(String remark20) {
		this.remark20 = remark20;
	}
	@Column(name = "remark21")
	public String getRemark21() {
		return remark21;
	}

	public void setRemark21(String remark21) {
		this.remark21 = remark21;
	}
	@Column(name = "remark22")
	public String getRemark22() {
		return remark22;
	}

	public void setRemark22(String remark22) {
		this.remark22 = remark22;
	}
	@Column(name = "remark23")
	public String getRemark23() {
		return remark23;
	}

	public void setRemark23(String remark23) {
		this.remark23 = remark23;
	}
	@Column(name = "remark24")
	public String getRemark24() {
		return remark24;
	}

	public void setRemark24(String remark24) {
		this.remark24 = remark24;
	}
	@Column(name = "remark25")
	public String getRemark25() {
		return remark25;
	}

	public void setRemark25(String remark25) {
		this.remark25 = remark25;
	}
	@Column(name = "remark26")
	public String getRemark26() {
		return remark26;
	}

	public void setRemark26(String remark26) {
		this.remark26 = remark26;
	}

	@Column(name = "total")
	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	@ManyToOne
	@JoinColumn(name = "CHECKID")
	public EnvironmentEquipCheck getCheckid() {
		return checkid;
	}

	public void setCheckid(EnvironmentEquipCheck checkid) {
		this.checkid = checkid;
	}
	
	
	

}





























