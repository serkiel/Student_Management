package com.g3appdev.JISsus.service;

import com.g3appdev.JISsus.entity.AttendanceRecord;
import com.g3appdev.JISsus.entity.Student;
import com.g3appdev.JISsus.repository.AttendanceRecordRepository;
import com.g3appdev.JISsus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AttendanceRecordService {

    @Autowired
    private AttendanceRecordRepository attendanceRecordRepository;

    @Autowired
    private StudentRepository studentRepository;


    public AttendanceRecord addAttendanceRecord(int studentID, AttendanceRecord attendanceRecord) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(() -> new NoSuchElementException("Student not found"));
        attendanceRecord.setStudent(student);  // Link the student to the attendance record
        return attendanceRecordRepository.save(attendanceRecord);
    }


    public List<AttendanceRecord> getAttendanceRecordsByStudent(int studentID) {
        Student student = studentRepository.findById(studentID)
                .orElseThrow(() -> new NoSuchElementException("Student not found"));
        return student.getAttendanceRecords();  // Fetch attendance records from the student entity
    }


    public AttendanceRecord updateAttendanceRecord(int id, AttendanceRecord updatedAttendanceRecord) {
        AttendanceRecord attendanceRecord = attendanceRecordRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("AttendanceRecord not found"));

        attendanceRecord.setType(updatedAttendanceRecord.getType());
        attendanceRecord.setDate(updatedAttendanceRecord.getDate());

        return attendanceRecordRepository.save(attendanceRecord);
    }


    public void deleteAttendanceRecord(int id) {
        attendanceRecordRepository.deleteById(id);
    }
}
