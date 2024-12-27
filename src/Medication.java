public class Medication {
    private String name;
    private String dosage;
    private String duration;
    public Medication(){

    }
    public Medication(String name, String dosage, String duration) {
        this.name = name;
        this.dosage = dosage;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Medication{" +
                "name='" + getName() + '\'' +
                ", dosage='" + getDosage() + '\'' +
                ", duration='" + getDuration() + '\'' +
                '}';
    }
}
