package com.example.empdemo.dto;

public class EmpDto {

	private String name;
	private int age;
	

	
	public EmpDto(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public EmpDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
