package org.cryptic.springboot3multitenant.controller;

import org.cryptic.springboot3multitenant.entity.Student;
import org.cryptic.springboot3multitenant.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Student>> getAll() throws SQLException {
        List<Student> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<Student> get(@PathVariable(value = "id") Long id) {
        Student student = studentService.get(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping(value = "/get/{name}")
    public ResponseEntity<Student> get(@PathVariable(value = "name") String name) {
        Student student = studentService.getByName(name);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Student> delete(@PathVariable(value = "id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
