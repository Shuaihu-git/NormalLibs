package org.example;

import java.lang.ref.Cleaner;

public class Member implements Runnable {
    public Member(){
        System.out.println("1111111111111111111");
    }

    @Override
    public void run() {
        System.out.println("12333331231313213131");
    }
}
class Cleanerimp implements AutoCloseable{
    private Member member;
    private final Cleaner cleaner=Cleaner.create();
    private Cleaner.Cleanable cleanable;

    Cleanerimp() {
        this.member =new Member();
        this.cleanable=this.cleaner.register(this,member);
    }

    @Override
    public void close() throws Exception {
        this.cleanable.clean();
    }
}
