package sm.hbrs.ia.controllers;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import sm.hbrs.ia.code.ManagePersonal;
import sm.hbrs.ia.model.EvaluationRecord;
import sm.hbrs.ia.model.SalesMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PersonalController implements ManagePersonal{
    // get mongodb via dependency injection
    private MongoDatabase database;
    private final String personalCollection = "employee";
    private final String performanceCollection = "performance_records";

    public PersonalController( MongoDatabase database) {
        this.database = database;
    }

    @Override
    public SalesMan createSalesMan( SalesMan record ){
        Document d = record.toDocument();
        database.getCollection(personalCollection).insertOne(d);
        return record;
    }
    @Override
    public SalesMan readSalesMan( String sid  ){

        SalesMan b = new SalesMan("alice", "mahmud", 20);
        return b;
    }


}