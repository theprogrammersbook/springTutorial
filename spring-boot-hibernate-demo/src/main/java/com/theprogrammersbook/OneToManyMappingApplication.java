package com.theprogrammersbook;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theprogrammersbook.entity.mapping.onetomany.Answer1M;
import com.theprogrammersbook.entity.mapping.onetomany.OneToManyDao;
import com.theprogrammersbook.entity.mapping.onetomany.Question1M;

//@SpringBootApplication
public class OneToManyMappingApplication implements CommandLineRunner {

	@Autowired
	private OneToManyDao oneToManyDao;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("++++++++++++++++++++Coming to This Area ++++++++++++++++++++");
		Answer1M ans1=new Answer1M();    
	    ans1.setAnswername("Java is a programming language");    
	    ans1.setPostedBy("Ravi Malik");    
	        
	    Answer1M ans2=new Answer1M();    
	    ans2.setAnswername("Java is a platform");    
	    ans2.setPostedBy("Sudhir Kumar");    
	        
	    Answer1M ans3=new Answer1M();    
	    ans3.setAnswername("Servlet is an Interface");    
	    ans3.setPostedBy("Jai Kumar");    
	        
	    Answer1M ans4=new Answer1M();    
	    ans4.setAnswername("Servlet is an API");    
	    ans4.setPostedBy("Arun");    
	        
	    ArrayList<Answer1M> list1=new ArrayList<Answer1M>();    
	    list1.add(ans1);    
	    list1.add(ans2);    
	        
	    ArrayList<Answer1M> list2=new ArrayList<Answer1M>();    
	    list2.add(ans3);    
	    list2.add(ans4);    
	        
	    Question1M question1=new Question1M();    
	    question1.setQname("What is Nagaraju Java?");    
	    question1.setAnswers(list1);    
	        
	    Question1M question2=new Question1M();    
	    question2.setQname("What is Servlet?");    
	    question2.setAnswers(list2);   
	    
	    oneToManyDao.addQuestions(question1);
	    oneToManyDao.addQuestions(question2);
	  
	}

	
}
