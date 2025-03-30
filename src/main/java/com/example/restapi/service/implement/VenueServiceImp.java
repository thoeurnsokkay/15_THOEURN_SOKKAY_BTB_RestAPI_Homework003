package com.example.restapi.service.implement;

import com.example.restapi.model.Venue;
import com.example.restapi.model.request.VenueRequest;
import com.example.restapi.ripository.VenueRepository;
import com.example.restapi.service.VenueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VenueServiceImp implements VenueService {
    public final VenueRepository venueRepository;




    @Override
    public List<Venue> getAllVenues(Integer page, Integer pageSize) {
        return venueRepository.findAllVenues(page, pageSize);
    }

    @Override
    public Venue getVenueById(Integer id) {

        return venueRepository.findVenueById(id);
    }

    @Override
    public Venue createVenue(VenueRequest venueRequest) {
        return venueRepository.insertVenue(venueRequest);
    }

    @Override
    public Venue deleteVenueById(Integer id) {
        return null;
    }

}
