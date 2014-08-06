package com.hsq.model;

import java.sql.Date;

public class Book {
	
	private int id;
	private String bName;
	private String description;
	private float price;
	public Book() {
		super();
	}
	public Book(int id, String bName, String description, float price) {
		super();
		this.id = id;
		this.bName = bName;
		this.description = description;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String result =""+
		"id="+id+","+
		"bName="+bName+","+
		"description="+description+","+
		"price="+price;
		return result;
	}
	
	
	/*
	
	private Integer id;//数据库id 
	private String author;
	
	private String title;
	private float price;
	
	private Date publishingDate;
	private int salesAmount;
	
	private int storeNumber;
	private String remark;
	*/

}
