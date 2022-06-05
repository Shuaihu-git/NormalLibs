package org.example;

public class Qurey {
    private String ip;
    public Qurey(String ip){
        this.ip=ip;
    }
    public boolean QureyIP(){
        String regex="([12]?[0-9]?[0-9]\\.){3}([12]?[0-9]?[0-9])";
        if (this.ip==null||"".equals(this.ip)){
            return false;
        }
        if (this.ip.matches(regex)){
        String [] result=this.ip.split("\\.");
            for (int i = 0; i < result.length; i++) {
                int tmp=Integer.parseInt(result[i]);
                System.out.println(result.length);
                System.out.println(tmp);
                if (tmp>255){
                    return false;
                }

            }
        }else {
            return false;
        }
       return true;
    }

    public String getIp() {
        return ip;
    }
}
