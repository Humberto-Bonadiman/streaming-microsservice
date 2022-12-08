package com.java.moviesservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.java.moviesservice.model.Movies;

public interface MoviesRepository extends MongoRepository<Movies, String> {

}
