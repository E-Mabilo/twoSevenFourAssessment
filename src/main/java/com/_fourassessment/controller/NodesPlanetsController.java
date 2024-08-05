package com._fourassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._fourassessment.entities.NodesPlanets;
import com._fourassessment.repository.NodesPlanetsRepo;

@RestController
@RequestMapping("/connect/nodesplanets/")
public class NodesPlanetsController {
    @Autowired
    private NodesPlanetsRepo nodeRepository;

    @GetMapping
    public List<NodesPlanets> getAllNodes() {
        return nodeRepository.findAll();
    }

    @PostMapping
    public NodesPlanets createNode(@RequestBody NodesPlanets node) {
        return nodeRepository.save(node);
    }

    @PutMapping("{id}")
    public NodesPlanets updateNode(@PathVariable Long id, @RequestBody NodesPlanets nodeDetails) {
    	NodesPlanets node = nodeRepository.findById(id).orElseThrow();
        node.setName(nodeDetails.getName());
        return nodeRepository.save(node);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteNode(@PathVariable Long id) {
        nodeRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}


