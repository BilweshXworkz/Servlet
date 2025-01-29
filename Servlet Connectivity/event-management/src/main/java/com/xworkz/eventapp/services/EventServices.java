package com.xworkz.eventapp.services;

import com.xworkz.eventapp.dto.EventDto;
import com.xworkz.eventapp.repository.EventRepository;

public interface EventServices {
    Boolean validAndSave(EventDto eventDto);
}
