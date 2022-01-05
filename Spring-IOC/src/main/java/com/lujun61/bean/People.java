package com.lujun61.bean;

public class People {
    private String name;
    private Integer age;
    private Address address;

    public People() {
        //System.out.println("==============People无参构造==============");
    }

    public People(String name, Integer age, Address address) {
        //System.out.println("==============People有参构造==============");
        this.name = name;
        this.age = age;
        this.address = address;
    }

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
