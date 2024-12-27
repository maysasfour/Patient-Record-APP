public class Diagnosis {
    private String condition;
    private String notes;
    public Diagnosis(){

    }
    public Diagnosis(String condition, String notes) {
        this.condition = condition;
        this.notes = notes;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "condition='" + getCondition() + '\'' +
                ", notes='" + getNotes() + '\'' +
                '}';
    }
}
