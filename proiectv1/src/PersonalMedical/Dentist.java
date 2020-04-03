package PersonalMedical;

public class Dentist extends Medic {
    void consulta(){};
    void trateaza(){};

    public Dentist(String nume, int nrMaximPacientiZilnic) {
        super(nume, nrMaximPacientiZilnic);
    }
    @Override
    public String toString() {
        return "Dentist{" +
                "nume=" + getNume() +
                ", id=" + getId() +
                ", nrMaximPacientiZilnic=" + getNrMaximPacientiZilnic() +
                ", pacienti=" + getPacienti() +
                '}';
    }
}
