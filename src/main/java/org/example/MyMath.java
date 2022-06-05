package org.example;

public class MyMath {
    private MyMath(){

    }
    public static double round(double num,int scale){
        return Math.round(num*Math.pow(10,scale))/Math.pow(10,scale);
    }

}
