package com.curdoperations.controller;

import com.curdoperations.payload.StudentSignUpDto;
import com.curdoperations.service.StudentSignUpService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class StudentSignUpController {

    private final StudentSignUpService studentSignUpService;

    @PostMapping("/save")
    public ResponseEntity<StudentSignUpDto> signUp(@RequestBody StudentSignUpDto signUpDto){
        StudentSignUpDto studentSignUpDto = studentSignUpService.signUp(signUpDto);
        return new ResponseEntity<>(studentSignUpDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentSignUpDto> getById(@PathVariable long id){
        StudentSignUpDto studentSignUpDto = studentSignUpService.getById(id);
        return new ResponseEntity<>(studentSignUpDto,HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<StudentSignUpDto> getAll(){
        return studentSignUpService.getAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSignUp(@PathVariable("id") long id){
        studentSignUpService.deleteById(id);
        return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<StudentSignUpDto> updateSignUpById(@RequestBody StudentSignUpDto signUpDto , @PathVariable("id") long id){
        StudentSignUpDto studentSignUpDto = studentSignUpService.updateSignUpById(signUpDto, id);
        return new ResponseEntity<>(studentSignUpDto,HttpStatus.OK);
    }
}
