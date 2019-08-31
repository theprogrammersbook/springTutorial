package com.theprogrammersbook.entity.inheritance.perheirarchy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public void addEmployee(Employee entity) {
		entityManager.persist(entity);
	}
	@Override
	public void addRegularEmployee(Regular_Employee entity) {
		entityManager.persist(entity);
		
	}
	@Override
	public void addContractEmployee(Contract_Employee entity) {
		entityManager.persist(entity);
		
	}
	

}
