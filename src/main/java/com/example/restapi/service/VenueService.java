package com.example.restapi.service;

import com.example.restapi.model.Venue;
import com.example.restapi.model.request.VenueRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VenueService {

    List<Venue> getAllVenues(Integer page, Integer pageSize);

    Venue getVenueById(Integer id);

    Venue createVenue(VenueRequest venueRequest);

    Venue deleteVenueById(Integer id);
}

