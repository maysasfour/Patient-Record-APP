public class Receptionist {
    private String ID;
    private String name;

    public Receptionist() {

    }

    public Receptionist(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "ID='" + getID() + '\'' +
                ", name='" + getName() + '\'' +
                '}';
    }
}