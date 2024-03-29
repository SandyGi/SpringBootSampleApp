package com.sandy.example.BootDemo.user;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


public class User {

	private int id;
	
	@Size(min = 2)
	private String name;
	private String address;
	
	@Past
	private Date dob;
	
	protected User(){
		
	}
	public User(int id, String name, String address, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address
				+ ", dob=" + dob + "]";
	}
	
}
