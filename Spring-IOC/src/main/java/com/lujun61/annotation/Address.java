package com.lujun61.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("myAddress")
public class Address {
    @Value("HuBei")
    private String province;

    @Value("JingZhou")
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
