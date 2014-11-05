package com.kevin.yigroup.entity;

import java.util.ArrayList;

public class SurveyContent {

	private ArrayList<Interest> work;
	private ArrayList<Interest> interest;
	private ArrayList<Interest> marriage;

	public ArrayList<Interest> getWork() {
		return work;
	}

	public void setWork(ArrayList<Interest> work) {
		this.work = work;
	}

	public ArrayList<Interest> getInterest() {
		return interest;
	}

	public void setInterest(ArrayList<Interest> interest) {
		this.interest = interest;
	}

	public ArrayList<Interest> getMarriage() {
		return marriage;
	}

	public void setMarriage(ArrayList<Interest> marriage) {
		this.marriage = marriage;
	}

	@Override
	public String toString() {
		return "SurveyContent [work=" + work + ", interest=" + interest
				+ ", marriage=" + marriage + "]";
	}

}
