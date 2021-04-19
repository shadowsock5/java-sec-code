package org.joychou;

import java.io.Serializable;

public class TestSerializable implements Serializable{
    private String testString;

    public TestSerializable(){}

    public void setTestString(String cmd) throws Exception{
        Runtime.getRuntime().exec(cmd);
    }
}
