package com.java.moviesservice.service;

import com.java.moviesservice.model.Movies;

import java.util.List;

import com.java.moviesservice.dto.MoviesDto;

public interface MoviesInterface {

	public Movies create(MoviesDto moviesDto);

	public List<Movies> listAll();

	public Movies findById(String id);

	public Movies update(String id, MoviesDto moviesDto);

	public void delete(String id);
}
