package com.vamsi.FirstJob.job.impl;

import com.vamsi.FirstJob.job.Job;
import com.vamsi.FirstJob.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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

    @Override
    public boolean DeleteJobById(long id) {
        Iterator<Job> iterator =jobs.iterator();
        while(iterator.hasNext())
        {
            Job job=iterator.next();
            if(job.getId() == id)
            {
                iterator.remove();
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean UpdateJobById(long id, Job updatedjob) {
        for(Job job : jobs)
        {
            if(job.getId() ==  id)
            {
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
