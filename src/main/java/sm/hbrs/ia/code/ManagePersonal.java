package sm.hbrs.ia.code;

import sm.hbrs.ia.model.EvaluationRecord;
import sm.hbrs.ia.model.SalesMan;


import java.util.List;

public interface ManagePersonal {
    public SalesMan createSalesMan( SalesMan record );

    public EvaluationRecord addPerformanceReord(EvaluationRecord record , String sid );

    public SalesMan readSalesMan(String sid );

   public void deleteSalesMan(int sid );



    public EvaluationRecord readSingleEvaluationRecords(String sid);

    public List<SalesMan> readAllSalesMan();

}
