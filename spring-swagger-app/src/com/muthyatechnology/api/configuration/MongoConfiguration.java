/**
 * Copyrights to Yaskawa
 */
package com.muthyatechnology.api.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

/**
 * @author Nagaraju G
 *
 */
@Configuration
@PropertySource("classpath:/api-db.properties")
@EnableMongoRepositories
public class MongoConfiguration extends AbstractMongoConfiguration {
	@Autowired
	Environment env;

	@Override
	protected String getDatabaseName() {
		return env.getProperty("db.database.name");
	}

	@Primary
	@Override
	public Mongo mongo() throws Exception {
		/*
		 * In general, users of this MongoClientOptions class will pick up all
		 * of the default options specified in MongoClientOptions. In
		 * particular, note that the default value of the connectionsPerHost
		 * option has been increased to 100 from the old default value of 10
		 * used by the superceded Mongo class.
		 */

		/*
		 * final UserCredentials userCredentials = new
		 * UserCredentials(this.userName, this.password);
		 * 
		 * final MongoTemplate mongoTemplate = new MongoTemplate(mongo(),
		 * getDatabaseName(), userCredentials);
		 * mongoTemplate.setWriteConcern(WriteConcern.SAFE);
		 */

		MongoClientOptions.Builder clientOptions = new MongoClientOptions.Builder();
		// clientOptions.minConnectionsPerHost(20);//min
		// clientOptions.connectionsPerHost(200);//max
		List<ServerAddress> serverAddresses = new ArrayList<>();
		ServerAddress serverAddress = new ServerAddress(env.getProperty("db.host.url"),
				Integer.valueOf(env.getProperty("db.port.number")));
		serverAddresses.add(serverAddress);
		return new MongoClient(serverAddresses, clientOptions.build());
	}

	@Override
	protected String getMappingBasePackage() {
		return "com.yaskawa.ai.dashboardapi.model";
	}
}