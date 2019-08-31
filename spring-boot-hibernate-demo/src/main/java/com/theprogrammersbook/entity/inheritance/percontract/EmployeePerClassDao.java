package com.theprogrammersbook.entity.inheritance.percontract;

public interface EmployeePerClassDao {
	   void addEmployee(EmployeePerClass entity);
	   void addRegularEmployee(Regular_EmployeePerClass entity);
	   void addContractEmployee(Contract_EmployeePerClass entity);
}
