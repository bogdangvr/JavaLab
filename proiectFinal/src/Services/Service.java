package Services;

import Pacienti.Adult;
import Pacienti.Copil;
import Pacienti.Pacient;
import Pacienti.Pensionar;
import PersonalMedical.Laborator;
import PersonalMedical.Medic;
import PersonalMedical.Receptionist;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

    private static Writer writer = Writer.getInstance();

    public Receptionist crearePoliclinica(Medic[] listaMedici, int nrMedici, Laborator laborator) throws IOException {

        Receptionist receptionist = new Receptionist(listaMedici, nrMedici, laborator);
        return receptionist;

    }

    public void afisarePoliclinica (Receptionist receptionist){
        System.out.println(receptionist);
    }

    public void afisarePacienti (List<Pacient> listaPacienti, int nrPacienti){

        for (int i=0; i<nrPacienti; i++){
            System.out.println(listaPacienti.get(i));
        }
    }

    public void adaugaPacient (List<Pacient> listaPacienti, int nrPacienti, Statement mySt, String nume, int varsta, int afectiune){
        try {
            nrPacienti++;
            if (varsta < 18) {
                Copil copil = new Copil(nume, varsta, afectiune);
                listaPacienti.add(copil);
            } else {
                if (varsta > 65) {
                    Pensionar pensionar = new Pensionar(nume, varsta, afectiune);
                    listaPacienti.add(pensionar);
                } else {
                    Adult adult = new Adult(nume, varsta, afectiune);
                    listaPacienti.add(adult);
                }
            }
            mySt.executeUpdate("INSERT INTO pacienti values(" + "'" +nume + "'" + "," + varsta + "," + afectiune + ")");
            Thread t = Thread.currentThread();
            writer.write("Apel de adaugaPacient", t.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void editeazaPacient (List<Pacient> listaPacienti, int nrPacienti, Statement mySt, String nume, int varsta, int afectiune, String numeNou, int varstaNoua, int afectiuneNoua){
        try {
            for (int i=0; i<nrPacienti; i++){
                if (listaPacienti.get(i).getNume().equals(nume) && listaPacienti.get(i).getVarsta() == varsta && listaPacienti.get(i).getAfectiune() == afectiune){
                    listaPacienti.get(i).setNume(numeNou);
                    listaPacienti.get(i).setVarsta(varstaNoua);
                    listaPacienti.get(i).resetAfectiune();
                    listaPacienti.get(i).setAfectiune(afectiuneNoua);
                }

            }
            mySt.executeUpdate("UPDATE pacienti SET nume = " + "'" + numeNou + "'" + ", varsta = " + varstaNoua + ", afectiune = " + afectiuneNoua +
                    " where nume = " + "'" + nume + "'" + " and varsta = " + varsta + " and afectiune = " + afectiune);
            Thread t = Thread.currentThread();
            writer.write("Apel de editeazaPacient", t.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public void stergePacient (List<Pacient> listaPacienti, int nrPacienti, Statement mySt, String nume, int varsta, int afectiune){
        try {
            for (int i=0; i<nrPacienti; i++){
                if (listaPacienti.get(i).getNume().equals(nume) && listaPacienti.get(i).getVarsta() == varsta && listaPacienti.get(i).getAfectiune() == afectiune){
                    listaPacienti.remove(i);
                    nrPacienti--;
                    break;
                }
            }
            mySt.executeUpdate("DELETE FROM pacienti where nume = " + "'" + nume + "'" + " and varsta = " + varsta + " and afectiune = " + afectiune);
            Thread t = Thread.currentThread();
            writer.write("Apel de stergePacient", t.getName());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void programeaza(List<Pacient> listaPacienti, int nrPacienti, Receptionist receptionist) throws IOException {

        Thread t = Thread.currentThread();
        writer.write("Apel de programeaza", t.getName());

        for (int i=0; i< nrPacienti; i++){

            listaPacienti.get(i).apel(receptionist);

        }
    }

    public List<Pacient> incarcaPacienti(Statement mySt, ResultSet myRs){
        try {
            List<Pacient> listaPacienti = new ArrayList<>();

            myRs = mySt.executeQuery("SELECT * FROM pacienti");
            while (myRs.next()) {
                int varsta = myRs.getInt("varsta");
                int afectiune = myRs.getInt("afectiune");
                String nume = myRs.getString("nume");
                if (varsta < 18) {
                    listaPacienti.add(new Copil(nume, varsta, afectiune));
                } else {
                    if (varsta > 65) {
                        listaPacienti.add(new Pensionar(nume, varsta, afectiune));
                    } else {
                        listaPacienti.add(new Adult(nume, varsta, afectiune));
                    }
                }
            }
            Thread t = Thread.currentThread();
            writer.write("Incarcarea pacientilor", t.getName());
            return listaPacienti;
        }
        catch (Exception e){
            e.printStackTrace();
            List<Pacient> listaPacienti = new ArrayList<>();
            return listaPacienti;
        }

    }

    public void trecereaTimpului(List<Pacient> listaPacienti, int nrPacienti, Receptionist receptionist, int ziCurenta) throws IOException{

        int nrPacientiTratati=0;

        Thread t = Thread.currentThread();
        writer.write("Apel de trecereaTimpului", t.getName());

        while (nrPacientiTratati<nrPacienti){
            //sortam pacientii dupa data vizitei la laborator apoi dupa data vizitei la medic:
            Collections.sort(listaPacienti);
            for (int i=0; i<nrPacienti; i++){
                Pacient curent = listaPacienti.get(i);
                //daca pacientul este tratat, nu il mai procesam
                if (!curent.isTratat()){
                    //daca ziua curenta este cea a programarii la analize
                    if (ziCurenta == curent.getDataAnalize()){
                        //atunci acesta face analize, iar aceasta informatie trebuie sa ajunga la receptionist
                        curent.faceAnalize(receptionist);
                        System.out.println("Pacientul " + curent + "a fost la laborator in ziua " + ziCurenta);
                    }
                    else{
                        //daca ziua curenta este cea a consultatiei
                        if (ziCurenta == curent.getDataConsultatie()) {
                            //cautam medicul la care este programat
                            for (int j = 0; j < receptionist.getNrMedici(); j++) {
                                if (receptionist.getListaMedici()[j].getId() == curent.getIdMedic()) {
                                    //pacientul este consultat de medic
                                    curent.mergeConsultatie(receptionist.getListaMedici()[j]);
                                    System.out.println("Pacientul " + curent + "a fost tratat in ziua " + ziCurenta + " de medicul " + receptionist.getListaMedici()[j]);
                                    nrPacientiTratati++;
                                    break;
                                }
                            }
                        }
                        else{
                            //exista un caz particular in care folosind formula anterioara de programare
                            //unii pacienti erau programati in trecut, iar acest mecanism trateaza acel caz
                            if (ziCurenta > curent.getDataConsultatie()){
                                curent.setDataConsultatie(ziCurenta+1);
                            }
                        }
                    }
                }
            }
            ziCurenta++;
        }
    }

    public String costTratament (List<Pacient> listaPacienti, int nrPacienti, String nume, int varsta, int afectiune) throws IOException {
        Thread t = Thread.currentThread();
        writer.write("Apel de costTratament", t.getName());

        for (int i=0; i<nrPacienti; i++){
            if (listaPacienti.get(i).getNume().equals(nume) && listaPacienti.get(i).getVarsta() == varsta && listaPacienti.get(i).getAfectiune() == afectiune){
                return String.valueOf(listaPacienti.get(i).getCostTratament());
            }

        }
        return "0";
    }
    public String dataProgramarii (List<Pacient> listaPacienti, int nrPacienti, String nume, int varsta, int afectiune) throws IOException {
        Thread t = Thread.currentThread();
        writer.write("Apel de dataProgramare", t.getName());

        for (int i=0; i<nrPacienti; i++){
            if (listaPacienti.get(i).getNume().equals(nume) && listaPacienti.get(i).getVarsta() == varsta && listaPacienti.get(i).getAfectiune() == afectiune){
                return String.valueOf(listaPacienti.get(i).getDataConsultatie());
            }

        }
        return "-1";
    }


}
