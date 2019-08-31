package com.theprogrammersbook.entity.mapping.onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.theprogrammersbook.entity.mapping.onetoone.Employee11;
@Transactional
@Repository
public class OneToManyDaoImpl implements OneToManyDao{

	@Autowired 
	private EntityManager entityManager;
	@Override
	public void addQuestions(Question1M question) {
	entityManager.persist(question);
	}

	@Override
	public List<Question1M> getQuestion() {
		String hql = "FROM Question";
		return (List<Question1M>) entityManager.createQuery(hql).getResultList();
	}

}
