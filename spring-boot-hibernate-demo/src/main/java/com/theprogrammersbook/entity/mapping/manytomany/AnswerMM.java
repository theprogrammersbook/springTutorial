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
public class AnswerMM {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)

	private int id;
	private String answername;
	private String postedBy;
	
	@ManyToMany(targetEntity = CommentMM.class,fetch = FetchType.EAGER, cascade = { CascadeType.ALL })  
	private List<CommentMM> comments;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswername() {
		return answername;
	}

	public void setAnswerMMname(String answername) {
		this.answername = answername;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public List<CommentMM> getComments() {
		return comments;
	}

	public void setComments(List<CommentMM> comments) {
		this.comments = comments;
	}

	public void setAnswername(String answername) {
		this.answername = answername;
	}

	@Override
	public String toString() {
		return "AnswerMM [id=" + id + ", answername=" + answername + ", postedBy=" + postedBy + ", comments=" + comments
				+ "]";
	}

	
	
}