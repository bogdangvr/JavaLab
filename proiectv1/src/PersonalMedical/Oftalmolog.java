package PersonalMedical;

public class Oftalmolog extends Medic {
    void consulta(){};
    void trateaza(){};

    public Oftalmolog(String nume, int nrMaximPacientiZilnic) {
        super(nume, nrMaximPacientiZilnic);
    }

    @Override
    public String toString() {
        return "Oftalmolog{" +
                "nume=" + getNume() +
                ", id=" + getId() +
                ", nrMaximPacientiZilnic=" + getNrMaximPacientiZilnic() +
                ", pacienti=" + getPacienti() +
                '}';
    }
}
