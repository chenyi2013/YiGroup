package com.kevin.yigroup.entity;

public class CtPois {

	private long poiid;
	private String ct_poi;

	public long getPoiid() {
		return poiid;
	}

	public void setPoiid(long poiid) {
		this.poiid = poiid;
	}

	public String getCt_poi() {
		return ct_poi;
	}

	public void setCt_poi(String ct_poi) {
		this.ct_poi = ct_poi;
	}

	public CtPois(long poiid, String ct_poi) {
		super();
		this.poiid = poiid;
		this.ct_poi = ct_poi;
	}

	@Override
	public String toString() {
		return "CtPois [poiid=" + poiid + ", ct_poi=" + ct_poi + "]";
	}

}
