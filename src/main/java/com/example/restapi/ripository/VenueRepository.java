package com.example.restapi.ripository;

import com.example.restapi.model.Venue;
import com.example.restapi.model.request.VenueRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenueRepository {
    @Select("""
    select * from venues
    offset  #{pageSize} * (#{page}-1)
            limit #{pageSize}

    """)
    @Results(id = "venues", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    List<Venue> findAllVenues(Integer page,Integer pageSize);


    @Select("""
    select * from venues
    where venue_id = #{venueId}
    """)
    @ResultMap("venues")
    Venue findVenueById(Integer id);


    @Select("""
        insert into venues(venue_name, location)
        values (#{venues.venueName}, #{venues.location}) returning *
        
    """)
    @Result(property = "venueId", column = "venue_id")
    @Result(property = "venueName", column = "venue_name")
    Venue insertVenue(@Param("venues") VenueRequest venueRequest);

}
