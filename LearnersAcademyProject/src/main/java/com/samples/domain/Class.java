package com.samples.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Class_ID")
	private int id;

	@OneToMany(mappedBy = "class1", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Teacher> teachers = new HashSet<>();

	@OneToMany(mappedBy = "class1", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Subject> subjects = new HashSet<>();

	@OneToMany(mappedBy = "class1", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private Set<Student> students = new HashSet<>();

	private String time;

	public Class() {
		super();
	}
	

	public Class(String time) {
		super();
		this.time = time;
	}


	public Class(Set<Teacher> teachers, Set<Subject> subjects, Set<Student> students, String time) {
		super();
		this.teachers = teachers;
		this.subjects = subjects;
		this.students = students;
		this.time = time;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", teachers=" + teachers + ", subjects=" + subjects + ", students=" + students
				+ ", time=" + time + "]";
	}

}
