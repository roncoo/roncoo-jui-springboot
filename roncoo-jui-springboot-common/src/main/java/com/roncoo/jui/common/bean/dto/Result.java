package com.roncoo.jui.common.bean.dto;

import java.io.Serializable;

/**
 * 接口返回对象实体
 * 
 * @author hugovon
 * @version 1.0
 * @param <T>
 */
public class Result<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 错误码
	 */
	private int errCode = 99;

	/**
	 * 错误信息
	 */
	private String errMsg = "";

	/**
	 * 返回结果实体
	 */
	private T resultData;

	public Result() {
	}

	public Result(T resultData) {
		this.resultData = resultData;
	}

	public Result(int errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public Result(RoncooException roncooException) {
		this.errCode = roncooException.getExpCode();
		this.errMsg = roncooException.getExpMsg();
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public T getResultData() {
		return resultData;
	}

	public void setResultData(T resultData) {
		this.resultData = resultData;
	}

	@Override
	public String toString() {
		return "ResultData [errCode=" + errCode + ", errMsg=" + errMsg + ", resultData=" + resultData + "]";
	}

}
