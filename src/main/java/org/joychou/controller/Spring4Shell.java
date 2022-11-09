package org.joychou.controller;

import org.joychou.dao.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Spring4Shell {
    @RequestMapping("/login2")
    public void login2(@RequestBody User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }


    @RequestMapping("/login3")
    public void login3(User user) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
    }
}
