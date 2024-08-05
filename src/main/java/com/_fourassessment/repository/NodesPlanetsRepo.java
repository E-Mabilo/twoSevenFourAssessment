package com._fourassessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._fourassessment.entities.NodesPlanets;

@Repository
public interface NodesPlanetsRepo extends JpaRepository<NodesPlanets, Long> {
	
	//create NodesPlanets interface and extend it from the JpaRepository 
	NodesPlanets findByName(String name);
}


