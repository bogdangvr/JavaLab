package PersonalMedical;

import Pacienti.Copil;
import Pacienti.Pacient;

public class Oftalmolog extends Medic {
    double costTratament=100;

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

    @Override
    public void consulta(Pacient pacient) {
        pacient.setVedereNeclara(false);
        pacient.setTratat(true);
        if (pacient.beneficiarReducere()){
            pacient.setCostTratament(pacient.getCostTratament()+this.costTratament*70/100);
        }
    }
}
