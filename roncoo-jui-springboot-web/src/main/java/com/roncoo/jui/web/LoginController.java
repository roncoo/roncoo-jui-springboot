/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.roncoo.jui.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wujing
 */
@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void getLogin() {

	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String postLogin() {
		return "redirect:/admin/index";
	}

}
