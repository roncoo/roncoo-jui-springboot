/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.roncoo.jui.common.util;

import com.alibaba.druid.support.json.JSONUtils;

/**
 * @author wujing
 */
public final class JSONUtil {
	
	private JSONUtil() {
	}

	public static String toJSONString(Object o) {
		return JSONUtils.toJSONString(o);
	}
}
