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

import com.roncoo.jui.common.bean.RcEmailInfo;
import com.roncoo.jui.common.bean.RcEmailInfoExample;
import com.roncoo.jui.common.bean.RcEmailInfoExample.Criteria;
import com.roncoo.jui.common.dao.EmailInfoDao;
import com.roncoo.jui.common.dao.impl.mapper.RcEmailInfoMapper;
import com.roncoo.jui.common.util.jui.Page;
import com.roncoo.jui.common.util.jui.SqlUtil;

/**
 * @author wujing
 */
@Repository
public class EmailInfoDaoImpl implements EmailInfoDao {

	@Autowired
	private RcEmailInfoMapper mapper;

	@Override
	public int insert(RcEmailInfo rcEmailInfo) {
		rcEmailInfo.setStatusId("1");
		rcEmailInfo.setCreateTime(new Date());
		rcEmailInfo.setUpdateTime(new Date());
		return mapper.insert(rcEmailInfo);
	}

	@Override
	public Page<RcEmailInfo> listForPage(int pageCurrent, int pageSize, String date, String search) {
		RcEmailInfoExample example = new RcEmailInfoExample();
		example.setOrderByClause(" id desc ");
		Criteria criteria = example.createCriteria();
		if (StringUtils.hasText(search)) {
			criteria.andToUserLike(SqlUtil.like(search));
		}
		int count = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(count, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(count, pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		example.setPageSize(pageSize);
		List<RcEmailInfo> list = mapper.selectByExample(example);
		return new Page<RcEmailInfo>(count, totalPage, pageCurrent, pageSize, list);
	}

	@Override
	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public RcEmailInfo selectById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

}
