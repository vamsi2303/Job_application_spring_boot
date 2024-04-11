package com.vamsi.FirstJob.job.impl;

import com.vamsi.FirstJob.job.Job;
import com.vamsi.FirstJob.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class JobServiceImpl  implements jobService {

    private List<Job> jobs= new ArrayList<>();
    private long newId =1;
    @Override
    public List<Job> FindAll() {
       return jobs;
    }

    @Override
    public void CreateJob(Job job) {
        job.setId(newId++);
        jobs.add(job);
    }
    @Override
    public Job GetJobById(long id) {
        for(Job job: jobs)
        {
            if(job.getId() == id)
            {
                return job;
            }
        }
        return null;
    }

}
