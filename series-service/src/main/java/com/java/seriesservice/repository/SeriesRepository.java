package com.java.seriesservice.repository;

import com.java.seriesservice.model.Series;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Integer> {

}
