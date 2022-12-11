package com.java.moviesservice.configuration;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

	@Primary
    @Bean(name = "moviesProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.primary")
    MongoProperties getMoviesDbProps() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "moviesMongoTemplate")
    MongoTemplate moviesMongoTemplate() throws Exception {
        return new MongoTemplate(moviesMongoDatabaseFactory(getMoviesDbProps()));
    }

    @Primary
    @Bean
    MongoDatabaseFactory moviesMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(mongo.getUri());
    }
}
