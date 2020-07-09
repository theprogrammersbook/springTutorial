package com.muthyatechnology.xmlconfigtdd.service;


import java.util.List;

import com.muthyatechnology.xmlconfigtdd.bean.User;

public interface MockUserService {

    List<User> getAll();

    User findById(int id);

    User findByName(String name);

    void create(User user);

    void update(User user);

    void delete(int id);

    boolean exists(User user);
}
