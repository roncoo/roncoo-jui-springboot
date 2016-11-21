/*
 * Copyright 2015-2016 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.roncoo.jui.biz;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.util.ConfUtil;

/**
 * 登录
 * 
 * @author wujing
 */
@Component
public class LoginBiz {
	private static final Logger logger = LoggerFactory.getLogger(LoginBiz.class);

	/**
	 * 跳转登录
	 * 
	 * @return
	 */
	public Result<String> login() {
		Result<String> result = new Result<String>();
		String url = ConfUtil.getProperty("baseUrl") + ConfUtil.getProperty("oauth2AuthorizeUrl");
		try {
			url = url.replace("{CLIENTID}", ConfUtil.getProperty("clientId")).replace("{RESPONSETYPE}", "code").replace("{REDIRECTURI}", URLEncoder.encode(ConfUtil.getProperty("redirectUrl"), "utf-8"));
			result.setStatus(true);
			result.setErrCode(0);
			result.setResultData(url);
		} catch (UnsupportedEncodingException e) {
			logger.error(url, e);
			e.printStackTrace();
		}
		return result;
	}

}
