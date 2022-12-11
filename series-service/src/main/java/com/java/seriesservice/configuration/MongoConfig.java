package com.java.seriesservice.configuration;

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

    @Bean(name = "seriesProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.secondary")
    MongoProperties getSeriesDbProps() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "seriesMongoTemplate")
    MongoTemplate moviesMongoTemplate() throws Exception {
        return new MongoTemplate(seriesMongoDatabaseFactory(getSeriesDbProps()));
    }

    @Primary
    @Bean
    MongoDatabaseFactory seriesMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(mongo.getUri());
    }
}
