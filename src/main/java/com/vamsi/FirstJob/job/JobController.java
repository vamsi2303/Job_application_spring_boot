package com.vamsi.FirstJob.job;

import jdk.jshell.Snippet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Job>> findAll()
        {
            return ResponseEntity.ok(jobService.FindAll());
        }
    @PostMapping("/jobs")
    public ResponseEntity<String> CreateJob(@RequestBody Job job)
    {
        jobService.CreateJob(job);
        return new ResponseEntity<>("job added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> GetJobById(@PathVariable long id)
    {
        Job job= jobService.GetJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable long id)
    {
        boolean deleted = jobService.DeleteJobById(id);
         if(deleted)
             return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable long id,@RequestBody Job updatedjob)
    {
        boolean updated = jobService.UpdateJobById(id, updatedjob);
        if(updated)
            return new ResponseEntity<>("Job Updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
