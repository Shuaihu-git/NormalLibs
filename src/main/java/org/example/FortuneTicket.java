package org.example;

import java.util.Random;

public class FortuneTicket {
    public FortuneTicket(){
        Random random1=new Random();
        Random random2=new Random();
        for (int j = 0; j < 5; j++) {
            int reddata[]=new int[6];
            int bluedata []=new int[1];
            int foot=0;
            while (foot<6){
                int num=random1.nextInt(33);
                if (this.isUse(num,reddata)){
                    reddata[foot++]=num;
                }
            }
            int blue=random2.nextInt(16);
            if (blue!=0){
                if (this.isUse(blue,bluedata)){
                    bluedata[0]=blue;
                }
            }else {
                    bluedata[0]=blue+2;
            }
            java.util.Arrays.sort(reddata);
            for (int tmp:reddata
            ) {
                System.out.print(tmp+"、");
            }
            for (int tmp:bluedata
            ) {
                System.out.println(tmp);
            }
            System.out.println();
        }

    }
    /***
     * 判断传入的数字是否不为0并且在当前数组中是否重复可用
     * @param num 需要判断的当前数字
     * @param temp 当前数组
     * @return 不为0且可用返回true否则返回false
     */
    public boolean isUse(int num,int temp[]){
        if (num==0){
            return false;
        }
        for (int i = 0; i < temp.length; i++) {
            if (num==temp[i]){
                return  false;
            }
        }
        return true;
    }
}
