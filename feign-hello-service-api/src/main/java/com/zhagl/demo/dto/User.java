package com.zhagl.demo.dto;


public class User {
    //一定要加上默认的构造方法！
    // 不然feign-hello-service-consumer模块的helloConsumer3中refactorHelloService.hello("haha", 20)报错
    public User(){

    }

    public User(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
