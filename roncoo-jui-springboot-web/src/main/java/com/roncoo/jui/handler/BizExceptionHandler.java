package com.roncoo.jui.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.roncoo.jui.common.bean.dto.RoncooException;
import com.roncoo.jui.common.util.base.BaseController;

/**
 * 
 * @author wujing
 */
@RestControllerAdvice
public class BizExceptionHandler extends BaseController {

	@ExceptionHandler({ RoncooException.class })
	@ResponseStatus(HttpStatus.OK)
	public String processBizException(RoncooException e) {
		logger.error(e.toString());
		return error(e.getExpMsg());
	}
	
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.OK)
	public String processException(Exception e) {
		logger.error(e.getMessage(), e);
		return error("系统错误");
	}

}
