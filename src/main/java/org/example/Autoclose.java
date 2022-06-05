package org.example;
interface IMessage extends AutoCloseable{
    public void send();
}
public class Autoclose implements IMessage {
    public Message message;
    public Autoclose(Message message){
        this.message=message;
    }
    public boolean connection(){
        System.out.println("通道建立成功");
        return true;
    }
    @Override
    public void send() {
        if (this.connection()){
            System.out.println("发送消息"+this.message.getMsg());
        }else {
            System.out.println("通道建立失败");
        }

    }

    @Override
    public void close() throws Exception {
        System.out.println("关闭消息连接通道");
    }
}
class Message {
    private String msg;

    public Message(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }
}
