package org.example;

public class Person implements Cloneable,Comparable<Person>{
    private String name;
    private int age;
    public  Person(String name,int age){
        this.age= age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "姓名：name"+this.name+"、年龄："+this.age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int compareTo(Person person) {
        return this.age-person.age;
    }
}
