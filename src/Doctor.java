public class Doctor {
    private String ID;
    private String Name;
    private String Speciality;
    public Doctor()
    {
    }

    public Doctor(String ID, String name, String speciality) {
        this.ID = ID;
        Name = name;
        Speciality = speciality;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpeciality() {
        return Speciality;
    }

    public void setSpeciality(String speciality) {
        Speciality = speciality;
    }

//    @Override
//    public String toString() {
//        return "Doctor{" +
//                "ID='" + getID() + '\'' +
//                ", Name='" + getName() + '\'' +
//                ", Speciality='" + getSpeciality() + '\'' +
//                ", name='" + getName() + '\'' +
//                ", speciality='" + getSpeciality() + '\'' +
//                '}';
//    }
}
