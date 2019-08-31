package com.theprogrammersbook.entity.inheritance.persubclass;

public interface EmployeePerSubClassDao {
	   void addEmployee(EmployeePerSubClass entity);
	   void addRegularEmployee(Regular_EmployeePerSubClass entity);
	   void addContractEmployee(Contract_EmployeePerSubClass entity);
}
