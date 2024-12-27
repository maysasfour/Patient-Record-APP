import java.util.Date;
import java.util.List;

public class Visit {
    private Date date;
    private List<Diagnosis> diagnoses;
    private List<Medication> medications;
    public Visit(){

    }

    public Visit(Date date, List<Diagnosis> diagnoses, List<Medication> medications) {
        this.date = date;
        this.diagnoses = diagnoses;
        this.medications = medications;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

//    @Override
//    public String toString() {
//        return "Visit{" +
//                "date=" + getDate() +
//                ", diagnoses=" + getDiagnoses() +
//                ", medications=" + getMedications() +
//                '}';
//    }
}
