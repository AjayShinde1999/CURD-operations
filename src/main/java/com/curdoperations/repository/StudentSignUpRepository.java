package com.curdoperations.repository;

import com.curdoperations.entity.StudentSignUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentSignUpRepository extends JpaRepository<StudentSignUp,Long> {
}
