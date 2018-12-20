package com.yks.way2homeservices.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan({"com.yks.way2homeservices"})
@PropertySource(name = "mongoProperties", value = "classpath:Config_Mongo_DB.properties")
@EnableMongoRepositories(basePackages = "com.yks.way2homeservices.dao")
public class ApplicationDataConfig extends AbstractApplicationDataConfig {


	private static final String HOME_DIR_PROPS_FILENAME = ".way2homeservices.mongo.properties";
	
    @Autowired
    private Environment mongoProperties;
    
    @Bean
    @Override
    MongoSystemProperties getMongoSystemProperties() {
        return new MongoSystemProperties(mongoProperties, getHomeDirPropertiesFilename());
    }

    @Override
    String getHomeDirPropertiesFilename() {
        return HOME_DIR_PROPS_FILENAME;
    }

}
