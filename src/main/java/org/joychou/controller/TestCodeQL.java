package org.joychou.controller;

import org.joychou.Constants;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 专门用于CodeQL测试
 */
@RestController
public class TestCodeQL {

    /**
     * http://localhost:8080/codeql/vul/?x=xxx.
     */
    @RequestMapping("/codeql/vul")
    private static String vul(String x) throws Exception{
        URL url = new URL("http://baidu.com");
        URL url2 = new URL(Constants.testURL);
        URL url3 = new URL(Constants.GLOBAL_URL);
        URLConnection urlConnection = url.openConnection();
        URLConnection urlConnection2 = url2.openConnection();
        URLConnection urlConnection3 = url3.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); //send request
        String inputLine;
        StringBuffer html = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            html.append(inputLine);
        }
        in.close();
        return html.toString();
    }

    @RequestMapping("/codeql/vul1")
    private static String vul1(String x) throws Exception{
        URL url = new URL(x);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); //send request
        String inputLine;
        StringBuffer html = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            html.append(inputLine);
        }
        in.close();
        return html.toString();
    }

    public static void main(String[] args)  {

    }
}

