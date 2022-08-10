package com.samples.domain;

public class Message {
	private int id;
	private String text;
	public Message(String text) {
		super();
		
		this.text = text;
	}
	
	public Message() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", text=" + text + "]";
	}
	
	

}
