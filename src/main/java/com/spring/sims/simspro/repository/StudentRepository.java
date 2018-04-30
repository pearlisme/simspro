package com.spring.sims.simspro.repository;

import com.spring.sims.simspro.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
