package com.java.moviesservice.service;

import com.java.moviesservice.dto.MoviesDto;
import com.java.moviesservice.model.Movies;
import com.java.moviesservice.repository.MoviesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesService implements MoviesInterface {

	@Autowired
	private MoviesRepository moviesRepository;
	
	@Override
	public Movies create(MoviesDto moviesDto) {
		Movies movie = new Movies(
		    moviesDto.getTitle(),
		    moviesDto.getSynopsis(),
		    moviesDto.getDuration(),
		    moviesDto.getReleaseYear(),
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
	public Movies findById(Integer id) {
		return moviesRepository.findById(id).get();
	}

	@Override
	public Movies update(Integer id, MoviesDto moviesDto) {
		Movies movie = moviesRepository.findById(id).get();
		movie.setTitle(moviesDto.getTitle());
		movie.setSynopsis(moviesDto.getSynopsis());
		movie.setDuration(moviesDto.getDuration());
		movie.setReleaseYear(moviesDto.getReleaseYear());
		movie.setImage(moviesDto.getImage());
		movie.setCategories(moviesDto.getCategories());
		moviesRepository.save(movie);
		return movie;
	}

	@Override
	public void delete(Integer id) {
		moviesRepository.deleteById(id);
	}
}
