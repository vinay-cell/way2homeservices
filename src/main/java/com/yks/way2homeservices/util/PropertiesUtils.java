package com.yks.way2homeservices.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PropertiesUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PropertiesUtils.class);
	
	private PropertiesUtils() {
        // Utility classes should not have a public or default constructor
    }
	
	public static Properties getPropertiesFromHomeDirFile(final String filename) {
        Properties properties = new Properties();
        if (filename == null) {
        	LOGGER.info("null filename provided in PropertiesUtils.getPropertiesFromHomeDirFile()");
            return properties;
        }

        File propertiesFile = new File(System.getProperty("user.home"), filename);

        if (propertiesFile.exists()) {
        	LOGGER.info("Reading properties from ~/" + filename + " file.");
            InputStream ubePropertiesInputStream;
            try {
                ubePropertiesInputStream = new FileInputStream(propertiesFile);
                properties.load(ubePropertiesInputStream);
                LOGGER.info(properties.size() + " properties were read from ~/" + filename);
            } catch (FileNotFoundException e) {
            	LOGGER.info("File not found: ~/" + filename+e);
            } catch (IOException e) {
            	LOGGER.info("Error reading ~/" + filename+""+ e);
            }
        } else {
                LOGGER.info("You have no custom properties file provided in ~/" + filename + ".  "
                        + "If you want to override the default properties, please put your values in that file.");
        }
        return properties;
    }
}
