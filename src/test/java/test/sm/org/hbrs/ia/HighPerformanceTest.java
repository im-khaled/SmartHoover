package test.sm.org.hbrs.ia;

import com.mongodb.client.MongoDatabase;
import database.sm.hbrs.ia.MongoDBConnection;
import sm.hbrs.ia.controllers.PersonalController;
import sm.hbrs.ia.model.SalesMan;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HighPerformanceTest {

    private MongoDatabase database;
    private PersonalController pc;
    private final String personalCollection = "employee";
    private final String performanceCollection = "SocialPerformance";

    @BeforeEach
    void setUp() {
        // connecting database using connection page
        database = MongoDBConnection.getDatabase();
        pc = new PersonalController(database);

    }

    @Test
    void insertSalesMan() {
        // CREATE (Storing) the salesman object
        SalesMan Jack = new SalesMan("Jack", "Jossy", 9904);

        // ... now storing the object
        pc.createSalesMan(Jack);

        // READ (Finding) the stored Documnent
        Document newDocument = this.database.getCollection(personalCollection).find().first();
        System.out.println("Printing the object (JSON): " + newDocument );

        // Assertion
        Integer sid = (Integer) newDocument.get("sid");
        assertEquals( 9904 , sid );

        // Deletion
        pc.deleteSalesMan(9904);
    }


}
