public class Patient extends Person {
    private String ID;
    private String telephoneNumber;
    public Patient()
    {
    }

    public Patient(String ID, String telephoneNumber) {
        this.ID = ID;
        this.telephoneNumber = telephoneNumber;
    }

    public Patient(String name, String address, String ID, String telephoneNumber) {
        super(name, address);
        this.ID = ID;
        this.telephoneNumber = telephoneNumber;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

//    @Override
//    public String toString() {
//        return "Patient{" +
//                "ID='" + getID() + '\'' +
//                ", TelephoneNumber='" + getTelephoneNumber() + '\'' +
//                ", telephoneNumber='" + getTelephoneNumber() + '\'' +
//                '}';
//    }
}
