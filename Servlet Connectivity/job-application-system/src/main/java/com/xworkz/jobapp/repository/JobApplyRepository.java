package com.xworkz.jobapp.repository;

import com.xworkz.jobapp.dto.JobApplydto;
import com.xworkz.jobapp.entity.JobApplyEntity;

public interface JobApplyRepository {
    Boolean save (JobApplyEntity jobApplyEntity);
}
