package com.wenjian.model;

public class User {
	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
