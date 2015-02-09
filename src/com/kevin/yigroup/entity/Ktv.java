package com.kevin.yigroup.entity;

public class Ktv {

	private String ktvIUrl;
	private float ktvLowestPrice;
	private String ktvIconURL;
	private String tips;
	private int ktvAppointStatus;

	public String getKtvIUrl() {
		return ktvIUrl;
	}

	public void setKtvIUrl(String ktvIUrl) {
		this.ktvIUrl = ktvIUrl;
	}

	public float getKtvLowestPrice() {
		return ktvLowestPrice;
	}

	public void setKtvLowestPrice(float ktvLowestPrice) {
		this.ktvLowestPrice = ktvLowestPrice;
	}

	public String getKtvIconURL() {
		return ktvIconURL;
	}

	public void setKtvIconURL(String ktvIconURL) {
		this.ktvIconURL = ktvIconURL;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public int getKtvAppointStatus() {
		return ktvAppointStatus;
	}

	public void setKtvAppointStatus(int ktvAppointStatus) {
		this.ktvAppointStatus = ktvAppointStatus;
	}

	@Override
	public String toString() {
		return "Ktv [ktvIUrl=" + ktvIUrl + ", ktvLowestPrice=" + ktvLowestPrice
				+ ", ktvIconURL=" + ktvIconURL + ", tips=" + tips
				+ ", ktvAppointStatus=" + ktvAppointStatus + "]";
	}

}
