package com.muthyatechnology.xmlconfigtdd.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Named;

import com.muthyatechnology.xmlconfigtdd.bean.User;
import com.muthyatechnology.xmlconfigtdd.dao.MockUserDao;
@Named("mockUserDao")
public class MockUserDaoImpl implements MockUserDao {
    private static final AtomicInteger counter = new AtomicInteger();
    private static List<User> users = new ArrayList<User>(
            Arrays.asList(
                    new User(counter.incrementAndGet(), "Daenerys Targaryen"),
                    new User(counter.incrementAndGet(), "John Snow"),
                    new User(counter.incrementAndGet(), "Arya Stark"),
                    new User(counter.incrementAndGet(), "Cersei Baratheon")));
    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public User findByName(String name) {
        for (User user : users){
            if (user.getUsername().equals(name)){
                return user;
            }
        }
        return null;
    }

    @Override
    public void create(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }

    @Override
    public void update(User user) {
        int index = users.indexOf(findById(user.getId()));
        users.set(index, user);
    }

    @Override
    public void delete(int id) {
        User user = findById(id);
        users.remove(user);
    }

    @Override
    public boolean exists(User user) {
        return findByName(user.getUsername()) != null;
    }

}
