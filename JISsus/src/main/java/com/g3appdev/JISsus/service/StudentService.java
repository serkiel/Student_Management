package com.g3appdev.JISsus.service;

import com.g3appdev.JISsus.entity.Student;
import com.g3appdev.JISsus.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @SuppressWarnings("finally")
    public Student putStudentDetails(int id, Student newStudentDetails) {
        Student student = new Student();
        try {

            student = studentRepository.findById(id)
                    .get();


            student.setSeatID(newStudentDetails.getSeatID());
            student.setName(newStudentDetails.getName());
            student.setProgram(newStudentDetails.getProgram());
            student.setYearlevel(newStudentDetails.getYearlevel());
            student.setPassword(newStudentDetails.getPassword());
            student.setEmail(newStudentDetails.getEmail());

        } catch (NoSuchElementException e) {
            throw new RuntimeException("Student " + id + " not found");
        } finally {
            return studentRepository.save(student);
        }
    }


    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}
