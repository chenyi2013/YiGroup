package com.kevin.yigroup.entity;

public class Cinema {

	private String phone;
	private int latestWeekCoupon;
	private int cityId;
	private String addr;
	private int ktvAppointStatus;
	private String brandName;
	private long brandId;
	private String poiid;
	private int groupInfo;
	private String showType;
	private long bizloginid;
	private String parkingInfo;
	private String brandLogo;
	// private Object extra;
	private String discount;
	private String frontImg;
	private int historyCouponCount;
	private float avgPrice;
	private String floor;
	private float avgScore;
	private int dayRoomSpan;
	private float lowestPrice;
	private String introduction;
	private int markNumbers;
	private double lng;
	private long areaId;
	private String subwayStationId;
	private boolean preferent;
	private String campaignTag;
	private boolean isSupportAppointment;
	private String style;
	private String featureMenus;
	private String name;
	private int hourRoomSpan;
	private String notice;
	private double lat;
	private float ktvLowestPrice;
	private long mallId;
	private int isHot;
	private boolean hasGroup;
	private String cates;
	private int zlSourceType;
	private boolean chooseSitting;
	private boolean isImax;
	private boolean wifi;

	private Ktv ktv;
	private Abstracts abstracts;
	private String areaName;
	private String iUrl;
	private String openInfo;
	private Tour tour;
	private long cateId;
	private String cateName;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getLatestWeekCoupon() {
		return latestWeekCoupon;
	}

