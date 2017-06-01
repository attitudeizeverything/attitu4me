package com.yoho.request;



import java.io.Serializable;
/**
 * @author Ranga Reddy
 * @version 1.0
 *
 */
public class Employees implements Serializable {

    private static final long serialVersionUID = -7988799579036225137L;

    private long id;

    private String name;

    private int age;

    private float salary;

    public Employees() {
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public float getSalary() {
        return salary;
    }
    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
