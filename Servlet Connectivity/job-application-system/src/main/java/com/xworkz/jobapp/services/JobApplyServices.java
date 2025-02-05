package com.xworkz.jobapp.services;

import com.xworkz.jobapp.dto.JobApplydto;

import java.util.List;

public interface JobApplyServices {
    Boolean ValidAndSave(JobApplydto dto);
    List<JobApplydto> getApply();
    void deleteById(int id);
    JobApplydto getApplyById(int id);
    void updateApplication(JobApplydto jobApplydto);
}
