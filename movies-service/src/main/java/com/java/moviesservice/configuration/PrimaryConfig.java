package com.java.moviesservice.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.java.moviesservice.repository.MoviesRepository;

@Configuration
@EnableMongoRepositories(
    basePackageClasses = MoviesRepository.class,
    mongoTemplateRef = PrimaryConfig.MONGO_TEMPLATE)
@EnableConfigurationProperties
public class PrimaryConfig {
	protected static final String MONGO_TEMPLATE = "moviesMongoTemplate";
}
