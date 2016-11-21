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
package com.roncoo.jui.common.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.roncoo.jui.common.bean.RcEmailAccountInfo;
import com.roncoo.jui.common.bean.RcEmailInfo;
import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.dao.EmailInfoDao;
import com.roncoo.jui.common.service.EmailInfoService;
import com.roncoo.jui.common.util.jui.Page;

import freemarker.template.Template;

/**
 * @author wujing
 */
@Service
public class EmailInfoServiceImpl implements EmailInfoService {

	private static final String TEMPLATE = "mail/roncoo.ftl";

	@Autowired
	private EmailInfoDao dao;

	@Autowired
	private JavaMailSenderImpl javaMailSender;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	@Override
	public Result<Page<RcEmailInfo>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcEmailInfo>> result = new Result<Page<RcEmailInfo>>();
		if (pageCurrent < 1) {
			result.setErrMsg("pageCurrent有误");
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("pageSize有误");
			return result;
		}
		result.setResultData(dao.listForPage(pageCurrent, pageSize, date, search));
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<RcEmailInfo> sendMail(RcEmailAccountInfo rcEmailAccountInfo, RcEmailInfo rcEmailInfo) {
		Result<RcEmailInfo> result = new Result<RcEmailInfo>();
		if (!StringUtils.hasText(rcEmailAccountInfo.getFromUser())) {
			result.setErrMsg("发件人不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailAccountInfo.getHost())) {
			result.setErrMsg("Host不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailAccountInfo.getPasswd())) {
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailInfo.getToUser())) {
			result.setErrMsg("收件人不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailInfo.getTitle())) {
			result.setErrMsg("标题不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailInfo.getSubject())) {
			result.setErrMsg("主题不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailInfo.getContent())) {
			result.setErrMsg("正文不能为空");
			return result;
		}
		// 编辑发送器
		createMailSender(rcEmailAccountInfo);

		HashMap<String, Object> map = new HashMap<>();
		map.put("content", rcEmailInfo.getContent());
		// 发送邮件
		send(rcEmailAccountInfo.getFromUser(), rcEmailInfo.getToUser(), rcEmailInfo.getSubject(), map, TEMPLATE);
		rcEmailInfo.setFromUser(rcEmailAccountInfo.getFromUser());
		// 保存记录

		if (dao.insert(rcEmailInfo) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setErrMsg("添加成功");
		}
		return result;
	}

	/**
	 * 
	 * @param to
	 * @param subject
	 * @param map
	 * @param templatePath
	 */
	private Result<RcEmailInfo> send(String fromUser, String to, String subject, Map<String, Object> map, String templatePath) {
		try {
			// 从FreeMarker模板生成邮件内容
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templatePath);
			String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
			this.threadPoolTaskExecutor.execute(new SendMailThread(fromUser, to, subject, text));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private void createMailSender(RcEmailAccountInfo info) {
		javaMailSender.setHost(info.getHost());
		javaMailSender.setUsername(info.getFromUser());
		javaMailSender.setPassword(info.getPasswd());
	}

	@Override
	public Result<String> deleteById(Long id) {
		Result<String> result = new Result<String>();
		if (id < 1) {
			result.setErrMsg("此id无效");
			return result;
		}
		if (dao.deleteById(id) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setErrMsg("删除成功");
		}
		return result;
	}

	@Override
	public Result<RcEmailInfo> queryById(Long id) {
		Result<RcEmailInfo> result = new Result<RcEmailInfo>();
		if (id < 1) {
			result.setErrMsg("此id无效");
			return result;
		}
		result.setResultData(dao.selectById(id));
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	// 内部线程类，利用线程池异步发邮件。
	private class SendMailThread implements Runnable {
		private String fromUser;
		private String to;
		private String subject;
		private String content;

		private SendMailThread(String fromUser, String to, String subject, String content) {
			super();
			this.fromUser = fromUser;
			this.to = to;
			this.subject = subject;
			this.content = content;
		}

		@Override
		public void run() {
			send(fromUser, to, subject, content);
		}

		private static final String NAME = "龙果学院";

		public void send(String fromUser, String to, String subject, String text) {
			try {
				MimeMessage message = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
				InternetAddress from = new InternetAddress();
				from.setAddress(fromUser);
				from.setPersonal(NAME, "UTF-8");
				helper.setFrom(from);
				helper.setTo(to);
				helper.setSubject(subject);
				helper.setText(text, true);
				javaMailSender.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
