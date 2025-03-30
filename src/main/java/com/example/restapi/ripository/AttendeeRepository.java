package com.example.restapi.ripository;

import com.example.restapi.model.Venue;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AttendeeRepository {
    @Select("""
    select * from venues
    offset  #{pageSize} * (#{page}-1)
            limit #{pageSize}

    """)
    @Results(id = "venues", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name")
    })
    List<Venue> findAllVenues(Integer page, Integer pageSize);


    @Select("""
    select * from venues
    where venue_id = #{venueId}
    """)
    @ResultMap("venues")
    Venue findVenueById(Integer id);
}
