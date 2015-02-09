package com.kevin.yigroup.entity;

public class Error {

	private String message;
	private int code;
	private String type;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Error [message=" + message + ", code=" + code + ", type="
				+ type + "]";
	}

}
