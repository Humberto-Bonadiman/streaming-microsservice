package com.java.moviesservice.service;

import com.java.moviesservice.model.Movies;

import java.util.List;

import com.java.moviesservice.dto.MoviesDto;

public interface MoviesInterface {

	public Movies create(MoviesDto moviesDto);

	public List<Movies> listAll();

	public Movies findById(Integer id);

	public Movies update(Integer id, MoviesDto moviesDto);

	public void delete(Integer id);
}
