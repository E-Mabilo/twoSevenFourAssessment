package com._fourassessment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._fourassessment.entities.NodesPlanets;
import com._fourassessment.entities.EdgesRoutes;
import com._fourassessment.repository.EdgesRoutesRepo;
import com._fourassessment.repository.NodesPlanetsRepo;


@Service
public class ShortPartServ {
    @Autowired
    private NodesPlanetsRepo nodeRepository;
    @Autowired
    private EdgesRoutesRepo edgeRepository;

    public List<NodesPlanets> findShortestPath(String startName, String endName) {
    	NodesPlanets start = nodeRepository.findByName(startName);
    	System.out.println("Start: " + start);
    	NodesPlanets end = nodeRepository.findByName(endName);
    	System.out.println("End: " + end);
        List<NodesPlanets> nodes = nodeRepository.findAll();
        List<EdgesRoutes> edges = edgeRepository.findAll();
        DrawNodeEdge graph = new DrawNodeEdge(nodes, edges);
        System.out.println("Graph ****** " + graph);
        return graph.shortestPath(start, end);
    }
}


