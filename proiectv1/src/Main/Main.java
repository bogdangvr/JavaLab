package Main;

import Pacienti.Adult;
import Pacienti.Copil;
import Pacienti.Pacient;
import Pacienti.Pensionar;
import PersonalMedical.*;
import Services.Service;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        Service MyService = new Service();

        //crearea personalului medical
        Laborator laborator = new Laborator(2, 30);
        Medic[] listaMedici = new Medic[10];
        listaMedici[0] = new Pediatru("Ped1", 2);
        listaMedici[1] = new Pediatru("Ped2", 3);
        listaMedici[2] = new Dentist("Den1", 6);
        listaMedici[3] = new Dentist("Den2", 4);
        listaMedici[4] = new Oftalmolog("Oft1", 8);
        listaMedici[5] = new Oftalmolog("Oft2", 5);
        listaMedici[6] = new Orl("Orl1", 10);
        listaMedici[7] = new Orl("Orl2", 8);
        listaMedici[8] = new Cardiolog("Card1", 2);
        listaMedici[9] = new Cardiolog("Card2", 2);

        //un intermediar care de fapt face ce in realitate face un receptionist
        //daca un pacient are date suficiente, ii programeaza o consultatie,
        //altfel, ii programeaza o vizita la laborator pentru analize
        Receptionist receptionist = MyService.CrearePoliclinica(listaMedici, 10, laborator);

        MyService.AfisarePoliclinica(receptionist);

        //crearea listei de pacienti
        List<Pacient> listaPacienti = new ArrayList<Pacient>();
        int nrPacienti = 10;
        listaPacienti.add(new Adult("Denisa", 21, 4));
        listaPacienti.add(new Adult("Vlad", 21, 4));
        listaPacienti.add(new Adult("Rares", 51, 2));
        listaPacienti.add(new Adult("Alex", 21, 4));
        listaPacienti.add(new Adult("Bianca", 20, 4));
        listaPacienti.add(new Pensionar("Ion", 71, 1));
        listaPacienti.add(new Copil("Ionut", 11, 3));
        listaPacienti.add(new Copil("Mihai", 7, 1));
        listaPacienti.add(new Pensionar("Ileana", 67, 1));
        listaPacienti.add(new Adult("Andrei", 31, 3));

        //programam toti pacientii
        MyService.Programeaza(listaPacienti, nrPacienti, receptionist);

        //afisam toti pacientii inregitrati si programati, fie la laborator, fie la consultatie
        MyService.AfisarePacienti(listaPacienti, 10);

        //simulam procesul de trecere a timpului: toti pacientii care trebuie sa viziteze laboratorul o vor face iar apoi
        //vor fi programati la o vizita la medic; fiecare pacient apoi este consultat si i se prescrie un tratament
        MyService.TrecereaTimpului(listaPacienti, nrPacienti, receptionist, 0);

        //serviciu ce afiseaza costul tratamentului pentru un pacient
        MyService.AfisareCostTratament(listaPacienti.get(0));

    }
}
