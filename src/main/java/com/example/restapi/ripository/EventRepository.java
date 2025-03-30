package com.example.restapi.ripository;

import com.example.restapi.model.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EventRepository {

    List<Event> findAllEvents();
}
