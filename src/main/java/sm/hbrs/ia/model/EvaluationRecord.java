package sm.hbrs.ia.model;

import org.bson.Document;

public class EvaluationRecord {
    private int leadershipCompetenceSupervisor;
    private int leadershipCompetencePeer;
    private int opennessToEmployeesSupervisor;
    private int opennessToEmployeesPeer;
    private int socialBehaviourToEmployeesSupervisor;
    private int socialBehaviourToEmployeesPeer;
    private int attitudeTowardsClientsSupervisor;
    private int attitudeTowardsClientsPeer;
    private int communicationSkillsSupervisor;
    private int communicationSkillsPeer;
    private int integrityToCompanySupervisor;
    private int integrityToCompanyPeer;

    // Constructors
    public EvaluationRecord() {}

    public EvaluationRecord(
            int leadershipCompetenceSupervisor, int leadershipCompetencePeer,
            int opennessToEmployeesSupervisor, int opennessToEmployeesPeer,
            int socialBehaviourToEmployeesSupervisor, int socialBehaviourToEmployeesPeer,
            int attitudeTowardsClientsSupervisor, int attitudeTowardsClientsPeer,
            int communicationSkillsSupervisor, int communicationSkillsPeer,
            int integrityToCompanySupervisor, int integrityToCompanyPeer
    ) {
        this.leadershipCompetenceSupervisor = leadershipCompetenceSupervisor;
        this.leadershipCompetencePeer = leadershipCompetencePeer;
        this.opennessToEmployeesSupervisor = opennessToEmployeesSupervisor;
        this.opennessToEmployeesPeer = opennessToEmployeesPeer;
        this.socialBehaviourToEmployeesSupervisor = socialBehaviourToEmployeesSupervisor;
        this.socialBehaviourToEmployeesPeer = socialBehaviourToEmployeesPeer;
        this.attitudeTowardsClientsSupervisor = attitudeTowardsClientsSupervisor;
        this.attitudeTowardsClientsPeer = attitudeTowardsClientsPeer;
        this.communicationSkillsSupervisor = communicationSkillsSupervisor;
        this.communicationSkillsPeer = communicationSkillsPeer;
        this.integrityToCompanySupervisor = integrityToCompanySupervisor;
        this.integrityToCompanyPeer = integrityToCompanyPeer;
    }

    public Document toDocument(String sid) {
        org.bson.Document document = new Document();
        document.append("leadershipCompetence", new Document("supervisor", this.leadershipCompetenceSupervisor).append("peerGroup", this.leadershipCompetencePeer));
        document.append("opennessToEmployees", new Document("supervisor", this.opennessToEmployeesSupervisor).append("peerGroup", this.opennessToEmployeesPeer));
        document.append("socialBehaviourToEmployees", new Document("supervisor", this.socialBehaviourToEmployeesSupervisor).append("peerGroup", this.socialBehaviourToEmployeesPeer));
        document.append("attitudeTowardsClients", new Document("supervisor", this.attitudeTowardsClientsSupervisor).append("peerGroup", this.attitudeTowardsClientsPeer));
        document.append("communicationSkills", new Document("supervisor", this.communicationSkillsSupervisor).append("peerGroup", this.communicationSkillsPeer));
        document.append("integrityToCompany", new Document("supervisor", this.integrityToCompanySupervisor).append("peerGroup", this.integrityToCompanyPeer));
        document.append("sid", sid);
        return document;
    }

    @Override
    public String toString() {
        return "SocialPerformance{" +
                "leadershipCompetenceSupervisor=" + leadershipCompetenceSupervisor +
                ", leadershipCompetencePeer=" + leadershipCompetencePeer +
                ", opennessToEmployeesSupervisor=" + opennessToEmployeesSupervisor +
                ", opennessToEmployeesPeer=" + opennessToEmployeesPeer +
                ", socialBehaviourToEmployeesSupervisor=" + socialBehaviourToEmployeesSupervisor +
                ", socialBehaviourToEmployeesPeer=" + socialBehaviourToEmployeesPeer +
                ", attitudeTowardsClientsSupervisor=" + attitudeTowardsClientsSupervisor +
                ", attitudeTowardsClientsPeer=" + attitudeTowardsClientsPeer +
                ", communicationSkillsSupervisor=" + communicationSkillsSupervisor +
                ", communicationSkillsPeer=" + communicationSkillsPeer +
                ", integrityToCompanySupervisor=" + integrityToCompanySupervisor +
                ", integrityToCompanyPeer=" + integrityToCompanyPeer +
                '}';
    }

    // Getters and setters omitted
}
