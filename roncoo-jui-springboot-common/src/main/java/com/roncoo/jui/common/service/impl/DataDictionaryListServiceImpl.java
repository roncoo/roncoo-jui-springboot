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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.roncoo.jui.common.bean.RcDataDictionaryList;
import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.dao.DataDictionaryListDao;
import com.roncoo.jui.common.service.DataDictionaryListService;
import com.roncoo.jui.common.util.base.Base;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 数据字典明细服务接口实现类
 * 
 * @author wujing
 */
@Service
public class DataDictionaryListServiceImpl extends Base implements DataDictionaryListService {

	@Autowired
	private DataDictionaryListDao dao;

	@Override
	public Result<Page<RcDataDictionaryList>> listForPage(int pageCurrent, int pageSize, String fieldCode, String date, String search) {
		Result<Page<RcDataDictionaryList>> result = new Result<Page<RcDataDictionaryList>>();
		if (pageCurrent < 1) {
			result.setErrMsg("pageCurrent有误");
			return result;
		}
		if (pageSize < 1) {
			result.setErrMsg("pageSize有误");
			return result;
		}
		if (!StringUtils.hasText(fieldCode)) {
			result.setErrMsg("fieldCode不能为空");
			return result;
		}
		result.setResultData(dao.listForPage(pageCurrent, pageSize, fieldCode, date, search));
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<RcDataDictionaryList> save(RcDataDictionaryList rcDataDictionaryList) {
		Result<RcDataDictionaryList> result = new Result<RcDataDictionaryList>();
		if (!StringUtils.hasText(rcDataDictionaryList.getFieldKey())) {
			result.setErrMsg("key不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcDataDictionaryList.getFieldValue())) {
			result.setErrMsg("value不能为空");
			return result;
		}
		if (rcDataDictionaryList.getSort() < 1) {
			result.setErrMsg("排序有误");
			return result;
		}
		if (dao.insert(rcDataDictionaryList) > 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("保存成功");
		}
		result.setResultData(rcDataDictionaryList);
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
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("删除成功");
		}
		return result;
	}

	@Override
	public Result<String> deleteByFieldCode(String fieldCode) {
		Result<String> result = new Result<String>();
		if (!StringUtils.hasText(fieldCode)) {
			result.setErrMsg("fieldCode不能为空");
			return result;
		}
		if (dao.deleteByFieldCode(fieldCode) > 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("删除成功");
		}
		return result;
	}

	@Override
	public Result<List<RcDataDictionaryList>> listByFieldCode(String fieldCode) {
		Result<List<RcDataDictionaryList>> result = new Result<List<RcDataDictionaryList>>();
		if (!StringUtils.hasText(fieldCode)) {
			result.setErrMsg("fieldCode不能为空");
			return result;
		}
		result.setResultData(dao.listByFieldCode(fieldCode));
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<RcDataDictionaryList> queryById(Long id) {
		Result<RcDataDictionaryList> result = new Result<RcDataDictionaryList>();
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
	public Result<RcDataDictionaryList> update(RcDataDictionaryList rcDataDictionaryList) {
		Result<RcDataDictionaryList> result = new Result<>();
		if (!StringUtils.hasText(rcDataDictionaryList.getFieldKey())) {
			result.setErrMsg("key不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcDataDictionaryList.getFieldValue())) {
			result.setErrMsg("value不能为空");
			return result;
		}
		if (rcDataDictionaryList.getSort() < 1) {
			result.setErrMsg("排序有误");
			return result;
		}
		if (dao.updateById(rcDataDictionaryList) > 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("更新成功");
		}
		result.setResultData(rcDataDictionaryList);
		return result;
	}

	@Override
	public Result<String> updateForFieldCode(String fieldCodePremise, String fieldCode) {
		Result<String> result = new Result<String>();
		if (!StringUtils.hasText(fieldCodePremise)) {
			result.setErrMsg("fieldCodePremise不能为空");
			return result;
		}
		if (!StringUtils.hasText(fieldCode)) {
			result.setErrMsg("fieldCode不能为空");
			return result;
		}
		if (dao.updateByFieldCode(fieldCodePremise, fieldCode) > 0) {
			result.setErrCode(0);
			result.setStatus(true);
			result.setErrMsg("更新成功");
		}
		return result;
	}

}
