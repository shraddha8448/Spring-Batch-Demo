package com.spring_batch.Spring_Batch_Processing.repository;

import com.spring_batch.Spring_Batch_Processing.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface StudentRepository extends JpaRepository<Student,Integer> {
}