	public void setLatestWeekCoupon(int latestWeekCoupon) {
		this.latestWeekCoupon = latestWeekCoupon;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getKtvAppointStatus() {
		return ktvAppointStatus;
	}

	public void setKtvAppointStatus(int ktvAppointStatus) {
		this.ktvAppointStatus = ktvAppointStatus;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public long getBrandId() {
		return brandId;
	}

	public void setBrandId(long brandId) {
		this.brandId = brandId;
	}

	public String getPoiid() {
		return poiid;
	}

	public void setPoiid(String poiid) {
		this.poiid = poiid;
	}

	public int getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(int groupInfo) {
		this.groupInfo = groupInfo;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public long getBizloginid() {
		return bizloginid;
	}

	public void setBizloginid(long bizloginid) {
		this.bizloginid = bizloginid;
	}

	public String getParkingInfo() {
		return parkingInfo;
	}

	public void setParkingInfo(String parkingInfo) {
		this.parkingInfo = parkingInfo;
	}

	public String getBrandLogo() {
		return brandLogo;
	}

	public void setBrandLogo(String brandLogo) {
		this.brandLogo = brandLogo;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getFrontImg() {
		return frontImg;
	}

	public void setFrontImg(String frontImg) {
		this.frontImg = frontImg;
	}

	public int getHistoryCouponCount() {
		return historyCouponCount;
	}

	public void setHistoryCouponCount(int historyCouponCount) {
		this.historyCouponCount = historyCouponCount;
	}

	public float getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(float avgPrice) {
		this.avgPrice = avgPrice;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public float getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}

	public int getDayRoomSpan() {
		return dayRoomSpan;
	}

	public void setDayRoomSpan(int dayRoomSpan) {
		this.dayRoomSpan = dayRoomSpan;
	}

	public float getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(float lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public int getMarkNumbers() {
		return markNumbers;
	}

	public void setMarkNumbers(int markNumbers) {
		this.markNumbers = markNumbers;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public long getAreaId() {
		return areaId;
	}

	public void setAreaId(long areaId) {
		this.areaId = areaId;
	}

	public String getSubwayStationId() {
		return subwayStationId;
	}

	public void setSubwayStationId(String subwayStationId) {
		this.subwayStationId = subwayStationId;
	}

	public boolean isPreferent() {
		return preferent;
	}

	public void setPreferent(boolean preferent) {
		this.preferent = preferent;
	}

	public String getCampaignTag() {
		return campaignTag;
	}

	public void setCampaignTag(String campaignTag) {
		this.campaignTag = campaignTag;
	}

	public boolean isSupportAppointment() {
		return isSupportAppointment;
	}

	public void setSupportAppointment(boolean isSupportAppointment) {
		this.isSupportAppointment = isSupportAppointment;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getFeatureMenus() {
		return featureMenus;
	}

	public void setFeatureMenus(String featureMenus) {
		this.featureMenus = featureMenus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHourRoomSpan() {
		return hourRoomSpan;
	}

	public void setHourRoomSpan(int hourRoomSpan) {
		this.hourRoomSpan = hourRoomSpan;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public float getKtvLowestPrice() {
		return ktvLowestPrice;
	}

	public void setKtvLowestPrice(float ktvLowestPrice) {
		this.ktvLowestPrice = ktvLowestPrice;
	}

	public long getMallId() {
		return mallId;
	}

	public void setMallId(long mallId) {
		this.mallId = mallId;
	}

	public int getIsHot() {
		return isHot;
	}

	public void setIsHot(int isHot) {
		this.isHot = isHot;
	}

	public boolean isHasGroup() {
		return hasGroup;
	}

	public void setHasGroup(boolean hasGroup) {
		this.hasGroup = hasGroup;
	}

	public String getCates() {
		return cates;
	}

	public void setCates(String cates) {
		this.cates = cates;
	}

	public int getZlSourceType() {
		return zlSourceType;
	}

	public void setZlSourceType(int zlSourceType) {
		this.zlSourceType = zlSourceType;
	}

	public boolean isChooseSitting() {
		return chooseSitting;
	}

	public void setChooseSitting(boolean chooseSitting) {
		this.chooseSitting = chooseSitting;
	}

	public boolean isImax() {
		return isImax;
	}

	public void setImax(boolean isImax) {
		this.isImax = isImax;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public Ktv getKtv() {
		return ktv;
	}

	public void setKtv(Ktv ktv) {
		this.ktv = ktv;
	}

	public Abstracts getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(Abstracts abstracts) {
		this.abstracts = abstracts;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getiUrl() {
		return iUrl;
	}

	public void setiUrl(String iUrl) {
		this.iUrl = iUrl;
	}

	public String getOpenInfo() {
		return openInfo;
	}

	public void setOpenInfo(String openInfo) {
		this.openInfo = openInfo;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public long getCateId() {
		return cateId;
	}

	public void setCateId(long cateId) {
		this.cateId = cateId;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	@Override
	public String toString() {
		return "Cinema [phone=" + phone + ", latestWeekCoupon="
				+ latestWeekCoupon + ", cityId=" + cityId + ", addr=" + addr
				+ ", ktvAppointStatus=" + ktvAppointStatus + ", brandName="
				+ brandName + ", brandId=" + brandId + ", poiid=" + poiid
				+ ", groupInfo=" + groupInfo + ", showType=" + showType
				+ ", bizloginid=" + bizloginid + ", parkingInfo=" + parkingInfo
				+ ", brandLogo=" + brandLogo + ", discount=" + discount
				+ ", frontImg=" + frontImg + ", historyCouponCount="
				+ historyCouponCount + ", avgPrice=" + avgPrice + ", floor="
				+ floor + ", avgScore=" + avgScore + ", dayRoomSpan="
				+ dayRoomSpan + ", lowestPrice=" + lowestPrice
				+ ", introduction=" + introduction + ", markNumbers="
				+ markNumbers + ", lng=" + lng + ", areaId=" + areaId
				+ ", subwayStationId=" + subwayStationId + ", preferent="
				+ preferent + ", campaignTag=" + campaignTag
				+ ", isSupportAppointment=" + isSupportAppointment + ", style="
				+ style + ", featureMenus=" + featureMenus + ", name=" + name
				+ ", hourRoomSpan=" + hourRoomSpan + ", notice=" + notice
				+ ", lat=" + lat + ", ktvLowestPrice=" + ktvLowestPrice
				+ ", mallId=" + mallId + ", isHot=" + isHot + ", hasGroup="
				+ hasGroup + ", cates=" + cates + ", zlSourceType="
				+ zlSourceType + ", chooseSitting=" + chooseSitting
				+ ", isImax=" + isImax + ", wifi=" + wifi + ", ktv=" + ktv
				+ ", abstracts=" + abstracts + ", areaName=" + areaName
				+ ", iUrl=" + iUrl + ", openInfo=" + openInfo + ", tour="
				+ tour + ", cateId=" + cateId + ", cateName=" + cateName + "]";
	}

}
