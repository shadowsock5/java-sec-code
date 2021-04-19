package org.joychou.controller;

import org.joychou.dao.User;
import org.joychou.util.WebUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import org.yaml.snakeyaml.Yaml;

import javax.servlet.http.HttpServletRequest;

@RestController
public class YamlDese {

        @PostMapping("/YamlDecoder")
        public String parseYaml(HttpServletRequest request) throws Exception{
//            String payload = WebUtils.getRequestBody(request);
            String payload = request.getParameter("yaml");

            Yaml yaml = new Yaml();

            User u;
            try{
                u = yaml.load(payload);
            }catch (Exception e){
                return e.toString();
            }

            return u.toString();
        }
}
