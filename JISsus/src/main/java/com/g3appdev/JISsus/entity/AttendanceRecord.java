package com.g3appdev.JISsus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AttendanceRecord")
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int AttendanceID;

    @ManyToOne
    @JoinColumn(name = "StudentID", nullable = false)
    @JsonBackReference  // This will ignore the student when serializing attendance records
    private Student student;

    @Column(nullable = false)
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    // Getters and Setters
    public int getAttendanceID() {
        return AttendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        AttendanceID = attendanceID;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
