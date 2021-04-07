package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student") //localhost:8080/...
//All resources for API
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping //we want to take student that comes from the client and map
    public void registerNewStudent(@RequestBody Student student) throws IllegalAccessException {
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "studentId")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name, //update name and email
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
