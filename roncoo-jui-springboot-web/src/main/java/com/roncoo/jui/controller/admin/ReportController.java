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
package com.roncoo.jui.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roncoo.jui.biz.ReportBiz;
import com.roncoo.jui.common.entity.RcReport;
import com.roncoo.jui.common.util.base.BaseController;
import com.roncoo.jui.common.util.base.Result;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 报表
 * 
 * @author wujing
 */
@Controller
@RequestMapping(value = "/admin/report", method = RequestMethod.POST)
public class ReportController extends BaseController {

	// private static final String NAVTABID = "report";

	@Autowired
	private ReportBiz biz;

	/**
	 * 分页查看
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param modelMap
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage, @RequestParam(defaultValue = "20") int numPerPage, @RequestParam(value = "orderField", required = false) String orderField, @RequestParam(value = "orderDirection", required = false) String orderDirection, @ModelAttribute RcReport rcReport, ModelMap modelMap) {
		Result<Page<RcReport>> result = biz.listForPage(currentPage, numPerPage, orderField, orderDirection, rcReport);
		if (result.isStatus()) {
			modelMap.put("page", result.getResultData());
			modelMap.put("bean", rcReport);
		}
	}

	/**
	 * 导出
	 * 
	 * @param id
	 * @param modelMap
	 * @throws IOException
	 */
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void download(HttpServletResponse response) throws IOException {
		biz.exportExcel(response);
	}

}
