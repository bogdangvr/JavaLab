package PersonalMedical;

import Pacienti.Copil;
import Pacienti.Pacient;

public class Cardiolog extends Medic {
    void consulta(){};
    void trateaza(){};
    double costTratament=60;

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

    @Override
    public void consulta(Pacient pacient) {
        pacient.setTensiuneAnormala(false);
        pacient.setTratat(true);
        if (pacient.beneficiarReducere()){
            pacient.setCostTratament(pacient.getCostTratament()+this.costTratament*50/100);
        }
    }
}
