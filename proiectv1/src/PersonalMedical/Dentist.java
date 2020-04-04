package PersonalMedical;

import Pacienti.Copil;
import Pacienti.Pacient;

public class Dentist extends Medic {
    double costTratament=80;

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

    @Override
    public void consulta(Pacient pacient) {
        pacient.setDurereMasea(false);
        pacient.setTratat(true);
        if (pacient.beneficiarReducere()){
            pacient.setCostTratament(pacient.getCostTratament()+this.costTratament*90/100);
        }
    }
}
