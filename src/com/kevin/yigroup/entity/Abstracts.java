package com.kevin.yigroup.entity;

public class Abstracts {

	private String group;
	private String coupon;

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getCoupon() {
		return coupon;
	}

	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}

	@Override
	public String toString() {
		return "Abstracts [group=" + group + ", coupon=" + coupon + "]";
	}

}
