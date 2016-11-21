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

import java.util.List;

import com.roncoo.jui.common.bean.RcDataDictionaryList;
import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.util.jui.Page;



/**
 * 数据字典明细服务功能
 * 
 * @author LYQ
 */
public interface DataDictionaryListService {

	/**
	 * 分页查询
	 * 
	 * @param fieldCode
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	Result<Page<RcDataDictionaryList>> listForPage(int pageCurrent, int pageSize, String fieldCode, String date, String search);

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
	Result<String> deleteById(Long id);

	/**
	 * 根据fieldCode进行删除
	 * 
	 * @param fieldCode
	 * @return
	 */
	Result<String> deleteByFieldCode(String fieldCode);

	/**
	 * 根据fieldCode查询
	 * 
	 * @param fieldCode
	 * @return
	 */
	Result<List<RcDataDictionaryList>> listByFieldCode(String fieldCode);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	Result<RcDataDictionaryList> queryById(Long id);

	/**
	 * 更新
	 * 
	 * @param rcDataDictionaryList
	 * @return
	 */
	Result<RcDataDictionaryList> update(RcDataDictionaryList rcDataDictionaryList);

	/**
	 * 根据fieldCode更新
	 * 
	 * @param fieldCodePremise
	 * @param fieldCode
	 * @return
	 */
	Result<String> updateForFieldCode(String fieldCodePremise, String fieldCode);
}
