package com.theprogrammersbook.entity.inheritance.perheirarchy;

public interface EmployeeDao {
	   void addEmployee(Employee entity);
	   void addRegularEmployee(Regular_Employee entity);
	   void addContractEmployee(Contract_Employee entity);
}
