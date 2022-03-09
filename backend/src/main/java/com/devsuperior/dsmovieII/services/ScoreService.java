package com.devsuperior.dsmovieII.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovieII.dto.MovieDTO;
import com.devsuperior.dsmovieII.dto.ScoreDTO;
import com.devsuperior.dsmovieII.entities.Movie;
import com.devsuperior.dsmovieII.entities.Score;
import com.devsuperior.dsmovieII.entities.User;
import com.devsuperior.dsmovieII.repositories.MovieRepository;
import com.devsuperior.dsmovieII.repositories.ScoreRepository;
import com.devsuperior.dsmovieII.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for( Score s : movie.getScores()) {
			sum += s.getValue();
		}
		movie.setScore(sum / movie.getScores().size());
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.saveAndFlush(movie);
		
		return new MovieDTO(movie);
	}
	


}
