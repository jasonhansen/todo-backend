package com.springboot.ToDoApplication.hello;

public class HelloWorldBean {
    private String bean;

    public HelloWorldBean() {

    }
    public HelloWorldBean(String bean) {
        this.bean = bean;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "bean='" + bean + '\'' +
                '}';
    }
}
