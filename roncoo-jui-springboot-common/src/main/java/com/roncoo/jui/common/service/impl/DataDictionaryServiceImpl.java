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
import org.springframework.util.StringUtils;

import com.roncoo.jui.common.bean.RcDataDictionary;
import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.dao.DataDictionaryDao;
import com.roncoo.jui.common.service.DataDictionaryService;
import com.roncoo.jui.common.util.jui.Page;


/**
 * 数据字典
 * 
 * @author LYQ
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Autowired
	private DataDictionaryDao dao;

	@Override
	public Result<RcDataDictionary> save(RcDataDictionary rcDataDictionary) {
		Result<RcDataDictionary> result = new Result<RcDataDictionary>();
		// 校验字段
		if (!StringUtils.hasText(rcDataDictionary.getFieldName())) {
			result.setErrMsg("字段名不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcDataDictionary.getFieldCode())) {
			result.setErrMsg("Code不能为空");
			return result;
		}
		if (rcDataDictionary.getSort() < 1) {
			result.setErrMsg("排序无效");
			return result;
		}
		if (dao.insert(rcDataDictionary) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setErrMsg("保存成功");
		}
		result.setResultData(rcDataDictionary);
		return result;
	}

	@Override
	public Result<Page<RcDataDictionary>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcDataDictionary>> result = new Result<Page<RcDataDictionary>>();
		if (pageCurrent < 1) {
			result.setErrMsg("pageCurrent有误");
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("pageSize有误");
			return result;
		}
		result.setResultData(dao.listForPage(pageCurrent, pageSize, date, search));
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<RcDataDictionary> queryById(Long id) {
		Result<RcDataDictionary> result = new Result<RcDataDictionary>();
		if (id < 1) {
			result.setErrMsg("此id无效");
			return result;
		}
		result.setResultData(dao.selectById(id));
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<String> deleteById(Long id) {
		Result<String> result = new Result<String>();
		if (id < 1) {
			result.setErrMsg("此id无效");
			return result;
		}
		if (dao.deleteById(id) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setErrMsg("删除成功");
		}
		return result;
	}

	@Override
	public Result<RcDataDictionary> update(RcDataDictionary rcDataDictionary) {
		Result<RcDataDictionary> result = new Result<RcDataDictionary>();
		// 校验字段
		// 校验字段
		if (!StringUtils.hasText(rcDataDictionary.getFieldName())) {
			result.setErrMsg("字段名不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcDataDictionary.getFieldCode())) {
			result.setErrMsg("Code不能为空");
			return result;
		}
		if (rcDataDictionary.getSort() < 1) {
			result.setErrMsg("排序无效");
			return result;
		}
		if (dao.updateById(rcDataDictionary) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setErrMsg("更新成功");
		}
		result.setResultData(rcDataDictionary);
		return result;
	}

}
