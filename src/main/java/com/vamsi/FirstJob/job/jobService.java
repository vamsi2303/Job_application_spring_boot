package com.vamsi.FirstJob.job;

import java.util.List;

public interface jobService {

    List<Job> FindAll();

    void CreateJob(Job job);

    Job GetJobById(long id);
}
