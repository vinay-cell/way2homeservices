package com.yks.way2homeservices.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public abstract class AbstractDocument {

	public static final String KEY_ID = "_id";
	
	@Id
	@Field(KEY_ID)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
