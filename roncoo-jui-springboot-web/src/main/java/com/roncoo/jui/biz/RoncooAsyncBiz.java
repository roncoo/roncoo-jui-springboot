package com.roncoo.jui.biz;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import com.roncoo.jui.common.bean.dto.Result;
import com.roncoo.jui.common.bean.entity.RcDataDictionary;
import com.roncoo.jui.common.bean.entity.RcReport;
import com.roncoo.jui.common.service.DataDictionaryService;
import com.roncoo.jui.common.service.ReportService;
import com.roncoo.jui.common.util.base.BaseController;

@Service
public class RoncooAsyncBiz extends BaseController {

	public static final Random random = new Random();

	@Async
	public Future<String> doTaskOne() throws Exception {
		StopWatch sw = new StopWatch("任务一");
		sw.start("A");
		Thread.sleep(random.nextInt(10000));
		sw.stop();
		// logger.info(sw.prettyPrint());
		return new AsyncResult<String>("任务一完成");
	}

	@Async
	public Future<String> doTaskTwo() throws Exception {
		StopWatch sw = new StopWatch("任务二");
		sw.start("B");
		Thread.sleep(random.nextInt(10000));
		sw.stop();
		// logger.info(sw.prettyPrint());
		return new AsyncResult<String>("任务二完成");
	}

	@Async
	public Future<String> doTaskThree() throws Exception {
		StopWatch sw = new StopWatch("任务三");
		sw.start("C");
		Thread.sleep(random.nextInt(10000));
		sw.stop();
		// logger.info(sw.prettyPrint());
		return new AsyncResult<String>("任务三完成");
	}

	@Autowired
	private DataDictionaryService dictionaryService;

	@Autowired
	private ReportService reportService;

	/**
	 * 
	 */
	@Transactional
	public void test() {
		RcReport rcReport = new RcReport();
		rcReport.setUserEmail("297115770@qq.com");
		rcReport.setUserNickname("无境");
		Result<Integer> result = reportService.save(rcReport);
		if (result.isStatus()) {
			System.out.println("---》抛出异常");
			throw new RuntimeException();
		}
		RcDataDictionary rcDataDictionary = new RcDataDictionary();
		rcDataDictionary.setFieldName("测试");
		rcDataDictionary.setFieldCode("ceshi");
		dictionaryService.save(rcDataDictionary);

	}

}
