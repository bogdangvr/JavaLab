package PersonalMedical;

import Pacienti.Copil;
import Pacienti.Pacient;

public class Orl extends Medic {
    void consulta(){};
    void trateaza(){};
    double costTratament=20;

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

    @Override
    public void consulta(Pacient pacient) {
        pacient.setInflamareGat(false);
        pacient.setTratat(true);
        if (pacient.beneficiarReducere()){
            pacient.setCostTratament(pacient.getCostTratament()+this.costTratament*80/100);
        }
    }
}
