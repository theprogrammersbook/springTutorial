package com.theprogrammersbook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theprogrammersbook.entity.mapping.manytoone.ManyToOneDao;
import com.theprogrammersbook.entity.mapping.manytoone.StudentM1;
import com.theprogrammersbook.entity.mapping.manytoone.UniversityM1;

//@SpringBootApplication
public class ManyToOneMappingApplication implements CommandLineRunner {

	@Autowired
	private ManyToOneDao manyToOneDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("++++++++++++++++++++Coming to This Area ++++++++++++++++++++");
		
		StudentM1 student1 = new StudentM1("SamNaga","Disilva","Maths");
		StudentM1 student2 = new StudentM1("Joshua", "Brill", "Science");
		StudentM1 student3 = new StudentM1("Peter", "Pan", "Physics");
		
		UniversityM1 university = new UniversityM1("CAMBRIDGE", "ENGLAND");

		student1.setUniversity(university);
		student2.setUniversity(university);
		student3.setUniversity(university);
		
		manyToOneDao.addUniversity(university);
		
		manyToOneDao.addStudent(student1);
		manyToOneDao.addStudent(student2);
		manyToOneDao.addStudent(student3);
	}

	

}
