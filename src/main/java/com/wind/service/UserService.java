package com.wind.service;

import com.wind.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    //查询所有方法
    List<User> findAll();

    // 保存用户信息
    void save(User user);

    // 根据id删除一个用户
    void delete(String s);

    // 修改用户信息
    void update(User user);

    // 分页查询
    List<User> findByPage(Integer pageNow, Integer rows);

    // 查询总条数
    Long findTotals();
}
