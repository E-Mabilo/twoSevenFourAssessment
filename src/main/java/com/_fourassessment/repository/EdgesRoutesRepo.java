package com._fourassessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com._fourassessment.entities.EdgesRoutes;
import com._fourassessment.entities.NodesPlanets;

@Repository
public interface EdgesRoutesRepo extends JpaRepository<EdgesRoutes, Long> {
	
	//create EdgesRoutes interface and extend it from the JpaRepository 
    List<EdgesRoutes> findBySource(NodesPlanets source);
    List<EdgesRoutes> findByDestination(NodesPlanets destination);
}


