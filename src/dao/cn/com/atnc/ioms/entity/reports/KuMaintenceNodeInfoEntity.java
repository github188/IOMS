/* Copyright @2017 Beijing ATNC Co.,Ltd. All rights reserved
 *
 * 创建人：王凌斌
 * 创建时间：@2017年1月19日 上午11:20:37
 * 
 * 修改人：
 * 修改时间：
 * 修改内容：
 */
package cn.com.atnc.ioms.entity.reports;


/**
 * MODEM参数实体
 * 
 * @author 王凌斌
 * @2017年1月19日 下午4:39:20
 */
public class KuMaintenceNodeInfoEntity {

	// MODEM参数：节点号
	private String node;
	// MODEM参数：当前发射电平
	private String emissionLevel;
	// MODEM参数：载波频率参数
	private String carrier;
	/**
	 * 
	 */
	public KuMaintenceNodeInfoEntity() {
		super();
	}
	/**
	 * @param node
	 * @param emissionLevel
	 * @param carrier
	 */
	public KuMaintenceNodeInfoEntity(String node, String emissionLevel,
			String carrier) {
		super();
		this.node = node;
		this.emissionLevel = emissionLevel;
		this.carrier = carrier;
	}

	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	public String getEmissionLevel() {
		return emissionLevel;
	}
	public void setEmissionLevel(String emissionLevel) {
		this.emissionLevel = emissionLevel;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
}
