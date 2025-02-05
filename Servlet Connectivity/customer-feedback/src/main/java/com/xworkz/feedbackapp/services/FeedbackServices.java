package com.xworkz.feedbackapp.services;

import com.xworkz.feedbackapp.dto.FeedbackDto;

import java.util.List;


public interface FeedbackServices {
    Boolean ValidAndSave(FeedbackDto dto);
    List<FeedbackDto> getFeedback();
    void deleteById(int id);
    FeedbackDto updateById(Integer id);
    void updateProfile(FeedbackDto dto);
}
