package PersonalMedical;

public class Cardiolog extends Medic {
    void consulta(){};
    void trateaza(){};

    public Cardiolog(String nume, int nrMaximPacientiZilnic) {
        super(nume, nrMaximPacientiZilnic);
    }

    @Override
    public String toString() {
        return "Cardiolog{" +
                "nume=" + getNume() +
                ", id=" + getId() +
                ", nrMaximPacientiZilnic=" + getNrMaximPacientiZilnic() +
                ", pacienti=" + getPacienti() +
                '}';
    }
}
