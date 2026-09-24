package com.learning.coursify.entity;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long PK;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="role",nullable = false)
    private String role;
    @Column(name="created_at",nullable = false)
    private Timestamp created_at;
    @Column(name="updated_at",nullable = false)
    private Timestamp updated_at;

    public UserEntity() {
    }
    public UserEntity(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    @PrePersist
    protected void onCreate() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        this.created_at = currentTime;
        this.updated_at= currentTime;
    }
    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Timestamp(System.currentTimeMillis());
    }

    public long getPK() {
        return PK;
    }
    public void setPK(long PK) {
        this.PK = PK;
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

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}