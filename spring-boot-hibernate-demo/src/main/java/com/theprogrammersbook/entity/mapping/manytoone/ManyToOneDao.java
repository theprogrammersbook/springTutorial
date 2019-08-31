package com.theprogrammersbook.entity.mapping.manytoone;

import java.util.List;

public interface ManyToOneDao {
public void addStudent(StudentM1 customer);
public List<StudentM1> getStudent();

public void addUniversity(UniversityM1 university);
}
