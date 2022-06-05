package org.example;

import java.util.Base64;

public class Encode {
    private static final String SALT="{"+"www.shuaihu.vip"+"}";
    private static int REPEAT=9;

    /**
     * 实现对字符串进行盐值处理的加密操作
     * @param s 等待加密的字符串
     * @return 返回加密后的字符串
     */
    public static String encode(String s){
    String tmp=s+SALT;
    byte data[]=tmp.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            data=Base64.getEncoder().encode(data);
        }
        return new String(data);
    }

    /**
     * 对字符串进行解密操作
     * @param s 待解密的字符串
     * @return 解密完成的字符串
     */
    public static String decode(String s){

        byte [] data=s.getBytes();
        for (int i = 0; i < REPEAT; i++) {
            data = Base64.getDecoder().decode(data);
        }
        return new String(data).replaceAll("\\{\\w+\\.\\w+\\.\\w+\\}","");
    }
}
