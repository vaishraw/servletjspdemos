package com.samples.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Subject_ID")
	private int id;
	private String name;
	private String shortcut;
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE },fetch=FetchType.EAGER)
	@JoinColumn(name = "Class_ID")
	private Class class1;
	
	@OneToMany(mappedBy = "subject", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Teacher> teachers = new HashSet<>();
	
	

	public Subject() {
		super();
	}
	
	

	public Set<Teacher> getTeachers() {
		return teachers;
	}



	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

public Subject(String name, String shortcut, Class class1, Set<Teacher> teachers) {
		super();
		
		this.name = name;
		this.shortcut = shortcut;
		this.class1 = class1;
		this.teachers = teachers;
	}




	public Subject(String name, String shortcut, Class class1) {
	super();
	this.name = name;
	this.shortcut = shortcut;
	this.class1 = class1;
}



	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
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

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}



	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", shortcut=" + shortcut + ", class1=" + class1 + ", teachers="
				+ teachers  + "]";
	}
}
