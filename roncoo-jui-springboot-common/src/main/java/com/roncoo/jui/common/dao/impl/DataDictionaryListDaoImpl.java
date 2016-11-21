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
package com.roncoo.jui.common.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.roncoo.jui.common.bean.RcDataDictionaryList;
import com.roncoo.jui.common.bean.RcDataDictionaryListExample;
import com.roncoo.jui.common.bean.RcDataDictionaryListExample.Criteria;
import com.roncoo.jui.common.dao.DataDictionaryListDao;
import com.roncoo.jui.common.dao.impl.mapper.RcDataDictionaryListMapper;
import com.roncoo.jui.common.util.jui.Page;
import com.roncoo.jui.common.util.jui.SqlUtil;


/**
 * 
 * @author wujing
 */
@Repository
public class DataDictionaryListDaoImpl implements DataDictionaryListDao {

	@Autowired
	private RcDataDictionaryListMapper mapper;

	@Override
	public int deleteByFieldCode(String fieldCode) {
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(fieldCode);
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RcDataDictionaryList rcDataDictionaryList) {
		Date date = new Date();
		rcDataDictionaryList.setCreateTime(date);
		rcDataDictionaryList.setUpdateTime(date);
		return mapper.insertSelective(rcDataDictionaryList);
	}

	@Override
	public Page<RcDataDictionaryList> listForPage(int pageCurrent, int pageSize, String fieldCode, String date, String search) {
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		example.setOrderByClause("sort asc");
		Criteria criteria = example.createCriteria();
		if (StringUtils.hasText(search)) {
			criteria.andFieldKeyLike(SqlUtil.like(search));
		}
		criteria.andFieldCodeEqualTo(fieldCode);
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		List<RcDataDictionaryList> list = mapper.selectByExample(example);
		Page<RcDataDictionaryList> page = new Page<RcDataDictionaryList>(totalCount, totalPage, pageCurrent, pageSize, list);
		return page;
	}

	@Override
	public RcDataDictionaryList selectById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateById(RcDataDictionaryList rcDataDictionaryList) {
		rcDataDictionaryList.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(rcDataDictionaryList);
	}

	@Override
	public List<RcDataDictionaryList> listByFieldCode(String fieldCode) {
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		example.setOrderByClause("sort desc");
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(fieldCode);
		return mapper.selectByExample(example);
	}

	@Override
	public int updateByFieldCode(String fieldCodePremise, String fieldCode) {
		RcDataDictionaryList dList = new RcDataDictionaryList();
		dList.setFieldCode(fieldCode);
		RcDataDictionaryListExample example = new RcDataDictionaryListExample();
		Criteria criteria = example.createCriteria();
		criteria.andFieldCodeEqualTo(fieldCodePremise);
		return mapper.updateByExampleSelective(dList, example);
	}
}
