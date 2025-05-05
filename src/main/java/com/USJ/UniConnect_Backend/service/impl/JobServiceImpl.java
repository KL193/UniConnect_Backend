package com.USJ.UniConnect_Backend.service.impl;

import com.USJ.UniConnect_Backend.dao.JobDao;
import com.USJ.UniConnect_Backend.dto.*;
import com.USJ.UniConnect_Backend.entities.ApplicantEntity;
import com.USJ.UniConnect_Backend.entities.JobEntity;
import com.USJ.UniConnect_Backend.exception.JobPortalException;
import com.USJ.UniConnect_Backend.service.JobService;
import com.USJ.UniConnect_Backend.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;


    @Override
    public JobDto postJob(JobDto jobDto) throws JobPortalException {
        if(jobDto.getId()==0){
            jobDto.setId(Utilities.getNextSequence("jobs"));
            jobDto.setPostTime(LocalDateTime.now());
        }

        else{
            JobEntity jobEntity = jobDao.findById(jobDto.getId()).orElseThrow(()->new JobPortalException("Job_Not_Found"));
            if(jobEntity.getJobStatus().equals(JobStatus.DRAFT) || jobDto.getJobStatus().equals(JobStatus.CLOSED))jobDto.setPostTime(LocalDateTime.now());
        }

        return jobDao.save(jobDto.toEntity()).toDto();

    }

    @Override
    public List<JobDto> getAllJobs() {
        return jobDao.findAll().stream().map((x)->x.toDto()).toList();
    }

    @Override
    public JobDto getJob(Long id) throws JobPortalException {
        return jobDao.findById(id).orElseThrow(()->new JobPortalException("Job_Not_Found")).toDto();
    }

    @Override
    public void applyJob(Long id, ApplicantDto applicantDto) throws JobPortalException {
        JobEntity jobEntity = jobDao.findById(id).orElseThrow(()->new JobPortalException("Job_Not_Found"));
        List<ApplicantEntity> applicantEntities = jobEntity.getApplicants();
        if(applicantEntities==null)applicantEntities = new ArrayList<>();
        if (applicantEntities.stream().filter((x)->x.getApplicationId()==applicantDto.getApplicationId()).toList().size()>0)throw new JobPortalException("Job_Applied_Already");
        applicantDto.setApplicationStatus(ApplicationStatus.APPLIED);
        applicantEntities.add(applicantDto.toEntity());
        jobEntity.setApplicants(applicantEntities);
        jobDao.save(jobEntity);

    }

    @Override
    public List<JobDto> getJobsPostedBy(Long id) {
        return jobDao.findByPostedBy(id).stream().map((x)->x.toDto()).toList();
    }

    @Override
    public void changeAppStatus(Application application) throws JobPortalException {
        JobEntity jobEntity = jobDao.findById(application.getId()).orElseThrow(()->new JobPortalException("Job_Not_Found"));
        List<ApplicantEntity> applicantEntities = jobEntity.getApplicants().stream().map((x)->{
          if(application.getApplicationId()==x.getApplicationId()){
              x.setApplicationStatus(application.getApplicationStatus());
              if(application.getApplicationStatus().equals(ApplicationStatus.INTERVIEWING))x.setInterviewTime(application.getInterviewTime());
          }
          return x;
        }).toList();
        jobEntity.setApplicants(applicantEntities);
        jobDao.save(jobEntity);
    }
}
