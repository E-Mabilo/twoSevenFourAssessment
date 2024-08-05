package com._fourassessment.entities;



@XmlRootElement
public class RouteRequest {
    private String start;
    private String end;

    public RouteRequest() {}

    public String getStart() {
        return start;
    }

    @XmlRootElement
    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    @XmlRootElement
    public void setEnd(String end) {
        this.end = end;
    }
}

