package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class User {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String name;


@Column(unique = true)
private String email;


private String password;


private String role;
private LocalDateTime createdAt;


public User() {}


public User(String name, String email, String password, String role) {
this.name = name;
this.email = email;
this.password = password;
this.role = (role == null || role.isEmpty()) ? "ANALYST" : role;
}


@PrePersist
public void setCreatedAt() {
this.createdAt = LocalDateTime.now();
}


// getters & setters
}