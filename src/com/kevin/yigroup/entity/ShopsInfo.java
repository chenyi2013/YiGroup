package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class ShopsInfo {

	private int count;
	private String ct_poi;
	private ArrayList<Shops> data;
	private ArrayList<CtPois> ct_pois;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getCt_poi() {
		return ct_poi;
	}

	public void setCt_poi(String ct_poi) {
		this.ct_poi = ct_poi;
	}

	public ArrayList<Shops> getData() {
		return data;
	}

	public void setData(ArrayList<Shops> data) {
		this.data = data;
	}

	public ArrayList<CtPois> getCt_pois() {
		return ct_pois;
	}

	public void setCt_pois(ArrayList<CtPois> ct_pois) {
		this.ct_pois = ct_pois;
	}

	@Override
	public String toString() {
		return "ShopsInfo [count=" + count + ", ct_poi=" + ct_poi + ", data="
				+ data + ", ct_pois=" + ct_pois + "]";
	}

}
