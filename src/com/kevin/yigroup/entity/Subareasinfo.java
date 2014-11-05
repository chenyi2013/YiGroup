package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class Subareasinfo {
	private String center;
	private int id;
	private int area;
	private String name;
	private String slug;
	private int type;
	private int district;
	private int city;
	private ArrayList<Integer> subareas;

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public ArrayList<Integer> getSubareas() {
		return subareas;
	}

	public void setSubareas(ArrayList<Integer> subareas) {
		this.subareas = subareas;
	}

	@Override
	public String toString() {
		return "Subareasinfo [center=" + center + ", id=" + id + ", area="
				+ area + ", name=" + name + ", slug=" + slug + ", type=" + type
				+ ", district=" + district + ", city=" + city + ", subareas="
				+ subareas + "]";
	}

}
