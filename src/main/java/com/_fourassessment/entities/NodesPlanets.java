package com._fourassessment.entities;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@ToString
@Entity
public class NodesPlanets {
	//creating an entity class to draw up NodesPlanets objects
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    
    // Constructor that takes a name
    public NodesPlanets(String name) {
        this.name = name;
    }

    // Getters and Setters are generated by Lombok
    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
