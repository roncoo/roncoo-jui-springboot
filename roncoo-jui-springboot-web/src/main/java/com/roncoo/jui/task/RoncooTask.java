package com.roncoo.jui.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.roncoo.jui.biz.RoncooAsyncBiz;
import com.roncoo.jui.common.util.base.Base;

/**
 * @author wujing
 */
@Component
public class RoncooTask extends Base {

	@Autowired
	private RoncooAsyncBiz roncooAsyncBiz;

	// 单位时间执行，单位是ms，也可以使用cron=*/5 * * * *
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() throws Exception {
		StopWatch sw = new StopWatch("调用测试");
		sw.start("A");
		roncooAsyncBiz.doTaskOne();
		sw.stop();
		sw.start("B");
		roncooAsyncBiz.doTaskTwo();
		sw.stop();
		sw.start("C");
		roncooAsyncBiz.doTaskThree();
		sw.stop();
		// logger.info(sw.prettyPrint());
	}

//	/**
//	 * 测试事务问题
//	 * 
//	 * @throws Exception
//	 */
//	@Scheduled(fixedRate = 5000)
//	public void testTransational() {
//		System.out.println("begin");
//		roncooAsyncBiz.test();
//	}

}
