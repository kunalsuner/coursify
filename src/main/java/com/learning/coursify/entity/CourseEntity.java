package com.learning.coursify.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="Course")
@Getter
@Setter
public class CourseEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long PK;

    @Column(name ="Title",nullable = false,unique = true)
    private String title;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price",nullable = false)
    private double price;

    @Column(name = "Duration")
    private int duration;

    @Column(name = "CreatedAt",nullable = false)
    private Timestamp created_at;

    @Column(name = "UpdatedAt",nullable = false)
    private Timestamp updated_at;

    @PrePersist
    protected void onCreate() {
        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
        this.created_at = currentTime;
        this.updated_at = currentTime;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Timestamp(System.currentTimeMillis());
    }
    public CourseEntity() {
    }

    public CourseEntity(String title, String description,
                        double price, int duration) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.duration = duration;
    }
}