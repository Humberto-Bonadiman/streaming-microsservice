package com.java.moviesservice.repository;

import com.java.moviesservice.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {

}
