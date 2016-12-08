package com.roncoo.jui.biz;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

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
		logger.info(sw.prettyPrint());
		return new AsyncResult<String>("任务一完成");
	}

	@Async
	public Future<String> doTaskTwo() throws Exception {
		StopWatch sw = new StopWatch("任务二");
		sw.start("B");
		Thread.sleep(random.nextInt(10000));
		sw.stop();
		logger.info(sw.prettyPrint());
		return new AsyncResult<String>("任务二完成");
	}

	@Async
	public Future<String> doTaskThree() throws Exception {
		StopWatch sw = new StopWatch("任务三");
		sw.start("C");
		Thread.sleep(random.nextInt(10000));
		sw.stop();
		logger.info(sw.prettyPrint());
		return new AsyncResult<String>("任务三完成");
	}

}
