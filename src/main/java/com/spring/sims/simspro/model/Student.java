package com.spring.sims.simspro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long Id;
    private String Name;
    private String department;
    private int mobile;
    private String address;

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", department='" + department + '\'' +
                ", mobile=" + mobile +
                ", address='" + address + '\'' +
                '}';
    }


    public Student(long Id, String Name, String department, int mobile, String address) {
        this.Id = Id;
        this.Name = Name;
        this.department = department;
        this.mobile = mobile;
        this.address = address;
    }

    public Student() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
