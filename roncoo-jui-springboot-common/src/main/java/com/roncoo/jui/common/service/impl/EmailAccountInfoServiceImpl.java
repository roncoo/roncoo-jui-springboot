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

import com.roncoo.jui.common.bean.RcEmailAccountInfo;
import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.dao.EmailAccountInfoDao;
import com.roncoo.jui.common.service.EmailAccountInfoService;
import com.roncoo.jui.common.util.jui.Page;



@Service
public class EmailAccountInfoServiceImpl implements EmailAccountInfoService {

	@Autowired
	private EmailAccountInfoDao dao;

	@Override
	public Result<Page<RcEmailAccountInfo>> listForPage(int pageCurrent, int pageSize, String date, String search) {
		Result<Page<RcEmailAccountInfo>> result = new Result<Page<RcEmailAccountInfo>>();
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
	public Result<RcEmailAccountInfo> queryById(Long id) {
		Result<RcEmailAccountInfo> result = new Result<RcEmailAccountInfo>();
		if (id < 1) {
			result.setErrMsg("此id无效");
			return result;
		}
		RcEmailAccountInfo info = dao.selectById(id);
		info.setPasswd(info.getPasswd());
		result.setResultData(info);
		result.setErrCode(0);
		result.setStatus(true);
		result.setErrMsg("查询成功");
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> save(RcEmailAccountInfo rcEmailAccountInfo) {
		Result<RcEmailAccountInfo> result = new Result<RcEmailAccountInfo>();
		if (!StringUtils.hasText(rcEmailAccountInfo.getFromUser())) {
			result.setErrMsg("账号不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailAccountInfo.getHost())) {
			result.setErrMsg("Host不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailAccountInfo.getPasswd())) {
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if (dao.insert(rcEmailAccountInfo) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setErrMsg("保存成功");
		}
		return result;
	}

	@Override
	public Result<RcEmailAccountInfo> updateById(RcEmailAccountInfo rcEmailAccountInfo) {
		Result<RcEmailAccountInfo> result = new Result<RcEmailAccountInfo>();
		if (!StringUtils.hasText(rcEmailAccountInfo.getFromUser())) {
			result.setErrMsg("账号不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailAccountInfo.getHost())) {
			result.setErrMsg("Host不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailAccountInfo.getPasswd())) {
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if (dao.updateById(rcEmailAccountInfo) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setErrMsg("更新成功");
		}
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
	public Result<RcEmailAccountInfo> update(RcEmailAccountInfo rcEmailAccountInfo) {
		Result<RcEmailAccountInfo> result = new Result<RcEmailAccountInfo>();
		if (!StringUtils.hasText(rcEmailAccountInfo.getFromUser())) {
			result.setErrMsg("账号不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailAccountInfo.getHost())) {
			result.setErrMsg("Host不能为空");
			return result;
		}
		if (!StringUtils.hasText(rcEmailAccountInfo.getPasswd())) {
			result.setErrMsg("授权码不能为空");
			return result;
		}
		if (dao.updateById(rcEmailAccountInfo) > 0) {
			result.setStatus(true);
			result.setErrCode(0);
			result.setErrMsg("更新成功");
		}
		return result;
	}

}
