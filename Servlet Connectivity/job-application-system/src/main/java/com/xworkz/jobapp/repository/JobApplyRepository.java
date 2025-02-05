package com.xworkz.jobapp.repository;

import com.xworkz.jobapp.dto.JobApplydto;
import com.xworkz.jobapp.entity.JobApplyEntity;

import java.util.List;

public interface JobApplyRepository {
    Boolean save (JobApplyEntity jobApplyEntity);
    List<JobApplyEntity> getApplyDetails();
    void deleteById(int id);
    JobApplyEntity getApplyById(int id);
    void updateApplication(JobApplyEntity entity);
}
