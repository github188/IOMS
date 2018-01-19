package cn.com.atnc.ioms.entity.duty.environment.ups;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import cn.com.atnc.ioms.entity.MyStringUUIDEntity;
import cn.com.atnc.ioms.entity.duty.environment.EnvironmentEquipCheck;
/**
 * 零地电压和零线电流测试
 * @author renyujuan
 * @date 2016年7月6日下午2:53:43
 */
@Entity
@Table(name="TB_OM_DUTY_UPS_ZGV_ZLC_MEA")
public class ZgvZlcMeasure extends MyStringUUIDEntity {

	/**
	 * @date 2016年7月6日 下午2:53:30
	 */
	private static final long serialVersionUID = 1L;
	
	private String zgvInputResult;					//输入端零地电压测试结果
	private String zgvInputRemark;					//输入端零地电压备注
	private String zgvOutputResult;					//输出端零地电压测试结果
	private String zgvOutputRemark;					//输出端零地电压备注
	private String zlcInputResult;					//输入端零线电流测试结果
	private String zlcInputRemark;					//输入端零线电流备注
	private String zlcOutputResult;					//输出端零线电流测试结果
	private String zlcOutputRemark;					//输出端零线电流备注
	
	/*20160802添加属性 renyujuan*/
	private String zgvInputMeasure;					//输入端零地电压测量值
	private String zgvOutputMeasure;				//输出端零地电压测量值
	private String zlcInputMeasure;					//输入端零线电流测量值
	private String zlcOutputMeasure;				//输出端零线电流测量值
	
	private EnvironmentEquipCheck upsCheck;
	
	@Column(name="zgv_input_measure")
	public String getZgvInputMeasure() {
		return zgvInputMeasure;
	}
	public void setZgvInputMeasure(String zgvInputMeasure) {
		this.zgvInputMeasure = zgvInputMeasure;
	}
	@Column(name="zgv_output_measure")
	public String getZgvOutputMeasure() {
		return zgvOutputMeasure;
	}
	public void setZgvOutputMeasure(String zgvOutputMeasure) {
		this.zgvOutputMeasure = zgvOutputMeasure;
	}
	@Column(name="zlc_input_measure")
	public String getZlcInputMeasure() {
		return zlcInputMeasure;
	}
	public void setZlcInputMeasure(String zlcInputMeasure) {
		this.zlcInputMeasure = zlcInputMeasure;
	}
	@Column(name="zlc_output_measure")
	public String getZlcOutputMeasure() {
		return zlcOutputMeasure;
	}
	public void setZlcOutputMeasure(String zlcOutputMeasure) {
		this.zlcOutputMeasure = zlcOutputMeasure;
	}
	@Column(name="zgv_input_result")
	public String getZgvInputResult() {
		return zgvInputResult;
	}
	public void setZgvInputResult(String zgvInputResult) {
		this.zgvInputResult = zgvInputResult;
	}
	
	@Column(name="zgv_input_remark")
	public String getZgvInputRemark() {
		return zgvInputRemark;
	}
	public void setZgvInputRemark(String zgvInputRemark) {
		this.zgvInputRemark = zgvInputRemark;
	}
	
	@Column(name="zgv_output_result")
	public String getZgvOutputResult() {
		return zgvOutputResult;
	}
	public void setZgvOutputResult(String zgvOutputResult) {
		this.zgvOutputResult = zgvOutputResult;
	}
	
	@Column(name="zgv_output_remark")
	public String getZgvOutputRemark() {
		return zgvOutputRemark;
	}
	public void setZgvOutputRemark(String zgvOutputRemark) {
		this.zgvOutputRemark = zgvOutputRemark;
	}
	@Column(name="zlc_input_result")
	public String getZlcInputResult() {
		return zlcInputResult;
	}
	public void setZlcInputResult(String zlcInputResult) {
		this.zlcInputResult = zlcInputResult;
	}
	@Column(name="zlc_input_remark")
	public String getZlcInputRemark() {
		return zlcInputRemark;
	}
	public void setZlcInputRemark(String zlcInputRemark) {
		this.zlcInputRemark = zlcInputRemark;
	}
	@Column(name="zlc_output_result")
	public String getZlcOutputResult() {
		return zlcOutputResult;
	}
	public void setZlcOutputResult(String zlcOutputResult) {
		this.zlcOutputResult = zlcOutputResult;
	}
	@Column(name="zlc_output_remark")
	public String getZlcOutputRemark() {
		return zlcOutputRemark;
	}
	public void setZlcOutputRemark(String zlcOutputRemark) {
		this.zlcOutputRemark = zlcOutputRemark;
	}
	@ManyToOne
	@JoinColumn(name="ups_check_id")
	public EnvironmentEquipCheck getUpsCheck() {
		return upsCheck;
	}
	public void setUpsCheck(EnvironmentEquipCheck upsCheck) {
		this.upsCheck = upsCheck;
	}
	
	
	
	

}
