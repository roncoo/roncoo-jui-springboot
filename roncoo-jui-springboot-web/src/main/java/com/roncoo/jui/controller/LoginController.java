/**
 * Copyright 2015-2016 广州市领课网络科技有限公司
 */
package com.roncoo.jui.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roncoo.jui.biz.LoginBiz;
import com.roncoo.jui.common.bean.dto.Result;

/**
 * @author wujing
 */
@Controller
public class LoginController {

	@Autowired
	private LoginBiz biz;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		Result<String> result = biz.login();
		if (result.isStatus()) {

			// 本地发布请打开这里即可，请注释下面 return "redirect:" + result.getResultData();
			// session.setAttribute("roncoo", "www.roncoo.com");
			
			// 进行龙果学院授权登录
			return "redirect:" + result.getResultData();
		}
		return "redirect:/admin/index";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String getLogin(@RequestParam(value = "code", defaultValue = "") String code, RedirectAttributes redirectAttributes, HttpSession session) {
		Result<String> result = biz.oauth(code);
		if (result.isStatus()) {
			// 成功之后，传入session
			session.setAttribute("roncoo", result.getResultData());
		}
		// 重定向到登录页面，由它来判断session进行登录
		return "redirect:/admin/index";
	}

}
