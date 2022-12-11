package com.java.seriesservice.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.java.seriesservice.repository.SeriesRepository;

@Configuration
@EnableMongoRepositories(
    basePackageClasses = SeriesRepository.class,
    mongoTemplateRef = PrimaryConfig.MONGO_TEMPLATE)
@EnableConfigurationProperties
public class PrimaryConfig {
	protected static final String MONGO_TEMPLATE = "seriesMongoTemplate";
}
