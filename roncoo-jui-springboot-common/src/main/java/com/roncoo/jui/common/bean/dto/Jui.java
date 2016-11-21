package com.roncoo.jui.common.bean.dto;

import java.io.Serializable;

public class Jui implements Serializable {

	private static final long serialVersionUID = 1L;

	private int statusCode; // 必选。状态码
	private String message; // 可选。信息内容。
	private String navTabId; // 可选。
	private String rel; // 可选。
	private String callbackType; // 可选。
	private boolean forwardUrl; // 可选
	private String confirmMsg; // 可选

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNavTabId() {
		return navTabId;
	}

	public void setNavTabId(String navTabId) {
		this.navTabId = navTabId;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getCallbackType() {
		return callbackType;
	}

	public void setCallbackType(String callbackType) {
		this.callbackType = callbackType;
	}

	public boolean isForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(boolean forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public String getConfirmMsg() {
		return confirmMsg;
	}

	public void setConfirmMsg(String confirmMsg) {
		this.confirmMsg = confirmMsg;
	}

}
