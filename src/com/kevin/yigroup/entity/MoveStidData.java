package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class MoveStidData {

	private MoveStidDataHot hot;
	private ArrayList<MoveStidDataMorepage> morepage;
	private ArrayList<MoveStidDataMorePageList> homepage;

	public MoveStidDataHot getHot() {
		return hot;
	}

	public void setHot(MoveStidDataHot hot) {
		this.hot = hot;
	}

	public ArrayList<MoveStidDataMorepage> getMorepage() {
		return morepage;
	}

	public void setMorepage(ArrayList<MoveStidDataMorepage> morepage) {
		this.morepage = morepage;
	}

	public ArrayList<MoveStidDataMorePageList> getHomepage() {
		return homepage;
	}

	public void setHomepage(ArrayList<MoveStidDataMorePageList> homepage) {
		this.homepage = homepage;
	}

	@Override
	public String toString() {
		return "MoveStidData [hot=" + hot + ", morepage=" + morepage
				+ ", homepage=" + homepage + "]";
	}

}
