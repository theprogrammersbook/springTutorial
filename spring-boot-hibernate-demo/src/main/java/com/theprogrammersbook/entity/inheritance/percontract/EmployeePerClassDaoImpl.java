package com.theprogrammersbook.entity.inheritance.percontract;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EmployeePerClassDaoImpl implements EmployeePerClassDao {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public void addEmployee(EmployeePerClass entity) {
		entityManager.persist(entity);
	}
	@Override
	public void addRegularEmployee(Regular_EmployeePerClass entity) {
		entityManager.persist(entity);
		
	}
	@Override
	public void addContractEmployee(Contract_EmployeePerClass entity) {
		entityManager.persist(entity);
		
	}
	

}
