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
import org.springframework.transaction.annotation.Transactional;

import com.roncoo.jui.common.bean.RcDataDictionary;
import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.service.DataDictionaryListService;
import com.roncoo.jui.common.service.DataDictionaryService;
import com.roncoo.jui.common.util.base.Base;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 数据字典逻辑业务类
 * 
 * @author LYQ
 */
@Component
public class DataDictionaryBiz extends Base{

	@Autowired
	private DataDictionaryService dictionaryService;

	@Autowired
	private DataDictionaryListService dictionaryListService;

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	public Result<Page<RcDataDictionary>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		return dictionaryService.listForPage(pageCurrent, pageSize, date, search);
	}

	/**
	 * 添加
	 * 
	 * @param rcDataDictionary
	 */
	public Result<RcDataDictionary> save(RcDataDictionary rcDataDictionary) {
		return dictionaryService.save(rcDataDictionary);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param fieldCode
	 */
	@Transactional
	public Result<String> delete(Long id, String fieldCode) {
		dictionaryListService.deleteByFieldCode(fieldCode);
		return dictionaryService.deleteById(id);
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public Result<RcDataDictionary> query(Long id) {
		return dictionaryService.queryById(id);
	}

	/**
	 * 更新
	 * 
	 * @param dictionary
	 * @param oldFieldCode
	 */
	@Transactional
	public Result<RcDataDictionary> update(RcDataDictionary dictionary, String oldFieldCode) {
		Result<RcDataDictionary> result = dictionaryService.update(dictionary);
		if (oldFieldCode != dictionary.getFieldCode()) {
			dictionaryListService.updateForFieldCode(oldFieldCode, dictionary.getFieldCode());
		}
		return result;
	}

	/**
	 * @param currentPage
	 * @param numPerPage
	 * @param rcDataDictionary
	 * @return
	 */
	public Result<Page<RcDataDictionary>> listForPage(int currentPage, int numPerPage, RcDataDictionary rcDataDictionary) {
		Result<Page<RcDataDictionary>> result = new Result<Page<RcDataDictionary>>();
		return result;
	}
}
