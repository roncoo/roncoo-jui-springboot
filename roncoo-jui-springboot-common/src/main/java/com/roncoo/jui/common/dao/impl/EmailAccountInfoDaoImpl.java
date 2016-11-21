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

import com.roncoo.jui.common.bean.RcEmailAccountInfo;
import com.roncoo.jui.common.bean.RcEmailAccountInfoExample;
import com.roncoo.jui.common.bean.RcEmailAccountInfoExample.Criteria;
import com.roncoo.jui.common.dao.EmailAccountInfoDao;
import com.roncoo.jui.common.dao.impl.mapper.RcEmailAccountInfoMapper;
import com.roncoo.jui.common.util.jui.Page;
import com.roncoo.jui.common.util.jui.SqlUtil;

@Repository
public class EmailAccountInfoDaoImpl implements EmailAccountInfoDao {

	@Autowired
	private RcEmailAccountInfoMapper mapper;

	@Override
	public int deleteById(Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RcEmailAccountInfo rcEmailAccountInfo) {
		rcEmailAccountInfo.setPasswd(rcEmailAccountInfo.getPasswd());
		Date date = new Date();
		rcEmailAccountInfo.setCreateTime(date);
		rcEmailAccountInfo.setUpdateTime(date);
		return mapper.insertSelective(rcEmailAccountInfo);
	}

	@Override
	public Page<RcEmailAccountInfo> listForPage(int pageCurrent, int pageSize, String date, String search) {
		RcEmailAccountInfoExample example = new RcEmailAccountInfoExample();
		example.setOrderByClause("id desc");
		Criteria criteria = example.createCriteria();
		if(StringUtils.hasText(search)){
			criteria.andFromUserLike(SqlUtil.like(search));
		}
		int totalCount = mapper.countByExample(example);
		pageSize = SqlUtil.checkPageSize(pageSize);
		pageCurrent = SqlUtil.checkPageCurrent(totalCount, pageSize, pageCurrent);
		int totalPage = SqlUtil.countTotalPage(totalCount, pageSize);
		example.setPageSize(pageSize);
		example.setLimitStart(SqlUtil.countOffset(pageCurrent, pageSize));
		List<RcEmailAccountInfo> list = mapper.selectByExample(example);

		Page<RcEmailAccountInfo> page = new Page<>(totalCount, totalPage, pageCurrent, pageSize, list);
		return page;
	}

	@Override
	public RcEmailAccountInfo selectById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateById(RcEmailAccountInfo rcEmailAccountInfo) {
		rcEmailAccountInfo.setPasswd(rcEmailAccountInfo.getPasswd());
		rcEmailAccountInfo.setUpdateTime(new Date());
		return mapper.updateByPrimaryKeySelective(rcEmailAccountInfo);
	}
}
