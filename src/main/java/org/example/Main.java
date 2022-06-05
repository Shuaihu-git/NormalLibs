package org.example;

import javax.sound.midi.Soundbank;
import java.lang.ref.Cleaner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.example.binarySearch.BinarySearch;

public class Main {
    public static void main(String[] args) {
        String string="www.shuaihu.vip";
        String strm="www.";
        String string1="www."+"shuaihu"+".vip";
        System.out.println(string==string1);
        System.out.println(string.equals(string1));

        StringBuffer stringBuffer=new StringBuffer("www.shuaihu.vip");
//        stringBuffer.append("www.").append("shuaihu").append(".vip").insert(15,":8080");
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("www.").append("shuaihu").append(".vip").insert(15,":8080/hello").delete(20,26);
        System.out.println(stringBuilder);
        System.out.println(stringBuffer.equals(string));
        System.out.println("-----------");
        CharSequence charSequence="www.shuaihu.vip";
        System.out.println(charSequence.length());

        try(Autoclose autoclose=new Autoclose(new Message("shuaihu.vip"))){
            autoclose.send();
        }catch (Exception e){
            e.printStackTrace();
        }
        Runtime runtime=Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        int [] start=new int[]{1,5,3,1,4,10};
        int [] nullArray=new int[6];
        nullArray[0]=0;
        System.arraycopy(start,0,nullArray,0,6);
      long startPoint=  System.currentTimeMillis();
        for (int tmp:nullArray
             ) {
            System.out.println(tmp);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long endPoint=System.currentTimeMillis();
        System.out.println(endPoint-startPoint);
        System.gc();
        Cleaner cleaner;
        cleaner = Cleaner.create();



        try (Cleanerimp cleanerimp=new Cleanerimp()){
//            cleanerimp.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Person person1=new Person("shuaihu.vip",1 );
        System.out.println(person1);
        Object person2= null;
        try {
            person2 = person1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(person2);
        System.out.println(MyMath.round(19.98851,3));
        FortuneTicket fortuneTicket=new FortuneTicket();
        System.out.println(round(35.115,2));
        long tt=System.currentTimeMillis();
        tt+=60*60*24*1000;
        Date date=new Date(tt);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String date1=simpleDateFormat.format(date);
        Date date2= null;
        try {
            date2 = simpleDateFormat.parse("1999-10-16 17:10:55.654");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println(date1);
        System.out.println(date2);
        String string2="http://www.shuaihu.vip:8888/hello";
        String regex="(http|https)?(\\:\\//\\w{3,}\\.\\w{2,}\\.\\w{2,})?(\\/)?(|\\:\\d{2,})?(\\/\\w+)?";
        String tel="13637271700";
        String email="1583139786@qq.com";

        if (string2.matches(regex)){
            System.out.println(string2);
        }
        if (tel.matches("(\\(\\d{3,4}\\)-)?(\\d{3,4}\\d{7,8})")){
            System.out.println(tel);
        }
        if (email.matches("[a-zA-Z0-9]\\w+@\\w+\\.(com|com.cn|org|gov|cn)")){
            System.out.println(email);
        }
        String s="ad a sd sa da d a";
        System.out.println(s.replaceAll("a| ",""));
        System.out.println(s.replaceFirst("a",""));
        String [] result=new String[s.toCharArray().length];
        result=s.split(" ");
        for (String tmp:result
             ) {
            System.out.print(tmp+"、");
        }
        System.out.println();
        String sql="insert INTO DEPT()  value(#{dept},#{name},#{loc}) ";
        Pattern pattern=Pattern.compile("#\\{\\w+\\}");
        Matcher matcher=pattern.matcher(sql);
        while (matcher.find()){
            System.out.println(matcher.group().replaceAll("#|\\{|\\}",""));
        }
        Locale locale=Locale.CHINA;
        System.out.println(locale);

        byte [] bytesa=new byte[]{1,3,4,6,7,9};
        byte [] bytesb=new byte[]{1,3,4,6,7,8};
        System.out.println(Arrays.compare(bytesa,bytesb));
        System.out.println(Arrays.equals(bytesa,bytesb));
        Arrays.sort(bytesa);
        System.out.println(Arrays.binarySearch(bytesa,(byte) 9));
        int [] p=new int[]{1,3,4,9,8,5,6,11};
        Arrays.sort(p);
        System.out.println(Arrays.toString(p));
        System.out.println(BinarySearch(p,3));
        System.out.println(BinarySearch(p,9));

        UUID uuid=UUID.randomUUID();

        System.out.println(uuid.toString());
        UUID uuid1= UUID.fromString("c5594967-207a-4bb0-bd5f-e2d8fbf719a0");
        System.out.println(uuid1);
        Optional<IMessageget> iMessageget=IMessageGetImp.get();
        System.out.println(iMessageget.orElse(new IMessageGetImp()).getMessage());
        //ThreadLocal解决线程同步问题
        new Thread(()->{
            MessageChannel messageChannel=new MessageChannel("  first->www.shuaihu.vip");
            Channel.setThreadLocal(messageChannel);

            System.out.println(Channel.getInfo());
        },"ThreadA").start();
        new Thread(()->{
            MessageChannel messageChannel=new MessageChannel("  second->www.shuaihu.vip");
            Channel.setThreadLocal(messageChannel);
            System.out.println(Channel.getInfo());
        },"ThreadB").start();
        new Thread(()->{
            MessageChannel messageChannel=new MessageChannel("  third->www.shuaihu.vip");
            Channel.setThreadLocal(messageChannel);
            System.out.println(Channel.getInfo());
        },"ThreadC").start();
//        //定时调度
//        Timer timer=new Timer();
//        timer.scheduleAtFixedRate(new TimeControl(),1000,1000);

        String newString =Encode.encode("1583139786");
        System.out.println(newString);
        System.out.println(newString.length());
        String repair=Encode.decode(newString);
        System.out.println(repair.replaceAll("\\{\\w+\\.\\w+\\.\\w+\\}",""));
        Person persons []=new Person[]{new Person("zhangsan",16),new Person("wangwu",20),new Person("lilei",23)};
        Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));


        BinaryTree<Person> personBinaryTree=new BinaryTree<>();

        personBinaryTree.add(new Person("zhangsan",25));
        personBinaryTree.add(new Person("lilei",21));
        personBinaryTree.add(new Person("zhanghan",23));
        personBinaryTree.add(new Person("xiaoshuai",22));
        personBinaryTree.add(new Person("xiaohu",20));
        System.out.println(Arrays.toString(personBinaryTree.toArray()));

        MapBinaryTree<Integer,PersonInfo> mapBinaryTree=new MapBinaryTree<>();
        mapBinaryTree.add(21,new PersonInfo("张三",21));
        mapBinaryTree.add(25,new PersonInfo("李磊",25));
        mapBinaryTree.add(26,new PersonInfo("小胡",26));
        mapBinaryTree.add(24,new PersonInfo("小胖",24));
        mapBinaryTree.add(22,new PersonInfo("溜溜",22));
        mapBinaryTree.add(30,new PersonInfo("湛澍",30));
        mapBinaryTree.add(32,new PersonInfo("瓯子",32));
        System.out.println(mapBinaryTree.contains(44));
        System.out.println(mapBinaryTree.contains(24));
        Object [] resultobj=mapBinaryTree.toArray();
        for (Object obj:
             resultobj) {
            MapBinaryTree.Entry<Integer,PersonInfo> entry=(MapBinaryTree.Entry<Integer,PersonInfo>)obj;
            System.out.println(entry.getKey()+"---->"+entry.getValue());
        }

        StringBuffer stringBuffer1=new StringBuffer();
        for (int i = 'a'; i <'z' ; i++) {
            stringBuffer1.append((char) i);
        }
        stringBuffer1.reverse().delete(0,4);
        System.out.println(stringBuffer1);
        Random random=new Random();
        int [] randomResult=new int[5];
        for (int i = 0; i < randomResult.length; i++) {
            int tmp=random.nextInt(30);
            if (tmp>=1){
                randomResult[i]=tmp;
            }

        }
        System.out.println(Arrays.toString(randomResult));
        String Email=new String("1583139786@qq.com.cn");
        if (Email.matches("\\w+@\\w+\\.(com|cn|org|com.cn)")){
            System.out.println(Email);
        }
        Coin.throwCoins(1000);
        System.out.println("front="+Coin.getFront()+"、back="+Coin.getBack());
        Qurey qurey=new Qurey("255.255.299.0");
        if (qurey.QureyIP()){
            System.out.println(qurey.getIp());
        }


        String option="zhangshan:21:69.0|lisi:22:80.5|xiaoshuai:22:100.0|张数:25:86.0";


        String [] resultstudent=option.split("\\|");
        Student [] students=new Student[resultstudent.length];
        for (int i = 0; i < resultstudent.length; i++) {
           String [] student=resultstudent[i].split(":");
                students[i]=new Student(student[0],Integer.parseInt(student[1]),Double.parseDouble(student[2]));

        }

        Arrays.sort(students);
        System.out.println(Arrays.toString(students));








    }


    public static double round(double num,int scale){
        return new BigDecimal(num).divide(new BigDecimal(1.0),scale,RoundingMode.HALF_UP).doubleValue();
    }
    public static boolean isUse(int num,int temp[]){
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