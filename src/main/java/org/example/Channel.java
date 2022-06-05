package org.example;

public class Channel {
    private static final ThreadLocal<MessageChannel> THREAD_LOCAL=new ThreadLocal<>();
    private Channel(){
    }
    public static void setThreadLocal(MessageChannel messageChannel){
        THREAD_LOCAL.set(messageChannel);
    }

    public static String getInfo(){
        return Thread.currentThread().getName()+THREAD_LOCAL.get().getMessage();
    }
}
