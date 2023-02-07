package com.crudoperations.model;

import jakarta.persistence.Entity;


public class Address {
	
	private String homeAddress;
	private String officeAddress;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Address(String homeAddress, String officeAddress) {
		super();
		this.homeAddress = homeAddress;
		this.officeAddress = officeAddress;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "Address [homeAddress=" + homeAddress + ", officeAddress=" + officeAddress + "]";
	}
	
	

}
