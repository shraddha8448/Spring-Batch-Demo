package com.spring_batch.Spring_Batch_Processing.config;

import com.spring_batch.Spring_Batch_Processing.modal.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentProcessor implements ItemProcessor<Student,Student> {
    @Override
    public Student process(Student student) throws Exception {
        student.setId(null);
        return student;
    }
}
