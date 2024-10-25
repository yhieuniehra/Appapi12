package com.example.Appapi12.model;

import jakarta.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Tự động tạo ID
    private int id;
    private String name;
    private String email;


    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    // Constructor mặc định (nếu không dùng Lombok)
    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    //Getter & Setter function here
}
