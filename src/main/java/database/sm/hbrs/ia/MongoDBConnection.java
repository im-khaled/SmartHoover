package database.sm.hbrs.ia;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017"; // adjust if remote
    private static final String DATABASE_NAME = "salesman"; // change to your DB name

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    static {
        // Initialize connection once
        mongoClient = MongoClients.create(CONNECTION_STRING);
        database = mongoClient.getDatabase(DATABASE_NAME);
        System.out.println("Connected to MongoDB: " + DATABASE_NAME);
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            System.out.println("🔌 MongoDB connection closed.");
        }
    }
}