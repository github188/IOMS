/* Copyright  2010 BEIJING ATNC CO,.LTD
 * All rights reserved
 *
 * create at Sep 27, 2010 11:12:41 AM
 * author:wangpeng E-mail:wangpeng@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.operstat.atm;

/**
 * 枚举类Model
 * 
 * @author wangpeng
 * @date:Sep 27, 2010 11:12:41 AM
 * @version 1.0
 */

public class EnumModel {
	private String name;
	private String value;
	private int ordinal;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the ordinal
	 */
	public int getOrdinal() {
		return ordinal;
	}

	/**
	 * @param ordinal
	 *            the ordinal to set
	 */
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
}
