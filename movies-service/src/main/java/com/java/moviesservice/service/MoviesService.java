package com.java.moviesservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.moviesservice.dto.MoviesDto;
import com.java.moviesservice.model.Movies;
import com.java.moviesservice.repository.MoviesRepository;

@Service
@Component
public class MoviesService implements MoviesInterface {

	@Autowired
	MoviesRepository moviesRepository;
	
	@Override
	public Movies create(MoviesDto moviesDto) {
		Movies movie = new Movies(
		    moviesDto.getTitle(),
		    moviesDto.getSynopsis(),
		    moviesDto.getDuration(),
		    moviesDto.getReleaseDate(),
		    moviesDto.getImage(),
		    moviesDto.getCategories());
		moviesRepository.save(movie);
		return movie;
	}

	@Override
	public List<Movies> listAll() {
		return moviesRepository.findAll();
	}

	@Override
	public Movies findById(String id) {
		return moviesRepository.findById(id).get();
	}

	@Override
	public Movies update(String id, MoviesDto moviesDto) {
		Movies movie = moviesRepository.findById(id).get();
		movie.setTitle(moviesDto.getTitle());
		movie.setSynopsis(moviesDto.getSynopsis());
		movie.setDuration(moviesDto.getDuration());
		movie.setReleaseDate(moviesDto.getReleaseDate());
		movie.setImage(moviesDto.getImage());
		movie.setCategories(moviesDto.getCategories());
		moviesRepository.save(movie);
		return movie;
	}

	@Override
	public void delete(String id) {
		Movies movie = moviesRepository.findById(id).get();
		moviesRepository.deleteById(movie.getId());
	}
}
