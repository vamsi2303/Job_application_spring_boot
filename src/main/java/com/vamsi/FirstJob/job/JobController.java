package com.vamsi.FirstJob.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class JobController {

  private jobService jobService;

    public JobController(com.vamsi.FirstJob.job.jobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll()
        {
            return jobService.FindAll();
        }
    @PostMapping("/jobs")
    public String CreateJob(@RequestBody Job job)
    {
        jobService.CreateJob(job);
        return "Job added successfully";
    }
    @GetMapping("/jobs/{id}")
    public Job GetJobById(@PathVariable long id)
    {
        Job job= jobService.GetJobById(id);
        if(job != null)
            return job;
        return new Job(1L, "TestJob", "This is a Testjob","2000", "2000", "Loc");
    }

}
