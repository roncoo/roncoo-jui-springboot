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
import com.roncoo.jui.common.bean.entity.RcDataDictionary;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 
 * @author wujing
 */
public interface DataDictionaryService {
	
	/**
	 * 
	 * @param currentPage
	 * @param numPerPage
	 * @param orderField
	 * @param orderDirection
	 * @param rcDataDictionary
	 * @return
	 */
	Result<Page<RcDataDictionary>> listForPage(int currentPage, int numPerPage, String orderField, String orderDirection, RcDataDictionary rcDataDictionary);

	/**
	 * 
	 * @param rcDataDictionary
	 * @return
	 */
	Result<RcDataDictionary> save(RcDataDictionary rcDataDictionary);



	/**
	 * 
	 * @param id
	 * @return
	 */
	Result<String> delete(Long id);
	

	/**
	 * 
	 * @param id
	 * @return
	 */
	Result<RcDataDictionary> query(Long id);

	/**
	 * 
	 * @param rcDataDictionary
	 * @return
	 */
	Result<RcDataDictionary> update(RcDataDictionary rcDataDictionary);

	
}
