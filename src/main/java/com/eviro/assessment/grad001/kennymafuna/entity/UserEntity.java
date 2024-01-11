package com.eviro.assessment.grad001.kennymafuna.entity;

import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USERID")
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    public UserEntity(){}
    public UserEntity(Map<String, String> userMap) {
        this.name = userMap.get("name");
        this.surname = userMap.get("surname");
        this.age = Integer.parseInt(userMap.get("age"));
        this.address = userMap.get("address");
        this.phone = userMap.get("phone");
        this.email = userMap.get("email");
    }

    public String getName(){
        return this.name;
    };

    public String getSurname(){
        return this.surname;
    };

    public int getAge(){
        return this.age;
    };

    public String getAddress(){
        return this.address;
    };

    public String getPhone(){
        return this.phone;
    };

    public String getEmail(){
        return this.email;
    };

    public int getUserId(){
        return this.userId;
    };
}
