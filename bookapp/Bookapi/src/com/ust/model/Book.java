package com.ust.model;

public class Book {
	
	private int id;
	private String title;
	private String author;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(int id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}


	public int getId() {
		return id;
	}


	public void setId(int i) {
		this.id = i;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	

}
