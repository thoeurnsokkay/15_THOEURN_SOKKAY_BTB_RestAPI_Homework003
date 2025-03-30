package com.example.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Event {
    private Integer eventId;
    private String eventName;
    private LocalDate eventDate;
    private Event event;
    private List<Attendee> attendees;
}
