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
package com.roncoo.jui.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roncoo.jui.biz.DataDictionaryBiz;
import com.roncoo.jui.common.entity.RcDataDictionary;
import com.roncoo.jui.common.util.base.BaseController;
import com.roncoo.jui.common.util.base.Result;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 数据字典
 * 
 * @author wujing
 */
@Controller
@RequestMapping(value = "/admin/dataDictionary", method = RequestMethod.POST)
public class DataDictionaryController extends BaseController {

	private static final String NAVTABID = "dataDictionary";

	@Autowired
	private DataDictionaryBiz biz;

	/**
	 * 分页查看
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param modelMap
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage, @RequestParam(defaultValue = "20") int numPerPage, @RequestParam(value = "orderField", required = false) String orderField, @RequestParam(value = "orderDirection", required = false) String orderDirection, @ModelAttribute RcDataDictionary rcDataDictionary, ModelMap modelMap) {
		Result<Page<RcDataDictionary>> result = biz.listForPage(currentPage, numPerPage, orderField, orderDirection, rcDataDictionary);
		if (result.isStatus()) {
			modelMap.put("page", result.getResultData());
			modelMap.put("bean", rcDataDictionary);
		}
	}

	/**
	 * 添加
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add() {
	}

	/**
	 * 保存
	 * 
	 * @param rcDataDictionary
	 * @return
	 */
	@RequestMapping(value = SAVE)
	@ResponseBody
	public String save(@ModelAttribute RcDataDictionary rcDataDictionary) {
		Result<RcDataDictionary> result = biz.save(rcDataDictionary);
		if (result.isStatus()) {
			return success(NAVTABID);
		}
		return error(result.getErrMsg());
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param fieldCode
	 * @return
	 */
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	@ResponseBody
	public String delete(@RequestParam(value = "id", defaultValue = "0") Long id, @RequestParam(value = "fieldCode", defaultValue = "") String fieldCode) {
		Result<String> result = biz.delete(id, fieldCode);
		if (result.isStatus()) {
			return delete(NAVTABID);
		}
		return error(result.getErrMsg());
	}

	/**
	 * 修改
	 * 
	 * @param id
	 * @param modelMap
	 */
	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(Long id, ModelMap modelMap) {
		Result<RcDataDictionary> result = biz.query(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
	}

	/**
	 * 更新
	 * 
	 * @param rcDataDictionary
	 * @param oldFieldCode
	 * @return
	 */
	@RequestMapping(value = UPDATE)
	@ResponseBody
	public String update(@ModelAttribute RcDataDictionary rcDataDictionary) {
		Result<RcDataDictionary> result = biz.update(rcDataDictionary);
		if (result.isStatus()) {
			return success(NAVTABID);
		}
		return error(result.getErrMsg());
	}
}
