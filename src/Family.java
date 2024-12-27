import java.util.List;

public class Family {
    private Patient headOfFamily;
    private List<Patient> members;
    public Family()
    {

    }

    public Family(Patient headOfFamily, List<Patient> members) {
        this.headOfFamily = headOfFamily;
        this.members = members;
    }

    public Patient getHeadOfFamily() {
        return headOfFamily;
    }

    public void setHeadOfFamily(Patient headOfFamily) {
        this.headOfFamily = headOfFamily;
    }

    public List<Patient> getMembers() {
        return members;
    }

    public void setMembers(List<Patient> members) {
        this.members = members;
    }

//    @Override
//    public String toString() {
//        return "Family{" +
//                "headOfFamily=" + getHeadOfFamily() +
//                ", members=" + getMembers() +
//                '}';
//    }
}
