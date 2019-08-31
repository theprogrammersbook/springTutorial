package com.theprogrammersbook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.theprogrammersbook.entity.mapping.manytomany.AnswerMM;
import com.theprogrammersbook.entity.mapping.manytomany.CommentMM;
import com.theprogrammersbook.entity.mapping.manytomany.ManyToManyDao;
import com.theprogrammersbook.entity.mapping.manytomany.QuestionMM;

@SpringBootApplication
public class ManyToManyMappingApplication implements CommandLineRunner {

	@Autowired
	private ManyToManyDao manyToManyDao;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {	
		System.out.println("++++++++++++++++++++Coming to This Area ++++++++++++++++++++");
		addMany();
       List<QuestionMM> questions = manyToManyDao.getQuestion();
       for(QuestionMM qmm : questions) {
    	   System.out.println("Question::"+qmm.toString());
    	   System.out.println("Ansers to this Quetion::");
    	   for(AnswerMM amm: qmm.getAnswers()) {
    		   System.out.println("Ans::"+amm.toString());
    	   }
    	   System.out.println("+++++++++++++++++++++++++++++++++++++++++==");
       }
	}

	private void addMany() {
		AnswerMM an1 = new AnswerMM();
		an1.setAnswerMMname("Java is a programming language");
		an1.setPostedBy("Ravi Malik");
		
		CommentMM cm1 = new CommentMM();
		cm1.setComment("Good");
		cm1.setCommentBy("G1");
		
		CommentMM cm2 = new CommentMM();
		cm2.setComment("Bad");
		cm2.setCommentBy("B1");
		
		List<CommentMM> commentList = new ArrayList<CommentMM>();
		commentList.add(cm1);
		commentList.add(cm2);
		an1.setComments(commentList);
		

		AnswerMM an2 = new AnswerMM();
		an2.setAnswerMMname("Java is a platform");
		an2.setPostedBy("Sudhir Kumar");

		QuestionMM q1 = new QuestionMM();
		q1.setQname("What is Java?");
		ArrayList<AnswerMM> l1 = new ArrayList<AnswerMM>();
		l1.add(an1);
		l1.add(an2);
		q1.setAnswerMMs(l1);

		AnswerMM ans3 = new AnswerMM();
		ans3.setAnswerMMname("Servlet is an Interface");
		ans3.setPostedBy("Jai Kumar");

		AnswerMM ans4 = new AnswerMM();
		ans4.setAnswerMMname("Servlet is an API");
		ans4.setPostedBy("Arun");

		QuestionMM q2 = new QuestionMM();
		q2.setQname("What is Servlet?");
		ArrayList<AnswerMM> l2 = new ArrayList<AnswerMM>();
		l2.add(ans3);
		l2.add(ans4);
		q2.setAnswerMMs(l2);

		manyToManyDao.addQuestions(q1);
		manyToManyDao.addQuestions(q2);
	}

}
