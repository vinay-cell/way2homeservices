package com.yks.way2homeservices.config;

import static java.lang.String.format;
import static org.apache.commons.lang.math.NumberUtils.toInt;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.util.Assert;

import com.mongodb.Mongo;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public abstract class AbstractApplicationDataConfig extends AbstractMongoConfiguration {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractApplicationDataConfig.class);
	
	private static final int MAX_NODES_IN_REPLICA_SET = 50;
	
	abstract MongoSystemProperties getMongoSystemProperties();
	
	abstract String getHomeDirPropertiesFilename();
	
	@Override
	protected String getDatabaseName() {
		return getMongoSystemProperties().getProperty("mongo.db");
	}

	@Override
	public Mongo mongo() throws Exception {
        List<ServerAddress> servers = new ArrayList<ServerAddress>(MAX_NODES_IN_REPLICA_SET);
        String hostProp = getMongoSystemProperties().getProperty("mongo.host");
        String portProp = getMongoSystemProperties().getProperty("mongo.port");
        if (!StringUtils.isBlank(hostProp) || StringUtils.isBlank(portProp)) {
            servers.add(new ServerAddress(hostProp, Integer.valueOf(portProp)));
        }
        LOGGER.info("Configuring mongo connection...");

        for (int i = 0; i < MAX_NODES_IN_REPLICA_SET; i++) {
            String hostPropertyName = format("mongo.%d.host", i);
            String host = getMongoSystemProperties().getProperty(hostPropertyName);
            String portPropertyName = format("mongo.%d.port", i);
            String portStr = getMongoSystemProperties().getProperty(portPropertyName);
            if (StringUtils.isBlank(host) || StringUtils.isBlank(portStr)) {
                break;
            }
            int port = toInt(portStr);
            Assert.isTrue(port > 0, format("Invalid value '%s' for property '%s'", portStr, portPropertyName));
            servers.add(new ServerAddress(host, port));
            LOGGER.info(format("Adding connection to mongo server [%d]: host: '%s', port: %d", i, host, port));
        }

        Assert.notEmpty(servers, "No mongo hosts were defined in the mongo properties file.");
        LOGGER.info(format("A total of %d mongo servers have been configured.", servers.size()));
        Mongo mongo = new Mongo(servers);
        mongo.setWriteConcern(WriteConcern.SAFE);
        /* List servers=new ArrayList();
        servers.add(new ServerAddress(hostProp, Integer.valueOf(portProp)));

        List creds=new ArrayList();
        creds.add(MongoCredential.createMongoCRCredential(user,database, password.toCharArray()));
        return new MongoClient(servers,creds);*/
        
        return mongo;
	}

}
