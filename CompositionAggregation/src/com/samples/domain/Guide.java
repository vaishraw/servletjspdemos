package com.samples.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guide {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="Staff_ID",nullable=false)
	private String staffID;
	private String name;
	private Integer Salary;
	
	public Guide() {}

	public Guide(String staffID, String name, Integer salary) {
		super();
		this.staffID = staffID;
		this.name = name;
		Salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return Salary;
	}

	public void setSalary(Integer salary) {
		Salary = salary;
	}

	@Override
	public String toString() {
		return "Guide [id=" + id + ", staffID=" + staffID + ", name=" + name + ", Salary=" + Salary + "]";
	}
	
	

}
