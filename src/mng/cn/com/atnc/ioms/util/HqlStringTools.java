/* Copyright ? 2013 BEIJING ATNC Co.,Ltd.
 * All rights reserved
 *
 * created at 2013-10-10 上午9:07:01
 * author:HuangYijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.util;

import cn.com.atnc.common.model.BaseModel;
import cn.com.atnc.common.util.StringTools;

/**
 * @author:huangyijie
 * @date:2013-10-10 上午9:07:01
 */
public class HqlStringTools extends BaseModel {

	public static String replaceSpecialChar(String str) {
		if(!StringTools.hasText(str)){
			return str;
		}
		if (str.indexOf("[") >= 0) {
			str=str.replace("[", "[[]");
		}
		if (str.indexOf("]") >= 0) {
			str=str.replace("]", "[]]");
		}
		if (str.indexOf("%") >= 0) {
			str=str.replace("%", "/%");
		}
		if (str.indexOf("_") >= 0) {
			str=str.replace("_", "/_");
		}
		if (str.indexOf("^") >= 0) {
			str=str.replace("^", "[^]");
		}
		return str;
	}
}
