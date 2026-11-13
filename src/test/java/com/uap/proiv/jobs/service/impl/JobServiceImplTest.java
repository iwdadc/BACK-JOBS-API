package com.uap.proiv.jobs.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uap.proiv.jobs.client.JobApiRepository;
import com.uap.proiv.jobs.dto.Job;

@ExtendWith(MockitoExtension.class)
public class JobServiceImplTest {

    @Mock   
    JobApiRepository jobApiRepository;

    @InjectMocks 
    JobServiceImpl jobServiceImpl;

    List<Job> jobs;

    @BeforeEach 
    void setup() {
        jobs = new ArrayList<>();

        Job job1 = new Job();
        job1.setId(1);
        job1.setName("Developer");
        job1.setSalary(5000);   
        job1.setHours(2000);
        job1.setResources(3);
        jobs.add(job1);

        Job job2 = new Job();
        job2.setId(2);
        job2.setName("Desingner");
        job2.setSalary(4500);
        job2.setHours(1500);
        job2.setResources(1);
        jobs.add(job2);

        Job job3 = new Job();
        job3.setId(3);
        job3.setName("Manager");
        job3.setSalary(6000);
        job3.setHours(45);
        job3.setResources(1);
        jobs.add(job3);
    }
    
    @Test 
    @DisplayName ("Verifica que el método getAllJobs() retorne la lista completa de jobs")
    void getAllJob_Success() {
        when(jobApiRepository.getAllJobs()).thenReturn(jobs);

        List<Job> result = jobServiceImpl.getAllJobs();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Developer", result.get(0).getName());
        verify(jobApiRepository, times(1)).getAllJobs();
    }

    @Test 
    @DisplayName ("Verifica una exception en JobApiRepository por listado vacio")
    void getAllJob_Exception() {
        when(jobApiRepository.getAllJobs()).thenReturn(new ArrayList<>());

        assertThrows(NoSuchElementException.class, () -> {
            jobServiceImpl.getJobById(1);
        });
        
        verify(jobApiRepository, times(1)).getAllJobs();
    }
}
