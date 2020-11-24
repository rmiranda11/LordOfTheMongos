package com.mon.mongodb.accessingdata.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Character {

	@Id
	private String id;
	private String name;
	private int age;
	private String role;
	
	
	public Character() {
		
	}
	
	public Character(String name, int age, String role) {
		super();
		this.name = name;
		this.age = age;
		this.role = role;
	}
	
	public Character(String id, String name, int age, String role) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + ", age=" + age + ", role=" + role + "]";
	}
	
	
	
}
