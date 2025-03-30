package com.example.restapi.controller;

import com.example.restapi.model.Venue;
import com.example.restapi.model.request.VenueRequest;
import com.example.restapi.model.response.ApiResponse;
import com.example.restapi.ripository.VenueRepository;
import com.example.restapi.service.VenueService;
import com.example.restapi.service.implement.VenueServiceImp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor

public class VenueController {

    private final VenueService venueService;

    //    get all venue;
    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Venue>>> getAllVenues(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        List<Venue> venues = venueService.getAllVenues(page, pageSize);
        ApiResponse<List<Venue>> response = ApiResponse.<List<Venue>>builder()
                .message("All venues have been successfully fetched.")
                .payload(venues)
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Venue>> getVenueById(@PathVariable Integer id) {
        Venue venue = venueService.getVenueById(id);
        if(venue!=null) {
            ApiResponse response = ApiResponse.<Venue>builder()
                    .message("The venue has been successfully founded.")
                    .payload(venue)
                    .status(HttpStatus.OK)
                    .timestamp(LocalDateTime.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping("/")
    public ApiResponse<Venue> createVenue(@RequestBody VenueRequest venueRequest) {

        Venue venue = venueService.createVenue(venueRequest);

        ApiResponse<Venue> response = ApiResponse.<Venue>builder()
                .timestamp(LocalDateTime.now())
                .message("Create author successfully.")
                .status(HttpStatus.CREATED)
                .payload(venue)
                .build();

        return response;
    }

//    @DeleteMapping("/{id}")
//    public String deleteTicketId(@PathVariable Integer id){
//        for(Ticket ticket : ticketList){
//            if(ticket.getTickedId() == id){
//                ticketList.remove(ticket);
//                return "Remove Success!!";
//            }
//        }
//        return "Ticker not found!!";
//    }
    @DeleteMapping("/{id}")
    public ApiResponse<Venue> deleteVenueById(@RequestBody Integer id) {
        Venue venue = venueService.deleteVenueById(id);
//        return null;
        if(venue.getVenueId() == id){
            venueService.deleteVenueById(id);{
                ApiResponse response = ApiResponse.<Venue>builder()
                        .message("The venue has been successfully founded.")
                        .payload(venue)
                        .status(HttpStatus.OK)
                        .timestamp(LocalDateTime.now())
                        .build();
                return response;
            }
        }

//    return ApiResponse.<Venue>builder().build()
        return null;
    }


}
