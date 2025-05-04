package com.USJ.UniConnect_Backend.service.impl;

import com.USJ.UniConnect_Backend.dao.JobDao;
import com.USJ.UniConnect_Backend.dto.JobDto;
import com.USJ.UniConnect_Backend.exception.JobPortalException;
import com.USJ.UniConnect_Backend.service.JobService;
import com.USJ.UniConnect_Backend.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("jobService")
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;


    @Override
    public JobDto postJob(JobDto jobDto) throws JobPortalException {
        jobDto.setId(Utilities.getNextSequence("jobs"));
        jobDto.setPostTime(LocalDateTime.now());
        return jobDao.save(jobDto.toEntity()).toDto();

    }

    @Override
    public List<JobDto> getAllJobs() {
        return jobDao.findAll().stream().map((x)->x.toDto()).toList();
    }
}
