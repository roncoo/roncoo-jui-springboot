/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.roncoo.jui.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roncoo.jui.common.util.base.BaseController;

/**
 * @author wujing
 */
@Controller
@RequestMapping(value = "admin")
public class IndexController extends BaseController {

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(HttpSession session) {
		if (session.getAttribute("roncoo") != null) {
			return "admin/index";
		}
		return "redirect:/";
	}

	/**
	 * 进入首页
	 */
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String postIndex() {
		return "redirect:/admin/index";
	}

}
