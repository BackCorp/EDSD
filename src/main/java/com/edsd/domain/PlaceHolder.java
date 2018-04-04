package com.edsd.domain;

import com.edsd.model.PrimesEdsd;
import com.edsd.model.User;

public class PlaceHolder {
	
	private Object edsd;
	private String createdByUsername;
	private String createdByFirstName;
	private String createdByLastName;
	
	public PlaceHolder(Object edsd, String createdByUsername, String createdByFirstName, String createdByLastName) {
		super();
		this.edsd = edsd;
		this.createdByUsername = createdByUsername;
		this.createdByFirstName = createdByFirstName;
		this.createdByLastName = createdByLastName;
	}

	public Object getEdsd() {
		return edsd;
	}

	public void setEdsd(Object edsd) {
		this.edsd = edsd;
	}

	public String getCreatedByUsername() {
		return createdByUsername;
	}

	public void setCreatedByUsername(String createdByUsername) {
		this.createdByUsername = createdByUsername;
	}

	public String getCreatedByFirstName() {
		return createdByFirstName;
	}

	public void setCreatedByFirstName(String createdByFirstName) {
		this.createdByFirstName = createdByFirstName;
	}

	public String getCreatedByLastName() {
		return createdByLastName;
	}

	public void setCreatedByLastName(String createdByLastName) {
		this.createdByLastName = createdByLastName;
	}
	
}
