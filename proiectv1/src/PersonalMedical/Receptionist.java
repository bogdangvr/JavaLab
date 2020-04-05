package PersonalMedical;

import Pacienti.Copil;
import Pacienti.Pacient;

import java.util.Arrays;

public class Receptionist {
    //receptionistul are o "agenda" cu medicii si programul lor, dar si programul laboratorului
    Medic[] listaMedici;
    Laborator laborator;
    private int nrMedici;

    //constructor
    public Receptionist(Medic[] listaMedici, int nrMedici, Laborator laborator) {
        this.listaMedici = listaMedici;
        this.laborator = laborator;
        this.nrMedici = nrMedici;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "listaMedici=" + Arrays.toString(listaMedici) +
                ", laborator=" + laborator +
                ", nrMedici=" + nrMedici +
                '}';
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
                        if (listaMedici[i].getNrMaximPacientiZilnic()!=1) {
                            listaMedici[i].setNrPacientiUltimaZi(1);
                        }
                        else{
                            listaMedici[i].setZiDisponibila(listaMedici[i].getZiDisponibila()+1);
                        }
                        break;
                    }
                    else {
                        if (listaMedici[i].getZiDisponibila() < ziProgramare) {
                            ziProgramare = listaMedici[i].getZiDisponibila();
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
                            if (listaMedici[i].getNrMaximPacientiZilnic()!=1) {
                                listaMedici[i].setNrPacientiUltimaZi(1);
                            }
                            else{
                                listaMedici[i].setZiDisponibila(listaMedici[i].getZiDisponibila()+1);
                            }
                            break;
                        }
                        else {
                            if (listaMedici[i].getZiDisponibila() < ziProgramare) {
                                ziProgramare = listaMedici[i].getZiDisponibila();
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
                            if (listaMedici[i].getNrPacienti()==0){
                                ziProgramare=0;
                                medic = listaMedici[i].getId();
                                if (listaMedici[i].getNrMaximPacientiZilnic()!=1) {
                                    listaMedici[i].setNrPacientiUltimaZi(1);
                                }
                                else{
                                    listaMedici[i].setZiDisponibila(listaMedici[i].getZiDisponibila()+1);
                                }
                                break;
                            }
                            else {
                                if (listaMedici[i].getZiDisponibila() < ziProgramare) {
                                    ziProgramare = listaMedici[i].getZiDisponibila();
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
                                    if (listaMedici[i].getNrMaximPacientiZilnic()!=1) {
                                        listaMedici[i].setNrPacientiUltimaZi(1);
                                    }
                                    else{
                                        listaMedici[i].setZiDisponibila(listaMedici[i].getZiDisponibila()+1);
                                    }
                                    break;
                                }
                                else {
                                    if (listaMedici[i].getZiDisponibila() < ziProgramare) {
                                        ziProgramare = listaMedici[i].getZiDisponibila();
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
                                        if (listaMedici[i].getNrMaximPacientiZilnic()!=1) {
                                            listaMedici[i].setNrPacientiUltimaZi(1);
                                        }
                                        else{
                                            listaMedici[i].setZiDisponibila(listaMedici[i].getZiDisponibila()+1);
                                        }
                                        break;
                                    }
                                    else {
                                        if (listaMedici[i].getZiDisponibila() < ziProgramare) {
                                            ziProgramare = listaMedici[i].getZiDisponibila();
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
                if (listaMedici[i].getNrPacientiUltimaZi()+1==listaMedici[i].getNrMaximPacientiZilnic()+1){
                    listaMedici[i].setZiDisponibila(listaMedici[i].getZiDisponibila()+1);
                    listaMedici[i].setNrPacientiUltimaZi(1);
                }
                else{
                    listaMedici[i].setNrPacientiUltimaZi(listaMedici[i].getNrPacientiUltimaZi()+1);
                }
                pacient.setIdMedic(medic);
            }
        }
        return ziProgramare;
    }

    public int programeazaAnalize(Pacient pacient){
        int ziProgramare = laborator.getNrPacienti()/laborator.getNrMaximPacientiZilnic();
        pacient.setDataAnalize(ziProgramare);
        laborator.setNrPacienti(laborator.getNrPacienti()+1);
        laborator.getPacienti().add(pacient.getId());
        return ziProgramare;
    }

    //getters
    public Laborator getLaborator() {
        return laborator;
    }

    public Medic[] getListaMedici() {
        return listaMedici;
    }

    public int getNrMedici() {
        return nrMedici;
    }

    //setters
    public void setNrMedici(int nrMedici) {
        this.nrMedici = nrMedici;
    }

    public void setLaborator(Laborator laborator) {
        this.laborator = laborator;
    }


}
