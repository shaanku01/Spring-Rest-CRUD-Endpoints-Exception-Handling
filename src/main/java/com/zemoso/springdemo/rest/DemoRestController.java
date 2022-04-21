package com.zemoso.springdemo.rest;

import com.zemoso.springdemo.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    private List<Student> students;

    //@PostConstruct To load the student data...

    @PostConstruct
    public void loadData(){
        this.students = new ArrayList<>();
        this.students.add(new Student("Shanker","Sai"));
        this.students.add(new Student("Kalyan","C"));
        this.students.add(new Student("Vineet","G"));

    }


    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/students")
    public List giveStudents(){
        students = new ArrayList<>();
        students.add(new Student("Shanker","Sai"));
        students.add(new Student("Kalyan","C"));
        students.add(new Student("Vineet","G"));

        return students;

    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        students = new ArrayList<>();
        students.add(new Student("Shanker","Sai"));
        students.add(new Student("Kalyan","C"));
        students.add(new Student("Vineet","G"));


        if(studentId<0 || studentId>=students.size()){
            throw new StudentNotFoundException("StudentId not Found :: --"+ studentId);
        }

        return students.get(studentId);
    }

    // Add an exception handler using @ExceptionHandler:
    // @Exception handler annotation tells that this function is a exception handler
    // the return type defines the type of the response body

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exe){
//        //create a StudentErrorResponse
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.NOT_FOUND.value());
//        error.setMessage(exe.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//
//
//
//        //return a ResponseEntity
//
//        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//    }
//
//    // Add another Exception handler : Generic
//
//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exe){
//        StudentErrorResponse error = new StudentErrorResponse();
//
//        error.setStatus(HttpStatus.BAD_REQUEST.value());
//        error.setMessage(exe.getMessage());
//        error.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//
//
//    }

}
