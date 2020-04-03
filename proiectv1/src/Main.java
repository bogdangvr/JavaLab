import Pacienti.Adult;
import Pacienti.Copil;
import Pacienti.Pacient;
import Pacienti.Pensionar;
import PersonalMedical.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
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
        System.out.println(receptionist.toString());
        System.out.println("Numarul de medici: ");
        int nrMedici = scanner.nextInt();
        scanner.nextLine();
        Medic[] listaMedici = new Medic[nrMedici];
        for (int i=0; i<nrMedici; i++){
            System.out.println("Numarul de medici pediatri: ");
            int k = scanner.nextInt();
            scanner.nextLine();
            for (int j=0; j<k; j++){
                System.out.println("Introduceti numele medicului " + (i+j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i+j]=new Pediatru(nume,nrMaximPacienti);
            }
            i+=k;
            System.out.println("Numarul de medici dentisti: ");
             k = scanner.nextInt();
            scanner.nextLine();
            for (int j=0; j<k; j++){
                System.out.println("Introduceti numele medicului " + (i+j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume +  ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i+j]=new Dentist(nume,nrMaximPacienti);
            }
            i+=k;
            System.out.println("Numarul de medici cardiologi: ");
            k = scanner.nextInt();
            scanner.nextLine();
            for (int j=0; j<k; j++){
                System.out.println("Introduceti numele medicului " + (i+j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume  + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i+j]=new Cardiolog(nume,nrMaximPacienti);
            }
            i+=k;
            System.out.println("Numarul de medici din domeniul ORL: ");
            k = scanner.nextInt();
            scanner.nextLine();
            for (int j=0; j<k; j++){
                System.out.println("Introduceti numele medicului " + (i+j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume  + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i+j]=new Orl(nume,nrMaximPacienti);
            }
            i+=k;
            System.out.println("Numarul de medici oftalmologi: ");
            k = scanner.nextInt();
            scanner.nextLine();
            for (int j=0; j<k; j++){
                System.out.println("Introduceti numele medicului " + (i+j) + ": ");
                nume = scanner.nextLine();
                System.out.println("Introduceti numarul maxim de pacienti pentru dr. " + nume + ": ");
                int nrMaximPacienti = scanner.nextInt();
                scanner.nextLine();
                listaMedici[i+j]=new Oftalmolog(nume,nrMaximPacienti);
            }
            i+=k;
        }
        for (int i=0; i<nrMedici; i++){
            System.out.println(listaMedici[i]);
        }


        int nrPacienti;
        System.out.println("Se vor introduce acum datele pacientilor: ");
        System.out.println("Introduceti numarul de pacienti: ");
        nrPacienti = scanner.nextInt();
        scanner.nextLine();

        //alocam vectorul pentru toti pacientii:
        Pacient[] listaPacienti = new Pacient[nrPacienti];

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
                listaPacienti[i] = new Copil(nume,varsta,afectiune);
            }
            else {
                if (varsta > 65) {
                    listaPacienti[i] = new Pensionar(nume, varsta, afectiune);
                }
                else {
                    listaPacienti[i] = new Adult(nume, varsta, afectiune);
                }
            }
        }
        scanner.close();
        for (int i=0; i<nrPacienti; i++){
            System.out.println(listaPacienti[i]);
        }

        int nrPacientiTratati=0;

    }

}
