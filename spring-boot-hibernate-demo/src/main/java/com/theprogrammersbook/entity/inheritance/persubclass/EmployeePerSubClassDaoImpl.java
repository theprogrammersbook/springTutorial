package com.theprogrammersbook.entity.inheritance.persubclass;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EmployeePerSubClassDaoImpl implements EmployeePerSubClassDao {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public void addEmployee(EmployeePerSubClass entity) {
		entityManager.persist(entity);
	}
	@Override
	public void addRegularEmployee(Regular_EmployeePerSubClass entity) {
		entityManager.persist(entity);
		
	}
	@Override
	public void addContractEmployee(Contract_EmployeePerSubClass entity) {
		entityManager.persist(entity);
		
	}
	

}
