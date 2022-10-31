package org.joychou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.InitialContext;
import javax.naming.NamingException;


@RestController
public class JndiInjection {

    @GetMapping("/jndi")
    public String jndi(String url) throws NamingException {
        return new InitialContext().lookup(url).toString();
    }

    public static void main(String[] args) {
    }
}
