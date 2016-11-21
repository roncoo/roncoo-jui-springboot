/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.roncoo.jui.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wujing
 */
@Controller
@RequestMapping(value = "admin")
public class IndexController {

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public void index() {

	}

}
