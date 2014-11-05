package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class DealData {
	private int id;
	private Share share;
	private String title;
	private long start;
	private int listJumpToTouch;
	private int type;
	private String descBefore;
	private ArrayList<Deal> deals;
	private long end;
	private String touchUrlForList;
	private String descIn;
	private String descAfter;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Share getShare() {
		return share;
	}

	public void setShare(Share share) {
		this.share = share;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
	}

	public int getListJumpToTouch() {
		return listJumpToTouch;
	}

	public void setListJumpToTouch(int listJumpToTouch) {
		this.listJumpToTouch = listJumpToTouch;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDescBefore() {
		return descBefore;
	}

	public void setDescBefore(String descBefore) {
		this.descBefore = descBefore;
	}

	public ArrayList<Deal> getDeals() {
		return deals;
	}

	public void setDeals(ArrayList<Deal> deals) {
		this.deals = deals;
	}

	public long getEnd() {
		return end;
	}

	public void setEnd(long end) {
		this.end = end;
	}

	public String getTouchUrlForList() {
		return touchUrlForList;
	}

	public void setTouchUrlForList(String touchUrlForList) {
		this.touchUrlForList = touchUrlForList;
	}

	public String getDescIn() {
		return descIn;
	}

	public void setDescIn(String descIn) {
		this.descIn = descIn;
	}

	public String getDescAfter() {
		return descAfter;
	}

	public void setDescAfter(String descAfter) {
		this.descAfter = descAfter;
	}

	@Override
	public String toString() {
		return "DealData [id=" + id + ", share=" + share + ", title=" + title
				+ ", start=" + start + ", listJumpToTouch=" + listJumpToTouch
				+ ", type=" + type + ", descBefore=" + descBefore + ", deals="
				+ deals + ", end=" + end + ", touchUrlForList="
				+ touchUrlForList + ", descIn=" + descIn + ", descAfter="
				+ descAfter + "]";
	}

}
