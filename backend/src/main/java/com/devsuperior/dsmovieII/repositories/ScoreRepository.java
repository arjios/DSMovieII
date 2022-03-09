package com.devsuperior.dsmovieII.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovieII.entities.Score;
import com.devsuperior.dsmovieII.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	
	

}
