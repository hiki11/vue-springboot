package com.wind.service;

import com.wind.dao.UserDAO;
import com.wind.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    // userDAO是大写有问题
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(String s) {
        userDAO.delete(s);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public List<User> findByPage(Integer pageNow, Integer rows) {
        int start = (pageNow-1)*rows;
        return userDAO.findByPage(start, rows);
    }

    @Override
    public Long findTotals() {
        return userDAO.findTotals();
    }
}
