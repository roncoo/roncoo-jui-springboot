/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.roncoo.jui.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wujing
 */
public final class JSONUtil {

	private JSONUtil() {
	}

	public static String toJSONString(Object o) {
		ObjectMapper m = new ObjectMapper();
		try {
			return m.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			return "";
		}
	}

}
