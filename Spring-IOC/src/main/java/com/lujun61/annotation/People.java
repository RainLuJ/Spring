package com.lujun61.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/** Component注解的解释
 *     来源：Spring框架
 *     作用：是用来【创建对象】的，等同于XML文件中的bean标签。
 *
 *     属性：value-是String类型的，等同于XML文件中的bean标签中的id属性
 *     注解使用位置：在定义的类上面
 */
@Component(value = "myPeople")
//@Component("myPeople")  ------>可以省略value
//@Component()   ------>全部省略，id值默认为：类名首字母小写
public class People {
    /** Value注解的解释
     *      来源：Spring框架
     *      作用：是用来给【简单类型】的【属性】赋值的
     *
     *      属性：value-是String类型的，表示简单数据类型的属性值
     *      位置：
     *            1.如果在属性定义的上面，则无需set方法。推荐使用
     *            2.如果在set方法的上面，则需要set方法
     */
    @Value(value = "${name}")
    private String name;

    @Value(value = "18")
    private Integer age;


    /** Autowired注解的解释
     *      来源：Spring框架
     *      作用：是用来给【引用数据类型】的【属性】赋值的
     *          ---用到的方式是[自动注入]的原理，支持byType，byName。默认为：byType
     *
     *          如果要使用byName：
     *          ---还需要在【属性/set方法】上面加上一个【@Qualifier(value="bean的id")】注解，
     *              表示使用指定id的bean来给属性完成赋值
     *
     *      属性：required-是一个boolean类型的，默认为true
     *          ---含义：
     *                  如果为true->表示引用类型属性如果赋值失败，程序报错，并终止执行（推荐使用：可以避免属性使用时的空指针异常）
     *                  如果为false->表示引用类型属性如果赋值失败，程序正常执行，但是值为null
     *      位置：
     *            1.如果在属性定义的上面，则无需set方法。推荐使用
     *            2.如果在set方法的上面，则需要set方法
     */
    @Autowired(required = true)
    @Qualifier(value="myAddress")  /* 按名称（id）byName自动注入 */
    private Address address;


    /** Resource注解的解释
     *      来源：JDK; 在Spring框架中提供了对这个注解的支持
     *      作用：是用来给【引用数据类型】的【属性】赋值的
     *          ---用到的方式是[自动注入]的原理，支持byType，byName。
     *             默认为：byName；
     *             注意：如果没有符合byName条件的值(类名首字母小写)，则会自动切换为byType
     *
     *      （部分）属性：name-是一个String类型的。如果想让@Resource只使用byName的方式寻找对象，需要增加一个属性：name="bean的id值"
     *
     *      位置：
     *            1.如果在属性定义的上面，则无需set方法。推荐使用
     *            2.如果在set方法的上面，则需要set方法
     */
    @Resource(name = "myStudent")
    private Student student;

    public People() {
        //System.out.println("==============People无参构造==============");
    }

    public People(String name, Integer age, Address address, Student student) {
        //System.out.println("==============People有参构造==============");
        this.name = name;
        this.age = age;
        this.address = address;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    //@Value(value = "LJ")
    public void setName(String name) {
        System.out.println("com.lujun61.annotation.People中的setName方法");
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", student=" + student +
                '}';
    }
}
