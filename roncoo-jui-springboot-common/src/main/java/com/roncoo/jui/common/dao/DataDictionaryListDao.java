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
package com.roncoo.jui.common.dao;

import java.util.List;

import com.roncoo.jui.common.bean.RcDataDictionaryList;
import com.roncoo.jui.common.util.jui.Page;



/**
 * 
 * @author LYQ
 *
 */
public interface DataDictionaryListDao {

	/**
	 * 根据FieldCode删除
	 * 
	 * @param FieldCode
	 * @return
	 */
	int deleteByFieldCode(String FieldCode);

	/**
	 * 
	 * 功能：根据id删除
	 * 
	 * 
	 * @param id
	 * @return int
	 */
	int deleteById(Long id);

	/**
	 * 添加
	 * 
	 * @param rcDataDictionaryList
	 * @return
	 */
	int insert(RcDataDictionaryList rcDataDictionaryList);

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param fieldCode
	 * @return
	 */
	Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode, String date, String search);

	/**
	 * 
	 * 功能：根据id查询
	 * 
	 * @param id
	 * @return RcDataDictionaryList
	 */
	RcDataDictionaryList selectById(Long id);

	/**
	 * 根据id更新
	 * 
	 * @param rcDataDictionaryList
	 * @return
	 */
	int updateById(RcDataDictionaryList rcDataDictionaryList);

	/**
	 * 根据fieldCode查询
	 * 
	 * @param fieldCode
	 * @return
	 */
	List<RcDataDictionaryList> listByFieldCode(String fieldCode);

	/**
	 * 根据fieldCode更新
	 * 
	 * @param fieldCodePremise
	 * @param fieldCode
	 * @return
	 */
	int updateByFieldCode(String fieldCodePremise, String fieldCode);
}
