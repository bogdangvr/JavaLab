package asociere;

public class Profesor {

    private String nume;
    private int id;

    public Profesor(int id, String nume) {
        this.nume = nume;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nume='" + nume + '\'' +
                ", id=" + id +
                '}';
    }
}
