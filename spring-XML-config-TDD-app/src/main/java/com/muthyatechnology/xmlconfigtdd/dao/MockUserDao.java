package com.muthyatechnology.xmlconfigtdd.dao;

import java.util.List;

import com.muthyatechnology.xmlconfigtdd.bean.User;

public interface MockUserDao {
	 List<User> getAll();

	    User findById(int id);

	    User findByName(String name);

	    void create(User user);

	    void update(User user);

	    void delete(int id);

	    boolean exists(User user);
}
