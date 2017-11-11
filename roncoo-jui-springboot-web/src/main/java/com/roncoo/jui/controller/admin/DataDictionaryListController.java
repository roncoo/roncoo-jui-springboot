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

import com.roncoo.jui.biz.DataDictionaryListBiz;
import com.roncoo.jui.common.entity.RcDataDictionaryList;
import com.roncoo.jui.common.util.base.BaseController;
import com.roncoo.jui.common.util.base.Result;
import com.roncoo.jui.common.util.jui.Page;

/**
 * 
 * @author wujing
 */
@Controller
@RequestMapping(value = "/admin/dataDictionaryList", method = RequestMethod.POST)
public class DataDictionaryListController extends BaseController {
	private static final String NAVTABID = "dataDictionaryList";

	@Autowired
	private DataDictionaryListBiz biz;

	/**
	 * 查询列表
	 * 
	 * @param id
	 * @param fieldCode
	 * @param modelMap
	 */
	@RequestMapping(value = LIST, method = RequestMethod.GET)
	public void list(@RequestParam(value = "pageNum", defaultValue = "1") int currentPage, @RequestParam(defaultValue = "20") int numPerPage, @RequestParam(value = "orderField", required = false) String orderField, @RequestParam(value = "orderDirection", required = false) String orderDirection, @RequestParam(value = "fieldCode") String fieldCode, @ModelAttribute RcDataDictionaryList rcDataDictionaryList, ModelMap modelMap) {
		Result<Page<RcDataDictionaryList>> result = biz.listForPage(currentPage, numPerPage, orderField, orderDirection, fieldCode, rcDataDictionaryList);
		if (result.isStatus()) {
			modelMap.put("page", result.getResultData());
			modelMap.put("fieldCode", fieldCode);
			modelMap.put("bean", rcDataDictionaryList);
		}
	}

	/**
	 * 添加
	 * 
	 * @param id
	 * @param fieldCode
	 * @param modelMap
	 */
	@RequestMapping(value = ADD, method = RequestMethod.GET)
	public void add(@RequestParam(value = "fieldCode") String fieldCode, ModelMap modelMap) {
		modelMap.put("fieldCode", fieldCode);
	}

	/**
	 * 保存
	 * 
	 * @param dList
	 * @param bindingResult
	 * @param dId
	 * @return
	 */
	@RequestMapping(value = SAVE)
	@ResponseBody
	public String save(@ModelAttribute RcDataDictionaryList rcDataDictionaryList) {
		Result<RcDataDictionaryList> result = biz.save(rcDataDictionaryList);
		if (result.isStatus()) {
			return success(NAVTABID);
		}
		return error(result.getErrMsg());
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @param dId
	 * @param fieldCode
	 * @return
	 */
	@RequestMapping(value = DELETE, method = RequestMethod.GET)
	@ResponseBody
	public String delete(@RequestParam(value = "id") Long id) {
		Result<String> result = biz.delete(id);
		if (result.isStatus()) {
			return delete(NAVTABID);
		}
		return error(result.getErrMsg());
	}

	/**
	 * 编辑
	 * 
	 * @param id
	 * @param dId
	 * @param modelMap
	 */
	@RequestMapping(value = EDIT, method = RequestMethod.GET)
	public void edit(@RequestParam(value = "id", defaultValue = "0") Long id, ModelMap modelMap) {
		Result<RcDataDictionaryList> result = biz.queryById(id);
		if (result.isStatus()) {
			modelMap.put("bean", result.getResultData());
		}
	}

	/**
	 * 更新
	 * 
	 * @param dList
	 * @param dId
	 * @return
	 */
	@RequestMapping(value = UPDATE)
	@ResponseBody
	public String update(@ModelAttribute RcDataDictionaryList rcDataDictionaryList) {
		Result<RcDataDictionaryList> result = biz.update(rcDataDictionaryList);
		if (result.isStatus()) {
			return success(NAVTABID);
		}
		return error(result.getErrMsg());
	}
}
