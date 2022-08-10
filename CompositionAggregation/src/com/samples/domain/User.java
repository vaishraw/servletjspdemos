package com.samples.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private int age;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="houseno", column=@Column(name="billing_houseno")),
		@AttributeOverride(name="street", column=@Column(name="billing_street")),
		@AttributeOverride(name="city", column=@Column(name="billing_city")),
		@AttributeOverride(name="pincode", column=@Column(name="billing_pincode"))
		
	})
	private Address billingaddress;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="houseno", column=@Column(name="shipping_houseno")),
		@AttributeOverride(name="street", column=@Column(name="shipping_street")),
		@AttributeOverride(name="city", column=@Column(name="shipping_city")),
		@AttributeOverride(name="pincode", column=@Column(name="shipping_pincode"))
	})
	private Address shippingaddress;
	
	public User() {}

	public User(String name, int age, Address billingaddress, Address shippingaddress) {
		super();
		this.name = name;
		this.age = age;
		this.billingaddress = billingaddress;
		this.shippingaddress = shippingaddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Address getBillingaddress() {
		return billingaddress;
	}

	public void setBillingaddress(Address billingaddress) {
		this.billingaddress = billingaddress;
	}

	public Address getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(Address shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", billingaddress=" + billingaddress
				+ ", shippingaddress=" + shippingaddress + "]";
	}
	
	
	
	

}
