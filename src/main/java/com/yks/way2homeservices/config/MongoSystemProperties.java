package com.yks.way2homeservices.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.yks.way2homeservices.util.PropertiesUtils;


public class MongoSystemProperties {

	@Autowired
	private Environment env;

	private Properties homeDirProperties;

	private final String homeDirPropertiesFileName;

	public MongoSystemProperties(final Environment environment, final String homeDirPropertiesFileName){
		if (environment == null) {
			throw new IllegalArgumentException("Environment cannot be null when initializing "
					+ this.getClass().getName());
		}
		this.homeDirPropertiesFileName = homeDirPropertiesFileName;
		this.env = environment;
		this.homeDirProperties = getPropertiesFromHomeDir();
	}
	
	public String getProperty(final String propertyName){
		if (homeDirProperties != null) {
            if (homeDirProperties.containsKey(propertyName)) {
                return homeDirProperties.getProperty(propertyName);
            }
        }
        return env.getProperty(propertyName, "");
	}
	
	private Properties getPropertiesFromHomeDir(){
		return PropertiesUtils.getPropertiesFromHomeDirFile(homeDirPropertiesFileName);
	}
	
}
