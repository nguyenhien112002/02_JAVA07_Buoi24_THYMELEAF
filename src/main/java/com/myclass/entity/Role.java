package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //khai bao cho hibernate biet lop nay se dung de anh xa den 1 bang trong csdl
@Table(name="roles") // lop nay anh xa den bang "roles" trong csdl
public class Role {
    
    @Column(name="id") //cot id
    @Id //khoa chinh
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tang tu dong
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;

    public Role() {
    }

    public Role(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
