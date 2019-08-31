package com.theprogrammersbook.entity.mapping.manytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.theprogrammersbook.entity.mapping.onetoone.Employee11;
@Transactional
@Repository
public class ManyToManyDaoImpl implements ManyToManyDao{

	@Autowired 
	private EntityManager entityManager;
	@Override
	public void addQuestions(QuestionMM question) {
	entityManager.persist(question);
	}

	@Override
	public List<QuestionMM> getQuestion() {
		String hql = "FROM QuestionMM";
		return (List<QuestionMM>) entityManager.createQuery(hql).getResultList();
	}

}
