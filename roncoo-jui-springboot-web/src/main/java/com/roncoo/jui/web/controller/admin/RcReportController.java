package com.roncoo.jui.web.controller.admin;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roncoo.jui.common.util.base.BaseController;
import com.roncoo.jui.web.bean.qo.RcReportQO;
import com.roncoo.jui.web.service.RcReportService;

/**
 * 报表
 *
 * @author wujing
 * @since 2017-11-11
 */
@Controller
@RequestMapping("/admin/rcReport")
public class RcReportController extends BaseController {

	// private final static String TARGETID = "admin-rcReport";

	@Autowired
	private RcReportService service;

	/**
	 * 分页查看
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param modelMap
	 */
	/**
	 * 分页查看
	 * 
	 * @param pageCurrent
	 * @param pageSize
	 * @param modelMap
	 */
	@RequestMapping(value = LIST)
	public void list(@RequestParam(value = "pageNum", defaultValue = "1") int pageCurrent, @RequestParam(value = "numPerPage", defaultValue = "20") int pageSize, @RequestParam(value = "orderField", required = false) String orderField, @RequestParam(value = "orderDirection", required = false) String orderDirection, @ModelAttribute RcReportQO qo, ModelMap modelMap) {
		modelMap.put("page", service.listForPage(pageCurrent, pageSize, orderField, orderDirection, qo));
		modelMap.put("bean", qo);
	}

	/**
	 * 导出
	 * 
	 * @param id
	 * @param modelMap
	 * @throws IOException
	 */
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void download(HttpServletResponse response) throws IOException {
		service.exportExcel(response);
	}
}
