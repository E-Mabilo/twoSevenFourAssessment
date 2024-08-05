package com._fourassessment.entities;

import java.util.List;

@XmlRootElement
public class RouteResponse {
    private List<String> nodes;

    public RouteResponse() {}

    // Constructor with nodes list
    public RouteResponse(List<String> nodes) {
        this.nodes = nodes;
    }

    @XmlRootElement
    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }
}
