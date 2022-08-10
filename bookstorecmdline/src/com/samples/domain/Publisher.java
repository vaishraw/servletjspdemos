package com.samples.domain;

public class Publisher {
	private String code;
	private String name;
	
	public Publisher(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public Publisher() {
		// TODO Auto-generated constructor stub
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Publisher [code=" + code + ", name=" + name + "]";
	}
	

}
