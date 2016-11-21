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

import com.roncoo.jui.common.bean.RcDataDictionary;
import com.roncoo.jui.common.bean.RcDataDictionaryExample;
import com.roncoo.jui.common.bean.RcDataDictionaryExample.Criteria;
import com.roncoo.jui.common.dao.DataDictionaryDao;
import com.roncoo.jui.common.dao.impl.mapper.RcDataDictionaryMapper;
import com.roncoo.jui.common.util.jui.Page;
import com.roncoo.jui.common.util.jui.SqlUtil;

/**
 * 
 * @author wujing
 */
@Repository
public class DataDictionaryDaoImpl implements DataDictionaryDao {

	@Autowired
	private RcDataDictionaryMapper mapper;

	@Override
	public int insert(RcDataDictionary rcDataDictionary) {
		rcDataDictionary.setStatusId("1");
		rcDataDictionary.setCreateTime(new Date());
		rcDataDictionary.setUpdateTime(rcDataDictionary.getCreateTime());
		return mapper.insertSelective(rcDataDictionary);
	}

	@Override
	public Page<RcDataDictionary> listForPage(int pageCurrent, int pageSize, String date, String search) {
		RcDataDictionaryExample example = new RcDataDictionaryExample();
		example.setOrderByClause("sort asc");
		Criteria criteria = example.createCriteria();
		if (StringUtils.hasText(search)) {
			criteria.andFieldNameLike(SqlUtil.like(search));
		}
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		List<RcDataDictionary> list = mapper.selectByExample(example);
		Page<RcDataDictionary> page = new Page<RcDataDictionary>(totalCount, totalPage, pageCurrent, pageSize, list);
		return page;
	}

	@Override
	public RcDataDictionary selectById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateById(RcDataDictionary rcDataDictionary) {
		rcDataDictionary.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(rcDataDictionary);
	}
}
