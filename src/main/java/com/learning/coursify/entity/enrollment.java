package com.learning.coursify.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary Key

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Foreign Key (FK) to User Table

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course; // Foreign Key (FK) to Course Table

    @Column(name = "enrolled_at", nullable = false)
    private LocalDateTime enrolledAt; // Enrollment Date & Time

    // Default Constructor (JPA requires this)
    public Enrollment() {}

    // Convenience Constructor
    public Enrollment(User user, Course course) {
        this.user = user;
        this.course = course;
        this.enrolledAt = LocalDateTime.now(); // Automatically sets current time
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }

    public LocalDateTime getEnrolledAt() { return enrolledAt; }
    public void setEnrolledAt(LocalDateTime enrolledAt) { this.enrolledAt = enrolledAt; }
}
