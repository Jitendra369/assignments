package com.crudoperations.model;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;


public class ServerResponse {
	
	private HttpStatus httpStatus;
	private String reason;
	private String devMessage;
	private Map<?, ?> data;
	
	
	
	
	public ServerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public ServerResponse(HttpStatus httpStatus, String reason, String devMessage) {
		super();
		this.httpStatus = httpStatus;
		this.reason = reason;
		this.devMessage = devMessage;
	}


	public ServerResponse(HttpStatus httpStatus, String reason, String devMessage, Map<?, ?> data) {
		super();
		this.httpStatus = httpStatus;
		this.reason = reason;
		this.devMessage = devMessage;
		this.data = data;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDevMessage() {
		return devMessage;
	}
	public void setDevMessage(String devMessage) {
		this.devMessage = devMessage;
	}
	public Map<?, ?> getData() {
		return data;
	}
	public void setData(Map<?, ?> data) {
		this.data = data;
	}
	
	
	
}
