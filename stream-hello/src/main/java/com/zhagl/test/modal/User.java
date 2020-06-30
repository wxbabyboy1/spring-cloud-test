package com.zhagl.test.modal;

public class User {
    public User(){

    }

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    String name;
    int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
