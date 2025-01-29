package com.xworkz.feedbackapp.services;

import com.xworkz.feedbackapp.dto.FeedbackDto;


public interface FeedbackServices {
    Boolean ValidAndSave(FeedbackDto dto);
}
