/* Copyright © 2011 BEIJING YiZhanHengTong Science & Technology Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-2-25 下午02:18:55
 * author:huangyijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import cn.com.atnc.ioms.enums.basedata.KuServiceRateType;

/**
 * @author:huangyijie
 * @date:2011-2-25 下午02:18:55
 * @version:1.0
 */

public class KuServiceRateTypeCustomDeserializer extends
		JsonDeserializer<Enum<?>> {

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
	 *      org.codehaus.jackson.map.DeserializationContext)
	 */
	@Override
	public Enum<?> deserialize(JsonParser parser,
			DeserializationContext deContext) throws IOException,
			JsonProcessingException {
		try {
			int index = parser.getValueAsInt();
			for (KuServiceRateType type : KuServiceRateType.values()) {
				if (type.ordinal() - index == 0) {
					return type;
				}
			}
		} catch (IOException e) {
			String value = parser.getText();
			for (KuServiceRateType type : KuServiceRateType.values()) {
				if (type.getValue().equals(value)) {
					return type;
				}
			}
		}
		return null;
	}
}
