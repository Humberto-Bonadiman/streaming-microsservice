package com.java.streamingservice.configuration;

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

    @Bean(name = "streamingProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb.tertiary")
    MongoProperties getStreamingDbProps() throws Exception {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "streamingMongoTemplate")
    MongoTemplate streamingMongoTemplate() throws Exception {
        return new MongoTemplate(streamingMongoDatabaseFactory(getStreamingDbProps()));
    }

    @Primary
    @Bean
    MongoDatabaseFactory streamingMongoDatabaseFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(mongo.getUri());
    }
}
