package com.curdoperations.repository;

import com.curdoperations.entity.StudentSignUp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentSignUpRepository extends JpaRepository<StudentSignUp,Long> {

    Optional<StudentSignUp> findByEmail(String email);
}
