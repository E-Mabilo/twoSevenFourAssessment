package com._fourassessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com._fourassessment.entities.RouteRequest;
import com._fourassessment.entities.NodesPlanets;
import com._fourassessment.entities.RouteResponse;

@WebService
public class ShortPartEndpointServ {
    @Autowired
    private ShortPartServ shortestPathService;

    @WebMethod
    public RouteResponse findShortestPath(RouteRequest request) {
    	// Java 8, Stream API is used to process collections of objects. A stream in Java is a sequence of objects that supports various methods which can be pipelined to produce the desired result.
        List<String>  path= shortestPathService.findShortestPath(request.getStart(), request.getEnd()).stream().map(notePlanet -> notePlanet.getName()).toList();
        System.out.println(path);
        
        return new RouteResponse(path);
    }
}

