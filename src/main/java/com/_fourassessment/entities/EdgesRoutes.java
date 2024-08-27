package com._fourassessment.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@ToString

@Entity
public class EdgesRoutes {
	//creating an entity class to draw up EdgesRoutes objects
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private NodesPlanets source;
    @ManyToOne
    private NodesPlanets destination;
    private double distance;
    private double trafficDelay;
    
    // Getters and Setters are generated by Lombok
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NodesPlanets getSource() {
        return source;
    }

    public void setSource(NodesPlanets source) {
        this.source = source;
    }

    public NodesPlanets getDestination() {
        return destination;
    }

    public void setDestination(NodesPlanets destination) {
        this.destination = destination;
    }

    public double getTrafficDelay() {
        return trafficDelay;
    }

    public void setTrafficDelay(double trafficDelay) {
        this.trafficDelay = trafficDelay;
    }
}
