package com.g3appdev.JISsus.controller;

import com.g3appdev.JISsus.entity.AttendanceRecord;
import com.g3appdev.JISsus.service.AttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceRecordController {

    @Autowired
    private AttendanceRecordService attendanceRecordService;


    @PostMapping("/add/{studentID}")
    public AttendanceRecord addAttendanceRecord(@PathVariable int studentID, @RequestBody AttendanceRecord attendanceRecord) {

        return attendanceRecordService.addAttendanceRecord(studentID, attendanceRecord);
    }


    @GetMapping("/student/{studentID}")
    public List<AttendanceRecord> getAttendanceRecordsByStudent(@PathVariable int studentID) {
        return attendanceRecordService.getAttendanceRecordsByStudent(studentID);
    }


    @PutMapping("/update/{id}")
    public AttendanceRecord updateAttendanceRecord(@PathVariable int id, @RequestBody AttendanceRecord attendanceRecord) {
        return attendanceRecordService.updateAttendanceRecord(id, attendanceRecord);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteAttendanceRecord(@PathVariable int id) {
        attendanceRecordService.deleteAttendanceRecord(id);
    }
}
