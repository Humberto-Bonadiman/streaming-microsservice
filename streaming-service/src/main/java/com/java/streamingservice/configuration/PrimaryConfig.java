package com.java.streamingservice.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.java.streamingservice.repository.StreamingRepository;

@Configuration
@EnableMongoRepositories(
    basePackageClasses = StreamingRepository.class,
    mongoTemplateRef = PrimaryConfig.MONGO_TEMPLATE)
@EnableConfigurationProperties
public class PrimaryConfig {
	protected static final String MONGO_TEMPLATE = "streamingMongoTemplate";
}
