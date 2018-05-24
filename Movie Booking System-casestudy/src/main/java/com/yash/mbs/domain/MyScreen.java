package com.yash.mbs.domain;

public class MyScreen {

	private int id;
	private String name;
	
	public MyScreen(int id, String name) {
		this.id =  id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "MyScreen [id=" + id + ", name=" + name + "]";
	}
}
