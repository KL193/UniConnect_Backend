package com.USJ.UniConnect_Backend.dao;

import com.USJ.UniConnect_Backend.entities.JobEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobDao extends MongoRepository<JobEntity,Long> {
}
