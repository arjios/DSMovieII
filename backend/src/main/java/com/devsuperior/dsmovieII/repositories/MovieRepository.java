package com.devsuperior.dsmovieII.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmovieII.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
