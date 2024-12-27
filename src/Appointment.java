import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Appointment {
    private LocalDate date;
    private LocalTime time;
    private Doctor doctor;
    private Patient patient;
    private AppointmentStatus status;


    public Appointment(LocalDate date, LocalTime time, Doctor doctor, Patient patient, AppointmentStatus status) {
        if (date == null || time == null || doctor == null || patient == null || status == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }
        this.date = date;
        this.time = time;
        this.doctor = doctor;
        this.patient = patient;
        this.status = status;
    }


    public Appointment() {

        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.doctor = null;
        this.patient = null;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public Appointment(Doctor doctor, Patient patient) {
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.doctor = doctor;
        this.patient = patient;
        this.status = AppointmentStatus.SCHEDULED;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public AppointmentStatus getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "date=" + date +
                ", time=" + time +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", status=" + status +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(date, that.date) &&
                Objects.equals(time, that.time) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(patient, that.patient) &&
                status == that.status;
    }


    @Override
    public int hashCode() {
        return Objects.hash(date, time, doctor, patient, status);
    }
}
