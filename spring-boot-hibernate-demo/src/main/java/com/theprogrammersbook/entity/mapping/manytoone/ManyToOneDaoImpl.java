package com.theprogrammersbook.entity.mapping.manytoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ManyToOneDaoImpl implements ManyToOneDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addStudent(StudentM1 student) {
		entityManager.persist(student);
	}

	@Override
	public List<StudentM1> getStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUniversity(UniversityM1 university) {
		entityManager.persist(university);
		
	}


}
