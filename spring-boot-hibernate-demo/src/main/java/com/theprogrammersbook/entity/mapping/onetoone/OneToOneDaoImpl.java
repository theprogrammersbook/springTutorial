package com.theprogrammersbook.entity.mapping.onetoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class OneToOneDaoImpl implements OneToOneDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addEmployee(Employee11 employee) {
		entityManager.persist(employee);

	}

	@Override
	public List<Employee11> getEmployee() {
		String hql = "FROM Employee11";
		return (List<Employee11>) entityManager.createQuery(hql).getResultList();
	}

}
