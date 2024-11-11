package com.spring_batch.Spring_Batch_Processing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final JobLauncher jobLauncher;
    private final Job job;

    @PostMapping
    public void importCsvToDBJob(){
        JobParameters jobParameter = new JobParametersBuilder()
                .addLong("startAt",System.currentTimeMillis())
                .toJobParameters();

        try {
            jobLauncher.run(job,jobParameter);
        } catch (JobExecutionAlreadyRunningException |JobRestartException | JobInstanceAlreadyCompleteException | JobParametersInvalidException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }
    }
}
