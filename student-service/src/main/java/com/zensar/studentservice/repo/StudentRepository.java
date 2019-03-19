package com.zensar.studentservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zensar.studentservice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
