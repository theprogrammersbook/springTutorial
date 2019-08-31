package com.theprogrammersbook.entity.mapping.onetomany;

import java.util.List;

public interface OneToManyDao {
	public void addQuestions(Question1M question);
	public List<Question1M> getQuestion();
}
