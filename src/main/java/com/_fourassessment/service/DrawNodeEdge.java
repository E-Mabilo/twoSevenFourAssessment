package com._fourassessment.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

import com._fourassessment.entities.NodesPlanets;
import com._fourassessment.entities.EdgesRoutes;

public class DrawNodeEdge {
    private final Map<NodesPlanets, List<EdgesRoutes>> adjacencyList;

    public DrawNodeEdge(List<NodesPlanets> nodes, List<EdgesRoutes> edges) {
        adjacencyList = new HashMap<>();
        for (NodesPlanets node : nodes) {
            adjacencyList.put(node, new ArrayList<>());
        }
        for (EdgesRoutes edge : edges) {
            adjacencyList.get(edge.getSource()).add(edge);
        }
    }
    
    public List<NodesPlanets> shortestPath(NodesPlanets start, NodesPlanets end) {
        // Priority queue to explore nodes by their distance
        PriorityQueue<NodeDistancePair> queue = new PriorityQueue<>(Comparator.comparingDouble(NodeDistancePair::getDistance));
        Map<NodesPlanets, Double> distances = new HashMap<>();
        Map<NodesPlanets, NodesPlanets> previousNodes = new HashMap<>();

        // Initialize distances to infinity and previous nodes to null
        for (NodesPlanets node : adjacencyList.keySet()) {
            distances.put(node, Double.MAX_VALUE);
            previousNodes.put(node, null);
        }

        // Set the distance for the start node to zero and add it to the queue
        distances.put(start, 0.0);
        queue.add(new NodeDistancePair(start, 0.0));

        while (!queue.isEmpty()) {
            // Get the node with the smallest distance
            NodeDistancePair pair = queue.poll();
            NodesPlanets current = pair.getNode();

            if (current.equals(end)) {
                break; // We've found the shortest path to the end node
            }

            // Update the distances to each neighbor
            for (EdgesRoutes edge : adjacencyList.get(current)) {
            	NodesPlanets neighbor = edge.getDestination();
                double newDist = distances.get(current) + edge.getTrafficDelay();

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previousNodes.put(neighbor, current);
                    queue.add(new NodeDistancePair(neighbor, newDist));
                }
            }
        }

        // Reconstruct the path from end to start
        List<NodesPlanets> path = new ArrayList<>();
        for (NodesPlanets at = end; at != null; at = previousNodes.get(at)) {
            path.add(at);
        }

        // Reverse the path to get the correct order from start to end
        Collections.reverse(path);

        // If the path's first node is not the start node, there is no valid path
        if (path.isEmpty() || !path.get(0).equals(start)) {
            return new ArrayList<>(); // Return an empty list if no path exists
        }

        return path;
    }

    private static class NodeDistancePair {
        private final NodesPlanets node;
        private final double distance;

        public NodeDistancePair(NodesPlanets node, double distance) {
            this.node = node;
            this.distance = distance;
        }

        public NodesPlanets getNode() {
            return node;
        }

        public double getDistance() {
            return distance;
        }

    } 
    
}
