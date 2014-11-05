package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class Data {

	private ArrayList<Morepage> morepage;
	private Hot hot;
	private ArrayList<Morepage> homepage;

	public ArrayList<Morepage> getMorepage() {
		return morepage;
	}

	public void setMorepage(ArrayList<Morepage> morepage) {
		this.morepage = morepage;
	}

	public Hot getHot() {
		return hot;
	}

	public void setHot(Hot hot) {
		this.hot = hot;
	}

	public ArrayList<Morepage> getHomepage() {
		return homepage;
	}

	public void setHomepage(ArrayList<Morepage> homepage) {
		this.homepage = homepage;
	}

	@Override
	public String toString() {
		return "Data [morepage=" + morepage + ", hot=" + hot + ", homepage="
				+ homepage + "]";
	}

}
