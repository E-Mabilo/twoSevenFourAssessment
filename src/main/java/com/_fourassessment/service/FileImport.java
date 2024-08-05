package com._fourassessment.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

//import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._fourassessment.repository.EdgesRoutesRepo;
import com._fourassessment.repository.NodesPlanetsRepo;
import com._fourassessment.entities.NodesPlanets;
import com._fourassessment.entities.EdgesRoutes;

@Service
public class FileImport {
    @Autowired
    private NodesPlanetsRepo nodeRepository;
    @Autowired
    private EdgesRoutesRepo edgeRepository;

    public void importData(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        Map<String, NodesPlanets> nodesPlanetsMap = new HashMap<>();

        // Skipping header line
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split("\\s+");

            String originName = parts[1];
            String destinationName = parts[2];
            double trafficDelay = Double.parseDouble(parts[3]);

            NodesPlanets origin = nodesPlanetsMap.computeIfAbsent(originName, name -> new NodesPlanets(name));
            NodesPlanets destination = nodesPlanetsMap.computeIfAbsent(destinationName, name -> new NodesPlanets(name));

            nodeRepository.save(origin);
            nodeRepository.save(destination);

            EdgesRoutes edge = new EdgesRoutes();
            edge.setSource(origin);
            edge.setDestination(destination);
            edge.setTrafficDelay(trafficDelay);
            edgeRepository.save(edge);
            
        }
    }
}




