package com.stream.service.api.entity.log;

import java.io.Serializable;

public class LogInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer logInfoId;
	private String logIp;

	public Integer getLogInfoId() {
		return logInfoId;
	}

	public void setLogInfoId(Integer logInfoId) {
		this.logInfoId = logInfoId;
	}

	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp;
	}

}
