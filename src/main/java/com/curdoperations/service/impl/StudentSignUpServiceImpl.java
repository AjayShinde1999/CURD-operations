package com.curdoperations.service.impl;

import com.curdoperations.entity.StudentSignUp;
import com.curdoperations.exception.ResourceNotFoundException;
import com.curdoperations.payload.StudentSignUpDto;
import com.curdoperations.repository.StudentSignUpRepository;
import com.curdoperations.service.StudentSignUpService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentSignUpServiceImpl implements StudentSignUpService {

    private final ModelMapper mapper;

    private final StudentSignUpRepository studentSignUpRepository;

    @Override
    public StudentSignUpDto signUp(StudentSignUpDto signUpDto) {
        StudentSignUp studentSignUp = mapToEntity(signUpDto);
        StudentSignUp save = studentSignUpRepository.save(studentSignUp);
        return mapToDto(save);
    }

    @Override
    public StudentSignUpDto getById(long id) {
        StudentSignUp studentSignUp = studentSignUpRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No Student With This Id : " + id)
        );
        return mapToDto(studentSignUp);

    }

    @Override
    public List<StudentSignUpDto> getAll() {
        List<StudentSignUp> signUpAll = studentSignUpRepository.findAll();
        return signUpAll.stream().map(signUp -> mapToDto(signUp)).collect(Collectors.toList());

    }

    @Override
    public void deleteById(long id) {
        StudentSignUp studentSignUp = studentSignUpRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No Student With This Id : " + id)
        );

        studentSignUpRepository.delete(studentSignUp);
    }

    @Override
    public StudentSignUpDto updateSignUpById(StudentSignUpDto signUpDto, long id) {
        StudentSignUp studentSignUp = studentSignUpRepository.findById(id).get();
        studentSignUp.setName(signUpDto.getName());
        studentSignUp.setEmail(signUpDto.getEmail());
        studentSignUp.setMobile(signUpDto.getMobile());
        studentSignUp.setPassword(signUpDto.getPassword());
        StudentSignUp save = studentSignUpRepository.save(studentSignUp);
        return mapToDto(save);

    }

    public StudentSignUp mapToEntity(StudentSignUpDto dto) {
        return mapper.map(dto, StudentSignUp.class);
    }

    public StudentSignUpDto mapToDto(StudentSignUp signUp) {
        return mapper.map(signUp, StudentSignUpDto.class);
    }
}
