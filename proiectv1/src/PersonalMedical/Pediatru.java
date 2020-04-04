package PersonalMedical;

import Pacienti.Copil;
import Pacienti.Pacient;

public class Pediatru extends Medic {
    double costTratament=40;

    public Pediatru(String nume, int nrMaximPacientiZilnic) {
        super(nume, nrMaximPacientiZilnic);
    }

    @Override
    public String toString() {
        return "Pediatru{" +
                "nume=" + getNume() +
                ", id=" + getId() +
                ", nrMaximPacientiZilnic=" + getNrMaximPacientiZilnic() +
                ", pacienti=" + getPacienti() +
                '}';
    }

    @Override
    public void consulta(Pacient pacient) {

        pacient.setInflamareGat(false);
        pacient.setDurereMasea(false);
        pacient.setTensiuneAnormala(false);
        pacient.setVedereNeclara(false);
        pacient.setTratat(true);
        pacient.setCostTratament(pacient.getCostTratament()+this.costTratament);

    }
}
