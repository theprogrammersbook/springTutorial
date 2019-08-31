package com.theprogrammersbook.entity.inheritance.persubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity  
@Table(name="regularemployee3")  
@PrimaryKeyJoinColumn(name="ID")
public class Regular_EmployeePerSubClass extends EmployeePerSubClass {
	@Column(name="salary")    
	private float salary;  
	  
	@Column(name="bonus")     
	private int bonus;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	} 
	
}
