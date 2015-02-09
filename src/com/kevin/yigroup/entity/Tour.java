package com.kevin.yigroup.entity;

public class Tour {

	private String tourPlaceName;
	private String tourInfo;
	private String tourDetailDesc;
	private String tourOpenTime;
	private float tourMarketPrice;
	private String tourPlaceStar;

	public String getTourPlaceName() {
		return tourPlaceName;
	}

	public void setTourPlaceName(String tourPlaceName) {
		this.tourPlaceName = tourPlaceName;
	}

	public String getTourInfo() {
		return tourInfo;
	}

	public void setTourInfo(String tourInfo) {
		this.tourInfo = tourInfo;
	}

	public String getTourDetailDesc() {
		return tourDetailDesc;
	}

	public void setTourDetailDesc(String tourDetailDesc) {
		this.tourDetailDesc = tourDetailDesc;
	}

	public String getTourOpenTime() {
		return tourOpenTime;
	}

	public void setTourOpenTime(String tourOpenTime) {
		this.tourOpenTime = tourOpenTime;
	}

	public float getTourMarketPrice() {
		return tourMarketPrice;
	}

	public void setTourMarketPrice(float tourMarketPrice) {
		this.tourMarketPrice = tourMarketPrice;
	}

	public String getTourPlaceStar() {
		return tourPlaceStar;
	}

	public void setTourPlaceStar(String tourPlaceStar) {
		this.tourPlaceStar = tourPlaceStar;
	}

	@Override
	public String toString() {
		return "Tour [tourPlaceName=" + tourPlaceName + ", tourInfo="
				+ tourInfo + ", tourDetailDesc=" + tourDetailDesc
				+ ", tourOpenTime=" + tourOpenTime + ", tourMarketPrice="
				+ tourMarketPrice + ", tourPlaceStar=" + tourPlaceStar + "]";
	}

}
