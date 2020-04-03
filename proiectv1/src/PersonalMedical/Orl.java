package PersonalMedical;

public class Orl extends Medic {
    void consulta(){};
    void trateaza(){};

    public Orl(String nume, int nrMaximPacientiZilnic) {
        super(nume, nrMaximPacientiZilnic);
    }

    @Override
    public String toString() {
        return "Orl{" +
                "nume=" + getNume() +
                ", id=" + getId() +
                ", nrMaximPacientiZilnic=" + getNrMaximPacientiZilnic() +
                ", pacienti=" + getPacienti() +
                '}';
    }
}
