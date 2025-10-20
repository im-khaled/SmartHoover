package database.sm.hbrs.ia;

import com.mongodb.client.MongoDatabase;
import sm.hbrs.ia.controllers.PersonalController;
import sm.hbrs.ia.model.SalesMan;

public class main {

    public static void main(String[] args) {
        MongoDatabase mydatabase = MongoDBConnection.getDatabase();
        PersonalController pc = new PersonalController(mydatabase);
        SalesMan Alio = new SalesMan("Alio", "Ayman",101);
        SalesMan Alioseved = pc.createSalesMan(Alio);

    }
}
