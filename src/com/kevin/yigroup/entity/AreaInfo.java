package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class AreaInfo {

	private ArrayList<Subareasinfo> subareasinfo;
	private ArrayList<Subareasinfo> areasinfo;
	private ArrayList<Integer> hotareas;

	public ArrayList<Subareasinfo> getSubareasinfo() {
		return subareasinfo;
	}

	public void setSubareasinfo(ArrayList<Subareasinfo> subareasinfo) {
		this.subareasinfo = subareasinfo;
	}

	public ArrayList<Subareasinfo> getAreasinfo() {
		return areasinfo;
	}

	public void setAreasinfo(ArrayList<Subareasinfo> areasinfo) {
		this.areasinfo = areasinfo;
	}

	public ArrayList<Integer> getHotareas() {
		return hotareas;
	}

	public void setHotareas(ArrayList<Integer> hotareas) {
		this.hotareas = hotareas;
	}

	@Override
	public String toString() {
		return "AreaInfo [subareasinfo=" + subareasinfo + ", areasinfo="
				+ areasinfo + ", hotareas=" + hotareas + "]";
	}

}
