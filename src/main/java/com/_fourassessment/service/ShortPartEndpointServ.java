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
        List<NodesPlanets> path = shortestPathService.findShortestPath(request.getStart(), request.getEnd());
        System.out.println(path);
        return new RouteResponse(path);
    }
}

