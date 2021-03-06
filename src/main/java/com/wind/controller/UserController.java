package com.wind.controller;

import com.alibaba.druid.util.StringUtils;
import com.wind.Result;
import com.wind.entity.User;
import com.wind.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wind
 */
@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    // 查询所有
    @GetMapping("findAll")
    public List<User> findAll() {
        return userService.findAll();
    }

    // 保存用户
    @PostMapping("saveOrUpdate")
    public Result saveOrUpdate(@RequestBody User user) {
        Result result = new Result();
        try {
            if (StringUtils.isEmpty(user.getId())) {
                userService.save(user);
                result.setMsg("用户信息保存成功！");
            } else {
                userService.update(user);
                result.setMsg("用户信息编辑成功！");
            }
        } catch (Exception e) {
            result.setStatus(false);
            result.setMsg("系统错误，保存用户信息失败，请稍后再试...");
        }
        return result;
    }

    // 删除用户
    @GetMapping("delete")
    public Result delete(String id) {
        Result result = new Result();
        try {
            userService.delete(id);
            result.setMsg("删除用户成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus(false);
            result.setMsg("删除用户信息失败，请稍后再试！");
        }
        return result;
    }

    // 分页查询
    @GetMapping("findByPage")
    public Map<String, Object> findByPage(Integer pageNow, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();
        pageNow = pageNow==null? 1:pageNow;
        pageSize = pageSize==null? 4:pageSize;
        List<User> users = userService.findByPage(pageNow, pageSize);
        Long totals = userService.findTotals();
        result.put("users", users);
        result.put("total", totals);

        return result;
    }
}
