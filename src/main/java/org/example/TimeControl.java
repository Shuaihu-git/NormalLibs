package org.example;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.UUID;

public class TimeControl extends TimerTask {
    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(simpleDateFormat.format(new Date())+" "+ UUID.randomUUID());
    }
}
