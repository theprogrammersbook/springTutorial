package com.theprogrammersbook.entity.mapping.manytomany;

import java.util.List;

public interface ManyToManyDao {
	public void addQuestions(QuestionMM question);
	public List<QuestionMM> getQuestion();
}
