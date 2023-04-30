package com.example.googleform.client;

import com.example.googleform.model.Event;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(value="eventFeignClient", url="${googleform.event-service.host}:${googleform.event-service.port}")
public interface EventFeignClient {

    @RequestMapping(method =  RequestMethod.GET, value="/api/eventEntities/{id}", produces = "application/json")
    Event getEventById(@PathVariable("id") String id);
}
