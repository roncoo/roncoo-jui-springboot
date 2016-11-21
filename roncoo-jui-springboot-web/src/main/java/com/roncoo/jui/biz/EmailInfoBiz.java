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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.roncoo.jui.common.bean.RcEmailInfo;
import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.service.EmailInfoService;
import com.roncoo.jui.common.util.jui.Page;

/**
 * @author wujing
 */
@Component
public class EmailInfoBiz {

	@Autowired
	private EmailInfoService emailInfoService;

	/**
	 * 分页查询
	 */
	public Result<Page<RcEmailInfo>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		return emailInfoService.listForPage(pageCurrent, pageSize, date, search);
	}


	/**
	 * 根据id进行删除
	 * 
	 * @param id
	 */
	public Result<String> deleteById(Long id) {
		return emailInfoService.deleteById(id);
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Result<RcEmailInfo> queryById(Long id) {
		return emailInfoService.queryById(id);
	}
}
