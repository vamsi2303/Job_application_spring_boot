package com.vamsi.FirstJob.job.impl;

import com.vamsi.FirstJob.job.Job;
import com.vamsi.FirstJob.job.JobRepository;
import com.vamsi.FirstJob.job.jobService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl  implements jobService {
   JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    //    private List<Job> jobs= new ArrayList<>();


    private long newId =1;
    @Override
    public List<Job> FindAll() {
       return jobRepository.findAll();
    }

    @Override
    public void CreateJob(Job job) {
        job.setId(newId++);
        jobRepository.save(job);
    }
    @Override
    public Job GetJobById(long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean DeleteJobById(long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean UpdateJobById(long id, Job updatedjob) {
        Optional<Job> joboptional = jobRepository.findById(id);
        {
            if(joboptional.isPresent())
            {
                Job job= joboptional.get(); 
                job.setTitle(updatedjob.getTitle());
                job.setDescription(updatedjob.getDescription());
                job.setMinSalary(updatedjob.getMinSalary());
                job.setMaxSalary(updatedjob.getMaxSalary());
                job.setLocation(updatedjob.getLocation());
                return true;
            }
        }
        return false;
    }

}
