package com.devsuperior.dsmovieII.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmovieII.dto.MovieDTO;
import com.devsuperior.dsmovieII.dto.ScoreDTO;
import com.devsuperior.dsmovieII.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		
		MovieDTO movieDTO = scoreService.saveScore(dto);
		return movieDTO;
	}

}
