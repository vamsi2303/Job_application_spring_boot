package com.vamsi.FirstJob.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vamsi.FirstJob.job.Job;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String description;

    @JsonIgnore // If we don't use jsonignore we will get infinite recursive calls because we have Company mapped with job and job mapped with company
    // Company has a list of jobs and Reviews

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;


    // This empty constructor for the JPA
    public Company() {
    }
    
    //Getter Setter methods

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Company(long id, String name, String description, List<Job> jobs) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.jobs = jobs;
    }
}
