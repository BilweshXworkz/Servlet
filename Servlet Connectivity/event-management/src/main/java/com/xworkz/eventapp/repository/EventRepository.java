package com.xworkz.eventapp.repository;

import com.xworkz.eventapp.entity.EventEntity;

import java.util.List;

public interface EventRepository {
    Boolean save(EventEntity eventEntity);
    List<EventEntity> getEventDetails();
    void deleteById(int id);
}
