package com.xworkz.feedbackapp.repository;

import com.xworkz.feedbackapp.entity.FeedbackEntity;

public interface FeedbackRepository {
    Boolean save (FeedbackEntity feedbackEntity);
}
