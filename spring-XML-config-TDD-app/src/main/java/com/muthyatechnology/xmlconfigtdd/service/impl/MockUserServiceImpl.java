package com.muthyatechnology.xmlconfigtdd.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.muthyatechnology.xmlconfigtdd.bean.User;
import com.muthyatechnology.xmlconfigtdd.dao.MockUserDao;
import com.muthyatechnology.xmlconfigtdd.service.MockUserService;

@Named("mockUserService")
public class MockUserServiceImpl implements MockUserService {

@Inject
@Named("mockUserDao")
private MockUserDao mockUserDao;

    @Override
    public List<User> getAll() {
        return mockUserDao.getAll();
    }

    @Override
    public User findById(int id) {
        return mockUserDao.findById(id);
    }

    @Override
    public User findByName(String name) {
        return mockUserDao.findByName(name);
    }

    @Override
    public void create(User user) {
    	mockUserDao.create(user);
    }

    @Override
    public void update(User user) {
    	mockUserDao.update(user);
    }

    @Override
    public void delete(int id) {
    	mockUserDao.delete(id);
    }

    @Override
    public boolean exists(User user) {
        return mockUserDao.exists(user);
    }

}
