package org.joychou.controller;

import java.lang.AutoCloseable;

public class TestReadable implements AutoCloseable{

    private String testString;

    public TestReadable(){}

    public void setTestString(String cmd) throws Exception{
        Runtime.getRuntime().exec(cmd);
        testString = cmd;
    }

    @Override
    public void close() throws Exception {
        System.out.println("test by cqq!");
    }
}
