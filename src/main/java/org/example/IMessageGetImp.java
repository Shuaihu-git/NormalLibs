package org.example;

import java.util.Optional;

public class IMessageGetImp implements IMessageget{
    public IMessageGetImp(){}
    public static Optional<IMessageget> get(){
        return Optional.ofNullable(null);
    }

    @Override
    public  String getMessage() {
        return "www.shuaihu.vip";
    }
}
