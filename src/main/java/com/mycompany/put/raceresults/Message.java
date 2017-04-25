package com.mycompany.put.raceresults;

import java.util.Date;

public class Message {
	private String text;
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private Categories category = Categories.General;

	public void setCategory(Categories category) {
		this.category = category;
	}

	public Categories getCategory() {
		return category;
	}

}
