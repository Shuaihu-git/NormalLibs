package org.example;

import java.util.Random;

public class Coin {
    private static int front;
    private static int back;
    private static Random random=new Random();
    private Coin(){}
    public static void throwCoins(int times){

        for (int i = 0; i < times; i++) {
            int tmp=random.nextInt(2);
            if (tmp==0){
                front++;
            }
            else {
                back++;
            }
        }
    }

    public static int getBack() {
        return back;
    }

    public static int getFront() {
        return front;
    }
}
