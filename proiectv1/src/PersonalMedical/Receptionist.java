package PersonalMedical;

import Pacienti.Copil;
import Pacienti.Pacient;

import javax.smartcardio.Card;
import java.util.Arrays;

public class Receptionist {
    private String nume;
    private int varsta;
    //receptionistul are o "agenda" cu medicii si programul lor, dar si programul laboratorului
    Medic[] listaMedici;
    Laborator laborator;
    private int nrMedici;

    public void setListaMedici(Medic[] listaMedici, int nrMedici){
        this.nrMedici = nrMedici;
        this.listaMedici = new Medic[nrMedici];
        for (int i=0; i<nrMedici; i++){
            this.listaMedici[i] = listaMedici[i];
        }
    }

    public boolean verificaInformatiiSuficiente(Pacient pacient){
        // copiii trebuie consultati mereu, indiferent de cate informatii se detin
        if (pacient instanceof Copil){
            return true;
        }
        // altfel, trebuie sa faca analize la laborator
        return pacient.isInformatiiSuficiente();
    }

    public int programeazaConsultatie(Pacient pacient){

        int ziProgramare = 1000000;
        int medic = -1;


        // daca este copil cautam medicul pediatru care il poate programa cel mai repede
        if (pacient instanceof Copil){
            for (int i=0; i<nrMedici; i++){
                if (listaMedici[i] instanceof Pediatru){
                    if (listaMedici[i].getNrPacienti()==0){
                        ziProgramare=0;
                        medic = listaMedici[i].getId();
                    }
                    else {
                        if (listaMedici[i].getNrPacienti() / listaMedici[i].getNrMaximPacientiZilnic() < ziProgramare) {
                            ziProgramare = listaMedici[i].getPacienti().size() / listaMedici[i].getNrMaximPacientiZilnic();
                            medic = listaMedici[i].getId();
                        }
                    }
                }
            }
        }
        else{
            if (pacient.isDurereMasea()){
                for (int i=0; i<nrMedici; i++){
                    if (listaMedici[i] instanceof Dentist){
                        if (listaMedici[i].getNrPacienti()==0){
                            ziProgramare=0;
                            medic = listaMedici[i].getId();
                        }
                        else {
                            if (listaMedici[i].getNrPacienti() / listaMedici[i].getNrMaximPacientiZilnic() < ziProgramare) {
                                ziProgramare = listaMedici[i].getPacienti().size() / listaMedici[i].getNrMaximPacientiZilnic();
                                medic = listaMedici[i].getId();
                            }
                        }
                    }
                }
            }
            else{
                if (pacient.isInflamareGat()){
                    for (int i=0; i<nrMedici; i++) {
                        if (listaMedici[i] instanceof Orl) {
                            if (listaMedici[i].getNrPacienti() == 0) {
                                ziProgramare = 0;
                                medic = listaMedici[i].getId();
                            } else {
                                if (listaMedici[i].getNrPacienti() / listaMedici[i].getNrMaximPacientiZilnic() < ziProgramare) {
                                    ziProgramare = listaMedici[i].getPacienti().size() / listaMedici[i].getNrMaximPacientiZilnic();
                                    medic = listaMedici[i].getId();
                                }
                            }
                        }
                    }
                }
                else{
                    if (pacient.isTensiuneAnormala()){
                        for (int i=0; i<nrMedici; i++){
                            if (listaMedici[i] instanceof Cardiolog){
                                if (listaMedici[i].getNrPacienti()==0){
                                    ziProgramare=0;
                                    medic = listaMedici[i].getId();
                                }
                                else {
                                    if (listaMedici[i].getNrPacienti() / listaMedici[i].getNrMaximPacientiZilnic() < ziProgramare) {
                                        ziProgramare = listaMedici[i].getPacienti().size() / listaMedici[i].getNrMaximPacientiZilnic();
                                        medic = listaMedici[i].getId();
                                    }
                                }
                            }
                        }
                    }
                    else{
                        if (pacient.isVedereNeclara()){
                            for (int i=0; i<nrMedici; i++){
                                if (listaMedici[i] instanceof Oftalmolog){
                                    if (listaMedici[i].getNrPacienti()==0){
                                        ziProgramare=0;
                                        medic = listaMedici[i].getId();
                                    }
                                    else {
                                        if (listaMedici[i].getNrPacienti() / listaMedici[i].getNrMaximPacientiZilnic() < ziProgramare) {
                                            ziProgramare = listaMedici[i].getPacienti().size() / listaMedici[i].getNrMaximPacientiZilnic();
                                            medic = listaMedici[i].getId();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i=0; i<nrMedici; i++){
            if (listaMedici[i].getId()==medic){
                listaMedici[i].adaugaPacient(pacient.getId());
                pacient.setIdMedic(medic);
            }
        }
        return ziProgramare;
    };

    public int programeazaAnalize(Pacient pacient){
        int ziProgramare = laborator.getNrPacienti()/laborator.getNrMaximPacientiZilnic();
        System.out.println(ziProgramare);
        pacient.setDataAnalize(ziProgramare);
        laborator.setNrPacienti(laborator.getNrPacienti()+1);
        laborator.getPacienti().add(pacient.getId());
        return 1;
    };

    public Receptionist(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                '}';
    }

    public void setNrMedici(int nrMedici) {
        this.nrMedici = nrMedici;
    }

    public void setLaborator(Laborator laborator) {
        this.laborator = laborator;
    }

    public Laborator getLaborator() {
        return laborator;
    }

}
