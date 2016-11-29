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
package com.roncoo.jui.common.service;

import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.bean.entity.RcDataDictionaryList;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 
 * @author wujing
 */
public interface DataDictionaryListService {

	/**
	 * @param currentPage
	 * @param numPerPage
	 * @param fieldCode
	 * @param rcDataDictionaryList
	 */
	Result<Page<RcDataDictionaryList>> listForPage(int currentPage, int numPerPage, String fieldCode, RcDataDictionaryList rcDataDictionaryList);

	/**
	 * 保存
	 * 
	 * @param rcDataDictionaryList
	 * @return
	 */
	Result<RcDataDictionaryList> save(RcDataDictionaryList rcDataDictionaryList);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	Result<String> delete(Long id);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	Result<RcDataDictionaryList> query(Long id);

	/**
	 * 更新
	 * 
	 * @param rcDataDictionaryList
	 * @return
	 */
	Result<RcDataDictionaryList> update(RcDataDictionaryList rcDataDictionaryList);

	/**
	 * @param fieldCode
	 * @return
	 */
	Result<String> deleteByFieldCode(String fieldCode);

}
