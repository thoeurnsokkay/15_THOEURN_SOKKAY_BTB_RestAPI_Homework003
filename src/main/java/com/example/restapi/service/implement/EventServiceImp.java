package com.example.restapi.service.implement;

import com.example.restapi.model.Event;
import com.example.restapi.ripository.EventRepository;
import com.example.restapi.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventServiceImp implements EventService {
    private final EventRepository eventRepository;

    public EventServiceImp(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAllEvents();
    }
}
