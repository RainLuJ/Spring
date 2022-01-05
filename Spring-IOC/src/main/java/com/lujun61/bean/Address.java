package com.lujun61.bean;

public class Address {
    private String province;
    private String city;

    public Address() {
        //System.out.println("==============Address无参构造==============");
    }

    public Address(String province, String city) {
        //System.out.println("==============Address有参构造==============");
        this.province = province;
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
