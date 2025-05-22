package com.example.util;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBUtil {
    private static MongoClient mongoClient;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;

    static {
        try {
            String host = System.getenv().getOrDefault("MONGO_INITDB_HOST", "localhost");
            String user = System.getenv().getOrDefault("MONGO_INITDB_ROOT_USERNAME", "root");
            String pass = System.getenv().getOrDefault("MONGO_INITDB_ROOT_PASSWORD", "root");
            String uri = "mongodb://" + user + ":" + pass + "@" + host;

            
            mongoClient = MongoClients.create(uri);
            database = mongoClient.getDatabase(System.getenv().getOrDefault("MONGO_INITDB_DATABASE", "students"));
            collection = database.getCollection("students");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MongoCollection<Document> getCollection() {
        return collection;
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }
}