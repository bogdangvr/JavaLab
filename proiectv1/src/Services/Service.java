package Services;

import Pacienti.Pacient;
import PersonalMedical.Laborator;
import PersonalMedical.Medic;
import PersonalMedical.Receptionist;

import java.util.Collections;
import java.util.List;

public class Service {

    public Receptionist CrearePoliclinica(Medic[] listaMedici, int nrMedici, Laborator laborator){

        Receptionist receptionist = new Receptionist(listaMedici, nrMedici, laborator);
        return receptionist;

    }

    public void AfisarePoliclinica (Receptionist receptionist){

        System.out.println(receptionist);

    }

    public void AfisarePacienti (List<Pacient> listaPacienti, int nrPacienti){

        for (int i=0; i<nrPacienti; i++){
            System.out.println(listaPacienti.get(i));
        }

    }

    public void Programeaza(List<Pacient> listaPacienti, int nrPacienti, Receptionist receptionist){

        for (int i=0; i< nrPacienti; i++){

            listaPacienti.get(i).apel(receptionist);

        }

    }

    public void TrecereaTimpului(List<Pacient> listaPacienti, int nrPacienti, Receptionist receptionist, int ziCurenta){

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
    }

    public void AfisareCostTratament (Pacient pacient){

        System.out.println(pacient.getCostTratament());

    }

}
