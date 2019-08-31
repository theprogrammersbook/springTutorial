package com.theprogrammersbook.entity.mapping.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class QuestionMM {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String qname;

	@ManyToMany(targetEntity = AnswerMM.class,fetch = FetchType.EAGER, cascade = { CascadeType.ALL })  
	private List<AnswerMM> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public List<AnswerMM> getAnswers() {
		return answers;
	}

	public void setAnswerMMs(List<AnswerMM> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "QuestionMM [id=" + id + ", qname=" + qname + ", answers=" + answers + "]";
	}
	
}
