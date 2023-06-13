package com.empresa.optica.dao;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {
	private static MongoClient mongoClient;
	private static MongoDatabase database;

	static {
		mongoClient = MongoClients.create("mongodb://localhost:27017");
		database = mongoClient.getDatabase("optica");
	}

	public static MongoDatabase getDatabase() {
		return database;
	}
}
