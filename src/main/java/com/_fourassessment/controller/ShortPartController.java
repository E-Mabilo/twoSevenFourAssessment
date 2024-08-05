package com._fourassessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com._fourassessment.entities.NodesPlanets;
import com._fourassessment.service.ShortPartServ;

@Controller
public class ShortPartController {
    @Autowired
    private ShortPartServ shortestPathService;

    @PostMapping("/shortest-path")
    public String findShortestPath(@RequestParam String source, @RequestParam String destination, Model model) {
        List<NodesPlanets> path = shortestPathService.findShortestPath(source, destination);
        model.addAttribute("path", path);
        
        System.out.println("path: "+ path);
        return "result";
    }
}


