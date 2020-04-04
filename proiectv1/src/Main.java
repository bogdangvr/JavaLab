import Pacienti.Adult;
import Pacienti.Copil;
import Pacienti.Pacient;
import Pacienti.Pensionar;
import PersonalMedical.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //citirea datelor personalului medical

        Scanner scanner = new Scanner(System.in);
        String nume;
        int varsta;
        System.out.println("Se vor introduce intai datele personalului medical: ");
        System.out.println("Numele receptionistului: ");
        nume = scanner.nextLine();
        System.out.println("Varsta receptionistului: ");
        varsta = scanner.nextInt();
        scanner.nextLine();
        Receptionist receptionist = new Receptionist(nume, varsta);

        Laborator laborator = new Laborator();
        System.out.println("Introduceti numarul maxim de analize pe care le poate efectua laboratorul zilnic: ");
        laborator.setNrMaximPacientiZilnic(scanner.nextInt());
        scanner.nextLine();
        receptionist.setLaborator(laborator);

        System.out.println("Numarul de medici: ");
        int nrMedici = scanner.nextInt();
        scanner.nextLine();
        receptionist.setNrMedici(nrMedici);
        Medic[] listaMedici = new Medic[nrMedici];
        for (int i = 0; i < nrMedici; i++) {
            System.out.println("Numarul de medici pediatri: ");
            int k = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < k; j++) {
                System.out.println("Introduceti numele medicului " + (i + j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i + j] = new Pediatru(nume, nrMaximPacienti);
            }
            i += k;
            System.out.println("Numarul de medici dentisti: ");
            k = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < k; j++) {
                System.out.println("Introduceti numele medicului " + (i + j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i + j] = new Dentist(nume, nrMaximPacienti);
            }
            i += k;
            System.out.println("Numarul de medici cardiologi: ");
            k = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < k; j++) {
                System.out.println("Introduceti numele medicului " + (i + j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i + j] = new Cardiolog(nume, nrMaximPacienti);
            }
            i += k;
            System.out.println("Numarul de medici din domeniul ORL: ");
            k = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < k; j++) {
                System.out.println("Introduceti numele medicului " + (i + j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i + j] = new Orl(nume, nrMaximPacienti);
            }
            i += k;
            System.out.println("Numarul de medici oftalmologi: ");
            k = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < k; j++) {
                System.out.println("Introduceti numele medicului " + (i + j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i + j] = new Oftalmolog(nume, nrMaximPacienti);
            }
            i += k;
        }
        for (int i = 0; i < nrMedici; i++) {
            System.out.println(listaMedici[i]);
        }
        receptionist.setListaMedici(listaMedici, nrMedici);



        //citirea datelor pacientilor
        //cream o lista de pacienti
        List<Pacient> listaPacienti = new ArrayList<Pacient>();
        int nrPacienti;
        System.out.println("Se vor introduce acum datele pacientilor: ");
        System.out.println("Introduceti numarul de pacienti: ");
        nrPacienti = scanner.nextInt();
        scanner.nextLine();

        for (int i=0; i<nrPacienti; i++){

            System.out.println("Introduceti numele pacientului " + i + ": ");
            nume = scanner.nextLine();
            System.out.println("Introduceti varsta pacientului " + i + ": ");
            varsta = scanner.nextInt();
            System.out.println("Introduceti afectiunea pacientului " + i + ": ");
            System.out.println("1 pentru tensiune anormala;");
            System.out.println("2 pentru inflamare gat;");
            System.out.println("3 pentru durere masea;");
            System.out.println("4 pentru vedere neclara;");
            int afectiune = scanner.nextInt();
            scanner.nextLine();
            if (varsta < 18){
                Pacient aux = new Copil(nume,varsta,afectiune);
                listaPacienti.add(aux);
            }
            else {
                if (varsta > 65) {
                    Pacient aux = new Pensionar(nume, varsta, afectiune);
                    listaPacienti.add(aux);
                }
                else {
                    Pacient aux = new Adult(nume, varsta, afectiune);
                    listaPacienti.add(aux);
                }
            }
        }
        scanner.close();

        //toti pacientii apeleaza receptionistul pentru programare la laborator/medic
        for (int i=0; i<nrPacienti; i++){
            listaPacienti.get(i).apel(receptionist);
        }

        int nrPacientiTratati=0;
        int ziCurenta = 0;

        for (int i=0; i<nrPacienti; i++){
            System.out.println(listaPacienti.get(i));
        }

        while (nrPacientiTratati<nrPacienti){
            //sortam pacientii dupa data vizitei la laborator apoi dupa data vizitei la medic:
            Collections.sort(listaPacienti);
            for (int i=0; i<nrPacienti; i++){
                Pacient curent = listaPacienti.get(i);
                if (!curent.isTratat()){
                    if (ziCurenta == curent.getDataAnalize()){
                        curent.faceAnalize(receptionist);
                        System.out.println("Pacientul " + curent + "a fost la laborator in ziua " + ziCurenta);
                    }
                    else{
                        if (ziCurenta == curent.getDataConsultatie()) {
                            for (int j = 0; j < nrMedici; j++) {
                                if (listaMedici[j].getId() == curent.getIdMedic()) {
                                    curent.mergeConsultatie(listaMedici[j]);
                                    System.out.println("Pacientul " + curent + "a fost tratat in ziua " + ziCurenta + " de medicul " + listaMedici[j]);
                                    nrPacientiTratati++;
                                    break;
                                }
                            }
                        }
                        else{
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
}
