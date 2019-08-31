package com.theprogrammersbook.entity.mapping.manytoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class StudentM1 {

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "SECTION")
	private String section;

	@ManyToOne(optional = false)
	@JoinColumn(name="UNIVERSITY_ID")
	private UniversityM1 university;


	public StudentM1() {
	}

	public StudentM1(String firstName, String lastName, String section) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.section = section;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public UniversityM1 getUniversity() {
		return university;
	}

	public void setUniversity(UniversityM1 university) {
		this.university = university;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", section=" + section + "]";
	}

}
