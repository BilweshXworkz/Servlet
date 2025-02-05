package com.xworkz.feedbackapp.repository;

import com.xworkz.feedbackapp.entity.FeedbackEntity;

import java.util.List;

public interface FeedbackRepository {
    Boolean save (FeedbackEntity feedbackEntity);
    List<FeedbackEntity> getFeedbackDetails();
    void deleteById(int id);
    FeedbackEntity getProfileById(Integer id);
    void updateProfile(FeedbackEntity entity);
}
