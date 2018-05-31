package com.ezreal.caffeine.controller;


import com.ezreal.caffeine.entity.User;
import com.ezreal.caffeine.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ezreal
 */
@RestController
@Slf4j
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    @ResponseBody
    public List<User> users() {
        return userService.list();
    }

    @RequestMapping("/user")
    @ResponseBody
    public User findUserById(@RequestParam("id") Long id) {
        long stime = System.currentTimeMillis();
        log.info("-----Get value by id=" + id + ", The time is " + stime);
        User userById = userService.findUserById(id);
        long etime = System.currentTimeMillis();
        log.info("-------Get value by id=" + id + ", The time is " + Long.toBinaryString(etime - stime));
        return userService.findUserById(id);
    }

    @RequestMapping("/info}")
    @ResponseBody
    public User findInfoById(@RequestParam("id") Long id) {
        long time = System.currentTimeMillis();
        log.info("------The cacheManager is" + userService);
        log.info("------Get value by id=" + id + ", The time is " + time);
        return userService.findInfoById(id);
    }

    @RequestMapping("/update/user")
    @ResponseBody
    public Map update(@RequestParam("id") Long id, @RequestParam("name") String name) {
        User user = userService.findUserById(id);
        user.setName(name);
        userService.update(user);
        Map<String, Object> result = new HashMap<>();
        result.put("ret", 0);
        result.put("msg", "ok");
        return result;
    }


}
