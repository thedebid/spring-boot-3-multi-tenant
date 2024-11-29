package org.cryptic.springboot3multitenant.service;

import org.cryptic.springboot3multitenant.entity.Student;
import org.cryptic.springboot3multitenant.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAll() throws SQLException {
        return studentRepository.findAll();

    }

    public Student get(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student getByName(String name) {
        return studentRepository.findByName(name);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
