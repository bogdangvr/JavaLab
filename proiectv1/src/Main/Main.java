package Main;

import Pacienti.Adult;
import Pacienti.Copil;
import Pacienti.Pacient;
import Pacienti.Pensionar;
import PersonalMedical.*;
import Services.Reader;
import Services.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        Service MyService = new Service();

        Reader reader = Reader.getInstance();
        String[][] laboratorFile = reader.read("laborator.csv");
        Laborator laborator = new Laborator(Integer.parseInt(laboratorFile[0][0]), Integer.parseInt(laboratorFile[0][1]));

        //citirea personalului medical


        Medic[] listaMedici = new Medic[10];
        String[][] medicFile = reader.read("medic.csv");
        listaMedici[0] = new Pediatru(medicFile[0][0], Integer.parseInt(medicFile[0][1]));
        listaMedici[1] = new Pediatru(medicFile[1][0], Integer.parseInt(medicFile[1][1]));
        listaMedici[2] = new Dentist(medicFile[2][0], Integer.parseInt(medicFile[2][1]));
        listaMedici[3] = new Dentist(medicFile[3][0], Integer.parseInt(medicFile[3][1]));
        listaMedici[4] = new Oftalmolog(medicFile[4][0], Integer.parseInt(medicFile[4][1]));
        listaMedici[5] = new Oftalmolog(medicFile[5][0], Integer.parseInt(medicFile[5][1]));
        listaMedici[6] = new Orl(medicFile[6][0], Integer.parseInt(medicFile[6][1]));
        listaMedici[7] = new Orl(medicFile[7][0], Integer.parseInt(medicFile[7][1]));
        listaMedici[8] = new Cardiolog(medicFile[8][0], Integer.parseInt(medicFile[8][1]));
        listaMedici[9] = new Cardiolog(medicFile[9][0], Integer.parseInt(medicFile[9][1]));

        //un intermediar care de fapt face ce in realitate face un receptionist
        //daca un pacient are date suficiente, ii programeaza o consultatie,
        //altfel, ii programeaza o vizita la laborator pentru analize
        Receptionist receptionist = MyService.crearePoliclinica(listaMedici, 10, laborator);

        MyService.afisarePoliclinica(receptionist);

        //citirea listei de pacienti
        List<Pacient> listaPacienti = new ArrayList<Pacient>();
        int nrPacienti = 10;
        String[][] pacientFile = reader.read("pacient.csv");
        listaPacienti.add(new Adult(pacientFile[0][0], Integer.parseInt(pacientFile[0][1]), Integer.parseInt(pacientFile[0][2])));
        listaPacienti.add(new Adult(pacientFile[1][0], Integer.parseInt(pacientFile[1][1]), Integer.parseInt(pacientFile[1][2])));
        listaPacienti.add(new Adult(pacientFile[2][0], Integer.parseInt(pacientFile[2][1]), Integer.parseInt(pacientFile[2][2])));
        listaPacienti.add(new Adult(pacientFile[3][0], Integer.parseInt(pacientFile[3][1]), Integer.parseInt(pacientFile[3][2])));
        listaPacienti.add(new Adult(pacientFile[4][0], Integer.parseInt(pacientFile[4][1]), Integer.parseInt(pacientFile[4][2])));
        listaPacienti.add(new Pensionar(pacientFile[5][0], Integer.parseInt(pacientFile[5][1]), Integer.parseInt(pacientFile[5][2])));
        listaPacienti.add(new Copil(pacientFile[6][0], Integer.parseInt(pacientFile[6][1]), Integer.parseInt(pacientFile[6][2])));
        listaPacienti.add(new Copil(pacientFile[7][0], Integer.parseInt(pacientFile[7][1]), Integer.parseInt(pacientFile[7][2])));
        listaPacienti.add(new Pensionar(pacientFile[8][0], Integer.parseInt(pacientFile[8][1]), Integer.parseInt(pacientFile[8][2])));
        listaPacienti.add(new Adult(pacientFile[9][0], Integer.parseInt(pacientFile[9][1]), Integer.parseInt(pacientFile[9][2])));


        //programam toti pacientii
        MyService.programeaza(listaPacienti, nrPacienti, receptionist);

        //afisam toti pacientii inregitrati si programati, fie la laborator, fie la consultatie
        MyService.afisarePacienti(listaPacienti, 10);

        //simulam procesul de trecere a timpului: toti pacientii care trebuie sa viziteze laboratorul o vor face iar apoi
        //vor fi programati la o vizita la medic; fiecare pacient apoi este consultat si i se prescrie un tratament
        MyService.trecereaTimpului(listaPacienti, nrPacienti, receptionist, 0);

        //serviciu ce afiseaza costul tratamentului pentru un pacient
        MyService.afisareCostTratament(listaPacienti.get(0));

    }
}
