package com.wind;

import com.wind.entity.User;
import com.wind.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testFindAll() {
        userService.findAll().forEach(user-> System.out.println("user= " + user));
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setName("王老五");
        user.setBir(new Date());
        user.setSex("男");
        user.setAddress("上海市虹桥医院");
        userService.save(user);
    }

    @Test
    public void testDelete() {
        userService.delete("3");
    }
}
