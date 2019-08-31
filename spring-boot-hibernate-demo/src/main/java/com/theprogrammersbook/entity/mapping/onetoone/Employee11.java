package com.theprogrammersbook.entity.mapping.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Employee11 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	private int employeeId;
	private String name, email;
	@OneToOne(targetEntity = Address11.class, cascade = CascadeType.ALL)
	private Address11 address;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address11 getAddress() {
		return address;
	}

	public void setAddress(Address11 address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee11 [employeeId=" + employeeId + ", name=" + name + ", email=" + email + ", address=" + address
				+ "]";
	}

}
