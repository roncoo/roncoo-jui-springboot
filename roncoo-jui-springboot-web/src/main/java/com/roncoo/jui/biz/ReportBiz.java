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

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.jui.common.entity.RcReport;
import com.roncoo.jui.common.service.ReportService;
import com.roncoo.jui.common.util.base.Base;
import com.roncoo.jui.common.util.base.Result;
import com.roncoo.jui.common.util.excel.ReportExcelUtil;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 
 * @author wujing
 */
@Component
public class ReportBiz extends Base {

	@Autowired
	private ReportService reportService;

	/**
	 * @param currentPage
	 * @param numPerPage
	 * @param rcDataDictionary
	 * @return
	 */
	public Result<Page<RcReport>> listForPage(int currentPage, int numPerPage, String orderField, String orderDirection, RcReport rcReport) {
		return reportService.listForPage(currentPage, numPerPage, orderField, orderDirection, rcReport);
	}

	public void exportExcel(HttpServletResponse response) throws IOException {
		// 获取数据
		Result<Page<RcReport>> result = listForPage(1, 200, "", "", new RcReport());
		if (result.isStatus()) {
			Page<RcReport> page = result.getResultData();
			if (page.getList().size() > 0) {
				// 生成报表
				response.setContentType("application/vnd.ms-excel;charset=utf-8");// 设置强制下载不打开
				response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("龙果学院-报表测试", "utf-8") + ".xlsx");// 设置文件名
				ReportExcelUtil.exportExcel("龙果学院", new String[] { "用户邮箱", "用户昵称" }, page.getList(), response.getOutputStream());
			}
		}
	}

}
