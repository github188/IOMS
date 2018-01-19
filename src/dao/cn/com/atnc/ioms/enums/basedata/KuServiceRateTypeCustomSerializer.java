/* Copyright © 2011 BEIJING YiZhanHengTong Science & Technology Co.,Ltd.
 * All rights reserved
 *
 * created at 2011-2-25 下午02:18:55
 * author:huangyijie E-mail:huangyijie@atnc.com.cn
 */

package cn.com.atnc.ioms.enums.basedata;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * @author:huangyijie
 * @date:2011-2-25 下午02:18:55
 * @version:1.0
 */

public class KuServiceRateTypeCustomSerializer extends JsonSerializer<Enum<?>> {

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object,
	 *      org.codehaus.jackson.JsonGenerator,
	 *      org.codehaus.jackson.map.SerializerProvider)
	 */
	@Override
	public void serialize(Enum<?> e, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		jgen.writeStartObject();
		jgen.writeStringField("name", e.name());
		jgen.writeNumberField("key", e.ordinal());
		jgen.writeStringField("value", e.toString());
		jgen.writeEndObject();
	
	}
}
