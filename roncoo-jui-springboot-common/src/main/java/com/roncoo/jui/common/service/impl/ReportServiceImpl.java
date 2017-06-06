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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.bean.entity.RcReport;
import com.roncoo.jui.common.dao.ReportDao;
import com.roncoo.jui.common.service.ReportService;
import com.roncoo.jui.common.util.base.Base;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 数据字典明细服务接口实现类
 * 
 * @author wujing
 */
@Service
public class ReportServiceImpl extends Base implements ReportService {

	@Autowired
	private ReportDao dao;

	@Override
	public Result<Page<RcReport>> listForPage(int currentPage, int numPerPage, String orderField, String orderDirection, RcReport rcReport) {
		Result<Page<RcReport>> result = new Result<>();
		Page<RcReport> page = dao.listForPage(currentPage, numPerPage, orderField, orderDirection, rcReport);
		result.setStatus(true);
		result.setErrCode(0);
		result.setResultData(page);
		return result;
	}

	@Override
	public Result<Integer> save(RcReport rcReport) {
		Result<Integer> result = new Result<>();
		result.setStatus(true);
		result.setErrCode(0);
		result.setResultData(dao.insert(rcReport));
		return result;
	}

}
