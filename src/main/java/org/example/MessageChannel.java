package org.example;

public class MessageChannel {
    private String message;
    public MessageChannel(String msg){
        this.message=msg;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
