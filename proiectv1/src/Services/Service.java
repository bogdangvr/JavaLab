package Services;

import Pacienti.Pacient;
import PersonalMedical.Laborator;
import PersonalMedical.Medic;
import PersonalMedical.Receptionist;
import Utilities.Writer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Service {

    private static Writer writer = Writer.getInstance();

    public Receptionist crearePoliclinica(Medic[] listaMedici, int nrMedici, Laborator laborator) throws IOException {

        Receptionist receptionist = new Receptionist(listaMedici, nrMedici, laborator);
        writer.write("Apel de crearePoliclinica");
        return receptionist;

    }

    public void afisarePoliclinica (Receptionist receptionist) throws IOException {

        writer.write("Apel de afisarePoliclinica");
        System.out.println(receptionist);

    }

    public void afisarePacienti (List<Pacient> listaPacienti, int nrPacienti) throws IOException {

        for (int i=0; i<nrPacienti; i++){
            System.out.println(listaPacienti.get(i));
        }
        writer.write("Apel de afisarePoliclinica");
    }

    public void programeaza(List<Pacient> listaPacienti, int nrPacienti, Receptionist receptionist) throws IOException{

        for (int i=0; i< nrPacienti; i++){

            listaPacienti.get(i).apel(receptionist);

        }
        writer.write("Apel de programeaza");
    }

    public void trecereaTimpului(List<Pacient> listaPacienti, int nrPacienti, Receptionist receptionist, int ziCurenta) throws IOException{

        int nrPacientiTratati=0;

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
        writer.write("Apel de trecereaTimpului");
    }

    public void afisareCostTratament (Pacient pacient) throws IOException{

        System.out.println(pacient.getCostTratament());
        writer.write("Apel de afisareCostTratament");
    }



}
