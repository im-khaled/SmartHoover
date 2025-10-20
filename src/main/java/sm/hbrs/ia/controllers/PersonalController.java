package sm.hbrs.ia.controllers;

import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import sm.hbrs.ia.code.ManagePersonal;
import sm.hbrs.ia.model.EvaluationRecord;
import sm.hbrs.ia.model.SalesMan;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PersonalController implements ManagePersonal{

    // Connecting to MongoDB using dependency injection
    private MongoDatabase database;
    private final String personalCollection = "employee";
    private final String performanceCollection = "SocialPerformance";

    public PersonalController( MongoDatabase database) {
        this.database = database;
    }

    //Inserting Single SalesMan into database
    @Override
    public SalesMan createSalesMan( SalesMan record ){
        Document d = record.toDocument();
        database.getCollection(personalCollection).insertOne(d);
        return record;
    }
    @Override
    public SalesMan readSalesMan( String sid ){

        Document d = database.getCollection(personalCollection).find(eq("sid", sid)).first();

        SalesMan SalesMan = new SalesMan(d.getString("firstname"), d.getString("lastname"),d.getInteger("sid"));
        return SalesMan;
    }
    @Override
    public List<SalesMan> readAllSalesMan(){

            return database.getCollection(personalCollection)
                .find()
                .map(doc ->{
                    String firstname = doc.getString("firstname");
                    String lastname = doc.getString("lastname");
                    Integer sid = doc.getInteger("sid");
                    return new SalesMan(firstname, lastname, sid);
                })
                .into(new ArrayList<>());
    }

    // adding performance record into database
    @Override
    public EvaluationRecord addPerformanceReord(EvaluationRecord record , String sid ){
        Document doc = record.toDocument(sid);
        database.getCollection(performanceCollection).insertOne(doc);
        return record;
    }

    // finding single performance record using sid
    @Override
    public EvaluationRecord readSingleEvaluationRecords(String sid) {
        Document doc = database.getCollection(performanceCollection).find(eq("sid", sid)).first();

        EvaluationRecord evaluation = new EvaluationRecord();
        if (doc != null) {
            evaluation = new EvaluationRecord(
                    doc.get("leadershipCompetence", Document.class).getInteger("supervisor", 0),
                    doc.get("leadershipCompetence", Document.class).getInteger("peerGroup", 0),

                    doc.get("opennessToEmployees", Document.class).getInteger("supervisor", 0),
                    doc.get("opennessToEmployees", Document.class).getInteger("peerGroup", 0),

                    doc.get("socialBehaviourToEmployees", Document.class).getInteger("supervisor", 0),
                    doc.get("socialBehaviourToEmployees", Document.class).getInteger("peerGroup", 0),

                    doc.get("attitudeTowardsClients", Document.class).getInteger("supervisor", 0),
                    doc.get("attitudeTowardsClients", Document.class).getInteger("peerGroup", 0),

                    doc.get("communicationSkills", Document.class).getInteger("supervisor", 0),
                    doc.get("communicationSkills", Document.class).getInteger("peerGroup", 0),

                    doc.get("integrityToCompany", Document.class).getInteger("supervisor", 0),
                    doc.get("integrityToCompany", Document.class).getInteger("peerGroup", 0)
            );


        }
        return evaluation;
    }
}