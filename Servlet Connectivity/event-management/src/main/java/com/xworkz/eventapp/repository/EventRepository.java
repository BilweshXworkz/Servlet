package com.xworkz.eventapp.repository;

import com.xworkz.eventapp.entity.EventEntity;

public interface EventRepository {
    Boolean save(EventEntity eventEntity);
}
