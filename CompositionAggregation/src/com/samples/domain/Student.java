package com.samples.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "registration_ID", nullable = false)
	private String registrationId;
	private String name;

	@ManyToOne
	@JoinColumn(name = "Guide_ID")
	private Guide guide;

	public Student() {
	}

	public Student(String registrationId, String name, Guide guide) {
		super();
		this.registrationId = registrationId;
		this.name = name;
		this.guide = guide;
	}

}
