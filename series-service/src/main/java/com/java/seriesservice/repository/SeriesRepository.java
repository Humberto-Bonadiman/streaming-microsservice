package com.java.seriesservice.repository;

import com.java.seriesservice.model.Series;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeriesRepository extends MongoRepository<Series, String> {

}
