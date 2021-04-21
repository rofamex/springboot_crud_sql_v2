package com.rofamex.springbootcrudsqlv2.dom;

import com.rofamex.springbootcrudsqlv2.entity.Zipcode;

public class CustomerDetail {

	private Long id;
	private String name;
	private int age;

	private Zipcode zipcode;

	public CustomerDetail() {

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




	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	public Zipcode getZipcode() {
		return zipcode;
	}

	public void setZipcode(Zipcode zipcode) {
		this.zipcode = zipcode;
	}



}
