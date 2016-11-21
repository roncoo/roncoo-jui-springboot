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

import com.roncoo.jui.common.bean.RcDataDictionary;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 数据字典数据交换功能
 * 
 * @author LYQ
 */
public interface DataDictionaryDao {

	/**
	 * 添加
	 * 
	 * @param rcDataDictionary
	 * @return
	 */
	int insert(RcDataDictionary rcDataDictionary);

	/**
	 * 分页查询
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @return
	 */
	Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize, String date, String search);

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	RcDataDictionary selectById(Long id);

	/**
	 * 根据id删除
	 * 
	 * @param id
	 */
	int deleteById(Long id);

	/**
	 * 更新
	 * 
	 * @param rcDataDictionary
	 * @return
	 */
	int updateById(RcDataDictionary rcDataDictionary);

}
