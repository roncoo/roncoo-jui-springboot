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

import com.roncoo.jui.common.bean.RcDataDictionaryList;
import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.service.DataDictionaryListService;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 数据字典明细逻辑功能
 * 
 * @author LYQ
 */
@Component
public class DataDictionaryListBiz {

	@Autowired
	private DataDictionaryListService dictionaryListService;

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param id
	 * @return
	 */
	public Result<Page<RcDataDictionaryList>> listForPage(int pageCurrent, int pageSize, String fieldCode, String date, String search) {
		return dictionaryListService.listForPage(pageCurrent, pageSize, fieldCode, date, search);
	}

	/**
	 * 根据id删除
	 */
	public Result<String> deleteById(Long id) {
		return dictionaryListService.deleteById(id);
	}

	/**
	 * 添加
	 * 
	 * @param rcDataDictionaryList
	 * @param id
	 */
	public Result<RcDataDictionaryList> save(RcDataDictionaryList rcDataDictionaryList) {
		return dictionaryListService.save(rcDataDictionaryList);
	}

	/**
	 * 根据id获取
	 * 
	 * @param id
	 * @return
	 */
	public Result<RcDataDictionaryList> queryById(Long id) {
		return dictionaryListService.queryById(id);
	}

	/**
	 * 更新
	 * 
	 * @param rDataDictionaryList
	 */
	public Result<RcDataDictionaryList> update(RcDataDictionaryList rDataDictionaryList) {
		return dictionaryListService.update(rDataDictionaryList);
	}

}
