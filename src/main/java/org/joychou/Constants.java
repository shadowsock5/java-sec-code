package org.joychou;

public class Constants {
    public static final String testURL = "https://ip.cn";
    public static final String GLOBAL_URL = java.lang.System.getenv("GLOBAL_URL");


    public static void main(String[] args){
        System.out.println(GLOBAL_URL);
    }
}
