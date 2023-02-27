package com.techaplle.module;
//bean class
public class Customer 
{
	private  int id;
	private  String Name;
	private  String Email;
	private  long MobileNo;
	private  String password;
	private  String State;
	public Customer(String name, String email, long mobileNo, String password, String state) {
		super();
		Name = name;
		Email = email;
		MobileNo = mobileNo;
		this.password = password;
		State = state;
	}
	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public  String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public  String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public  long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	public  String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public  String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	
	

}
